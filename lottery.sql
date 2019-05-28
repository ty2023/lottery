/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50635
 Source Host           : localhost:3306
 Source Schema         : lottery

 Target Server Type    : MySQL
 Target Server Version : 50635
 File Encoding         : 65001

 Date: 28/05/2019 21:50:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类别编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名',
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别描述',
  `num_sum` int(10) NULL DEFAULT NULL COMMENT '该类彩票总量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES (1, '即开型彩票', '好玩', 500);
INSERT INTO `t_category` VALUES (2, '传统型彩票', '好看', 500);
INSERT INTO `t_category` VALUES (3, '乐透型彩票', '好看又好玩', 500);

-- ----------------------------
-- Table structure for t_lottery
-- ----------------------------
DROP TABLE IF EXISTS `t_lottery`;
CREATE TABLE `t_lottery`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '彩票编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '彩票名字',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '彩票价格',
  `cate_id` int(11) NULL DEFAULT NULL COMMENT '所属类别',
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '彩票描述',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  `lottery_nu` int(10) NULL DEFAULT NULL COMMENT '彩票库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_lottery
-- ----------------------------
INSERT INTO `t_lottery` VALUES (1, '时时彩', 19.00, 1, '好看好用', '2019-05-27 19:06:47', 500);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户电话',
  `qq` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户QQ',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户地址',
  `role` int(10) NULL DEFAULT 0 COMMENT '用户身份',
  `truename` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `sex` int(1) NULL DEFAULT NULL COMMENT '用户性别',
  `age` int(10) NULL DEFAULT NULL COMMENT '用户年龄',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '用户生日',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', '123', '2902992419@qq.com', '18173707896', '2902992419', '湖南长沙宁乡', 2, '牧尘', 1, 123, '2019-05-27 16:00:00');
INSERT INTO `t_user` VALUES (14, '苹果', NULL, '18173707896@163.com', '18173707891', '123456', '湖南长沙', 0, '喻杰', 0, 78, '2019-03-31 16:00:00');

SET FOREIGN_KEY_CHECKS = 1;
