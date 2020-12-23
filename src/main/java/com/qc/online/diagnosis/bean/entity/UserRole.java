package com.qc.online.diagnosis.bean.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @Description:用户角色表
 * @Author: wangyilong
 * @Date: 2020/12/17 14:15
 **/
@Data
@TableName("tb_user_role")
public class UserRole {

    @TableField(value = "user_id")
    private Long userid;

    @TableField(value = "role_id")
    private Long roleid;

    @TableField(value = "permission_id")
    private Long permissionid;

}