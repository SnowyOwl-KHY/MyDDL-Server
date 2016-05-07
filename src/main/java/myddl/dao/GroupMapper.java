package myddl.dao;

import myddl.entity.Group;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GroupMapper {
    List<Group> selectByUserId(Long userId);

    void insertGroupUser(@Param("userId") Long userId, @Param("groupId") Long groupId);

    int deleteUserGroupByGroupId(Long groupId);

    int deleteUserGroupByUserIdAndGroupId(@Param("userId") Long userId, @Param("groupId") Long groupId);

    int deleteGroupDeadlineByGroupIdAndDeadlineId(@Param("groupId") Long groupId, @Param("deadlineId") Long deadlineId);

    int insertGroupDeadline(@Param("groupId") Long groupId, @Param("deadlineId") Long deadlineId);


    int deleteByPrimaryKey(Long groupId);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Long groupId);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);
}