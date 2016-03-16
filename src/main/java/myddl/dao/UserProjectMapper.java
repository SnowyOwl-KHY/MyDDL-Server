package myddl.dao;

import myddl.entity.UserProject;

public interface UserProjectMapper {
    int deleteByPrimaryKey(Long projectId);

    int insert(UserProject record);

    int insertSelective(UserProject record);

    UserProject selectByPrimaryKey(Long projectId);

    int updateByPrimaryKeySelective(UserProject record);

    int updateByPrimaryKey(UserProject record);
}