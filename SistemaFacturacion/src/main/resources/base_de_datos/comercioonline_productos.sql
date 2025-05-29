-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: comercioonline
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripción` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `precio` int NOT NULL,
  `stock` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKmlgw7js72hh2xtd4mvpdqfsbe` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'MacBook Pro con chip M3, pantalla Retina de 14 pulgadas, 16GB RAM, 512GB SSD','Notebook MacBook Pro 4',1450000,10),(2,'Teclado inalámbrico mecánico de bajo perfil con retroiluminación RGB','Teclado mecánico Logitech G915',210000,15),(3,'Mouse inalámbrico con diseño ergonómico, ideal para trabajo prolongado','Mouse Ergonómico Logitech MX Master 3',145000,20),(4,'Silla ejecutiva ergonómica con soporte lumbar y apoyabrazos ajustables','Silla Ergonómica Homestool',250000,12),(5,'Monitor de 34 pulgadas ultrawide QHD con USB-C y tecnología IPS','Monitor ultrawide LG 34WN80C',620000,8),(6,'Auriculares con cancelación de ruido activa, bluetooth y micrófono integrado','Auriculares Gamer Sony WH-1000XM5',390000,18),(7,'Soporte ajustable premium para monitores hasta 34 pulgadas','Brazo Articulado para Monitor Ergotron LX',135000,10),(8,'Luces LED inteligentes RGB con control desde app móvil','Tiras LED Govee',45000,30),(9,'PC de alta gama para desarrollo y gaming extremo, con GPU RTX 4080','PC Armada Ryzen 9 9950X3D | 32GB DDR5 | 1TB NVMe',1890000,5),(10,'Decoración temática para espacios de trabajo de desarrolladores','Pack de 2 cuadros desarrollador Front-End / Back-End',30000,25);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-27 15:42:30
