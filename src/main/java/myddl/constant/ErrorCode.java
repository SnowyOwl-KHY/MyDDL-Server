package myddl.constant;

public enum ErrorCode {

    ERROR_PARAMETER(1000, "参数错误"),
    ERROR_SYSTEM(1001, "系统错误"),
    ERROR_USER_NOT_EXIST(10001, "用户不存在"),
    ERROR_DEADLINE_NOT_EXIST(20001, "deadline不存在");

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
