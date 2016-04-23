package myddl.service.impl;

import myddl.dao.UserCourseMapper;
import myddl.dao.UserInfoMapper;
import myddl.dao.UserProjectMapper;
import myddl.entity.UserCourse;
import myddl.entity.UserInfo;
import myddl.entity.UserProject;
import myddl.returnobject.UserRO;
import myddl.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    UserInfoMapper userInfoMapper;

    @Resource
    UserCourseMapper userCourseMapper;

    @Resource
    UserProjectMapper userProjectMapper;

    @Override
    public UserRO getUser(long userId) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        List<UserCourse> userCourseList = userCourseMapper.selectByUserId(userId);
        List<UserProject> userProjectList = userProjectMapper.selectByUserId(userId);
        return new UserRO(userInfo, userCourseList, userProjectList);
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void deleteUser(long userId) {
        userInfoMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public void updateUserCourse(UserCourse userCourse) {
        userCourseMapper.updateByPrimaryKeySelective(userCourse);
    }

    @Override
    public void addUserCourse(UserCourse userCourse) {
        userCourseMapper.insertSelective(userCourse);
    }

    @Override
    public void deleteUserCourse(long userCourseId) {
        userCourseMapper.deleteByPrimaryKey(userCourseId);
    }

    @Override
    public void updateUserProject(UserProject userProject) {
        userProjectMapper.updateByPrimaryKeySelective(userProject);
    }

    @Override
    public void addUserProject(UserProject userProject) {
        userProjectMapper.insertSelective(userProject);
    }

    @Override
    public void deleteUserProject(long userProjectId) {
        userProjectMapper.deleteByPrimaryKey(userProjectId);
    }
}
