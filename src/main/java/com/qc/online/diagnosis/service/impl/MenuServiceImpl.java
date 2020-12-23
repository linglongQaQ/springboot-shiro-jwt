package com.qc.online.diagnosis.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qc.online.diagnosis.bean.entity.Menu;
import com.qc.online.diagnosis.bean.entity.Role;
import com.qc.online.diagnosis.bean.entity.RoleMenu;
import com.qc.online.diagnosis.mapper.MenuMapper;
import com.qc.online.diagnosis.mapper.RoleMenuMapper;
import com.qc.online.diagnosis.service.MenuService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: wangyilong
 * @Date: 2020/12/17 15:32
 **/
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<Menu> findMenuByRolesId(List<Role> roleList) {
        List<Menu> menus=new ArrayList<>();
        if(!CollectionUtils.isEmpty(roleList)){
            //存放用户的菜单id
            Set<Long> menuIds=new HashSet<>();
            List<RoleMenu> roleMenus;
            for (Role role : roleList) {
                //根据角色ID查询权限ID
                QueryWrapper queryWrapper = new QueryWrapper();
                queryWrapper.eq("role_id",role.getRoleid());
                roleMenus= roleMenuMapper.selectList(queryWrapper);
                if(!CollectionUtils.isEmpty(roleMenus)){
                    for (RoleMenu roleMenu : roleMenus) {
                        menuIds.add(roleMenu.getMenuId());
                    }
                }
            }
            if(!CollectionUtils.isEmpty(menuIds)){
                for (Long menuId : menuIds) {
                    //该用户所有的菜单
                    Menu menu = menuMapper.selectById(menuId);
                    if(menu!=null){
                        menus.add(menu);
                    }
                }
            }
        }
        return menus;
    }
}
