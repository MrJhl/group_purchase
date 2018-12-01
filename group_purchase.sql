/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : group_purchase

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 01/12/2018 20:12:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `gender` tinyint(1) DEFAULT '0' COMMENT '0：男；1：女',
  `real_name` varchar(100) DEFAULT NULL,
  `user_status` tinyint(1) DEFAULT NULL COMMENT '0:未可用；1：可用',
  `user_type` tinyint(1) DEFAULT NULL COMMENT '0：超级管理员；1：店长；',
  `create_time` timestamp NULL DEFAULT NULL,
  `last_edit_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Table structure for tb_free_bill
-- ----------------------------
DROP TABLE IF EXISTS `tb_free_bill`;
CREATE TABLE `tb_free_bill` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `order_id` int(20) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_edit_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='免单表';

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `describe` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `standard` varchar(50) DEFAULT NULL COMMENT '商品规格',
  `price` decimal(10,2) NOT NULL COMMENT '商品价格',
  `index` int(10) DEFAULT NULL COMMENT '排列顺序',
  `create_time` timestamp NULL DEFAULT NULL,
  `last_edit_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Table structure for tb_goods_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods_order`;
CREATE TABLE `tb_goods_order` (
  `goods_id` int(20) NOT NULL,
  `order_id` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单与商品关联表';

-- ----------------------------
-- Table structure for tb_media
-- ----------------------------
DROP TABLE IF EXISTS `tb_media`;
CREATE TABLE `tb_media` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) NOT NULL COMMENT '多媒体路径',
  `type` tinyint(1) DEFAULT NULL COMMENT '0：图片；1：音频；2：视频',
  `common_id` int(20) DEFAULT NULL COMMENT '通用id',
  `table` int(10) DEFAULT NULL COMMENT '0：商品表；1：套餐表',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_edit_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='多媒体表';

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `number` varchar(20) NOT NULL,
  `set_id` int(20) NOT NULL COMMENT '套餐id',
  `user_id` int(50) NOT NULL COMMENT '用户id',
  `shop_id` int(10) NOT NULL COMMENT '店铺id',
  `total` int(20) NOT NULL COMMENT '数量',
  `status` tinyint(1) DEFAULT NULL COMMENT '支付状态：0：未支付；1：已支付；2：已收货',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_edit_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Table structure for tb_set
-- ----------------------------
DROP TABLE IF EXISTS `tb_set`;
CREATE TABLE `tb_set` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '套餐名',
  `describe` varchar(200) DEFAULT NULL COMMENT '描述',
  `price` decimal(10,2) NOT NULL COMMENT '价格',
  `total` int(50) DEFAULT NULL COMMENT '已买数量',
  `start_time` timestamp NULL DEFAULT NULL COMMENT '团购开始时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '团购结束时间',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_edit_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='套餐表';

-- ----------------------------
-- Table structure for tb_shop
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop`;
CREATE TABLE `tb_shop` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `num` varchar(0) NOT NULL COMMENT '编号',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮件',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_edit_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺表';

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` tinyint(1) DEFAULT '0',
  `phone` varchar(15) DEFAULT NULL,
  `address` varchar(125) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `last_edit_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for tb_user_shop
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_shop`;
CREATE TABLE `tb_user_shop` (
  `user_id` int(20) NOT NULL,
  `shop_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与店铺关联表';

SET FOREIGN_KEY_CHECKS = 1;
