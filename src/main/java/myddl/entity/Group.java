package myddl.entity;

public class Group {
    private Long groupId;

    private String groupName;

    private String groupImage;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getGroupImage() {
        return groupImage;
    }

    public void setGroupImage(String groupImage) {
        this.groupImage = groupImage == null ? null : groupImage.trim();
    }
}