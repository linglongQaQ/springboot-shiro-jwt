package com.qc.online.diagnosis.bean.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @Description:
 * @Author: wangyilong
 * @Date: 2020/12/17 14:27
 **/
@Data
@TableName("tb_role_menu")
public class RoleMenu {
    @TableField(value = "role_id")
    private Long roleId;
    @TableField(value = "menu_id")
    private Long menuId;

}