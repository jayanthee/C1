-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 08, 2014 at 05:44 AM
-- Server version: 5.1.44
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `c1`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `Id` int(15) NOT NULL AUTO_INCREMENT,
  `Name` varchar(300) DEFAULT ' ',
  `Address` varchar(300) DEFAULT ' ',
  `Address2` varchar(300) DEFAULT ' ',
  `City` varchar(90) DEFAULT ' ',
  `State` varchar(90) DEFAULT ' ',
  `ZipCode` varchar(90) DEFAULT ' ',
  `Type` enum('Agency','Advertiser','Publisher') NOT NULL DEFAULT 'Publisher',
  `BillingContactFirstName` varchar(150) DEFAULT ' ',
  `BillingContactLastName` varchar(150) DEFAULT ' ',
  `BillingContactPhone` varchar(150) DEFAULT ' ',
  `BillingContactEmail` varchar(300) DEFAULT ' ',
  `PaymentMethod` varchar(150) DEFAULT ' ',
  `PaymentDetails` varchar(300) DEFAULT ' ',
  `IntegrationId` varchar(50) DEFAULT NULL,
  `CreatedBy` int(11) NOT NULL,
  `Created` datetime NOT NULL,
  `UpdatedBy` int(11) NOT NULL,
  `Updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`Id`, `Name`, `Address`, `Address2`, `City`, `State`, `ZipCode`, `Type`, `BillingContactFirstName`, `BillingContactLastName`, `BillingContactPhone`, `BillingContactEmail`, `PaymentMethod`, `PaymentDetails`, `IntegrationId`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(1, 'ABCAgency', '117/51, North Steet', 'Thirubuvanam', 'Kumbakonam', 'Tamil Nadu', '612103', 'Agency', 'Muthu Kumar', 'Rajaraman', '+919842065014', 'muthu1980@gmail.com', 'Paypal', 'Payment Received', '', 0, '0000-00-00 00:00:00', 0, '0000-00-00 00:00:00'),
(2, 'OMG', '1933 silva pl', '', 'santa clara', 'ca', '95054', 'Agency', 'kim', 'perkins', '4088448586', 'k@omg.com', 'credit', 'master card', '', 0, '0000-00-00 00:00:00', 0, '0000-00-00 00:00:00'),
(3, 'sai', '1/177,North Street', 'Thirubuvanam', 'Thanjavur', 'Tamil Nadu', '612103', 'Agency', 'SaiRam', 'Sunder', NULL, 'sairamonnet@gmail.com', 'creditcard', NULL, 'integrationid', 1, '2014-01-10 19:14:34', 1, '2014-01-10 13:44:34'),
(4, 'sai1', '1/177,North Street', 'Thirubuvanam', 'Thanjavur', 'Tamil Nadu', '612103', 'Agency', 'SaiRam', 'Sunder', '9842012345', 'sairamonnet@gmail.com', 'creditcard', 'paid through paypalaccount', 'integrationid', 1, '2014-01-10 19:20:09', 1, '2014-01-10 13:50:09'),
(5, 'sai1', '1/177,North Street', 'Thirubuvanam', 'Thanjavur', 'Tamil Nadu', '612103', 'Agency', 'SaiRam', 'Sunder', '9842012345', 'sairamonnet@gmail.com', 'creditcard', 'paid through paypalaccount', '111', 1, '2014-01-11 17:50:37', 1, '2014-01-11 17:50:37'),
(6, 'sai', '1/177,North Street', 'Thirubuvanam', 'Thanjavur', 'Tamil Nadu', '612103', 'Agency', 'SaiRam', 'Sunder', NULL, 'sairamonnet@gmail.com', 'creditcard', NULL, NULL, 1, '2014-01-11 16:09:40', 1, '2014-01-11 21:39:40'),
(7, 'sai', '1/177,NorthStreet', 'Thirubuvanam', 'Thanjavur', 'TamilNadu', '612103', 'Agency', 'SaiRam', 'Sunder', NULL, 'sairamonnet@gmail.com', 'creditcard', NULL, NULL, 1, '2014-01-12 00:10:07', 1, '2014-01-12 05:40:07'),
(8, 'sai', '1/177,North Street', 'Thirubuvanam', 'Thanjavur', 'Tamil Nadu', '612103', 'Agency', 'SaiRam', 'Sunder', NULL, 'sairamonnet@gmail.com', 'creditcard', NULL, NULL, 1, '2014-01-12 07:55:49', 1, '2014-01-12 13:25:49'),
(9, 'sai', '1/177,NorthStreet', 'Thirubuvanam', 'Thanjavur', 'TamilNadu', '612103', 'Agency', 'SaiRam', 'Sunder', NULL, 'sairamonnet@gmail.com', 'creditcard', NULL, NULL, 1, '2014-01-13 01:58:52', 1, '2014-01-13 07:28:52'),
(10, 'Express Logistics and Transport', '620 SW 5th Avenue Suite 400', '', 'Portland', 'Oregon', '97204', 'Agency', 'fTest', 'LTest', NULL, 'test@test.com', 'creditcard', NULL, NULL, 1, '2014-01-13 02:10:57', 1, '2014-01-13 07:40:57'),
(11, 'Express Logistics and Transport', '620 SW 5th Avenue Suite 400', '', 'Portland', 'Oregon', '97204', 'Agency', 'fTest', 'LTest', NULL, 'test@test.com', 'creditcard', NULL, NULL, 1, '2014-01-13 02:15:19', 1, '2014-01-13 07:45:19'),
(12, 'Express Logistics and Transport', '620 SW 5th Avenue Suite 400', '', 'Portland', 'Oregon', '97204', 'Agency', 'fTest', 'LTest', NULL, 'test@test.com', 'creditcard', NULL, NULL, 1, '2014-01-13 02:16:08', 1, '2014-01-13 07:46:08'),
(13, 'Express Logistics and Transport', '620 SW 5th Avenue Suite 400', '', 'Portland', 'Oregon', '97204', 'Agency', 'fTest', 'LTest', NULL, 'test@test.com', 'creditcard', NULL, NULL, 1, '2014-01-14 00:17:19', 1, '2014-01-14 05:47:19'),
(14, 'Express Logistics and Transport', '620 SW 5th Avenue Suite 400', '', 'Portland', 'Oregon', '97204', 'Agency', 'fTest', 'LTest', NULL, 'test@test.com', 'creditcard', NULL, NULL, 1, '2014-01-14 00:41:06', 1, '2014-01-14 06:11:06'),
(15, 'Express Logistics and Transport', '620 SW 5th Avenue Suite 400', '', 'Portland', 'Oregon', '97204', 'Agency', 'fTest', 'LTest', NULL, 'test@test.com', 'creditcard', NULL, NULL, 1, '2014-01-14 00:44:20', 1, '2014-01-14 06:14:20'),
(16, 'Express Logistics and Transport', '620 SW 5th Avenue Suite 400', '', 'Portland', 'Oregon', '97204', 'Agency', 'fTest', 'LTest', NULL, 'test@test.com', 'creditcard', NULL, NULL, 1, '2014-01-14 00:45:38', 1, '2014-01-14 06:15:38'),
(17, 'Express Logistics and Transport', '620 SW 5th Avenue Suite 400', '', 'Portland', 'Oregon', '97204', 'Agency', 'fTest', 'LTest', NULL, 'test@test.com', 'creditcard', NULL, NULL, 1, '2014-01-15 02:11:59', 1, '2014-01-15 07:41:59'),
(18, 'sai', '1/177,North Street', 'Thirubuvanam', 'Thanjavur', 'Tamil Nadu', '612103', 'Agency', 'SaiRam', 'Sunder', NULL, 'sairamonnet@gmail.com', 'creditcard', NULL, NULL, 1, '2014-01-21 10:33:23', 1, '2014-01-21 16:03:23'),
(19, 'saisuresh', '1/177,North Street', 'Thirubuvanam', 'Thanjavur', 'Tamil Nadu', '612103', 'Agency', 'SaiRam', 'Sunder', '9842012345', 'sairamonnet@gmail.com', 'creditcard', 'paid through paypalaccount', '111', 0, '2014-01-24 04:28:13', 0, '2014-01-24 09:58:13');

-- --------------------------------------------------------

--
-- Table structure for table `adunitimpression`
--

CREATE TABLE IF NOT EXISTS `adunitimpression` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ImpressionSettingsId` int(11) DEFAULT NULL,
  `AdUnitId` int(11) DEFAULT NULL,
  `PlacementId` int(11) DEFAULT NULL,
  `AvailImpressions` int(11) DEFAULT '0',
  `PublicInventoryImpression` int(11) DEFAULT '0',
  `PrivateInventoryImpression` int(11) DEFAULT '0',
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`),
  KEY `ImpressionSettingsId` (`ImpressionSettingsId`),
  KEY `AdUnitId` (`AdUnitId`),
  KEY `PlacementId` (`PlacementId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `adunitimpression`
