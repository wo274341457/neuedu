/*
Navicat MySQL Data Transfer

Source Server         : MYSQL5.7.17
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-01-18 16:51:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for s_comment
-- ----------------------------
DROP TABLE IF EXISTS `s_comment`;
CREATE TABLE `s_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) DEFAULT NULL COMMENT '用户id',
  `shop_id` int(11) DEFAULT NULL COMMENT '商品id',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_comment
-- ----------------------------
INSERT INTO `s_comment` VALUES ('1', '1', '1', '什么垃圾商品');

-- ----------------------------
-- Table structure for s_member
-- ----------------------------
DROP TABLE IF EXISTS `s_member`;
CREATE TABLE `s_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `money` int(255) DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_member
-- ----------------------------
INSERT INTO `s_member` VALUES ('1', 'zhangsan', '123456', '10000');

-- ----------------------------
-- Table structure for s_order
-- ----------------------------
DROP TABLE IF EXISTS `s_order`;
CREATE TABLE `s_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) DEFAULT NULL COMMENT '用户id',
  `shop_id` int(11) DEFAULT NULL COMMENT '商品id',
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_order
-- ----------------------------
INSERT INTO `s_order` VALUES ('2', '1', '1', '支付');

-- ----------------------------
-- Table structure for s_shop
-- ----------------------------
DROP TABLE IF EXISTS `s_shop`;
CREATE TABLE `s_shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '商品名',
  `price` int(11) DEFAULT NULL COMMENT '单价',
  `count` int(11) DEFAULT NULL COMMENT '库存',
  `type_id` int(11) DEFAULT NULL COMMENT '商品类型表的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_shop
-- ----------------------------
INSERT INTO `s_shop` VALUES ('1', '耐克女装上衣', '200', '199', '1');
INSERT INTO `s_shop` VALUES ('2', '阿迪女装上衣', '200', '200', '1');
INSERT INTO `s_shop` VALUES ('3', '特步男装上衣', '150', '300', '2');
INSERT INTO `s_shop` VALUES ('4', '优衣库男装裤子', '150', '500', '2');

-- ----------------------------
-- Table structure for s_shop_type
-- ----------------------------
DROP TABLE IF EXISTS `s_shop_type`;
CREATE TABLE `s_shop_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '商品类别名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_shop_type
-- ----------------------------
INSERT INTO `s_shop_type` VALUES ('1', '女装');
INSERT INTO `s_shop_type` VALUES ('2', '男装');

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
