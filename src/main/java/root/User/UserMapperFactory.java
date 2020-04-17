package root.User;

import root.User.StoreOwner.StoreOwnerMapper;

import static root.User.UserType.STORE_OWNER;

public class UserMapperFactory {

    static public UserMapper createMapper(UserType userType) {
        switch(userType)
        {
            case BUYER:
                break;
            case STORE_OWNER:
                return new StoreOwnerMapper();
            case ADMIN:
                break;
        }
        return null;
    }
}
