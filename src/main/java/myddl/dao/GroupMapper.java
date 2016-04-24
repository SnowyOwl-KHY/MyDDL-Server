package myddl.dao;

import myddl.entity.Group;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GroupMapper {
    int deleteByPrimaryKey(Long groupId);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Long groupId);

    List<Group> selectByUserId(Long userId);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);
}