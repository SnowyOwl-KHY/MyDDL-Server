package myddl.returnobject;

import myddl.entity.UserInfo;

public class UserAbstractRO {
    private Long userId;
    private String userName;
    private String userImage;

    public UserAbstractRO(UserInfo userInfo) {
        userId = userInfo.getUserId();
        userName = userInfo.getUserName();
        userImage = userInfo.getUserImage();
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
}
