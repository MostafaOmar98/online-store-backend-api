package root.User.Buyer;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @PostMapping("/register")
    public String register(@RequestBody Buyer buyer) {
        BuyerVerifier verifier = new BuyerVerifier();
        String status = "";
        try{
            status = verifier.verify(buyer);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            buyer.setPassword(encoder.encode(buyer.getPassword()));
            if(status.equals("OK")){
                BuyerMapper.insert(buyer);
            }
        }catch (Exception e){
            e.printStackTrace();
            status = "Error: Unhandled Exception";
        }
        return status;
    }

}
