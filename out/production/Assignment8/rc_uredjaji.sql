CREATE DATABASE  IF NOT EXISTS `rc_racunari` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `rc_racunari`;
-- MySQL dump 10.13  Distrib 8.0.13, for macos10.14 (x86_64)
--
-- Host: localhost    Database: rc_racunari
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.37-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `lokacije`
--

DROP TABLE IF EXISTS `lokacije`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lokacije` (
  `id_lokacije` int(11) NOT NULL AUTO_INCREMENT,
  `grad` varchar(45) NOT NULL,
  `adresa` varchar(45) NOT NULL,
  PRIMARY KEY (`id_lokacije`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lokacije`
--

/*!40000 ALTER TABLE `lokacije` DISABLE KEYS */;
INSERT INTO `lokacije` VALUES (1,'Beograd','Danijelova 32a'),(2,'Beograd','Kumodraska 261a'),(3,'Novi Sad','Bulevar Mihajla Pupina 4a'),(4,'Nis','Nikole Pasica 28');
/*!40000 ALTER TABLE `lokacije` ENABLE KEYS */;

--
-- Table structure for table `racunari`
--

DROP TABLE IF EXISTS `racunari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `racunari` (
  `id_racunari` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) DEFAULT NULL,
  `inventarski_broj` int(5) unsigned DEFAULT NULL,
  `konfiguracija` varchar(255) DEFAULT NULL,
  `maticna` varchar(45) DEFAULT NULL,
  `procesor` varchar(45) DEFAULT NULL,
  `ram` varchar(45) DEFAULT NULL,
  `hdd` varchar(45) DEFAULT NULL,
  `napajanje` varchar(45) DEFAULT NULL,
  `graficka` varchar(45) DEFAULT NULL,
  `komentar` varchar(255) DEFAULT NULL,
  `id_lokacije` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_racunari`),
  KEY `fk_lokacije` (`id_lokacije`),
  CONSTRAINT `fk_lokacije` FOREIGN KEY (`id_lokacije`) REFERENCES `lokacije` (`id_lokacije`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `racunari`
--

/*!40000 ALTER TABLE `racunari` DISABLE KEYS */;
INSERT INTO `racunari` VALUES (1,'ex. Kaća Lukić, Stud. služba',7367,NULL,'Ima - Ne radi','Ima + Integrisana GPU','2 x 1GB','Ima, WD 320GB','Ima','Ima','Povremeno se pali, vrv matična kvar',NULL),(2,'Danilo Golijan',NULL,NULL,'Ima','Ima','Nema','Ima, WD 250GB','Nema','Nema','Napisano na kompu, izvađena grafika i napajanje, otišla matična',NULL),(3,'No - 01',NULL,NULL,'Ima','Ima + Integrisana GPU','1 x 512MB, 1 x 256MB','Ima, Hitachi 82GB','Ima','Integrisana','Win 7 Professional',2),(4,'ex. Cvele',7339,NULL,'Ima','Ima','2 x 1GB','Ima, WD 250GB','Ima','Ima','Ne radi verovatno napajanje',NULL),(5,'Tanasković',7337,NULL,'Ima','Ima','2 x 1GB','Ima, WD 250GB','Ima','Nema','Nema graficke ',NULL),(6,'ex. Slavka Drašković',7338,NULL,'Ima','Ima','1 x 2GB','Ima, WD 320GB','Ima','Ima','Ne pali se, ne reaguje tastatura',NULL),(7,'ex Stojić',1162,'BRENDIRANI HP',NULL,NULL,NULL,NULL,NULL,NULL,'Win 7 Professional',NULL),(8,'Barać',NULL,NULL,'Ima','Ima','1 x 256MB','Ima, WD 30GB','Ima','Ima','Za otpis',NULL),(9,'Jasna Pak',NULL,'IBM','Ima','Ima','1 x DDR1 512MB','Ima, WD 40GB','Ima','Integrisana','Za otpis',NULL),(10,'ex. Služba',0,NULL,'Ima','Ima','2 x 512MB','Ima, WD 80GB','Ima','Ima','Uparen sa monitorom samsung 19. S/N HA19HMFP901032',NULL),(11,'Brendiran Dell radi ',1396,'Brendiran Dell',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,NULL,7349,NULL,'Ima','Ima','2x2','Ima, Hitachi 250GB pinovi polomljeni',NULL,NULL,NULL,NULL),(13,'Ex Jeremic',NULL,NULL,'Ima','Ima','1x256MB 3x512MB  DDR','Ima, Seagate 80GB','Ima','Ima + Integrisana',NULL,NULL),(14,'Ex glavni u 112',7326,NULL,'Ima','Ima ','1x2GB','Ima, WD 80GB','Ima','Ima','Win 7',NULL),(15,'Ex Živković',7334,NULL,'GA-P35-DS3R','Core 2 Duo E6550','2 x 1GB','Ima 2 x  250GB S-ATA','400W',' 8400gs','Ne pali se',NULL);
/*!40000 ALTER TABLE `racunari` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-18 12:58:39
