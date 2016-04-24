package myddl.returnobject;

import java.util.List;

public class UserRO {
    private Long userId;
    private String userName;
    private String userImage;
    private String userPhone;
    private String userEmail;
    private Integer mainScreenImage;
    private List<DeadlineAbstractRO> deadlines;
    private List<GroupAbstractRO> groups;
    private List<CourseProjectAbstractRO> courseProjects;

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

    public List<DeadlineAbstractRO> getDeadlines() {
        return deadlines;
    }

    public void setDeadlines(List<DeadlineAbstractRO> deadlines) {
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
