package myddl.returnobject;

import myddl.dao.CourseProjectMapper;
import myddl.entity.CourseProject;
import myddl.entity.Deadline;

public class DeadlineAbstractRO {
    private Long deadlineId;
    private String deadlineName;
    private String time;
    private CourseProjectAbstractRO courseProject;

    public DeadlineAbstractRO(Deadline deadline, CourseProjectMapper courseProjectMapper) {
        deadlineId = deadline.getDeadlineId();
        deadlineName = deadline.getDeadlineName();
        time = deadline.getTime();
        long courseProjectId = deadline.getCourseProjectId();
        CourseProject courseProject = courseProjectMapper.selectByPrimaryKey(courseProjectId);
        this.courseProject = new CourseProjectAbstractRO(courseProject);
    }

    public Long getDeadlineId() {
        return deadlineId;
    }

    public void setDeadlineId(Long deadlineId) {
        this.deadlineId = deadlineId;
    }

    public String getDeadlineName() {
        return deadlineName;
    }

    public void setDeadlineName(String deadlineName) {
        this.deadlineName = deadlineName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CourseProjectAbstractRO getCourseProject() {
        return courseProject;
    }

    public void setCourseProject(CourseProjectAbstractRO courseProject) {
        this.courseProject = courseProject;
    }
}
