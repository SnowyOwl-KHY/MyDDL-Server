package myddl.entity;

public class PushDeadline {
    private Long pushDeadlineId;

    private Long userId;

    private Long deadlineId;

    public Long getPushDeadlineId() {
        return pushDeadlineId;
    }

    public void setPushDeadlineId(Long pushDeadlineId) {
        this.pushDeadlineId = pushDeadlineId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeadlineId() {
        return deadlineId;
    }

    public void setDeadlineId(Long deadlineId) {
        this.deadlineId = deadlineId;
    }
}