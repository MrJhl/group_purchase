/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 39.108.235.163:3306
 Source Schema         : group_purchase

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 03/01/2019 20:51:27
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
  `shop_id` int(20) DEFAULT NULL COMMENT '店铺id',
  `create_time` timestamp NULL DEFAULT NULL,
  `last_edit_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
BEGIN;
INSERT INTO `tb_admin` VALUES (1, 'admin', 'H10QGN3949IQ59QIIH56H057I20I883H', '13813999999', '1240364839@qq.com', 1, '管理员', 1, 0, NULL, '2018-12-04 23:03:50', '2018-12-04 23:03:50');
COMMIT;

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
  `sale_price` decimal(10,2) DEFAULT NULL COMMENT '商品售价',
  `set_id` int(100) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `last_edit_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
BEGIN;
INSERT INTO `tb_goods` VALUES (1, '棒棒糖', '不好吃不要钱', '1支', 15.00, NULL, NULL, NULL);
INSERT INTO `tb_goods` VALUES (2, '小套餐001', '这是包含5种棒棒糖的小套餐', '1箱', 240.36, 1, '2018-12-09 03:22:13', '2018-12-09 03:22:14');
INSERT INTO `tb_goods` VALUES (3, '小套餐001', '这是包含5种棒棒糖的小套餐', '1箱', 240.36, 1, '2018-12-09 03:27:40', '2018-12-09 03:27:42');
INSERT INTO `tb_goods` VALUES (4, '棒棒糖小套餐001', '这是属于棒棒糖大套餐中的一种小套餐', '1箱', 150.00, 1, '2018-12-10 20:07:07', '2018-12-10 20:07:07');
INSERT INTO `tb_goods` VALUES (5, '棒棒糖小套餐001', '这是属于棒棒糖大套餐中的一种小套餐', '1箱', 150.00, 1, '2018-12-10 20:42:41', '2018-12-10 20:42:41');
COMMIT;

-- ----------------------------
-- Table structure for tb_goods_media
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods_media`;
CREATE TABLE `tb_goods_media` (
  `goods_id` int(11) NOT NULL,
  `media_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_goods_media
-- ----------------------------
BEGIN;
INSERT INTO `tb_goods_media` VALUES (3, 15);
INSERT INTO `tb_goods_media` VALUES (3, 16);
INSERT INTO `tb_goods_media` VALUES (3, 11);
INSERT INTO `tb_goods_media` VALUES (4, 12);
INSERT INTO `tb_goods_media` VALUES (4, 13);
INSERT INTO `tb_goods_media` VALUES (4, 14);
INSERT INTO `tb_goods_media` VALUES (5, 11);
INSERT INTO `tb_goods_media` VALUES (5, 12);
INSERT INTO `tb_goods_media` VALUES (5, 13);
INSERT INTO `tb_goods_media` VALUES (5, 14);
COMMIT;

-- ----------------------------
-- Table structure for tb_media
-- ----------------------------
DROP TABLE IF EXISTS `tb_media`;
CREATE TABLE `tb_media` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) NOT NULL COMMENT '多媒体路径',
  `type` tinyint(1) DEFAULT NULL COMMENT '0：图片；1：音频；2：视频',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_edit_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='多媒体表';

