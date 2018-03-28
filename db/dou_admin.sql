# Host: localhost  (Version 5.5.53)
# Date: 2018-03-28 08:34:48
# Generator: MySQL-Front 5.4  (Build 4.153) - http://www.mysqlfront.de/

/*!40101 SET NAMES utf8 */;

#
# Structure for table "dou_admin"
#

DROP TABLE IF EXISTS `dou_admin`;
CREATE TABLE `dou_admin` (
  `user_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(60) NOT NULL DEFAULT '',
  `email` varchar(60) NOT NULL DEFAULT '',
  `password` varchar(32) NOT NULL DEFAULT '',
  `action_list` text NOT NULL,
  `add_time` int(11) NOT NULL DEFAULT '0',
  `last_login` int(11) NOT NULL DEFAULT '0',
  `last_ip` varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "dou_admin"
#

/*!40000 ALTER TABLE `dou_admin` DISABLE KEYS */;
INSERT INTO `dou_admin` VALUES (1,'admin','','e10adc3949ba59abbe56e057f20f883e','ALL',1521358529,1521382350,'127.0.0.1');
/*!40000 ALTER TABLE `dou_admin` ENABLE KEYS */;
