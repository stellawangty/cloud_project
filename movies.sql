/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.22-log : Database - movies
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`movies` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `movies`;

/*Table structure for table `boxoffice_country` */

DROP TABLE IF EXISTS `boxoffice_country`;

CREATE TABLE `boxoffice_country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `boxoffice_country` */

insert  into `boxoffice_country`(`id`,`country`,`num`) values (17,'Australia',11),(18,'Canada',18),(19,'China',136),(20,'France',26),(21,'Germany',20),(22,'Italy',7),(23,'Korea',20),(24,'New Zealand',7);

/*Table structure for table `boxoffice_rate` */

DROP TABLE IF EXISTS `boxoffice_rate`;

CREATE TABLE `boxoffice_rate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `rate` float DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `boxoffice_rate` */

insert  into `boxoffice_rate`(`id`,`name`,`rate`) values (10,'Three fools make a big fuss in Bollywood',9.1),(11,'Spirited away',9.2),(12,'Titanic',9.1),(13,'Marine pianist',9.2),(14,'Inception',9.2),(15,'The Shawshank Redemption',9.6),(16,'Let the bullets fly',8.7),(17,'Léon',9.4),(18,'Forrest Gump',9.4);

/*Table structure for table `boxoffice_style_num` */

DROP TABLE IF EXISTS `boxoffice_style_num`;

CREATE TABLE `boxoffice_style_num` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `style` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `boxoffice_style_num` */

insert  into `boxoffice_style_num`(`id`,`style`,`num`) values (6,'plot',2),(7,'action',2),(8,'comedy',1),(9,'love',3),(10,'crime',1);

/*Table structure for table `boxoffice_top` */

DROP TABLE IF EXISTS `boxoffice_top`;

CREATE TABLE `boxoffice_top` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `boxoffice` int(11) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `boxoffice_top` */

insert  into `boxoffice_top`(`id`,`name`,`boxoffice`) values (10,'Three fools make a big fuss in Bollywood',549808),(11,'Spirited away',525505),(12,'Titanic',535491),(13,'Marine pianist',501153),(14,'Inception',642134),(15,'The Shawshank Redemption',692795),(16,'Let the bullets fly',534791),(17,'Léon',662552),(18,'Forrest Gump',580897);

/*Table structure for table `years` */

DROP TABLE IF EXISTS `years`;

CREATE TABLE `years` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `style` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `years` */

insert  into `years`(`id`,`style`,`num`) values (1,'1990-1995',356),(2,'1990年之前',623),(3,'1995-2000',1531),(4,'2000-2005',5362),(5,'2005-2010',7236),(6,'2010-2015',4563);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
