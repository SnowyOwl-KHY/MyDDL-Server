package myddl.service.impl;

import myddl.dao.CourseProjectMapper;
import myddl.dao.DeadlineMapper;
import myddl.entity.CourseProject;
import myddl.entity.Deadline;
import myddl.returnobject.CourseProjectRO;
import myddl.service.CourseProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("courseProjectService")
public class CourseProjectServiceImpl implements CourseProjectService {

    @Resource
    CourseProjectMapper courseProjectMapper;
    @Resource
    DeadlineMapper deadlineMapper;

    @Override
    public CourseProjectRO getCourseProject(Long courseProjectId) {
        CourseProject courseProject = courseProjectMapper.selectByPrimaryKey(courseProjectId);
        List<Deadline> deadlines = deadlineMapper.selectByCourseProjectId(courseProjectId);
        return new CourseProjectRO(courseProject, deadlines, courseProjectMapper);
    }

    @Override
    public void modifyCourseProject(CourseProject courseProject) {
        courseProjectMapper.updateByPrimaryKeySelective(courseProject);
    }

    @Override
    public long addCourseProject(CourseProject courseProject, Long userId) {
        courseProjectMapper.insertSelective(courseProject);
        long courseProjectId = courseProject.getCourseProjectId();
        courseProjectMapper.insertUserCourseProject(userId, courseProjectId);
        return courseProjectId;
    }

    @Override
    public void deleteCourseProject(Long courseProjectId) {
        courseProjectMapper.deleteByPrimaryKey(courseProjectId);
        courseProjectMapper.deleteUserCourseProjectByCourseProjectId(courseProjectId);
    }
}
