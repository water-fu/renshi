USE `renshi`;

/*Table structure for table `QA_COMMENT` */

DROP TABLE IF EXISTS `QA_COMMENT`;

CREATE TABLE `QA_COMMENT` (
  `ID` int(8) NOT NULL COMMENT '评论的编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '评论者的用户编号',
  `CONTENT` text NOT NULL COMMENT '评论的内容',
  `CREATE_DATE` datetime NOT NULL COMMENT '评论的创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '评论的修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子回复的评论表，用户对帖子的回复的内容进行评论';



/*Table structure for table `QA_MENTION` */

DROP TABLE IF EXISTS `QA_MENTION`;

CREATE TABLE `QA_MENTION` (
  `ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '艾特编号',
  `ACCOUNT_ID` int(8) DEFAULT NULL COMMENT '发艾特的用户编号',
  `MSG` varchar(250) NOT NULL COMMENT '艾特信息',
  `IS_READ` char(1) NOT NULL COMMENT '这条艾特信息是否已读',
  `COMMON_ID` int(8) DEFAULT NULL COMMENT '艾特信息所在的评论的ID',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '艾特的创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '艾特的修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论@表';



/*Table structure for table `QA_POST` */

DROP TABLE IF EXISTS `QA_POST`;

CREATE TABLE `QA_POST` (
  `ID` int(8) NOT NULL AUTO_INCREMENT COMMENT 'ID自增',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '帖子的用户编号',
  `TITLE` varchar(200) NOT NULL COMMENT '帖子标题',
  `CONTENT` text NOT NULL COMMENT '帖子内容',
  `CATEGORY` char(2) NOT NULL COMMENT '帖子所属的种类(具体的科室)',
  `CREATE_DATE` datetime NOT NULL COMMENT '帖子创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '帖子修改时间',
  `VIEW_NUM` int(5) NOT NULL DEFAULT '0' COMMENT '帖子被浏览次数',
  `VOTE_NUM` int(5) DEFAULT '0' COMMENT '帖子点赞个数',
  `REPLY_NUM` int(5) NOT NULL DEFAULT '0' COMMENT '帖子评论个数',
  `FAVORITE_NUM` int(5) NOT NULL DEFAULT '0' COMMENT '帖子被收藏次数',
  `TAG` varchar(100) DEFAULT NULL COMMENT '帖子的标签',
  `STATUS` varchar(10) NOT NULL COMMENT '帖子状态(1:正常开放;2:关闭;3:禁贴)',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子表，用户发帖之后的信息都在这里';



/*Table structure for table `QA_REPLY` */

DROP TABLE IF EXISTS `QA_REPLY`;

CREATE TABLE `QA_REPLY` (
  `ID` int(8) NOT NULL COMMENT '回帖编号',
  `ACCOUNT_ID` int(8) NOT NULL COMMENT '回帖者用户编号',
  `CONTENT` text NOT NULL COMMENT '回帖内容',
  `CREATE_DATE` datetime NOT NULL COMMENT '回帖创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '回帖修改时间',
  `FLAG` char(2) NOT NULL COMMENT '1:主动回帖；2:发帖者邀请回答',
  `VOTE_NUM` int(5) NOT NULL DEFAULT '0' COMMENT '点赞次数',
  PRIMARY KEY (`ID`,`ACCOUNT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子的回复表，用户对帖子恢复的信息都在这';
