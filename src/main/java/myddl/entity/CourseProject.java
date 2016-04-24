package myddl.entity;

public class CourseProject {
    private Long courseProjectId;

    private String courseProjectName;

    private String courseProjectType;

    private String courseProjectNote;

    private String courseProjectImage;

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
        this.courseProjectName = courseProjectName == null ? null : courseProjectName.trim();
    }

    public String getCourseProjectType() {
        return courseProjectType;
    }

    public void setCourseProjectType(String courseProjectType) {
        this.courseProjectType = courseProjectType == null ? null : courseProjectType.trim();
    }

    public String getCourseProjectNote() {
        return courseProjectNote;
    }

    public void setCourseProjectNote(String courseProjectNote) {
        this.courseProjectNote = courseProjectNote == null ? null : courseProjectNote.trim();
    }

    public String getCourseProjectImage() {
        return courseProjectImage;
    }

    public void setCourseProjectImage(String courseProjectImage) {
        this.courseProjectImage = courseProjectImage == null ? null : courseProjectImage.trim();
    }
}