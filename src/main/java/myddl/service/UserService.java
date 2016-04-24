package myddl.service;

import myddl.entity.UserInfo;
import myddl.returnobject.UserRO;

public interface UserService {

    UserRO getUser(Long userId);

    void addUser(UserInfo userInfo);

}
