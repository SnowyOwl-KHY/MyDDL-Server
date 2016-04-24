package myddl.returnobject;

public class CourseProjectAbstractRO {
    private Long cpId;
    private String cpName;
    private String cpImage;
    private String cpType;
    private String cpNote;

    public Long getCpId() {
        return cpId;
    }

    public void setCpId(Long cpId) {
        this.cpId = cpId;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public String getCpImage() {
        return cpImage;
    }

    public void setCpImage(String cpImage) {
        this.cpImage = cpImage;
    }

    public String getCpType() {
        return cpType;
    }

    public void setCpType(String cpType) {
        this.cpType = cpType;
    }

    public String getCpNote() {
        return cpNote;
    }

    public void setCpNote(String cpNote) {
        this.cpNote = cpNote;
    }
}
