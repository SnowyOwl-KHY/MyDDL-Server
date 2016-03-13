package myddl.service.impl;

import myddl.dao.UserMapper;
import myddl.entity.User;
import myddl.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    public User getUser(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

}
