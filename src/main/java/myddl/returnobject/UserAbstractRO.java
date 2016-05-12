package myddl.returnobject;

import myddl.entity.UserInfo;

public class UserAbstractRO {
    private Long userId;
    private String userName;
    private String userImage;
    private String userPhone;
    private String userEmail;

    public UserAbstractRO(UserInfo userInfo) {
        userId = userInfo.getUserId();
        userName = userInfo.getUserName();
        userImage = userInfo.getUserImage();
        userPhone = userInfo.getUserPhone();
        userEmail = userInfo.getUserEmail();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
