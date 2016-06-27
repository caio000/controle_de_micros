CREATE DATABASE  IF NOT EXISTS `control` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `control`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: control
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.10-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `idAddress` int(11) NOT NULL AUTO_INCREMENT,
  `publicPlace` varchar(45) NOT NULL,
  `neighborhood` varchar(45) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`idAddress`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'RUA SIQUEIRA CAMPOS','CENTRO',44),(2,'RUA LUIZ PASSOS JÚNIOR','CENTRO',50),(3,'RUA VEREADOR ANTONIO CRUZ AROUCA','INDAIÁ',121),(4,'AVENIDA RIO DE JANEIRO','INDAIÁ',860),(5,'RUA LUIZ PASSOS JÚNIOR','CENTRO',50),(6,'AVENIDA BRASIL','SUMARÉ',749),(7,'AVENIDA MARANHÃO','JARDIM PRIMAVERA',451),(8,'RUA SÃO BENEDITO','CENTRO',436),(9,'RUA LUIZ PASSOS JÚNIOR','CENTRO',50),(10,'RUA LUIZ PASSOS JÚNIOR','CENTRO',50),(11,'RUA JORGE BURIHAN','JARDIM JAQUEIRA',10),(12,'RUA LUIZ PASSOS JÚNIOR','CENTRO',50),(13,'AVENIDA JOSÉ HERCULANO','JARDIM BRITÂNIA',50),(14,'AVENIDA RIO DE JANEIRO','JARDIM PRIMAVERA',171),(15,'AVENIDA DR.ARTHUR COSTA FILHO','CENTRO',25),(16,'AVENIDA DR. ARTHUR DA COSTA FILHO','CENTRO',457),(17,'RUA MAJOR AYRES','CENTRO',365),(18,'RAU IRMÃ SÃO FRANCISCO','CAPUTERA',83),(19,'AVENIDA SENADOR FEIJÓ','JARDIM ARUAN',165);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `computer`
--

DROP TABLE IF EXISTS `computer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `computer` (
  `ctis` int(11) NOT NULL,
  `idSecretariat` int(11) NOT NULL,
  `hostname` varchar(45) DEFAULT NULL,
  `ip` varchar(15) NOT NULL,
  `macAddress` varchar(45) DEFAULT NULL,
  `serial` varchar(45) NOT NULL,
  `model` varchar(45) DEFAULT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ctis`),
  UNIQUE KEY `ip_UNIQUE` (`ip`),
  KEY `fk_computer_secretariat_idx` (`idSecretariat`),
  CONSTRAINT `fk_computer_secretariat` FOREIGN KEY (`idSecretariat`) REFERENCES `secretariat` (`idsecretariat`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `computer`
--

LOCK TABLES `computer` WRITE;
/*!40000 ALTER TABLE `computer` DISABLE KEYS */;
/*!40000 ALTER TABLE `computer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone` (
  `idphone` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(9) NOT NULL,
  PRIMARY KEY (`idphone`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
INSERT INTO `phone` VALUES (1,'3897-8176'),(2,'3897-8183'),(3,'3886-2030'),(4,'3897-7000'),(5,'3897-8202'),(6,'3886-6060'),(7,'3897-2100'),(8,'3897-1100'),(9,'3897-8101'),(10,'3897-8105'),(11,'3886-3050'),(12,'3897-8282'),(13,'3885-2200'),(14,'3897-2530'),(15,'3897-7910'),(16,'3885-1600'),(17,'3886-2920'),(18,'3886-6080'),(19,'3885-4550');
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secretariat`
--

DROP TABLE IF EXISTS `secretariat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secretariat` (
  `idsecretariat` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `idAddress` int(11) NOT NULL,
  `idPhone` int(11) NOT NULL,
  PRIMARY KEY (`idsecretariat`),
  KEY `fk_secretariat_address_idx` (`idAddress`),
  KEY `fk_secretareat_phone_idx` (`idPhone`),
  CONSTRAINT `fk_secretareat_phone` FOREIGN KEY (`idPhone`) REFERENCES `phone` (`idphone`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_secretariat_address` FOREIGN KEY (`idAddress`) REFERENCES `address` (`idAddress`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secretariat`
--

LOCK TABLES `secretariat` WRITE;
/*!40000 ALTER TABLE `secretariat` DISABLE KEYS */;
INSERT INTO `secretariat` VALUES (1,'SEC. DE ADMINISTRAÇÃO',1,1),(2,'SEC. DE ASSUNTOS JURIDICOS',2,2),(3,'SEC. DE DESENVOLVIMENTO SOCIAL DE CIDADANIA',3,3),(4,'SEC. DE EDUCAÇÃO',4,4),(5,'SEC. DE FAZENDA',2,5),(6,'SEC. DE URBANISMO',6,6),(7,'SEC. DE SAÚDE',7,7),(8,'SEC. DE PLANEJAMENTO E TI',8,8),(9,'SEC. DE OBRAS PÚBLICAS',2,9),(10,'GABINETE DO PREFEITO',2,10),(11,'sec. da pessoa com deficiência e do idoso',11,11),(12,'SEC. DE GOVERNO',2,12),(13,'SEC. DE ESPORTES E RECREAÇÃO',13,13),(14,'SEC. DE MEIO AMBIENTE',14,14),(15,'SEC. DE TURISMO',15,15),(16,'SEC. DE HABITAÇÃO',16,16),(17,'SEC. DE COMINICAÇÃO SOCIAL',17,17),(18,'SEC. DE TRÂNSITO E SEGURANÇA',18,18),(19,'SEC. DE SERVIÇOS PÚBLICOS',19,19);
/*!40000 ALTER TABLE `secretariat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `registration` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `isAdmin` tinyint(1) NOT NULL DEFAULT '0',
  `isActive` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`registration`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-27 13:46:57
