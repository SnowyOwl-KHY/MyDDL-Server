package myddl.service;

import myddl.returnobject.UserRO;

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
