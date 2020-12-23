/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50730
Source Host           : localhost:3306
Source Database       : wind_data

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2020-12-23 15:35:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级id',
  `menu_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '菜单名称',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `url` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '菜单路径',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('1', '0', '系统管理', '0', null, '2020-12-22 15:13:41');
INSERT INTO `tb_menu` VALUES ('2', '1', '菜单权限', '0', '/sys/menus', '2020-12-22 15:13:45');
INSERT INTO `tb_menu` VALUES ('3', '1', '角色管理', '0', '/sys/roles', '2020-12-22 15:13:50');
INSERT INTO `tb_menu` VALUES ('4', '1', '用户管理', '0', '/sys/users', '2020-12-22 15:13:52');

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission` (
  `permission_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `permission_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '权限名称',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_permission
-- ----------------------------
INSERT INTO `tb_permission` VALUES ('1', 'edit');
INSERT INTO `tb_permission` VALUES ('2', 'query');
INSERT INTO `tb_permission` VALUES ('3', 'delete');
INSERT INTO `tb_permission` VALUES ('4', 'update');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色',
  `role_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` int(11) DEFAULT '1' COMMENT '状态 0. 不可用；1.可用',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', 'admin', '管理员', '2020-12-23 15:15:07', '1');
INSERT INTO `tb_role` VALUES ('2', 'user', '普通用户', '2020-12-23 15:15:15', '1');

-- ----------------------------
-- Table structure for tb_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_menu`;
CREATE TABLE `tb_role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_role_menu
-- ----------------------------
INSERT INTO `tb_role_menu` VALUES ('1', '1');
INSERT INTO `tb_role_menu` VALUES ('1', '2');
INSERT INTO `tb_role_menu` VALUES ('1', '3');
INSERT INTO `tb_role_menu` VALUES ('1', '4');
INSERT INTO `tb_role_menu` VALUES ('2', '3');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `phone` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电话号码',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `perms` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '123456789', '1', '2020-12-18 10:51:23', '1', 'edit');
INSERT INTO `tb_user` VALUES ('2', 'test', '21218cca77804d2ba1922c33e0151105', '12121212', '1', '2020-12-18 10:52:06', '1', 'query');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `permission_id` bigint(11) DEFAULT NULL COMMENT '全向id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户角色表';

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('1', '1', '1');
INSERT INTO `tb_user_role` VALUES ('1', '1', '2');
INSERT INTO `tb_user_role` VALUES ('1', '1', '3');
INSERT INTO `tb_user_role` VALUES ('1', '1', '4');
INSERT INTO `tb_user_role` VALUES ('1', '2', '2');
INSERT INTO `tb_user_role` VALUES ('1', '2', '4');
INSERT INTO `tb_user_role` VALUES ('2', '2', '2');
