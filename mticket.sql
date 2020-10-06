-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 21, 2020 at 08:33 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mticket`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAdmin` ()  SELECT * FROM admin_login$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `admin_login`
--

CREATE TABLE `admin_login` (
  `admin_id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_login`
--

INSERT INTO `admin_login` (`admin_id`, `username`, `password`) VALUES
(1, 'jagannath', 'de594ef5c314372edec29b93cab9d72e'),
(2, 'albin', '202cb962ac59075b964b07152d234b70');

-- --------------------------------------------------------

--
-- Table structure for table `book_history`
--

CREATE TABLE `book_history` (
  `book_id` int(11) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `movie_name` varchar(20) NOT NULL,
  `theater_name` varchar(20) NOT NULL,
  `class` varchar(20) NOT NULL,
  `show_time` varchar(20) NOT NULL,
  `no_tickets` varchar(20) NOT NULL,
  `amount` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book_history`
--

INSERT INTO `book_history` (`book_id`, `user_id`, `movie_name`, `theater_name`, `class`, `show_time`, `no_tickets`, `amount`) VALUES
(7, '7', 'KGF', 'ALINKEL', 'GOLD', '11.00 AM', '3', '450'),
(8, '7', 'WAR', 'CLASSIC', 'PLATINUM', '8.00 PM', '5', '1000'),
(10, '10', 'LUCIFER', 'CINEPOLIS', 'SILVER', '9.00 AM', '1', '100');

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `email_id` varchar(40) NOT NULL,
  `creation_date_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `user_id`, `email_id`, `creation_date_time`) VALUES
(10, 7, 'albinabraham@gmail.com', '2019-12-03 08:42:06'),
(11, 8, 'jaggu@gmail.com', '2019-12-03 08:46:52'),
(12, 9, 'amalkv@gmail.com', '2019-12-03 10:18:50'),
(13, 10, 'ok@gmail.com', '2020-09-19 12:53:49');

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `movie_id` varchar(40) NOT NULL,
  `movie_name` varchar(40) NOT NULL,
  `movie_language` varchar(40) NOT NULL,
  `Rating` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`movie_id`, `movie_name`, `movie_language`, `Rating`) VALUES
('ae01', 'Avengers Endgame', 'English', 9),
('kgf01', 'KGF', 'kannada', 9),
('lf01', 'Lucifer', 'malayalam', 9),
('w01', 'war', 'hindi', 8);

-- --------------------------------------------------------

--
-- Table structure for table `theater`
--

CREATE TABLE `theater` (
  `theater_name` varchar(20) NOT NULL,
  `theater_location` varchar(20) NOT NULL,
  `no_screen` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `theater`
--

INSERT INTO `theater` (`theater_name`, `theater_location`, `no_screen`) VALUES
('big cinemas', 'mangalore', 4),
('cinepolis', 'mangalore', 4),
('suchitra', 'mangalore', 3),
('Alinkel 4k', 'kannur', 2),
('crown 4k', 'kannur', 1),
('classic 4k', 'kannur', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL,
  `password` varchar(40) NOT NULL,
  `email_id` varchar(50) NOT NULL,
  `mobile_number` varchar(10) DEFAULT NULL,
  `location` varchar(40) NOT NULL,
  `first_name` varchar(40) NOT NULL,
  `last_name` varchar(40) NOT NULL,
  `age` int(3) NOT NULL,
  `user_status` varchar(20) NOT NULL DEFAULT 'deactive'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`user_id`, `password`, `email_id`, `mobile_number`, `location`, `first_name`, `last_name`, `age`, `user_status`) VALUES
(7, '12345', 'albinabraham@gmail.com', '8943639646', 'MANGALORE', 'albin', 'abraham', 20, 'deactive'),
(9, '121212', 'amalkv@gmail.com', '6985745896', 'KANNUR', 'amal', 'kv', 20, 'deactive'),
(10, '123', 'ok@gmail.com', '123', 'MANGALORE', 'jaggu', 'kv', 19, 'active');

--
-- Triggers `user_info`
--
DELIMITER $$
CREATE TRIGGER `insertLog` AFTER INSERT ON `user_info` FOR EACH ROW INSERT INTO logs VALUES(null,NEW.user_id,NEW.email_id,NOW())
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_login`
--
ALTER TABLE `admin_login`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `book_history`
--
ALTER TABLE `book_history`
  ADD PRIMARY KEY (`book_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`);

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`movie_id`);

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin_login`
--
ALTER TABLE `admin_login`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `book_history`
--
ALTER TABLE `book_history`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `user_info`
--
ALTER TABLE `user_info`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
