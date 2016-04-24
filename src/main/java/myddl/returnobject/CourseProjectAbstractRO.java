package myddl.returnobject;

import myddl.entity.CourseProject;

public class CourseProjectAbstractRO {
    private Long courseProjectId;
    private String courseProjectName;
    private String courseProjectType;
    private String courseProjectNote;
    private String courseProjectImage;

    public CourseProjectAbstractRO(CourseProject courseProject) {
        courseProjectId = courseProject.getCourseProjectId();
        courseProjectName = courseProject.getCourseProjectName();
        courseProjectType = courseProject.getCourseProjectType();
        courseProjectNote = courseProject.getCourseProjectNote();
        courseProjectImage = courseProject.getCourseProjectImage();
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

    public String getCourseProjectImage() {
        return courseProjectImage;
    }

    public void setCourseProjectImage(String courseProjectImage) {
        this.courseProjectImage = courseProjectImage;
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
}