-- ----------------------------
-- Records of tb_media
-- ----------------------------
BEGIN;
INSERT INTO `tb_media` VALUES (1, 'C:\\Users\\ASUS\\git\\group_purchase\\target\\classes\\static\\images\\upload/9656f4cb8e664376905a52253dc246bf.jpg', 0, '2018-12-07 01:59:45', '2018-12-07 01:59:45');
INSERT INTO `tb_media` VALUES (2, 'C:\\Users\\ASUS\\git\\group_purchase\\target\\classes\\static\\images\\upload/4f9624c269314128b97ad7f36ff9b322.jpg', 0, '2018-12-07 01:59:45', '2018-12-07 01:59:45');
INSERT INTO `tb_media` VALUES (3, 'C:\\Users\\ASUS\\git\\group_purchase\\target\\classes\\static\\images\\upload/dbebbc19c58d4a38a268446126e05c14.jpg', 0, '2018-12-07 01:59:45', '2018-12-07 01:59:45');
INSERT INTO `tb_media` VALUES (4, 'C:\\Users\\ASUS\\git\\group_purchase\\target\\classes\\static\\images\\upload/6c9b090043d2409d856332ba1504d16c.jpg', 0, '2018-12-07 01:59:45', '2018-12-07 01:59:45');
INSERT INTO `tb_media` VALUES (5, 'C:\\Users\\ASUS\\git\\group_purchase\\target\\classes\\static\\images\\upload/929684cbd88a4f1a8b8920f418445056.jpg', 0, '2018-12-07 01:59:45', '2018-12-07 01:59:45');
INSERT INTO `tb_media` VALUES (6, 'C:\\Users\\ASUS\\git\\group_purchase\\target\\classes\\static\\images\\upload/59af42fa96e84f34b0dc82d75aebf19b.jpg', 0, '2018-12-07 02:00:40', '2018-12-07 02:00:40');
INSERT INTO `tb_media` VALUES (7, 'C:\\Users\\ASUS\\git\\group_purchase\\target\\classes\\static\\images\\upload/1af93f116fa64be7858431ad2ff02a07.jpg', 0, '2018-12-07 02:00:40', '2018-12-07 02:00:40');
INSERT INTO `tb_media` VALUES (8, 'C:\\Users\\ASUS\\git\\group_purchase\\target\\classes\\static\\images\\upload/e4b174a5a9ce436e98ede8ad195e5422.jpg', 0, '2018-12-07 02:00:40', '2018-12-07 02:00:40');
INSERT INTO `tb_media` VALUES (9, 'C:\\Users\\ASUS\\git\\group_purchase\\target\\classes\\static\\images\\upload/f652abaf5105413da5e2ca5d6b628e6c.jpg', 0, '2018-12-07 02:00:40', '2018-12-07 02:00:40');
INSERT INTO `tb_media` VALUES (10, 'C:\\Users\\ASUS\\git\\group_purchase\\target\\classes\\static\\images\\upload/3bf7aa51db1e4919956d109c5b1707aa.jpg', 0, '2018-12-07 02:00:40', '2018-12-07 02:00:40');
INSERT INTO `tb_media` VALUES (11, 'C:\\Users\\Administrator\\git\\group_purchase\\target\\classes\\static\\images\\upload/bf77d60bacaf494098a447d213228908.PNG', 0, '2018-12-08 06:46:04', '2018-12-08 06:46:04');
INSERT INTO `tb_media` VALUES (12, 'C:\\Users\\Administrator\\git\\group_purchase\\static\\images\\upload/3740b8761c884f55ad2c4476c851cdb3.PNG', 0, '2018-12-08 06:50:36', '2018-12-08 06:50:36');
INSERT INTO `tb_media` VALUES (13, 'static/images/upload/94bddac5484c4a4cacb46a03f659c63c.PNG', 0, '2018-12-08 06:51:09', '2018-12-08 06:51:09');
INSERT INTO `tb_media` VALUES (14, 'static/images/upload/5186c5b5662e4be69f7a3db35611dcc4.PNG', 0, '2018-12-08 06:53:13', '2018-12-08 06:53:13');
INSERT INTO `tb_media` VALUES (15, 'static/images/upload/c46d22cd736946ce9a254eb154ea7499.jpg', 0, '2018-12-08 07:01:48', '2018-12-08 07:01:48');
INSERT INTO `tb_media` VALUES (16, 'static/images/upload/51bd3e71dabf46d3a577bde0336cb038.jpg', 0, '2018-12-08 07:01:48', '2018-12-08 07:01:48');
INSERT INTO `tb_media` VALUES (17, 'static/images/upload/90a2d550cb954a298f5c16b972d86d47.jpg', 0, '2018-12-08 07:01:48', '2018-12-08 07:01:48');
INSERT INTO `tb_media` VALUES (18, 'static/images/upload/62f531666f66401686f3fbd594e8f5ee.jpg', 0, '2018-12-08 07:01:48', '2018-12-08 07:01:48');
INSERT INTO `tb_media` VALUES (19, 'static/images/upload/7bf74ab61d5546c7b9495e871453b848.png', 0, '2018-12-08 09:53:57', '2018-12-08 09:53:57');
INSERT INTO `tb_media` VALUES (20, 'static/images/upload/4f8203b59bfc49bc97ceb24f27755944.png', 0, '2018-12-08 09:58:04', '2018-12-08 09:58:04');
INSERT INTO `tb_media` VALUES (21, 'static/images/upload/cfe2baef35cd4f60864e1b69769de91f.png', 0, '2018-12-10 06:19:55', '2018-12-10 06:19:55');
INSERT INTO `tb_media` VALUES (22, '4d11766ce04f46939a405b7e3ad799d4.jpg', 0, '2018-12-14 00:07:41', '2018-12-14 00:07:41');
INSERT INTO `tb_media` VALUES (23, '8dba7a1e48fb47a6bb149bbba5706048.jpg', 0, '2018-12-14 00:07:41', '2018-12-14 00:07:41');
INSERT INTO `tb_media` VALUES (24, '0179649761d6405d91729cafc6cbe458.jpg', 0, '2018-12-14 00:07:41', '2018-12-14 00:07:41');
INSERT INTO `tb_media` VALUES (25, 'c48cb275068944e7bd130cf787232b6c.jpg', 0, '2018-12-14 00:07:41', '2018-12-14 00:07:41');
INSERT INTO `tb_media` VALUES (26, 'd84b6b4140f345e0a7eb43e36cbff2e3.jpg', 0, '2018-12-14 00:07:41', '2018-12-14 00:07:41');
INSERT INTO `tb_media` VALUES (27, '28c1bb17caf94bc2ad5bffb277ed2707.jpg', 0, '2018-12-14 00:10:18', '2018-12-14 00:10:18');
INSERT INTO `tb_media` VALUES (28, 'b1439ca3f8c84ebb99626224c238d2e8.jpg', 0, '2018-12-14 00:10:18', '2018-12-14 00:10:18');
INSERT INTO `tb_media` VALUES (29, '410a2c7a922349488ea58cd86dc71d1e.jpg', 0, '2018-12-14 00:10:18', '2018-12-14 00:10:18');
INSERT INTO `tb_media` VALUES (30, 'b5e3fe5f8630422c8a847a91878764dc.jpg', 0, '2018-12-14 00:10:18', '2018-12-14 00:10:18');
INSERT INTO `tb_media` VALUES (31, '9abb64a2f1294508af7966073c860876.jpg', 0, '2018-12-14 00:10:18', '2018-12-14 00:10:18');
INSERT INTO `tb_media` VALUES (32, 'f01dad3a3396425b8c1dbbe33ce56c45.jpg', 0, '2018-12-14 00:14:10', '2018-12-14 00:14:10');
INSERT INTO `tb_media` VALUES (33, 'ac7fe4ed29fb4a9c83a9bdcbf5e6bf41.jpg', 0, '2018-12-14 00:14:10', '2018-12-14 00:14:10');
INSERT INTO `tb_media` VALUES (34, '0e312c73d70b4bedbeeb0724fc1b2127.jpg', 0, '2018-12-14 00:14:10', '2018-12-14 00:14:10');
INSERT INTO `tb_media` VALUES (35, '8334eee0c60f48f8813d101f60a7edfa.jpg', 0, '2018-12-14 00:14:10', '2018-12-14 00:14:10');
INSERT INTO `tb_media` VALUES (36, '46ab8923f23e4a7682f589fc90b087ea.jpg', 0, '2018-12-14 00:14:10', '2018-12-14 00:14:10');
INSERT INTO `tb_media` VALUES (37, 'd650f2e5a90748d5b2f602b1fb001392.jpg', 0, '2018-12-14 00:19:36', '2018-12-14 00:19:36');
INSERT INTO `tb_media` VALUES (38, '82059656336d4887a3e34882f8e1c6a1.jpg', 0, '2018-12-14 00:19:36', '2018-12-14 00:19:36');
INSERT INTO `tb_media` VALUES (39, 'f9c05e1e56174bbea69c958ec45995b8.jpg', 0, '2018-12-14 00:19:36', '2018-12-14 00:19:36');
INSERT INTO `tb_media` VALUES (40, '1123f7690e8a41bc84c5fd3f8254d4bd.jpg', 0, '2018-12-14 00:19:36', '2018-12-14 00:19:36');
INSERT INTO `tb_media` VALUES (41, '180decf2eebf4ac08d5c3120829978dc.jpg', 0, '2018-12-14 00:19:36', '2018-12-14 00:19:36');
INSERT INTO `tb_media` VALUES (42, '6de73f3addfe413b828ad4adc32667d0.jpg', 0, '2018-12-14 00:19:44', '2018-12-14 00:19:44');
INSERT INTO `tb_media` VALUES (43, '09910198a56247a7aacbf0d789d2a5b8.jpg', 0, '2018-12-14 00:19:44', '2018-12-14 00:19:44');
INSERT INTO `tb_media` VALUES (44, 'f99a1bffd4ae4eebab287220b14d03e8.jpg', 0, '2018-12-14 00:19:44', '2018-12-14 00:19:44');
INSERT INTO `tb_media` VALUES (45, '55fa2f69d32c49deb17038c189319f97.jpg', 0, '2018-12-14 00:19:44', '2018-12-14 00:19:44');
INSERT INTO `tb_media` VALUES (46, '6c1e1bb54f514fe4b29ed1d545d356cb.jpg', 0, '2018-12-14 00:19:44', '2018-12-14 00:19:44');
INSERT INTO `tb_media` VALUES (47, '99798cbfbc19460fbe9a85728c6ed281.jpg', 0, '2018-12-14 00:19:52', '2018-12-14 00:19:52');
INSERT INTO `tb_media` VALUES (48, 'ff0d23432e354309a5584b7f2bfeb476.jpg', 0, '2018-12-14 00:19:52', '2018-12-14 00:19:52');
INSERT INTO `tb_media` VALUES (49, '7bad7d73eea9447abac516994d741d27.jpg', 0, '2018-12-14 00:19:52', '2018-12-14 00:19:52');
INSERT INTO `tb_media` VALUES (50, '70a4fd83dcf84a32bacdfb991378ecca.jpg', 0, '2018-12-14 00:19:52', '2018-12-14 00:19:52');
INSERT INTO `tb_media` VALUES (51, '96f90f7c1bb049fbbbaf83af96bb00d1.jpg', 0, '2018-12-14 00:19:52', '2018-12-14 00:19:52');
INSERT INTO `tb_media` VALUES (52, '3af333e18a064a4aa26fc3fe5978303e.jpg', 0, '2018-12-14 00:23:25', '2018-12-14 00:23:25');
INSERT INTO `tb_media` VALUES (53, '1968b4cc1d294ae9a609dd3d9267704f.jpg', 0, '2018-12-14 00:23:25', '2018-12-14 00:23:25');
INSERT INTO `tb_media` VALUES (54, '2ccd5f98c1f341ac8630a85bc7297afd.jpg', 0, '2018-12-14 00:23:25', '2018-12-14 00:23:25');
INSERT INTO `tb_media` VALUES (55, 'ba398e0290f64a77a9f2c2a081aadd1c.jpg', 0, '2018-12-14 00:23:25', '2018-12-14 00:23:25');
INSERT INTO `tb_media` VALUES (56, 'e644a5b22782490698b7d7adc18ef35e.jpg', 0, '2018-12-14 00:23:25', '2018-12-14 00:23:25');
INSERT INTO `tb_media` VALUES (57, '57dddad0af494bb4bc5559aee0f1113b.jpg', 0, '2018-12-14 00:25:07', '2018-12-14 00:25:07');
INSERT INTO `tb_media` VALUES (58, 'e93370b77d0d496c9a4879149fd5c3f8.jpg', 0, '2018-12-14 00:25:07', '2018-12-14 00:25:07');
INSERT INTO `tb_media` VALUES (59, 'faeafb042dec4ff58605f2731f0bcb2f.jpg', 0, '2018-12-14 00:25:07', '2018-12-14 00:25:07');
INSERT INTO `tb_media` VALUES (60, 'ba16e7412b514dde9672797d9ebf513f.jpg', 0, '2018-12-14 00:25:07', '2018-12-14 00:25:07');
INSERT INTO `tb_media` VALUES (61, '57ed5d000c604ec1a324de3fd5cd9b79.jpg', 0, '2018-12-14 00:25:07', '2018-12-14 00:25:07');
INSERT INTO `tb_media` VALUES (62, '74bf17a987054b5a8a0fe4231ca46b07.jpg', 0, '2018-12-14 00:27:40', '2018-12-14 00:27:40');
INSERT INTO `tb_media` VALUES (63, '3b754d7f88ea412fbc246fcf1c13602d.jpg', 0, '2018-12-14 00:27:40', '2018-12-14 00:27:40');
INSERT INTO `tb_media` VALUES (64, '1070ead4e0814c5d8cda9a91e0fe0fa2.jpg', 0, '2018-12-14 00:27:40', '2018-12-14 00:27:40');
INSERT INTO `tb_media` VALUES (65, '6102cbf02a214e319c73232d53b59d5f.jpg', 0, '2018-12-14 00:27:40', '2018-12-14 00:27:40');
INSERT INTO `tb_media` VALUES (66, '06725cd8decc4ba6bc1b0ffbb376803b.jpg', 0, '2018-12-14 00:27:40', '2018-12-14 00:27:40');
COMMIT;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `number` varchar(20) NOT NULL,
  `goods_id` int(20) NOT NULL COMMENT '套餐id',
  `user_id` int(50) NOT NULL COMMENT '用户id',
  `shop_id` int(10) NOT NULL COMMENT '店铺id',
  `total` int(20) NOT NULL COMMENT '数量',
  `status` tinyint(1) DEFAULT NULL COMMENT '支付状态：0：未支付；1：已支付；2：已收货',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_edit_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of tb_order
