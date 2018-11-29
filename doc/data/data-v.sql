/*
Source Database       : data-v
Target Server Type    : MYSQL
Target Server Version : 50642
File Encoding         : 65001

Date: 2018-11-29 19:16:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course_click_count
-- ----------------------------
DROP TABLE IF EXISTS `course_click_count`;
CREATE TABLE `course_click_count` (
  `id` int(4) NOT NULL,
  `day` varchar(10) DEFAULT NULL,
  `course_id` varchar(10) DEFAULT NULL,
  `click_count` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of course_click_count
-- ----------------------------
INSERT INTO `course_click_count` VALUES ('1', '20171111', '112', '80000');
INSERT INTO `course_click_count` VALUES ('2', '20171111', '128', '90000');
INSERT INTO `course_click_count` VALUES ('3', '20171111', '145', '100000');
INSERT INTO `course_click_count` VALUES ('4', '20171111', '146', '40000');
INSERT INTO `course_click_count` VALUES ('5', '20171111', '131', '30000');
INSERT INTO `course_click_count` VALUES ('6', '20171111', '130', '20000');

-- ----------------------------
-- Table structure for course_info
-- ----------------------------
DROP TABLE IF EXISTS `course_info`;
CREATE TABLE `course_info` (
  `id` int(4) NOT NULL,
  `course_id` varchar(10) DEFAULT NULL,
  `course_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of course_info
-- ----------------------------
INSERT INTO `course_info` VALUES ('1', '112', 'Spark SQL');
INSERT INTO `course_info` VALUES ('2', '128', '10小时入门大数据');
INSERT INTO `course_info` VALUES ('3', '145', '深度学习');
INSERT INTO `course_info` VALUES ('4', '146', 'Node.js');
INSERT INTO `course_info` VALUES ('5', '131', 'Vue+Django实战');
INSERT INTO `course_info` VALUES ('6', '130', 'web前端性能优化');
