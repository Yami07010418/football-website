/*
Navicat MySQL Data Transfer

Source Server         : dlufl
Source Server Version : 50740
Source Host           : localhost:3306
Source Database       : personmis

Target Server Type    : MYSQL
Target Server Version : 50740
File Encoding         : 65001

Date: 2024-04-02 11:28:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ausertable
-- ----------------------------
DROP TABLE IF EXISTS `ausertable`;
CREATE TABLE `ausertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `upwd` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ausertable
-- ----------------------------
INSERT INTO `ausertable` VALUES ('0', 'admin', 'admin');

-- ----------------------------
-- Table structure for coach
-- ----------------------------
DROP TABLE IF EXISTS `coach`;
CREATE TABLE `coach` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(255) NOT NULL,
  `apwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coach
-- ----------------------------
INSERT INTO `coach` VALUES ('1', '克洛普', '2d4d38e0404a6597fa1984f0c2509c23');
INSERT INTO `coach` VALUES ('3', 'admin2', '2d4d38e0404a6597fa1984f0c2509c23');
INSERT INTO `coach` VALUES ('4', 'admin3', '2d4d38e0404a6597fa1984f0c2509c23');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `dname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dtype` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dtel` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dfax` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `supdepartment` int(11) DEFAULT NULL,
  `establishmentdate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '球员', '足球运动员', '18342019107', null, '所有足球运动员所在的部门1', '3', '2023-05-29');
INSERT INTO `department` VALUES ('2', '教练组', '教练', '18342019107', '1611284964@qq.com', '教练组成员111', '3', '2023-05-29');
INSERT INTO `department` VALUES ('3', '管理层', '主席', '18342019107', null, '亨利集团董事会成员', '3', '2023-06-13');
INSERT INTO `department` VALUES ('4', '技术分析师', '技术分析师', '123', null, '技术分析', '3', '2023-06-26');
INSERT INTO `department` VALUES ('5', '球探', '球探', '123', null, '球探部门', '3', '2023-06-26');
INSERT INTO `department` VALUES ('6', '医疗', '后勤', '86731637', null, null, '3', '2024-03-27');

-- ----------------------------
-- Table structure for examine
-- ----------------------------
DROP TABLE IF EXISTS `examine`;
CREATE TABLE `examine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `sex` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date NOT NULL,
  `sid` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `depart_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  `entrydate` date NOT NULL,
  `joinworkdate` date NOT NULL,
  `workform` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `staffsource` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `score` int(50) DEFAULT NULL,
  `nation` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` int(50) DEFAULT NULL,
  `stel` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `semail` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sheight` decimal(12,2) DEFAULT NULL,
  `bloodtype` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `weight` int(50) DEFAULT NULL,
  `registeredresidence` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `education` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `degree` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `university` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `picture` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `graduationdate` date DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `status` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `peroidopdate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `did` (`depart_id`) USING BTREE,
  KEY `pid` (`post_id`) USING BTREE,
  CONSTRAINT `examine_ibfk_1` FOREIGN KEY (`depart_id`) REFERENCES `department` (`id`),
  CONSTRAINT `examine_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of examine
-- ----------------------------
INSERT INTO `examine` VALUES ('1', '曲浡语', '男', '2023-06-02', '123', '1', '12', '2023-05-30', '2023-06-09', '试训', '自由转会', '10', null, '8000', '', '', null, null, '0', null, null, null, null, null, null, '2023-06-15', '2023-07-01', null, null);
INSERT INTO `examine` VALUES ('2', '萨拉赫', '男', '2023-06-02', '123', '1', '1', '2023-06-14', '2023-06-30', '正式', '自由转会', '20', null, '9000', null, null, null, null, '0', null, null, null, null, '202306156212548023.jpg', null, null, null, null, null);
INSERT INTO `examine` VALUES ('3', '努涅斯', '男', '2023-06-01', '123', '1', '3', '2023-06-01', '2023-06-23', '正式', '转会费', '13', null, '8000', null, null, null, null, '0', null, null, null, null, '202306156182952863.jpg', null, null, null, null, null);
INSERT INTO `examine` VALUES ('4', '加克波', '男', '2023-06-05', '123', '1', '2', '2023-06-02', '2023-06-09', '正式', '转会费', '10', null, '6000', null, null, null, null, '0', null, null, null, null, '202306156183239983.png', null, null, null, null, null);
INSERT INTO `examine` VALUES ('5', '麦卡利斯特', '男', '2023-06-07', '123', '1', '5', '2023-05-31', '2023-06-21', '正式', '转会费', '12', null, '8000', null, null, null, null, '0', null, null, null, null, '202306156232830453.png', null, null, null, null, null);
INSERT INTO `examine` VALUES ('6', '菲尔米诺', '男', '2023-06-01', '123', '1', '11', '2023-06-08', '2023-06-23', '正式', '自由转会', '10', null, '4000', '86731637', '1611284964@qq.com', null, null, '0', null, null, null, null, '2023061561229283731.jpg', null, null, null, null, null);
INSERT INTO `examine` VALUES ('7', '范迪克', '男', '2023-06-16', '123', '1', '10', '2023-06-15', '2023-06-15', '正式', '自由转会', null, null, '0', '86731637', '1611284964@qq.com', null, null, '0', null, null, null, null, '202306175175130981.jpeg', null, null, null, null, null);
INSERT INTO `examine` VALUES ('8', '曲浡语', '男', '2023-06-15', '123', '1', '6', '2023-06-15', '2023-06-21', '正式', '自由转会', null, null, '0', '86731637', '1611284964@qq.com', null, null, '0', null, null, null, null, '202306175180506626.jpeg', null, null, null, null, null);
INSERT INTO `examine` VALUES ('9', '刘懿峤1', '男', '2023-06-01', '123', '1', '11', '2023-06-01', '2023-06-09', '正式', '自由转会', null, null, '0', null, null, null, null, '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `examine` VALUES ('10', '远藤航', '男', '2024-03-19', '123', '2', '7', '2024-03-07', '2024-03-07', '正式', '自由转会', null, null, '0', null, null, null, null, '0', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `plandate` date DEFAULT NULL,
  `dname` varchar(255) DEFAULT NULL,
  `dtype` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `coach_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES ('1', '2023-06-01', '球员', '足球运动员', '4v4对抗', '1');
INSERT INTO `plan` VALUES ('2', '2023-06-02', '教练1', '教练', '制定球队战术', '1');
INSERT INTO `plan` VALUES ('3', '2023-06-02', '技术部门', '技术分析师', '分析上一场比赛的数据', '1');
INSERT INTO `plan` VALUES ('4', '2023-06-06', '球员', '足球运动员', '跑步', '1');
INSERT INTO `plan` VALUES ('5', '2023-06-07', '中锋', '足球运动员', '头球', '1');
INSERT INTO `plan` VALUES ('6', '2023-06-07', '右边锋', '足球运动员', '下底传中', '1');
INSERT INTO `plan` VALUES ('7', '2024-03-26', '左边锋', '足球运动员', '内切射门', '1');

-- ----------------------------
-- Table structure for player
-- ----------------------------
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `sex` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date NOT NULL,
  `sid` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `depart_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  `entrydate` date NOT NULL,
  `joinworkdate` date NOT NULL,
  `workform` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `staffsource` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `score` int(50) DEFAULT NULL,
  `nation` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` int(50) DEFAULT NULL,
  `stel` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `semail` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sheight` decimal(12,2) DEFAULT NULL,
  `bloodtype` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `weight` int(50) DEFAULT NULL,
  `registeredresidence` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `education` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `degree` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `university` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `picture` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `graduationdate` date DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `status` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `peroidopdate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `did` (`depart_id`) USING BTREE,
  KEY `pid` (`post_id`) USING BTREE,
  CONSTRAINT `player_ibfk_1` FOREIGN KEY (`depart_id`) REFERENCES `department` (`id`),
  CONSTRAINT `player_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of player
-- ----------------------------
INSERT INTO `player` VALUES ('1', '曲浡语', '男', '2023-06-02', '123', '1', '12', '2023-05-30', '2023-06-09', '试训', '自由转会', '10', null, '8000', '', '', null, null, '0', null, null, null, null, null, null, '2023-06-15', '2023-07-01', null, null);
INSERT INTO `player` VALUES ('2', '萨拉赫', '男', '2023-06-02', '123', '1', '1', '2023-06-14', '2023-06-30', '正式', '自由转会', '20', null, '9000', null, null, null, null, '0', null, null, null, null, '202306156212548023.jpg', null, null, null, null, null);
INSERT INTO `player` VALUES ('3', '努涅斯', '男', '2023-06-01', '123', '1', '3', '2023-06-01', '2023-06-23', '正式', '转会费', '13', null, '8000', null, null, null, null, '0', null, null, null, null, '202306156182952863.jpg', null, null, null, null, null);
INSERT INTO `player` VALUES ('4', '加克波', '男', '2023-06-05', '123', '1', '2', '2023-06-02', '2023-06-09', '正式', '转会费', '10', null, '6000', null, null, null, null, '0', null, null, null, null, '202306156183239983.png', null, null, null, null, null);
INSERT INTO `player` VALUES ('5', '麦卡利斯特', '男', '2023-06-07', '123', '1', '5', '2023-05-31', '2023-06-21', '正式', '转会费', '12', null, '8000', null, null, null, null, '0', null, null, null, null, '202306156232830453.png', null, null, null, null, null);
INSERT INTO `player` VALUES ('6', '菲尔米诺', '男', '2023-06-01', '123', '1', '11', '2023-06-08', '2023-06-23', '正式', '自由转会', '10', null, '4000', '86731637', '1611284964@qq.com', null, null, '0', null, null, null, null, '2023061561229283731.jpg', null, null, null, null, null);
INSERT INTO `player` VALUES ('7', '范迪克', '男', '2023-06-16', '123', '1', '10', '2023-06-15', '2023-06-15', '正式', '自由转会', null, null, '0', '86731637', '1611284964@qq.com', null, null, '0', null, null, null, null, '202306175175130981.jpeg', null, null, null, null, null);
INSERT INTO `player` VALUES ('8', '曲浡语', '男', '2023-06-15', '123', '1', '6', '2023-06-15', '2023-06-21', '正式', '自由转会', null, null, '0', '86731637', '1611284964@qq.com', null, null, '0', null, null, null, null, '202306175180506626.jpeg', null, null, null, null, null);
INSERT INTO `player` VALUES ('9', '刘懿峤1', '男', '2023-06-01', '123', '1', '1', '2023-06-01', '2023-06-09', '正式', '自由转会', '13', null, '0', null, null, null, null, '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `player` VALUES ('10', '远藤航', '男', '2024-03-21', '123', '1', '7', '2024-03-14', '2024-03-21', '正式', '自由转会', null, null, '0', null, null, null, null, '0', null, null, null, null, '20240387124445126.webp', null, null, null, null, null);

-- ----------------------------
-- Table structure for playercoach
-- ----------------------------
DROP TABLE IF EXISTS `playercoach`;
CREATE TABLE `playercoach` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `sex` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date NOT NULL,
  `sid` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `depart_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  `entrydate` date NOT NULL,
  `joinworkdate` date NOT NULL,
  `workform` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `staffsource` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `score` int(50) DEFAULT NULL,
  `nation` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` int(50) DEFAULT NULL,
  `stel` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `semail` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sheight` decimal(12,2) DEFAULT NULL,
  `bloodtype` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `weight` int(50) DEFAULT NULL,
  `registeredresidence` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `education` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `degree` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `university` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `picture` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `graduationdate` date DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `status` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `peroidopdate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `did` (`depart_id`) USING BTREE,
  KEY `pid` (`post_id`) USING BTREE,
  CONSTRAINT `playercoach_ibfk_1` FOREIGN KEY (`depart_id`) REFERENCES `department` (`id`),
  CONSTRAINT `playercoach_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of playercoach
-- ----------------------------
INSERT INTO `playercoach` VALUES ('1', '萨拉赫', '男', '2023-06-02', '123', '1', '1', '2023-06-14', '2023-06-30', '正式', '自由转会', '20', null, '9000', null, null, null, null, '0', null, null, null, null, '202306156212548023.jpg', null, null, null, null, null);
INSERT INTO `playercoach` VALUES ('2', '努涅斯', '男', '2023-06-01', '123', '1', '3', '2023-06-01', '2023-06-23', '正式', '转会费', '13', null, '8000', null, null, null, null, '0', null, null, null, null, '202306156182952863.jpg', null, null, null, null, null);
INSERT INTO `playercoach` VALUES ('3', '加克波', '男', '2023-06-05', '123', '1', '2', '2023-06-02', '2023-06-09', '正式', '转会费', '9', null, '6000', null, null, null, null, '0', null, null, null, null, '202306156183239983.png', null, null, null, null, null);
INSERT INTO `playercoach` VALUES ('4', '麦卡利斯特', '男', '2023-06-07', '123', '1', '5', '2023-05-31', '2023-06-21', '正式', '转会费', '12', null, '8000', null, null, null, null, '0', null, null, null, null, '202306156232830453.png', null, null, null, null, null);
INSERT INTO `playercoach` VALUES ('5', '菲尔米诺', '男', '2023-06-01', '123', '1', '11', '2023-06-08', '2023-06-23', '正式', '自由转会', '10', null, '4000', '86731637', '1611284964@qq.com', null, null, '0', null, null, null, null, '2023061561229283731.jpg', null, null, null, null, null);
INSERT INTO `playercoach` VALUES ('7', '罗伯逊', '男', '2023-05-31', '123', '1', '8', '2023-06-10', '2023-06-16', '正式', '自由转会', '3', null, '6500', null, null, null, null, '0', null, null, null, null, '202306159162358941.jpg', null, null, null, null, null);
INSERT INTO `playercoach` VALUES ('8', '科纳特', '男', '2023-06-02', '123', '1', '9', '2023-06-15', '2023-06-22', '正式', '自由转会', null, null, '0', '86731637', '1611284964@qq.com', null, null, '0', null, null, null, null, '202306175181430730.jpeg', null, null, null, null, null);
INSERT INTO `playercoach` VALUES ('9', '范迪克', '男', '2023-06-15', '123', '1', '10', '2023-06-28', '2023-06-23', '正式', '自由转会', null, null, '0', null, null, null, null, '0', null, null, null, null, '202306175181602941.jpeg', null, null, null, null, null);
INSERT INTO `playercoach` VALUES ('10', '阿诺德', '男', '2023-08-03', '123', '1', '11', '2023-08-09', '2023-08-17', '正式', '自由转会', '12', null, '8000', null, null, null, null, '0', null, null, null, null, '202308223104546359.jpg', null, null, null, null, null);
INSERT INTO `playercoach` VALUES ('11', '阿里松', '男', '2023-08-18', '123', '1', '12', '2023-08-03', '2023-08-10', '正式', '自由转会', null, null, '0', null, null, null, null, '0', null, null, null, null, '202308223110018519.jpg', null, null, null, null, null);
INSERT INTO `playercoach` VALUES ('13', '索博斯罗伊', '男', '2024-03-12', '12', '1', '6', '2024-03-06', '2024-03-13', '正式', '自由转会', '12', null, '0', null, null, null, null, '0', null, null, null, null, '20240375140545302.jpg', null, null, null, null, null);

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ptype` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `organization` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '右边锋', '球员', '2');
INSERT INTO `post` VALUES ('2', '伪九号', '球员', '1');
INSERT INTO `post` VALUES ('3', '左边锋', '球员', '3');
INSERT INTO `post` VALUES ('4', '中锋', '球员', '2');
INSERT INTO `post` VALUES ('5', '左中场', '球员', '1');
INSERT INTO `post` VALUES ('6', '右中场', '球员', '1');
INSERT INTO `post` VALUES ('7', '后腰', '球员', '1');
INSERT INTO `post` VALUES ('8', '左后卫', '球员', '1');
INSERT INTO `post` VALUES ('9', '中后卫（左）', '球员', '1');
INSERT INTO `post` VALUES ('10', '中后卫（右）', '球员', '2');
INSERT INTO `post` VALUES ('11', '右后卫', '球员', '1');
INSERT INTO `post` VALUES ('12', '门将', '球员', '1');
INSERT INTO `post` VALUES ('13', '主教练', '教练组', '1');
INSERT INTO `post` VALUES ('14', '球探', '球探', '2');
INSERT INTO `post` VALUES ('15', '青训球员', '球员', '2');

-- ----------------------------
-- Table structure for quit
-- ----------------------------
DROP TABLE IF EXISTS `quit`;
CREATE TABLE `quit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_id` int(11) DEFAULT NULL,
  `sname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `qtype` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `qdate` date DEFAULT NULL,
  `opdate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `qsid` (`staff_id`),
  CONSTRAINT `qsid` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of quit
-- ----------------------------
INSERT INTO `quit` VALUES ('1', '3', '萨拉赫', '辞职', '2024-03-09', '2024-04-21');
INSERT INTO `quit` VALUES ('2', '2', '克洛普', '辞职', '2024-03-26', '2024-03-21');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `sex` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date NOT NULL,
  `sid` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `depart_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  `entrydate` date NOT NULL,
  `joinworkdate` date NOT NULL,
  `workform` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `staffsource` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `politicalstatus` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nation` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nativeplace` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `stel` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `semail` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sheight` decimal(12,2) DEFAULT NULL,
  `bloodtype` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `weight` int(50) DEFAULT NULL,
  `registeredresidence` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `education` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `degree` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `university` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `picture` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `graduationdate` date DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `status` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `peroidopdate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `did` (`depart_id`),
  KEY `pid` (`post_id`),
  CONSTRAINT `did` FOREIGN KEY (`depart_id`) REFERENCES `department` (`id`),
  CONSTRAINT `pid` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1', '曲浡语', '男', '2023-06-02', '123', '2', '6', '2023-05-30', '2023-06-09', '正式', '自由转会', null, null, '', '', '', null, null, '0', null, null, null, null, null, null, '2023-05-16', '2023-06-29', '转正', '2023-06-24');
INSERT INTO `staff` VALUES ('2', '克洛普', '男', '2023-06-22', '123', '2', '13', '2023-05-30', '2023-06-08', '正式', '自由转会', null, null, '', null, null, null, null, '0', null, null, null, null, null, null, '2023-06-14', '2023-06-01', '试训', '2023-06-09');
INSERT INTO `staff` VALUES ('3', '萨拉赫', '男', '2023-06-08', '123', '1', '1', '2023-05-31', '2023-06-15', '正式', '自由转会', null, null, '', null, null, null, null, '0', null, null, null, null, null, null, '2023-06-14', '2023-06-29', '正常', '2023-06-03');
INSERT INTO `staff` VALUES ('4', '努涅斯', '男', '2023-06-23', '123', '1', '4', '2023-06-22', '2023-06-08', '正式', '自由转会', null, null, '', null, null, null, null, null, null, null, null, null, null, null, '2023-06-22', '2023-06-22', '正常', '2023-06-03');
INSERT INTO `staff` VALUES ('5', '加克波', '男', '2023-06-02', '123', '1', '2', '2023-06-16', '2023-06-09', '正式', '自由转会', null, null, '1', null, null, null, null, null, null, null, null, null, null, null, '2023-06-07', '2023-06-14', '正常', '2023-06-16');
INSERT INTO `staff` VALUES ('6', '迪亚斯', '男', '2023-06-22', '123', '1', '3', '2023-06-09', '2023-06-23', '正式', '自由转会', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2023-06-21', '2023-06-24', '正常', '2023-06-26');
INSERT INTO `staff` VALUES ('7', '若塔', '男', '2023-06-28', '123', '1', '2', '2023-06-07', '2023-06-23', '正式', '自由转会', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2023-05-31', '2023-06-21', '正常', '2023-06-09');
INSERT INTO `staff` VALUES ('8', '麦卡利斯特', '男', '2023-06-08', '123', '1', '5', '2023-06-15', '2023-06-02', '正式', '自由转会', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2023-06-26', '2023-06-15', '正常', '2023-06-15');
INSERT INTO `staff` VALUES ('9', '索博斯罗伊', '男', '2023-06-01', '123', '1', '6', '2023-06-24', '2023-06-26', '正式', '自由转会', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2023-06-16', '2023-06-30', '转正', '2023-06-26');

-- ----------------------------
-- Table structure for transfer
-- ----------------------------
DROP TABLE IF EXISTS `transfer`;
CREATE TABLE `transfer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_id` int(11) DEFAULT NULL,
  `sname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `beforepost_id` int(11) DEFAULT NULL,
  `afterpost_id` int(11) DEFAULT NULL,
  `ttype` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tdate` date DEFAULT NULL,
  `opdate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ssid` (`staff_id`),
  KEY `ppid` (`afterpost_id`),
  KEY `bpid` (`beforepost_id`),
  CONSTRAINT `bpid` FOREIGN KEY (`beforepost_id`) REFERENCES `post` (`id`),
  CONSTRAINT `ppid` FOREIGN KEY (`afterpost_id`) REFERENCES `post` (`id`),
  CONSTRAINT `ssid` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of transfer
-- ----------------------------
INSERT INTO `transfer` VALUES ('1', '1', '曲浡语', '2', '6', '升职', '2024-03-26', '2024-03-21');
