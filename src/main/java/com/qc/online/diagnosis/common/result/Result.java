package com.qc.online.diagnosis.common.result;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author qc_he
 */

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Result<T> {
    private boolean succ;
    private T records;
    private String message;

    public Result(boolean succ,T records,String message){
        this.succ = succ;
        this.records = records;
        this.message = message;
    }

    public static Result ok() {
        Result result = new Result();
        result.setSucc(ResultCode.SUCCESS.getSucc());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        return result;
    }

    public static Result ok(ResultCode resultCode) {
        Result result = new Result();
        result.setSucc(resultCode.getSucc());
        result.setMessage(resultCode.getMessage());
        return result;
    }

    public static Result ok(Object data) {
        Result result = new Result();
        result.setRecords(data);
        result.setSucc(ResultCode.SUCCESS.getSucc());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setSucc(ResultCode.FAILED.getSucc());
        result.setMessage(ResultCode.FAILED.getMessage());
        return result;
    }


    public static Result error(String message) {
        Result result = new Result();
        result.setSucc(ResultCode.REQUEST_ERROR.getSucc());
        result.setMessage(message);
        return result;
    }

    public static Result error(ResultCode resultCode) {
        Result result = new Result();
        result.setSucc(resultCode.getSucc());
        result.setMessage(resultCode.getMessage());
        return result;
    }


}
