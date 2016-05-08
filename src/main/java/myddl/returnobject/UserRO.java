package myddl.returnobject;

import myddl.dao.CourseProjectMapper;
import myddl.entity.CourseProject;
import myddl.entity.Deadline;
import myddl.entity.Group;
import myddl.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class UserRO {
    private Long userId;
    private String userName;
    private String userImage;
    private String userPhone;
    private String userEmail;
    private Integer mainScreenImage;
    private List<DeadlineRO> deadlines = new ArrayList<>();
    private List<GroupAbstractRO> groups = new ArrayList<>();
    private List<CourseProjectAbstractRO> courseProjects = new ArrayList<>();

    public UserRO(UserInfo userInfo, List<Deadline> deadlines, List<Group> groups, List<CourseProject> courseProjects, CourseProjectMapper courseProjectMapper) {
        userId = userInfo.getUserId();
        userName = userInfo.getUserName();
        userImage = userInfo.getUserImage();
        userPhone = userInfo.getUserPhone();
        userEmail = userInfo.getUserEmail();
        mainScreenImage = userInfo.getMainScreenImage();

        for (Deadline deadline : deadlines) {
            DeadlineRO deadlineRO = new DeadlineRO(deadline, courseProjectMapper);
            this.deadlines.add(deadlineRO);
        }

        for (Group group : groups) {
            GroupAbstractRO groupAbstractRO = new GroupAbstractRO(group);
            this.groups.add(groupAbstractRO);
        }

        for (CourseProject courseProject : courseProjects) {
            CourseProjectAbstractRO courseProjectAbstractRO = new CourseProjectAbstractRO(courseProject);
            this.courseProjects.add(courseProjectAbstractRO);
        }
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

    public Integer getMainScreenImage() {
        return mainScreenImage;
    }

    public void setMainScreenImage(Integer mainScreenImage) {
        this.mainScreenImage = mainScreenImage;
    }

    public List<DeadlineRO> getDeadlines() {
        return deadlines;
    }

    public void setDeadlines(List<DeadlineRO> deadlines) {
        this.deadlines = deadlines;
    }

    public List<GroupAbstractRO> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupAbstractRO> groups) {
        this.groups = groups;
    }

    public List<CourseProjectAbstractRO> getCourseProjects() {
        return courseProjects;
    }

    public void setCourseProjects(List<CourseProjectAbstractRO> courseProjects) {
        this.courseProjects = courseProjects;
    }
}
