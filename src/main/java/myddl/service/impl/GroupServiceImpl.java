package myddl.service.impl;

import myddl.dao.DeadlineMapper;
import myddl.dao.GroupMapper;
import myddl.dao.PushDeadlineMapper;
import myddl.dao.UserInfoMapper;
import myddl.entity.Deadline;
import myddl.entity.Group;
import myddl.entity.PushDeadline;
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
    @Resource
    PushDeadlineMapper pushDeadlineMapper;

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
        // delete relationship between group and deadline(copy duplicate to all user)
        List<Deadline> groupDeadlines = deadlineMapper.selectByGroupId(groupId);
        List<UserInfo> groupUsers = userInfoMapper.selectByGroupId(groupId);
        for (Deadline deadline : groupDeadlines) {
            // copy duplicate to all user
            for (UserInfo userInfo : groupUsers) {
                Deadline duplicate = deadline.duplicate();
                long duplicateId = deadlineMapper.insertSelective(duplicate);
                deadlineMapper.insertUserDeadline(userInfo.getUserId(), duplicateId);
            }

            // delete group deadline
            groupMapper.deleteGroupDeadlineByDeadlineId(deadline.getDeadlineId());
            deadlineMapper.deleteByPrimaryKey(deadline.getDeadlineId());
        }

        groupMapper.deleteByPrimaryKey(groupId);
        // delete relationship between group and user
        groupMapper.deleteUserGroupByGroupId(groupId);
    }

    @Override
    public void addGroupUser(Long groupId, Long userId) {
        groupMapper.insertGroupUser(groupId, userId);

        // push the group deadline to this new user
        List<Deadline> groupDeadlines = deadlineMapper.selectByGroupId(groupId);
        for (Deadline deadline : groupDeadlines) {
            pushDeadlineMapper.insertSelective(new PushDeadline(null, userId, deadline.getDeadlineId()));
        }
    }

    /**
     * Delete group user and copy a duplicate of group deadline to this user. (if the user has anyone.)
     * @param groupId
     * @param userId
     */
    @Override
    public void deleteGroupUser(Long groupId, Long userId) {
        groupMapper.deleteUserGroupByUserIdAndGroupId(userId, groupId);

        // delete relationship between group deadline and user, then copy that deadline(if the user has anyone).
        List<Deadline> groupDeadlines = deadlineMapper.selectByGroupId(groupId);
        for (Deadline deadline : groupDeadlines) {
            Long userDeadlineId = deadlineMapper.selectPrimaryKeyByUserIdAndDeadlineId(userId, deadline.getDeadlineId());
            if (userDeadlineId != null) {
                deadlineMapper.deleteUserDeadlineByPrimaryKey(userDeadlineId);

                Deadline duplicate = deadline.duplicate();
                long duplicateId = deadlineMapper.insertSelective(duplicate);
                deadlineMapper.insertUserDeadline(userId, duplicateId);
            }
        }
    }

    /**
     * Add the deadline to the push deadline list of all user
     * @param groupId
     * @param deadlineId
     */
    @Override
    public void addGroupDeadline(Long groupId, Long deadlineId) {
        groupMapper.insertGroupDeadline(groupId, deadlineId);
        List<UserInfo> groupUsers = userInfoMapper.selectByGroupId(groupId);
        for (UserInfo userInfo : groupUsers) {
            pushDeadlineMapper.insertSelective(new PushDeadline(null, userInfo.getUserId(), deadlineId));
        }
    }

}
