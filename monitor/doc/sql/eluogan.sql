/*
Navicat MySQL Data Transfer

Source Server         : localhost3306
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : eluogan

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2016-03-14 09:04:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for about_us
-- ----------------------------
DROP TABLE IF EXISTS `about_us`;
CREATE TABLE `about_us` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(500) NOT NULL,
  `content` text,
  `sort_num` int(11) default NULL,
  `is_deleted` int(1) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL auto_increment,
  `user_name` varchar(255) default NULL,
  `address` varchar(255) NOT NULL,
  `telephone` varchar(255) default NULL,
  `gudingphone` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  `isDeleted` int(12) default NULL,
  `member_id` int(12) default '0',
  `alias_address` varchar(255) default NULL,
  `province` varchar(255) default NULL,
  `city` varchar(255) default NULL,
  `county` varchar(255) default NULL,
  `acquiesce` int(11) default '0',
  `address_list` varchar(255) default NULL,
  `jiedao` varchar(500) default '',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` int(11) NOT NULL auto_increment,
  `type` int(11) NOT NULL,
  `title` varchar(255) default NULL,
  `img` varchar(255) NOT NULL,
  `url` varchar(1000) default NULL,
  `sort_num` int(11) default NULL,
  `is_deleted` int(1) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ec_business
-- ----------------------------
DROP TABLE IF EXISTS `ec_business`;
CREATE TABLE `ec_business` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `summaryIntroduce` text,
  `sort` int(11) NOT NULL,
  `icon` varchar(500) NOT NULL,
  `isDeleted` varchar(1) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for enterprise
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(255) default NULL,
  `logo_pic` varchar(255) default NULL,
  `small_pic` varchar(255) default NULL,
  `content` text,
  `sort_num` int(11) default NULL,
  `hot` int(2) default NULL,
  `is_deleted` int(1) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for e_news
-- ----------------------------
DROP TABLE IF EXISTS `e_news`;
CREATE TABLE `e_news` (
  `id` int(11) NOT NULL auto_increment,
  `type` int(11) NOT NULL,
  `title` varchar(255) collate utf8_bin NOT NULL,
  `small_pic` varchar(255) collate utf8_bin default NULL,
  `sort_num` int(11) default '0',
  `content` text collate utf8_bin,
  `is_img_news` int(1) NOT NULL default '0',
  `is_show` int(1) NOT NULL default '0',
  `show_pic` int(2) default NULL,
  `is_deleted` int(1) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4923 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for faqgenre
-- ----------------------------
DROP TABLE IF EXISTS `faqgenre`;
CREATE TABLE `faqgenre` (
  `id` int(11) NOT NULL auto_increment,
  `faq_id` int(11) NOT NULL,
  `content` text collate utf8_bin,
  `title` varchar(255) collate utf8_bin NOT NULL default '0',
  `is_deleted` int(1) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for groups
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
-- Table structure for imgs
-- ----------------------------
DROP TABLE IF EXISTS `imgs`;
CREATE TABLE `imgs` (
  `id` int(11) NOT NULL auto_increment,
  `fid` int(11) NOT NULL,
  `img_path` varchar(5000) default NULL,
  `type` int(2) default NULL,
  `is_deleted` tinyint(1) NOT NULL,
  `time_create` datetime default NULL,
  `time_modified` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=134 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mail_templte
-- ----------------------------
DROP TABLE IF EXISTS `mail_templte`;
CREATE TABLE `mail_templte` (
  `id` int(11) NOT NULL auto_increment,
  `numbers` varchar(25) default NULL,
  `subject` varchar(255) default NULL,
  `content` varchar(600) default NULL,
  `time_create` datetime default NULL,
  `time_modified` datetime default NULL,
  `is_delete` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `id` int(11) NOT NULL auto_increment,
  `name_id` int(11) NOT NULL,
  `factory_id` int(11) NOT NULL,
  `furnace` varchar(255) default NULL,
  `crafts_id` int(11) NOT NULL,
  `spec_id` int(11) NOT NULL,
  `length` double(255,5) NOT NULL,
  `num` int(11) NOT NULL default '0',
  `zu` int(11) NOT NULL default '0',
  `piece` int(11) NOT NULL default '0',
  `weight` double(255,5) NOT NULL,
  `price` double(50,2) NOT NULL,
  `is_published` int(1) NOT NULL default '0',
  `is_deleted` int(1) NOT NULL default '0',
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for member
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
) ENGINE=MyISAM AUTO_INCREMENT=37 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for module
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
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(500) NOT NULL,
  `content` text,
  `sort_num` int(11) default NULL,
  `isshow` int(2) default NULL,
  `is_deleted` int(1) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for oldmanges
-- ----------------------------
DROP TABLE IF EXISTS `oldmanges`;
CREATE TABLE `oldmanges` (
  `id` int(11) NOT NULL auto_increment,
  `num` int(11) default NULL,
  `objname` varchar(255) NOT NULL,
  `img` varchar(255) default NULL,
  `price` double(50,2) NOT NULL,
  `isDeleted` int(1) default NULL,
  `content` text,
  `name` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  `isPublished` int(1) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for personnel
-- ----------------------------
DROP TABLE IF EXISTS `personnel`;
CREATE TABLE `personnel` (
  `id` int(11) NOT NULL auto_increment,
  `num` int(11) default NULL,
  `name` varchar(255) NOT NULL,
  `img` varchar(255) default NULL,
  `sex` varchar(10) NOT NULL,
  `age` int(11) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `objective` varchar(255) NOT NULL,
  `salary` varchar(255) NOT NULL,
  `content` text,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  `isPublished` int(1) NOT NULL,
  `isDeleted` int(1) default NULL,
  `muban` int(11) default NULL,
  PRIMARY KEY  (`id`)
)

-- ----------------------------
-- Table structure for recommend
-- ----------------------------
DROP TABLE IF EXISTS `recommend`;
CREATE TABLE `recommend` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL,
  `img` varchar(255) NOT NULL,
  `url` varchar(1000) default NULL,
  `sort_num` int(11) default NULL,
  `is_deleted` int(1) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for resources
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
) ENGINE=MyISAM AUTO_INCREMENT=10705 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for role
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
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_module
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
-- Table structure for shopuser_active
-- ----------------------------
DROP TABLE IF EXISTS `shopuser_active`;
CREATE TABLE `shopuser_active` (
  `id` int(11) NOT NULL auto_increment,
  `shopuser_id` int(11) NOT NULL,
  `check_code` varchar(200) NOT NULL,
  `time` varchar(100) default NULL,
  `is_used` int(1) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  `is_delete` int(1) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shop_user
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
) ENGINE=MyISAM AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sms_validate
-- ----------------------------
DROP TABLE IF EXISTS `sms_validate`;
CREATE TABLE `sms_validate` (
  `id` int(11) NOT NULL auto_increment,
  `phone` varchar(11) NOT NULL,
  `yzm` varchar(10) NOT NULL,
  `num` int(2) NOT NULL,
  `time` bigint(20) NOT NULL,
  `isused` int(1) NOT NULL,
  `sdate` varchar(8) NOT NULL,
  `is_deleted` int(1) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for supplies
-- ----------------------------
DROP TABLE IF EXISTS `supplies`;
CREATE TABLE `supplies` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL,
  `img` varchar(5000) NOT NULL,
  `content` text,
  `class_id` int(11) NOT NULL,
  `factory_id` int(11) NOT NULL,
  `brand_id` int(11) NOT NULL,
  `spec` varchar(500) NOT NULL,
  `price` double(50,2) NOT NULL,
  `is_published` int(1) NOT NULL default '0',
  `is_deleted` int(1) NOT NULL default '0',
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_cart
-- ----------------------------
DROP TABLE IF EXISTS `tb_cart`;
CREATE TABLE `tb_cart` (
  `id` int(11) NOT NULL auto_increment,
  `user_id` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `zhinum` int(11) NOT NULL default '0',
  `jiannum` int(11) NOT NULL default '0',
  `num` double(11,3) default NULL,
  `type` int(11) NOT NULL,
  `is_deleted` int(1) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_material_stock
-- ----------------------------
DROP TABLE IF EXISTS `tb_material_stock`;
CREATE TABLE `tb_material_stock` (
  `id` int(11) NOT NULL auto_increment,
  `type` int(1) default NULL,
  `menber_id` int(11) default NULL,
  `name_id` int(11) NOT NULL,
  `factory_id` int(11) NOT NULL,
  `furnace` varchar(11) default NULL,
  `crafts_id` int(11) NOT NULL,
  `spec_id` int(11) NOT NULL,
  `length` double(11,2) NOT NULL,
  `zu` int(11) default NULL,
  `piece` int(11) default NULL,
  `weight` double(11,2) NOT NULL,
  `is_deleted` int(1) NOT NULL default '0',
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `order_code` varchar(20) NOT NULL,
  `money` double(11,2) NOT NULL,
  `order_state` int(1) NOT NULL,
  `address_id` int(11) NOT NULL,
  `pay_method` int(1) NOT NULL,
  `pay_tool` int(1) NOT NULL,
  `qr_date` datetime default NULL,
  `fukuan_date` datetime default NULL,
  `fahuo_date` datetime default NULL,
  `kuaidi_num` varchar(30) default NULL,
  `platform_remark` text,
  `remark` varchar(1000) default NULL,
  `deliveries` int(1) NOT NULL,
  `trade_no` varchar(200) default NULL,
  `is_deleted` int(1) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  `receive_name` varchar(200) default NULL,
  `receive_mtel` varchar(200) default NULL,
  `receive_guhua` varchar(200) default NULL,
  `receive_address` varchar(200) default NULL,
  `receive_email` varchar(200) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_order_action
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_action`;
CREATE TABLE `tb_order_action` (
  `id` int(11) NOT NULL auto_increment,
  `orderid` int(11) default NULL,
  `type` int(1) default NULL,
  `desc_str` varchar(200) default NULL,
  `operater` varchar(200) default NULL,
  `operaterid` int(11) default NULL,
  `optime` varchar(50) default NULL,
  `time_create` datetime default NULL,
  `time_modified` datetime default NULL,
  `is_deleted` int(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_order_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_item`;
CREATE TABLE `tb_order_item` (
  `id` int(11) NOT NULL auto_increment,
  `order_id` int(11) NOT NULL,
  `type` int(1) default NULL,
  `guigeid` int(11) default NULL,
  `goodsid` int(11) default NULL,
  `zhinum` int(11) NOT NULL default '0',
  `jiannum` int(11) NOT NULL default '0',
  `num` double(11,3) default NULL,
  `price` double(11,2) default NULL,
  `goods_name` varchar(1000) default NULL,
  `gooods_spec` varchar(1000) default NULL,
  `img` varchar(1000) default NULL,
  `money` double(11,2) default '0.00',
  `commentid` int(11) default NULL,
  `commentstate` int(11) default NULL,
  `state` int(1) default NULL,
  `is_deleted` int(1) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_prov_city_area_street
-- ----------------------------
DROP TABLE IF EXISTS `tb_prov_city_area_street`;
CREATE TABLE `tb_prov_city_area_street` (
  `id` int(11) NOT NULL auto_increment,
  `code` varchar(11) default NULL,
  `parentId` varchar(11) default NULL,
  `name` varchar(50) default NULL,
  `level` tinyint(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47496 DEFAULT CHARSET=utf8 COMMENT='全国省市区街道';

-- ----------------------------
-- Table structure for tb_wishlist
-- ----------------------------
DROP TABLE IF EXISTS `tb_wishlist`;
CREATE TABLE `tb_wishlist` (
  `id` int(11) NOT NULL auto_increment,
  `cid` int(11) NOT NULL,
  `userid` int(11) default NULL,
  `type` int(1) NOT NULL,
  `is_deleted` int(1) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
