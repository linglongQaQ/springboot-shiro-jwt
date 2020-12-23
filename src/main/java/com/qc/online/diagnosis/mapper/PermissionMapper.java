package com.qc.online.diagnosis.mapper;/**
 * @Description:
 * @Author: wangyilong
 * @Date: 2020/12/22 15:53
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qc.online.diagnosis.bean.entity.Permission;

/**
 * @Description:
 * @Author: wangyilong
 * @Date: 2020/12/22 15:53
 **/
public interface PermissionMapper extends BaseMapper<Permission> {


    /**
     * @param id 权限id
     * @return
     */
    Permission selectPermById(Long id);
}
