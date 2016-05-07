package myddl.entity;

public class Deadline {
    private Long deadlineId;

    private String deadlineName;

    private String time;

    private Long courseProjectId;

    private String contactName;

    private String contactPhone;

    private String contactEmail;

    private String deadlineNote;

    private String deadlineImage;

    private Boolean complete = false;

    public Deadline() {
    }

    public Deadline(Long deadlineId, String deadlineName, String time, Long courseProjectId, String contactName, String contactPhone, String contactEmail, String deadlineNote, String deadlineImage, Boolean complete) {
        this.deadlineId = deadlineId;
        this.deadlineName = deadlineName;
        this.time = time;
        this.courseProjectId = courseProjectId;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.deadlineNote = deadlineNote;
        this.deadlineImage = deadlineImage;
        this.complete = complete;
    }

    public Deadline duplicate() {
        Deadline duplicate = new Deadline(null,
                getDeadlineName(),
                getTime(),
                getCourseProjectId(),
                getContactName(),
                getContactPhone(),
                getContactEmail(),
                getDeadlineNote(),
                getDeadlineImage(),
                getComplete());
        return duplicate;
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
        this.deadlineName = deadlineName == null ? null : deadlineName.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Long getCourseProjectId() {
        return courseProjectId;
    }

    public void setCourseProjectId(Long courseProjectId) {
        this.courseProjectId = courseProjectId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    public String getDeadlineNote() {
        return deadlineNote;
    }

    public void setDeadlineNote(String deadlineNote) {
        this.deadlineNote = deadlineNote == null ? null : deadlineNote.trim();
    }

    public String getDeadlineImage() {
        return deadlineImage;
    }

    public void setDeadlineImage(String deadlineImage) {
        this.deadlineImage = deadlineImage == null ? null : deadlineImage.trim();
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }
}