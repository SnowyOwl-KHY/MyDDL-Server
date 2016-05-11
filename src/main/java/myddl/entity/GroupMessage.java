package myddl.entity;

public class GroupMessage {
    private Long groupMessageId;

    private String content;

    private String time;

    private Long groupId;

    public GroupMessage() {
    }

    public GroupMessage(Long groupMessageId, String content, String time, Long groupId) {
        this.groupMessageId = groupMessageId;
        this.content = content;
        this.time = time;
        this.groupId = groupId;
    }

    public Long getGroupMessageId() {
        return groupMessageId;
    }

    public void setGroupMessageId(Long groupMessageId) {
        this.groupMessageId = groupMessageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}