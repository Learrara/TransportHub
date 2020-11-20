-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: testdb
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id_num` int NOT NULL AUTO_INCREMENT COMMENT 'Decide in meeting if ID is autoincrement or determined by our code''s logic',
  `order_id_num` int NOT NULL,
  `customername` varchar(60) NOT NULL,
  `address` varchar(100) NOT NULL COMMENT 'replace gui design''s textfield with textarea and textpane',
  `customerphone` varchar(11) NOT NULL,
  PRIMARY KEY (`customer_id_num`),
  UNIQUE KEY `customer_id_#_UNIQUE` (`customer_id_num`),
  KEY `order_id_#_idx` (`order_id_num`),
  CONSTRAINT `order_id_#` FOREIGN KEY (`order_id_num`) REFERENCES `orders` (`order_id_num`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (11,10055,'Joji Miller','Flavortown, USA','0924162416');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager_account`
--

DROP TABLE IF EXISTS `manager_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manager_account` (
  `account_id_num` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `fullname` varchar(60) NOT NULL,
  `password` varchar(45) NOT NULL,
  `birthday` date NOT NULL,
  `phonenumber` varchar(11) NOT NULL,
  `preferredtitle` varchar(12) NOT NULL,
  PRIMARY KEY (`account_id_num`),
  UNIQUE KEY `account_id_#_UNIQUE` (`account_id_num`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `password_UNIQUE` (`password`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager_account`
--

LOCK TABLES `manager_account` WRITE;
/*!40000 ALTER TABLE `manager_account` DISABLE KEYS */;
INSERT INTO `manager_account` VALUES (1,'JD','john doe','bruh','1986-04-26','09786543241','Sir');
/*!40000 ALTER TABLE `manager_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_item` (
  `order_item_id_num` int NOT NULL AUTO_INCREMENT,
  `order_id_num` int NOT NULL,
  `item_name` varchar(40) NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`order_item_id_num`),
  UNIQUE KEY `order_item_id_#_UNIQUE` (`order_item_id_num`),
  KEY `_idx` (`order_id_num`),
  CONSTRAINT `order id #` FOREIGN KEY (`order_id_num`) REFERENCES `orders` (`order_id_num`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES (34,10055,'Pink Suit',1),(35,10055,'Hair Cake',2),(36,10055,'Pink Season album',1);
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_status`
--

DROP TABLE IF EXISTS `order_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_status` (
  `order_status_id_num` int NOT NULL AUTO_INCREMENT,
  `account_id_num` int NOT NULL,
  `order_id_num` int NOT NULL,
  `status` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `location` varchar(100) NOT NULL,
  PRIMARY KEY (`order_status_id_num`),
  UNIQUE KEY `order_status_id_#_UNIQUE` (`order_status_id_num`),
  KEY `account id #_idx` (`account_id_num`),
  KEY `order id #_idx` (`order_id_num`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_status`
--

LOCK TABLES `order_status` WRITE;
/*!40000 ALTER TABLE `order_status` DISABLE KEYS */;
INSERT INTO `order_status` VALUES (38,1,10055,'Packed','2013-12-03','Osaka, Japan'),(39,1,10055,'Shipped','2014-12-04','Osaka, Japan');
/*!40000 ALTER TABLE `order_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id_num` int NOT NULL AUTO_INCREMENT,
  `account_id_num` int NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`order_id_num`),
  UNIQUE KEY `order_id_#_UNIQUE` (`order_id_num`),
  KEY `account_id_#_idx` (`account_id_num`),
  CONSTRAINT `account_id_#` FOREIGN KEY (`account_id_num`) REFERENCES `manager_account` (`account_id_num`)
) ENGINE=InnoDB AUTO_INCREMENT=10056 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (10054,1,'2020-11-20'),(10055,1,'2020-11-20');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-20  7:42:22
