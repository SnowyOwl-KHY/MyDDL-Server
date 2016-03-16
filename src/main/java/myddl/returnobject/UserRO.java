package myddl.returnobject;

import myddl.entity.UserCourse;
import myddl.entity.UserInfo;
import myddl.entity.UserProject;

import java.util.List;

public class UserRO {
    private UserInfo userInfo;

    private List<UserCourse> userCourseList;

    private List<UserProject> userProjectList;

    public UserRO(UserInfo userInfo, List<UserCourse> userCourseList, List<UserProject> userProjectList) {
        this.userInfo = userInfo;
        this.userCourseList = userCourseList;
        this.userProjectList = userProjectList;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<UserCourse> getUserCourseList() {
        return userCourseList;
    }

    public void setUserCourseList(List<UserCourse> userCourseList) {
        this.userCourseList = userCourseList;
    }

    public List<UserProject> getUserProjectList() {
        return userProjectList;
    }

    public void setUserProjectList(List<UserProject> userProjectList) {
        this.userProjectList = userProjectList;
    }
}
