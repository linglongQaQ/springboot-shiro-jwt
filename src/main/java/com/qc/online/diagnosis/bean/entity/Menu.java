package com.qc.online.diagnosis.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @Description: 菜单表
 * @Author: wangyilong
 * @Date: 2020/12/17 14:17
 **/
@Data
@TableName("tb_menu")
public class Menu {

    @TableId(type = IdType.AUTO,value = "menu_id")
    private Long menuid;

    @TableField(value = "parent_id")
    private Long parentId;

    private String menuName;

    private Integer type;

    private String url;

}
