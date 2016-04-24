package myddl.returnobject;

import myddl.dao.CourseProjectMapper;
import myddl.entity.CourseProject;
import myddl.entity.Deadline;

public class DeadlineAbstractRO {
    private String deadlineName;
    private String time;
    private CourseProjectAbstractRO courseProject;

    public DeadlineAbstractRO(Deadline deadline, CourseProjectMapper courseProjectMapper) {
        deadlineName = deadline.getDeadlineName();
        time = deadline.getTime();

        CourseProject owner = courseProjectMapper.selectByPrimaryKey(deadline.getCourseProjectId());
        courseProject = new CourseProjectAbstractRO(owner);
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
