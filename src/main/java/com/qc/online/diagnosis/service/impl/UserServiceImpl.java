package com.qc.online.diagnosis.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qc.online.diagnosis.bean.entity.Menu;
import com.qc.online.diagnosis.bean.entity.Role;
import com.qc.online.diagnosis.bean.entity.User;
import com.qc.online.diagnosis.mapper.UserMapper;
import com.qc.online.diagnosis.service.MenuService;
import com.qc.online.diagnosis.service.RoleService;
import com.qc.online.diagnosis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: wangyilong
 * @Date: 2020/12/17 15:07
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;


    /**
     *根据用户名查询用户
     * @param userName
     * @return
     */
    @Override
    public User findUserByName(String userName) {
        User user = new User();
        user.setUsername(userName);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.setEntity(user);
        return userMapper.selectOne(queryWrapper);
    }

    /**
     * 根据用户id查询角色
     * @param id 用户id
     * @return
     */
    @Override
    public List<Role> findRolesById(Long id) {
        List<Role> roleList = roleService.findRoleByUserId(id);
        return roleList;
    }

    /**d
     * 根据用户的角色查询菜单权限
     * @param roleList 用户的角色
     * @return
     */
    @Override
    public List<Menu> findMenuByRolesId(List<Role> roleList) {
        List<Menu> menuList = menuService.findMenuByRolesId(roleList);
        return menuList;
    }

}
