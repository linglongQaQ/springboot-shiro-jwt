package com.qc.online.diagnosis.bean.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description:权限表
 * @Author: wangyilong
 * @Date: 2020/12/22 15:40
 **/
@Data
@TableName("tb_permission")
public class Permission {

    @TableField(value = "permission_id")
    private Long permissionid;

    @TableField(value = "permission_name")
    private String permissionName;
}
