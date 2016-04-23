package myddl.returnobject;

import myddl.constant.ErrorCode;
import myddl.constant.StatusCode;

import javax.validation.constraints.NotNull;

public class ReturnObject {
    private int statusCode;

    private Object result;

    private ErrorCodeObject errorCodeObject;

    public static final ReturnObject INTERNAL_ERROR = newErrorReturnObject(StatusCode.INTERNAL_SERVER_ERROR, ErrorCode.ERROR_SYSTEM);
    public static final ReturnObject EXECUTION_SUCCESS = newOKReturnObject("success");

    public static ReturnObject newOKReturnObject(Object result) {
        ReturnObject returnObject = new ReturnObject();
        returnObject.setResult(result);
        returnObject.setStatusCode(StatusCode.OK);
        return returnObject;
    }

    public static ReturnObject newErrorReturnObject(int statusCode, @NotNull ErrorCode errorCode) {
        ReturnObject returnObject = new ReturnObject();
        //设置状态码
        returnObject.setStatusCode(statusCode);
        //设置具体的错误代码和错误信息
        ErrorCodeObject errorCodeObject = new ErrorCodeObject();
        errorCodeObject.setErrorCode(errorCode.name());
        errorCodeObject.setErrorMsg(errorCode.getErrorMsg());
        returnObject.setErrorCodeObject(errorCodeObject);
        return returnObject;
    }


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public ErrorCodeObject getErrorCodeObject() {
        return errorCodeObject;
    }

    public void setErrorCodeObject(ErrorCodeObject errorCodeObject) {
        this.errorCodeObject = errorCodeObject;
    }
}