--

INSERT INTO `adunitimpression` (`Id`, `ImpressionSettingsId`, `AdUnitId`, `PlacementId`, `AvailImpressions`, `PublicInventoryImpression`, `PrivateInventoryImpression`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(1, 1, 111, 111, 30000, 40000, 50000, 1, '2014-01-16 00:00:00', 1, '2014-01-31 11:27:40'),
(2, 2, 444, 444, 60000, 70000, 80000, 1, '2014-01-31 11:27:30', 1, '2014-01-31 11:27:40');

-- --------------------------------------------------------

--
-- Table structure for table `adunits`
--

CREATE TABLE IF NOT EXISTS `adunits` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  `Sizes` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  `Style` varchar(45) DEFAULT NULL,
  `ParentId` int(11) DEFAULT NULL,
  `PublisherId` int(11) DEFAULT NULL,
  `VendorId` int(11) DEFAULT NULL,
  `CPM` decimal(15,2) DEFAULT NULL,
  `Currency` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `ImageLink` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  `KeyWords` varchar(6000) CHARACTER SET utf8 DEFAULT NULL,
  `Positions` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `PlacementType` int(11) DEFAULT '0',
  `InventoryType` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `DefaultRateCardId` int(11) DEFAULT '0',
  `SpecialRateCardId` int(11) DEFAULT '0',
  `PublicInventoryPercent` int(3) DEFAULT NULL,
  `PublicImpressionAvailable` int(11) DEFAULT '0',
  `PrivateImpressionAvailable` int(11) DEFAULT '0',
  `IntegrationId` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Impression` int(11) DEFAULT NULL,
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `PublisherId` (`PublisherId`),
  KEY `ParentId` (`ParentId`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`),
  KEY `VendorId` (`VendorId`),
  KEY `DefaultRateCardId` (`DefaultRateCardId`),
  KEY `SpecialRateCardId` (`SpecialRateCardId`),
  KEY `PlacementType` (`PlacementType`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=636 ;

--
-- Dumping data for table `adunits`
--

INSERT INTO `adunits` (`Id`, `Name`, `Sizes`, `Style`, `ParentId`, `PublisherId`, `VendorId`, `CPM`, `Currency`, `ImageLink`, `KeyWords`, `Positions`, `PlacementType`, `InventoryType`, `DefaultRateCardId`, `SpecialRateCardId`, `PublicInventoryPercent`, `PublicImpressionAvailable`, `PrivateImpressionAvailable`, `IntegrationId`, `Impression`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(111, 'LeaderBoard', '720X90', 'Leaderboard', NULL, 345, NULL, 2.00, 'USD', 'xyz', 'auto car van', 'top', NULL, 'display', 1, 1, 40, 0, 0, '', NULL, 1, '2013-11-06 00:00:00', 1, '2014-02-02 13:52:04'),
(222, 'SkyCrapper', '300X600', 'Rectangle Banner', 111, 345, NULL, 3.00, 'USD', 'abc', 'auto car van', 'sidebar', NULL, 'display', 1, 1, 40, 0, 0, '', NULL, 1, '2013-11-06 00:00:00', 1, '2014-02-02 13:52:04'),
(333, 'Rectangle', '300X250', 'Sky crapper', 222, 345, NULL, 4.00, 'USD', '1234', 'auto car van', 'center', NULL, 'display', 1, 1, 40, 0, 0, '', NULL, 1, '2013-11-06 00:00:00', 1, '2014-02-02 13:52:04'),
(444, 'Rectangle', '300X250', 'Leaderboard', 333, 456, NULL, 3.00, 'USD', 'abcd', 'Health Fitness', 'center', NULL, 'display', 1, 1, 30, 0, 0, '', NULL, 1, '2013-11-06 00:00:00', 1, '2014-02-02 13:52:04'),
(555, 'homepage', '300X250', 'Sky crapper', 222, 456, NULL, 4.00, 'USD', 'etf', 'Health Fitness', 'center', NULL, 'display', 1, 1, 30, 0, 0, '', NULL, 1, '2013-11-06 00:00:00', 1, '2014-02-02 13:52:04'),
(631, 'ca-pub-5611263585770920', NULL, NULL, 632, NULL, NULL, NULL, NULL, NULL, NULL, 'TOP', NULL, NULL, 1, 1, NULL, 0, 0, '56383576', NULL, NULL, '2013-11-06 00:00:00', NULL, '2014-02-02 13:52:04'),
(632, 'ca-pub-5611263585770920: ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'TOP', NULL, NULL, 1, 1, NULL, 0, 0, '56383456', NULL, NULL, '2013-11-06 00:00:00', NULL, '2014-02-02 13:52:04'),
(633, 'new_300x250', '300x250', NULL, 631, NULL, NULL, NULL, NULL, NULL, NULL, 'BLANK', NULL, NULL, 1, 1, NULL, 0, 0, '72074896', NULL, NULL, '2013-11-06 00:00:00', NULL, '2014-02-02 13:52:04'),
(634, 'Test_AU1', '300x250', NULL, 631, NULL, NULL, NULL, NULL, NULL, NULL, 'BLANK', NULL, NULL, 1, 1, NULL, 0, 0, '56383696', NULL, NULL, '2013-11-06 00:00:00', NULL, '2014-02-02 13:52:04'),
(635, 'tes_au2', '728x90', NULL, 631, NULL, NULL, NULL, NULL, NULL, NULL, 'TOP', NULL, NULL, 1, 1, NULL, 0, 0, '56383936', NULL, NULL, '2013-11-06 00:00:00', NULL, '2014-02-02 13:52:04');

-- --------------------------------------------------------

--
-- Table structure for table `adunitsplacements`
--

CREATE TABLE IF NOT EXISTS `adunitsplacements` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PlacementId` int(11) DEFAULT NULL,
  `AdUnitId` int(11) DEFAULT NULL,
  `IntegrationId` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `DefaultRateCardId` int(11) DEFAULT NULL,
  `SpecialRateCardId` int(11) DEFAULT NULL,
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `PlacementId` (`PlacementId`),
  KEY `AdUnitId` (`AdUnitId`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`),
  KEY `DefaultRateCardId` (`DefaultRateCardId`),
  KEY `SpecialRateCardId` (`SpecialRateCardId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=556 ;

--
-- Dumping data for table `adunitsplacements`
--

INSERT INTO `adunitsplacements` (`Id`, `PlacementId`, `AdUnitId`, `IntegrationId`, `DefaultRateCardId`, `SpecialRateCardId`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(111, 111, 111, '', NULL, NULL, 1, '2013-11-06 00:00:00', 1, '2013-11-06 17:45:29'),
(222, 111, 222, '', NULL, NULL, 1, '2013-11-06 00:00:00', 1, '2013-11-06 17:45:49'),
(333, 111, 333, '', NULL, NULL, 1, '2013-11-06 00:00:00', 1, '2013-11-06 17:46:14'),
(444, 222, 111, '', NULL, NULL, 1, '2013-11-06 00:00:00', 1, '2013-11-06 17:46:41'),
(555, 222, 222, '', NULL, NULL, 1, '2013-11-06 00:00:00', 1, '2013-11-06 17:47:03');

-- --------------------------------------------------------

--
-- Table structure for table `advertiser`
--

CREATE TABLE IF NOT EXISTS `advertiser` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Address2` varchar(100) DEFAULT NULL,
  `City` varchar(90) DEFAULT NULL,
  `State` varchar(30) DEFAULT NULL,
  `ZipCode` varchar(30) DEFAULT NULL,
  `AccountId` int(11) DEFAULT NULL,
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`),
  KEY `AccountId` (`AccountId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `advertiser`
--

INSERT INTO `advertiser` (`Id`, `Name`, `Address`, `Address2`, `City`, `State`, `ZipCode`, `AccountId`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(1, 'Coca Cola', '123 silva pl', '', 'santa clara', 'CA', '94045', 1, 1, '2013-11-22 00:00:00', 1, '2013-11-22 18:49:41');

-- --------------------------------------------------------

--
-- Table structure for table `creative`
--

CREATE TABLE IF NOT EXISTS `creative` (
  `Id` int(15) NOT NULL AUTO_INCREMENT,
  `CreativeListId` int(11) DEFAULT NULL,
  `PlanLineId` int(15) DEFAULT NULL,
  `IntegrationId` varchar(50) DEFAULT NULL,
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `PlanLineId` (`PlanLineId`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`),
  KEY `CreativeListId` (`CreativeListId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `creative`
--

INSERT INTO `creative` (`Id`, `CreativeListId`, `PlanLineId`, `IntegrationId`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(1, 1, 112, NULL, NULL, NULL, NULL, '2014-02-01 01:46:17');

-- --------------------------------------------------------

--
-- Table structure for table `creativelist`
--

CREATE TABLE IF NOT EXISTS `creativelist` (
  `Id` int(15) NOT NULL AUTO_INCREMENT,
  `PlanId` int(15) DEFAULT NULL,
  `Name` varchar(180) DEFAULT NULL,
  `Link` varchar(6000) DEFAULT NULL,
  `Sizes` varchar(300) DEFAULT NULL,
  `Tag` varchar(6000) DEFAULT NULL,
  `IntegrationId` varchar(50) DEFAULT NULL,
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`),
  KEY `PlanId` (`PlanId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `creativelist`
--

INSERT INTO `creativelist` (`Id`, `PlanId`, `Name`, `Link`, `Sizes`, `Tag`, `IntegrationId`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(1, 111, 'LRL Leader1', 'link1', 'size1', NULL, NULL, 1, '2014-02-04 01:43:33', 1, '2014-02-01 01:43:41'),
(2, 111, 'LRL Leader2', 'link2', 'size2', NULL, NULL, 1, '2014-02-04 01:43:33', 1, '2014-02-01 01:44:15');

-- --------------------------------------------------------

--
-- Table structure for table `impressionsettings`
--

CREATE TABLE IF NOT EXISTS `impressionsettings` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Month` int(2) DEFAULT NULL,
  `Year` int(4) DEFAULT NULL,
  `MonthlyImpression` int(11) DEFAULT '0',
  `PublicInventoryPercent` int(11) DEFAULT '0',
  `PrivateInventoryPercent` int(11) DEFAULT '0',
  `InventorySettingsId` int(11) DEFAULT NULL,
  `Description` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`),
  KEY `InventorySettingsId` (`InventorySettingsId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `impressionsettings`
--

INSERT INTO `impressionsettings` (`Id`, `Month`, `Year`, `MonthlyImpression`, `PublicInventoryPercent`, `PrivateInventoryPercent`, `InventorySettingsId`, `Description`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(1, 5, 2013, 100000, 40, 50, 1, 'desc', 1, '2014-01-31 11:25:12', 1, '2014-02-03 17:59:48'),
(2, 6, 2014, 200000, 50, 40, 1, NULL, 1, '2014-01-02 11:25:50', 1, '2014-02-03 17:59:48');

-- --------------------------------------------------------

--
-- Table structure for table `inventorysettings`
--

CREATE TABLE IF NOT EXISTS `inventorysettings` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Vendor` int(11) DEFAULT NULL,
  `UserName` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `PassWord` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  `Status` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `TotalImpression` int(11) DEFAULT NULL,
  `PublicInventroyPercent` int(11) DEFAULT NULL,
  `PrivateInventoryPercent` int(11) DEFAULT NULL,
  `PublisherId` int(11) DEFAULT '0',
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `Vendor` (`Vendor`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`),
  KEY `PublisherId` (`PublisherId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `inventorysettings`
--

INSERT INTO `inventorysettings` (`Id`, `Vendor`, `UserName`, `PassWord`, `Status`, `TotalImpression`, `PublicInventroyPercent`, `PrivateInventoryPercent`, `PublisherId`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(1, 1, 'logic', '5dhuZ6yraKONVhzzk0A04FOWCeoma1NNwHuz/Cpuo+t89xZlLoUd+HRpIFmgKuYa', 'sync', 15000, 40, 50, 345, 1, '2014-01-23 17:28:02', 1, '2014-02-03 17:36:46');

-- --------------------------------------------------------

--
-- Table structure for table `inventorytype`
--

CREATE TABLE IF NOT EXISTS `inventorytype` (
  `Id` int(15) NOT NULL AUTO_INCREMENT,
  `PublisherId` int(15) DEFAULT NULL,
  `InventoryType` varchar(150) DEFAULT NULL,
  `UserId` varchar(300) DEFAULT NULL,
  `Password` varchar(300) DEFAULT NULL,
  `Token` varchar(300) DEFAULT NULL,
  `Status` varchar(150) DEFAULT NULL,
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `PublisherId` (`PublisherId`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=146 ;

--
-- Dumping data for table `inventorytype`
--

INSERT INTO `inventorytype` (`Id`, `PublisherId`, `InventoryType`, `UserId`, `Password`, `Token`, `Status`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(141, 345, 'Banner', 'mk1', 'pwd1', '23234', 'Active', 1, '2013-11-06 17:16:47', 1, '2013-11-06 17:18:07'),
(142, 345, 'Video', 'mk2', 'pwd2', '23236', 'Active', 1, '2013-11-06 00:00:00', 1, '2013-11-06 17:20:29'),
(143, 456, 'Mobile Banner', 'mk3', 'pwd3', '23235', 'Active', 1, '2013-11-06 00:00:00', 1, '2013-11-06 17:21:22'),
(144, 567, 'Banner', 'mk4', 'pwd4', '23237', 'Active', 1, '2013-11-06 00:00:00', 1, '2013-11-06 17:22:00'),
(145, 567, 'Mobile', 'mk5', 'pwd5', '23238', 'Active', 1, '2013-11-06 00:00:00', 1, '2013-11-06 17:22:38');

-- --------------------------------------------------------

--
-- Table structure for table `invtargeting`
--

CREATE TABLE IF NOT EXISTS `invtargeting` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PublisherId` int(11) DEFAULT NULL,
  `AdUnitId` int(11) DEFAULT NULL,
  `PlacementId` int(11) DEFAULT NULL,
  `ParentAdUnitId` int(11) DEFAULT NULL,
  `CPM` decimal(15,2) DEFAULT '0.00',
  `Currency` varchar(30) DEFAULT NULL,
  `ImpressionBooked` int(11) DEFAULT '0',
  `PrivateFlag` enum('Y','N') DEFAULT 'N',
  `MediaCost` decimal(15,2) DEFAULT '0.00',
  `DiscountPercentage` decimal(5,2) DEFAULT '0.00',
  `PlanLineId` int(11) DEFAULT NULL,
  `Status` enum('APPROVED','PENDING','IN PROGRESS') DEFAULT 'PENDING',
  `IntegrationId` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `PublisherId` (`PublisherId`),
  KEY `AdUnitId` (`AdUnitId`),
  KEY `PlacementId` (`PlacementId`),
  KEY `ParentAdUnitId` (`ParentAdUnitId`),
  KEY `PlanLineId` (`PlanLineId`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=588 ;

--
-- Dumping data for table `invtargeting`
--

INSERT INTO `invtargeting` (`Id`, `PublisherId`, `AdUnitId`, `PlacementId`, `ParentAdUnitId`, `CPM`, `Currency`, `ImpressionBooked`, `PrivateFlag`, `MediaCost`, `DiscountPercentage`, `PlanLineId`, `Status`, `IntegrationId`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(111, 345, 111, 111, NULL, 2.00, 'USD', 10000, 'Y', 20.00, 0.00, 112, 'PENDING', '', 1, '2013-11-06 00:00:00', 1, '2014-02-02 13:14:35'),
(222, 345, 222, 111, 111, 3.00, 'USD', 20000, 'Y', 60.00, 0.00, 113, 'APPROVED', '', 1, '2013-11-06 00:00:00', 1, '2014-02-02 13:16:00'),
(333, 345, 333, 222, 222, 3.60, 'USD', 50000, 'Y', 180.00, 10.00, 113, 'APPROVED', '', 1, '2013-11-06 00:00:00', 1, '2014-02-02 13:16:12'),
(444, 345, 222, 222, 222, 2.80, 'USD', 10000, 'Y', 28.00, 10.00, 113, 'APPROVED', '', 1, '2013-11-06 00:00:00', 1, '2014-02-02 13:16:12'),
(555, 345, 444, 222, 222, 2.80, 'USD', 10000, 'Y', 28.00, 10.00, 113, 'APPROVED', '', 1, '2013-11-06 00:00:00', 1, '2014-02-02 13:16:12'),
(556, 345, 111, 111, 111, 2.00, NULL, 10000, 'Y', NULL, NULL, 214, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(557, 345, 222, 111, 222, 3.00, NULL, 30000, 'Y', NULL, NULL, 214, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(558, 345, 111, NULL, 111, 2.00, NULL, 20000, 'Y', NULL, NULL, 215, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(559, 345, 222, NULL, 222, 3.00, NULL, 60000, 'Y', NULL, NULL, 215, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(560, 345, 111, NULL, 111, 2.00, NULL, 40000, 'Y', NULL, NULL, 216, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(561, 345, 222, NULL, 222, 3.00, NULL, 120000, 'N', NULL, NULL, 216, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(562, 345, 111, 111, 111, 2.00, NULL, 80000, 'N', NULL, NULL, 217, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(563, 345, 222, 111, 222, 3.00, NULL, 240000, 'N', NULL, NULL, 217, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(564, 345, 111, 111, 111, 2.00, NULL, 160000, 'N', NULL, NULL, 218, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(565, 345, 222, 111, 222, 3.00, NULL, 480000, 'N', NULL, NULL, 218, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(566, 456, 444, NULL, 444, 3.00, NULL, 10000, 'N', NULL, NULL, 219, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(567, 456, 444, NULL, 444, 3.00, NULL, 20000, 'N', NULL, NULL, 220, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(568, 456, 444, NULL, 444, 3.00, NULL, 40000, 'N', NULL, NULL, 221, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(569, 456, 444, NULL, 444, 3.00, NULL, 80000, 'N', NULL, NULL, 222, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(570, 456, 111, 111, 111, 2.00, NULL, 120000, 'N', NULL, NULL, 223, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(571, 456, 222, 111, 222, 3.00, NULL, 2500000, 'N', NULL, NULL, 223, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(572, 456, 111, 111, 111, 2.00, NULL, 120000, 'N', NULL, NULL, 223, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(573, 456, 222, 111, 222, 3.00, NULL, 2500000, 'N', NULL, NULL, 223, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(574, 456, 111, NULL, 111, 2.00, NULL, 120000, 'N', NULL, NULL, 223, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(575, 456, 222, NULL, 222, 3.00, NULL, 2500000, 'N', NULL, NULL, 223, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(576, 456, 111, NULL, 111, 2.00, NULL, 120000, 'N', NULL, NULL, 223, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(577, 456, 222, NULL, 222, 3.00, NULL, 2500000, 'N', NULL, NULL, 223, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(578, 456, 111, NULL, 111, 2.00, NULL, 120000, 'N', NULL, NULL, 223, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(579, 456, 222, NULL, 222, 3.00, NULL, 2500000, 'N', NULL, NULL, 223, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(580, 456, 111, NULL, 111, 2.00, NULL, 120000, 'N', NULL, NULL, 224, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(581, 456, 222, NULL, 222, 3.00, NULL, 2500000, 'N', NULL, NULL, 224, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(582, 456, 111, 222, 111, 2.00, NULL, 120000, 'N', NULL, NULL, 224, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(583, 456, 222, 222, 222, 3.00, NULL, 2500000, 'N', NULL, NULL, 224, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(584, 456, 111, 222, 111, 2.00, NULL, 0, 'N', NULL, NULL, 225, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(585, 456, 222, 222, 222, 3.00, NULL, 0, 'N', NULL, NULL, 225, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(586, 456, 111, 222, 111, 2.00, NULL, 0, 'N', NULL, NULL, 225, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12'),
(587, 456, 222, 222, 222, 3.00, NULL, 0, 'N', NULL, NULL, 225, 'APPROVED', NULL, NULL, NULL, NULL, '2014-02-02 13:16:12');

-- --------------------------------------------------------

--
-- Table structure for table `listofvalues`
--

CREATE TABLE IF NOT EXISTS `listofvalues` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Value` varchar(50) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `ParentId` int(15) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `ParentId` (`ParentId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

--
-- Dumping data for table `listofvalues`
--

INSERT INTO `listofvalues` (`Id`, `Name`, `Value`, `Description`, `ParentId`) VALUES
(3, 'Gender', 'Male', '', NULL),
(4, 'Gender', 'Female', '', NULL),
(5, 'Age', '15-20', '', NULL),
(6, 'Age', '20-24', '', NULL),
(7, 'Age', '25-30', '', NULL),
(8, 'Age', '31-40', '', NULL),
(9, 'PlacementType', 'Digital banners', 'digital banner ads', NULL),
(10, 'PlacementType', 'Digital video', 'digital video instream ads', NULL),
(11, 'PlacementType', 'Mobile Banner', 'mobile banner ads', NULL),
(12, 'PlacementType', 'Mobile Video', 'mobile video ads', NULL),
(13, 'PlacementType', 'Social', 'facebook social ads', NULL),
(14, 'CategoryList', 'Arts & Entertainment', 'category related to arts and entertainment', NULL),
(15, 'CategoryList', 'Automative', 'car rentals and car resellers', NULL),
(16, 'CategoryList', 'Education', 'Universities and education insitutes', NULL),
(17, 'CategoryList', 'Health Fitness', 'All health care related products', NULL),
(18, 'CategoryList', 'Food & drink', 'Energy drink and foods', NULL),
(19, 'CategoryList', 'Travel', 'Travel networks', NULL),
(20, 'Country', 'USA', '', NULL),
(21, 'Country', 'India', '', NULL),
(22, 'State', 'California', '', 20),
(23, 'State', 'New York', '', 20),
(24, 'City', 'Santa Clara', '', 22),
(25, 'City', 'Sunnyvale', '', 22);

-- --------------------------------------------------------

--
-- Table structure for table `mediaplan`
--

CREATE TABLE IF NOT EXISTS `mediaplan` (
  `Id` int(15) NOT NULL AUTO_INCREMENT,
  `AccountId` int(15) DEFAULT NULL,
  `Name` varchar(300) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `TotalImpression` int(11) DEFAULT '0',
  `PublisherList` varchar(6000) DEFAULT NULL,
  `IntegrationId` varchar(50) DEFAULT NULL,
  `AdvertiserId` int(11) DEFAULT NULL,
  `Owner` varchar(50) DEFAULT NULL,
  `TotalCost` decimal(22,7) DEFAULT NULL,
  `TermsandCondition` varchar(3000) DEFAULT NULL,
  `Status` enum('APPROVED','PENDING','IN PROGRESS') DEFAULT 'PENDING',
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`),
  KEY `AccountId` (`AccountId`),
  KEY `AdvertiserId` (`AdvertiserId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=574 ;

--
-- Dumping data for table `mediaplan`
--

INSERT INTO `mediaplan` (`Id`, `AccountId`, `Name`, `StartDate`, `EndDate`, `TotalImpression`, `PublisherList`, `IntegrationId`, `AdvertiserId`, `Owner`, `TotalCost`, `TermsandCondition`, `Status`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(111, 1, 'Flowers campaign', '2013-12-20', '2013-12-25', 200000, 'yahoo.com,yatra.com', '225689416', 1, '', 0.0000000, '', 'APPROVED', 1, '2013-10-21 12:10:10', 1, '2013-12-16 18:08:14'),
(222, 1, 'Cosmetics', '2013-12-01', '2013-12-15', 10000, 'lrl.com,yahoo.com,yatra.com', '225689416', 1, '', 0.0000000, '', 'APPROVED', 1, '2013-10-21 12:10:10', 1, '2013-12-16 18:08:14'),
(333, 1, 'new car model', '2013-03-12', '2013-10-12', 5000000, 'yatra.com', '', 1, '', 0.0000000, '', 'PENDING', 1, '2013-10-21 12:10:10', 1, '2013-12-16 18:08:14'),
(444, 1, 'shoes', '2013-11-15', '2013-12-26', 100000, 'newyorktimes.com', '', 1, '', 0.0000000, '', 'PENDING', 1, '2013-10-21 12:10:10', 1, '2013-12-16 18:08:14'),
(555, 1, 'Credit Cards', '2013-01-11', '2013-11-15', 250000, 'hindu.com', '', 1, '', 0.0000000, '', 'APPROVED', 1, '2013-10-21 12:10:10', 1, '2013-12-16 18:08:14'),
(556, 1, 'mytest1', '2013-01-16', '2013-01-25', NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, '2013-10-21 12:10:10', NULL, '2013-12-16 18:08:14'),
(557, 1, 'mytest1', '2013-01-16', '2013-01-25', NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, '2013-10-21 12:10:10', NULL, '2014-01-24 11:53:35'),
(558, 1, 'LRLADDS', '2013-01-22', '2013-01-28', NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, '2013-10-21 12:10:10', NULL, '2014-01-24 11:53:35'),
(559, 1, 'test1', '2014-01-01', '2014-01-10', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(560, 1, 'test1', '2014-01-02', '2014-01-02', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(561, 1, 'test1', '0007-07-07', '0007-07-07', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(562, 1, 'test1', '0007-07-07', '0007-07-07', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(563, 1, 'test1', '0007-07-07', '0007-07-07', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(564, 1, 'test1', '0007-07-07', '0007-07-07', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(565, 1, 'test1', '2014-01-01', '2014-01-10', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(566, 1, 'test1', '2014-01-01', '2014-01-10', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(567, 1, 'tttt', '2014-01-01', '2014-01-10', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(568, 1, 'tttt', '2014-01-01', '2014-01-10', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(569, 1, 'tttt', '2014-01-01', '2014-01-10', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(570, 1, 'tttt', '2014-01-01', '2014-01-10', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(571, 1, 'tttt', '2014-01-01', '2014-01-10', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(572, 1, 'tttt', '2014-01-01', '2014-01-10', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(573, 1, 'tttt', '2014-04-01', '2014-08-10', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `mediaplanline`
--

CREATE TABLE IF NOT EXISTS `mediaplanline` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(300) DEFAULT NULL,
  `PublisherId` int(11) DEFAULT NULL,
  `CPM` decimal(15,2) DEFAULT NULL,
  `Currency` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `InventoryProposed` int(11) DEFAULT NULL,
  `Status` enum('APPROVED','PENDING','IN PROGRESS') CHARACTER SET utf8 DEFAULT 'PENDING',
  `InventoryApproved` int(11) DEFAULT NULL,
  `PlanId` int(11) DEFAULT NULL,
  `StartDate` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `EndDate` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `IntegrationId` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `PublisherId` (`PublisherId`),
  KEY `PlanId` (`PlanId`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=227 ;

--
-- Dumping data for table `mediaplanline`
--

INSERT INTO `mediaplanline` (`Id`, `Name`, `PublisherId`, `CPM`, `Currency`, `InventoryProposed`, `Status`, `InventoryApproved`, `PlanId`, `StartDate`, `EndDate`, `IntegrationId`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(112, 'Wahoo Finance', 345, 2.00, 'USD', 100000, 'PENDING', 10, 111, '2013-12-21 00:00:00', '2013-12-25 00:00:00', '71534896', 1, '2013-11-06 00:00:00', 1, '2014-01-03 10:42:57'),
(113, 'My Line', 567, 3.00, 'USD', 100000, 'APPROVED', 100000, 111, '2013-12-25 12:12:12', '2013-12-25 12:12:12', '71534896', 1, '2013-11-06 00:00:00', 1, '2013-12-31 15:35:43'),
(211, 'Wahoo sports', 345, 3.00, 'USD', 2000, 'APPROVED', 2000, 222, '2013-12-01 12:12:12', '2013-12-05 12:12:12', '71534896', 1, '2013-11-06 00:00:00', 1, '2013-12-19 16:16:41'),
(212, '', 456, 2.00, 'USD', 5000, 'APPROVED', 5000, 222, '2013-12-05 12:12:12', '2013-12-10 12:12:12', '71534896', 1, '2013-11-06 00:00:00', 1, '2013-12-19 16:16:41'),
(213, '', 567, 4.00, 'USD', 5000, 'APPROVED', 3000, 222, '2013-12-01 12:12:12', '2013-12-15 12:12:12', '71534896', 1, '2013-11-06 00:00:00', 1, '2013-12-19 16:16:41'),
(214, 'LRL - 1', 345, 2.00, NULL, 10000, 'PENDING', 20000, 111, '2013-12-23 10:48:20', '2013-12-23 10:48:20', '71534896', NULL, NULL, NULL, '2013-12-31 15:32:01'),
(215, 'LRL - 2', 345, 2.00, NULL, 20000, 'PENDING', 5000, 111, '2013-12-24 10:50:08', '2013-12-24 10:50:08', '71534896', NULL, NULL, NULL, '2013-12-31 15:35:43'),
(216, '720X90Leaderboard', 345, 2.00, NULL, 40000, 'PENDING', 15000, 111, '2013-12-23 15:05:58', '2013-12-23 15:05:58', '71534896', NULL, NULL, NULL, '2013-12-30 15:28:51'),
(217, '720X90Leaderboard', 345, 2.00, NULL, 80000, 'PENDING', 10000, 111, '2013-12-24 15:06:05', '2013-12-24 15:06:05', '71534896', NULL, NULL, NULL, '2013-12-31 15:35:43'),
(218, '720X90Leaderboard', 345, 2.00, NULL, 160000, 'PENDING', 150000, 111, '2013-12-23 16:31:11', '2013-12-23 16:31:11', '71534896', NULL, NULL, NULL, '2013-12-30 15:28:51'),
(219, '300X250Leaderboard', 456, 3.00, NULL, 10000, 'PENDING', NULL, 111, '2014-01-07 17:17:58', '2014-01-07 17:17:58', '71534896', NULL, NULL, NULL, NULL),
(220, '300X250Leaderboard', 456, 3.00, NULL, 20000, 'PENDING', NULL, 111, '2014-01-07 17:19:49', '2014-01-07 17:19:49', '71534896', NULL, NULL, NULL, NULL),
(221, '300X250Leaderboard', 456, 3.00, NULL, 40000, 'PENDING', NULL, 111, '2014-01-07 17:19:57', '2014-01-07 17:19:57', '71534896', NULL, NULL, NULL, NULL),
(222, '300X250Leaderboard', 456, 3.00, NULL, 80000, 'PENDING', NULL, 111, '2014-01-07 17:20:00', '2014-01-07 17:20:00', '71534896', NULL, NULL, NULL, NULL),
(223, '720X90Leaderboard', 456, 2.00, NULL, 120000, 'PENDING', NULL, 555, '2014-01-07 19:05:14', '2014-01-07 19:05:14', NULL, NULL, NULL, NULL, NULL),
(224, '720X90Leaderboard', 456, 2.00, NULL, 120000, 'PENDING', NULL, 555, '2014-01-08 11:03:55', '2014-01-08 11:03:55', NULL, NULL, NULL, NULL, NULL),
(225, '720X90Leaderboard', 456, 2.00, NULL, 0, 'PENDING', NULL, 555, '2014-01-08 11:20:01', '2014-01-08 11:20:01', NULL, NULL, NULL, NULL, NULL),
(226, '720X90Leaderboard', 345, 2.00, NULL, 1160000, 'PENDING', NULL, 111, '2013-12-20 00:00:00', '2013-12-25 00:00:00', NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `paymentmethod`
--

CREATE TABLE IF NOT EXISTS `paymentmethod` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PaymentMethod` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  `PaymentDetails` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  `CreditName` varchar(150) CHARACTER SET utf8 DEFAULT NULL,
  `CreditNumber` varchar(150) CHARACTER SET utf8 DEFAULT NULL,
  `ExpireDate` datetime DEFAULT NULL,
  `AccountId` int(11) DEFAULT NULL,
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`),
  KEY `AccountId` (`AccountId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `paymentmethod`
--


-- --------------------------------------------------------

--
-- Table structure for table `placements`
--

CREATE TABLE IF NOT EXISTS `placements` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PublisherId` int(11) DEFAULT NULL,
  `Name` varchar(3000) CHARACTER SET utf8 DEFAULT NULL,
  `CPM` decimal(15,2) DEFAULT NULL,
  `IntegrationId` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Currency` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `DefaultRateCardId` int(11) DEFAULT '0',
  `SpecialRateCardId` int(11) DEFAULT '0',
  `Impression` int(11) NOT NULL DEFAULT '0',
  `PublicImpressionAvailable` int(11) DEFAULT NULL,
  `PrivateImpressionAvailable` int(11) DEFAULT NULL,
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `PublisherId` (`PublisherId`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`),
  KEY `DefaultRateCardId` (`DefaultRateCardId`),
  KEY `SpecialRateCardId` (`SpecialRateCardId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=445 ;

--
-- Dumping data for table `placements`
--

INSERT INTO `placements` (`Id`, `PublisherId`, `Name`, `CPM`, `IntegrationId`, `Currency`, `DefaultRateCardId`, `SpecialRateCardId`, `Impression`, `PublicImpressionAvailable`, `PrivateImpressionAvailable`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(111, 345, 'egmcartech', 3.00, '', 'USD', 1, 1, 0, 0, 0, 1, '2013-11-06 00:00:00', 1, '2014-02-02 13:50:51'),
(222, 345, 'egmcartech home', 4.00, '', 'USD', 1, 1, 0, 0, 0, 1, '2013-11-06 00:00:00', 1, '2014-02-02 13:51:36'),
(333, 456, 'health central', 4.00, '', 'USD', 1, 1, 0, 0, 0, 1, '2013-11-06 00:00:00', 1, '2014-02-02 13:51:47'),
(444, 456, 'health diet', 2.00, '', 'USD', 1, 1, 0, 0, 0, 1, '2013-11-06 00:00:00', 1, '2014-02-02 13:51:47');

-- --------------------------------------------------------

--
-- Table structure for table `publisher`
--

CREATE TABLE IF NOT EXISTS `publisher` (
  `Id` int(15) NOT NULL AUTO_INCREMENT,
  `Name` varchar(300) DEFAULT NULL,
  `Overview` varchar(6000) DEFAULT NULL,
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=787 ;

--
-- Dumping data for table `publisher`
--

INSERT INTO `publisher` (`Id`, `Name`, `Overview`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(345, 'egmcartech', 'huge auto care produts', 1, '2013-10-16 00:00:00', 1, '2013-11-06 15:51:02'),
(456, 'health.com', 'health and fitness benefit', 1, '2013-10-16 00:00:00', 1, '2013-11-06 15:51:28'),
(567, 'yatra.com', 'Yatra is purely focussed on travel booking and planning.', 1, '2013-10-16 00:00:00', 1, '2013-11-06 15:41:34'),
(786, 'AutoGuide Group', '', 1, '2013-10-16 00:00:00', 1, '2013-11-06 15:51:18');

-- --------------------------------------------------------

--
-- Table structure for table `publishercategory`
--

CREATE TABLE IF NOT EXISTS `publishercategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `publisherid` int(11) NOT NULL,
  `categoryid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `publisherid` (`publisherid`),
  KEY `categoryid` (`categoryid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `publishercategory`
--

INSERT INTO `publishercategory` (`id`, `publisherid`, `categoryid`) VALUES
(1, 345, 14),
(2, 345, 15),
(3, 345, 16),
(4, 456, 14),
(5, 567, 18),
(6, 567, 19);

-- --------------------------------------------------------

--
-- Table structure for table `publishercontact`
--

CREATE TABLE IF NOT EXISTS `publishercontact` (
  `Id` int(15) NOT NULL AUTO_INCREMENT,
  `PublisherId` int(15) DEFAULT NULL,
  `FirstName` varchar(300) DEFAULT NULL,
  `LastName` varchar(300) DEFAULT NULL,
  `EmailId` varchar(300) DEFAULT NULL,
  `ContactNo` varchar(300) DEFAULT NULL,
  `Role` varchar(300) DEFAULT NULL,
  `Image` varchar(3000) DEFAULT NULL,
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `PublisherId` (`PublisherId`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=766 ;

--
-- Dumping data for table `publishercontact`
--

INSERT INTO `publishercontact` (`Id`, `PublisherId`, `FirstName`, `LastName`, `EmailId`, `ContactNo`, `Role`, `Image`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(762, 567, 'alan', 'fuller', 'a@yatra.com', '982392832', 'Account Manager', 'Link4', 1, '2013-11-06 00:00:00', 1, '2013-11-06 16:24:44'),
(763, 567, 'thomas', 'siebel', 't@yatra.com', '4089892989', 'Media Director', 'Link3', 1, '2013-11-06 00:00:00', 1, '2013-11-06 16:23:24'),
(764, 456, 'steve', 'media agency', 's@health.com', '4089899976', 'Media Agency', 'Link2', 1, '2013-11-06 00:00:00', 1, '2013-11-06 16:21:42'),
(765, 345, 'mike', 'antonelle', 'm@autozone.com', '1234567890', 'Media Rep', 'Link1', 1, '2013-11-06 00:00:00', 1, '2013-11-06 16:20:18');

-- --------------------------------------------------------

--
-- Table structure for table `ratecard`
--

CREATE TABLE IF NOT EXISTS `ratecard` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `TimePeriodId` int(11) DEFAULT NULL,
  `Price` double(15,2) DEFAULT NULL,
  `Status` enum('Active','Inactive') CHARACTER SET utf8 DEFAULT 'Inactive',
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`),
  KEY `TimePeriodId` (`TimePeriodId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `ratecard`
--

INSERT INTO `ratecard` (`Id`, `Name`, `TimePeriodId`, `Price`, `Status`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(1, 'Test Rate Card', 1, 1000.00, 'Active', 1, '2014-01-08 00:00:00', 1, '2014-01-08 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `targeting`
--

CREATE TABLE IF NOT EXISTS `targeting` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(300) DEFAULT NULL,
  `Value` varchar(300) DEFAULT NULL,
  `MediaPlanId` int(11) DEFAULT NULL,
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `MediaPlanId` (`MediaPlanId`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=556 ;

--
-- Dumping data for table `targeting`
--

INSERT INTO `targeting` (`Id`, `Name`, `Value`, `MediaPlanId`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(111, '345', '111', 112, 1, '2013-11-06 00:00:00', 1, '2013-11-06 16:10:30'),
(222, 'Age', '15-20', 112, 1, '2013-11-06 00:00:00', 1, '2013-11-06 16:12:16'),
(333, 'Age', '35-40', 112, 1, '2013-11-06 00:00:00', 1, '2013-11-06 16:12:17'),
(444, 'State', 'CA', 112, 1, '2013-11-06 00:00:00', 1, '2013-11-06 16:12:17'),
(555, 'State', 'NY', 112, 1, '2013-11-06 00:00:00', 1, '2013-11-06 16:12:17');

-- --------------------------------------------------------

--
-- Table structure for table `timeperiod`
--

CREATE TABLE IF NOT EXISTS `timeperiod` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `StartDate` date DEFAULT NULL,
  `EndDate` date DEFAULT NULL,
  `Status` enum('Active','Inactive') CHARACTER SET utf8 DEFAULT NULL,
  `PublisherId` int(11) DEFAULT NULL,
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`),
  KEY `PublisherId` (`PublisherId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `timeperiod`
--

INSERT INTO `timeperiod` (`Id`, `Name`, `StartDate`, `EndDate`, `Status`, `PublisherId`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(1, 'Test', '2014-01-08', '2014-01-08', 'Active', 345, 1, '2014-01-08 00:00:00', 1, '2014-01-08 13:46:07'),
(2, 'name', '2010-01-10', '2011-01-11', 'Active', 345, NULL, NULL, NULL, NULL),
(3, 'singer1', '2014-01-10', '2014-01-12', 'Inactive', 345, NULL, NULL, NULL, NULL),
(4, 'singer1', '2014-01-10', '2014-01-12', 'Inactive', 345, NULL, NULL, NULL, NULL),
(5, 'n2', '2014-01-10', '2014-01-10', 'Inactive', 345, NULL, NULL, NULL, NULL),
(6, 'n2', '2014-01-10', '2014-01-10', 'Inactive', 345, NULL, NULL, NULL, NULL),
(7, 'singer1', '2014-01-10', '2014-01-12', 'Inactive', 345, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `userprofile`
--

CREATE TABLE IF NOT EXISTS `userprofile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `AccountId` int(11) NOT NULL,
  `FirstName` varchar(300) DEFAULT NULL,
  `LastName` varchar(300) DEFAULT NULL,
  `MiddleName` varchar(300) DEFAULT NULL,
  `EmailId` varchar(600) DEFAULT NULL,
  `TimeZone` varchar(300) DEFAULT NULL,
  `ContactNo` varchar(300) DEFAULT NULL,
  `Type` enum('Agency','Publisher','Advertisement') DEFAULT NULL,
  `Status` enum('Active','Inactive') DEFAULT NULL,
  `UserName` varchar(300) DEFAULT NULL,
  `PassWord` varchar(600) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `AccountId` (`AccountId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `userprofile`
--

INSERT INTO `userprofile` (`id`, `AccountId`, `FirstName`, `LastName`, `MiddleName`, `EmailId`, `TimeZone`, `ContactNo`, `Type`, `Status`, `UserName`, `PassWord`) VALUES
(1, 1, 'Sriram', 'Subramaniyan', '', 'subamsriram@gmail.com', 'IST', '9842065057', 'Agency', 'Active', 'Sriram', '123456'),
(2, 1, 'Sharan', 'Selvaraj', '', 'lrlsharan@gmail.com', 'IST', '9994917318', 'Publisher', 'Active', 'sharan', '987654321'),
(3, 1, 'Jayanthi', 'Packiyasami', '', 'p.jayam.thee@gmail.com', 'IST', '8870757933', 'Publisher', 'Active', 'jayanthi', '147258'),
(4, 5, 'sairam', 'sundar', '', 'sairamonnet@gmail.com', 'IST', '98745633210', 'Agency', 'Active', 'sairam', 'MGg0/BvLm705fezH66LH5bSkKGtuszgk4FAqfhnFpWToIcqgQ8EK1I+X6XtZa+tF'),
(5, 6, 'sairam', 'sundar', '', 'sairamonnet@gmail.com', 'IST', '98745633210', 'Agency', 'Active', 'sairam', 'XIxf9D+GSvxVTS4gzCB7otFHf0Lq9UtzI+/nLmb+b76IqiMOMfeVAHoEcDsvjJLm'),
(6, 8, 'sairam11', 'sundar11', '', 'mrtkumaran@gmail.com', 'IST', '98745633210', 'Agency', 'Active', 'sairam11', 'YRWDxE09RYIMX8E3jPOoH71SLIGcpix3blZVx6rO3uJmZXa/1v1rVw1/Icl55ebu'),
(7, 7, 'sairam', 'sundar', '', 'sairamonnet@gmail.com', 'IST', '98745633210', 'Agency', 'Active', 'sairam', 'wynHcfzWsH9pNLaO76W7agAlc/Avz5eDW/JwD/AqYnXQhjnAPIR6xBtRrIY8VPVC'),
(8, 16, 'Josh', 'Davis', '', 'j.davis@expresslt.net', 'PST', '(503)421-7800', 'Agency', 'Active', 'j.davis', 'fZHS5W0L4a3M0J+SRQJWn5ZEakyIn0VC5Ojm2WxQGBjQBsugn0z5Mc/c0pS1mZUR'),
(9, 16, 'Josh', 'Davis', '', 'j.davis@expresslt.net', 'PST', '(503)421-7800', 'Agency', 'Active', 'j.davis', 'jv9TM/orHkJdr2K51p/cfM/UnQLdoEGplwagA6uMQSUrKRX/bDNVxsVEd4OMh7fA'),
(10, 16, 'Josh', 'Davis', '', 'j.davis@expresslt.net', 'PST', '5034217800', 'Agency', 'Active', 'j.davis', 'xjBGINdJYGXdzkdLPb/9Cc88+5TwgRROtu850P0af3x5XFD4HBzWelQO2h2pnQyR'),
(11, 16, 'sairam', 'sundar', '', 'sairamonnet@gmail.com', 'IST', '98745633210', 'Agency', 'Active', 'sairam', 'J0GcGNw5slH/oV6XdaLoZLxqes8hRo82nP1Da8nRbcfgYhVliVbMuxK1MzXLcUCm'),
(12, 18, 'sairam', 'sundar', '', 'sairamonnet@gmail.com', 'IST', '98745633210', 'Agency', 'Active', 'sairam', 'Q6UHnREcp/dnvRcygKWHGLuFLDT9vvrpFNtIr7CZBRTz16lThpF3jf0UZMiJKwHg'),
(13, 19, 'sairam', 'sundar', '', 'subamsriram@gmail.com', 'IST', '98745633210', NULL, 'Active', 'guru', '5NXy8pXv0TIyus1kU+xky85WsqVRi10+iyMOAFs4VnE0oBS8FtFtHgelsijngSH9');

-- --------------------------------------------------------

--
-- Table structure for table `vendors`
--

CREATE TABLE IF NOT EXISTS `vendors` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `Logo` blob,
  `Link` varchar(500) NOT NULL,
  `CreatedBy` int(11) NOT NULL,
  `Created` datetime NOT NULL,
  `UpdatedBy` int(11) NOT NULL,
  `Updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `vendors`
--

INSERT INTO `vendors` (`Id`, `Name`, `Logo`, `Link`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(1, 'LiveRail', NULL, 'http://www.LiveRail.com', 1, '2014-01-23 17:15:33', 1, '2014-01-23 17:15:33'),
(2, 'LiveRail', NULL, 'http://www.LiveRail.com', 1, '2014-01-23 17:25:43', 1, '2014-01-23 17:25:43');

-- --------------------------------------------------------

--
-- Table structure for table `version`
--

CREATE TABLE IF NOT EXISTS `version` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Version` varchar(16) NOT NULL,
  `Changes` varchar(512) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `version`
--

INSERT INTO `version` (`id`, `Version`, `Changes`) VALUES
(1, '1', ''),
(2, '2', '1.adunits, adunitsplacements,invtargeting tables are included\n\n2. Status Column included in the inv targeting table.'),
(3, '2.5', '1.Name column added in mediaplanid  2.Style column added in adunits 3.Description column changed to name in Placements. 4. IntegrationId column added in the following tables (mediaplan, mediaplanlineid,invtargetin, adunits, adunitsplacements, placements)'),
(4, '3', '1. Four columns in new in media table  2. Agencyname table changed to Agency.  3.Payment method table is new.  4. Advertise table is new.   5.  In  Agency,  Creative table integration id is included.');

-- --------------------------------------------------------

--
-- Table structure for table `volumediscount`
--

CREATE TABLE IF NOT EXISTS `volumediscount` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `TimePeriodId` int(11) DEFAULT NULL,
  `StartImpression` int(11) DEFAULT '0',
  `EndImpression` int(11) DEFAULT '0',
  `DiscountPercent` decimal(15,2) DEFAULT '0.00',
  `TotalDays` int(11) DEFAULT '0',
  `CreatedBy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `Updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `TimePeriodId` (`TimePeriodId`),
  KEY `CreatedBy` (`CreatedBy`),
  KEY `UpdatedBy` (`UpdatedBy`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `volumediscount`
--

INSERT INTO `volumediscount` (`Id`, `Name`, `TimePeriodId`, `StartImpression`, `EndImpression`, `DiscountPercent`, `TotalDays`, `CreatedBy`, `Created`, `UpdatedBy`, `Updated`) VALUES
(1, 'volume discount', 1, 10000, 20000, 12.00, NULL, 1, NULL, 1, '2014-01-23 20:02:05');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `adunitimpression`
--
ALTER TABLE `adunitimpression`
  ADD CONSTRAINT `adunitimpression_ibfk_1` FOREIGN KEY (`ImpressionSettingsId`) REFERENCES `impressionsettings` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `adunitimpression_ibfk_2` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `adunitimpression_ibfk_3` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `adunitimpression_ibfk_4` FOREIGN KEY (`AdUnitId`) REFERENCES `adunits` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `adunitimpression_ibfk_5` FOREIGN KEY (`PlacementId`) REFERENCES `placements` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `adunits`
--
ALTER TABLE `adunits`
  ADD CONSTRAINT `adunits_ibfk_1` FOREIGN KEY (`ParentId`) REFERENCES `adunits` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `adunits_ibfk_2` FOREIGN KEY (`PublisherId`) REFERENCES `publisher` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `adunits_ibfk_4` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `adunits_ibfk_5` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `adunits_ibfk_6` FOREIGN KEY (`VendorId`) REFERENCES `vendors` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `adunits_ibfk_7` FOREIGN KEY (`DefaultRateCardId`) REFERENCES `ratecard` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `adunits_ibfk_8` FOREIGN KEY (`SpecialRateCardId`) REFERENCES `ratecard` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `adunits_ibfk_9` FOREIGN KEY (`PlacementType`) REFERENCES `listofvalues` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `adunitsplacements`
--
ALTER TABLE `adunitsplacements`
  ADD CONSTRAINT `adunitsplacements_ibfk_1` FOREIGN KEY (`PlacementId`) REFERENCES `placements` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `adunitsplacements_ibfk_2` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `adunitsplacements_ibfk_4` FOREIGN KEY (`AdUnitId`) REFERENCES `adunits` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `adunitsplacements_ibfk_5` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `adunitsplacements_ibfk_6` FOREIGN KEY (`DefaultRateCardId`) REFERENCES `ratecard` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `adunitsplacements_ibfk_7` FOREIGN KEY (`SpecialRateCardId`) REFERENCES `ratecard` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `advertiser`
--
ALTER TABLE `advertiser`
  ADD CONSTRAINT `advertiser_ibfk_1` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `advertiser_ibfk_2` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `advertiser_ibfk_3` FOREIGN KEY (`AccountId`) REFERENCES `account` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `creative`
--
ALTER TABLE `creative`
  ADD CONSTRAINT `creative_ibfk_2` FOREIGN KEY (`PlanLineId`) REFERENCES `mediaplanline` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `creative_ibfk_3` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `creative_ibfk_4` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `creative_ibfk_5` FOREIGN KEY (`CreativeListId`) REFERENCES `creativelist` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `creativelist`
--
ALTER TABLE `creativelist`
  ADD CONSTRAINT `creativelist_ibfk_2` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `creativelist_ibfk_3` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `creativelist_ibfk_4` FOREIGN KEY (`PlanId`) REFERENCES `mediaplan` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `impressionsettings`
--
ALTER TABLE `impressionsettings`
  ADD CONSTRAINT `impressionsettings_ibfk_1` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `impressionsettings_ibfk_2` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `impressionsettings_ibfk_3` FOREIGN KEY (`InventorySettingsId`) REFERENCES `inventorysettings` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `inventorysettings`
--
ALTER TABLE `inventorysettings`
  ADD CONSTRAINT `inventorysettings_ibfk_1` FOREIGN KEY (`Vendor`) REFERENCES `vendors` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `inventorysettings_ibfk_2` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `inventorysettings_ibfk_3` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `inventorysettings_ibfk_4` FOREIGN KEY (`PublisherId`) REFERENCES `publisher` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `inventorytype`
--
ALTER TABLE `inventorytype`
  ADD CONSTRAINT `inventorytype_ibfk_1` FOREIGN KEY (`PublisherId`) REFERENCES `publisher` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `inventorytype_ibfk_2` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `inventorytype_ibfk_3` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `invtargeting`
--
ALTER TABLE `invtargeting`
  ADD CONSTRAINT `invtargeting_ibfk_2` FOREIGN KEY (`AdUnitId`) REFERENCES `adunits` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `invtargeting_ibfk_4` FOREIGN KEY (`ParentAdUnitId`) REFERENCES `adunits` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `invtargeting_ibfk_5` FOREIGN KEY (`PlanLineId`) REFERENCES `mediaplanline` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `invtargeting_ibfk_6` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `invtargeting_ibfk_7` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `invtargeting_ibfk_8` FOREIGN KEY (`PublisherId`) REFERENCES `publisher` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `invtargeting_ibfk_9` FOREIGN KEY (`PlacementId`) REFERENCES `placements` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `listofvalues`
--
ALTER TABLE `listofvalues`
  ADD CONSTRAINT `listofvalues_ibfk_1` FOREIGN KEY (`ParentId`) REFERENCES `listofvalues` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `mediaplan`
--
ALTER TABLE `mediaplan`
  ADD CONSTRAINT `mediaplan_ibfk_2` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mediaplan_ibfk_3` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mediaplan_ibfk_4` FOREIGN KEY (`AdvertiserID`) REFERENCES `advertiser` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mediaplan_ibfk_5` FOREIGN KEY (`AccountId`) REFERENCES `account` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mediaplan_ibfk_6` FOREIGN KEY (`AdvertiserId`) REFERENCES `advertiser` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `mediaplanline`
--
ALTER TABLE `mediaplanline`
  ADD CONSTRAINT `mediaplanline_ibfk_1` FOREIGN KEY (`PublisherId`) REFERENCES `publisher` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mediaplanline_ibfk_2` FOREIGN KEY (`PlanId`) REFERENCES `mediaplan` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mediaplanline_ibfk_3` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mediaplanline_ibfk_4` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `paymentmethod`
--
ALTER TABLE `paymentmethod`
  ADD CONSTRAINT `paymentmethod_ibfk_2` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `paymentmethod_ibfk_3` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `paymentmethod_ibfk_4` FOREIGN KEY (`AccountId`) REFERENCES `account` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `placements`
--
ALTER TABLE `placements`
  ADD CONSTRAINT `placements_ibfk_1` FOREIGN KEY (`PublisherId`) REFERENCES `publisher` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `placements_ibfk_2` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `placements_ibfk_3` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `placements_ibfk_4` FOREIGN KEY (`DefaultRateCardId`) REFERENCES `ratecard` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `placements_ibfk_5` FOREIGN KEY (`SpecialRateCardId`) REFERENCES `ratecard` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `publisher`
--
ALTER TABLE `publisher`
  ADD CONSTRAINT `publisher_ibfk_1` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publisher_ibfk_2` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `publishercategory`
--
ALTER TABLE `publishercategory`
  ADD CONSTRAINT `publishercategory_ibfk_1` FOREIGN KEY (`publisherid`) REFERENCES `publisher` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publishercategory_ibfk_2` FOREIGN KEY (`categoryid`) REFERENCES `listofvalues` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `publishercontact`
--
ALTER TABLE `publishercontact`
  ADD CONSTRAINT `publishercontact_ibfk_1` FOREIGN KEY (`PublisherId`) REFERENCES `publisher` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publishercontact_ibfk_2` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publishercontact_ibfk_3` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ratecard`
--
ALTER TABLE `ratecard`
  ADD CONSTRAINT `ratecard_ibfk_1` FOREIGN KEY (`TimePeriodId`) REFERENCES `timeperiod` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ratecard_ibfk_2` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ratecard_ibfk_3` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `targeting`
--
ALTER TABLE `targeting`
  ADD CONSTRAINT `targeting_ibfk_1` FOREIGN KEY (`MediaPlanId`) REFERENCES `mediaplanline` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `targeting_ibfk_2` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `targeting_ibfk_3` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `timeperiod`
--
ALTER TABLE `timeperiod`
  ADD CONSTRAINT `timeperiod_ibfk_1` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `timeperiod_ibfk_2` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `timeperiod_ibfk_3` FOREIGN KEY (`PublisherId`) REFERENCES `publisher` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `userprofile`
--
ALTER TABLE `userprofile`
  ADD CONSTRAINT `userprofile_ibfk_1` FOREIGN KEY (`AccountId`) REFERENCES `account` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `vendors`
--
ALTER TABLE `vendors`
  ADD CONSTRAINT `vendors_ibfk_1` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `vendors_ibfk_2` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `volumediscount`
--
ALTER TABLE `volumediscount`
  ADD CONSTRAINT `volumediscount_ibfk_1` FOREIGN KEY (`TimePeriodId`) REFERENCES `timeperiod` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `volumediscount_ibfk_2` FOREIGN KEY (`CreatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `volumediscount_ibfk_3` FOREIGN KEY (`UpdatedBy`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;