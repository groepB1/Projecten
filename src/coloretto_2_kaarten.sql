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
INSERT INTO `kaarten` VALUES (4,'blauw',6),(4,'geel',7),(4,'grijs',8),(4,'groen',9),(4,'joker',2),(4,'oranje',8),(4,'plus 2',8),(4,'rood',8),(4,'roos',8),(5,'blauw',9),(5,'geel',6),(5,'grijs',8),(5,'groen',7),(5,'joker',2),(5,'oranje',8),(5,'plus 2',9),(5,'rood',8),(5,'roos',7),(6,'blauw',6),(6,'geel',8),(6,'grijs',7),(6,'groen',9),(6,'joker',3),(6,'oranje',6),(6,'plus 2',9),(6,'rood',8),(6,'roos',8),(7,'blauw',8),(7,'geel',9),(7,'grijs',7),(7,'groen',9),(7,'joker',3),(7,'oranje',8),(7,'plus 2',10),(7,'rood',9),(7,'roos',5);
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

-- Dump completed on 2020-05-01 12:41:05
