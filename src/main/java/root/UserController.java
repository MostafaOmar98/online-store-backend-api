package root;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping("/register")
    public void register(@RequestBody RegistrationHolder holder){
        if(holder.getUserType() == UserType.STORE_OWNER){
            UserBehavior userRegister = new BuyerBehavior();
            userRegister.register(holder);
        }
    }

    @GetMapping("/holder")
    public RegistrationHolder getHolder(){ // utility function to help with testing
        UserInfo userInfo = new UserInfo(1, "ahmad", "www@qqq", "password", "Ahmad");
        return new RegistrationHolder(userInfo, "social_id", UserType.STORE_OWNER);
    }
}
