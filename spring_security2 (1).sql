-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th7 30, 2023 lúc 04:00 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `spring_security2`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(55) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `authority` varchar(55) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('james', 'ROLE_EMPLOYEE'),
('john', 'ROLE_ADMIN'),
('mary', 'ROLE_EMPLOYEE'),
('ngocsonadmin', 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `username` varchar(55) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` char(68) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('james', '{bcrypt}$2a$10$yzMZjoBPVrDRQGgQk2X9Z.oSdusMLVPIxuNT1nzX1i9vqCYZs/2ke', 1),
('john', '{bcrypt}$2a$10$tOpSzthDYkahg6dF0YcUxumaT.T9fQgmr8Qc6vwr.HxWY0tWA.i.S', 1),
('mary', '{bcrypt}$2a$10$yzMZjoBPVrDRQGgQk2X9Z.oSdusMLVPIxuNT1nzX1i9vqCYZs/2ke', 0),
('ngocsonadmin', '{bcrypt}$2a$10$tOpSzthDYkahg6dF0YcUxumaT.T9fQgmr8Qc6vwr.HxWY0tWA.i.S', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `authorities`
--
ALTER TABLE `authorities`
  ADD KEY `khong` (`username`,`authority`) USING BTREE;

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `khong` FOREIGN KEY (`username`) REFERENCES `users` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
