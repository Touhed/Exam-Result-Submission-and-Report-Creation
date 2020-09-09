-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 14, 2019 at 07:58 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `examresult`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `UserId` int(20) NOT NULL,
  `UserName` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `UserType` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`UserId`, `UserName`, `Email`, `Password`, `UserType`) VALUES
(1, 'a', 'aaa@gmail.com', '1111', 'Admin'),
(2, 'b', 'bbb@gmail.com', '2222', 'Teacher'),
(3, 'c', 'ccc@gmail.com', '3333', 'Student');

-- --------------------------------------------------------

--
-- Table structure for table `studentinfo`
--

CREATE TABLE `studentinfo` (
  `SN` int(30) NOT NULL,
  `StudentId` int(30) NOT NULL,
  `StudentName` varchar(50) NOT NULL,
  `Department` varchar(30) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Contact` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentinfo`
--

INSERT INTO `studentinfo` (`SN`, `StudentId`, `StudentName`, `Department`, `Address`, `Contact`, `Email`) VALUES
(1, 1710, 'abc', 'cse', 'uttara', '13135161231651', 'abc@gmail.com'),
(2, 1711, 'def', 'bba', 'dhaka', '172214864', 'def@gmail.com'),
(3, 1712, 'ghi', 'ME', 'dhaka', '849595515414', 'ghi@gmail.com'),
(4, 1713, 'jkl', 'EEE', 'uttara', '0172589855', 'jkl@gmail.com'),
(5, 1714, 'mno', 'CE', 'dhaka', '01955845855', 'mno@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `transcript`
--

CREATE TABLE `transcript` (
  `SN` int(20) NOT NULL,
  `Id` int(20) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Subject` varchar(30) NOT NULL,
  `Section` varchar(20) NOT NULL,
  `Marks` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transcript`
--

INSERT INTO `transcript` (`SN`, `Id`, `Name`, `Subject`, `Section`, `Marks`) VALUES
(1, 1710, 'abc', 'English', 'A', 90),
(2, 1710, 'abc', 'Math', 'A', 95),
(3, 1712, 'abd', 'Science', 'B', 90);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`UserId`);

--
-- Indexes for table `studentinfo`
--
ALTER TABLE `studentinfo`
  ADD PRIMARY KEY (`SN`);

--
-- Indexes for table `transcript`
--
ALTER TABLE `transcript`
  ADD PRIMARY KEY (`SN`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
