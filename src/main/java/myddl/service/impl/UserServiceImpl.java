package myddl.service.impl;

import myddl.dao.*;
import myddl.entity.*;
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
    UserPasswordMapper userPasswordMapper;
    @Resource
    CourseProjectMapper courseProjectMapper;
    @Resource
    DeadlineMapper deadlineMapper;
    @Resource
    GroupMapper groupMapper;

    @Override
    public Long login(String username, String password) {
        UserPassword userPassword = userPasswordMapper.selectByUsername(username);
        if (userPassword != null) {
            return userPassword.getUserId();
        } else {
            return null;
        }
    }

    @Override
    public UserRO getUser(Long userId) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        if (userInfo == null) return null;

        List<Deadline> deadlines = deadlineMapper.selectByUserId(userId);
        List<Group> groups = groupMapper.selectByUserId(userId);
        List<CourseProject> courseProjects = courseProjectMapper.selectByUserId(userId);
        return new UserRO(userInfo, deadlines, groups, courseProjects, courseProjectMapper);
    }

    @Override
    public void modifyUser(UserPassword userPassword, UserInfo userInfo) {
        userPasswordMapper.updateByPrimaryKeySelective(userPassword);
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public long addUser(UserPassword userPassword, UserInfo userInfo) {
        long userId = userPasswordMapper.insertSelective(userPassword);
        userInfo.setUserId(userId);
        userInfoMapper.insertSelective(userInfo);
        return userId;
    }

    @Override
    public void deleteUser(Long userId) {
        userPasswordMapper.deleteByPrimaryKey(userId);
        userInfoMapper.deleteByPrimaryKey(userId);
    }
}
