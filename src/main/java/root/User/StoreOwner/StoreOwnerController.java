package root.User.StoreOwner;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store_owner")
public class StoreOwnerController {

    @PostMapping("/register")
    public String register(@RequestBody StoreOwner storeOwner){
        StoreOwnerVerifier verifier = new StoreOwnerVerifier();
        String status = "";
        try{
            status = verifier.verify(storeOwner);
            if(status.equals("OK")){
                StoreOwnerMapper.insert(storeOwner);
            }
        }catch (Exception e){
            e.printStackTrace();
            status = "Error: Unhandled Exception";
        }
        return status;
    }
}
