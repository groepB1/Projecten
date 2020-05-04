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
-- Table structure for table `speler`
--

DROP TABLE IF EXISTS `speler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `speler` (
  `idspeler` int(11) NOT NULL,
  `idSpel` int(11) NOT NULL,
  `naam` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idspeler`,`idSpel`),
  KEY `spelSpeler_idx` (`idSpel`),
  CONSTRAINT `spelSpeler` FOREIGN KEY (`idSpel`) REFERENCES `spel` (`idspel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `speler`
--

LOCK TABLES `speler` WRITE;
/*!40000 ALTER TABLE `speler` DISABLE KEYS */;
INSERT INTO `speler` VALUES (0,4,'A'),(0,5,'A'),(0,6,'A'),(0,7,'A'),(0,8,'A'),(0,9,'LALA'),(0,10,'A'),(0,11,'A'),(0,12,'A'),(0,13,'A'),(0,14,'A'),(0,15,'A'),(0,16,'AA'),(0,17,'A'),(0,18,'A'),(0,19,'A'),(0,20,'A'),(0,21,'A'),(0,22,'A'),(0,23,'A'),(0,24,'1'),(0,25,'1'),(0,26,'JA'),(0,27,'JA'),(0,28,'JA'),(0,29,'JA'),(1,4,'B'),(1,5,'B'),(1,6,'Z'),(1,7,'B'),(1,8,'B'),(1,9,'BABA'),(1,10,'B'),(1,11,'B'),(1,12,'B'),(1,13,'B'),(1,14,'B'),(1,15,'B'),(1,16,'BB'),(1,17,'B'),(1,18,'B'),(1,19,'B'),(1,20,'B'),(1,21,'B'),(1,22,'B'),(1,23,'B'),(1,24,'2'),(1,25,'2'),(1,26,'LE'),(1,27,'LE'),(1,28,'LE'),(1,29,'LE'),(2,4,'C'),(2,5,'C'),(2,6,'E'),(2,7,'C'),(2,8,'C'),(2,9,'GAGA'),(2,10,'C'),(2,11,'C'),(2,12,'C'),(2,13,'C'),(2,14,'C'),(2,15,'C'),(2,16,'CC'),(2,17,'C'),(2,18,'C'),(2,19,'C'),(2,20,'C'),(2,21,'C'),(2,22,'C'),(2,23,'C'),(2,24,'3'),(2,25,'3'),(2,26,'BE'),(2,27,'BE'),(2,28,'BE'),(2,29,'BE'),(3,4,'D'),(3,5,'D'),(3,6,'R'),(3,7,'D'),(3,8,'D'),(3,9,'RARA'),(3,10,'D'),(3,11,'D'),(3,12,'D'),(3,13,'D'),(3,14,'D'),(3,15,'D'),(3,16,'DD'),(3,17,'D'),(3,18,'D'),(3,19,'D'),(3,20,'D'),(3,21,'D'),(3,22,'D'),(3,23,'D'),(3,24,'4'),(3,25,'4'),(3,26,'RE'),(3,27,'RE'),(3,28,'RE'),(3,29,'RE');
/*!40000 ALTER TABLE `speler` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-04 21:47:20
