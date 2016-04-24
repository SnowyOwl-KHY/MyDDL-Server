package myddl.entity;

public class UserInfo {
    private Long userId;

    private String userName;

    private String userImage;

    private String userPhone;

    private String userEmail;

    private Integer mainScreenImage;

    public UserInfo() {
    }

    public UserInfo(Long userId, String userName, String userImage, String userPhone, String userEmail, Integer mainScreenImage) {
        this.userId = userId;
        this.userName = userName;
        this.userImage = userImage;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.mainScreenImage = mainScreenImage;
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
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage == null ? null : userImage.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Integer getMainScreenImage() {
        return mainScreenImage;
    }

    public void setMainScreenImage(Integer mainScreenImage) {
        this.mainScreenImage = mainScreenImage;
    }
}