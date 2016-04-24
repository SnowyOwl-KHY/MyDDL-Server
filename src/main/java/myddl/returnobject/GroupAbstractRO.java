package myddl.returnobject;

import myddl.entity.Group;

public class GroupAbstractRO {
    private Long groupId;
    private String groupName;
    private String groupImage;

    public GroupAbstractRO(Group group) {
        groupId = group.getGroupId();
        groupName = group.getGroupName();
        groupImage = group.getGroupImage();
    }

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
        this.groupName = groupName;
    }

    public String getGroupImage() {
        return groupImage;
    }

    public void setGroupImage(String groupImage) {
        this.groupImage = groupImage;
    }
}
