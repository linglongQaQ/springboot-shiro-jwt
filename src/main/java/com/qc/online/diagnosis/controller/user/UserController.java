package com.qc.online.diagnosis.controller.user;/**
 * @Description:
 * @Author: wangyilong
 * @Date: 2020/12/21 17:29
 */

import com.qc.online.diagnosis.bean.entity.Role;
import com.qc.online.diagnosis.common.exception.MyException;
import com.qc.online.diagnosis.common.result.Result;
import com.qc.online.diagnosis.service.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: wangyilong
 * @Date: 2020/12/21 17:29
 **/
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @RequiresRoles({"admin"})
    @RequestMapping("/query")
    public Result findUser(@RequestParam(value = "id") long id){

        List<Role> rolesList = userService.findRolesById(id);
        if (rolesList.size()>0){
            return new Result(true,rolesList,"查询数据成功");
        }else {
            throw new MyException();
        }
    }


    @GetMapping("/finduser")
    @RequiresRoles("admin")
    public Result queryUser(){
        return new Result(true,null,"have admin permission");
    }

}
