package myddl.dao;

import myddl.entity.Group;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GroupMapper {
    List<Group> selectByUserId(Long userId);

    void insertGroupUser(@Param("groupId") Long groupId, @Param("userId") Long userId);

    int deleteUserGroupByGroupId(Long groupId);


    int deleteByPrimaryKey(Long groupId);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Long groupId);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);
}