-- ----------------------------
BEGIN;
INSERT INTO `tb_order` VALUES ('A0001', 1, 1, 1, 2, 1, '修改状态', '2018-12-11 14:25:08', '2018-12-10 21:47:39');
INSERT INTO `tb_order` VALUES ('A0002', 1, 1, 1, 1, 0, NULL, '2018-12-10 21:49:03', '2018-12-10 21:49:03');
INSERT INTO `tb_order` VALUES ('A0003', 1, 1, 1, 1, 0, '备注信息', '2018-12-10 22:15:10', '2018-12-10 22:15:10');
COMMIT;

-- ----------------------------
-- Table structure for tb_order_set_shop
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_set_shop`;
CREATE TABLE `tb_order_set_shop` (
  `set_id` int(20) NOT NULL,
  `order_id` int(20) DEFAULT NULL,
  `shop_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单与商品关联表';

-- ----------------------------
-- Table structure for tb_set
-- ----------------------------
DROP TABLE IF EXISTS `tb_set`;
CREATE TABLE `tb_set` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '套餐名',
  `describe` varchar(200) DEFAULT NULL COMMENT '描述',
  `sale_price` decimal(10,2) NOT NULL COMMENT '团购价格',
  `price` decimal(10,2) NOT NULL COMMENT '价格',
  `total` int(50) DEFAULT NULL COMMENT '已买数量',
  `index` int(10) DEFAULT NULL COMMENT '排列顺序',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_edit_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='套餐表';

