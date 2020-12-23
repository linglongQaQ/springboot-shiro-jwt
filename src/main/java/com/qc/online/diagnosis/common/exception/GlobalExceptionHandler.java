package com.qc.online.diagnosis.common.exception;

import com.qc.online.diagnosis.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author qc_he
 */
@RestControllerAdvice(basePackages = {"com.qc.online.vibrationMonitoring.controller"})
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(MyException.class)
    public Result error(MyException e){
        log.error(e.getMessage(),e);
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result error(Exception e){
        log.error(e.getMessage(),e);
        return Result.error();
    }
}
