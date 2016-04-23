package myddl.entity;

public class UserInfo {
    private Long userId;

    private String nickname;

    public UserInfo() {
    }

    public UserInfo(String nickname) {
        this.nickname = nickname;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }
}