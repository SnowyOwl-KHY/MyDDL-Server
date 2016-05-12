package myddl.service;

import myddl.entity.Group;
import myddl.entity.GroupMessage;
import myddl.returnobject.GroupRO;

import java.util.List;

public interface GroupService {

    GroupRO getGroup(Long groupId);

    void modifyGroup(Group group);

    Long addGroup(Group group, Long userId);

    void deleteGroup(Long groupId);

    void addGroupUser(Long groupId, Long userId);

    void deleteGroupUser(Long groupId, Long userId);

    void addGroupDeadline(Long groupId, Long deadlineId, long userId);

    void deleteGroupDeadline(Long groupId, Long deadlineId, long userId);

    List<GroupMessage> getGroupMessage(Long groupId);
}
