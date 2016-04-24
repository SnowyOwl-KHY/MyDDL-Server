package myddl.service;

import myddl.returnobject.UserRO;

public interface UserService {

    UserRO getUser(Long userId);

}
