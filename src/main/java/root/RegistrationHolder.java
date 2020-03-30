package root;

public class RegistrationHolder {
    private UserInfo userInfo;
    private String socialID;
    private UserType userType;

    RegistrationHolder(){
        userInfo = new UserInfo();
    }

    public RegistrationHolder(UserInfo userInfo, String socialID, UserType userType) {
        this.userInfo = userInfo;
        this.socialID = socialID;
        this.userType = userType;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getSocialID() {
        return socialID;
    }

    public void setSocialID(String socialID) {
        this.socialID = socialID;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
