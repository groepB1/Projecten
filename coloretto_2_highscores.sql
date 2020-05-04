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
-- Table structure for table `highscores`
--

DROP TABLE IF EXISTS `highscores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `highscores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `spelernaam` varchar(255) DEFAULT NULL,
  `score` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `highscores`
--

LOCK TABLES `highscores` WRITE;
/*!40000 ALTER TABLE `highscores` DISABLE KEYS */;
INSERT INTO `highscores` VALUES (1,'AA','4'),(2,'AB','4'),(3,'AC','6'),(4,'AD','5'),(5,'AE','10'),(6,'A','3'),(7,'B','3'),(8,'C','3'),(9,'D','3'),(10,'A','3'),(11,'B','3'),(12,'C','3'),(13,'D','3'),(14,'D','5'),(15,'B','0'),(16,'C','5'),(17,'A','14'),(18,'A','3'),(19,'B','2'),(20,'C','4'),(21,'D','2'),(22,'A','3'),(23,'B','5'),(24,'C','5'),(25,'D','5'),(26,'A','9'),(27,'B','0'),(28,'C','12'),(29,'D','2'),(30,'A','8'),(31,'B','8'),(32,'C','0'),(33,'D','2'),(34,'A','3'),(35,'B','5'),(36,'C','4'),(37,'D','4'),(38,'A','8'),(39,'B','11'),(40,'C','11'),(41,'D','5'),(42,'A','3'),(43,'B','3'),(44,'C','8'),(45,'D','5'),(46,'A','4'),(47,'B','1'),(48,'C','3'),(49,'D','6'),(50,'A','7'),(51,'B','4'),(52,'C','3'),(53,'D','6'),(54,'A','12'),(55,'B','3'),(56,'C','12'),(57,'D','10'),(58,'A','7'),(59,'B','4'),(60,'C','3'),(61,'D','6'),(62,'A','4'),(63,'B','4'),(64,'C','6'),(65,'D','6'),(66,'A','7'),(67,'B','4'),(68,'C','6'),(69,'D','3'),(70,'A','6'),(71,'B','4'),(72,'C','3'),(73,'D','4'),(74,'A','7'),(75,'B','4'),(76,'C','6'),(77,'D','6'),(78,'A','7'),(79,'B','4'),(80,'C','6'),(81,'D','7'),(82,'A','7'),(83,'B','4'),(84,'C','7'),(85,'D','3'),(86,'A','7'),(87,'B','4'),(88,'C','3'),(89,'D','3'),(90,'A','4'),(91,'B','4'),(92,'C','6'),(93,'D','3'),(94,'A','10'),(95,'B','6'),(96,'C','6'),(97,'D','10'),(98,'A','4'),(99,'B','1'),(100,'C','6'),(101,'D','6');
/*!40000 ALTER TABLE `highscores` ENABLE KEYS */;
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
