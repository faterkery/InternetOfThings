-- ----------------------------
-- �˻����޸�
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
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for supplies_img
-- ----------------------------
DROP TABLE IF EXISTS `supplies_img`;
CREATE TABLE `supplies_img` (
  `id` int(11) NOT NULL auto_increment,
  `suppliesId` int(11) NOT NULL,
  `suppliesImg` varchar(5000) default NULL,
  `isDeleted` tinyint(1) NOT NULL,
  `time_create` datetime default NULL,
  `time_modified` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;







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
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

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
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `supplies_img`;
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
) ENGINE=MyISAM AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tb_cart`;
CREATE TABLE `tb_cart` (
  `id` int(11) NOT NULL auto_increment,
  `user_id` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `num` int(11) default NULL,
  `type` int(11) NOT NULL,
  `is_deleted` int(1) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


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
  `phone` int(11) NOT NULL,
  `objective` varchar(255) NOT NULL,
  `salary` int(11) NOT NULL,
  `content` text,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  `isPublished` int(1) NOT NULL,
  `isDeleted` int(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


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
) ENGINE=MyISAM AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `id` int(11) NOT NULL auto_increment,
  `name_id` int(11) NOT NULL,
  `factory_id` int(11) NOT NULL,
  `furnace` varchar(255) default NULL,
  `crafts_id` int(11) NOT NULL,
  `spec_id` int(11) NOT NULL,
  `length` double(255,5) NOT NULL,
  `zu` int(11) default NULL,
  `piece` int(11) default NULL,
  `weight` double(255,5) NOT NULL,
  `price` double(50,2) NOT NULL,
  `is_published` int(1) NOT NULL default '0',
  `is_deleted` int(1) NOT NULL default '0',
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 新闻资讯
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
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tb_order_item`;
CREATE TABLE `tb_order_item` (
  `id` int(11) NOT NULL auto_increment,
  `order_id` int(11) NOT NULL,
  `type` int(1) default NULL,
  `guigeid` int(11) default NULL,
  `goodsid` int(11) default NULL,
  `num` int(11) default NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;


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
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;


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
) ENGINE=MyISAM AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;


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
  `phone` varchar(255) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  `isPublished` int(1) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;


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
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;


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
  `phone` varchar(11) NOT NULL,
  `objective` varchar(255) NOT NULL,
  `salary` varchar(11) NOT NULL,
  `content` text,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  `isPublished` int(1) NOT NULL,
  `isDeleted` int(1) default NULL,
  `muban` int(11) default NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

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
  `phone` varchar(255) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  `isPublished` int(1) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;







-- ----------------------------
-- Table structure for supplies
-- ----------------------------
DROP TABLE IF EXISTS `supplies`;
CREATE TABLE `supplies` (
  `id` int(11) NOT NULL auto_increment,
  `sort_num` int(11) default '0',
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
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `id` int(11) NOT NULL auto_increment,
  `sort_num` int(11) default '0',
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
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for enterprise
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(255) default NULL,
  `small_title` varchar(255) default NULL,
  `logo_pic` varchar(255) default NULL,
  `small_pic` varchar(255) default NULL,
  `content` text,
  `sort_num` int(11) default NULL,
  `hot` int(2) default NULL,
  `is_deleted` int(1) NOT NULL,
  `time_create` datetime NOT NULL,
  `time_modified` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

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
  `remark_num` varchar(1000) default NULL,
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
  `remarks` varchar(1000) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

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
  `length_buy` double(11,3) default NULL,
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
) ENGINE=MyISAM AUTO_INCREMENT=174 DEFAULT CHARSET=utf8;

-- ----------------------------
-- 删除 tb_order中的 remarks
-- ----------------------------
ALTER TABLE `tb_order`
DROP COLUMN `remarks`;
-- ----------------------------
--  tb_cart表中增加 remarks
-- ----------------------------

ALTER TABLE `tb_cart`
ADD COLUMN `remarks`  varchar(1000) NULL AFTER `time_modified`;
-- ----------------------------
--  tb_order_item表中增加  remarks
-- ----------------------------
ALTER TABLE `tb_order_item`
ADD COLUMN `remarks`  varchar(1000) NULL AFTER `time_modified`;



-- ----------------------------
--  e_news表中增加 content_val
-- ----------------------------
ALTER TABLE `e_news`
ADD COLUMN `content_val`  varchar(500) NULL AFTER `content_val`;

-- ----------------------------
--  enterprise表中增加 content_val
-- ----------------------------
ALTER TABLE `enterprise`
ADD COLUMN `content_val`  varchar(500) NULL AFTER `content_val`;



