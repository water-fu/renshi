/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50151
Source Host           : localhost:3306
Source Database       : renshi

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2015-07-06 11:05:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blog_share_info`
-- ----------------------------
DROP TABLE IF EXISTS `blog_share_info`;
CREATE TABLE `blog_share_info` (
  `SHARE_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '分享编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账户编号',
  `SHARE_TITLE` varchar(256) NOT NULL COMMENT '分享标题',
  `SHARE_TYPE` int(4) NOT NULL COMMENT '分享类型\r\n            1.视频\r\n            2.知识\r\n            3.病例\r\n            4.文库',
  `SHARE_TAG` varchar(32) NOT NULL COMMENT '分享标签',
  `SHARE_DESC` text NOT NULL COMMENT '分享描述',
  `BELONG_PROFESS` varchar(128) NOT NULL COMMENT '所属专业',
  `READ_PERMISSION` int(4) NOT NULL COMMENT '阅读权限',
  `SHARE_STATUS` int(4) NOT NULL COMMENT '审批状态\r\n            0.未审批\r\n            1.审批通过\r\n            2.审批未通过',
  `LIKE_NUM` int(8) NOT NULL DEFAULT '0' COMMENT '点赞数量',
  `COLLECTION_NUM` int(8) NOT NULL DEFAULT '0' COMMENT '收藏数量',
  `READ_NUM` int(8) NOT NULL DEFAULT '0' COMMENT '查看次数',
  `COMMENT_NUM` int(8) NOT NULL DEFAULT '0' COMMENT '评论数量',
  `SHARE_LEVEL` int(4) NOT NULL DEFAULT '0',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_USER` int(8) NOT NULL COMMENT '更新用户',
  `UPDATE_DATE` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`SHARE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='个人分享信息';

-- ----------------------------
-- Records of blog_share_info
-- ----------------------------
INSERT INTO `blog_share_info` VALUES ('1', '22', '测试知识测试知识测试知识', '2', '你好，我好', '测试知识测试知识测试知识测试知识测试知识测试知识测试知识测试知识测试知识测试知识测试知识测试知识测试知识测试知识测试知识测试知识测试知识测试知识测试知识测试知识', '神经科', '1', '1', '2', '1', '90', '1', '0', '1', '2015-06-09 17:14:19', '22', '2015-07-05 15:07:13');
INSERT INTO `blog_share_info` VALUES ('2', '28', '我的测试我的测试', '2', '测试测试', '测试测试测试侧是测试测试测试侧是测试测试测试侧是测试测试测试侧是测试测试测试侧是测试测试测试侧是测试测试测试侧是测试测试测试侧是测试测试测试侧是测试测试测试侧是测试测试测试侧是', '内科', '1', '1', '1', '1', '109', '2', '0', '1', '2015-06-17 14:35:14', '22', '2015-07-03 14:21:13');

