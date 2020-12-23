package com.qc.online.diagnosis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qc.online.diagnosis.bean.entity.Permission;
import com.qc.online.diagnosis.bean.entity.UserRole;
import com.qc.online.diagnosis.mapper.PermissionMapper;
import com.qc.online.diagnosis.mapper.UserRoleMapper;
import com.qc.online.diagnosis.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: wangyilong
 * @Date: 2020/12/22 15:56
 **/
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 根据userid查询用户权限列表
     * @param userid
     * @return
     */
    @Override
    public Set<String> findPermissionByUserid(Long userid) {

        //1 根据用户id查询用户角色表  获取用户角色对象
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",userid);
        List<UserRole> userRoles = userRoleMapper.selectList(queryWrapper);
        //2 根据用户查询用户权限
        Set<String> permissionList = new HashSet<>();
        for (UserRole userRole : userRoles) {
            if (userRole != null){
                Permission permission = permissionMapper.selectPermById(userRole.getPermissionid());
                permissionList.add(permission.getPermissionName());
            }
        }
        return permissionList;
    }
}
