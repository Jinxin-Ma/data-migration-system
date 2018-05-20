/*
Navicat MySQL Data Transfer

Source Server         : qCloud
Source Server Version : 50628
Source Host           : 57b2e9bf1e5d0.sh.cdb.myqcloud.com:7695
Source Database       : springbatch

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2017-12-21 11:27:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_number` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '订单编号',
  `uid` bigint(20) DEFAULT NULL COMMENT '用户id',
  `pay_price` double(20,2) DEFAULT NULL COMMENT '支付价格',
  `is_pay` int(4) DEFAULT NULL COMMENT '是否支付：-1未支付，1支付',
  `pay_time` datetime(6) DEFAULT NULL COMMENT '支付时间',
  `is_ship` int(4) DEFAULT NULL COMMENT '是否收货：-1未收货，1已收货',
  `ship_time` datetime(6) DEFAULT NULL COMMENT '发货时间',
  `is_receipt` int(4) DEFAULT NULL COMMENT '是否已经发货：-1未发货，1已发货',
  `receipt_time` datetime(6) DEFAULT NULL COMMENT '收货时间',
  `ship_nmber` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '快递单号',
  `status` int(4) DEFAULT NULL COMMENT '订单状态:-1删除订单，1正常订单',
  `created` datetime(6) DEFAULT NULL COMMENT '创建时间',
  `modified` datetime(6) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `id` (`id`) USING BTREE COMMENT '主键索引',
  KEY `orderNum` (`id`,`order_number`) USING BTREE COMMENT 'id,order_number组合索引',
  KEY `uid` (`uid`) USING BTREE COMMENT '用户索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
