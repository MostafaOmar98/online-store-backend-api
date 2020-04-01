package root;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @PostMapping("/register")
    public String register(@RequestBody Buyer buyer) {
        BuyerVerifier verifier = new BuyerVerifier();
        String status = "";
        try{
            status = verifier.verify(buyer);
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
