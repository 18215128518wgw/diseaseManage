/*
 Navicat Premium Data Transfer

 Source Server         : mysql56
 Source Server Type    : MySQL
 Source Server Version : 50647
 Source Host           : localhost:3306
 Source Schema         : disease

 Target Server Type    : MySQL
 Target Server Version : 50647
 File Encoding         : 65001

 Date: 09/03/2020 17:31:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `college` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院',
  `classes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日期',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号',
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区',
  `stay_at_school` tinyint(255) NULL DEFAULT NULL COMMENT '是否留校',
  `if_wuhanperson` tinyint(255) NULL DEFAULT NULL COMMENT '是否武汉籍学生',
  `if_hubeiperson` tinyint(255) NULL DEFAULT NULL COMMENT '是否湖北籍学生',
  `with_wuhan_meet` tinyint(255) NULL DEFAULT NULL COMMENT '14天内与武汉疫区人员接触',
  `with_hubei_meet` tinyint(255) NULL DEFAULT NULL COMMENT '14天内与湖北疫区（不含武汉）人员接触',
  `in_wuhan` tinyint(255) NULL DEFAULT NULL COMMENT '是否在武汉',
  `in_hubei` tinyint(255) NULL DEFAULT NULL COMMENT '是否在湖北（不含武汉)',
  `back_to_school` tinyint(255) NULL DEFAULT NULL COMMENT '是否今天返校',
  `suspect` tinyint(255) NULL DEFAULT NULL COMMENT '是否疑似',
  `infect` tinyint(255) NULL DEFAULT NULL COMMENT '是否确诊感染',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '201771030121', '计算机', '17卓越', '2020-3-6', '王国伟', '18215128518', '甘肃', '兰州', '七里河', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `student` VALUES (8, '621691', '数统', '计科2', '2020-03-07 16:03:24', '张楠', '18893483103', '河北', '邯郸', '二道河', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `student` VALUES (9, '621691', '数统', '计科2', '2020-03-07 16:03:24', '张楠', '18893483103', '河北', '邯郸', '二道河', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `student` VALUES (10, '201771020145', '计算机科学与工程学院', '2017级软件一班', '2020-03-07 16:03:603', '张人懿', '17393153129', '辽宁省', '沈阳市', '皇姑区', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `student` VALUES (11, '220170952520', '小仙女学院', '天空一班', '2020-03-08 18:03:212', '王晴', '2582557758', '九重天省', '青丘市', '白滚滚区', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `student` VALUES (12, '1715929383', '计算机学院', '16-4', '2020-03-08 18:03:416', '郭涛', '16625362370', '上海', '上海', '青浦', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `student` VALUES (13, '621691', '物理', '2班', '2020-03-09 15:03:124', '邓福如', '18845783103', '湖南', '承德', '二道河', 1, 1, 0, 1, 1, 0, 1, 1, 1, 0);
INSERT INTO `student` VALUES (15, '12345678', '旅游', '2班', '2020-03-09 15:03:180', '陈独秀', '12334564567', '甘肃', '承德', '二道河', 1, 0, 1, 1, 0, 1, 0, 0, 1, 1);
INSERT INTO `student` VALUES (16, '12345678', '旅游', '2班', '2020-03-09 15:03:180', '陈独秀', '12334564567', '甘肃', '承德', '二道河', 1, 0, 1, 1, 0, 1, 0, 0, 1, 1);
INSERT INTO `student` VALUES (17, '12345678', '驱蚊器', '请问请问', '2020-03-09 15:03:304', '王国伟', '18893483103', '甘肃', '兰州', '二道河', 1, 1, 1, 1, 0, 0, 0, 0, 1, 1);
INSERT INTO `student` VALUES (18, '12345678', '驱蚊器', '请问请问', '2020-03-09 15:03:993', '王国伟', '18893483103', '甘肃', '兰州', '二道河', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `student` VALUES (25, '123232334', '计算机', '物联网', '2020-03-09 15:03:282', '苗疆客', '4008123123', '辽宁', '沈阳', '皇姑', 0, 0, 0, 1, 0, 0, 1, 1, 0, 0);
INSERT INTO `student` VALUES (26, '58956562', '物理', '物联网', '2020-03-09 16:03:13', '东方朔', '12343215', '北京', '北京', '东城', 1, 0, 1, 1, 0, 0, 1, 1, 0, 0);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 83 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (2, 'wgw', '用户1', '1', '1');
INSERT INTO `users` VALUES (1, 'admin', '管理员', '123456', '1');
INSERT INTO `users` VALUES (3, 'test', 'test', '1', '1');

SET FOREIGN_KEY_CHECKS = 1;
