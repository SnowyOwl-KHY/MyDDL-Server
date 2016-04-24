package myddl.dao;

import myddl.entity.CourseProject;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CourseProjectMapper {
    int deleteByPrimaryKey(Long courseProjectId);

    int insert(CourseProject record);

    int insertSelective(CourseProject record);

    CourseProject selectByPrimaryKey(Long courseProjectId);

    List<CourseProject> selectByUserId(Long userId);

    int updateByPrimaryKeySelective(CourseProject record);

    int updateByPrimaryKey(CourseProject record);
}