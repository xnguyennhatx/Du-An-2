-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le: Mer 16 Novembre 2016 à 04:06
-- Version du serveur: 5.6.11
-- Version de PHP: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `dulich`
--
CREATE DATABASE IF NOT EXISTS `dulich` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `dulich`;

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `macom` int(11) NOT NULL AUTO_INCREMENT,
  `noidung` text COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `mand` int(11) NOT NULL,
  `ngaybl` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`macom`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=45 ;

--
-- Contenu de la table `comment`
--

INSERT INTO `comment` (`macom`, `noidung`, `username`, `mand`, `ngaybl`) VALUES
(1, 'hello', 'thu', 40, '29/10/2016'),
(2, 'hi!', 'thu', 40, '29/10/2016'),
(6, 'qua dep', 'thu', 39, '29/10/2016'),
(7, 'noi day rat la dep', 'thu', 40, '29/10/2016'),
(8, '4 nguoi', 'thu', 39, '29/10/2016'),
(10, 'toi tung di noi nay noi chung la rat la dep', 'thu', 40, '29/10/2016'),
(11, 'gdgf', 'thu', 39, '29/10/2016'),
(12, 'mua nuoc noi rat dep', 'thu', 24, '29/10/2016'),
(13, 'hello thu', 'diep', 24, '29/10/2016'),
(14, 'chao diep', 'thu', 24, '29/10/2016'),
(15, 'cococococo', 'diep', 39, '30/10/2016'),
(16, 'halowin', 'thu', 40, '30/10/2016'),
(17, 'khong co chi', 'thu', 40, '30/10/2016'),
(18, 'chao ban dat oc cho \n', 'diep', 40, '30/10/2016'),
(19, 'r011dd', 'thu', 40, '30/10/2016'),
(20, 'tha thu', 'thu', 39, '30/10/2016'),
(21, 'tha thu', 'thu', 40, '30/10/2016'),
(22, 'hello phan thu', 'thu', 42, '01/11/2016'),
(23, 'co gi dau', 'thu', 43, '01/11/2016'),
(24, 'xinchao', 'thu', 41, '01/11/2016'),
(25, 'noi day thay dep', 'thu', 43, '01/11/2016'),
(26, 'kaka', 'thu', 43, '01/11/2016'),
(27, '', 'thu', 43, '01/11/2016'),
(28, '', 'thu', 43, '01/11/2016'),
(29, '', 'thu', 43, '01/11/2016'),
(30, 'chao ban', 'thu', 42, '01/11/2016'),
(31, 'không co chi', 'thu', 42, '01/11/2016'),
(32, '', 'thu', 41, '01/11/2016'),
(33, '', 'thu', 41, '01/11/2016'),
(34, 'c', 'thu', 41, '01/11/2016'),
(36, 'hi', 'thu', 55, '14/11/2016'),
(37, '', 'thu', 55, '15/11/2016'),
(39, 'bbb', 'thu', 55, '15/11/2016'),
(40, 'hihihi', 'thu', 55, '15/11/2016'),
(41, '', 'thu', 57, '16/11/2016'),
(42, 'khong', 'thu', 57, '16/11/2016'),
(43, '', 'thu', 57, '16/11/2016'),
(44, '', 'thu', 57, '16/11/2016');

-- --------------------------------------------------------

--
-- Structure de la table `danhmuc`
--

