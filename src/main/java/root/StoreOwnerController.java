package root;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store_owner")
public class StoreOwnerController {

    @PostMapping("/register")
    public String register(@RequestBody StoreOwner storeOwner) {
        StoreOwnerVerifier verifier = new StoreOwnerVerifier();
        String status = verifier.verify(storeOwner);
        if(status.equals("OK")){
            try{
                StoreOwnerMapper.insert(storeOwner);
            }catch (Exception e){e.printStackTrace();}
        }
        return status;
    }


}
