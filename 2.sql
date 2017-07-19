/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.6.14 : Database - etc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`etc` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `etc`;

/*Table structure for table `house` */

DROP TABLE IF EXISTS `house`;

CREATE TABLE `house` (
  `price` int(11) DEFAULT NULL,
  `id` varchar(50) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `link` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `house` */

insert  into `house`(`price`,`id`,`address`,`link`) values (123456,'3333','东湖公园厕所，10平方米','123456'),(123456,'444','东湖公园厕所，10平方米','123456'),(123456,'4444','东湖公园厕所，10平方米','123456'),(123456,'555','东湖公园厕所，10平方米','123456'),(123456,'666','东湖公园厕所，10平方米','123456'),(123456,'777','东湖公园厕所，10平方米','123456'),(123456,'888','东湖公园厕所，10平方米','123456'),(123456,'999','东湖公园厕所，10平方米','123456');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`user`,`password`,`telephone`,`username`) values (1,'tom','123',NULL,NULL),(2,'123','123','123','123'),(3,'123','123','123','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
