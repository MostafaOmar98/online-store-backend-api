package root.User;

import root.User.Admin.AdminMapper;
import root.User.StoreOwner.StoreOwnerMapper;

public class UserMapperFactory {

    static public UserMapper createMapper(UserType userType) {
        switch(userType)
        {
            case BUYER:
                break;
            case STORE_OWNER:
                return new StoreOwnerMapper();
            case ADMIN:
                return new AdminMapper();
        }
        return null;
    }
}
