package com.qc.online.diagnosis.service;/**
 * @Description:
 * @Author: wangyilong
 * @Date: 2020/12/17 15:31
 */

import com.qc.online.diagnosis.bean.entity.Menu;
import com.qc.online.diagnosis.bean.entity.Role;

import java.util.List;

/**
 * @Description:菜单管理
 * @Author: wangyilong
 * @Date: 2020/12/17 15:31
 **/
public interface  MenuService {
    /**
     * 根据用户角色查询菜单权限
     * @param roles
     * @return
     */
    List<Menu> findMenuByRolesId(List<Role> roles);
}
