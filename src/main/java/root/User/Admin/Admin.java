package root.User.Admin;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import root.User.UserInfo;
import root.User.UserType;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Admin {
    @JsonUnwrapped
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

    @JsonProperty
    public UserType getType() {
        return UserType.ADMIN;
    }
}
