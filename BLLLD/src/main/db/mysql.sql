/*
Navicat MySQL Data Transfer

Source Server         : oop
Source Server Version : 50624
Source Host           : localhost:10001
Source Database       : db_blog

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-01-12 15:34:52
*/
# 关闭外键约束
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id`      INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL ,
  `title`   VARCHAR(50)      DEFAULT NULL,
  `content` TEXT,
  `name`    VARCHAR(50)      DEFAULT NULL,
  `date`    DATETIME         DEFAULT NULL,
  `hasread` INT(11)          DEFAULT '0',
  FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  COMMENT = '文章表';
-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (null, 1,'SSH整合方案（一）', '<p>这段时间准备写一下SSH的整合方法<img alt=\"\" src=\"http://localhost:8080/JavaPrj_4/user/fckeditor/editor/images/smiley/qq/017.jpg\" /></p>',
                              'xiaoxiao', '2009-12-27 10:58:50', '2');
INSERT INTO `article` VALUES (null, 1,'SSH整合方案（二）', '<p>让我们一起感受SSH整合的魅力吧！！！！！</p>', 'xiaoxiao', '2009-12-27 10:59:41', '1');
INSERT INTO `article` VALUES (null,1,'今天好冷啊！',
                              '<p>外面下雪了，今年的冬天来得太早了。<img alt=\"\" src=\"http://localhost:8080/JavaPrj_4/user/fckeditor/editor/images/smiley/qq/005.gif\" /></p>',
                              'xiaoxiao', '2009-12-27 11:00:22', '2');
INSERT INTO `article` VALUES (null,1,'SSH', '继续更新我的SSH整合方案！',  'xiaoxiao', '2009-12-27 11:08:43', '2');
INSERT INTO `article` VALUES ( null,1,'测试日志！！',
                              '<p>测试日志！！<img alt=\"\" src=\"http://localhost:8080/JavaPrj_4/user/fckeditor/editor/images/smiley/qq/004.gif\" /></p>',
                              'xiaoxiao', '2010-01-27 18:05:06', '1');

-- ----------------------------
-- Table structure for bloginfo
-- ----------------------------
DROP TABLE IF EXISTS `bloginfo`;
CREATE TABLE `bloginfo` (
  `id`     int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `uid`     int NOT NULL ,
  `name`      VARCHAR(20) NOT NULL,
  `blogtitle` VARCHAR(50)          DEFAULT NULL,
  `idiograph` VARCHAR(50)          DEFAULT NULL,
  CONSTRAINT `bloginfo` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '个性设置表';

-- ----------------------------
-- Records of bloginfo
-- ----------------------------
INSERT INTO `bloginfo` VALUES (null,1,'xiaoxiao', 'dddww', 'qqwww');

-- ----------------------------
-- Table structure for critique
-- ----------------------------
DROP TABLE IF EXISTS `critique`;
CREATE TABLE `critique` (
  `id`       INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `aid`      INT(11)          DEFAULT NULL,
  `content`  TEXT,
  `username` VARCHAR(50)      DEFAULT NULL,
  CONSTRAINT `critique` FOREIGN KEY (`aid`) REFERENCES `article` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = utf8
  COMMENT = '评论表';

-- ----------------------------
-- Records of critique
-- ----------------------------
INSERT INTO `critique` VALUES ('1', '3', '<p>是啊，太冷了，我还好！！！</p>', 'xiaoxiao');
INSERT INTO `critique` VALUES ('2', '3', '<p>我们公司的暖气坏了，好冷啊！！</p>', 'xiaoxiao');
INSERT INTO `critique` VALUES ('3', '2', '<p>测试一下！</p>', 'xiaoxiao');
INSERT INTO `critique` VALUES ('4', '5', '<p>评论！！</p>', 'xiaoxiao');
INSERT INTO `critique` VALUES ('5', '1', '<p>测试一下！！</p>', 'xiaoxiao');
INSERT INTO `critique`
VALUES ('6', '5', '<p><a href=\"http://localhost:8080/JavaPrj_4/\">http://localhost:8080/JavaPrj_4/</a></p>', '匿名');

-- ----------------------------
-- Table structure for dianjiliang
-- ----------------------------
DROP TABLE IF EXISTS `clickrate`;
CREATE TABLE `clickrate` (
  `id`   INT(11) NOT NULL AUTO_INCREMENT,
  `aid`  INT(11)          NOT NULL,
  `ip`   VARCHAR(255)     DEFAULT NULL,
  `time` DATE             DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `clickrate` FOREIGN KEY (`aid`) REFERENCES `article` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = utf8
  COMMENT = '点击量表';

-- ----------------------------
-- Records of dianjiliang
-- ----------------------------
INSERT INTO `clickrate` VALUES ('1', '1', '0:0:0:0:0:0:0:1', '2009-12-27');
INSERT INTO `clickrate` VALUES ('2', '3', '0:0:0:0:0:0:0:1', '2009-12-27');
INSERT INTO `clickrate` VALUES ('3', '1', '0:0:0:0:0:0:0:1', '2010-01-27');
INSERT INTO `clickrate` VALUES ('4', '2', '0:0:0:0:0:0:0:1', '2010-01-27');
INSERT INTO `clickrate` VALUES ('5', '5', '0:0:0:0:0:0:0:1', '2010-01-27');
INSERT INTO `clickrate` VALUES ('6', '4', '0:0:0:0:0:0:0:1', '2010-01-27');
INSERT INTO `clickrate` VALUES ('7', '4', '0:0:0:0:0:0:0:1', '2016-01-12');
INSERT INTO `clickrate` VALUES ('8', '3', '0:0:0:0:0:0:0:1', '2016-01-12');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` INTEGER NOT NULL AUTO_INCREMENT COMMENT '登陆ID',
  `name`        VARCHAR(50) NOT NULL
  COMMENT '用户姓名',
  `password`    VARCHAR(20)  NOT NULL
  COMMENT '用户密码',
  `nick_name`   VARCHAR(100) NOT NULL
  COMMENT '昵称',
  `sex`         CHAR(1)         NOT NULL #m/f/n
  COMMENT '性别',
  `duty`        VARCHAR(15) COMMENT '职务',
  `email`       VARCHAR(25) COMMENT '邮箱',
  `photo_url`   VARCHAR(75) COMMENT '头像地址',
  `used`        INT     NOT NULL #Y/N
  COMMENT '账号是否可用',
  `create_time` DATETIME     NOT NULL,
  PRIMARY KEY (`uid`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (null,'xiaoxiao', '000000', '厉风行', 'F', '', '0000@163.com', '', 0, now());
INSERT INTO `user`
VALUES (null,'haha', '000000', '厉风行', 'F', '', '0000@163.com', '', 0, now());