package myddl.dao;

import myddl.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    User selectByPrimaryKey(Long userId);

}
