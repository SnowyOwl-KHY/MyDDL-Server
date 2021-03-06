package myddl.service;

import myddl.entity.CourseProject;
import myddl.returnobject.CourseProjectRO;

public interface CourseProjectService {

    CourseProjectRO getCourseProject(Long courseProjectId);

    void modifyCourseProject(CourseProject courseProject);

    long addCourseProject(CourseProject courseProject, Long userId);

    void deleteCourseProject(Long courseProjectId);

}