CREATE TABLE IF NOT EXISTS `danhmuc` (
  `iddanhmuc` int(11) NOT NULL AUTO_INCREMENT,
  `tendanhmuc` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`iddanhmuc`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Contenu de la table `danhmuc`
--

INSERT INTO `danhmuc` (`iddanhmuc`, `tendanhmuc`) VALUES
(1, '000');

-- --------------------------------------------------------

--
-- Structure de la table `noidung`
--

CREATE TABLE IF NOT EXISTS `noidung` (
  `mand` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `mota` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `chitiet` text COLLATE utf8_unicode_ci NOT NULL,
  `hinhanh` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ngaydang` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `thich` int(11) NOT NULL,
  `xem` int(11) NOT NULL,
  `binhluan` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `iddanhmuc` int(11) NOT NULL,
  `Lat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Lang` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`mand`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=58 ;

--
-- Contenu de la table `noidung`
--

INSERT INTO `noidung` (`mand`, `username`, `mota`, `chitiet`, `hinhanh`, `ngaydang`, `thich`, `xem`, `binhluan`, `iddanhmuc`, `Lat`, `Lang`) VALUES
(21, 'diep', 'Hồ Tấn Tài phá bóng trượt nhưng may mắn cho U19 Việt Nam khi không có cầu thủ nào của U19 Bahrain băng vào dứt điểm.', 'Hồ Tấn Tài phá bóng trượt nhưng may mắn cho U19 Việt Nam khi không có cầu thủ nào của U19 Bahrain băng vào dứt điểm. Hồ Tấn Tài phá bóng trượt nhưng may mắn cho U19 Việt Nam khi không có cầu thủ nào của U19 Bahrain băng vào dứt điểm. Hồ Tấn Tài phá bóng trượt nhưng may mắn cho U19 Việt Nam khi không có cầu thủ nào của U19 Bahrain băng vào dứt điểm. Hồ Tấn Tài phá bóng trượt nhưng may mắn cho U19 Việt Nam khi không có cầu thủ nào của U19 Bahrain băng vào dứt điểm. Hồ Tấn Tài phá bóng trượt nhưng may mắn cho U19 Việt Nam khi không có cầu thủ nào của U19 Bahrain băng vào dứt điểm. Hồ Tấn Tài phá bóng trượt nhưng may mắn cho U19 Việt Nam khi không có cầu thủ nào của U19 Bahrain băng vào dứt điểm.', '201610237622746.jpeg', '23/10/2016', 44, 21, 'nen.jpeg', 1, '', ''),
(22, 'diep', 'Hội An trong lành và bình yên đến lạ trong tiết trời mát mẻ của những ngày đầu thu khiến du khách quyến luyến.', 'Hội An trong lành và bình yên đến lạ trong tiết trời mát mẻ của những ngày đầu thu khiến du khách quyến luyến.', '201610235315545.jpeg', '23/10/2016', 0, 30, 'nen.jpeg', 1, '', ''),
(23, 'man', 'Thị trấn Đồng Văn vào mùa đẹp nhất ở Hà Giang', 'Mùa này có lẽ là mùa đẹp nhất để lên với Hà Giang, thời tiết khô ráo, nắng vẫn còn rực rỡ và hoa tam giác mạch đang nở rộ.', '201610231104388.jpeg', '23/10/2016', 0, 38, 'nen1.jpeg', 1, '', ''),
(39, 'thu', 'nnn', 'nnnnn', '201610241951615.jpeg', '24/10/2016', 0, 73, 'ab.jpeg', 1, '', ''),
(40, 'thu', 'bcbc', 'bcb', '201610272997753.jpeg', '27/10/2016', 0, 59, 'ab.jpeg', 1, '16.077488333333335', '108.17150833333332'),
(41, 'thu', 'Cục Hải quan Hàn Quốc tại Incheon cho biết đã bắt giữ một nữ tiếp viên hàng không Việt Nam làm việc cho một hãng hàng không Hàn Quốc vì tội buôn lậu vàng', 'Cục Hải quan Hàn Quốc tại Incheon cho biết đã bắt giữ một nữ tiếp viên hàng không Việt Nam làm việc cho một hãng hàng không Hàn Quốc vì tội buôn lậu vàng', '201610302794.jpeg', '30/10/2016', 0, 1, 'ab.jpeg', 1, '0.0', '0.0'),
(43, 'thu', 'ccccccccc', 'cccccccccc', '201611012630871.jpeg', '01/11/2016', 0, 5, 'ab.jpeg', 1, '0.0', '0.0'),
(44, 'thu', 'vxc', 'cx', '201611028801634.jpeg', '02/11/2016', 0, 0, 'ab.jpeg', 1, '0.0', '0.0'),
(45, 'thu', 'hello chim', 'hi cu', '201611026005016.jpeg', '02/11/2016', 0, 3, 'ab.jpeg', 1, '0.0', '0.0'),
(46, 'thu', 'cvbcv', 'bcvbcvb', '201611042514693.jpeg', '04/11/2016', 0, 0, 'ab.jpeg', 1, '0.0', '0.0'),
(47, 'thu', 'mmmmmmmm', 'mmmmmmmm', '201611041332463.jpeg', '04/11/2016', 0, 1, 'ab.jpeg', 1, '0.0', '0.0'),
(53, 'diep', 'chao ngay moi', 'hello ngay moi', '201611059394605.jpeg', '05/11/2016', 0, 1, '201611053686316.jpeg', 1, '0.0', '0.0'),
(54, 'thu', 'gdgd', 'gdgdg', '201611052290065.jpeg', '05/11/2016', 0, 2, '201611046202612.jpeg', 1, '0.0', '0.0'),
(55, 'diep', 'vvv', 'vvv', '201611055990421.jpeg', '05/11/2016', 4, 3, '201611053686316.jpeg', 1, '0.0', '0.0'),
(57, 'thu', 'bbbbbbbb', 'bbbbbbbbbbbb', '201611077763082.jpeg', '07/11/2016', 4, 5, '201611046202612.jpeg', 1, '0.0', '0.0');

-- --------------------------------------------------------

--
-- Structure de la table `sotay`
--

CREATE TABLE IF NOT EXISTS `sotay` (
  `maso` int(11) NOT NULL AUTO_INCREMENT,
  `diadiem` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `noidung` text COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ngaytao` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`maso`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Contenu de la table `sotay`
--

INSERT INTO `sotay` (`maso`, `diadiem`, `noidung`, `username`, `ngaytao`) VALUES
(2, 'Biển Phạm Văn Đồng - Đà Nẵng', 'Sự kiện bất ngờ này có thể tạo nên bước ngoặt trong cuộc bầu cử tổng thống. Hiện ứng viên đảng Cộng hòa Donald Trump bị bà Clinton dẫn điểm trong hầu hết các cuộc thăm dò toàn quốc.', 'thu', '28/10/2016'),
(3, 'dsfsf', 'sfsf', 'thu', '06/11/2016');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `avatar` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`iduser`, `username`, `email`, `password`, `avatar`) VALUES
(1, 'thu', 'minhthuvlt@gmail.com', '111', '201611076847545.jpeg'),
(2, 'diep', 'diep@gmail.com', '123', '201611053686316.jpeg'),
(3, 'man', 'man@gmail.com', '111', 'nen1.jpeg'),
(4, 'hoa', 'h@gmail.com', '1234', NULL),
(5, 'hello', 'hello@gmail.com', '111', NULL),
(6, 'lllllll', 'llll@gmail.com', '111', NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
