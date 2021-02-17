-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 25, 2019 at 05:27 PM
-- Server version: 10.1.39-MariaDB
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- Table structure for table `add_std`
--

CREATE TABLE `add_std` (
  `s_id` int(11) NOT NULL,
  `sname` varchar(200) NOT NULL,
  `smoblie` varchar(200) NOT NULL,
  `sfmoblie` varchar(200) NOT NULL,
  `sfname` varchar(200) NOT NULL,
  `sfo` varchar(200) NOT NULL,
  `smname` varchar(200) NOT NULL,
  `smmoblie` varchar(200) NOT NULL,
  `smo` varchar(200) NOT NULL,
  `spi` varchar(200) NOT NULL,
  `ssex` varchar(200) NOT NULL,
  `sprdv` varchar(200) NOT NULL,
  `sprds` varchar(200) NOT NULL,
  `sprv` varchar(200) NOT NULL,
  `spdv` varchar(200) NOT NULL,
  `spds` varchar(200) NOT NULL,
  `spv` varchar(200) NOT NULL,
  `sbranch` varchar(200) NOT NULL,
  `sbroad` varchar(200) NOT NULL,
  `spy` varchar(200) NOT NULL,
  `sgpa` varchar(200) NOT NULL,
  `s12broad` varchar(200) NOT NULL,
  `s12py` varchar(200) NOT NULL,
  `s12gpa` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `form`
--

CREATE TABLE `form` (
  `s_id` int(11) NOT NULL,
  `sname` varchar(200) NOT NULL,
  `smoblie` varchar(200) NOT NULL,
  `sfmoblie` varchar(200) NOT NULL,
  `sfname` varchar(200) NOT NULL,
  `sfo` varchar(200) NOT NULL,
  `smname` varchar(200) NOT NULL,
  `smmoblie` varchar(200) NOT NULL,
  `smo` varchar(200) NOT NULL,
  `spi` varchar(200) NOT NULL,
  `ssex` varchar(200) NOT NULL,
  `sprdv` varchar(200) NOT NULL,
  `sprds` varchar(200) NOT NULL,
  `sprv` varchar(200) NOT NULL,
  `spdv` varchar(200) NOT NULL,
  `spds` varchar(200) NOT NULL,
  `spv` varchar(200) NOT NULL,
  `sbranch` varchar(200) NOT NULL,
  `sbroad` varchar(200) NOT NULL,
  `spy` varchar(200) NOT NULL,
  `sgpa` varchar(200) NOT NULL,
  `s12broad` varchar(200) NOT NULL,
  `s12py` varchar(200) NOT NULL,
  `s12gpa` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `form`
--

INSERT INTO `form` (`s_id`, `sname`, `smoblie`, `sfmoblie`, `sfname`, `sfo`, `smname`, `smmoblie`, `smo`, `spi`, `ssex`, `sprdv`, `sprds`, `sprv`, `spdv`, `spds`, `spv`, `sbranch`, `sbroad`, `spy`, `sgpa`, `s12broad`, `s12py`, `s12gpa`) VALUES
(1, ' Sayed Ashik', '016', '017', 'Afteb    ', 'yy', 'Rahamatun nesa', '018    ', 'Housewife', '158888888', '', 'a    ', 'a', 'a    ', 's    ', 's    ', 's', 'COMPUTER SCIENCE AND ENG ', 'kul    ', '2013    ', '4.00', '4.00', '2015', '4.00'),
(2, 'Medul Medul', '01781', '01781', 'wzzol       ', 'Teacher', 'Afroza', '01781       ', 'Housewife', '30000', 'Male', 'a       ', 'b', 'c       ', 'x       ', 'y       ', 'z', 'COMPUTER SCIENCE AND ENG ', 'reg       ', '2013       ', '3.00', '3.00', '2015', '3.00'),
(4, 'Dipu', '01781', '01781', 'a', 'b', 'e', '01781', 'f', '30000', 'Male', 'd', 'b', 'c', 'x', 'f', 'e', 'COMPUTER SCIENCE AND ENG', 'reg', '2013', '3.00', 'reg', '2015', '3.00'),
(5, 'Rafid T', '017', '0147852', 'a ', 'b', 'd', '0147852 ', 'f', '158888888', '', 'd ', 'b', 'c ', 'x ', 'y ', 'z', 'COMPUTER SCIENCE AND ENG ', 'reg ', '2013 ', '77', 'reg', '2015', '77'),
(7, 'Biplon', '0147852', '0147852', 'a', 'b', 'e', '0147852', 'f', '30000', 'Male', 'd', 'b', 'y', 'x', 'y', 'e', 'COMPUTER SCIENCE AND ENG', 'reg', '2013', '4.00', 'reg', '2015', '4.00');

-- --------------------------------------------------------

--
-- Table structure for table `sign_up`
--

CREATE TABLE `sign_up` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sign_up`
--

INSERT INTO `sign_up` (`id`, `name`, `email`, `password`) VALUES
(1, 'Ashik', 'ashik@gmail.com', '258'),
(4, 'Dipanker Sarker', 'dip@gmail.com', '123'),
(6, 'kobir', 'hk@gmail.com', '123456'),
(7, 'mbh', 'mbh@gmail.com', '123456'),
(2, 'Medul', 'medul@gmail.com', '147'),
(3, 'Medul Hasan', 'medulhasan@gmail.com', '258'),
(5, 'Rafid', 'r@gmail.com', '789');

-- --------------------------------------------------------

--
-- Table structure for table `t_userdoc`
--

CREATE TABLE `t_userdoc` (
  `s_pic` varchar(200) NOT NULL,
  `s_tenmarkpic` varchar(200) NOT NULL,
  `s_tencerpic` varchar(200) NOT NULL,
  `s_twdmarkpic` varchar(200) NOT NULL,
  `s_twdcerpic` varchar(200) NOT NULL,
  `s_idprfpic` varchar(200) NOT NULL,
  `s_sigpic` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_userdoc`
--

INSERT INTO `t_userdoc` (`s_pic`, `s_tenmarkpic`, `s_tencerpic`, `s_twdmarkpic`, `s_twdcerpic`, `s_idprfpic`, `s_sigpic`) VALUES
('Screenshot (17).png', '', '', '', '', '', ''),
('Screenshot (17).png', '', '', '', '', '', ''),
('Screenshot (17).png', '', '', '', '', '', ''),
('Screenshot (17).png', '', '', '', '', '', ''),
('Screenshot (17).png', '', '', '', '', '', ''),
('Screenshot (17).png', '', '', '', '', '', ''),
('Screenshot (7).png', '', '', '', '', '', ''),
('Screenshot (7).png', '', '', '', '', '', ''),
('Screenshot (1).png', '', '', '', '', '', ''),
('Screenshot (1).png', '', '', '', '', '', ''),
('Screenshot (8).png', '', '', '', '', '', ''),
('Screenshot (5).png', '', '', '', '', '', ''),
('', '', '', '', '', '', ''),
('', '', '', '', '', '', ''),
('', '', '', '', '', '', ''),
('', '', '', '', '', '', ''),
('', '', '', '', '', '', ''),
('', '', '', '', '', '', ''),
('', '', '', '', '', '', ''),
('', '', '', '', '', '', ''),
('', '', '', '', '', '', ''),
('', '', '', '', '', '', ''),
('', '', '', '', '', '', ''),
('Screenshot (8).png', '', '', '', '', '', ''),
('Screenshot (7).png', '', '', '', '', '', ''),
('', '', '', '', '', '', ''),
('', '', '', '', '', '', ''),
('', '', '', '', '', '', ''),
('Screenshot (7).png', 'Screenshot (17).png', 'Screenshot (6).png', 'Screenshot (17).png', 'Screenshot (8).png', 'Screenshot (7).png', 'Screenshot (2).png'),
('Screenshot (1).png', 'Screenshot (9).png', 'Screenshot (17).png', 'Screenshot (17).png', 'Screenshot (4).png', 'Screenshot (8).png', 'Screenshot (2).png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `add_std`
--
ALTER TABLE `add_std`
  ADD PRIMARY KEY (`s_id`);

--
-- Indexes for table `form`
--
ALTER TABLE `form`
  ADD PRIMARY KEY (`s_id`);

--
-- Indexes for table `sign_up`
--
ALTER TABLE `sign_up`
  ADD PRIMARY KEY (`email`),
  ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sign_up`
--
ALTER TABLE `sign_up`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