-- ----------------------------
-- Records of tb_set
-- ----------------------------
BEGIN;
INSERT INTO `tb_set` VALUES (1, '套餐1', '棒棒糖套餐', 1500.00, 1000.00, 0, NULL, '2018-12-07 01:59:45', '2018-12-07 01:59:45');
INSERT INTO `tb_set` VALUES (2, '套餐1', '棒棒糖套餐', 1500.00, 1000.00, 0, NULL, '2018-12-07 02:00:40', '2018-12-07 02:00:40');
INSERT INTO `tb_set` VALUES (3, '套餐1', '棒棒糖套餐', 1500.00, 1000.00, 0, NULL, '2018-12-08 07:36:53', '2018-12-08 07:36:54');
INSERT INTO `tb_set` VALUES (4, '套餐1', '棒棒糖', 1500.00, 1000.00, 0, NULL, '2018-12-08 08:15:58', '2018-12-08 08:15:58');
INSERT INTO `tb_set` VALUES (5, '套餐1', '棒棒糖套餐', 15001.00, 10001.00, 0, NULL, '2018-12-08 08:17:07', '2018-12-08 08:17:07');
INSERT INTO `tb_set` VALUES (6, '套餐1', '棒棒糖套餐', 15001.00, 10001.00, 0, NULL, '2018-12-08 09:52:34', '2018-12-08 09:52:34');
INSERT INTO `tb_set` VALUES (7, '套餐1', '棒棒糖套餐', 15001.00, 10001.00, 0, NULL, '2018-12-09 03:47:51', '2018-12-09 03:47:51');
INSERT INTO `tb_set` VALUES (8, '套餐1', '棒棒糖套餐', 15001.00, 10001.00, 0, NULL, '2018-12-09 03:48:45', '2018-12-09 03:48:45');
INSERT INTO `tb_set` VALUES (9, '套餐1', '棒棒糖套餐', 15001.00, 10001.00, 0, NULL, '2018-12-09 03:50:28', '2018-12-09 03:50:28');
INSERT INTO `tb_set` VALUES (10, '套餐1', '棒棒糖套餐', 15001.00, 10001.00, 0, NULL, '2018-12-10 07:58:38', '2018-12-10 07:58:38');
INSERT INTO `tb_set` VALUES (11, '套餐1', '棒棒糖套餐', 15001.00, 10001.00, 0, NULL, '2018-12-10 08:04:10', '2018-12-10 08:04:10');
INSERT INTO `tb_set` VALUES (12, '套餐1', '棒棒糖套餐', 15001.00, 10001.00, 0, NULL, '2018-12-10 08:06:11', '2018-12-10 08:06:11');
INSERT INTO `tb_set` VALUES (13, '套餐1', '棒棒糖套餐', 15001.00, 10001.00, 0, NULL, '2018-12-10 19:38:00', '2018-12-10 19:38:00');
INSERT INTO `tb_set` VALUES (14, '套餐1', '棒棒糖套餐', 15001.00, 10001.00, 0, NULL, '2018-12-10 19:52:28', '2018-12-10 19:52:28');
INSERT INTO `tb_set` VALUES (15, '套餐1', '棒棒糖套餐', 15001.00, 10001.00, 0, NULL, '2018-12-10 19:59:17', '2018-12-10 19:59:17');
COMMIT;

