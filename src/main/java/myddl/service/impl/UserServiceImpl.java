package myddl.service.impl;

import myddl.dao.CourseProjectMapper;
import myddl.dao.DeadlineMapper;
import myddl.dao.GroupMapper;
import myddl.dao.UserInfoMapper;
import myddl.entity.CourseProject;
import myddl.entity.Deadline;
import myddl.entity.Group;
import myddl.entity.UserInfo;
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
    CourseProjectMapper courseProjectMapper;
    @Resource
    DeadlineMapper deadlineMapper;
    @Resource
    GroupMapper groupMapper;

    @Override
    public UserRO getUser(Long userId) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        List<Deadline> deadlines = deadlineMapper.selectByUserId(userId);
        List<Group> groups = groupMapper.selectByUserId(userId);
        List<CourseProject> courseProjects = courseProjectMapper.selectByUserId(userId);
        return new UserRO(userInfo, deadlines, groups, courseProjects, courseProjectMapper);
    }
}
