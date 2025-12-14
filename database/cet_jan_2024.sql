-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2025 at 08:38 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cet_jan_2024`
--
CREATE DATABASE IF NOT EXISTS `cet_jan_2024` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `cet_jan_2024`;

-- --------------------------------------------------------

--
-- Table structure for table `poruka`
--

DROP TABLE IF EXISTS `poruka`;
CREATE TABLE IF NOT EXISTS `poruka` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `posiljalac_id` bigint(20) DEFAULT NULL,
  `primalac_id` bigint(20) DEFAULT NULL,
  `sadrzaj` varchar(200) DEFAULT NULL,
  `datumVreme` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `posiljalac_id` (`posiljalac_id`),
  KEY `primalac_id` (`primalac_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `poruka`
--

INSERT INTO `poruka` (`id`, `posiljalac_id`, `primalac_id`, `sadrzaj`, `datumVreme`) VALUES
(1, 4, 1, 'Alooo', '2025-06-23 18:09:21'),
(2, 2, 1, 'tu tu tu', '2025-06-23 18:12:09'),
(3, 2, 1, 'ee', '2025-06-23 18:16:01'),
(4, 3, 1, 'zzz', '2025-06-23 18:19:48'),
(5, 1, 3, 'Alooo', '2025-06-23 19:03:38'),
(6, 4, 1, 'sss', '2025-06-23 19:11:56'),
(7, 1, 1, 'Alooo', '2025-12-14 16:28:24'),
(8, 4, 4, 'Alooo', '2025-12-14 16:29:57'),
(9, 1, 1, 'Alooo', '2025-12-14 16:30:33');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
(1, 'Zika', 'z1'),
(2, 'Mika', 'm1'),
(3, 'Kika', 'k1'),
(4, 'Pera', 'p1'),
(5, 'Cika', 'c1'),
(6, 'Vera', 'v1');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `poruka`
--
ALTER TABLE `poruka`
  ADD CONSTRAINT `poruka_ibfk_1` FOREIGN KEY (`posiljalac_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `poruka_ibfk_2` FOREIGN KEY (`primalac_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
