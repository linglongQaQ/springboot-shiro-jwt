package com.qc.online.diagnosis.common.result;

/**
 *
 * @author qc_he
 */

public enum ResultCode {
    SUCCESS(200,true, "success"),
    //400 默认为业务捕获异常,带异常说明
    REQUEST_ERROR(400, false, "请求错误"),
    NO_LOGIN(401,false,  "没有登录"),
    NO_PERMISSION(403,false,  "没有操作权限"),
    //500 默认未捕获异常，默认为系统异常
    FAILED(500, false, "系统异常")
	;

    private Integer code;
    private String message;
    private Boolean succ;

	ResultCode(Integer code,Boolean succ, String message) {
        this.code = code;
        this.succ = succ;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSucc() {
        return succ;
    }

    public void setSucc(Boolean succ) {
        this.succ = succ;
    }
}
