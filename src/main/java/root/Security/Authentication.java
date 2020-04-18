package root.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import root.User.UserMapper;
import root.User.UserMapperFactory;
import root.User.UserType;

import java.sql.SQLException;

@RestController
public class Authentication {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody UserCredentials userCredentials) throws SQLException {
        UserMapper mapper = UserMapperFactory.createMapper(userCredentials.getUserType());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userCredentials.setPassword(encoder.encode(userCredentials.getPassword()));
        if (!mapper.userExists(userCredentials.getUsername(), userCredentials.getPassword()))
            return "ERROR: User Not Found";

        return jwtUtil.generateToken(userCredentials);
    }
}
