package myddl.returnobject;

import myddl.entity.Deadline;

public class DeadlineAbstractRO {
    private Long deadlineId;
    private String deadlineName;
    private String time;
    private Long courseProjectId;

    public DeadlineAbstractRO(Deadline deadline) {
        deadlineId = deadline.getDeadlineId();
        deadlineName = deadline.getDeadlineName();
        time = deadline.getTime();
        courseProjectId = deadline.getCourseProjectId();
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

    public Long getCourseProjectId() {
        return courseProjectId;
    }

    public void setCourseProjectId(Long courseProjectId) {
        this.courseProjectId = courseProjectId;
    }
}
