package myddl.returnobject;

import myddl.dao.CourseProjectMapper;
import myddl.entity.CourseProject;
import myddl.entity.Deadline;

import java.util.ArrayList;
import java.util.List;

public class CourseProjectRO {
    private Long courseProjectId;
    private String courseProjectName;
    private String courseProjectType;
    private String courseProjectNote;
    private String courseProjectImage;
    private List<DeadlineRO> deadlines = new ArrayList<>();

    public CourseProjectRO(CourseProject courseProject, List<Deadline> deadlines, CourseProjectMapper courseProjectMapper) {
        courseProjectId = courseProject.getCourseProjectId();
        courseProjectName = courseProject.getCourseProjectName();
        courseProjectType = courseProject.getCourseProjectType();
        courseProjectNote = courseProject.getCourseProjectNote();
        courseProjectImage = courseProject.getCourseProjectImage();

        for (Deadline deadline : deadlines) {
            DeadlineRO deadlineRO = new DeadlineRO(deadline, courseProjectMapper);
            this.deadlines.add(deadlineRO);
        }
    }

    public Long getCourseProjectId() {
        return courseProjectId;
    }

    public void setCourseProjectId(Long courseProjectId) {
        this.courseProjectId = courseProjectId;
    }

    public String getCourseProjectName() {
        return courseProjectName;
    }

    public void setCourseProjectName(String courseProjectName) {
        this.courseProjectName = courseProjectName;
    }

    public String getCourseProjectType() {
        return courseProjectType;
    }

    public void setCourseProjectType(String courseProjectType) {
        this.courseProjectType = courseProjectType;
    }

    public String getCourseProjectNote() {
        return courseProjectNote;
    }

    public void setCourseProjectNote(String courseProjectNote) {
        this.courseProjectNote = courseProjectNote;
    }

    public String getCourseProjectImage() {
        return courseProjectImage;
    }

    public void setCourseProjectImage(String courseProjectImage) {
        this.courseProjectImage = courseProjectImage;
    }

    public List<DeadlineRO> getDeadlines() {
        return deadlines;
    }

    public void setDeadlines(List<DeadlineRO> deadlines) {
        this.deadlines = deadlines;
    }
}
