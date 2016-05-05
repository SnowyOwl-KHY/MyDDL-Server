package myddl.service;

import myddl.entity.UserInfo;
import myddl.returnobject.UserRO;

public interface UserService {

    Long login(String username, String password);

    UserRO getUser(Long userId);

    void modifyUser(UserInfo userInfo);

    int addUser(UserInfo userInfo);

    void deleteUser(Long userId);
}