-- ----------------------------
-- Table structure for `doctor_authentic_info`
-- ----------------------------
DROP TABLE IF EXISTS `doctor_authentic_info`;
CREATE TABLE `doctor_authentic_info` (
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账户编号',
  `WORK_PROFESS` varchar(30) DEFAULT NULL COMMENT '工作职称',
  `ACADEMIC_PROFESS` varchar(30) DEFAULT NULL COMMENT '学术职称',
  `EDUCATION_PROFESS` varchar(30) DEFAULT NULL COMMENT '教育职称',
  `PROFESS_LEVEL` int(4) DEFAULT NULL COMMENT '职称级别',
  `ID_CARD` varchar(30) DEFAULT NULL COMMENT '身份证编码',
  `FRONT_URL` varchar(50) DEFAULT NULL COMMENT '正面地址',
  `BACK_URL` varchar(50) DEFAULT NULL COMMENT '反面地址',
  `CERTIFICATE_TYPE` int(4) DEFAULT NULL COMMENT '证书类型\r\n            1.医师学历证\r\n            2.医师资格证\r\n            3.医师学位证',
  `CERTIFICATE_NO` varchar(50) DEFAULT NULL COMMENT '证书编号',
  `CERTIFICATE_URL` varchar(50) DEFAULT NULL COMMENT '照片地址',
  PRIMARY KEY (`ACCOUNT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='医生认证信息';

-- ----------------------------
-- Records of doctor_authentic_info
-- ----------------------------
INSERT INTO `doctor_authentic_info` VALUES ('22', '主任医师', '教授', '博士生导师', '1', '339005199001022816', '/data/renshi/idCard/20150608203805110', '/data/renshi/idCard/20150608203806707', '1', '123123123', '/data/renshi/cretificatePath/20150608203803032');
INSERT INTO `doctor_authentic_info` VALUES ('28', '主治医师', '讲师', '硕士生导师', '1', '339005199000002837', '/data/renshi/idCard/20150617143251682.jpg', '/data/renshi/idCard/20150617143253088.jpg', '1', '123123123123', '/data/renshi/cretificatePath/20150617143244100.jpg');
INSERT INTO `doctor_authentic_info` VALUES ('29', '主治医师', '副教授', '博士生导师', '1', '339004200001011111', '/data/renshi/idCard/20150619102432384.jpg', '/data/renshi/idCard/20150619102434070.jpg', '1', '123123123', '/data/renshi/cretificatePath/20150619102413662.jpg');
INSERT INTO `doctor_authentic_info` VALUES ('33', '主治医师', '副教授', '硕士生导师', '2', '339005199999992837', '/data/renshi/idCard/20150629172731019.jpg', '/data/renshi/idCard/20150629172732187.jpg', '3', '123123', '/data/renshi/cretificatePath/20150629172722072.jpg');
INSERT INTO `doctor_authentic_info` VALUES ('37', '主治医师', '教授', '博士生导师', '2', '330119111111111111', '/data/renshi/idCard/20150701084210085.jpg', '/data/renshi/idCard/20150701084211327.jpg', '1', '13123', '/data/renshi/cretificatePath/20150701084159094.jpg');
INSERT INTO `doctor_authentic_info` VALUES ('38', '副主任医师', '教授', '博士生导师', '3', '330111222222222222', '/data/renshi/idCard/20150701135548688.jpg', '/data/renshi/idCard/20150701135549988.jpg', '1', '123123123', '/data/renshi/cretificatePath/20150701135540578.jpg');

-- ----------------------------
-- Table structure for `doctor_book_info`
-- ----------------------------
DROP TABLE IF EXISTS `doctor_book_info`;
CREATE TABLE `doctor_book_info` (
  `BOOK_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '著作编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账户编号',
  `BOOK_NAME` varchar(128) NOT NULL COMMENT '著作名称',
  `AUTHOR_TYPE` varchar(32) NOT NULL COMMENT '作者类型\r\n            1.第一作者\r\n            2.第二作者\r\n            3.译者',
  `AUTHOR_NAME` varchar(64) DEFAULT NULL COMMENT '作者名称',
  `PUBLISH_DATE` varchar(32) NOT NULL COMMENT '出版时间',
  `PUBLISH_DEPT` varchar(128) NOT NULL COMMENT '出版机构',
  `BOOK_DESC` varchar(128) NOT NULL COMMENT '著作描述',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  `UPDATE_DATE` datetime NOT NULL COMMENT '更新时间',
  `UPDATE_USER` int(8) NOT NULL COMMENT '更新用户',
  PRIMARY KEY (`BOOK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='医生著作信息';

-- ----------------------------
-- Records of doctor_book_info
-- ----------------------------

-- ----------------------------
-- Table structure for `doctor_contact_info`
-- ----------------------------
DROP TABLE IF EXISTS `doctor_contact_info`;
CREATE TABLE `doctor_contact_info` (
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账户编号',
  `PHONE_NO` varchar(50) NOT NULL COMMENT '手机号码',
  `MAIL_ADDRESS` varchar(50) DEFAULT NULL COMMENT '邮箱地址',
  `QQ_NO` varchar(50) NOT NULL COMMENT 'QQ号码',
  `WECHAT_NO` varchar(50) DEFAULT NULL COMMENT '微信号',
  `WEIBO_ADDRESS` varchar(256) DEFAULT NULL COMMENT '微博地址',
  PRIMARY KEY (`ACCOUNT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='医生联系方式';

-- ----------------------------
-- Records of doctor_contact_info
-- ----------------------------
INSERT INTO `doctor_contact_info` VALUES ('22', '15158133910', null, '746349472', null, null);
INSERT INTO `doctor_contact_info` VALUES ('28', '15158133910', null, '746349472', null, null);
INSERT INTO `doctor_contact_info` VALUES ('29', '15158133910', null, '746349472', null, null);
INSERT INTO `doctor_contact_info` VALUES ('33', '15158133910', null, '123123312', null, null);
INSERT INTO `doctor_contact_info` VALUES ('37', '15158133910', null, '123123', null, null);
INSERT INTO `doctor_contact_info` VALUES ('38', '15158133910', null, '123123123', null, null);

-- ----------------------------
-- Table structure for `doctor_education_info`
-- ----------------------------
DROP TABLE IF EXISTS `doctor_education_info`;
CREATE TABLE `doctor_education_info` (
  `EDUCATION_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '教育编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账户编号',
  `SCHOOL_NAME` varchar(64) NOT NULL COMMENT '学校名称',
  `START_DATE` varchar(32) NOT NULL COMMENT '入学时间',
  `END_DATE` varchar(32) NOT NULL COMMENT '毕业时间',
  `IN_CITY` varchar(32) NOT NULL COMMENT '就读城市',
  `MAJOR_NAME` varchar(32) NOT NULL COMMENT '就读专业',
  `DEGREE_NAME` varchar(32) NOT NULL COMMENT '学位名称',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  `UPDATE_DATE` datetime NOT NULL COMMENT '更新时间',
  `UPDATE_USER` int(8) NOT NULL COMMENT '更新用户',
  PRIMARY KEY (`EDUCATION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='医生教育信息';

-- ----------------------------
-- Records of doctor_education_info
-- ----------------------------

-- ----------------------------
-- Table structure for `doctor_meeting_info`
-- ----------------------------
DROP TABLE IF EXISTS `doctor_meeting_info`;
CREATE TABLE `doctor_meeting_info` (
  `MEETING_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '会议编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账户编号',
  `MEETING_NAME` varchar(128) NOT NULL COMMENT '会议名称',
  `MEETING_TYPE` varchar(32) NOT NULL COMMENT '参加类型\r\n            1.嘉宾\r\n            2.主持',
  `MEETING_ADDRESS` varchar(128) NOT NULL COMMENT '会议地点',
  `MEETING_DATE` varchar(32) NOT NULL COMMENT '会议时间',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  `UPDATE_DATE` datetime NOT NULL COMMENT '更新时间',
  `UPDATE_USER` int(8) NOT NULL COMMENT '更新用户',
  PRIMARY KEY (`MEETING_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='医生会议信息';

-- ----------------------------
-- Records of doctor_meeting_info
-- ----------------------------

-- ----------------------------
-- Table structure for `doctor_patent_info`
-- ----------------------------
DROP TABLE IF EXISTS `doctor_patent_info`;
CREATE TABLE `doctor_patent_info` (
  `PATENT_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '专利编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账户编号',
  `PATENT_NAME` varchar(128) NOT NULL COMMENT '专利名称',
  `PATENT_CODE` varchar(128) NOT NULL COMMENT '专利编码',
  `PATENT_COUNTRY` varchar(128) NOT NULL COMMENT '注册国家',
  `PATENT_DATE` varchar(32) NOT NULL COMMENT '获批时间',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  `UPDATE_DATE` datetime NOT NULL COMMENT '更新时间',
  `UPDATE_USER` int(8) NOT NULL COMMENT '更新用户',
  PRIMARY KEY (`PATENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='医生专利信息';

-- ----------------------------
-- Records of doctor_patent_info
-- ----------------------------

-- ----------------------------
-- Table structure for `doctor_patient_judge`
-- ----------------------------
DROP TABLE IF EXISTS `doctor_patient_judge`;
CREATE TABLE `doctor_patient_judge` (
  `PATIENT_ID` int(8) NOT NULL AUTO_INCREMENT,
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账户编号',
  `PATIENT_NAME` varchar(128) NOT NULL COMMENT '患者姓名',
  `PATIENT_SEX` int(4) NOT NULL COMMENT '患者性别',
  `PATIENT_AGE` int(4) NOT NULL COMMENT '患者年龄',
  `PATIENT_DESC` varchar(128) NOT NULL COMMENT '病情描述',
  `JUDGE_DATE` date NOT NULL COMMENT '评价时间',
  `JUDGE_DESC` varchar(128) NOT NULL COMMENT '评价描述',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  `UPDATE_DATE` datetime NOT NULL COMMENT '更新时间',
  `UPDATE_USER` int(8) NOT NULL COMMENT '更新用户',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`PATIENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='医生患者评价';

-- ----------------------------
-- Records of doctor_patient_judge
-- ----------------------------

-- ----------------------------
-- Table structure for `doctor_prize_info`
-- ----------------------------
DROP TABLE IF EXISTS `doctor_prize_info`;
CREATE TABLE `doctor_prize_info` (
  `PRIZE_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '奖项编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账户编号',
  `PRIZE_NAME` varchar(128) NOT NULL COMMENT '奖项名称',
  `PRIZE_DATE` varchar(32) NOT NULL COMMENT '获奖时间',
  `AWARD_DEPT` varchar(128) NOT NULL COMMENT '颁奖机构',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  `UPDATE_DATE` datetime NOT NULL COMMENT '更新时间',
  `UPDATE_USER` int(8) NOT NULL COMMENT '更新用户',
  PRIMARY KEY (`PRIZE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='医生奖项信息';

-- ----------------------------
-- Records of doctor_prize_info
-- ----------------------------

-- ----------------------------
-- Table structure for `doctor_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `doctor_user_info`;
CREATE TABLE `doctor_user_info` (
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账户编号',
  `REAL_NAME` varchar(30) NOT NULL COMMENT '真实姓名',
  `ACCOUNT_SEX` int(4) NOT NULL COMMENT '性别\r\n            1.男\r\n            2.女',
  `BIRTH_DATE` varchar(30) DEFAULT NULL COMMENT '出生日期\r\n            存储格式yyyy-MM-dd',
  `HOME_TOWN` varchar(256) DEFAULT NULL COMMENT '故乡',
  `LIVE_TOWN` varchar(256) DEFAULT NULL COMMENT '现居住地\r\n            中国,浙江,杭州',
  `BELONG_HOSPITAL` varchar(50) NOT NULL COMMENT '所在医院',
  `BELONG_DEPT` varchar(50) NOT NULL COMMENT '所在科室',
  `WORK_PROFESS` varchar(30) NOT NULL DEFAULT ' ' COMMENT '工作职称',
  `BELONG_MEDICAL` varchar(50) NOT NULL COMMENT '所属医学会',
  `SPECIL_AREA` text COMMENT '擅长领域',
  `PERSON_INFRO` text COMMENT '个人简介',
  PRIMARY KEY (`ACCOUNT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='医生个人信息';

-- ----------------------------
-- Records of doctor_user_info
-- ----------------------------
INSERT INTO `doctor_user_info` VALUES ('22', '傅水军', '1', '2001-01-01', null, '中国,浙江省,杭州市', '浙江省第一人民医院', '骨科', '主任医师', '', '', '');
INSERT INTO `doctor_user_info` VALUES ('28', '胡维颖', '1', '2001-01-01', null, '中国,浙江省,杭州市', '浙江省第一人民医院', '骨科', '主任医师', '', '', '');
INSERT INTO `doctor_user_info` VALUES ('29', '傅水军', '1', '2001-01-01', null, '中国,浙江省,杭州市', '浙江省第一人民医院', '骨科', '主任医师', '', '', '');
INSERT INTO `doctor_user_info` VALUES ('33', '测试账号1', '1', '2001-01-01', null, '中国,浙江省,杭州市', '浙江省第一人民医院', '骨科', '主治医师', '123', '123', '123');
INSERT INTO `doctor_user_info` VALUES ('37', '测试用户', '1', '2001-01-01', null, '中国,浙江省,杭州市', '浙江省第二人民医院', '骨科', '主治医师', '123123', '123123', '123123');
INSERT INTO `doctor_user_info` VALUES ('38', '测试', '1', '2001-01-01', null, '中国,浙江省,杭州市', '浙江省第一人民医院', '骨科', '副主任医师', '13123', '123', '123123');

-- ----------------------------
-- Table structure for `doctor_work_info`
-- ----------------------------
DROP TABLE IF EXISTS `doctor_work_info`;
CREATE TABLE `doctor_work_info` (
  `WORK_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '工作编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账户编号',
  `COMPANY_NAME` varchar(64) NOT NULL COMMENT '单位名称',
  `START_DATE` varchar(30) NOT NULL COMMENT '起始时间',
  `END_DATE` varchar(30) NOT NULL COMMENT '截至时间',
  `IN_CITY` varchar(32) NOT NULL COMMENT '所在城市',
  `BELONG_DEPT` varchar(32) NOT NULL COMMENT '所在科室',
  `PREFESS_NAME` varchar(32) NOT NULL COMMENT '工作职称',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  `UPDATE_DATE` datetime NOT NULL COMMENT '更新时间',
  `UPDATE_USER` int(8) NOT NULL COMMENT '更新用户',
  PRIMARY KEY (`WORK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='医生工作信息';

-- ----------------------------
-- Records of doctor_work_info
-- ----------------------------

-- ----------------------------
-- Table structure for `proxy_base_info`
-- ----------------------------
DROP TABLE IF EXISTS `proxy_base_info`;
CREATE TABLE `proxy_base_info` (
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账号信息',
  `PROXY_TYPE` int(4) NOT NULL COMMENT '代理商身份',
  `PROXY_TARGET` varchar(30) DEFAULT NULL COMMENT '代理项目',
  `COMPANY_NAME` varchar(256) DEFAULT NULL COMMENT '公司名称',
  `COMPANY_TYPE` int(4) DEFAULT NULL COMMENT '公司类型',
  `LEGAL_NAME` varchar(30) DEFAULT NULL COMMENT '法人名称',
  `COMPANY_INFRO` text COMMENT '公司简介',
  `PERSON_SEX` int(4) DEFAULT NULL COMMENT '个人性别',
  `PERSON_BIRTH` varchar(30) DEFAULT NULL COMMENT '出生年月',
  `LIVE_TOWN` varchar(256) DEFAULT NULL COMMENT '现居城市',
  `PERSON_INFRO` text COMMENT '个人简介',
  `REAL_NAME` varchar(30) DEFAULT NULL COMMENT '联系人姓名',
  `PHONE_NO` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `TEL_NO` varchar(50) DEFAULT NULL COMMENT '固定电话',
  `EMAIL_NO` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `QQ_NO` varchar(50) DEFAULT NULL COMMENT 'QQ号码',
  PRIMARY KEY (`ACCOUNT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代理商基础信息';

-- ----------------------------
-- Records of proxy_base_info
-- ----------------------------
INSERT INTO `proxy_base_info` VALUES ('32', '1', '1,2,3', '123123', '1', '123', '123', '1', '2001-01-01', '中国,浙江省,杭州市', '', null, '123', '', '', '');

-- ----------------------------
-- Table structure for `proxy_license_info`
-- ----------------------------
DROP TABLE IF EXISTS `proxy_license_info`;
CREATE TABLE `proxy_license_info` (
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账户编号',
  `ID_CARD` varchar(30) DEFAULT NULL COMMENT '身份证编码',
  `FRONT_URL` varchar(50) DEFAULT NULL COMMENT '正面地址',
  `BACK_URL` varchar(50) DEFAULT NULL COMMENT '反面地址',
  `LICENSE_NO` varchar(50) DEFAULT NULL COMMENT '营业执照',
  `LICENSE_URL` varchar(50) DEFAULT NULL COMMENT '照片地址',
  PRIMARY KEY (`ACCOUNT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代理商认证信息';

-- ----------------------------
-- Records of proxy_license_info
-- ----------------------------
INSERT INTO `proxy_license_info` VALUES ('32', '', '', '', '123', '/data/renshi/cretificatePath/20150629162956970.jpg');

-- ----------------------------
-- Table structure for `qa_comment`
-- ----------------------------
DROP TABLE IF EXISTS `qa_comment`;
CREATE TABLE `qa_comment` (
  `ID` int(8) NOT NULL COMMENT '评论的编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '评论者的用户编号',
  `CONTENT` text NOT NULL COMMENT '评论的内容',
  `CREATE_DATE` datetime NOT NULL COMMENT '评论的创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '评论的修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子回复的评论表，用户对帖子的回复的内容进行评论';

-- ----------------------------
-- Records of qa_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `qa_mention`
-- ----------------------------
DROP TABLE IF EXISTS `qa_mention`;
CREATE TABLE `qa_mention` (
  `ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '艾特编号',
  `ACCOUNT_ID` int(8) DEFAULT NULL COMMENT '发艾特的用户编号',
  `MSG` varchar(250) NOT NULL COMMENT '艾特信息',
  `IS_READ` char(1) NOT NULL COMMENT '这条艾特信息是否已读',
  `COMMON_ID` int(8) DEFAULT NULL COMMENT '艾特信息所在的评论的ID',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '艾特的创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '艾特的修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论@表';

-- ----------------------------
-- Records of qa_mention
-- ----------------------------

-- ----------------------------
-- Table structure for `qa_post`
-- ----------------------------
DROP TABLE IF EXISTS `qa_post`;
CREATE TABLE `qa_post` (
  `ID` int(8) NOT NULL AUTO_INCREMENT COMMENT 'ID自增',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '帖子的用户编号',
  `TITLE` varchar(200) NOT NULL COMMENT '帖子标题',
  `CONTENT` text NOT NULL COMMENT '帖子内容',
  `CATEGORY` char(2) NOT NULL COMMENT '帖子所属的种类(具体的科室)',
  `CREATE_DATE` datetime NOT NULL COMMENT '帖子创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '帖子修改时间',
  `REPLY_NUM` int(5) NOT NULL DEFAULT '0' COMMENT '帖子的回帖个数',
  `VIEW_NUM` int(5) NOT NULL DEFAULT '0' COMMENT '帖子被浏览次数',
  `FAVORITE_NUM` int(5) NOT NULL DEFAULT '0' COMMENT '帖子被收藏次数',
  `TAG` varchar(100) DEFAULT NULL COMMENT '帖子的标签',
  `STATUS` varchar(10) NOT NULL COMMENT '帖子状态(1:正常开放;2:关闭;3:禁贴)',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子表，用户发帖之后的信息都在这里';

-- ----------------------------
-- Records of qa_post
-- ----------------------------

-- ----------------------------
-- Table structure for `qa_reply`
-- ----------------------------
DROP TABLE IF EXISTS `qa_reply`;
CREATE TABLE `qa_reply` (
  `ID` int(8) NOT NULL COMMENT '回帖编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '回帖者用户编号',
  `CONTENT` text NOT NULL COMMENT '回帖内容',
  `CREATE_DATE` datetime NOT NULL COMMENT '回帖创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '回帖修改时间',
  `FLAG` char(2) NOT NULL COMMENT '1:主动回帖；2:发帖者邀请回答',
  `VOTE_NUM` int(5) NOT NULL DEFAULT '0' COMMENT '点赞次数',
  PRIMARY KEY (`ID`,`ACCOUNT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子的回复表，用户对帖子恢复的信息都在这';

-- ----------------------------
-- Records of qa_reply
-- ----------------------------

-- ----------------------------
-- Table structure for `share_attach_info`
-- ----------------------------
DROP TABLE IF EXISTS `share_attach_info`;
CREATE TABLE `share_attach_info` (
  `ATTACH_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '附件编号',
  `SHARE_ID` int(8) NOT NULL COMMENT '分享编号',
  `ATTACH_TYPE` int(4) NOT NULL COMMENT '附件类型\r\n            1.图片\r\n            2.文件\r\n            3.视频',
  `ATTACH_NAME` varchar(128) NOT NULL COMMENT '附件名称',
  `ATTACH_URL` varchar(128) NOT NULL COMMENT '附件地址',
  `ATTACH_SUFFIX` varchar(32) NOT NULL COMMENT '附件后缀',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`ATTACH_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='分享附件信息';

-- ----------------------------
-- Records of share_attach_info
-- ----------------------------
INSERT INTO `share_attach_info` VALUES ('1', '1', '1', '照片1', '/data/renshi/idCard/20150608203805110.jpg', '.jpg', '1', '2015-06-11 11:00:29');

-- ----------------------------
-- Table structure for `share_collection_info`
-- ----------------------------
DROP TABLE IF EXISTS `share_collection_info`;
CREATE TABLE `share_collection_info` (
  `COLLECTION_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '收藏编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账户编号',
  `SHARE_ID` int(8) NOT NULL COMMENT '分享编号',
  `IS_READ` int(4) NOT NULL COMMENT '是否阅读',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`COLLECTION_ID`),
  UNIQUE KEY `IDX_ACCOUNT_SHARE` (`ACCOUNT_ID`,`SHARE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8 COMMENT='分享收藏信息';

-- ----------------------------
-- Records of share_collection_info
-- ----------------------------
INSERT INTO `share_collection_info` VALUES ('86', '22', '2', '0', '22', '2015-07-01 08:59:33');
INSERT INTO `share_collection_info` VALUES ('90', '22', '1', '0', '22', '2015-07-01 21:48:52');

-- ----------------------------
-- Table structure for `share_discuss_info`
-- ----------------------------
DROP TABLE IF EXISTS `share_discuss_info`;
CREATE TABLE `share_discuss_info` (
  `DISCUSS_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
  `SHARE_ID` int(8) NOT NULL COMMENT '分享编号',
  `PARENT_ID` int(8) NOT NULL COMMENT '上级评论',
  `DISCUSS_TYPE` int(4) NOT NULL COMMENT '评论类型\r\n            1.微博\r\n            2.评论\r\n            3.赞',
  `DISCUSS_CONTENT` varchar(256) NOT NULL COMMENT '评论内容',
  `DISCUSS_PATH` varchar(64) NOT NULL COMMENT '评论层级',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '被评论用户编号',
  `ACCOUNT_NAME` varchar(30) NOT NULL COMMENT '被评论用户姓名',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`DISCUSS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='分享评论信息';

-- ----------------------------
-- Records of share_discuss_info
-- ----------------------------
INSERT INTO `share_discuss_info` VALUES ('2', '2', '0', '3', '332123', '', '22', '傅水军', '2015-06-26 15:10:21', '28');
INSERT INTO `share_discuss_info` VALUES ('3', '2', '0', '3', '123123', '', '28', '胡维颖', '2015-06-26 17:00:56', '22');
INSERT INTO `share_discuss_info` VALUES ('4', '2', '2', '2', '32323', '', '28', '胡维颖', '2015-06-26 17:05:24', '22');
INSERT INTO `share_discuss_info` VALUES ('5', '2', '2', '2', '123123', '', '28', '胡维颖', '2015-06-26 17:07:43', '22');
INSERT INTO `share_discuss_info` VALUES ('6', '2', '3', '2', '123123123', '', '22', '傅水军', '2015-06-26 17:26:41', '28');
INSERT INTO `share_discuss_info` VALUES ('7', '2', '3', '2', '123123123', '', '22', '傅水军', '2015-06-26 17:28:18', '28');
INSERT INTO `share_discuss_info` VALUES ('8', '2', '3', '2', '123123123', '', '22', '傅水军', '2015-06-26 17:29:22', '28');
INSERT INTO `share_discuss_info` VALUES ('9', '2', '3', '2', '123123123', '', '22', '傅水军', '2015-06-26 17:30:28', '28');
INSERT INTO `share_discuss_info` VALUES ('10', '2', '4', '2', '123123', '', '22', '傅水军', '2015-06-26 17:30:47', '28');
INSERT INTO `share_discuss_info` VALUES ('11', '2', '2', '2', '你好吗', '', '28', '胡维颖', '2015-06-30 14:27:18', '22');
INSERT INTO `share_discuss_info` VALUES ('12', '2', '11', '2', '我很好', '', '22', '傅水军', '2015-06-30 14:38:18', '22');
INSERT INTO `share_discuss_info` VALUES ('13', '2', '0', '1', '123123', '', '0', '', '2015-06-30 15:15:46', '22');
INSERT INTO `share_discuss_info` VALUES ('14', '2', '0', '1', '123123', '', '0', '', '2015-06-30 15:16:29', '22');
INSERT INTO `share_discuss_info` VALUES ('15', '2', '14', '2', '123123123', '', '22', '傅水军', '2015-06-30 15:16:34', '22');
INSERT INTO `share_discuss_info` VALUES ('16', '2', '14', '2', '123123123', '', '22', '傅水军', '2015-06-30 15:17:30', '22');
INSERT INTO `share_discuss_info` VALUES ('17', '2', '16', '2', '123213', '', '22', '傅水军', '2015-06-30 15:18:16', '22');
INSERT INTO `share_discuss_info` VALUES ('18', '2', '0', '1', '123123', '', '0', '', '2015-06-30 15:52:46', '22');
INSERT INTO `share_discuss_info` VALUES ('19', '2', '2', '2', '123123', '', '28', '胡维颖', '2015-06-30 15:52:54', '22');
INSERT INTO `share_discuss_info` VALUES ('20', '1', '0', '1', '123123', '', '0', '', '2015-07-01 08:38:56', '22');

-- ----------------------------
-- Table structure for `share_follow_active`
-- ----------------------------
DROP TABLE IF EXISTS `share_follow_active`;
CREATE TABLE `share_follow_active` (
  `FOLLOW_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '关注编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账户编号',
  `FOLLOW_ACCOUNT` int(8) NOT NULL COMMENT '关注人编号',
  `FOLLOW_NAME` varchar(30) NOT NULL COMMENT '关注人姓名',
  `FOLLOW_TYPE` int(4) NOT NULL COMMENT '关注类型，默认1\r\n            1.关注\r\n            2.相互关注',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`FOLLOW_ID`),
  UNIQUE KEY `IDX_ACCOUNT_FOLLOW` (`ACCOUNT_ID`,`FOLLOW_ACCOUNT`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='主动关注信息';

-- ----------------------------
-- Records of share_follow_active
-- ----------------------------
INSERT INTO `share_follow_active` VALUES ('4', '22', '22', '傅水军', '1', '1', '2015-06-11 14:50:27');
INSERT INTO `share_follow_active` VALUES ('5', '28', '28', '傅水军', '1', '1', '2015-06-17 14:33:20');
INSERT INTO `share_follow_active` VALUES ('6', '29', '29', '傅水军', '1', '1', '2015-06-19 10:25:14');
INSERT INTO `share_follow_active` VALUES ('19', '37', '37', '测试用户', '1', '37', '2015-07-01 08:42:15');
INSERT INTO `share_follow_active` VALUES ('20', '38', '38', '测试', '1', '38', '2015-07-01 13:57:06');

-- ----------------------------
-- Table structure for `share_follow_passive`
-- ----------------------------
DROP TABLE IF EXISTS `share_follow_passive`;
CREATE TABLE `share_follow_passive` (
  `FOLLOWED_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '关注编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账户编号',
  `FOLLOWED_ACCOUNT` int(8) NOT NULL COMMENT '关注人编号',
  `FOLLOWED_NAME` varchar(30) NOT NULL,
  `FOLLOW_TYPE` int(4) NOT NULL COMMENT '关注类型，默认1\r\n            1.关注\r\n            2.相互关注',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`FOLLOWED_ID`),
  UNIQUE KEY `IDX_ACCOUNT_FOLLOWED` (`ACCOUNT_ID`,`FOLLOWED_ACCOUNT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='被动关注信息';

-- ----------------------------
-- Records of share_follow_passive
-- ----------------------------

-- ----------------------------
-- Table structure for `share_person_info`
-- ----------------------------
DROP TABLE IF EXISTS `share_person_info`;
CREATE TABLE `share_person_info` (
  `PERSON_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '空间编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '用户编号',
  `FANS_NUM` int(8) NOT NULL DEFAULT '0' COMMENT '粉丝数量',
  `FOLLOW_NUM` int(8) NOT NULL DEFAULT '0' COMMENT '关注数量',
  `BROWER_NUM` int(8) NOT NULL DEFAULT '0' COMMENT '浏览数量',
  `VIDEO_NUM` int(8) NOT NULL DEFAULT '0' COMMENT '视频数量',
  `ARTICLE_NUM` int(8) NOT NULL DEFAULT '0' COMMENT '文章数量',
  `CASE_NUM` int(8) NOT NULL DEFAULT '0' COMMENT '病例数量',
  `COURSE_NUM` int(8) NOT NULL DEFAULT '0' COMMENT '课件数量',
  `QA_NUM` int(8) NOT NULL DEFAULT '0' COMMENT '提问数量',
  `COLLECTION_NUM` int(8) NOT NULL DEFAULT '0' COMMENT '收藏数量',
  `PERSON_STATUS` int(4) NOT NULL COMMENT '空间状态\r\n            0.关闭\r\n            1.开通',
  `PERSON_LEVEL` int(4) DEFAULT '0' COMMENT '空间等级',
  `PERSON_ACTIVE` int(4) DEFAULT '0' COMMENT '活跃度',
  `PERSON_SPECIAL` int(4) DEFAULT '0' COMMENT '空间特权',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_USER` int(8) NOT NULL COMMENT '更新用户',
  `UPDATE_DATE` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`PERSON_ID`),
  UNIQUE KEY `IDX_ACCOUNT_ID` (`ACCOUNT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='个人空间信息';

-- ----------------------------
-- Records of share_person_info
-- ----------------------------
INSERT INTO `share_person_info` VALUES ('4', '22', '1', '2', '14', '0', '0', '0', '0', '0', '2', '1', '0', '0', '0', '1', '2015-06-11 14:50:27', '22', '2015-07-03 14:17:38');
INSERT INTO `share_person_info` VALUES ('5', '28', '1', '1', '6', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '1', '2015-06-17 14:33:20', '22', '2015-07-03 14:13:08');
INSERT INTO `share_person_info` VALUES ('6', '29', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '1', '2015-06-19 10:25:14', '22', '2015-06-29 23:31:42');
INSERT INTO `share_person_info` VALUES ('7', '33', '0', '0', '0', '0', '0', '0', '0', '-1', '-1', '1', '0', '0', '0', '33', '2015-06-29 17:27:35', '33', '2015-06-29 17:27:35');
INSERT INTO `share_person_info` VALUES ('8', '37', '0', '0', '0', '0', '0', '0', '0', '-1', '-1', '1', '0', '0', '0', '37', '2015-07-01 08:42:15', '37', '2015-07-01 08:42:15');
INSERT INTO `share_person_info` VALUES ('9', '38', '0', '0', '1', '0', '0', '0', '0', '-1', '-1', '1', '0', '0', '0', '38', '2015-07-01 13:57:06', '22', '2015-07-01 14:10:36');

-- ----------------------------
-- Table structure for `share_praise_info`
-- ----------------------------
DROP TABLE IF EXISTS `share_praise_info`;
CREATE TABLE `share_praise_info` (
  `PRAISE_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '点赞编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账户编号',
  `SHARE_ID` int(8) NOT NULL COMMENT '分享编号',
  `IS_READ` int(4) NOT NULL COMMENT '是否阅读',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`PRAISE_ID`),
  UNIQUE KEY `IDX_ACCOUNT_SHARE` (`ACCOUNT_ID`,`SHARE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='分享赞信息';

-- ----------------------------
-- Records of share_praise_info
-- ----------------------------
INSERT INTO `share_praise_info` VALUES ('24', '28', '1', '0', '1', '2015-06-26 14:55:40');
INSERT INTO `share_praise_info` VALUES ('37', '22', '2', '0', '22', '2015-07-01 14:02:02');
INSERT INTO `share_praise_info` VALUES ('39', '22', '1', '0', '22', '2015-07-01 21:42:33');

-- ----------------------------
-- Table structure for `share_tag_info`
-- ----------------------------
DROP TABLE IF EXISTS `share_tag_info`;
CREATE TABLE `share_tag_info` (
  `TAG_ID` int(8) NOT NULL COMMENT '标签编号',
  `TAG_NAME` varchar(30) NOT NULL COMMENT '标签名称',
  `SHARE_TYPE` int(8) NOT NULL COMMENT '分享类型',
  `TAG_NUM` int(8) NOT NULL COMMENT '分享数量',
  PRIMARY KEY (`TAG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分享标签信息';

-- ----------------------------
-- Records of share_tag_info
-- ----------------------------

-- ----------------------------
-- Table structure for `share_video_info`
-- ----------------------------
DROP TABLE IF EXISTS `share_video_info`;
CREATE TABLE `share_video_info` (
  `SHARE_ID` int(8) NOT NULL COMMENT '视频编号',
  `VIDEO_URL` varchar(128) NOT NULL COMMENT '视频地址',
  PRIMARY KEY (`SHARE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分享视频信息';

-- ----------------------------
-- Records of share_video_info
-- ----------------------------

-- ----------------------------
-- Table structure for `system_account_info`
-- ----------------------------
DROP TABLE IF EXISTS `system_account_info`;
CREATE TABLE `system_account_info` (
  `ACCOUNT_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `REGISTER_TYPE` int(4) NOT NULL COMMENT '注册方式\r\n            1.手机\r\n            2.邮箱\r\n            3.其他',
  `LOGIN_ACCOUNT` varchar(50) NOT NULL COMMENT '登录账号',
  `LOGIN_PASSWORD` varchar(50) NOT NULL COMMENT '登录密码',
  `HEAD_URL` varchar(50) DEFAULT NULL COMMENT '头像地址',
  `ACCOUNT_TYPE` int(4) NOT NULL COMMENT '账号类型\r\n            1.医生\r\n            2.代理商',
  `ACCOUNT_STATUS` int(4) NOT NULL COMMENT '认证状态\r\n			0.未认证\r\n			1.第一步\r\n			2.第二步\r\n			3.第三步',
  `ACTIVE_TYPE` int(4) NOT NULL COMMENT '激活状态\r\n            0.未激活\r\n            1.已激活',
  `ACTIVE_TIME` datetime DEFAULT NULL COMMENT '激活时间',
  `ACCOUNT_LEVEL` int(4) DEFAULT '0' COMMENT '账号等级',
  `ACCOUNT_SCORE` int(8) DEFAULT '0' COMMENT '账号积分',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_USER` int(8) DEFAULT NULL COMMENT '更新用户',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ACCOUNT_ID`),
  UNIQUE KEY `IDX_LOGIN_ACCOUNT` (`LOGIN_ACCOUNT`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='登录账号信息';

-- ----------------------------
-- Records of system_account_info
-- ----------------------------
INSERT INTO `system_account_info` VALUES ('22', '2', '7463494722@qq.com', '42e491e5e2d4b737533982bd921ec4bf', '/data/renshi/headPath/Jellyfish.jpg', '1', '3', '1', '2015-06-02 19:46:33', '0', '0', '2015-06-02 18:53:48', '2', '2015-06-11 14:50:27');
INSERT INTO `system_account_info` VALUES ('25', '2', '7463494723@qq.com', '73198b03212ef1abf729222438ab4ca2', null, '1', '0', '0', null, '0', '0', '2015-06-15 14:12:32', '1', '2015-06-15 14:12:32');
INSERT INTO `system_account_info` VALUES ('26', '2', 'fushujijun2008@gmail.com', 'eda352760e141f8a06d1622fef34cb59', null, '1', '0', '0', null, '0', '0', '2015-06-17 14:21:48', '1', '2015-06-17 14:21:48');
INSERT INTO `system_account_info` VALUES ('27', '2', 'fushuijun2008@gmail.com', 'eda352760e141f8a06d1622fef34cb59', null, '1', '0', '0', null, '0', '0', '2015-06-17 14:24:50', '1', '2015-06-17 14:24:50');
INSERT INTO `system_account_info` VALUES ('28', '2', 'fushuijun2008@foxmail.com', 'eda352760e141f8a06d1622fef34cb59', '/data/renshi/headPath/20150617143219820.jpg', '1', '3', '1', '2015-06-17 14:29:05', '0', '0', '2015-06-17 14:28:40', '2', '2015-06-17 14:33:20');
INSERT INTO `system_account_info` VALUES ('29', '2', 'fushuijun2008@live.com', 'eda352760e141f8a06d1622fef34cb59', '/data/renshi/headPath/20150619102353464.jpg', '1', '3', '1', '2015-06-19 10:23:00', '0', '0', '2015-06-19 10:21:45', '2', '2015-06-19 10:25:14');
INSERT INTO `system_account_info` VALUES ('38', '2', '746349472@qq.com', 'c3034b685efeb526fb4392e683e258ff', '/data/renshi/headPath/20150701135520588.jpg', '1', '3', '1', '2015-07-01 13:54:54', '0', '0', '2015-07-01 13:54:20', '38', '2015-07-01 13:57:06');

-- ----------------------------
-- Table structure for `system_valid_mail`
-- ----------------------------
DROP TABLE IF EXISTS `system_valid_mail`;
CREATE TABLE `system_valid_mail` (
  `VALID_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '校验编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '用户编号',
  `VALID_TYPE` int(4) NOT NULL COMMENT '校验类型\r\n            1.注册邮件\r\n            2.忘记密码',
  `VALID_KEY` varchar(128) NOT NULL COMMENT '加密编码',
  `EXPIRE_DATE` datetime NOT NULL COMMENT '过期时间',
  `VALID_BOOL` int(4) NOT NULL COMMENT '是否校验\r\n            0.未使用\r\n            1.已使用',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`VALID_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='数据校验信息\r\n用于校验短信验证码和邮件链接地址';

-- ----------------------------
-- Records of system_valid_mail
-- ----------------------------
INSERT INTO `system_valid_mail` VALUES ('13', '22', '1', '41cdb618-c888-4c7f-8270-97208171993c', '2015-06-02 20:53:48', '1', '2015-06-02 18:53:48');
INSERT INTO `system_valid_mail` VALUES ('14', '22', '2', '62982653-34aa-46f9-bda0-2c149e89c5a7', '2015-06-10 16:16:38', '1', '2015-06-08 16:16:38');
INSERT INTO `system_valid_mail` VALUES ('15', '23', '1', '869b93d7-48ff-4549-8b37-fa050428cde1', '2015-06-14 16:57:08', '0', '2015-06-12 16:57:08');
INSERT INTO `system_valid_mail` VALUES ('16', '24', '1', '377b86b0-df32-4554-90ce-8e48041809bc', '2015-06-14 16:58:47', '0', '2015-06-12 16:58:47');
INSERT INTO `system_valid_mail` VALUES ('17', '24', '2', '2750d581-5817-40f7-b23f-a511e829a0ca', '2015-06-14 17:17:51', '0', '2015-06-12 17:17:51');
INSERT INTO `system_valid_mail` VALUES ('18', '24', '2', '6edb32cf-edf0-44d7-8fc9-408199d1e0f5', '2015-06-14 17:30:15', '0', '2015-06-12 17:30:15');
INSERT INTO `system_valid_mail` VALUES ('19', '25', '1', 'a20dd31b-03d8-4b4a-b182-c91288439f0e', '2015-06-17 14:12:32', '0', '2015-06-15 14:12:32');
INSERT INTO `system_valid_mail` VALUES ('20', '26', '1', '27da26a3-5516-4a9d-81b2-c9bbce2381d9', '2015-06-19 14:21:48', '0', '2015-06-17 14:21:48');
INSERT INTO `system_valid_mail` VALUES ('21', '27', '1', '0fa334f8-691a-409c-b0fb-767955db30b3', '2015-06-19 14:24:50', '0', '2015-06-17 14:24:50');
INSERT INTO `system_valid_mail` VALUES ('22', '28', '1', '3cef6dd8-68e7-4ea9-bf1a-cffb001d0a08', '2015-06-19 14:28:40', '1', '2015-06-17 14:28:40');
INSERT INTO `system_valid_mail` VALUES ('23', '29', '1', '41ab1c17-1099-43e0-be26-f7e0af4059c2', '2015-06-21 10:21:45', '1', '2015-06-19 10:21:45');
INSERT INTO `system_valid_mail` VALUES ('24', '29', '2', 'bb1528cc-d2b4-44e2-947e-3841b89d6534', '2015-06-21 10:28:33', '0', '2015-06-19 10:28:33');
INSERT INTO `system_valid_mail` VALUES ('25', '30', '1', 'ff992991-5893-48d1-84e4-460a2b68a77d', '2015-07-01 15:24:36', '0', '2015-06-29 15:24:36');
INSERT INTO `system_valid_mail` VALUES ('26', '31', '1', '4d50c750-9107-46ae-bbe3-14f550efbfba', '2015-07-01 15:26:05', '0', '2015-06-29 15:26:05');
INSERT INTO `system_valid_mail` VALUES ('27', '32', '1', 'd9719944-c34f-42ef-9b81-8e84393da7d9', '2015-07-01 15:27:01', '1', '2015-06-29 15:27:01');
INSERT INTO `system_valid_mail` VALUES ('28', '33', '1', 'e18a9527-425f-4559-8886-8c492096b6b3', '2015-07-01 17:23:24', '1', '2015-06-29 17:23:24');
INSERT INTO `system_valid_mail` VALUES ('29', '34', '1', '55cf8070-fdfa-4d9b-937b-acef8bb96ce8', '2015-07-01 20:47:10', '0', '2015-06-29 20:47:10');
INSERT INTO `system_valid_mail` VALUES ('30', '35', '1', '799d1356-fe43-4cab-afa0-98372735c0bc', '2015-07-01 20:48:27', '0', '2015-06-29 20:48:27');
INSERT INTO `system_valid_mail` VALUES ('31', '36', '1', '41c9a411-0c9f-4077-a568-0c89a82b1f5a', '2015-07-01 20:50:05', '1', '2015-06-29 20:50:05');
INSERT INTO `system_valid_mail` VALUES ('32', '37', '1', '3f3b39d9-6aaa-4bbf-af99-e3458ffe2ce8', '2015-07-03 08:41:21', '1', '2015-07-01 08:41:21');
INSERT INTO `system_valid_mail` VALUES ('33', '38', '1', '6ce50160-6104-44f4-9587-de4d3f85549c', '2015-07-03 13:54:20', '1', '2015-07-01 13:54:20');



-- ----------------------------
-- 后台系统表
-- ----------------------------
DROP TABLE IF EXISTS `admin_permission`;
CREATE TABLE `admin_permission` (
  `PERM_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `PERM_NAME` varchar(50) NOT NULL COMMENT '权限名称',
  `PERM_DESC` varchar(250) DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`PERM_ID`),
  KEY `ID` (`PERM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台权限管理表';


DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `ROLE_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `ROLE_NAME` varchar(50) NOT NULL COMMENT '角色名称',
  `ROLE_DESC` varchar(250) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`ROLE_ID`),
  KEY `ROLE_ID` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台管理角色表';


DROP TABLE IF EXISTS `admin_role_permission`;
CREATE TABLE `admin_role_permission` (
  `ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `ROLE_ID` int(8) DEFAULT NULL COMMENT '角色编号',
  `PERM_ID` int(8) DEFAULT NULL COMMENT '权限编号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `admin_user_role`;
CREATE TABLE `admin_user_role` (
  `ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `USER_ID` int(8) DEFAULT NULL COMMENT '用户编号',
  `ROLE_ID` int(8) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台用户角色表';


DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `USER_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '后台用户编号',
  `PARENT_ID` int(8) DEFAULT NULL COMMENT '父帐号用户编号,只有子帐号才有父帐号',
  `LOGIN_ACCOUNT` varchar(50) DEFAULT NULL COMMENT '登录用户名',
  `LOGIN_PASSWORD` varchar(250) DEFAULT NULL COMMENT '登录密码',
  `USER_TYPE` char(2) NOT NULL COMMENT '用户类型(1:认仕网管理员、2:代理商、3:代理商子账号)',
  `EMAIL` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `PHONE` varchar(50) DEFAULT NULL COMMENT '用户手机号',
  `STATUS` int(2) DEFAULT NULL COMMENT '状态(1:待认证、2:已认证、3:认证失败、4:已解约)',
  `INVITER` int(8) DEFAULT NULL COMMENT '代理商邀请方',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_USER` int(8) DEFAULT NULL COMMENT '更新用户',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`USER_ID`),
  KEY `USER_ID` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='后台管理用户表';


drop table if exists share_case_info;

/*==============================================================*/
/* Table: SHARE_CASE_INFO                                       */
/*==============================================================*/
create table share_case_info
(
   SHARE_ID             int(8) not null comment '案例编号',
   PATIENT_SEX          varchar(30) comment '病人性别',
   PATIENT_AGE          varchar(30) comment '病人年龄',
   ILLNESS_DESC         varchar(256) comment '现病史',
   CHECK_RESULT         varchar(256) comment '检查结果',
   primary key (SHARE_ID)
);

alter table share_case_info comment '分享病例信息';

drop table if exists share_question_info;


/*==============================================================*/
/* Table: SHARE_QUESTION_INFO                                   */
/*==============================================================*/
create table share_question_info
(
   SHARE_ID             int(8) not null comment '案例编号',
   PATIENT_SEX          varchar(30) comment '病人性别',
   PATIENT_AGE          varchar(30) comment '病人年龄',
   ILLNESS_DESC         varchar(256) comment '现病史',
   CHECK_RESULT         varchar(256) comment '检查结果',
   primary key (SHARE_ID)
);

alter table share_question_info comment '分享医问信息';


-- ----------------------------
-- Table structure for `system_area_info`
-- ----------------------------
DROP TABLE IF EXISTS `system_area_info`;
CREATE TABLE `system_area_info` (
  `AREA_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '医院编号',
  `PARENT_ID` int(8) NOT NULL COMMENT '归属地市',
  `FIRST_CHAR` varchar(16) DEFAULT NULL COMMENT '地市首字母',
  `AREA_NAME` varchar(256) NOT NULL COMMENT '医院名称',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_USER` int(8) NOT NULL COMMENT '更新用户',
  `UPDATE_DATE` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`AREA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='地市信息';

-- ----------------------------
-- Records of system_area_info
-- ----------------------------

-- ----------------------------
-- Table structure for `system_dept_info`
-- ----------------------------
DROP TABLE IF EXISTS `system_dept_info`;
CREATE TABLE `system_dept_info` (
  `DEPT_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '科室编号',
  `HOSPITAL_ID` int(8) NOT NULL COMMENT '归属医院',
  `DEPT_NAME` varchar(256) NOT NULL COMMENT '科室名称',
  `DEPT_TYPE` int(4) NOT NULL COMMENT '科室类型\r\n            1.一级科室\r\n            2.二级科室',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_USER` int(8) NOT NULL COMMENT '更新用户',
  `UPDATE_DATE` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`DEPT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='科室信息';

-- ----------------------------
-- Records of system_dept_info
-- ----------------------------

-- ----------------------------
-- Table structure for `system_hospital_info`
-- ----------------------------
DROP TABLE IF EXISTS `system_hospital_info`;
CREATE TABLE `system_hospital_info` (
  `HOSPITAL_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '医院编号',
  `AREA_ID` int(8) NOT NULL COMMENT '归属地市',
  `HOSPITAL_NAME` varchar(256) NOT NULL COMMENT '医院名称',
  `CREATE_USER` int(8) NOT NULL COMMENT '创建用户',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_USER` int(8) NOT NULL COMMENT '更新用户',
  `UPDATE_DATE` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`HOSPITAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='医院信息';

-- ----------------------------
-- Records of system_hospital_info
-- ----------------------------

ALTER TABLE `admin_user`
ADD COLUMN `STATUS`  int(2) NULL AFTER `PARENT_ID`,
ADD COLUMN `INVITER`  int(8) NULL AFTER `STATUS`;

-- ----------------------------
-- Table structure for `share_msg_content`
-- ----------------------------
DROP TABLE IF EXISTS `share_msg_content`;
CREATE TABLE `share_msg_content` (
  `CONTENT_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '消息编号',
  `MSG_ID` int(8) NOT NULL COMMENT '私信编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账户编号',
  `MSG_CONTENT` text NOT NULL COMMENT '内容编号',
  `SEND_DATE` datetime NOT NULL COMMENT '发送时间',
  PRIMARY KEY (`CONTENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='私信内容信息';

-- ----------------------------
-- Table structure for `share_msg_info`
-- ----------------------------
DROP TABLE IF EXISTS `share_msg_info`;
CREATE TABLE `share_msg_info` (
  `MSG_ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '私信编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '账户编号',
  `ACCOUNTED_ID` int(8) NOT NULL COMMENT '被聊天编号',
  `SEND_DATE` datetime NOT NULL COMMENT '最新发送时间',
  `MSG_COUNT` int(8) NOT NULL COMMENT '未读条数',
  `MSGDED_COUNT` int(8) NOT NULL COMMENT '被未度条数',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `MSG_CONTENT` text,
  PRIMARY KEY (`MSG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='私信列表信息';


CREATE TABLE `agent_doctor_relation` (
  `ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `AGENT_USER_ID` int(8) NOT NULL COMMENT '代理商用户编号(对应admin_user表中userid)',
  `DOCTOR_USER_ID` int(8) NOT NULL COMMENT '医生用户编号(对应system_account_info表中医生的账户编号)',
  `PROXY_STATUS` int(2) DEFAULT NULL COMMENT '代理关系状态(1:待审批、2:审批失败、3:代理中、4:解约中、5:已解约)',
  `CREATE_USER` int(8) DEFAULT NULL COMMENT '创建用户',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER` int(8) DEFAULT NULL COMMENT '更新用户',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='代理商医生代理关系表'