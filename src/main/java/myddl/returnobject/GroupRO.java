package myddl.returnobject;

import myddl.entity.Deadline;
import myddl.entity.Group;
import myddl.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class GroupRO {

    private Long groupId;
    private String groupName;
    private String groupImage;
    private List<UserAbstractRO> users = new ArrayList<>();
    private List<DeadlineAbstractRO> deadlines = new ArrayList<>();

    public GroupRO(Group group, List<UserInfo> userInfos, List<Deadline> deadlines) {
        groupId = group.getGroupId();
        groupName = group.getGroupName();
        groupImage = group.getGroupImage();

        for (UserInfo userInfo : userInfos) {
            UserAbstractRO userAbstractRO = new UserAbstractRO(userInfo);
            users.add(userAbstractRO);
        }

        for (Deadline deadline : deadlines) {
            DeadlineAbstractRO deadlineAbstractRO = new DeadlineAbstractRO(deadline);
            this.deadlines.add(deadlineAbstractRO);
        }
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

    public List<UserAbstractRO> getUsers() {
        return users;
    }

    public void setUsers(List<UserAbstractRO> users) {
        this.users = users;
    }

    public List<DeadlineAbstractRO> getDeadlines() {
        return deadlines;
    }

    public void setDeadlines(List<DeadlineAbstractRO> deadlines) {
        this.deadlines = deadlines;
    }
}
