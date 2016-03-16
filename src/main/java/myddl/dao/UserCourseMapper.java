package myddl.dao;

import myddl.entity.UserCourse;

public interface UserCourseMapper {
    int deleteByPrimaryKey(Long courseId);

    int insert(UserCourse record);

    int insertSelective(UserCourse record);

    UserCourse selectByPrimaryKey(Long courseId);

    int updateByPrimaryKeySelective(UserCourse record);

    int updateByPrimaryKey(UserCourse record);
}