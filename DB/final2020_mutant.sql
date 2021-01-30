/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.4.13-MariaDB : Database - final2020_mutant
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`final2020_mutant` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `final2020_mutant`;

/*Table structure for table `mutante` */

DROP TABLE IF EXISTS `mutante`;

CREATE TABLE `mutante` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `dna` tinyblob DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `mutante` */

insert  into `mutante`(`id`,`apellido`,`dna`,`dni`,`nombre`) values (2,'Howlett','¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0ATGCGAt\0CAGTGCt\0TTATGTt\0AGAAGGt\0CCCCTAt\0TCACTG',123456,'Logan');

/*Table structure for table `mutante_aud` */

DROP TABLE IF EXISTS `mutante_aud`;

CREATE TABLE `mutante_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `dna` tinyblob DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FKaippnps4jn3emipm5gs99tpt9` (`rev`),
  CONSTRAINT `FKaippnps4jn3emipm5gs99tpt9` FOREIGN KEY (`rev`) REFERENCES `revision_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mutante_aud` */

insert  into `mutante_aud`(`id`,`rev`,`revtype`,`apellido`,`dna`,`dni`,`nombre`) values (1,1,0,NULL,'¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0ATGCGAt\0CAGTGCt\0TTATGTt\0AGAAGGt\0CCCCTAt\0TCACTG',0,NULL),(1,2,2,NULL,NULL,NULL,NULL),(2,3,0,'Howlett','¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0ATGCGAt\0CAGTGCt\0TTATGTt\0AGAAGGt\0CCCCTAt\0TCACTG',123456,'Logan');

/*Table structure for table `revision_info` */

DROP TABLE IF EXISTS `revision_info`;

CREATE TABLE `revision_info` (
  `id` int(11) NOT NULL,
  `revision_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `revision_info` */

insert  into `revision_info`(`id`,`revision_date`) values (1,'2021-01-30 21:12:58'),(2,'2021-01-30 21:14:53'),(3,'2021-01-30 21:17:38');

/*Table structure for table `seq_revision_id` */

DROP TABLE IF EXISTS `seq_revision_id`;

CREATE TABLE `seq_revision_id` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `seq_revision_id` */

insert  into `seq_revision_id`(`next_val`) values (101);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
