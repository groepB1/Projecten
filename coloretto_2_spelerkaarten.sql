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
INSERT INTO `spelerkaarten` VALUES (6,0,'blauw','0'),(6,0,'geel','0'),(6,0,'grijs','1'),(6,0,'groen','0'),(6,0,'joker','0'),(6,0,'oranje','1'),(6,0,'plus 2','0'),(6,0,'rood','0'),(6,0,'roos','1'),(6,1,'blauw','1'),(6,1,'geel','0'),(6,1,'grijs','0'),(6,1,'groen','0'),(6,1,'joker','0'),(6,1,'oranje','1'),(6,1,'plus 2','1'),(6,1,'rood','0'),(6,1,'roos','0'),(6,2,'blauw','2'),(6,2,'geel','1'),(6,2,'grijs','0'),(6,2,'groen','0'),(6,2,'joker','0'),(6,2,'oranje','0'),(6,2,'plus 2','0'),(6,2,'rood','0'),(6,2,'roos','0'),(6,3,'blauw','0'),(6,3,'geel','0'),(6,3,'grijs','1'),(6,3,'groen','0'),(6,3,'joker','0'),(6,3,'oranje','1'),(6,3,'plus 2','0'),(6,3,'rood','1'),(6,3,'roos','0'),(7,0,'blauw','0'),(7,0,'geel','0'),(7,0,'grijs','1'),(7,0,'groen','0'),(7,0,'joker','0'),(7,0,'oranje','0'),(7,0,'plus 2','0'),(7,0,'rood','0'),(7,0,'roos','1'),(7,1,'blauw','0'),(7,1,'geel','0'),(7,1,'grijs','1'),(7,1,'groen','0'),(7,1,'joker','0'),(7,1,'oranje','0'),(7,1,'plus 2','0'),(7,1,'rood','0'),(7,1,'roos','1'),(7,2,'blauw','1'),(7,2,'geel','0'),(7,2,'grijs','0'),(7,2,'groen','0'),(7,2,'joker','0'),(7,2,'oranje','0'),(7,2,'plus 2','0'),(7,2,'rood','0'),(7,2,'roos','1'),(7,3,'blauw','0'),(7,3,'geel','0'),(7,3,'grijs','0'),(7,3,'groen','0'),(7,3,'joker','0'),(7,3,'oranje','1'),(7,3,'plus 2','0'),(7,3,'rood','0'),(7,3,'roos','1'),(8,0,'blauw','0'),(8,0,'geel','0'),(8,0,'grijs','1'),(8,0,'groen','0'),(8,0,'joker','0'),(8,0,'oranje','1'),(8,0,'plus 2','1'),(8,0,'rood','0'),(8,0,'roos','0'),(8,1,'blauw','0'),(8,1,'geel','0'),(8,1,'grijs','1'),(8,1,'groen','1'),(8,1,'joker','0'),(8,1,'oranje','0'),(8,1,'plus 2','0'),(8,1,'rood','0'),(8,1,'roos','1'),(8,2,'blauw','0'),(8,2,'geel','0'),(8,2,'grijs','1'),(8,2,'groen','1'),(8,2,'joker','0'),(8,2,'oranje','0'),(8,2,'plus 2','0'),(8,2,'rood','1'),(8,2,'roos','0'),(8,3,'blauw','0'),(8,3,'geel','0'),(8,3,'grijs','0'),(8,3,'groen','0'),(8,3,'joker','0'),(8,3,'oranje','0'),(8,3,'plus 2','1'),(8,3,'rood','1'),(8,3,'roos','1'),(9,0,'blauw','0'),(9,0,'geel','0'),(9,0,'grijs','1'),(9,0,'groen','1'),(9,0,'joker','0'),(9,0,'oranje','0'),(9,0,'plus 2','0'),(9,0,'rood','0'),(9,0,'roos','1'),(9,1,'blauw','0'),(9,1,'geel','0'),(9,1,'grijs','0'),(9,1,'groen','0'),(9,1,'joker','0'),(9,1,'oranje','1'),(9,1,'plus 2','0'),(9,1,'rood','1'),(9,1,'roos','1'),(9,2,'blauw','0'),(9,2,'geel','2'),(9,2,'grijs','0'),(9,2,'groen','0'),(9,2,'joker','0'),(9,2,'oranje','0'),(9,2,'plus 2','0'),(9,2,'rood','1'),(9,2,'roos','0'),(9,3,'blauw','0'),(9,3,'geel','1'),(9,3,'grijs','0'),(9,3,'groen','1'),(9,3,'joker','0'),(9,3,'oranje','0'),(9,3,'plus 2','1'),(9,3,'rood','0'),(9,3,'roos','0'),(10,0,'blauw','1'),(10,0,'geel','0'),(10,0,'grijs','0'),(10,0,'groen','0'),(10,0,'joker','0'),(10,0,'oranje','0'),(10,0,'plus 2','0'),(10,0,'rood','0'),(10,0,'roos','2'),(10,1,'blauw','0'),(10,1,'geel','0'),(10,1,'grijs','1'),(10,1,'groen','0'),(10,1,'joker','0'),(10,1,'oranje','1'),(10,1,'plus 2','0'),(10,1,'rood','0'),(10,1,'roos','1'),(10,2,'blauw','0'),(10,2,'geel','0'),(10,2,'grijs','1'),(10,2,'groen','0'),(10,2,'joker','1'),(10,2,'oranje','0'),(10,2,'plus 2','0'),(10,2,'rood','0'),(10,2,'roos','1'),(10,3,'blauw','0'),(10,3,'geel','1'),(10,3,'grijs','0'),(10,3,'groen','2'),(10,3,'joker','0'),(10,3,'oranje','0'),(10,3,'plus 2','0'),(10,3,'rood','0'),(10,3,'roos','0'),(11,0,'blauw','1'),(11,0,'geel','0'),(11,0,'grijs','0'),(11,0,'groen','0'),(11,0,'joker','0'),(11,0,'oranje','0'),(11,0,'plus 2','1'),(11,0,'rood','0'),(11,0,'roos','0'),(11,1,'blauw','0'),(11,1,'geel','0'),(11,1,'grijs','0'),(11,1,'groen','1'),(11,1,'joker','0'),(11,1,'oranje','1'),(11,1,'plus 2','0'),(11,1,'rood','0'),(11,1,'roos','0'),(11,2,'blauw','0'),(11,2,'geel','1'),(11,2,'grijs','0'),(11,2,'groen','0'),(11,2,'joker','0'),(11,2,'oranje','1'),(11,2,'plus 2','0'),(11,2,'rood','0'),(11,2,'roos','0'),(11,3,'blauw','0'),(11,3,'geel','0'),(11,3,'grijs','0'),(11,3,'groen','0'),(11,3,'joker','0'),(11,3,'oranje','1'),(11,3,'plus 2','0'),(11,3,'rood','0'),(11,3,'roos','1'),(12,0,'blauw','0'),(12,0,'geel','1'),(12,0,'grijs','0'),(12,0,'groen','0'),(12,0,'joker','0'),(12,0,'oranje','1'),(12,0,'plus 2','0'),(12,0,'rood','0'),(12,0,'roos','0'),(12,1,'blauw','0'),(12,1,'geel','1'),(12,1,'grijs','0'),(12,1,'groen','0'),(12,1,'joker','0'),(12,1,'oranje','0'),(12,1,'plus 2','0'),(12,1,'rood','0'),(12,1,'roos','1'),(12,2,'blauw','0'),(12,2,'geel','0'),(12,2,'grijs','1'),(12,2,'groen','0'),(12,2,'joker','0'),(12,2,'oranje','0'),(12,2,'plus 2','0'),(12,2,'rood','0'),(12,2,'roos','1'),(12,3,'blauw','0'),(12,3,'geel','0'),(12,3,'grijs','1'),(12,3,'groen','0'),(12,3,'joker','0'),(12,3,'oranje','0'),(12,3,'plus 2','1'),(12,3,'rood','0'),(12,3,'roos','0'),(13,0,'blauw','0'),(13,0,'geel','0'),(13,0,'grijs','0'),(13,0,'groen','1'),(13,0,'joker','0'),(13,0,'oranje','0'),(13,0,'plus 2','0'),(13,0,'rood','0'),(13,0,'roos','1'),(13,1,'blauw','0'),(13,1,'geel','1'),(13,1,'grijs','1'),(13,1,'groen','0'),(13,1,'joker','0'),(13,1,'oranje','0'),(13,1,'plus 2','0'),(13,1,'rood','0'),(13,1,'roos','0'),(13,2,'blauw','0'),(13,2,'geel','1'),(13,2,'grijs','0'),(13,2,'groen','0'),(13,2,'joker','0'),(13,2,'oranje','0'),(13,2,'plus 2','0'),(13,2,'rood','1'),(13,2,'roos','0'),(13,3,'blauw','1'),(13,3,'geel','0'),(13,3,'grijs','0'),(13,3,'groen','1'),(13,3,'joker','0'),(13,3,'oranje','0'),(13,3,'plus 2','0'),(13,3,'rood','0'),(13,3,'roos','0'),(14,0,'blauw','1'),(14,0,'geel','1'),(14,0,'grijs','1'),(14,0,'groen','0'),(14,0,'joker','0'),(14,0,'oranje','0'),(14,0,'plus 2','0'),(14,0,'rood','0'),(14,0,'roos','0'),(14,1,'blauw','0'),(14,1,'geel','1'),(14,1,'grijs','0'),(14,1,'groen','0'),(14,1,'joker','0'),(14,1,'oranje','1'),(14,1,'plus 2','0'),(14,1,'rood','1'),(14,1,'roos','0'),(14,2,'blauw','1'),(14,2,'geel','0'),(14,2,'grijs','0'),(14,2,'groen','0'),(14,2,'joker','0'),(14,2,'oranje','0'),(14,2,'plus 2','1'),(14,2,'rood','1'),(14,2,'roos','0'),(14,3,'blauw','0'),(14,3,'geel','2'),(14,3,'grijs','0'),(14,3,'groen','1'),(14,3,'joker','0'),(14,3,'oranje','0'),(14,3,'plus 2','0'),(14,3,'rood','0'),(14,3,'roos','0'),(15,0,'blauw','1'),(15,0,'geel','0'),(15,0,'grijs','1'),(15,0,'groen','0'),(15,0,'joker','0'),(15,0,'oranje','0'),(15,0,'plus 2','0'),(15,0,'rood','0'),(15,0,'roos','0'),(15,1,'blauw','0'),(15,1,'geel','0'),(15,1,'grijs','0'),(15,1,'groen','0'),(15,1,'joker','1'),(15,1,'oranje','0'),(15,1,'plus 2','0'),(15,1,'rood','1'),(15,1,'roos','0'),(15,2,'blauw','0'),(15,2,'geel','1'),(15,2,'grijs','1'),(15,2,'groen','0'),(15,2,'joker','0'),(15,2,'oranje','0'),(15,2,'plus 2','0'),(15,2,'rood','0'),(15,2,'roos','0'),(15,3,'blauw','0'),(15,3,'geel','1'),(15,3,'grijs','0'),(15,3,'groen','0'),(15,3,'joker','0'),(15,3,'oranje','0'),(15,3,'plus 2','0'),(15,3,'rood','1'),(15,3,'roos','0'),(16,0,'blauw','1'),(16,0,'geel','0'),(16,0,'grijs','1'),(16,0,'groen','0'),(16,0,'joker','0'),(16,0,'oranje','0'),(16,0,'plus 2','0'),(16,0,'rood','0'),(16,0,'roos','0'),(16,1,'blauw','0'),(16,1,'geel','0'),(16,1,'grijs','1'),(16,1,'groen','0'),(16,1,'joker','0'),(16,1,'oranje','0'),(16,1,'plus 2','1'),(16,1,'rood','0'),(16,1,'roos','0'),(16,2,'blauw','0'),(16,2,'geel','0'),(16,2,'grijs','1'),(16,2,'groen','1'),(16,2,'joker','0'),(16,2,'oranje','0'),(16,2,'plus 2','0'),(16,2,'rood','0'),(16,2,'roos','0'),(16,3,'blauw','0'),(16,3,'geel','0'),(16,3,'grijs','0'),(16,3,'groen','0'),(16,3,'joker','0'),(16,3,'oranje','0'),(16,3,'plus 2','1'),(16,3,'rood','0'),(16,3,'roos','1'),(17,0,'blauw','0'),(17,0,'geel','0'),(17,0,'grijs','0'),(17,0,'groen','0'),(17,0,'joker','2'),(17,0,'oranje','0'),(17,0,'plus 2','0'),(17,0,'rood','0'),(17,0,'roos','0'),(17,1,'blauw','0'),(17,1,'geel','1'),(17,1,'grijs','0'),(17,1,'groen','0'),(17,1,'joker','0'),(17,1,'oranje','0'),(17,1,'plus 2','1'),(17,1,'rood','0'),(17,1,'roos','0'),(17,2,'blauw','0'),(17,2,'geel','0'),(17,2,'grijs','1'),(17,2,'groen','0'),(17,2,'joker','0'),(17,2,'oranje','0'),(17,2,'plus 2','0'),(17,2,'rood','0'),(17,2,'roos','1'),(17,3,'blauw','0'),(17,3,'geel','0'),(17,3,'grijs','1'),(17,3,'groen','0'),(17,3,'joker','0'),(17,3,'oranje','1'),(17,3,'plus 2','0'),(17,3,'rood','0'),(17,3,'roos','0'),(18,0,'blauw','0'),(18,0,'geel','0'),(18,0,'grijs','0'),(18,0,'groen','1'),(18,0,'joker','0'),(18,0,'oranje','0'),(18,0,'plus 2','0'),(18,0,'rood','1'),(18,0,'roos','0'),(18,1,'blauw','0'),(18,1,'geel','0'),(18,1,'grijs','0'),(18,1,'groen','1'),(18,1,'joker','0'),(18,1,'oranje','0'),(18,1,'plus 2','0'),(18,1,'rood','0'),(18,1,'roos','1'),(18,2,'blauw','0'),(18,2,'geel','1'),(18,2,'grijs','0'),(18,2,'groen','0'),(18,2,'joker','0'),(18,2,'oranje','0'),(18,2,'plus 2','1'),(18,2,'rood','0'),(18,2,'roos','0'),(18,3,'blauw','1'),(18,3,'geel','0'),(18,3,'grijs','0'),(18,3,'groen','0'),(18,3,'joker','1'),(18,3,'oranje','0'),(18,3,'plus 2','0'),(18,3,'rood','0'),(18,3,'roos','0'),(19,0,'blauw','0'),(19,0,'geel','0'),(19,0,'grijs','2'),(19,0,'groen','0'),(19,0,'joker','0'),(19,0,'oranje','0'),(19,0,'plus 2','0'),(19,0,'rood','0'),(19,0,'roos','0'),(19,1,'blauw','0'),(19,1,'geel','0'),(19,1,'grijs','0'),(19,1,'groen','1'),(19,1,'joker','0'),(19,1,'oranje','1'),(19,1,'plus 2','0'),(19,1,'rood','0'),(19,1,'roos','0'),(19,2,'blauw','0'),(19,2,'geel','0'),(19,2,'grijs','0'),(19,2,'groen','0'),(19,2,'joker','0'),(19,2,'oranje','0'),(19,2,'plus 2','2'),(19,2,'rood','0'),(19,2,'roos','0'),(19,3,'blauw','1'),(19,3,'geel','1'),(19,3,'grijs','0'),(19,3,'groen','0'),(19,3,'joker','0'),(19,3,'oranje','0'),(19,3,'plus 2','0'),(19,3,'rood','0'),(19,3,'roos','0'),(20,0,'blauw','0'),(20,0,'geel','0'),(20,0,'grijs','1'),(20,0,'groen','0'),(20,0,'joker','0'),(20,0,'oranje','0'),(20,0,'plus 2','1'),(20,0,'rood','0'),(20,0,'roos','0'),(20,1,'blauw','0'),(20,1,'geel','0'),(20,1,'grijs','0'),(20,1,'groen','1'),(20,1,'joker','0'),(20,1,'oranje','0'),(20,1,'plus 2','0'),(20,1,'rood','1'),(20,1,'roos','0'),(20,2,'blauw','0'),(20,2,'geel','1'),(20,2,'grijs','1'),(20,2,'groen','0'),(20,2,'joker','0'),(20,2,'oranje','0'),(20,2,'plus 2','0'),(20,2,'rood','0'),(20,2,'roos','0'),(20,3,'blauw','1'),(20,3,'geel','0'),(20,3,'grijs','0'),(20,3,'groen','0'),(20,3,'joker','0'),(20,3,'oranje','1'),(20,3,'plus 2','0'),(20,3,'rood','0'),(20,3,'roos','0'),(21,0,'blauw','0'),(21,0,'geel','0'),(21,0,'grijs','1'),(21,0,'groen','0'),(21,0,'joker','0'),(21,0,'oranje','0'),(21,0,'plus 2','1'),(21,0,'rood','1'),(21,0,'roos','0'),(21,1,'blauw','1'),(21,1,'geel','0'),(21,1,'grijs','0'),(21,1,'groen','1'),(21,1,'joker','0'),(21,1,'oranje','0'),(21,1,'plus 2','0'),(21,1,'rood','1'),(21,1,'roos','0'),(21,2,'blauw','0'),(21,2,'geel','1'),(21,2,'grijs','1'),(21,2,'groen','1'),(21,2,'joker','0'),(21,2,'oranje','0'),(21,2,'plus 2','0'),(21,2,'rood','0'),(21,2,'roos','0'),(21,3,'blauw','1'),(21,3,'geel','0'),(21,3,'grijs','0'),(21,3,'groen','1'),(21,3,'joker','0'),(21,3,'oranje','1'),(21,3,'plus 2','0'),(21,3,'rood','0'),(21,3,'roos','0'),(22,0,'blauw','0'),(22,0,'geel','1'),(22,0,'grijs','1'),(22,0,'groen','0'),(22,0,'joker','1'),(22,0,'oranje','0'),(22,0,'plus 2','1'),(22,0,'rood','1'),(22,0,'roos','0'),(22,1,'blauw','1'),(22,1,'geel','0'),(22,1,'grijs','0'),(22,1,'groen','1'),(22,1,'joker','1'),(22,1,'oranje','0'),(22,1,'plus 2','0'),(22,1,'rood','1'),(22,1,'roos','1'),(22,2,'blauw','1'),(22,2,'geel','1'),(22,2,'grijs','1'),(22,2,'groen','2'),(22,2,'joker','0'),(22,2,'oranje','0'),(22,2,'plus 2','0'),(22,2,'rood','0'),(22,2,'roos','0'),(22,3,'blauw','2'),(22,3,'geel','0'),(22,3,'grijs','0'),(22,3,'groen','1'),(22,3,'joker','0'),(22,3,'oranje','1'),(22,3,'plus 2','0'),(22,3,'rood','0'),(22,3,'roos','1'),(23,0,'blauw','0'),(23,0,'geel','0'),(23,0,'grijs','0'),(23,0,'groen','0'),(23,0,'joker','0'),(23,0,'oranje','2'),(23,0,'plus 2','0'),(23,0,'rood','1'),(23,0,'roos','0'),(23,1,'blauw','3'),(23,1,'geel','0'),(23,1,'grijs','0'),(23,1,'groen','0'),(23,1,'joker','0'),(23,1,'oranje','0'),(23,1,'plus 2','0'),(23,1,'rood','0'),(23,1,'roos','0'),(23,2,'blauw','0'),(23,2,'geel','0'),(23,2,'grijs','0'),(23,2,'groen','1'),(23,2,'joker','0'),(23,2,'oranje','0'),(23,2,'plus 2','1'),(23,2,'rood','1'),(23,2,'roos','0'),(23,3,'blauw','0'),(23,3,'geel','0'),(23,3,'grijs','2'),(23,3,'groen','1'),(23,3,'joker','0'),(23,3,'oranje','0'),(23,3,'plus 2','0'),(23,3,'rood','0'),(23,3,'roos','0'),(24,0,'blauw','0'),(24,0,'geel','0'),(24,0,'grijs','0'),(24,0,'groen','2'),(24,0,'joker','0'),(24,0,'oranje','0'),(24,0,'plus 2','0'),(24,0,'rood','0'),(24,0,'roos','1'),(24,1,'blauw','0'),(24,1,'geel','0'),(24,1,'grijs','1'),(24,1,'groen','0'),(24,1,'joker','0'),(24,1,'oranje','1'),(24,1,'plus 2','0'),(24,1,'rood','0'),(24,1,'roos','1'),(24,2,'blauw','1'),(24,2,'geel','0'),(24,2,'grijs','1'),(24,2,'groen','0'),(24,2,'joker','0'),(24,2,'oranje','0'),(24,2,'plus 2','1'),(24,2,'rood','0'),(24,2,'roos','0'),(24,3,'blauw','0'),(24,3,'geel','0'),(24,3,'grijs','2'),(24,3,'groen','1'),(24,3,'joker','0'),(24,3,'oranje','0'),(24,3,'plus 2','0'),(24,3,'rood','0'),(24,3,'roos','0'),(25,0,'blauw','0'),(25,0,'geel','0'),(25,0,'grijs','0'),(25,0,'groen','2'),(25,0,'joker','1'),(25,0,'oranje','0'),(25,0,'plus 2','0'),(25,0,'rood','0'),(25,0,'roos','1'),(25,1,'blauw','0'),(25,1,'geel','0'),(25,1,'grijs','1'),(25,1,'groen','0'),(25,1,'joker','0'),(25,1,'oranje','1'),(25,1,'plus 2','1'),(25,1,'rood','0'),(25,1,'roos','1'),(25,2,'blauw','1'),(25,2,'geel','0'),(25,2,'grijs','1'),(25,2,'groen','0'),(25,2,'joker','0'),(25,2,'oranje','0'),(25,2,'plus 2','1'),(25,2,'rood','1'),(25,2,'roos','0'),(25,3,'blauw','0'),(25,3,'geel','0'),(25,3,'grijs','2'),(25,3,'groen','1'),(25,3,'joker','0'),(25,3,'oranje','0'),(25,3,'plus 2','1'),(25,3,'rood','0'),(25,3,'roos','0'),(26,0,'blauw','0'),(26,0,'geel','0'),(26,0,'grijs','0'),(26,0,'groen','0'),(26,0,'joker','0'),(26,0,'oranje','0'),(26,0,'plus 2','1'),(26,0,'rood','1'),(26,0,'roos','0'),(26,1,'blauw','1'),(26,1,'geel','1'),(26,1,'grijs','0'),(26,1,'groen','0'),(26,1,'joker','0'),(26,1,'oranje','0'),(26,1,'plus 2','0'),(26,1,'rood','0'),(26,1,'roos','0'),(26,2,'blauw','0'),(26,2,'geel','0'),(26,2,'grijs','1'),(26,2,'groen','0'),(26,2,'joker','0'),(26,2,'oranje','1'),(26,2,'plus 2','0'),(26,2,'rood','0'),(26,2,'roos','0'),(26,3,'blauw','0'),(26,3,'geel','1'),(26,3,'grijs','0'),(26,3,'groen','0'),(26,3,'joker','0'),(26,3,'oranje','0'),(26,3,'plus 2','0'),(26,3,'rood','1'),(26,3,'roos','0'),(27,0,'blauw','0'),(27,0,'geel','0'),(27,0,'grijs','0'),(27,0,'groen','0'),(27,0,'joker','0'),(27,0,'oranje','0'),(27,0,'plus 2','1'),(27,0,'rood','1'),(27,0,'roos','0'),(27,1,'blauw','1'),(27,1,'geel','1'),(27,1,'grijs','0'),(27,1,'groen','0'),(27,1,'joker','0'),(27,1,'oranje','0'),(27,1,'plus 2','0'),(27,1,'rood','0'),(27,1,'roos','0'),(27,2,'blauw','0'),(27,2,'geel','0'),(27,2,'grijs','1'),(27,2,'groen','0'),(27,2,'joker','0'),(27,2,'oranje','1'),(27,2,'plus 2','0'),(27,2,'rood','0'),(27,2,'roos','0'),(27,3,'blauw','0'),(27,3,'geel','1'),(27,3,'grijs','0'),(27,3,'groen','0'),(27,3,'joker','0'),(27,3,'oranje','0'),(27,3,'plus 2','0'),(27,3,'rood','1'),(27,3,'roos','0'),(28,0,'blauw','0'),(28,0,'geel','0'),(28,0,'grijs','0'),(28,0,'groen','1'),(28,0,'joker','0'),(28,0,'oranje','0'),(28,0,'plus 2','1'),(28,0,'rood','1'),(28,0,'roos','0'),(28,1,'blauw','1'),(28,1,'geel','1'),(28,1,'grijs','0'),(28,1,'groen','0'),(28,1,'joker','0'),(28,1,'oranje','0'),(28,1,'plus 2','0'),(28,1,'rood','1'),(28,1,'roos','0'),(28,2,'blauw','1'),(28,2,'geel','0'),(28,2,'grijs','1'),(28,2,'groen','0'),(28,2,'joker','0'),(28,2,'oranje','1'),(28,2,'plus 2','0'),(28,2,'rood','0'),(28,2,'roos','0'),(28,3,'blauw','1'),(28,3,'geel','1'),(28,3,'grijs','0'),(28,3,'groen','0'),(28,3,'joker','0'),(28,3,'oranje','0'),(28,3,'plus 2','0'),(28,3,'rood','1'),(28,3,'roos','0'),(29,0,'blauw','0'),(29,0,'geel','0'),(29,0,'grijs','0'),(29,0,'groen','1'),(29,0,'joker','0'),(29,0,'oranje','0'),(29,0,'plus 2','1'),(29,0,'rood','1'),(29,0,'roos','0'),(29,1,'blauw','1'),(29,1,'geel','1'),(29,1,'grijs','0'),(29,1,'groen','0'),(29,1,'joker','0'),(29,1,'oranje','0'),(29,1,'plus 2','0'),(29,1,'rood','1'),(29,1,'roos','0'),(29,2,'blauw','1'),(29,2,'geel','0'),(29,2,'grijs','1'),(29,2,'groen','0'),(29,2,'joker','0'),(29,2,'oranje','1'),(29,2,'plus 2','0'),(29,2,'rood','0'),(29,2,'roos','0'),(29,3,'blauw','1'),(29,3,'geel','1'),(29,3,'grijs','0'),(29,3,'groen','0'),(29,3,'joker','0'),(29,3,'oranje','0'),(29,3,'plus 2','0'),(29,3,'rood','1'),(29,3,'roos','0');
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

-- Dump completed on 2020-05-04 21:47:19
