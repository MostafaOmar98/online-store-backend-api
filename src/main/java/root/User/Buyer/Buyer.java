package root.User.Buyer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import root.User.UserInfo;
import root.User.UserType;

public class Buyer {
    @JsonUnwrapped
    private UserInfo userInfo;
    private String address;

    Buyer() { // for deserialization
        userInfo = new UserInfo();
    }

    Buyer(String username, String email, String password, String name, String address){
        this.userInfo = new UserInfo(username, email, password, name);
        this.address = address;
    }

    Buyer(int id, String username, String email, String password, String name, String address){
        this.userInfo = new UserInfo(id, username, email, password, name);
        this.address = address;
    }

    Buyer(UserInfo userInfo, String address) {
        this.userInfo = userInfo;
        this.address = address;
    }

    @JsonIgnore
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return UserType.BUYER;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "userInfo=" + userInfo +
                ", address='" + address + '\'' +
                '}';
    }
}
