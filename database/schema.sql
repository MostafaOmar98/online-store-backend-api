-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 18, 2020 at 11:59 AM
-- Server version: 5.7.17
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `online_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
                         `id` int(11) NOT NULL,
                         `username` varchar(50) NOT NULL,
                         `email` varchar(50) NOT NULL,
                         `password` varchar(256) NOT NULL,
                         `name` varchar(50) NOT NULL,
                         `key_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `email`, `password`, `name`, `key_id`) VALUES
(1, 'admin', 'admin@protonmail.com', '$2a$10$Zz/A5hPdoz0JRlPtLnirV.LJKdWP8PEUhipLt2DR3Q1v6gn.jjxLC', 'Ahmad', 1),
(2, 'admin2', 'admi2n@protonmail.com', '$2a$10$m19oKl/YNFPc/KOSdbpm/eduQFBkCgLipK5dNHAHD9qVJrZzp1sNu', 'Ahmad', 3),
(3, 'admin3', 'buyer2@protonmail.com', '$2a$10$5lIdq2QSXgCn4xTvLYTyVeDLceBjiL0phVDi8iEa/.CbKHBPnLOoe', 'Ahmad', 4);

-- --------------------------------------------------------

--
-- Table structure for table `admin_keys`
--

CREATE TABLE `admin_keys` (
                              `id` int(11) NOT NULL,
                              `key_value` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_keys`
--

INSERT INTO `admin_keys` (`id`, `key_value`) VALUES
(1, 'V2$H9sjbf#K'),
(2, 'vW8,.@unCi>N'),
(3, 'vWaQweR'),
(4, 'vWeRQASD');

-- --------------------------------------------------------

--
-- Table structure for table `buyer`
--

CREATE TABLE `buyer` (
                         `id` int(10) UNSIGNED NOT NULL,
                         `username` varchar(50) NOT NULL,
                         `email` varchar(50) NOT NULL,
                         `password` varchar(256) NOT NULL,
                         `name` varchar(50) NOT NULL,
                         `address` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buyer`
--

INSERT INTO `buyer` (`id`, `username`, `email`, `password`, `name`, `address`) VALUES
(1, 'ahmad', 'ahmad@protonmail.com', '$2a$10$v7ZJpnFkn47YDKzD51w0N.CFUg2jPtnAuPfdBLkhRGU8B3/zSMpSG', 'Ahmad', '2B'),
(2, 'ahmad2', 'ahmad2@protonmail.com', '$2a$10$CLPfkZZyobhkDTkTr1lGkuRePQsrfiBNS2k6CvQtYMXb9lSIHpT..', 'Ahmad', '2B'),
(3, 'ahmad3', 'ahmad3@protonmail.com', '$2a$10$QomX65YylJRO5/wpO/XdRucjuaqzf8yNyeS9maMo1VAgd1zmn.bNC', 'Ahmad', '2B'),
(4, 'buyer', 'buyer@protonmail.com', '$2a$10$a8pwWNlaVX1LHb2phViFLuuP/qZWHSvy1alftsQqnNyuxxwDkS4DO', 'Ahmad', '2B'),
(5, 'buyer2', 'buyer2@protonmail.com', '$2a$10$81byW1JNEXuvQV3hfM.FZOfD/2fwr.MCuxE1Uqz3CdmGm/4u9TME.', 'Ahmad', '2B');

-- --------------------------------------------------------

--
-- Table structure for table `store_owner`
--

CREATE TABLE `store_owner` (
                               `id` int(10) UNSIGNED NOT NULL,
                               `username` varchar(50) NOT NULL,
                               `email` varchar(50) NOT NULL,
                               `password` varchar(256) NOT NULL,
                               `name` varchar(50) NOT NULL,
                               `social_id` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `store_owner`
--

INSERT INTO `store_owner` (`id`, `username`, `email`, `password`, `name`, `social_id`) VALUES
(1, 'ahmad', 'ahmad@protonmail.com', '$2a$10$FFkn0Hg0QLDFL4vf/fXnPejGtRd2.EFxqfdpz00LOkFhKB4KoizkS', 'Ahmad', '2B'),
(2, 'ahmad2', 'ahma2d@protonmail.com', '$2a$10$ORTKDXF7yOrqLk0r1Z04Z.cayTCNTNmSZ9mj0bF6tyGtrzuNKVBwe', 'Ahmad', '2B');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `username` (`username`),
    ADD UNIQUE KEY `email` (`email`),
    ADD KEY `FK_key_id` (`key_id`);

--
-- Indexes for table `admin_keys`
--
ALTER TABLE `admin_keys`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `key_value` (`key_value`);

--
-- Indexes for table `buyer`
--
ALTER TABLE `buyer`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `username` (`username`),
    ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `store_owner`
--
ALTER TABLE `store_owner`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `username` (`username`),
    ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `admin_keys`
--
ALTER TABLE `admin_keys`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `buyer`
--
ALTER TABLE `buyer`
    MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `store_owner`
--
ALTER TABLE `store_owner`
    MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
