package root.Security.Filters;


import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import root.Security.JwtUtil;
import root.Security.UserCredentials;
import root.User.UserType;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AdminEndPointFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        String jwtToken = null;
        JwtUtil jwtUtil = new JwtUtil();
        if (authHeader != null && authHeader.startsWith("Bearer "))
        {
            jwtToken = authHeader.substring(7);
            System.out.println(jwtToken);
        }
        if (!jwtUtil.extractUserType(jwtToken).equals("ADMIN"))
            throw new ServletException("Access Denied");
        filterChain.doFilter(request, response);
    }

    @Bean
    public FilterRegistrationBean<AdminEndPointFilter> AdminEndPointFilterBean() {
        FilterRegistrationBean<AdminEndPointFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AdminEndPointFilter());
        registrationBean.addUrlPatterns("/admin/listAll");
        return registrationBean;
    }
}
