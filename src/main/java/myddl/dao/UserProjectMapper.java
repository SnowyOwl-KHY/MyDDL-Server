package myddl.dao;

import myddl.entity.UserProject;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserProjectMapper {
    int deleteByPrimaryKey(Long projectId);

    int insert(UserProject record);

    int insertSelective(UserProject record);

    UserProject selectByPrimaryKey(Long projectId);

    int updateByPrimaryKeySelective(UserProject record);

    int updateByPrimaryKey(UserProject record);


    List<UserProject> selectByUserId(long userId);
}