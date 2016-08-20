-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 08, 2015 at 09:17 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cse370project`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminlogin`
--

CREATE TABLE IF NOT EXISTS `adminlogin` (
  `sL_admin` int(11) NOT NULL,
  `admin_name` varchar(15) NOT NULL,
  `admin_password` varchar(15) NOT NULL,
  `admin_type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adminlogin`
--

INSERT INTO `adminlogin` (`sL_admin`, `admin_name`, `admin_password`, `admin_type`) VALUES
(1, 'maqsud', 'abc', 'salesman'),
(2, 'tahanima', 'chowdhury', 'admin'),
(3, 'sazzad', 'sazzad', 'admin'),
(4, 'local', 'root', 'admin'),
(5, 'sazib', 'saz', 'admin'),
(6, 'salesman', 'salesman', 'salesman'),
(7, 'local2', 'root2', 'salesman'),
(9, 'cse370', 'cse370', 'admin'),
(36, 'cseProject', 'okdone', 'salesman');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `customerId` varchar(15) NOT NULL DEFAULT '',
  `customerName` varchar(15) DEFAULT NULL,
  `customerHouseNo` varchar(15) DEFAULT NULL,
  `customerRoadNo` varchar(15) DEFAULT NULL,
  `customerCity` varchar(15) DEFAULT NULL,
  `customerLocation` varchar(15) DEFAULT NULL,
  `customerPhone` varchar(20) DEFAULT NULL,
  `customerEmail` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerId`, `customerName`, `customerHouseNo`, `customerRoadNo`, `customerCity`, `customerLocation`, `customerPhone`, `customerEmail`) VALUES
('0001', 'Sajib', '5/2c', '2', 'Dhaka', 'kallyanpur', '01812341267', 'sazib66@gmail.com'),
('0002', 'Navan', '7', '2', 'Dhaka', 'Iqbal Road', '0165489785', 'navan27@gmail.com'),
('0003', 'soumik', '1', '2', 'Dhaka', 'azimpur', '0165454879', 'pwxh@GMAIL.COM'),
('00032', 'opu', '5', '9', 'Dhaka', 'kallyanpur', '01236565', 'saz@hma.com'),
('0004', 'Ismot', '8', '2', 'Dhaka', 'Lalmatia', '0165454645', 'ismot@nmail.com'),
('0005', 'Moskud', '6', '7', 'Dhaka', 'Mohammadpur', '5655213', 'xh0123@nmail.com'),
('0006', 'Anwar', '5', '7', 'Dhaka', 'Mohammadpur', '0123565654', 'mAQ@nmail.com'),
('0007', 'Moskud', '9', '5', 'dhaka', 'Mohammadpur', '0125955455', 'maqsud@ymail.com'),
('0008', 'Sazzad', '96', '57', 'dhaka', 'Shamoli', '01674716980', 'sazib@ymail.com'),
('0009', 'Tanzim', '9', '5', 'dhaka', 'dhanmodi', '0155363656', 'tanzim@ymail.com'),
('0010', 'shakib', '98', '2', 'Dhaka', 'Farmgate', '0123565859', 'shakib236@gmail.com'),
('0013', 'Opu', '6', '58', 'Dhaka', 'shamoli', '0123569856', 'hakjda@mail.com'),
('0020', 'Saleh', '5', '6', 'Dhaka', 'Lalmatia', '01876544532', 'saleh@mail.com'),
('00326', 'ismoti', '67', '56', 'Dhaka', 'purbachol', '023656585', 'jhdakj@mail.com'),
('0098', 'Mahi', '4', '3', 'Sylhet', 'Lalbagh', '01789764324', 'mahi@mail.com'),
('00987', 'Muna', '7', '4', 'Dhaka', 'Mohamadpur', '01987656787', 'muna@mail.com'),
('011', 'Ismail', '6', '420', 'Dhaka', 'Mogbazar', '0165656986', 'ismail@hotmail.com'),
('0127', 'Taha', '4', '5', 'Dhaka', 'Lalmatia', '01937896534', 'taha@gmail.com'),
('065', 'Akash', '6', '98', 'dhaka', 'kakrail', '0123656985', 'ok@ymail.com'),
('66', 'Fahim', '4', '7', 'Sylhet', 'Hak', '01876543243', 'fah@mail.com');

-- --------------------------------------------------------

--
-- Table structure for table `orderlist`
--

CREATE TABLE IF NOT EXISTS `orderlist` (
  `orderId` varchar(15) NOT NULL DEFAULT '',
  `customerId` varchar(15) DEFAULT NULL,
  `orderDate` date DEFAULT NULL,
  `orderPayementType` varchar(15) DEFAULT NULL,
  `totalAmountPayement` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderlist`
--

INSERT INTO `orderlist` (`orderId`, `customerId`, `orderDate`, `orderPayementType`, `totalAmountPayement`) VALUES
('o665', '0001', '2015-06-25', 'Bkash', '56'),
('or0001', '0001', '2015-04-23', 'Bank', '5695'),
('or0002', '0002', '2015-04-18', 'Cash', '5632'),
('or0003', '0003', '2015-05-18', 'Bank', '3265'),
('or0004', '0004', '2015-04-20', 'Cash', '5698'),
('or0005', '0010', '2015-04-25', 'Cash', '4569'),
('or0006', '0009', '2015-04-21', 'bank', '458'),
('or0007', '0005', '2015-01-21', 'cash', '563'),
('oR535', '0005', '2015-04-04', 'bank', '365'),
('or635', '0005', '2015-04-04', 'cash', '2000'),
('or898956', '0004', '2015-04-23', 'Bank', '8699');

-- --------------------------------------------------------

--
-- Table structure for table `orderproduct`
--

CREATE TABLE IF NOT EXISTS `orderproduct` (
  `orderId` varchar(15) NOT NULL,
  `productId` varchar(15) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `totalPrice` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderproduct`
--

INSERT INTO `orderproduct` (`orderId`, `productId`, `quantity`, `totalPrice`) VALUES
('or0001', '01', '4', '564'),
('or0001', '02', '3', '500'),
('or0001', '05', '6', '1164'),
('or0002', '01', '1', '64'),
('or0002', '08', '2', '164'),
('or0003', '06', '4', '664'),
('or0004', '02', '2', '564'),
('or0004', '03', '4', '264'),
('or0004', '04', '3', '994'),
('or0004', '06', '4', '584'),
('or0002', '05', '50', '36'),
('or0001', '01', '980', '360');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `productId` varchar(15) NOT NULL DEFAULT '',
  `productName` varchar(25) DEFAULT NULL,
  `productStock` decimal(10,0) DEFAULT NULL,
  `productPrice` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productId`, `productName`, `productStock`, `productPrice`) VALUES
('01', 'nido', '20', '400'),
('018', 'Chocolate', '4', '89'),
('02', 'cheese', '20', '200'),
('03', 'choco', '20', '100'),
('04', 'milo', '20', '150'),
('05', 'watch', '0', '800'),
('06', 'lays', '20', '70'),
('07', 'tea', '20', '80'),
('08', 'noodles', '20', '100'),
('09', 'scent', '0', '700'),
('10', 'cream', '20', '500'),
('11', 'Boost', '6', '980');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
  `supplierId` varchar(15) NOT NULL DEFAULT '',
  `supplierName` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supplierId`, `supplierName`) VALUES
('01', 'nestle'),
('02', 'sazibgroup'),
('03', 'pran'),
('04', 'acme'),
('05', 'akijbeverage'),
('06', 'transcom'),
('07', 'keya'),
('08', 'uniliver'),
('09', 'square'),
('10', 'arong');

-- --------------------------------------------------------

--
-- Table structure for table `supplierbankaccountinfo`
--

CREATE TABLE IF NOT EXISTS `supplierbankaccountinfo` (
  `supplierId` varchar(15) NOT NULL,
  `bank` varchar(15) DEFAULT NULL,
  `accountNo` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplierbankaccountinfo`
--

INSERT INTO `supplierbankaccountinfo` (`supplierId`, `bank`, `accountNo`) VALUES
('07', 'Brac Bank', '123236.235'),
('10', 'Brac Bank', '123.535.235'),
('08', 'Estern Bank', '1236.5353.3'),
('09', 'DBBL', '2535.235'),
('05', 'East west Bank', '323..32'),
('06', 'National Bank', '53535.23.32'),
('02', 'Modhumoti Bank', '352.235'),
('01', 'Jamuna Bank', '63.2112.235'),
('03', 'Brac Bank', '8978.235'),
('05', 'brac Bank', '1651322.6516');

-- --------------------------------------------------------

--
-- Table structure for table `suppliercontactinfo`
--

CREATE TABLE IF NOT EXISTS `suppliercontactinfo` (
  `supplierId` varchar(15) NOT NULL,
  `supplierHouseNo` varchar(11) DEFAULT NULL,
  `supplierRoadNo` varchar(11) DEFAULT NULL,
  `supplierCity` varchar(15) DEFAULT NULL,
  `supplierLocation` varchar(15) DEFAULT NULL,
  `supplierPhone` varchar(15) DEFAULT NULL,
  `supplierEmail` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `suppliercontactinfo`
--

INSERT INTO `suppliercontactinfo` (`supplierId`, `supplierHouseNo`, `supplierRoadNo`, `supplierCity`, `supplierLocation`, `supplierPhone`, `supplierEmail`) VALUES
('03', '5', '3', 'Dhaka', 'kakrail', '01236545698', 'kai@gmail.com'),
('10', '40', '60', 'Dhaka', 'dhamrai', '01656958', 'nesle@gmail.com'),
('05', '42', '42', 'Dhaka', 'mirpur', '032656985', 'pran@gmail.com'),
('06', '1', '2', 'Dhaka', 'kaoranbazar', '786542', 'acme@gmail.com'),
('07', '2', '1', 'Dhaka', 'rampura', '01656958', 'nesle@gmail.com'),
('09', '8', '9', 'Dhaka', 'puran dhaka', '0168686868', 'gmaz@gmail.com'),
('04', '23', '4', 'Dhaka', 'shamoli', '0123445688', 'gmart@gmail.com'),
('02', '9', '5', 'dhaka', 'bd', '02+881651', 'sd@kfjhsd.com');

-- --------------------------------------------------------

--
-- Table structure for table `supplyproduct`
--

CREATE TABLE IF NOT EXISTS `supplyproduct` (
  `supplierId` varchar(10) NOT NULL,
  `productId` varchar(10) NOT NULL,
  `supplyDate` date NOT NULL,
  `supplyPrice` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplyproduct`
--

INSERT INTO `supplyproduct` (`supplierId`, `productId`, `supplyDate`, `supplyPrice`) VALUES
('01', '01', '2015-04-01', '4000.00'),
('01', '01', '2015-04-01', '4000.00'),
('0206', '05', '2015-04-22', '322.00'),
('0206', '05', '2015-04-22', '322.00'),
('01', '05', '2015-04-09', '6543.00'),
('01', '05', '2015-04-09', '6543.00'),
('02', '03', '2015-04-01', '6765.00'),
('02', '03', '2015-04-01', '6765.00'),
('03', '08', '2015-04-03', '7675.00'),
('03', '08', '2015-04-03', '7675.00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adminlogin`
--
ALTER TABLE `adminlogin`
 ADD PRIMARY KEY (`sL_admin`), ADD UNIQUE KEY `admin_name` (`admin_name`), ADD UNIQUE KEY `sL_admin` (`sL_admin`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
 ADD PRIMARY KEY (`customerId`), ADD UNIQUE KEY `customerId` (`customerId`);

--
-- Indexes for table `orderlist`
--
ALTER TABLE `orderlist`
 ADD PRIMARY KEY (`orderId`), ADD UNIQUE KEY `orderId` (`orderId`), ADD KEY `customerId` (`customerId`);

--
-- Indexes for table `orderproduct`
--
ALTER TABLE `orderproduct`
 ADD KEY `orderId` (`orderId`), ADD KEY `productId` (`productId`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
 ADD PRIMARY KEY (`productId`), ADD UNIQUE KEY `productId` (`productId`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
 ADD PRIMARY KEY (`supplierId`), ADD UNIQUE KEY `supplierId` (`supplierId`);

--
-- Indexes for table `supplierbankaccountinfo`
--
ALTER TABLE `supplierbankaccountinfo`
 ADD KEY `supplierId` (`supplierId`);

--
-- Indexes for table `suppliercontactinfo`
--
ALTER TABLE `suppliercontactinfo`
 ADD KEY `supplierId` (`supplierId`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orderlist`
--
ALTER TABLE `orderlist`
ADD CONSTRAINT `orderlist_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`);

--
-- Constraints for table `orderproduct`
--
ALTER TABLE `orderproduct`
ADD CONSTRAINT `orderproduct_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orderlist` (`orderId`),
ADD CONSTRAINT `orderproduct_ibfk_2` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`);

--
-- Constraints for table `supplierbankaccountinfo`
--
ALTER TABLE `supplierbankaccountinfo`
ADD CONSTRAINT `supplierbankaccountinfo_ibfk_1` FOREIGN KEY (`supplierId`) REFERENCES `supplier` (`supplierId`);

--
-- Constraints for table `suppliercontactinfo`
--
ALTER TABLE `suppliercontactinfo`
ADD CONSTRAINT `suppliercontactinfo_ibfk_1` FOREIGN KEY (`supplierId`) REFERENCES `supplier` (`supplierId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
