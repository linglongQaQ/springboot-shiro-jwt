package com.qc.online.diagnosis.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: wangyilong
 * @Date: 2020/12/17 14:04
 **/
@Data
@TableName("tb_user")
public class User {

    @TableId(type = IdType.AUTO,value = "user_id")
    private Long userid;

    private String username;

    private String password;

    private String phone;

    private Integer status;

    private Date createTime;

    private Integer type;

    /**
     * 该字段为非数据库字段
     */
    @TableField(exist = false)
    private List<UserRole> userRoleList;

}