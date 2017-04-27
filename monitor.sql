/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : monitor

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2016-11-09 16:10:01
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `crop`
-- ----------------------------
DROP TABLE IF EXISTS `crop`;
CREATE TABLE `crop` (
  `id` int(11) NOT NULL auto_increment,
  `Time_create` datetime default NULL,
  `Temperature` float NOT NULL,
  `Reserve` float default NULL,
  `Voltage` int(11) default NULL,
  `Soil_temperature` int(11) default NULL,
  `CO2` int(11) NOT NULL,
  `AINCH3` int(11) default NULL,
  `AINCH4` int(11) default NULL,
  `AINCH5` int(11) default NULL,
  `AINCH6` int(11) default NULL,
  `AINCH7` int(11) default NULL,
  `AINCH8` int(11) default NULL,
  `KIN` int(11) NOT NULL,
  `Illumination` int(11) NOT NULL,
  `Temperature_S` float NOT NULL,
  `Humidity` float default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of crop
-- ----------------------------
INSERT INTO crop VALUES ('12', '2016-11-08 16:38:28', '19.4', '319.9', '12', '4317', '5689', '0', '0', '0', '0', '0', '0', '0', '0', '20.3', '61.1');
INSERT INTO crop VALUES ('13', '2016-11-08 16:38:32', '19.4', '319.9', '12', '4284', '5689', '0', '0', '0', '0', '0', '0', '0', '0', '20.3', '61.1');
INSERT INTO crop VALUES ('14', '2016-11-08 16:38:37', '19.4', '319.9', '12', '4267', '5689', '0', '0', '0', '0', '0', '0', '0', '0', '20.3', '61.1');
INSERT INTO crop VALUES ('15', '2016-11-08 16:38:42', '19.4', '319.9', '12', '4284', '5689', '0', '0', '0', '8', '2', '0', '0', '0', '20.3', '61.1');
INSERT INTO crop VALUES ('16', '2016-11-08 16:38:47', '19.4', '319.9', '12', '4284', '5689', '0', '0', '0', '0', '0', '0', '0', '0', '20.3', '61.1');
INSERT INTO crop VALUES ('17', '2016-11-08 16:38:52', '19.4', '319.9', '12', '4300', '5689', '0', '0', '0', '15', '0', '0', '0', '0', '20.3', '61.2');
INSERT INTO crop VALUES ('18', '2016-11-08 16:38:58', '19.4', '319.9', '12', '4317', '5689', '0', '0', '0', '0', '0', '0', '0', '0', '20.3', '61.2');

-- ----------------------------
-- Table structure for `diagnosis`
-- ----------------------------
DROP TABLE IF EXISTS `diagnosis`;
CREATE TABLE `diagnosis` (
  `id` int(18) NOT NULL auto_increment,
  `name` varchar(100) collate utf8_bin NOT NULL,
  `isPublished` int(1) NOT NULL default '0',
  `isDeleted` tinyint(1) NOT NULL default '0',
  `time_create` datetime default NULL,
  `time_modified` datetime default NULL,
  `resolvent` varchar(255) collate utf8_bin default NULL,
  `advice` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of diagnosis
-- ----------------------------
INSERT INTO diagnosis VALUES ('21', '辣椒', '0', '0', '2016-11-07 15:26:20', '2016-11-07 15:26:20', '<span class=\"ft\">解决方法</span>', '<span class=\"ft\">专家建议</span>');
INSERT INTO diagnosis VALUES ('22', '个人股', '0', '1', '2016-11-07 15:28:17', '2016-11-07 15:29:14', 'tertiary', '额外');

-- ----------------------------
-- Table structure for `expert`
-- ----------------------------
DROP TABLE IF EXISTS `expert`;
CREATE TABLE `expert` (
  `id` int(18) NOT NULL auto_increment,
  `name` varchar(50) collate utf8_bin default NULL,
  `sex` int(11) NOT NULL,
  `age` varchar(255) collate utf8_bin NOT NULL,
  `title` varchar(255) collate utf8_bin NOT NULL,
  `studiec` varchar(255) collate utf8_bin default NULL,
  `goodat` varchar(50) collate utf8_bin default NULL,
  `isPublished` int(1) NOT NULL default '0',
  `isDeleted` tinyint(1) NOT NULL default '0',
  `time_create` datetime default NULL,
  `time_modified` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of expert
-- ----------------------------
INSERT INTO expert VALUES ('18', '张三', '0', '人味儿人', '温柔', 'w', '人味儿', '0', '0', '2016-11-07 16:21:47', '2016-11-07 16:22:03');

-- ----------------------------
-- Table structure for `groups`
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL,
  `memo` varchar(255) default NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  `company_id` int(11) default NULL,
  `par_id` varchar(32) default NULL,
  `isDeleted` int(12) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of groups
-- ----------------------------
INSERT INTO groups VALUES ('1', '大地1', '大地', '2016-01-21 15:20:04', '2016-01-21 15:23:43', '0', null, '1');
INSERT INTO groups VALUES ('2', '技术部', '技术', '2016-01-21 15:23:50', '2016-01-21 16:37:11', '0', null, '0');

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL auto_increment,
  `login_name` varchar(32) default NULL,
  `password` varchar(32) default NULL,
  `state` int(11) default '0',
  `is_admin` char(1) default 'n',
  `time_create` datetime default NULL,
  `time_modified` datetime default NULL,
  `username` varchar(32) default NULL,
  `tel` varchar(32) default NULL,
  `role_id` int(11) default NULL,
  `group_id` int(11) default NULL,
  `userType` int(11) default NULL,
  `isDeleted` int(11) default NULL,
  `shop_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1002 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO member VALUES ('999', 'admin', '1', '0', '', '2016-11-07 09:55:11', '2016-11-08 09:55:18', 'admin', '1', '1000', '0', '1', '0', '0');
INSERT INTO member VALUES ('1000', '张三', '111', '0', null, '2016-11-08 09:59:45', '2016-11-08 09:59:45', null, '123', '1000', '0', '0', '0', '0');
INSERT INTO member VALUES ('1001', '李四', '111', '0', null, '2016-11-08 10:19:45', '2016-11-08 10:33:56', null, '1231', '12', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for `module`
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `id` int(32) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL,
  `memo` varchar(255) default NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  `isDeleted` int(12) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module
-- ----------------------------

-- ----------------------------
-- Table structure for `products`
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int(18) NOT NULL auto_increment,
  `goodsname` varchar(100) collate utf8_bin NOT NULL,
  `img` varchar(255) collate utf8_bin NOT NULL,
  `basetype` varchar(255) collate utf8_bin NOT NULL,
  `plantingtime` varchar(255) collate utf8_bin NOT NULL,
  `expectedmatur` varchar(255) collate utf8_bin NOT NULL,
  `name` varchar(50) collate utf8_bin default NULL,
  `household` varchar(255) collate utf8_bin default NULL,
  `phone` varchar(50) collate utf8_bin default NULL,
  `address` varchar(255) collate utf8_bin default NULL,
  `isPublished` int(1) NOT NULL default '0',
  `isDeleted` tinyint(1) NOT NULL default '0',
  `time_create` datetime default NULL,
  `time_modified` datetime default NULL,
  `position` varchar(255) collate utf8_bin default NULL,
  `number` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO products VALUES ('12', '52', '/attached/image/20161027/20161027150105_181.png', '54', '', '', '52', '52', '52', '52', '52', '0', '2016-10-27 15:01:16', '2016-10-27 15:01:16', null, null);
INSERT INTO products VALUES ('13', '亲亲', '/attached/image/20161027/20161027151009_479.jpg', '12', '', '', '去', '去', '23', '我去', '1', '1', '2016-10-27 15:10:32', '2016-11-08 10:51:15', null, null);
INSERT INTO products VALUES ('14', '12', '/attached/image/20161027/20161027152746_600.png', '12', '', '', 'w', 'w', 'w', 'w', '0', '0', '2016-10-27 15:28:02', '2016-10-27 15:28:02', null, null);
INSERT INTO products VALUES ('15', '方式', '/attached/image/20161027/20161027153245_58.jpg', '54', 'g', 'g', 'qw', 'qw', 'qw', 'qw', '1', '0', '2016-10-27 15:33:03', '2016-10-27 15:49:05', null, null);
INSERT INTO products VALUES ('16', 'rrrr', '/attached/image/20161027/20161027162302_59.jpg', 'e', '2016-09-27', '2016-10-12', 'f', 'f', 'f', 'f', '0', '1', '2016-10-27 16:23:12', '2016-10-27 16:36:39', null, null);
INSERT INTO products VALUES ('17', '辣椒', '/attached/image/20161107/20161107140537_692.jpg', '222', '2016-11-01', '2016-11-02', '3123', '3123', '312', '312', '0', '0', '2016-11-07 14:05:53', '2016-11-07 14:10:54', null, null);

-- ----------------------------
-- Table structure for `resources`
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `id` int(11) NOT NULL auto_increment,
  `created_date` int(11) default NULL,
  `last_updated_date` int(11) default NULL,
  `type` varchar(32) NOT NULL default '',
  `value` varchar(128) default NULL,
  `isDeleted` int(12) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10791 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of resources
-- ----------------------------
INSERT INTO resources VALUES ('10705', '1457920934', '1457920934', 'hfl', '空气滤芯', '0');
INSERT INTO resources VALUES ('10706', '1457920948', '1457920948', 'hfl', '空压机油', '0');
INSERT INTO resources VALUES ('10707', '1457920954', '1457920954', 'hfl', '油滤', '0');
INSERT INTO resources VALUES ('10708', '1457920967', '1457920971', 'hfl', '测试', '1');
INSERT INTO resources VALUES ('10709', '0', '1457920989', 'hfl', '螺杆测试类别', '0');
INSERT INTO resources VALUES ('10710', '1457921120', '1457921120', 'hpp', '惠普', '0');
INSERT INTO resources VALUES ('10711', '1457921130', '1457921130', 'hpp', '捷豹螺杆', '0');
INSERT INTO resources VALUES ('10712', '1457921161', '1457921161', 'hpp', '安达', '0');
INSERT INTO resources VALUES ('10713', '1457921184', '1457921184', 'hpp', '大丰振东', '0');
INSERT INTO resources VALUES ('10714', '1457921201', '1457921201', 'hpp', '晶科', '0');
INSERT INTO resources VALUES ('10715', '1457921240', '1457921240', 'hpp', '奥斯曼', '0');
INSERT INTO resources VALUES ('10716', '1457921247', '1457921247', 'hpp', '1', '0');
INSERT INTO resources VALUES ('10717', '1457921248', '1457921248', 'hpp', '2', '0');
INSERT INTO resources VALUES ('10718', '1457921249', '1457921249', 'hpp', '3', '0');
INSERT INTO resources VALUES ('10719', '1457921250', '1457921250', 'hpp', '4', '0');
INSERT INTO resources VALUES ('10720', '0', '1457921554', 'hpp', '55555', '0');
INSERT INTO resources VALUES ('10721', '1457921252', '1457921545', 'hpp', '6', '1');
INSERT INTO resources VALUES ('10722', '1457921283', '1457921283', 'hfl', '1', '0');
INSERT INTO resources VALUES ('10723', '1457921284', '1458193169', 'hfl', '2', '1');
INSERT INTO resources VALUES ('10724', '1457921285', '1457921285', 'hfl', '3', '0');
INSERT INTO resources VALUES ('10725', '1457921286', '1457921286', 'hfl', '4', '0');
INSERT INTO resources VALUES ('10726', '1457921287', '1457921287', 'hfl', '5', '0');
INSERT INTO resources VALUES ('10727', '1457921288', '1457921288', 'hfl', '6', '0');
INSERT INTO resources VALUES ('10728', '1457921289', '1457921289', 'hfl', '7', '0');
INSERT INTO resources VALUES ('10729', '0', '1458193156', 'hfl', '88888', '1');
INSERT INTO resources VALUES ('10730', '1457921291', '1457921527', 'hfl', '9', '1');
INSERT INTO resources VALUES ('10731', '1457921665', '1457921665', 'hcj', '南京金吉机械设备有限公司专业开发', '0');
INSERT INTO resources VALUES ('10732', '1457921671', '1457921671', 'hcj', '舟山螺杆厂', '0');
INSERT INTO resources VALUES ('10733', '1457921690', '1457921690', 'hcj', '伺服螺杆厂家', '0');
INSERT INTO resources VALUES ('10734', '1457921707', '1457921707', 'hcj', '东莞思诺达机电公司', '0');
INSERT INTO resources VALUES ('10735', '1457921752', '1457921752', 'hcj', '金华市鑫格林机电设备有限公司', '0');
INSERT INTO resources VALUES ('10736', '1457921754', '1457921754', 'hcj', '1231312', '0');
INSERT INTO resources VALUES ('10737', '1457921758', '1457921758', 'hcj', '1', '0');
INSERT INTO resources VALUES ('10738', '1457921759', '1457921759', 'hcj', '2', '0');
INSERT INTO resources VALUES ('10739', '0', '1457922065', 'hcj', '3555', '0');
INSERT INTO resources VALUES ('10740', '1457921761', '1457922057', 'hcj', '4', '1');
INSERT INTO resources VALUES ('10741', '1457922401', '1458193159', 'hfl', '舟山市定海旭泰机械有限公司主要致力于平行双螺杆、锥形双螺杆；单螺杆挤出机、注塑机、橡胶熔胶机、化纤机的主要部件—机筒螺杆的专业生产。', '1');
INSERT INTO resources VALUES ('10742', '1457922411', '1457927329', 'hfl', '舟山市定海旭泰机械有限公司主要致力于平行双螺杆、锥形双螺杆；单螺杆挤出机、注塑机、橡胶熔胶机、化纤机的主要部件—机筒螺杆的专业生产。 产品材质均采用优质38CrMOALA经调制、成型、定性、氮化、（或喷焊双合金）精磨、抛光等工艺精制而成，具有极高的精密度、', '1');
INSERT INTO resources VALUES ('10743', '1457922442', '1458193154', 'hfl', '~!@#$%^&*()_+|}{', '1');
INSERT INTO resources VALUES ('10744', '1457922452', '1458193196', 'hpp', '舟山市定海旭泰机械有限公', '0');
INSERT INTO resources VALUES ('10780', '1458193201', '1458193204', 'hpp', '444ds', '0');
INSERT INTO resources VALUES ('10781', '1458193306', '1458193312', 'hcj', 'ere444', '0');
INSERT INTO resources VALUES ('10782', '1458195703', '1458195703', 'gg', '80', '0');
INSERT INTO resources VALUES ('10783', '1458195710', '1458195710', 'gg', '1000', '0');
INSERT INTO resources VALUES ('10745', '1457922465', '1457922465', 'hcj', '舟山市定海旭泰机械有限公司主要致力于平行双螺杆、锥形双螺杆；单螺杆挤出机、注塑机、橡胶熔胶机、化纤机的主要部件—机筒螺杆的专业生产。 产品材质均采用优质38CrMOALA经调制、成型、定性、氮化、（或喷焊双合金）精磨、抛光等工艺精制而成，具有极高的精密度、', '0');
INSERT INTO resources VALUES ('10746', '1457922485', '1457922485', 'hpp', '~!@#$%^&*()_+\\][;\',/.<>?:\"{}|', '0');
INSERT INTO resources VALUES ('10747', '1457922498', '1457922498', 'hcj', '~!@#$%^&*()_+\\][;\',/.<>?:\"{}|', '0');
INSERT INTO resources VALUES ('10748', '1457942439', '1457942439', 'pm', '45号钢', '0');
INSERT INTO resources VALUES ('10749', '1457942448', '1457942448', 'pm', '40Cr', '0');
INSERT INTO resources VALUES ('10750', '1457942455', '1457942455', 'pm', '氨化钢', '0');
INSERT INTO resources VALUES ('10751', '1457942461', '1457942461', 'pm', '38CrMOAl', '0');
INSERT INTO resources VALUES ('10752', '1457942467', '1457942467', 'pm', '高温合金', '0');
INSERT INTO resources VALUES ('10753', '0', '1457945806', 'pm', '测试品名', '1');
INSERT INTO resources VALUES ('10754', '1457942569', '1457942579', 'pm', '是搜', '1');
INSERT INTO resources VALUES ('10755', '1457945345', '1457945804', 'pm', '555', '1');
INSERT INTO resources VALUES ('10756', '1457945346', '1457945802', 'pm', '4564', '1');
INSERT INTO resources VALUES ('10757', '1457945347', '1457945800', 'pm', '32', '1');
INSERT INTO resources VALUES ('10758', '1457945348', '1457945798', 'pm', '2342', '1');
INSERT INTO resources VALUES ('10759', '1457945349', '1457945796', 'pm', '553', '1');
INSERT INTO resources VALUES ('10760', '1457945414', '1457945414', 'cj', '苏州利波螺杆', '0');
INSERT INTO resources VALUES ('10761', '1457945425', '1457945425', 'cj', '上海柿德', '0');
INSERT INTO resources VALUES ('10762', '1457945433', '1457945433', 'cj', '~!@#$%^&*()_+\\][;\',/.<>?:\"{}|', '0');
INSERT INTO resources VALUES ('10763', '1457945443', '1457945443', 'cj', '上海昱彦', '0');
INSERT INTO resources VALUES ('10764', '1457945458', '1457945458', 'cj', '深圳金鑫', '0');
INSERT INTO resources VALUES ('10765', '1457945601', '1457945601', 'gy', '耐高温,', '0');
INSERT INTO resources VALUES ('10766', '1457945613', '1457945613', 'gy', '耐磨损,寿命长', '0');
INSERT INTO resources VALUES ('10767', '1457945648', '1457945648', 'gy', '耐腐蚀，物料具有腐蚀性', '0');
INSERT INTO resources VALUES ('10768', '1457945658', '1457945658', 'gy', '高强度，可承受大扭矩，高转速', '0');
INSERT INTO resources VALUES ('10769', '1457945666', '1457945666', 'gy', '具有良好的切削加工性能', '0');
INSERT INTO resources VALUES ('10770', '1457945677', '1457945677', 'gy', '热处理后残余应力小，热变形小等。', '0');
INSERT INTO resources VALUES ('10771', '1457945737', '1458195713', 'gg', 'kg', '1');
INSERT INTO resources VALUES ('10772', '0', '1461562670', 'gg', '根', '1');
INSERT INTO resources VALUES ('10773', '1457945779', '1458195706', 'gg', '箱', '1');
INSERT INTO resources VALUES ('10774', '1457945784', '1457945787', 'gg', '测试', '1');
INSERT INTO resources VALUES ('10775', '1458012743', '1458012747', 'gg', '55', '1');
INSERT INTO resources VALUES ('10776', '1458025955', '1458025955', 'gg', '40', '0');
INSERT INTO resources VALUES ('10777', '1458025958', '1458025958', 'gg', '50', '0');
INSERT INTO resources VALUES ('10778', '1458025960', '1458025960', 'gg', '60', '0');
INSERT INTO resources VALUES ('10779', '1458193109', '1458193152', 'hfl', 'erwerwesfs', '1');
INSERT INTO resources VALUES ('10784', '1458268383', '1458268391', 'faq', '资讯新闻', '0');
INSERT INTO resources VALUES ('10785', '1458268486', '1458268486', 'faq', '客户问题留言', '0');
INSERT INTO resources VALUES ('10786', '1458268499', '1458268499', 'faq', '新品发布', '0');
INSERT INTO resources VALUES ('10787', '1458280913', '1458280913', 'faq', '5555555555555', '0');
INSERT INTO resources VALUES ('10788', '1458280916', '1458280916', 'faq', '6666666666666666666', '0');
INSERT INTO resources VALUES ('10789', '1461562650', '1461562663', 'gy', '测试数据20160425001', '0');
INSERT INTO resources VALUES ('10790', '1464061393', '1464061393', 'hfl', 'w', '0');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL,
  `group_pri` int(11) default NULL,
  `memo` varchar(255) default NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  `isDeleted` int(12) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO role VALUES ('1', '管理员', '1000', '管理员', '2011-06-23 15:06:20', '2016-01-22 10:06:00', '0');
INSERT INTO role VALUES ('8', 'hu ', '10', '123', '2016-01-21 16:10:11', '2016-01-21 16:10:17', '1');
INSERT INTO role VALUES ('9', '设计师', '10', '设计师', '2016-01-21 16:10:24', '2016-01-21 16:37:38', '0');
INSERT INTO role VALUES ('10', 'yre', '1000', 'tre', '2016-10-19 09:29:33', '2016-10-19 09:29:33', '0');
INSERT INTO role VALUES ('11', '333', '1000', '3', '2016-11-08 09:00:03', '2016-11-08 09:00:03', '0');

-- ----------------------------
-- Table structure for `role_module`
-- ----------------------------
DROP TABLE IF EXISTS `role_module`;
CREATE TABLE `role_module` (
  `id` int(11) NOT NULL auto_increment,
  `module_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `pri` varchar(255) default NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  `isDeleted` int(12) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_module
-- ----------------------------

-- ----------------------------
-- Table structure for `shop_user`
-- ----------------------------
DROP TABLE IF EXISTS `shop_user`;
CREATE TABLE `shop_user` (
  `id` int(11) NOT NULL auto_increment,
  `mtel` varchar(100) NOT NULL,
  `true_name` varchar(100) default NULL,
  `pwd` varchar(200) default NULL,
  `sex` int(1) NOT NULL,
  `company_name` varchar(200) default NULL,
  `img` varchar(500) default NULL,
  `email` varchar(100) default NULL,
  `email_check` int(1) default NULL,
  `qq` varchar(20) default NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  `is_delete` int(12) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_user
-- ----------------------------
INSERT INTO shop_user VALUES ('50', '15168085427', '', '4297f44b13955235245b2497399d7a93', '-1', '', '', '', '0', '', '2016-03-15 10:51:53', '2016-03-15 10:51:53', '0');
INSERT INTO shop_user VALUES ('51', '18205800808', '风烨', 'dcc62e31c8030d9488969c5da73d2f16', '1', '', '/attached/image/20160315/20160315154021_988.jpg', null, '0', '', '2016-03-15 10:56:47', '2016-03-16 09:55:52', '0');
INSERT INTO shop_user VALUES ('52', '13758020222', '', '1e3ca88f5c5e28b9c26b1289007e7fbb', '-1', '', '', null, '0', '', '2016-03-15 16:55:33', '2016-04-22 13:55:16', '0');
INSERT INTO shop_user VALUES ('53', '18358092560', '', '53b677f59579b5e4c9dbfc295eb9a0dd', '-1', '', '', '', '0', '', '2016-03-16 09:41:31', '2016-03-16 09:41:31', '0');
INSERT INTO shop_user VALUES ('54', '18205800805', '', 'e10adc3949ba59abbe56e057f20f883e', '-1', '', '', '', '0', '', '2016-03-17 10:15:12', '2016-03-17 10:15:12', '0');
INSERT INTO shop_user VALUES ('55', '18205800809', '', 'dcc62e31c8030d9488969c5da73d2f16', '-1', '个人', '/attached/image/20160317/20160317172232_890.jpg', '437874607@qq.com', '0', '', '2016-03-17 14:30:57', '2016-03-17 17:22:54', '0');
INSERT INTO shop_user VALUES ('56', '18268732850', '', '675792dbdebee22b714af4a50b962a25', '-1', '', '', '', '0', '', '2016-03-23 15:37:36', '2016-03-23 15:37:36', '0');
INSERT INTO shop_user VALUES ('57', '18205800813', '', 'dcc62e31c8030d9488969c5da73d2f16', '-1', '', '', '', '0', '', '2016-03-23 16:14:02', '2016-03-23 16:14:02', '0');
INSERT INTO shop_user VALUES ('59', '18205800804', '', 'dcc62e31c8030d9488969c5da73d2f16', '-1', '', '', '', '0', '', '2016-04-22 13:53:59', '2016-04-22 13:53:59', '0');

-- ----------------------------
-- Table structure for `threshold`
-- ----------------------------
DROP TABLE IF EXISTS `threshold`;
CREATE TABLE `threshold` (
  `id` int(11) NOT NULL auto_increment,
  `isDeleted` tinyint(1) NOT NULL default '0',
  `time_create` datetime default NULL,
  `time_modified` datetime default NULL,
  `name` varchar(50) collate utf8_bin default NULL,
  `max` int(11) default NULL,
  `min` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of threshold
-- ----------------------------
INSERT INTO threshold VALUES ('1', '0', '2016-11-07 14:28:26', '2016-11-07 14:28:26', '辣椒', '25', '12');
INSERT INTO threshold VALUES ('2', '0', '2016-11-07 14:36:38', '2016-11-07 14:36:38', '玩儿', '23', '43');
INSERT INTO threshold VALUES ('3', '0', '2016-11-07 14:39:53', '2016-11-07 14:39:53', 'i与', '76', '87');
INSERT INTO threshold VALUES ('4', '1', '2016-11-07 14:40:02', '2016-11-07 14:42:59', '98', '8765', '54');
