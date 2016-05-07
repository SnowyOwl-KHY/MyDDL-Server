package myddl.constant;

public enum ErrorCode {

    ERROR_SYSTEM(1001, "System Error."),
    ERROR_USER_NOT_EXIST(10001, "User Not Exist."),
    ERROR_DEADLINE_NOT_EXIST(20001, "Deadline Not Exist."),
    ERROR_GROUP_NOT_EXIST(30001, "Group Not Exist."),
    ERROR_COURSE_PROJECT_NOT_EXIST(40001, "CourseProject Not Exist.");

    private final int errorCode;

    private final String errorMsg;

    ErrorCode(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
