package myddl.service;

import myddl.entity.UserInfo;
import myddl.entity.UserPassword;
import myddl.returnobject.UserRO;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    Long login(String username, String password);

    UserRO getUser(@Param("userId") Long userId);

    void modifyUser(UserPassword userPassword, UserInfo userInfo);

    long addUser(UserPassword userPassword, UserInfo userInfo);

    void deleteUser(Long userId);
}
