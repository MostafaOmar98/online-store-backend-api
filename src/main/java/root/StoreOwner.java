package root;

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

    public UserInfo getUserInfo(){
        return this.userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
