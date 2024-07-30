-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2024 at 06:49 AM
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
-- Database: `coursework`
--

-- --------------------------------------------------------

--
-- Table structure for table `cartitems_info`
--

CREATE TABLE `cartitems_info` (
  `cart_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cartitems_info`
--

INSERT INTO `cartitems_info` (`cart_id`, `product_id`, `quantity`) VALUES
(42, 4, 5),
(42, 6, 4),
(46, 2, 4),
(46, 3, 4);

-- --------------------------------------------------------

--
-- Table structure for table `cart_info`
--

CREATE TABLE `cart_info` (
  `cart_id` int(11) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cart_info`
--

INSERT INTO `cart_info` (`cart_id`, `user_name`) VALUES
(46, 'prbhb'),
(42, 'renish_khadka');

-- --------------------------------------------------------

--
-- Table structure for table `order_info`
--

CREATE TABLE `order_info` (
  `order_id` int(11) NOT NULL,
  `cart_id` int(11) DEFAULT NULL,
  `order_status` varchar(30) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `total_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product_info`
--

CREATE TABLE `product_info` (
  `product_ID` int(255) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `product_description` varchar(255) NOT NULL,
  `product_price` int(60) NOT NULL,
  `product_stock` int(60) NOT NULL,
  `product_image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product_info`
--

INSERT INTO `product_info` (`product_ID`, `product_name`, `product_description`, `product_price`, `product_stock`, `product_image`) VALUES
(2, 'AMD RX7800XT', 'The HELLHOUND edition of our AMD RX 7800 XT does NOT disappoint. Better and faster than its predecessor, this offers a whole new world of possibilities through your screen.', 1300, 40, '7800XT.png'),
(3, 'RTX 4090 Ti', 'Just because something works doesnt mean it can\'t get better. The Gigabyte edition of the RTX 4090 Ti is living proof that even perfection can be further refined. Shop now!', 1800, 10, '4090ti.png'),
(4, 'RTX 4060', 'Just because something works doesnt mean it can\'t get better. The Gigabyte edition of the RTX 4060 is living proof that even perfection can be further refined. Shop now!', 1000, 31, '4060.png'),
(5, 'RTX 3090', 'The RTX 3090 blew up so we introduced an XTREME plan for the already perfect RTX 3090. Take your user experience to the XTREME with the all-new RTX 3090.', 1300, 15, '3090.png'),
(6, 'AMD RX6600', 'PowerColors and AMD have brought forth a new monster. Introducing RX 6600, made by AMD, guaranteed by PowerColor to deliver smoothness to your experience.', 1100, 30, 'Rx6600.png');

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE `user_info` (
  `user_name` varchar(20) NOT NULL,
  `first_name` varchar(60) NOT NULL,
  `middle_name` varchar(50) NOT NULL,
  `last_name` varchar(60) NOT NULL,
  `dob` date NOT NULL,
  `gender` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `phone_number` varchar(30) NOT NULL,
  `address` varchar(80) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`user_name`, `first_name`, `middle_name`, `last_name`, `dob`, `gender`, `email`, `phone_number`, `address`, `password`, `role`) VALUES
('admin', 'admin', '', 'admin', '2024-02-29', 'admin', 'admin@gmail.com', 'admin', 'admin', 'admin', 'admin'),
('prbhb', 'Prabhab', ' ', 'Khanal', '2024-04-29', 'male', 'prbhb1232gmail.com', '12345678901', 'Kathmandu', 'ewnB9OzJuVgxIkYso//5/aNEZVLoji1N5LmWZHUgk75iNejMj16sNbD68MZXt5+z', 'User'),
('renish_khadka', 'Renish', 'Kaji', 'Khadka', '2015-02-12', 'male', 'renish123@gmail.com', '1234567890', 'Hetauda-Ward No 55', 'yzKU+L4/sMbHvBpL5Y/diTROj1HgOsZefW+wmtb4bLd7rbki4MbA5tKTA+J44vjq', 'User');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cartitems_info`
--
ALTER TABLE `cartitems_info`
  ADD PRIMARY KEY (`cart_id`,`product_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `cart_info`
--
ALTER TABLE `cart_info`
  ADD PRIMARY KEY (`cart_id`),
  ADD KEY `user_name` (`user_name`);

--
-- Indexes for table `order_info`
--
ALTER TABLE `order_info`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `cart_id` (`cart_id`);

--
-- Indexes for table `product_info`
--
ALTER TABLE `product_info`
  ADD PRIMARY KEY (`product_ID`);

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
  ADD PRIMARY KEY (`user_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart_info`
--
ALTER TABLE `cart_info`
  MODIFY `cart_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `order_info`
--
ALTER TABLE `order_info`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cartitems_info`
--
ALTER TABLE `cartitems_info`
  ADD CONSTRAINT `cartitems_info_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `cart_info` (`cart_id`),
  ADD CONSTRAINT `cartitems_info_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product_info` (`product_ID`);

--
-- Constraints for table `cart_info`
--
ALTER TABLE `cart_info`
  ADD CONSTRAINT `cart_info_ibfk_1` FOREIGN KEY (`user_name`) REFERENCES `user_info` (`user_name`);

--
-- Constraints for table `order_info`
--
ALTER TABLE `order_info`
  ADD CONSTRAINT `order_info_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `cart_info` (`cart_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
