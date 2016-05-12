package myddl.dao;

import myddl.entity.CourseProject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseProjectMapper")
public interface CourseProjectMapper {
    int insertUserCourseProject(@Param("userId") Long userId, @Param("courseProjectId") Long courseProjectId);

    int deleteUserCourseProjectByCourseProjectId(Long courseProjectId);


    int deleteByPrimaryKey(Long courseProjectId);

    int insert(CourseProject record);

    int insertSelective(CourseProject record);

    CourseProject selectByPrimaryKey(Long courseProjectId);

    List<CourseProject> selectByUserId(Long userId);

    int updateByPrimaryKeySelective(CourseProject record);

    int updateByPrimaryKey(CourseProject record);
}