-- ----------------------------
-- Table structure for tb_set_media
-- ----------------------------
DROP TABLE IF EXISTS `tb_set_media`;
CREATE TABLE `tb_set_media` (
  `set_id` int(11) NOT NULL,
  `media_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_set_media
-- ----------------------------
BEGIN;
INSERT INTO `tb_set_media` VALUES (1, 1);
INSERT INTO `tb_set_media` VALUES (1, 2);
INSERT INTO `tb_set_media` VALUES (1, 3);
INSERT INTO `tb_set_media` VALUES (1, 4);
INSERT INTO `tb_set_media` VALUES (1, 5);
INSERT INTO `tb_set_media` VALUES (2, 6);
INSERT INTO `tb_set_media` VALUES (2, 7);
INSERT INTO `tb_set_media` VALUES (2, 8);
INSERT INTO `tb_set_media` VALUES (2, 9);
INSERT INTO `tb_set_media` VALUES (2, 10);
INSERT INTO `tb_set_media` VALUES (15, 3);
INSERT INTO `tb_set_media` VALUES (16, 3);
INSERT INTO `tb_set_media` VALUES (17, 3);
INSERT INTO `tb_set_media` VALUES (18, 3);
INSERT INTO `tb_set_media` VALUES (15, 4);
INSERT INTO `tb_set_media` VALUES (16, 4);
INSERT INTO `tb_set_media` VALUES (17, 4);
INSERT INTO `tb_set_media` VALUES (18, 4);
INSERT INTO `tb_set_media` VALUES (15, 5);
INSERT INTO `tb_set_media` VALUES (16, 5);
INSERT INTO `tb_set_media` VALUES (17, 5);
INSERT INTO `tb_set_media` VALUES (18, 5);
INSERT INTO `tb_set_media` VALUES (15, 6);
INSERT INTO `tb_set_media` VALUES (16, 6);
INSERT INTO `tb_set_media` VALUES (17, 6);
INSERT INTO `tb_set_media` VALUES (18, 6);
INSERT INTO `tb_set_media` VALUES (15, 7);
INSERT INTO `tb_set_media` VALUES (16, 7);
INSERT INTO `tb_set_media` VALUES (17, 7);
INSERT INTO `tb_set_media` VALUES (18, 7);
INSERT INTO `tb_set_media` VALUES (15, 8);
INSERT INTO `tb_set_media` VALUES (16, 8);
INSERT INTO `tb_set_media` VALUES (17, 8);
INSERT INTO `tb_set_media` VALUES (18, 8);
INSERT INTO `tb_set_media` VALUES (15, 9);
INSERT INTO `tb_set_media` VALUES (16, 9);
INSERT INTO `tb_set_media` VALUES (17, 9);
INSERT INTO `tb_set_media` VALUES (18, 9);
INSERT INTO `tb_set_media` VALUES (15, 10);
INSERT INTO `tb_set_media` VALUES (16, 10);
INSERT INTO `tb_set_media` VALUES (17, 10);
INSERT INTO `tb_set_media` VALUES (18, 10);
INSERT INTO `tb_set_media` VALUES (15, 11);
INSERT INTO `tb_set_media` VALUES (16, 11);
INSERT INTO `tb_set_media` VALUES (17, 11);
INSERT INTO `tb_set_media` VALUES (18, 11);
INSERT INTO `tb_set_media` VALUES (15, 12);
INSERT INTO `tb_set_media` VALUES (16, 12);
INSERT INTO `tb_set_media` VALUES (17, 12);
INSERT INTO `tb_set_media` VALUES (18, 12);
INSERT INTO `tb_set_media` VALUES (15, 13);
INSERT INTO `tb_set_media` VALUES (16, 13);
INSERT INTO `tb_set_media` VALUES (17, 13);
INSERT INTO `tb_set_media` VALUES (18, 13);
INSERT INTO `tb_set_media` VALUES (15, 14);
INSERT INTO `tb_set_media` VALUES (16, 14);
INSERT INTO `tb_set_media` VALUES (17, 14);
INSERT INTO `tb_set_media` VALUES (18, 14);
COMMIT;

-- ----------------------------
-- Table structure for tb_shop
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop`;
CREATE TABLE `tb_shop` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `num` varchar(0) NOT NULL COMMENT '编号',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `phone` varchar(15) DEFAULT NULL COMMENT '手机',
  `email` varchar(20) DEFAULT NULL COMMENT '邮件',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_edit_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺表';

-- ----------------------------
-- Table structure for tb_shop_set
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop_set`;
CREATE TABLE `tb_shop_set` (
  `shop_id` int(11) NOT NULL,
  `set_id` int(11) DEFAULT NULL,
  `start_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_shop_set
-- ----------------------------
BEGIN;
INSERT INTO `tb_shop_set` VALUES (1, 1, NULL, NULL);
INSERT INTO `tb_shop_set` VALUES (1, 2, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `gender` tinyint(1) DEFAULT '0',
  `phone` varchar(15) DEFAULT NULL,
  `address` varchar(125) DEFAULT NULL,
  `photo` varchar(200) DEFAULT NULL,
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
