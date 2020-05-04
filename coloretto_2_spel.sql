CREATE DATABASE  IF NOT EXISTS `coloretto_2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `coloretto_2`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: coloretto_2
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `spel`
--

DROP TABLE IF EXISTS `spel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spel` (
  `idspel` int(11) NOT NULL AUTO_INCREMENT,
  `spelNaam` varchar(45) NOT NULL,
  `vorigeSpelerIndex` int(11) DEFAULT NULL,
  PRIMARY KEY (`idspel`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spel`
--

LOCK TABLES `spel` WRITE;
/*!40000 ALTER TABLE `spel` DISABLE KEYS */;
INSERT INTO `spel` VALUES (1,'test',NULL),(2,'TEST1',NULL),(3,'ja',NULL),(4,'test',NULL),(5,'tes2',NULL),(6,'test1125',NULL),(7,'finale test',NULL),(8,'TEST10',NULL),(9,'TEST55',NULL),(10,'A',NULL),(11,'RE',NULL),(12,'AZ',3),(13,'RE',2),(14,'RKA',3),(15,'LALA',0),(16,'ER',3),(17,'ZE',1),(18,'ZE',2),(19,'ZE',2),(20,'ER',1),(21,'ER',1),(22,'ER',1),(23,'ZLKEF?Z',1),(24,'finaleTest',0),(25,'finaleTest',0),(26,'DE',0),(27,'DE',0),(28,'DE',2),(29,'DE',2);
/*!40000 ALTER TABLE `spel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-04 21:47:19
