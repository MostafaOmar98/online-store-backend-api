package root;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/register")
    public String register(@RequestBody Admin admin){
        AdminVerifier verifier = new AdminVerifier();
        String status = "";
        try{
            status = verifier.verify(admin);
            if(status.equals("OK")){
                AdminMapper.insert(admin);
            }
        }catch (Exception e){
            e.printStackTrace();
            status = "Error: Unhandled Exception";
        }
        return status;
    }
}
