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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Peralta',3500,NULL,40818163,'25 De Mayo 1973, Corrientes, Argentina','imanolaugusto18@gmail.com','Imanol',3735636568),(2,'Gómez',3600,NULL,40123456,'San Martín 1024, Resistencia, Chaco','lucia.gomez@gmail.com','Lucía',3624789123),(3,'Rodríguez',3700,NULL,39876543,'Belgrano 854, Formosa','martinr@hotmail.com','Martín',3701234567),(4,'López',1000,NULL,42345678,'Av. Rivadavia 300, Buenos Aires','camilopez@yahoo.com','Camila',1145637890),(5,'Fernández',5500,NULL,41234567,'Sarmiento 999, Mendoza','juan.fer@gmail.com','Juan',2613344556),(6,'Martínez',5000,NULL,41789456,'Maipú 455, Córdoba','sofi.martinez@gmail.com','Sofía',3517896541),(7,'Sosa',4400,NULL,39001234,'Italia 1830, Salta','dsosa@gmail.com','Diego',3876677889),(8,'Torres',4000,NULL,40567891,'Mitre 77, Tucumán','flor.torres@gmail.com','Florencia',3814455667),(9,'Ramírez',3000,NULL,42233445,'España 1880, Santa Fe','cramirez@outlook.com','Carlos',3427788990),(10,'Morales',5400,NULL,41889900,'Av. Libertador 1200, San Juan','valenmorales@gmail.com','Valentina',2645566778);
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

-- Dump completed on 2025-05-27 15:42:30
