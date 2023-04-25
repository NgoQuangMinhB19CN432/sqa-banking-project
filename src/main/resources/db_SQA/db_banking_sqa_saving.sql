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
-- Table structure for table `saving`
--

DROP TABLE IF EXISTS `saving`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saving` (
  `saving_id` int NOT NULL AUTO_INCREMENT,
  `kind_of_profit` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `original_money` int NOT NULL,
  `result_money` int NOT NULL,
  `to_date` date NOT NULL,
  `bank_account_number` varchar(255) COLLATE utf8_bin NOT NULL,
  `saving_term_id` int NOT NULL,
  `saving_status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`saving_id`),
  KEY `bank_account_number` (`bank_account_number`),
  KEY `saving_term_id` (`saving_term_id`),
  CONSTRAINT `saving_bank_account_number_fk` FOREIGN KEY (`bank_account_number`) REFERENCES `bank_account` (`bank_account_number`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `saving_saving_term_id_fk` FOREIGN KEY (`saving_term_id`) REFERENCES `saving_term` (`saving_term_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saving`
--

LOCK TABLES `saving` WRITE;
/*!40000 ALTER TABLE `saving` DISABLE KEYS */;
INSERT INTO `saving` VALUES (1,'lãi kép',68000000,0,'2023-04-05','268000203213',11,1),(2,'lãi đơn',50000000,0,'2023-04-01','268000203213',12,1),(3,'lãi kép',89000000,0,'2023-04-03','268000203213',11,1);
/*!40000 ALTER TABLE `saving` ENABLE KEYS */;
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
