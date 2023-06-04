CREATE DATABASE  IF NOT EXISTS `siva_krishna` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `siva_krishna`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 192.168.60.22    Database: siva_krishna
-- ------------------------------------------------------
-- Server version	5.7.25-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `train_details`
--

DROP TABLE IF EXISTS `train_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `train_details` (
  `train_no` int(11) NOT NULL AUTO_INCREMENT,
  `train_name` varchar(45) DEFAULT NULL,
  `ss_code` int(11) NOT NULL,
  `es_code` int(11) NOT NULL,
  `bording_time` varchar(45) DEFAULT NULL,
  `destination_time` varchar(45) DEFAULT NULL,
  `avg_speed` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`train_no`)
) ENGINE=InnoDB AUTO_INCREMENT=12071 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_details`
--

LOCK TABLES `train_details` WRITE;
/*!40000 ALTER TABLE `train_details` DISABLE KEYS */;
INSERT INTO `train_details` VALUES (12041,'NDL Express',1,2,'9:20 PM','5:30 AM','60 km/hr'),(12042,'KCL Express',1,3,'9:20 PM','2:30 AM','60 km/hr'),(12043,'NDL Express',2,1,'11:30 PM','7:30 AM','70 km/hr'),(12044,'KCL Express',3,1,'5:20 AM','8:50 AM','80 km/hr'),(12045,'BGN Express',1,4,'5:30 AM','7:10 PM','50 km/hr'),(12046,'BGN Express',4,1,'6:20 PM','4:50 AM','60 km/hr'),(12047,'CHN Express',1,5,'9:10 PM','5:40 AM','60 km/hr'),(12048,'CHN Express',5,1,'3:30 PM','4:50 AM','80 km/hr'),(12049,'SCB Express',6,2,'12:30 PM','7:00 PM','90 km/hr'),(12050,'SCB Express',2,6,'4:25 PM','8:20 PM','70 km/hr'),(12051,'VG Express',7,2,'6:35 AM','4:45 PM','80 km/hr'),(12052,'VG Express',2,7,'8:20 PM','11:30 AM','60 km/hr'),(12053,'Vizag Express',1,7,'5:40 AM','12:40 PM','60 km/hr'),(12054,'Vizag Express',7,1,'6:00 PM','4:10 AM','50 km/hr'),(12055,'Banglore Express',2,4,'6:10 AM','5:35 PM','45 km/hr'),(12056,'Banglore Express',4,2,'1:30 AM','9:30 PM','60 km/hr'),(12057,'LCK Express',9,10,'3:30 AM','11:15 PM','60 km/hr'),(12058,'LCK Express',10,9,'3:55 PM','2:35 PM','95 km/hr'),(12059,'Kurnool Express',10,3,'2:45 AM','12:40 AM','70 km/hr'),(12060,'Kurnool Express',3,10,'3:40 PM','5:05 AM','50 km/hr'),(12061,'PN Express',8,10,'6:10 AM','8:20 PM','60 km/hr'),(12062,'PN Express',10,8,'9:25 AM','3:30 PM','60 km/hr'),(12063,'PUN Express',8,5,'5:55 PM','4:00PM','35 km/hr'),(12064,'PUN Express',5,8,'2:10 AM','10:30 PM','55 km/hr'),(12065,'Pune Express',8,4,'10:00 AM','11:25 PM','60 km/hr'),(12066,'Pune Express',4,8,'8:45 AM','6:30 PM','75 km/hr'),(12067,'Chennai Express',6,5,'7:15 AM','7:00 PM','60 km/hr'),(12068,'Chennai Express',5,6,'5:50 PM','3:25 PM','80 km/hr'),(12069,'Mumbai Express',10,6,'6:23 PM','8:10 AM','60 km/hr'),(12070,'Mumbai Express',6,10,'7:50 AM','5:55 AM','57 km/hr');
/*!40000 ALTER TABLE `train_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-01 10:55:28
