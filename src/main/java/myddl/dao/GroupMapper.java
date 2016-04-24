package myddl.dao;

import myddl.entity.Group;
import org.springframework.stereotype.Component;

@Component
public interface GroupMapper {
    int deleteByPrimaryKey(Long groupId);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Long groupId);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);
}