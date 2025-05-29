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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) NOT NULL,
  `código postal` int NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `dni` int NOT NULL,
  `domicilio` varchar(255) NOT NULL,
  `correo electrónico` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `número de teléfono` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKm6ysdwsqke00e5piajbvgn6lg` (`dni`),
  UNIQUE KEY `UK8mb9o41joa58huvkh2iybta9k` (`correo electrónico`),
  UNIQUE KEY `UKte2bg4qgueouwr2dyyey75mj9` (`número de teléfono`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'González',5500,'2025-05-29 01:17:57.032000',12345678,'25 De Mayo, 123','cliente@example.com','Pedro',5491123456789),(2,'Martínez',1406,'2025-05-29 01:18:10.000000',23456789,'Calle San Juan, 456','lucia.martinez@example.com','Lucía',5491134567820),(3,'Fernández',5000,'2025-05-29 01:18:25.000000',34567890,'Av. Córdoba 789','julian.fernandez@example.com','Julián',5491167890123),(4,'Sánchez',7600,'2025-05-29 01:18:40.000000',45678901,'Belgrano 987','carla.sanchez@example.com','Carla',5491145678901),(5,'Ramírez',8300,'2025-05-29 01:19:00.000000',56789012,'España 654','matias.ramirez@example.com','Matías',5491178901234),(6,'Peralta',3500,'2025-05-29 01:20:22.480000',40818163,'Álvarez Thomas n°20','imanolaugusto18@gmail.com','Imanol',3735636568);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-28 23:15:10
