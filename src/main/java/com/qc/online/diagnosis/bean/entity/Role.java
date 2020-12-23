package com.qc.online.diagnosis.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description:角色表
 * @Author: wangyilong
 * @Date: 2020/12/17 14:12
 **/
@Data
@TableName("tb_role")
public class Role {

    @TableId(type = IdType.AUTO,value = "role_id")
    private Long roleid;
    //角色名称
    private String roleName;
    //创建时间
    private Date createTime;
    //状态
    private Integer status;
    //角色
    private String role;

    @TableField(exist = false)
    private List<Permission> permissionList;
}
