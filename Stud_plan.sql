-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: study_plan2
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `certification`
--

DROP TABLE IF EXISTS `certification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `certification` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_plan` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcerf` (`id_plan`),
  CONSTRAINT `FKcerf` FOREIGN KEY (`id_plan`) REFERENCES `plan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `competence`
--

DROP TABLE IF EXISTS `competence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `competence` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_competence` varchar(100) DEFAULT NULL,
  `shifr_competence` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `creator_study_programm`
--

DROP TABLE IF EXISTS `creator_study_programm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creator_study_programm` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_teacher` int DEFAULT NULL,
  `id_study_programm` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcr` (`id_study_programm`),
  CONSTRAINT `FKcr` FOREIGN KEY (`id_study_programm`) REFERENCES `study_programm` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fakultativ`
--

DROP TABLE IF EXISTS `fakultativ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fakultativ` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_plan` int DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfak` (`id_plan`),
  CONSTRAINT `FKfak` FOREIGN KEY (`id_plan`) REFERENCES `plan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `group_components`
--

DROP TABLE IF EXISTS `group_components`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_components` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` enum('Государственный компонент','Компонент учреждения высшего образования','Факультативные дисциплины','Дополнительные виды обучения') DEFAULT NULL,
  `component_number` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `group_units`
--

DROP TABLE IF EXISTS `group_units`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_units` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `id_group_components` int DEFAULT NULL,
  `unit_number` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgrunit` (`id_group_components`),
  CONSTRAINT `FKgrunit` FOREIGN KEY (`id_group_components`) REFERENCES `group_components` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `node`
--

DROP TABLE IF EXISTS `node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `node` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_subject` int DEFAULT NULL,
  `id_cathedra` int DEFAULT NULL,
  `id_plan` int DEFAULT NULL,
  `node_number` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK` (`id_subject`),
  KEY `FK10` (`id_plan`),
  CONSTRAINT `FK` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id`),
  CONSTRAINT `FK10` FOREIGN KEY (`id_plan`) REFERENCES `plan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `plan`
--

DROP TABLE IF EXISTS `plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_speciality` int DEFAULT NULL,
  `diplom_name` varchar(100) DEFAULT NULL,
  `diplom_id_semestr` int DEFAULT NULL,
  `diplom_count_week` int DEFAULT NULL,
  `diplom_ze` int DEFAULT NULL,
  `enrollment_year` varchar(15) DEFAULT NULL,
  `reg_number` varchar(15) DEFAULT NULL,
  `utv_date` datetime DEFAULT NULL,
  `learn_year` varchar(45) DEFAULT NULL,
  `education_form` enum('очная','заочная','заочная на базе ССУЗ') DEFAULT NULL,
  `gov_exam` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9` (`id_speciality`) /*!80000 INVISIBLE */,
  CONSTRAINT `FK9` FOREIGN KEY (`id_speciality`) REFERENCES `speciality` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `practice`
--

DROP TABLE IF EXISTS `practice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `practice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_plan` int DEFAULT NULL,
  `id_semestr` int DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `count_week` int DEFAULT NULL,
  `ze` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKprac` (`id_plan`),
  CONSTRAINT `FKprac` FOREIGN KEY (`id_plan`) REFERENCES `plan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `semestr`
--

DROP TABLE IF EXISTS `semestr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `semestr` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` int NOT NULL,
  `lecture` int DEFAULT NULL,
  `laboratory` int DEFAULT NULL,
  `practice` int DEFAULT NULL,
  `seminar` int DEFAULT NULL,
  `type` enum('экзамен','зачет') DEFAULT NULL,
  `rgr` int DEFAULT NULL,
  `course_work_type` enum('work','project') DEFAULT NULL,
  `id_node` int DEFAULT NULL,
  `ze` int DEFAULT NULL,
  `cource_work_ze` int DEFAULT NULL,
  `cource_work_hours` int DEFAULT NULL,
  `id_teacher` int DEFAULT NULL,
  `id_faculty` int DEFAULT NULL,
  `selfeducation` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKS` (`id_node`),
  CONSTRAINT `FKS` FOREIGN KEY (`id_node`) REFERENCES `node` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `speciality`
--

DROP TABLE IF EXISTS `speciality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `speciality` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `shifr` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `study_programm`
--

DROP TABLE IF EXISTS `study_programm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `study_programm` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_subject` int DEFAULT NULL,
  `date_approve` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKstudy` (`id_subject`),
  CONSTRAINT `FKstudy` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sub_competence`
--

DROP TABLE IF EXISTS `sub_competence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sub_competence` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_competence` int DEFAULT NULL,
  `id_subject` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcom` (`id_competence`),
  KEY `FKcom2` (`id_subject`),
  CONSTRAINT `FKcom` FOREIGN KEY (`id_competence`) REFERENCES `competence` (`id`),
  CONSTRAINT `FKcom2` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `shifr` varchar(50) DEFAULT NULL,
  `id_unit` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsub` (`id_unit`),
  CONSTRAINT `FKsub` FOREIGN KEY (`id_unit`) REFERENCES `group_units` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `weeks_semestr`
--

DROP TABLE IF EXISTS `weeks_semestr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weeks_semestr` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number_semestr` int DEFAULT NULL,
  `count_weeks` int DEFAULT NULL,
  `id_plan` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKweek` (`id_plan`),
  CONSTRAINT `FKweek` FOREIGN KEY (`id_plan`) REFERENCES `plan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-05 13:10:32
