package root.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.User.Buyer.Buyer;
import root.User.Buyer.BuyerMapper;
import root.User.StoreOwner.StoreOwnerMapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/users")
    public List<Object> getAll() {
        List<Object> list = new ArrayList<>();
        try {
            list.addAll(StoreOwnerMapper.selectAll());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
