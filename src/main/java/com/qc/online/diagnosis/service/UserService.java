package com.qc.online.diagnosis.service;

import com.qc.online.diagnosis.bean.entity.Menu;
import com.qc.online.diagnosis.bean.entity.Role;
import com.qc.online.diagnosis.bean.entity.User;

import java.util.List;

/**
 * @Description:
 * @Author: wangyilong
 * @Date: 2020/12/17 14:52
 */
public interface UserService {

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    User findUserByName(String userName);

    /**
     * 查询用户角色
     *
     * @param id 用户id
     * @return
     */
    List<Role> findRolesById(Long id);

    /**
     * 根据用户角色查询用户的菜单
     * 菜单: menu+button
     *
     * @param roles 用户的角色
     * @return
     */
    List<Menu> findMenuByRolesId(List<Role> roles);



}
