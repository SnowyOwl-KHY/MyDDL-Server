package myddl.service;

import myddl.entity.UserCourse;
import myddl.entity.UserInfo;
import myddl.entity.UserProject;
import myddl.returnobject.UserRO;

import java.util.List;

public interface UserService {

    UserRO getUser(long userId);

    void addUser(UserInfo userInfo);

    void updateUserInfo(UserInfo userInfo);

    void deleteUser(long userId);

    void updateUserCourse(UserCourse userCourse);

    void addUserCourse(UserCourse userCourse);

    void deleteUserCourse(long userCourseId);

    void updateUserProject(UserProject userProject);

    void addUserProject(UserProject userProject);

    void deleteUserProject(long userProjectId);


}
