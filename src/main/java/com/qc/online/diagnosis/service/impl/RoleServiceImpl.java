package com.qc.online.diagnosis.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qc.online.diagnosis.bean.entity.Role;
import com.qc.online.diagnosis.bean.entity.User;
import com.qc.online.diagnosis.bean.entity.UserRole;
import com.qc.online.diagnosis.mapper.RoleMapper;
import com.qc.online.diagnosis.mapper.UserRoleMapper;
import com.qc.online.diagnosis.service.RoleService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: wangyilong
 * @Date: 2020/12/17 15:32
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;


    /**
     * 根据用户名查询用户角色
     * @param id
     * @return
     */
    @Override
    public List<Role> findRoleByUserId(Long id) {
        //角色集合
        List<Role> roleList = new ArrayList<>();
        //通过userid查询角色集合
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",id);
        List<UserRole> userRoleList = userRoleMapper.selectList(queryWrapper);
        //创建角色id集合
        List<Long> rids = new ArrayList<>();
        if(!CollectionUtils.isEmpty(userRoleList)){
            for (UserRole userRole : userRoleList) {
                rids.add(userRole.getRoleid());
            }
            if(!CollectionUtils.isEmpty(rids)){
                for (Long rid : rids) {
                    Role role = roleMapper.selectById(rid);
                    if(role!=null){
                        roleList.add(role);
                    }
                }
            }
        }
        return roleList;
    }
}
