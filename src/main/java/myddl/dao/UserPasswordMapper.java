package myddl.dao;

import myddl.entity.UserPassword;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("userPasswordMapper")
public interface UserPasswordMapper {

    UserPassword selectByUsername(String username);


    int deleteByPrimaryKey(Long userId);

    int insert(UserPassword record);

    int insertSelective(UserPassword record);

    UserPassword selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserPassword record);

    int updateByPrimaryKey(UserPassword record);
}