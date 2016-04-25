package myddl.service;

import myddl.entity.UserInfo;
import myddl.returnobject.UserRO;

public interface UserService {

    UserRO getUser(Long userId);

    void modifyUser(UserInfo userInfo);

    void addUser(UserInfo userInfo);

}
