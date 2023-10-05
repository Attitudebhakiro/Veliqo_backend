-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 05, 2023 at 01:57 AM
-- Server version: 8.0.33-0ubuntu0.20.04.2
-- PHP Version: 7.4.3-4ubuntu2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `veliqo_challenge_ab`
--

-- --------------------------------------------------------

--
-- Table structure for table `application`
--

CREATE TABLE `application` (
  `id` bigint NOT NULL,
  `applicationStatus` varchar(255) DEFAULT NULL,
  `appliedDate` datetime(6) NOT NULL,
  `approvedDate` datetime(6) DEFAULT NULL,
  `coverageType` varchar(255) DEFAULT NULL,
  `dependents` int NOT NULL,
  `marriageStatus` varchar(255) DEFAULT NULL,
  `approved_by` int DEFAULT NULL,
  `applicant` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `application`
--

INSERT INTO `application` (`id`, `applicationStatus`, `appliedDate`, `approvedDate`, `coverageType`, `dependents`, `marriageStatus`, `approved_by`, `applicant`) VALUES
(1, 'Approved', '2023-10-04 22:28:46.069871', '2023-10-05 00:43:35.566635', 'Standard', 3, 'No', NULL, 4),
(7, 'Pending', '2023-10-05 01:41:42.902108', '2023-10-05 01:41:42.902614', 'Tailored', 5, 'No', NULL, 5),
(8, 'Pending', '2023-10-05 01:54:47.106652', '2023-10-05 01:54:47.106737', 'Premium', 2, 'Yes', NULL, 6);

-- --------------------------------------------------------

--
-- Table structure for table `Token`
--

CREATE TABLE `Token` (
  `id` int NOT NULL,
  `expired` bit(1) NOT NULL,
  `revoked` bit(1) NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  `tokenType` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Token`
--

INSERT INTO `Token` (`id`, `expired`, `revoked`, `token`, `tokenType`, `user_id`) VALUES
(1, b'0', b'0', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwYWxtZXRAdmVsaXFvLmNvbSIsImlhdCI6MTY5NjQ0OTk1OSwiZXhwIjoxNjk3MzEzOTU5fQ.YxhUJr6JD4Fj3CgC9gVr6y9sw1rZCmhx-U9iC3SS3fs', 'BEARER', 4),
(2, b'1', b'1', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhdHRpdHVkZUB2ZWxpcW8uY29tIiwiaWF0IjoxNjk2NDU2OTk4LCJleHAiOjE2OTczMjA5OTh9.wgRVy2hABVcC54iIk9GooPAVudl0wwAsDp2wZn6qwes', 'BEARER', 1),
(3, b'1', b'1', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYXBwaWVAdmVsaXFvLmNvbSIsImlhdCI6MTY5NjQ2MDg2NiwiZXhwIjoxNjk3MzI0ODY2fQ.e8FPyDwkdjt1DMhePjITIOgUxKghwoUhSVs7jw03LQs', 'BEARER', 5),
(52, b'0', b'0', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYXBwaWVAdmVsaXFvLmNvbSIsImlhdCI6MTY5NjQ2MjI5OCwiZXhwIjoxNjk3MzI2Mjk4fQ.MVPaXIJtM590NMx-LAKG4eomtBQn5_-ILx0GZUz_OEE', 'BEARER', 5),
(102, b'1', b'1', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhdHRpdHVkZUB2ZWxpcW8uY29tIiwiaWF0IjoxNjk2NDYzMjI2LCJleHAiOjE2OTczMjcyMjZ9.44VEfZscHt15tVkpjmPZgJ9fYxYfdWNnWBYlzcnorNE', 'BEARER', 1),
(103, b'0', b'0', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhdHRpdHVkZUB2ZWxpcW8uY29tIiwiaWF0IjoxNjk2NDYzNzQyLCJleHAiOjE2OTczMjc3NDJ9.B0cbKGpwzzw9V5oo3RholiF8tnI_NH-SAiZXEWLTI4Y', 'BEARER', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Token_SEQ`
--

CREATE TABLE `Token_SEQ` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Token_SEQ`
--

INSERT INTO `Token_SEQ` (`next_val`) VALUES
(201);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `idNumber` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `city`, `contact`, `dob`, `email`, `gender`, `idNumber`, `name`, `password`, `role`) VALUES
(1, 'Harare', '0777999888', '1980-07-07', 'attitude@veliqo.com', 'male', '83-78899T-83', 'Attitude Bhakiro', '$2a$10$T5GEYi52MLRbIDxN.hGmLuznMimYRqLMZkcKPs5DAgfE.sOzOBnxW', 'ADMIN'),
(4, 'Harare', '0775333222', '2000-05-05', 'palmet@veliqo.com', 'female', '45-9823T-45', 'Palmet Bhakiro', '$2a$10$eNUoZeTsKg3vTIUAmzZ.1OZ0np/SpXZvCnjkTlf9/iVSnWNAQdVty', 'APPLICANT'),
(5, 'Harare', '0779222444', '2000-03-06', 'happie@veliqo.com', 'female', '54-2008-T-54', 'Happiness Happie Chimz', '$2a$10$DXWvKTvuaqZ5HIMsZgy9KO4DDQPh7fIMJH2EY/O1bSo1uViApPQZC', 'APPLICANT'),
(6, 'Kwekwe', '0712333555', '1997-05-04', 'sullivan@veliqo.com', 'male', '45-2999-K-45', 'Sullivan  Muchada', '$2a$10$4s1nf43Y7kZvg7hmCS1rGOnge8OFN4NUn9I6AfTYDWRBCBFxemBP2', 'APPLICANT');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `application`
--
ALTER TABLE `application`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6523oa5ei8ga5j6rrl59b50gm` (`approved_by`),
  ADD KEY `FKgyu0gqvqe79docgncwfhb6btc` (`applicant`);

--
-- Indexes for table `Token`
--
ALTER TABLE `Token`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_3wi2t4g8oiplxjflw3o2lkv2y` (`token`),
  ADD KEY `FK4ebys2hayw8bqk047mjfvxxkj` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKgj2fy3dcix7ph7k8684gka40c` (`name`),
  ADD UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `application`
--
ALTER TABLE `application`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `application`
--
ALTER TABLE `application`
  ADD CONSTRAINT `FK6523oa5ei8ga5j6rrl59b50gm` FOREIGN KEY (`approved_by`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKgyu0gqvqe79docgncwfhb6btc` FOREIGN KEY (`applicant`) REFERENCES `user` (`id`);

--
-- Constraints for table `Token`
--
ALTER TABLE `Token`
  ADD CONSTRAINT `FK4ebys2hayw8bqk047mjfvxxkj` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
