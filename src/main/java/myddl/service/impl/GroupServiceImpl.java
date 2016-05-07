package myddl.service.impl;

import myddl.dao.DeadlineMapper;
import myddl.dao.GroupMapper;
import myddl.dao.UserInfoMapper;
import myddl.entity.Deadline;
import myddl.entity.Group;
import myddl.entity.UserInfo;
import myddl.returnobject.GroupRO;
import myddl.service.GroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("groupService")
public class GroupServiceImpl implements GroupService {

    @Resource
    GroupMapper groupMapper;
    @Resource
    UserInfoMapper userInfoMapper;
    @Resource
    DeadlineMapper deadlineMapper;

    @Override
    public GroupRO getGroup(Long groupId) {
        Group group = groupMapper.selectByPrimaryKey(groupId);
        if (group == null) return null;

        List<UserInfo> users = userInfoMapper.selectByGroupId(groupId);
        List<Deadline> deadlines = deadlineMapper.selectByGroupId(groupId);
        return new GroupRO(group, users, deadlines);
    }

    @Override
    public void modifyGroup(Group group) {
        groupMapper.updateByPrimaryKeySelective(group);
    }

    @Override
    public Long addGroup(Group group) {
        long groupId = groupMapper.insertSelective(group);
        return groupId;
    }

    @Override
    public void deleteGroup(Long groupId) {
        // TODO: delete group deadline(copy duplicate to all user)
        groupMapper.deleteByPrimaryKey(groupId);
        groupMapper.deleteUserGroupByGroupId(groupId);
    }

    @Override
    public void addGroupUser(Long groupId, Long userId) {
        groupMapper.insertGroupUser(groupId, userId);
    }
}
