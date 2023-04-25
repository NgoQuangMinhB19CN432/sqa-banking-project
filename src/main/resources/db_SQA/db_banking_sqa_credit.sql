-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: db_banking_sqa
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `credit`
--

DROP TABLE IF EXISTS `credit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credit` (
  `credit_id` int NOT NULL AUTO_INCREMENT,
  `borrow_day` date DEFAULT NULL,
  `original_money` int DEFAULT NULL,
  `money` int DEFAULT '0',
  `mortgage` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `pay_day` date DEFAULT NULL,
  `bank_account_number` varchar(255) COLLATE utf8_bin NOT NULL,
  `credit_term_id` int NOT NULL,
  `credit_status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`credit_id`),
  KEY `bank_account_number` (`bank_account_number`),
  KEY `credit_term_id` (`credit_term_id`),
  CONSTRAINT `credit_bank_account_number_fk` FOREIGN KEY (`bank_account_number`) REFERENCES `bank_account` (`bank_account_number`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `credit_credit_term_id_fk` FOREIGN KEY (`credit_term_id`) REFERENCES `credit_term` (`credit_term_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit`
--

LOCK TABLES `credit` WRITE;
/*!40000 ALTER TABLE `credit` DISABLE KEYS */;
INSERT INTO `credit` VALUES (1,'2023-04-03',50000000,0,'nhà riêng','2023-12-03','268000203213',1,1);
/*!40000 ALTER TABLE `credit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-24 18:02:58
