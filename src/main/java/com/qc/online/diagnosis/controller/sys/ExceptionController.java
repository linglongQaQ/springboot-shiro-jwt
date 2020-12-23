package com.qc.online.diagnosis.controller.sys;

import com.qc.online.diagnosis.common.exception.MyException;
import com.qc.online.diagnosis.common.result.Result;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;



/**
 * @Description:处理框架异常
 * @Author: wangyilong
 * @Date: 2020/12/21 11:19
 **/
@RestControllerAdvice
public class ExceptionController {
    /**
     *   捕捉shiro的异常
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException .class)
    public Result handle401(ShiroException e) {
        return new Result(false, null,"shiro的异常,无权访问");
    }

    /**
     * 捕捉UnauthorizedException
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(MyException.class)
    public Result handle401() {
        return new Result(false,null, "UnauthorizedException");
    }

    /**
     *     捕捉其他所有异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result globalException(HttpServletRequest request, Throwable ex) {
        return new Result(false, null,"其他异常");
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
