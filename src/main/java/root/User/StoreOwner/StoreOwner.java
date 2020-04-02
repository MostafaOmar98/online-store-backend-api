package root.User.StoreOwner;

import com.fasterxml.jackson.annotation.JsonIgnore;
import root.User.UserInfo;
import root.User.UserType;

public class StoreOwner {
    private UserInfo userInfo;
    private String socialID;

    StoreOwner(){ // for deserialization
        userInfo = new UserInfo();
    }

    StoreOwner(String username, String email, String password, String name, String socialID){
        this.userInfo = new UserInfo(username, email, password, name);
        this.socialID = socialID;
    }

    StoreOwner(int id, String username, String email, String password, String name, String socialID){
        this.userInfo = new UserInfo(id, username, email, password, name);
        this.socialID = socialID;
    }

    StoreOwner(UserInfo userInfo, String socialID){
        this.userInfo = userInfo;
        this.socialID = socialID;
    }

    public String getSocialID(){
        return this.socialID;
    }

    public void setSocialID(String socialID){
        this.socialID = socialID;
    }

    @JsonIgnore
    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getUsername() {
        return userInfo.getUsername();
    }

    public String getPassword() {
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
        return UserType.STORE_OWNER;
    }

}
