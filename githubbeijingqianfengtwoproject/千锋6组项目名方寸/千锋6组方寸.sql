/*
Navicat MySQL Data Transfer

Source Server         : 联合项目
Source Server Version : 50724
Source Host           : qianfeng1.qfjava.cn:8300
Source Database       : hotelsix

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-12-10 21:15:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for qf_card
-- ----------------------------
DROP TABLE IF EXISTS `qf_card`;
CREATE TABLE `qf_card` (
  `card_id` int(11) NOT NULL AUTO_INCREMENT,
  `card_type` int(11) NOT NULL,
  `card_belongto_user` int(11) NOT NULL,
  `card_status` int(11) DEFAULT '0',
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qf_card
-- ----------------------------

-- ----------------------------
-- Table structure for qf_card_sample
-- ----------------------------
DROP TABLE IF EXISTS `qf_card_sample`;
CREATE TABLE `qf_card_sample` (
  `card_type` int(11) NOT NULL,
  `card_img` varchar(200) DEFAULT NULL,
  `card_price` decimal(10,0) NOT NULL,
  `card_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`card_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qf_card_sample
-- ----------------------------

-- ----------------------------
-- Table structure for qf_group
-- ----------------------------
DROP TABLE IF EXISTS `qf_group`;
CREATE TABLE `qf_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255) NOT NULL,
  `group_price` decimal(10,2) NOT NULL,
  `group_personnum` int(11) NOT NULL,
  `group_type` varchar(255) NOT NULL,
  `group_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qf_group
-- ----------------------------
INSERT INTO `qf_group` VALUES ('1', '小小野炊', '1000.00', '20', '烧烤,旅游', 'group1/M00/00/00/rB8xvlvo-NiAA2dzAABHs4-W3Fw610.jpg');
INSERT INTO `qf_group` VALUES ('2', '海岸', '10.00', '200', '野战,烧烤', 'group1/M00/00/00/rB8xvlvo9qSADMclAABHs4-W3Fw366.jpg');
INSERT INTO `qf_group` VALUES ('3', '黄柏山', '10.00', '200', '旅游,景点', 'group1/M00/00/00/rB8xvlvo-NiAA2dzAABHs4-W3Fw610.jpg');
INSERT INTO `qf_group` VALUES ('4', '黄金海岸', '10.19', '32', '冲浪,旅游', 'group1/M00/00/00/rB8xvlvo-NiAA2dzAABHs4-W3Fw610.jpg');

-- ----------------------------
-- Table structure for qf_group1
-- ----------------------------
DROP TABLE IF EXISTS `qf_group1`;
CREATE TABLE `qf_group1` (
  `id` int(11) NOT NULL,
  `group_name` varchar(255) DEFAULT NULL,
  `group_person` varchar(255) DEFAULT NULL,
  `group_city1` varchar(255) DEFAULT NULL,
  `group_city2` varchar(255) DEFAULT NULL,
  `group_city3` varchar(255) DEFAULT NULL,
  `group_city4` varchar(255) DEFAULT NULL,
  `group_tag1` varchar(255) DEFAULT NULL,
  `group_tag2` varchar(255) DEFAULT NULL,
  `group_tag3` varchar(255) CHARACTER SET latin7 DEFAULT NULL,
  `group_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qf_group1
-- ----------------------------

-- ----------------------------
-- Table structure for qf_group2
-- ----------------------------
DROP TABLE IF EXISTS `qf_group2`;
CREATE TABLE `qf_group2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255) DEFAULT NULL,
  `group_person` varchar(255) DEFAULT NULL,
  `group_city1` varchar(255) DEFAULT NULL,
  `group_city2` varchar(255) DEFAULT NULL,
  `group_city3` varchar(255) DEFAULT NULL,
  `group_city4` varchar(255) DEFAULT NULL,
  `group_tag1` varchar(255) DEFAULT NULL,
  `group_tag2` varchar(255) DEFAULT NULL,
  `group_tag3` varchar(255) DEFAULT NULL,
  `group_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `qf_group2_group_tag2_uindex` (`group_tag2`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qf_group2
-- ----------------------------
INSERT INTO `qf_group2` VALUES ('1', '黄山', '20-89', '黄山', '北京', '上海', '青岛', '烧烤', '好玩', '美食', '/group1/M00/00/00/rBA6i1wJNtSANin9AARLLtzQFaY031.jpg');
INSERT INTO `qf_group2` VALUES ('2', '莫干山', '90-99', '莫干山', '杭州', '余杭', '黄山', '泳池', '餐厅', '大保健', '/group1/M00/00/00/rBA6i1wJNtSANin9AARLLtzQFaY031.jpg');
INSERT INTO `qf_group2` VALUES ('3', '北道海', '30-99', '北道海', '杭州', '黄山', '烟台', '泳池', '快餐', '影像设备', '/group1/M00/00/00/rBA6i1wJNtSANin9AARLLtzQFaY031.jpg');
INSERT INTO `qf_group2` VALUES ('4', '稻城', '509-1000', '稻城', '南京', '重庆', '东莞', '按摩', 'KTV', '游艇', '/group1/M00/00/00/rBA6i1wJNpmAHo9dAAHXXBUiYuQ350.jpg');

-- ----------------------------
-- Table structure for qf_hotel
-- ----------------------------
DROP TABLE IF EXISTS `qf_hotel`;
CREATE TABLE `qf_hotel` (
  `hotel_id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(50) DEFAULT NULL,
  `hotel_msg` text,
  `hotel_price` double DEFAULT NULL,
  `hotel_type` varchar(50) DEFAULT NULL,
  `hotel_tag` varchar(50) DEFAULT NULL,
  `hotel_local` varchar(50) DEFAULT NULL,
  `hotel_img` varchar(255) DEFAULT NULL,
  `hotel_available_num` int(11) DEFAULT NULL,
  `hotel_city` int(11) DEFAULT NULL,
  PRIMARY KEY (`hotel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qf_hotel
-- ----------------------------
INSERT INTO `qf_hotel` VALUES ('1', '杭州隐竺别院', '雅趣', '89', '1', '海景,吃喝', '杭州', '[{\"files\":\"/group1/M00/00/00/rBA6i1wJMumAZXoIAALjGwGW_QM873.png\"},{\"files\":\"/group1/M00/00/00/rBA6i1wJMruAOYWIAAOCmsmKGF0848.png\"},{\"files\":\"/group1/M00/00/00/rBA6i1wJNpmAHo9dAAHXXBUiYuQ350.jpg\"}]', '100', '1');
INSERT INTO `qf_hotel` VALUES ('2', '北海道餐厅', '团建风标', '1299', '2', '冲浪,餐厅', '上海', '[{\"files\":\"/group1/M00/00/00/rBA6i1wJMw-AI7m9AALPr0ERoP0786.png\"},{\"files\":\"/group1/M00/00/00/rBA6i1wJNpmAHo9dAAHXXBUiYuQ350.jpg\"},{\"files\":\"/group1/M00/00/00/rBA6i1wJN-aAQJ5tAARYrIeZJbI670.jpg \"}]', '11', '2');
INSERT INTO `qf_hotel` VALUES ('3', '黄金海滩', '浪漫之夜', '324', '1', '海景,冲浪', '天津', '[{\"files\":\"/group1/M00/00/00/rBA6i1wKbzyAbacWAAmTz5yIDFo924.jpg\"},{\"files\":\"/group1/M00/00/00/rBA6i1wJNtSANin9AARLLtzQFaY031.jpg\"}][{\"files\":\"/group1/M00/00/00/rBA6i1wJN-aAQJ5tAARYrIeZJbI670.jpg \"}]', '33', '3');
INSERT INTO `qf_hotel` VALUES ('4', '皇冠大酒店', '古堡风格', '123', '1', '古典,雅致', '深圳', '[{\"files\":\"/group1/M00/00/00/rBA6i1wJNtSANin9AARLLtzQFaY031.jpg\"}]', '11', '4');
INSERT INTO `qf_hotel` VALUES ('6', '山水大酒店', '风情秀丽', '232', '1', '晴空,万里', '杭州', '[{\"files\":\"/group1/M00/00/00/rBA6i1wJNpmAHo9dAAHXXBUiYuQ350.jpg\"}]', '14', '4');
INSERT INTO `qf_hotel` VALUES ('7', '台州温岭碟来三舍', '高端大气', '489', '2', '档次,逼格', '北京', '[{\"files\":\"/group1/M00/00/00/rBA6i1wJN-aAQJ5tAARYrIeZJbI670.jpg \"}]', '15', '4');

-- ----------------------------
-- Table structure for qf_hotel_city
-- ----------------------------
DROP TABLE IF EXISTS `qf_hotel_city`;
CREATE TABLE `qf_hotel_city` (
  `id` varchar(20) DEFAULT NULL,
  `city_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='酒店所属城市';

-- ----------------------------
-- Records of qf_hotel_city
-- ----------------------------
INSERT INTO `qf_hotel_city` VALUES ('1', '北京');
INSERT INTO `qf_hotel_city` VALUES ('2', '上海');
INSERT INTO `qf_hotel_city` VALUES ('3', '天津');
INSERT INTO `qf_hotel_city` VALUES ('4', '深圳');

-- ----------------------------
-- Table structure for qf_hotel_type
-- ----------------------------
DROP TABLE IF EXISTS `qf_hotel_type`;
CREATE TABLE `qf_hotel_type` (
  `htype_id` varchar(3) NOT NULL,
  `htype_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`htype_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qf_hotel_type
-- ----------------------------
INSERT INTO `qf_hotel_type` VALUES ('1', '亲近大自然');
INSERT INTO `qf_hotel_type` VALUES ('2', '亲子主题房');
INSERT INTO `qf_hotel_type` VALUES ('3', '原生态果园');
INSERT INTO `qf_hotel_type` VALUES ('4', '亲子互动');
INSERT INTO `qf_hotel_type` VALUES ('5', '团建类型');

-- ----------------------------
-- Table structure for qf_order
-- ----------------------------
DROP TABLE IF EXISTS `qf_order`;
CREATE TABLE `qf_order` (
  `order_id` char(16) NOT NULL,
  `order_userid` int(11) NOT NULL,
  `order_itemid` int(11) NOT NULL,
  `order_itemType` int(11) NOT NULL,
  `order_quantity` int(11) NOT NULL,
  `order_price` decimal(10,2) NOT NULL,
  `order_date` datetime NOT NULL,
  `order_status` int(11) DEFAULT '0',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `qf_order_order_id_uindex` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qf_order
-- ----------------------------
INSERT INTO `qf_order` VALUES ('24kP5u6Uw1lRMq6Y', '1', '1', '0', '1', '0.01', '2018-12-08 00:46:38', '0');
INSERT INTO `qf_order` VALUES ('2HTKCCLBuriGbGH9', '1', '0', '0', '0', '0.00', '2018-11-12 15:41:11', '0');
INSERT INTO `qf_order` VALUES ('2ySQlEdwLe8j8i2i', '1', '1', '1', '0', '0.00', '2018-12-06 08:43:25', '0');
INSERT INTO `qf_order` VALUES ('5lBNGOkmsW7zUj5j', '1', '1', '1', '0', '0.00', '2018-12-06 08:41:03', '0');
INSERT INTO `qf_order` VALUES ('bbsItwcDG5O9vsN5', '1', '1', '0', '1', '0.01', '2018-12-06 09:11:23', '0');
INSERT INTO `qf_order` VALUES ('bnG2nWhxJuPzbbfc', '1', '1', '0', '1', '1.00', '2018-11-13 09:44:47', '0');
INSERT INTO `qf_order` VALUES ('DWc5tZt8WYMnzpb5', '1', '1', '0', '1', '0.01', '2018-12-06 09:12:12', '0');
INSERT INTO `qf_order` VALUES ('geapykdejHoPlehm', '1', '1', '1', '0', '0.00', '2018-12-06 09:09:37', '0');
INSERT INTO `qf_order` VALUES ('HJ6SnnCXmehhQG5G', '1', '1', '0', '1', '1.00', '2018-12-06 10:35:30', '0');
INSERT INTO `qf_order` VALUES ('HpnNx20Qdunww5ul', '1', '1', '0', '1', '0.01', '2018-12-08 00:45:42', '0');
INSERT INTO `qf_order` VALUES ('HS0IfshGniANCZ4v', '1', '1', '0', '1', '0.01', '2018-12-06 09:13:02', '0');
INSERT INTO `qf_order` VALUES ('JYZ6Oat5hPQchyHu', '1', '1', '0', '1', '0.01', '2018-12-06 09:32:44', '1');
INSERT INTO `qf_order` VALUES ('O4XW4u8GWWxCJb9n', '1', '1', '1', '0', '0.00', '2018-12-06 08:42:25', '0');
INSERT INTO `qf_order` VALUES ('pEBQlLBgyiS4pFly', '1', '1', '0', '0', '0.00', '2018-12-06 08:42:13', '0');
INSERT INTO `qf_order` VALUES ('PV2AxdAgvhzi5qej', '1', '1', '1', '0', '0.00', '2018-12-06 09:08:52', '0');
INSERT INTO `qf_order` VALUES ('pzgUQuEPnGOObyyB', '1', '1', '1', '0', '0.00', '2018-12-06 08:57:51', '0');
INSERT INTO `qf_order` VALUES ('TphuNeUpRRSANPWn', '1', '1', '0', '0', '0.00', '2018-12-06 08:57:59', '0');
INSERT INTO `qf_order` VALUES ('tqkPsjGyCIWunOiz', '1', '1', '1', '0', '0.00', '2018-12-06 08:48:29', '0');
INSERT INTO `qf_order` VALUES ('UNGJjny9CzMMBzLQ', '1', '1', '0', '1', '1.00', '2018-12-06 09:09:52', '0');
INSERT INTO `qf_order` VALUES ('w75bGlO0rgGdEMDv', '1', '1', '1', '0', '0.00', '2018-12-06 08:56:51', '0');
INSERT INTO `qf_order` VALUES ('W8VzQ5zdUGaeFERt', '1', '0', '0', '0', '0.00', '2018-11-12 15:40:47', '0');
INSERT INTO `qf_order` VALUES ('WBnvVjgMUuMd9ST9', '1', '1', '0', '1', '1.00', '2018-12-06 17:10:24', '0');
INSERT INTO `qf_order` VALUES ('We5BL79NkxVFElQ2', '1', '1', '0', '1', '1.00', '2018-12-06 17:09:43', '0');
INSERT INTO `qf_order` VALUES ('WYBWhUtdyoLik87h', '1', '1', '0', '1', '0.01', '2018-12-06 09:11:57', '1');
INSERT INTO `qf_order` VALUES ('x1mgNf0Gd2FtgAWh', '1', '1', '1', '0', '0.00', '2018-12-06 08:56:04', '0');
INSERT INTO `qf_order` VALUES ('YyogqxWr8MZNqnlR', '1', '1', '0', '1', '0.01', '2018-12-06 10:40:15', '0');

-- ----------------------------
-- Table structure for qf_user
-- ----------------------------
DROP TABLE IF EXISTS `qf_user`;
CREATE TABLE `qf_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_mobile` varchar(50) NOT NULL,
  `user_password` varchar(50) DEFAULT NULL,
  `user_nickname` varchar(50) DEFAULT '晨曦',
  `user_img` varchar(255) DEFAULT NULL,
  `user_identify` varchar(30) DEFAULT NULL,
  `user_salt` varchar(30) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT '方寸',
  `user_vip_status` int(11) DEFAULT '0',
  `user_vip_expire_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qf_user
-- ----------------------------
INSERT INTO `qf_user` VALUES ('1', '18434395466', null, null, '', null, null, null, '0', null);
INSERT INTO `qf_user` VALUES ('2', '14398776512', null, null, null, null, null, null, '0', null);
INSERT INTO `qf_user` VALUES ('3', '15656473543', null, null, null, null, null, null, '0', null);
INSERT INTO `qf_user` VALUES ('4', '13488695314', null, null, '/group1/M00/00/00/rBA6i1wKd8-AYJY7AANLIKP0iIE991.jpg', null, null, null, '0', null);
INSERT INTO `qf_user` VALUES ('5', '13488601342', null, null, '/group1/M00/00/00/rBA6i1wJOCKAFqM7AAZxM5YMnGs157.jpg', '李设计费雷克萨斯', null, null, '0', null);
INSERT INTO `qf_user` VALUES ('6', '14534352645', null, null, null, null, null, null, '0', null);
INSERT INTO `qf_user` VALUES ('7', '13488601487', null, null, null, null, null, null, '0', null);
INSERT INTO `qf_user` VALUES ('8', '15788776655', null, null, null, null, null, null, '0', null);
INSERT INTO `qf_user` VALUES ('9', '18714302271', null, null, null, null, null, null, '0', null);
INSERT INTO `qf_user` VALUES ('10', '18749515010', null, null, null, null, null, null, '0', null);
INSERT INTO `qf_user` VALUES ('11', '18745915010', null, null, null, null, null, null, '0', null);
INSERT INTO `qf_user` VALUES ('12', '15040964875', null, null, null, null, null, null, '0', null);
INSERT INTO `qf_user` VALUES ('13', '15023024155', null, null, null, null, null, null, '0', null);
INSERT INTO `qf_user` VALUES ('14', '15040295874', null, null, null, null, null, null, '0', null);
INSERT INTO `qf_user` VALUES ('15', '15026587478', null, null, null, null, null, null, '0', null);
INSERT INTO `qf_user` VALUES ('16', '15043258945', null, null, null, null, null, null, '0', null);
INSERT INTO `qf_user` VALUES ('17', '15023654589', null, null, '111', null, null, null, '0', null);
INSERT INTO `qf_user` VALUES ('18', '13488601486', null, 'vcjH6MQ', '4567u8990', null, null, null, '0', null);
INSERT INTO `qf_user` VALUES ('19', '15032156458', null, null, '8888', null, null, null, '0', null);
