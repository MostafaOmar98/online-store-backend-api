package root;

public class StoreOwner {
    private UserInfo _userInfo;
    private String _socialID;

    StoreOwner(String username, String email, String password, String name, String socialID){
        _userInfo = new UserInfo();
        _userInfo.username = username;
        _userInfo.email = email;
        _userInfo.password = password;
        _userInfo.name = name;

        _socialID = socialID;
    }

    StoreOwner(int id, String username, String email, String password, String name, String socialID){
        _userInfo = new UserInfo();
        _userInfo.id = id;
        _userInfo.username = username;
        _userInfo.email = email;
        _userInfo.password = password;
        _userInfo.name = name;

        _socialID = socialID;
    }

    StoreOwner(UserInfo userInfo, String _socialID){
        _userInfo = userInfo;
        _socialID = _socialID;
    }

}
