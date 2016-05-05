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
        return new UserRO(userInfo, deadlines, groups, courseProjects);
    }

    @Override
    public void modifyUser(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public int addUser(UserInfo userInfo) {
        return userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void deleteUser(Long userId) {
        userInfoMapper.deleteByPrimaryKey(userId);
    }
}
