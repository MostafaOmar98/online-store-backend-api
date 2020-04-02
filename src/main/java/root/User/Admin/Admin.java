package root.User.Admin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import root.User.UserInfo;
import root.User.UserType;

public class Admin {
    private UserInfo userInfo;
    private String key;

    Admin(){this.userInfo = new UserInfo();}

    Admin(String username, String email, String password, String name, String key){
        this.userInfo = new UserInfo(username, email, password, name);
        this.key = key;
    }

    Admin(int id, String username, String email, String password, String name, String key){
        this.userInfo = new UserInfo(id, username, email, password, name);
        this.key = key;
    }

    Admin(UserInfo userInfo, String key) {
        this.userInfo = userInfo;
        this.key = key;
    }

    @JsonIgnore
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUsername(){
        return userInfo.getUsername();
    }

    public String getPassword(){
        return userInfo.getPassword();
    }

    public String getEmail() {
        return userInfo.getEmail();
    }

    public String getName() {
        return userInfo.getName();
    }

    public int getId() {
        return userInfo.getId();
    }

    public UserType getType() {
        return UserType.ADMIN;
    }
}
