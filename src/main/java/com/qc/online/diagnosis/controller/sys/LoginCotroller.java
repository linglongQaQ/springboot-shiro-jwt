package com.qc.online.diagnosis.controller.sys;

import com.qc.online.diagnosis.bean.entity.User;
import com.qc.online.diagnosis.common.exception.MyException;
import com.qc.online.diagnosis.common.result.Result;
import com.qc.online.diagnosis.common.utils.JWTUtils;
import com.qc.online.diagnosis.common.utils.MD5Utils;
import com.qc.online.diagnosis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: wangyilong
 * @Date: 2020/12/17 18:09
 **/
@RestController
@RequestMapping("/sys")
public class LoginCotroller {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Result login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password){

        User user = userService.findUserByName(username);
        String md5 = MD5Utils.getMD5(password);
        if (md5.equals(user.getPassword())){
            return new Result(true, JWTUtils.sign(username,md5),"login succ");
        }else {
            throw new MyException();
        }

    }

}
