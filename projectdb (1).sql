-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2021 at 04:25 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projectdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `projects`
--

CREATE TABLE `projects` (
  `ProjectID` int(11) NOT NULL,
  `ProjectName` varchar(50) NOT NULL,
  `ProjectType` varchar(50) NOT NULL,
  `UserID` int(11) NOT NULL,
  `sdate` date NOT NULL,
  `edate` date NOT NULL,
  `status` varchar(50) NOT NULL,
  `investStatus` varchar(50) NOT NULL,
  `InvestmentAmount` decimal(10,5) NOT NULL,
  `ProposedEquity` decimal(10,5) NOT NULL,
  `ProjectTimeline` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `projects`
--

INSERT INTO `projects` (`ProjectID`, `ProjectName`, `ProjectType`, `UserID`, `sdate`, `edate`, `status`, `investStatus`, `InvestmentAmount`, `ProposedEquity`, `ProjectTimeline`) VALUES
(3, 'nipuni', '', 0, '0000-00-00', '0000-00-00', 'ys', 'no', '0.00000', '0.00000', ''),
(4, 'jjj', '', 2, '2021-04-06', '2021-04-22', 'yes', 'yes', '0.00000', '0.00000', ''),
(5, 'xyz', 'typ', 1, '2021-09-09', '2021-10-09', 'no', 'no', '30.00000', '30.00000', '10years'),
(6, 'kkk', '', 2, '2020-12-12', '2020-12-12', 'yes', 'no', '0.00000', '0.00000', ''),
(7, 'lll', '', 3, '2020-02-02', '2020-02-02', 'yes', 'no', '0.00000', '0.00000', ''),
(8, 'mmm', 'finance', 4, '2020-12-12', '2020-12-31', 'yes', 'yes', '50.00000', '40.00000', '5 years'),
(9, 'mmm', 'finance', 4, '2020-12-12', '2020-12-31', 'yes', 'yes', '50.00000', '40.00000', '5 years'),
(10, 'mmm', 'finance', 4, '2020-12-12', '2020-12-31', 'ye', 'yes', '50.00000', '40.00000', '5 years'),
(11, 'mmm', 'finance', 4, '2020-12-12', '2020-12-31', 'no', 'yes', '50.00000', '40.00000', '5 years'),
(12, 'mmm', 'finance', 4, '2020-12-12', '2020-12-31', 'no', 'yes', '50.00000', '40.00000', '5 years'),
(13, 'mmm', 'finance', 4, '2020-12-12', '2020-12-31', 'yes', 'yes', '50.00000', '40.00000', '5 years'),
(14, 'mmm', 'finance', 4, '2020-12-12', '2020-12-31', 'yes', 'yes', '50.00000', '40.00000', '5 years'),
(15, 'hiru', 'girl', 3, '2020-03-03', '2020-09-09', 'yes', 'yes', '40.00000', '60.00000', '7 years'),
(18, 'lll', 's', 7, '2020-09-09', '2020-10-10', 'yes', 'yes', '50.00000', '7.00000', '6 years'),
(19, 'lll', 's', 7, '2021-09-09', '2021-10-10', 'yes', 'yes', '50.00000', '7.00000', '6 years');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`ProjectID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `projects`
--
ALTER TABLE `projects`
  MODIFY `ProjectID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
