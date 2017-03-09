-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 09, 2017 at 11:37 AM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bms`
--
CREATE DATABASE IF NOT EXISTS `bms` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bms`;

-- --------------------------------------------------------

--
-- Table structure for table `tbladmin`
--

CREATE TABLE IF NOT EXISTS `tbladmin` (
  `username` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbladmin`
--

INSERT INTO `tbladmin` (`username`, `password`) VALUES
('bvillajin', '1234'),
('lseno', '1234'),
('syeo', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `tblbook`
--

CREATE TABLE IF NOT EXISTS `tblbook` (
  `bookId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `author` varchar(30) DEFAULT NULL,
  `publisher` varchar(100) DEFAULT NULL,
  `price` decimal(12,2) NOT NULL,
  `onhand` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `tblbook`
--

INSERT INTO `tblbook` (`bookId`, `title`, `author`, `publisher`, `price`, `onhand`) VALUES
(1, 'Book1', 'Author1', 'Publisher1', '100.00', 300),
(2, 'Book2', 'Author2', 'Publisher2', '200.00', 300),
(3, 'Book3', 'Author3', 'Publisher3', '300.00', 300),
(4, 'Book4', 'Author4', 'Publisher4', '400.00', 300),
(5, 'Book5', 'Author5', 'Publisher5', '500.00', 300);

-- --------------------------------------------------------

--
-- Table structure for table `tblrequest`
--

CREATE TABLE IF NOT EXISTS `tblrequest` (
  `requestId` int(11) NOT NULL AUTO_INCREMENT,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `or_no` int(11) NOT NULL DEFAULT '0',
  `id` int(11) NOT NULL,
  PRIMARY KEY (`requestId`),
  UNIQUE KEY `or_no` (`or_no`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `tblrequest`
--

INSERT INTO `tblrequest` (`requestId`, `date`, `or_no`, `id`) VALUES
(1, '2017-03-09 10:10:58', 0, 2014102880),
(2, '2017-03-09 10:10:58', 10000001, 2014102880),
(3, '2017-03-09 10:10:58', 10000002, 2014102881),
(4, '2017-03-09 10:10:58', 10000003, 2014102882);

-- --------------------------------------------------------

--
-- Table structure for table `tblrequestline`
--

CREATE TABLE IF NOT EXISTS `tblrequestline` (
  `requestId` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  `qtty` int(11) NOT NULL,
  KEY `bookId` (`bookId`),
  KEY `requestId` (`requestId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblrequestline`
--

INSERT INTO `tblrequestline` (`requestId`, `bookId`, `qtty`) VALUES
(1, 1, 1),
(1, 2, 1),
(2, 3, 1),
(3, 4, 1),
(4, 5, 1),
(4, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblstudent`
--

CREATE TABLE IF NOT EXISTS `tblstudent` (
  `id` int(11) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `fname` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblstudent`
--

INSERT INTO `tblstudent` (`id`, `lname`, `fname`) VALUES
(2014102880, 'Villajin', 'Bernadette'),
(2014102881, 'Yeo', 'Stephanie Mae'),
(2014102882, 'Seno', 'Louie');

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_requests`
--
CREATE TABLE IF NOT EXISTS `view_requests` (
`date` timestamp
,`concat(tblstudent.fname, " ", tblstudent.lname)` varchar(101)
,`title` varchar(100)
,`price` decimal(12,2)
,`tblrequestline.qtty * tblbook.price` decimal(22,2)
,`or_no` int(11)
);
-- --------------------------------------------------------

--
-- Structure for view `view_requests`
--
DROP TABLE IF EXISTS `view_requests`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_requests` AS select `tblrequest`.`date` AS `date`,concat(`tblstudent`.`fname`,' ',`tblstudent`.`lname`) AS `concat(tblstudent.fname, " ", tblstudent.lname)`,`tblbook`.`title` AS `title`,`tblbook`.`price` AS `price`,(`tblrequestline`.`qtty` * `tblbook`.`price`) AS `tblrequestline.qtty * tblbook.price`,`tblrequest`.`or_no` AS `or_no` from (((`tblrequest` join `tblstudent`) join `tblbook`) join `tblrequestline`) where ((`tblrequest`.`id` = `tblstudent`.`id`) and (`tblrequest`.`requestId` = `tblrequestline`.`requestId`) and (`tblrequestline`.`bookId` = `tblbook`.`bookId`)) order by `tblrequest`.`date` desc WITH CASCADED CHECK OPTION;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tblrequest`
--
ALTER TABLE `tblrequest`
  ADD CONSTRAINT `tblrequest_ibfk_1` FOREIGN KEY (`id`) REFERENCES `tblstudent` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `tblrequestline`
--
ALTER TABLE `tblrequestline`
  ADD CONSTRAINT `tblrequestline_ibfk_3` FOREIGN KEY (`requestId`) REFERENCES `tblrequest` (`requestId`) ON UPDATE CASCADE,
  ADD CONSTRAINT `tblrequestline_ibfk_2` FOREIGN KEY (`bookId`) REFERENCES `tblbook` (`bookId`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
