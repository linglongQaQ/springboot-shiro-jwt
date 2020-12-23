package com.qc.online.diagnosis.service;

import com.qc.online.diagnosis.bean.entity.Role;
import com.qc.online.diagnosis.bean.entity.User;

import java.util.List;

/**
 * @Description:权限管理
 * @Author: wangyilong
 * @Date: 2020/12/17 15:30
 */
public interface RoleService {

    /**
     * 根据用户查询角色
     * @param id
     * @return
     */
    List<Role> findRoleByUserId(Long id);
}
