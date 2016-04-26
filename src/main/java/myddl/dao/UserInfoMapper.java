package myddl.dao;

import myddl.entity.UserInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserInfoMapper {
    List<UserInfo> selectByGroupId(Long groupId);


    int deleteByPrimaryKey(Long userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}