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
-- Table structure for table `spelerkaarten`
--

DROP TABLE IF EXISTS `spelerkaarten`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spelerkaarten` (
  `idSpel` int(11) NOT NULL,
  `idSpeler` int(11) NOT NULL,
  `kleur` varchar(45) NOT NULL,
  `aantal` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idSpel`,`idSpeler`,`kleur`),
  KEY `SpelerSpelerkaarten_idx` (`idSpeler`),
  CONSTRAINT `SpelSpelerkaarten` FOREIGN KEY (`idSpel`) REFERENCES `spel` (`idspel`),
  CONSTRAINT `SpelerSpelerkaarten` FOREIGN KEY (`idSpeler`) REFERENCES `speler` (`idspeler`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spelerkaarten`
--

LOCK TABLES `spelerkaarten` WRITE;
/*!40000 ALTER TABLE `spelerkaarten` DISABLE KEYS */;
INSERT INTO `spelerkaarten` VALUES (6,0,'blauw','0'),(6,0,'geel','0'),(6,0,'grijs','1'),(6,0,'groen','0'),(6,0,'joker','0'),(6,0,'oranje','1'),(6,0,'plus 2','0'),(6,0,'rood','0'),(6,0,'roos','1'),(6,1,'blauw','1'),(6,1,'geel','0'),(6,1,'grijs','0'),(6,1,'groen','0'),(6,1,'joker','0'),(6,1,'oranje','1'),(6,1,'plus 2','1'),(6,1,'rood','0'),(6,1,'roos','0'),(6,2,'blauw','2'),(6,2,'geel','1'),(6,2,'grijs','0'),(6,2,'groen','0'),(6,2,'joker','0'),(6,2,'oranje','0'),(6,2,'plus 2','0'),(6,2,'rood','0'),(6,2,'roos','0'),(6,3,'blauw','0'),(6,3,'geel','0'),(6,3,'grijs','1'),(6,3,'groen','0'),(6,3,'joker','0'),(6,3,'oranje','1'),(6,3,'plus 2','0'),(6,3,'rood','1'),(6,3,'roos','0'),(7,0,'blauw','0'),(7,0,'geel','0'),(7,0,'grijs','1'),(7,0,'groen','0'),(7,0,'joker','0'),(7,0,'oranje','0'),(7,0,'plus 2','0'),(7,0,'rood','0'),(7,0,'roos','1'),(7,1,'blauw','0'),(7,1,'geel','0'),(7,1,'grijs','1'),(7,1,'groen','0'),(7,1,'joker','0'),(7,1,'oranje','0'),(7,1,'plus 2','0'),(7,1,'rood','0'),(7,1,'roos','1'),(7,2,'blauw','1'),(7,2,'geel','0'),(7,2,'grijs','0'),(7,2,'groen','0'),(7,2,'joker','0'),(7,2,'oranje','0'),(7,2,'plus 2','0'),(7,2,'rood','0'),(7,2,'roos','1'),(7,3,'blauw','0'),(7,3,'geel','0'),(7,3,'grijs','0'),(7,3,'groen','0'),(7,3,'joker','0'),(7,3,'oranje','1'),(7,3,'plus 2','0'),(7,3,'rood','0'),(7,3,'roos','1');
/*!40000 ALTER TABLE `spelerkaarten` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-01 12:41:06
