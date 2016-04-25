package myddl.returnobject;

import myddl.dao.CourseProjectMapper;
import myddl.entity.CourseProject;
import myddl.entity.Deadline;

public class DeadlineRO {
    private Long deadlineId;
    private String deadlineName;
    private String time;
    private String contactName;
    private String contactPhone;
    private String contactEmail;
    private String deadlineNote;
    private String deadlineImage;
    private Boolean complete;
    private CourseProjectAbstractRO courseProject;

    public DeadlineRO(Deadline deadline, CourseProjectMapper courseProjectMapper) {
        deadlineId = deadline.getDeadlineId();
        deadlineName = deadline.getDeadlineName();
        time = deadline.getTime();
        contactName = deadline.getContactName();
        contactPhone = deadline.getContactPhone();
        contactEmail = deadline.getContactEmail();
        deadlineNote = deadline.getDeadlineNote();
        deadlineImage = deadline.getDeadlineImage();
        complete = deadline.getComplete();
        Long courseProjectId = deadline.getCourseProjectId();
        CourseProject owner = courseProjectMapper.selectByPrimaryKey(courseProjectId);
        courseProject = new CourseProjectAbstractRO(owner);
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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getDeadlineNote() {
        return deadlineNote;
    }

    public void setDeadlineNote(String deadlineNote) {
        this.deadlineNote = deadlineNote;
    }

    public String getDeadlineImage() {
        return deadlineImage;
    }

    public void setDeadlineImage(String deadlineImage) {
        this.deadlineImage = deadlineImage;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public CourseProjectAbstractRO getCourseProject() {
        return courseProject;
    }

    public void setCourseProject(CourseProjectAbstractRO courseProject) {
        this.courseProject = courseProject;
    }
}
