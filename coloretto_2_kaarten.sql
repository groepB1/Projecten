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
-- Table structure for table `kaarten`
--

DROP TABLE IF EXISTS `kaarten`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kaarten` (
  `idSpel` int(11) NOT NULL,
  `kleur` varchar(45) NOT NULL,
  `aantal` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSpel`,`kleur`),
  CONSTRAINT `SpelKaarten` FOREIGN KEY (`idSpel`) REFERENCES `spel` (`idspel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaarten`
--

LOCK TABLES `kaarten` WRITE;
/*!40000 ALTER TABLE `kaarten` DISABLE KEYS */;
INSERT INTO `kaarten` VALUES (4,'blauw',6),(4,'geel',7),(4,'grijs',8),(4,'groen',9),(4,'joker',2),(4,'oranje',8),(4,'plus 2',8),(4,'rood',8),(4,'roos',8),(5,'blauw',9),(5,'geel',6),(5,'grijs',8),(5,'groen',7),(5,'joker',2),(5,'oranje',8),(5,'plus 2',9),(5,'rood',8),(5,'roos',7),(6,'blauw',6),(6,'geel',8),(6,'grijs',7),(6,'groen',9),(6,'joker',3),(6,'oranje',6),(6,'plus 2',9),(6,'rood',8),(6,'roos',8),(7,'blauw',8),(7,'geel',9),(7,'grijs',7),(7,'groen',9),(7,'joker',3),(7,'oranje',8),(7,'plus 2',10),(7,'rood',9),(7,'roos',5),(8,'blauw',9),(8,'geel',9),(8,'grijs',6),(8,'groen',7),(8,'joker',3),(8,'oranje',8),(8,'plus 2',8),(8,'rood',7),(8,'roos',7),(9,'blauw',9),(9,'geel',6),(9,'grijs',8),(9,'groen',7),(9,'joker',3),(9,'oranje',8),(9,'plus 2',9),(9,'rood',7),(9,'roos',7),(10,'blauw',8),(10,'geel',8),(10,'grijs',7),(10,'groen',7),(10,'joker',2),(10,'oranje',8),(10,'plus 2',10),(10,'rood',9),(10,'roos',5),(11,'blauw',8),(11,'geel',8),(11,'grijs',9),(11,'groen',8),(11,'joker',3),(11,'oranje',6),(11,'plus 2',9),(11,'rood',9),(11,'roos',8),(12,'blauw',9),(12,'geel',7),(12,'grijs',7),(12,'groen',9),(12,'joker',3),(12,'oranje',8),(12,'plus 2',9),(12,'rood',9),(12,'roos',7),(13,'blauw',8),(13,'geel',7),(13,'grijs',8),(13,'groen',7),(13,'joker',3),(13,'oranje',9),(13,'plus 2',10),(13,'rood',8),(13,'roos',8),(14,'blauw',7),(14,'geel',5),(14,'grijs',8),(14,'groen',8),(14,'joker',3),(14,'oranje',8),(14,'plus 2',9),(14,'rood',7),(14,'roos',9),(15,'blauw',8),(15,'geel',7),(15,'grijs',7),(15,'groen',9),(15,'joker',2),(15,'oranje',9),(15,'plus 2',10),(15,'rood',7),(15,'roos',9),(16,'blauw',8),(16,'geel',9),(16,'grijs',6),(16,'groen',8),(16,'joker',3),(16,'oranje',9),(16,'plus 2',8),(16,'rood',9),(16,'roos',8),(17,'blauw',9),(17,'geel',8),(17,'grijs',7),(17,'groen',9),(17,'joker',1),(17,'oranje',8),(17,'plus 2',9),(17,'rood',9),(17,'roos',8),(18,'blauw',8),(18,'geel',8),(18,'grijs',9),(18,'groen',7),(18,'joker',2),(18,'oranje',9),(18,'plus 2',9),(18,'rood',8),(18,'roos',8),(19,'blauw',8),(19,'geel',8),(19,'grijs',7),(19,'groen',8),(19,'joker',3),(19,'oranje',8),(19,'plus 2',8),(19,'rood',9),(19,'roos',9),(20,'blauw',8),(20,'geel',8),(20,'grijs',7),(20,'groen',8),(20,'joker',3),(20,'oranje',8),(20,'plus 2',9),(20,'rood',8),(20,'roos',9),(21,'blauw',7),(21,'geel',8),(21,'grijs',7),(21,'groen',6),(21,'joker',3),(21,'oranje',8),(21,'plus 2',9),(21,'rood',7),(21,'roos',9),(22,'blauw',5),(22,'geel',7),(22,'grijs',7),(22,'groen',5),(22,'joker',1),(22,'oranje',8),(22,'plus 2',9),(22,'rood',7),(22,'roos',7),(23,'blauw',6),(23,'geel',9),(23,'grijs',7),(23,'groen',7),(23,'joker',3),(23,'oranje',7),(23,'plus 2',9),(23,'rood',7),(23,'roos',9),(24,'blauw',8),(24,'geel',9),(24,'grijs',5),(24,'groen',6),(24,'joker',3),(24,'oranje',8),(24,'plus 2',9),(24,'rood',9),(24,'roos',7),(25,'blauw',8),(25,'geel',9),(25,'grijs',5),(25,'groen',6),(25,'joker',2),(25,'oranje',8),(25,'plus 2',7),(25,'rood',8),(25,'roos',7),(26,'blauw',8),(26,'geel',6),(26,'grijs',7),(26,'groen',8),(26,'joker',2),(26,'oranje',8),(26,'plus 2',9),(26,'rood',7),(26,'roos',8),(27,'blauw',8),(27,'geel',6),(27,'grijs',7),(27,'groen',8),(27,'joker',2),(27,'oranje',8),(27,'plus 2',9),(27,'rood',7),(27,'roos',8),(28,'blauw',5),(28,'geel',6),(28,'grijs',5),(28,'groen',7),(28,'joker',2),(28,'oranje',7),(28,'plus 2',9),(28,'rood',6),(28,'roos',7),(29,'blauw',5),(29,'geel',6),(29,'grijs',5),(29,'groen',7),(29,'joker',2),(29,'oranje',7),(29,'plus 2',9),(29,'rood',6),(29,'roos',7);
/*!40000 ALTER TABLE `kaarten` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-04 21:47:18
