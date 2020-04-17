package root.User.Admin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.User.Buyer.BuyerMapper;
import root.User.StoreOwner.StoreOwnerMapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/listAll")
    public List<Object> getAll() {
        List<Object> list = new ArrayList<>();
        try {
            list.addAll(StoreOwnerMapper.selectAll());
            list.addAll(BuyerMapper.selectAll());
            list.addAll(AdminMapper.selectAll());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

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
