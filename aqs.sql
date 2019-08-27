/*
Navicat MySQL Data Transfer

Source Server         : 1903
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : aqs

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-08-27 14:56:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for aqs_answer
-- ----------------------------
DROP TABLE IF EXISTS `aqs_answer`;
CREATE TABLE `aqs_answer` (
  `answer_id` varchar(50) NOT NULL COMMENT '回答标识',
  `user_account` varchar(50) DEFAULT NULL COMMENT '回答用户账号',
  `question_id` varchar(50) DEFAULT NULL COMMENT '问题标识',
  `answer_content` mediumtext COMMENT '问题回答内容',
  `answer_sub_id` varchar(50) DEFAULT NULL,
  `answer_create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '回答时间',
  PRIMARY KEY (`answer_id`),
  KEY `answer_user_foreign_key` (`user_account`),
  KEY `answer_question_id` (`question_id`),
  KEY `answer_answer_sub_id` (`answer_sub_id`),
  CONSTRAINT `answer_answer_sub_id` FOREIGN KEY (`answer_sub_id`) REFERENCES `aqs_answer` (`answer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `answer_question_id` FOREIGN KEY (`question_id`) REFERENCES `aqs_question` (`question_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `answer_user_foreign_key` FOREIGN KEY (`user_account`) REFERENCES `aqs_user` (`user_account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aqs_answer
-- ----------------------------
INSERT INTO `aqs_answer` VALUES ('1', '347804189@qq.com', '1', '你说错了', null, '2019-06-06 09:03:33');
INSERT INTO `aqs_answer` VALUES ('2', '347804189@qq.com', '1', '没凑', '1', '2019-06-06 10:11:34');
INSERT INTO `aqs_answer` VALUES ('3', '347804189@qq.com', '1', 'nice', '2', '2019-06-06 10:13:49');
INSERT INTO `aqs_answer` VALUES ('4', '347804189@qq.com', '1', '爱的色放', null, '2019-06-21 12:19:19');

-- ----------------------------
-- Table structure for aqs_logs
-- ----------------------------
DROP TABLE IF EXISTS `aqs_logs`;
CREATE TABLE `aqs_logs` (
  `log_id` varchar(50) NOT NULL,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of aqs_logs
-- ----------------------------

-- ----------------------------
-- Table structure for aqs_menus
-- ----------------------------
DROP TABLE IF EXISTS `aqs_menus`;
CREATE TABLE `aqs_menus` (
  `menu_id` varchar(50) NOT NULL,
  `menu_name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `menu_url` varchar(200) DEFAULT NULL COMMENT '资源URL',
  `menu_type` int(11) DEFAULT NULL COMMENT '类型     1：菜单   2：按钮',
  `menu_sort` int(11) DEFAULT NULL COMMENT '排序',
  `menu_note` varchar(100) DEFAULT NULL COMMENT '备注',
  `menu_parent_id` varchar(50) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `menu_permission` varchar(500) DEFAULT NULL COMMENT '授权(如：user:create)',
  `menu_created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `menu_modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  `menu_created_user` varchar(50) DEFAULT NULL COMMENT '创建用户',
  `menu_modified_user` varchar(50) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`menu_id`),
  KEY `parent_id` (`menu_parent_id`),
  CONSTRAINT `parent_id` FOREIGN KEY (`menu_parent_id`) REFERENCES `aqs_menus` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源管理';

-- ----------------------------
-- Records of aqs_menus
-- ----------------------------

-- ----------------------------
-- Table structure for aqs_question
-- ----------------------------
DROP TABLE IF EXISTS `aqs_question`;
CREATE TABLE `aqs_question` (
  `question_id` varchar(50) NOT NULL COMMENT '问题标识号',
  `user_account` varchar(50) DEFAULT NULL COMMENT '用户账号',
  `question_introduce` varchar(50) NOT NULL COMMENT '问题名称',
  `question_content` mediumtext COMMENT '问题内容',
  `question_preview_count` int(11) DEFAULT NULL COMMENT '浏览数',
  `question_praise` int(255) DEFAULT NULL COMMENT '点赞数',
  `question_ifpublic` int(255) DEFAULT NULL COMMENT '问题是否所有人可见，1所有人可见，0私密',
  `question_type_id` varchar(50) DEFAULT NULL COMMENT '问题类型',
  `question_create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '提问时间',
  PRIMARY KEY (`question_id`),
  KEY `question_user_foreign_key` (`user_account`),
  KEY `question_type_id` (`question_type_id`),
  FULLTEXT KEY `question_content_index` (`question_content`),
  FULLTEXT KEY `question_introduce_index` (`question_introduce`),
  CONSTRAINT `question_type_id` FOREIGN KEY (`question_type_id`) REFERENCES `aqs_question_type` (`quesiton_type_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `question_user_foreign_key` FOREIGN KEY (`user_account`) REFERENCES `aqs_user` (`user_account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aqs_question
-- ----------------------------
INSERT INTO `aqs_question` VALUES ('086bc12469a5403c9b447ae82e004b3f', '347804189@qq.com', 'lombok介绍', 'lombok是一个可以通过简单的注解的形式来帮助我们简化消除一些必须有但显得很臃肿的 Java 代码的工具，在我们项目开发中经常使用model，entity等类，绝大部分数据类类中都需要get、set、toString等方法，一般我们需要手动的添加这些属性， 但是如果我们受到业务的变更，字段的添加，修改等操作，我们需要更改实体类，但是使用了lombok插件，只要我们定义了变量，例如使用@Data属性，lombok会在编译的时候，自动加上get set方法', '10', '11', '1', '356dce1b94d911e989e6f0761cbd81f3', '2019-07-06 11:08:02');
INSERT INTO `aqs_question` VALUES ('1', '347804189@qq.com', 'spring简介11112', '这是我的第一个简介测试111', '1', '1', '1', '356dce1b94d911e989e6f0761cbd81f3', '2019-07-05 18:57:21');
INSERT INTO `aqs_question` VALUES ('2', '347804189@qq.com', '撒旦发射点发射点是的', '撒旦飞洒地方水电费啊发生的噶尔单实', '1', '1', '1', '356dce1b94d911e989e6f0761cbd81f3', '2019-07-05 19:23:17');

-- ----------------------------
-- Table structure for aqs_question_type
-- ----------------------------
DROP TABLE IF EXISTS `aqs_question_type`;
CREATE TABLE `aqs_question_type` (
  `quesiton_type_id` varchar(50) NOT NULL COMMENT '类型标识',
  `question_type_name` varchar(255) DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`quesiton_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aqs_question_type
-- ----------------------------
INSERT INTO `aqs_question_type` VALUES ('356dce1b94d911e989e6f0761cbd81f3', 'JAVA');

-- ----------------------------
-- Table structure for aqs_roles
-- ----------------------------
DROP TABLE IF EXISTS `aqs_roles`;
CREATE TABLE `aqs_roles` (
  `role_id` varchar(50) NOT NULL,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_note` varchar(500) DEFAULT NULL COMMENT '备注',
  `role_created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `role_modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  `role_created_user` varchar(50) DEFAULT NULL COMMENT '创建用户',
  `role_modified_user` varchar(50) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of aqs_roles
-- ----------------------------

-- ----------------------------
-- Table structure for aqs_role_menus
-- ----------------------------
DROP TABLE IF EXISTS `aqs_role_menus`;
CREATE TABLE `aqs_role_menus` (
  `rm_id` varchar(50) NOT NULL,
  `role_id` varchar(50) NOT NULL COMMENT '角色ID',
  `menu_id` varchar(50) NOT NULL COMMENT 'ID',
  PRIMARY KEY (`rm_id`),
  KEY `menu_role_id` (`role_id`),
  KEY `menu_menu_id` (`menu_id`),
  CONSTRAINT `menu_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `aqs_menus` (`menu_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `menu_role_id` FOREIGN KEY (`role_id`) REFERENCES `aqs_roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of aqs_role_menus
-- ----------------------------

-- ----------------------------
-- Table structure for aqs_user
-- ----------------------------
DROP TABLE IF EXISTS `aqs_user`;
CREATE TABLE `aqs_user` (
  `user_account` varchar(50) NOT NULL COMMENT '账号',
  `user_nickname` varchar(50) NOT NULL COMMENT '用户名称',
  `user_password` varchar(50) NOT NULL COMMENT '用户密码',
  `user_sale` varchar(50) DEFAULT NULL,
  `user_valid` varchar(1) DEFAULT NULL COMMENT '禁用',
  `user_introduce` varchar(255) DEFAULT NULL COMMENT '个人简介',
  `user_create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`user_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aqs_user
-- ----------------------------
INSERT INTO `aqs_user` VALUES ('347804189@qq.com', '龚长江', '1101', null, '1', '我的第一个测试', '2019-06-21 18:08:49');

-- ----------------------------
-- Table structure for aqs_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `aqs_user_roles`;
CREATE TABLE `aqs_user_roles` (
  `ur_id` varchar(50) NOT NULL,
  `user_id` varchar(20) NOT NULL COMMENT '用户ID',
  `role_id` varchar(50) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`ur_id`),
  KEY `user_id` (`user_id`),
  KEY `user_role_id` (`role_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `aqs_user` (`user_account`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_role_id` FOREIGN KEY (`role_id`) REFERENCES `aqs_roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of aqs_user_roles
-- ----------------------------
