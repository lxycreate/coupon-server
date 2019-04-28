/*
 Navicat MySQL Data Transfer

 Source Server         : 默认
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : taobao

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 28/04/2019 15:47:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` varchar(255) DEFAULT NULL COMMENT '商品ID',
  `platform_id` int(11) DEFAULT NULL COMMENT '平台ID',
  `seller_id` varchar(255) DEFAULT NULL COMMENT '店家ID',
  `goods_title` varchar(255) DEFAULT NULL COMMENT '商品标题',
  `goods_stitle` varchar(255) DEFAULT NULL COMMENT '商品短标题',
  `goods_pic` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `goods_url` varchar(255) DEFAULT NULL COMMENT '商品链接',
  `goods_intro` varchar(255) DEFAULT NULL COMMENT '商品简介',
  `goods_price` double(10,2) DEFAULT NULL COMMENT '商品价格',
  `goods_sale` int(255) DEFAULT NULL COMMENT '商品销量',
  `goods_cid` int(11) DEFAULT NULL COMMENT '商品目录ID',
  `commission_rate` double(255,0) DEFAULT NULL COMMENT '佣金比率',
  `commission_type` int(255) DEFAULT NULL COMMENT '佣金类型',
  `coupon_id` varchar(255) DEFAULT NULL COMMENT '优惠券ID',
  `coupon_url` varchar(255) DEFAULT NULL COMMENT '优惠券链接',
  `coupon_price` double(10,2) DEFAULT NULL COMMENT '优惠券面值',
  `after_coupon` double(255,0) DEFAULT NULL COMMENT '券后价',
  `coupon_condition` varchar(255) DEFAULT NULL COMMENT '满多少可用',
  `coupon_total` int(255) DEFAULT NULL COMMENT '优惠券总量',
  `coupon_rest` int(255) DEFAULT NULL COMMENT '优惠券剩余',
  `coupon_use` int(255) DEFAULT NULL COMMENT '已领取数量',
  `coupon_start` varchar(255) DEFAULT NULL COMMENT '优惠券开始时间',
  `coupon_end` varchar(255) DEFAULT NULL COMMENT '优惠券结束时间',
  `is_tmall` int(255) DEFAULT NULL COMMENT '是否天猫',
  `is_ju` int(255) DEFAULT NULL COMMENT '是否聚划算',
  `is_qiang` int(255) DEFAULT NULL COMMENT '是否淘抢购',
  `is_yun` int(255) DEFAULT NULL COMMENT '是否运费险',
  `is_gold` int(255) DEFAULT NULL COMMENT '是否金牌卖家',
  `is_ji` int(255) DEFAULT NULL COMMENT '是否极有家',
  `is_hai` int(255) DEFAULT NULL COMMENT '是否海淘',
  `dsr` double(255,0) DEFAULT NULL COMMENT '评分'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for goods_test
-- ----------------------------
DROP TABLE IF EXISTS `goods_test`;
CREATE TABLE `goods_test` (
  `goods_id` varchar(255) DEFAULT NULL COMMENT '商品ID',
  `platform_id` int(11) DEFAULT NULL COMMENT '平台ID',
  `seller_id` varchar(255) DEFAULT NULL COMMENT '店家ID',
  `goods_title` varchar(255) DEFAULT NULL COMMENT '商品标题',
  `goods_stitle` varchar(255) DEFAULT NULL COMMENT '商品短标题',
  `goods_pic` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `goods_url` varchar(255) DEFAULT NULL COMMENT '商品链接',
  `goods_intro` varchar(255) DEFAULT NULL COMMENT '商品简介',
  `goods_price` double(10,2) DEFAULT NULL COMMENT '商品价格',
  `goods_sale` int(255) DEFAULT NULL COMMENT '商品销量',
  `goods_cid` int(11) DEFAULT NULL COMMENT '商品目录ID',
  `commission_rate` double(255,0) DEFAULT NULL COMMENT '佣金比率',
  `commission_type` int(255) DEFAULT NULL COMMENT '佣金类型',
  `coupon_id` varchar(255) DEFAULT NULL COMMENT '优惠券ID',
  `coupon_url` varchar(255) DEFAULT NULL COMMENT '优惠券链接',
  `coupon_price` double(10,2) DEFAULT NULL COMMENT '优惠券面值',
  `after_coupon` double(255,0) DEFAULT NULL COMMENT '券后价',
  `coupon_condition` varchar(255) DEFAULT NULL COMMENT '满多少可用',
  `coupon_total` int(255) DEFAULT NULL COMMENT '优惠券总量',
  `coupon_rest` int(255) DEFAULT NULL COMMENT '优惠券剩余',
  `coupon_use` int(255) DEFAULT NULL COMMENT '已领取数量',
  `coupon_start` varchar(255) DEFAULT NULL COMMENT '优惠券开始时间',
  `coupon_end` varchar(255) DEFAULT NULL COMMENT '优惠券结束时间',
  `is_tmall` int(255) DEFAULT NULL COMMENT '是否天猫',
  `is_ju` int(255) DEFAULT NULL COMMENT '是否聚划算',
  `is_qiang` int(255) DEFAULT NULL COMMENT '是否淘抢购',
  `is_yun` int(255) DEFAULT NULL COMMENT '是否运费险',
  `is_gold` int(255) DEFAULT NULL COMMENT '是否金牌卖家',
  `is_ji` int(255) DEFAULT NULL COMMENT '是否极有家',
  `is_hai` int(255) DEFAULT NULL COMMENT '是否海淘',
  `dsr` double(255,0) DEFAULT NULL COMMENT '评分'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_type` varchar(255) DEFAULT NULL COMMENT '任务类型',
  `obj` varchar(255) DEFAULT NULL COMMENT '任务对象',
  `status` varchar(255) DEFAULT NULL COMMENT '任务状态',
  `code` varchar(255) DEFAULT NULL COMMENT '任务代码',
  `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `start_time` varchar(255) DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(255) DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
