package myddl.service;

import myddl.entity.Group;
import myddl.returnobject.GroupRO;

public interface GroupService {

    GroupRO getGroup(Long groupId);

    void modifyGroup(Group group);

    Long addGroup(Group group);

    void deleteGroup(Long groupId);

    void addGroupUser(Long groupId, Long userId);

    void deleteGroupUser(Long groupId, Long userId);

    void addGroupDeadline(Long groupId, Long deadlineId);
}
