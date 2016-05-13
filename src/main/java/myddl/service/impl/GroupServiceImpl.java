package myddl.service.impl;

import myddl.dao.*;
import myddl.entity.*;
import myddl.returnobject.GroupRO;
import myddl.service.GroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    GroupMessageMapper groupMessageMapper;
    @Resource
    PushDeadlineMapper pushDeadlineMapper;
    @Resource
    CourseProjectMapper courseProjectMapper;

    @Override
    public GroupRO getGroup(Long groupId) {
        Group group = groupMapper.selectByPrimaryKey(groupId);
        if (group == null) return null;

        List<UserInfo> users = userInfoMapper.selectByGroupId(groupId);
        List<Deadline> deadlines = deadlineMapper.selectByGroupId(groupId);
        return new GroupRO(group, users, deadlines, courseProjectMapper);
    }

    @Override
    public void modifyGroup(Group group) {
        groupMapper.updateByPrimaryKeySelective(group);
    }

    @Override
    public Long addGroup(Group group, Long userId) {
        groupMapper.insertSelective(group);
        long groupId = group.getGroupId();
        addGroupUser(groupId, userId);
        return groupId;
    }

    @Override
    public void deleteGroup(Long groupId) {
        // delete relationship between group and deadline(copy duplicate to all user)
        List<Deadline> groupDeadlines = deadlineMapper.selectByGroupId(groupId);
        List<UserInfo> groupUsers = userInfoMapper.selectByGroupId(groupId);
        for (Deadline deadline : groupDeadlines) {
            // copy duplicate to all user and delete group deadline
            deleteGroupDeadlineAndCopyDuplicateToGroupUsers(groupId, deadline, groupUsers);
        }

        groupMapper.deleteByPrimaryKey(groupId);
        // delete relationship between group and user
        groupMapper.deleteUserGroupByGroupId(groupId);
    }

    @Override
    public void addGroupUser(Long groupId, Long userId) {
        groupMapper.insertGroupUser(userId, groupId);

        // push the group deadline to this new user
        List<Deadline> groupDeadlines = deadlineMapper.selectByGroupId(groupId);
        for (Deadline deadline : groupDeadlines) {
            pushDeadlineMapper.insertSelective(new PushDeadline(null, userId, deadline.getDeadlineId()));
        }

        UserInfo user = userInfoMapper.selectByPrimaryKey(userId);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd/HH:mm");
        String timeString = format.format(date);
        groupMessageMapper.insertSelective(new GroupMessage(null, user.getUserName() + " join group.", timeString, groupId));
    }

    /**
     * Delete group user and copy a duplicate of group deadline to this user. (if the user has anyone.)
     *
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
                deadlineMapper.insertSelective(duplicate);
                long duplicateId = duplicate.getDeadlineId();
                deadlineMapper.insertUserDeadline(userId, duplicateId);
            }
        }

        UserInfo user = userInfoMapper.selectByPrimaryKey(userId);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd/HH:mm");
        String timeString = format.format(date);
        groupMessageMapper.insertSelective(new GroupMessage(null, user.getUserName() + " quit group.", timeString, groupId));
    }

    /**
     * Add the deadline to the push deadline list of all user
     *
     * @param groupId
     * @param deadlineId
     */
    @Override
    public void addGroupDeadline(Long groupId, Long deadlineId, long userId) {
        groupMapper.insertGroupDeadline(groupId, deadlineId);

        List<UserInfo> groupUsers = userInfoMapper.selectByGroupId(groupId);
        groupUsers.stream().filter(userInfo -> userInfo.getUserId() != userId).forEach(userInfo ->
                        pushDeadlineMapper.insertSelective(new PushDeadline(null, userInfo.getUserId(), deadlineId)));

        UserInfo user = userInfoMapper.selectByPrimaryKey(userId);
        Deadline deadline = deadlineMapper.selectByPrimaryKey(deadlineId);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd/HH:mm");
        String timeString = format.format(date);
        groupMessageMapper.insertSelective(new GroupMessage(null, user.getUserName() + " share deadline: " + deadline.getDeadlineName(), timeString, groupId));
    }

    /**
     * Delete and copy a duplicate
     *
     * @param groupId
     * @param deadlineId
     */
    @Override
    public void deleteGroupDeadline(Long groupId, Long deadlineId, long userId) {
        Deadline deadline = deadlineMapper.selectByPrimaryKey(deadlineId);
        List<UserInfo> groupUsers = userInfoMapper.selectByGroupId(groupId);
        // copy duplicate to all user and delete group deadline
        deleteGroupDeadlineAndCopyDuplicateToGroupUsers(groupId, deadline, groupUsers);

        UserInfo user = userInfoMapper.selectByPrimaryKey(userId);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd/HH:mm");
        String timeString = format.format(date);
        groupMessageMapper.insertSelective(new GroupMessage(null, user.getUserName() + " delete deadline: " + deadline.getDeadlineName(), timeString, groupId));
    }

    @Override
    public List<GroupMessage> getGroupMessage(Long groupId) {
        return groupMessageMapper.selectByGroupId(groupId);
    }

    /**
     * Copy duplicate to all user and delete group deadline
     *
     * @param groupId
     * @param deadline
     * @param groupUsers
     */
    private void deleteGroupDeadlineAndCopyDuplicateToGroupUsers(Long groupId, Deadline deadline, List<UserInfo> groupUsers) {
        // copy duplicate to all user
        for (UserInfo userInfo : groupUsers) {
            Deadline duplicate = deadline.duplicate();
            deadlineMapper.insertSelective(duplicate);
            long duplicateId = duplicate.getDeadlineId();
            deadlineMapper.insertUserDeadline(userInfo.getUserId(), duplicateId);
        }
        // delete group deadline
        groupMapper.deleteGroupDeadlineByGroupIdAndDeadlineId(groupId, deadline.getDeadlineId());
        deadlineMapper.deleteByPrimaryKey(deadline.getDeadlineId());
    }

}
