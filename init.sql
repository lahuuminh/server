CREATE DATABASE  IF NOT EXISTS `banhang` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `banhang`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: banhang
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chitiethoadon`
--

DROP TABLE IF EXISTS `chitiethoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitiethoadon` (
  `mahoadon` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `masanpham` int DEFAULT NULL,
  `gia` double DEFAULT NULL,
  `soluong` int DEFAULT NULL,
  KEY `masanpham` (`masanpham`),
  KEY `mahoadon` (`mahoadon`),
  CONSTRAINT `chitiethoadon_ibfk_2` FOREIGN KEY (`masanpham`) REFERENCES `sanpham` (`masanpham`),
  CONSTRAINT `chitiethoadon_ibfk_3` FOREIGN KEY (`mahoadon`) REFERENCES `hoadon` (`mahoadon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitiethoadon`
--

LOCK TABLES `chitiethoadon` WRITE;
/*!40000 ALTER TABLE `chitiethoadon` DISABLE KEYS */;
INSERT INTO `chitiethoadon` VALUES ('WB14-211902130',2,160000,2),('WB14-215334933',1,40000,1),('WB14-215417525',2,160000,2),('WB14-215444557',1,40000,3),('WB14-217352525',12,220000,2),('WB14-230478781',3,160000,7),('WB17-257959247',3,160000,5),('WB17-257959247',1,40000,4),('WB17-258067312',1,40000,20),('WB17-258067312',3,160000,10),('WB17-264757596',2,160000,4),('WB17-264757596',1,40000,3),('WB17-264899691',1,40000,3),('WB21-210469548',3,160000,5),('WB21-210469548',2,160000,6),('WB21-210469548',1,40000,4),('WB1-359270334',2,160000,3),('WB1-359270334',3,160000,2),('WB1-359333341',1,40000,1),('WB5-320047609',11,210000,3),('WB5-320047609',12,220000,5),('WB5-321521490',3,160000,2),('WB5-321521490',8,520000,6),('WB6-314252115',1,40000,3),('WB14-368179074',3,160000,4),('WB14-372893751',1,40000,3),('WB17-368920178',2,160000,3),('WB17-369180738',4,180000,2),('WB17-369197722',10,200000,2),('WB21-371543910',7,420000,3),('WB21-371543910',8,520000,2),('WB21-371822579',6,160000,1),('WB21-371919600',6,160000,1),('WB21-371975288',6,160000,1),('WB21-372131386',6,160000,1),('WB22-350555636',3,160000,2),('WB22-350555636',4,180000,3),('WB5-410640474',13,372000,3),('WB5-410640474',15,1711000,3),('WB5-410986903',15,1711000,1),('WB5-410986903',14,850000,1),('WB5-411096577',15,1711000,1),('WB5-411151895',15,1711000,1),('WB5-414001763',20,1300000,12),('WB5-414001763',16,1055000,5),('WB5-414001763',15,1711000,4),('WB6-488994956',12,250000,5);
/*!40000 ALTER TABLE `chitiethoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hinhanh`
--

DROP TABLE IF EXISTS `hinhanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hinhanh` (
  `anh_id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `masanpham` int DEFAULT NULL,
  PRIMARY KEY (`anh_id`),
  KEY `masanpham` (`masanpham`),
  CONSTRAINT `hinhanh_ibfk_1` FOREIGN KEY (`masanpham`) REFERENCES `sanpham` (`masanpham`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hinhanh`
--

LOCK TABLES `hinhanh` WRITE;
/*!40000 ALTER TABLE `hinhanh` DISABLE KEYS */;
INSERT INTO `hinhanh` VALUES (1,'../asset/anh/chibi figure/16 1.jpg',1),(2,'../asset/anh/chibi figure/24 2.jpg',1),(3,'../asset/anh/chibi figure/24 3.jpg',1),(4,'../asset/anh/chibi figure/24 4.jpg',1),(5,'../asset/anh/chibi figure/17 1.jpg',2),(6,'../asset/anh/chibi figure/18 4.jpg',3),(7,'../asset/anh/chibi figure/19 1.jpg',4),(9,'../asset/anh/chibi figure/20 4.jpg',6),(10,'../asset/anh/chibi figure/21 4.jpg',7),(11,'../asset/anh/chibi figure/22 4.jpg',8),(12,'../asset/anh/chibi figure/27 4.jpg',9),(13,'../asset/anh/chibi figure/26 4.jpg',10),(14,'../asset/anh/chibi figure/25 1.jpg',5),(15,'../asset/anh/chibi figure/23 1.jpg',11),(16,'../asset/anh/chibi figure/24 1.jpg',12),(19,'../asset/anh/chibi figure/30 1.jpg',20),(20,'../asset/anh/chibi figure/28 1.jpg',19),(21,'../asset/anh/chibi figure/29 1.jpg',18),(22,'../asset/anh/set figure/37 1.jpg',17),(23,'../asset/anh/set figure/38 1.jpg',16),(24,'../asset/anh/set figure/39 1.jpg',15),(25,'../asset/anh/set figure/40 1.jpg',14),(26,'../asset/anh/set figure/41 1.jpg',13);
/*!40000 ALTER TABLE `hinhanh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `mahoadon` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `trangthaihoadon` enum('Wating','Da Giao Hang','Da Huy') COLLATE utf8mb4_general_ci DEFAULT 'Wating',
  `ngaymua` date DEFAULT NULL,
  `tongtien` double DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`mahoadon`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES ('eljadfa','Da Giao Hang','2024-04-10',120000,22),('WB1-359270334','Da Giao Hang','2024-04-01',800000,10),('WB1-359333341','Da Giao Hang','2024-04-01',40000,10),('WB14-211902130','Da Giao Hang','2024-03-14',320000,1),('WB14-215334933','Da Huy','2024-03-14',40000,1),('WB14-215417525','Da Giao Hang','2024-03-14',320000,1),('WB14-215444557','Da Huy','2024-03-14',120000,1),('WB14-217352525','Da Huy','2024-03-14',440000,1),('WB14-230478781','Da Huy','2024-03-14',1120000,2),('WB14-368179074','Da Giao Hang','2024-04-14',640000,10),('WB14-372893751','Da Giao Hang','2024-04-14',120000,22),('WB17-257959247','Da Giao Hang','2024-03-17',960000,1),('WB17-258067312','Da Giao Hang','2024-03-17',2400000,1),('WB17-264757596','Da Giao Hang','2024-03-17',760000,1),('WB17-264899691','Da Huy','2024-03-17',120000,1),('WB17-368920178','Da Giao Hang','2024-04-17',480000,10),('WB17-369180738','Da Huy','2024-04-17',360000,10),('WB17-369197722','Da Giao Hang','2024-04-17',400000,10),('WB21-210469548','Da Giao Hang','2024-03-21',1920000,1),('WB21-371543910','Da Giao Hang','2024-04-21',2300000,22),('WB21-371822579','Da Giao Hang','2024-04-21',160000,22),('WB21-371919600','Da Giao Hang','2024-04-21',160000,22),('WB21-371975288','Da Giao Hang','2024-04-21',160000,22),('WB21-372131386','Da Giao Hang','2024-04-21',160000,22),('WB22-350555636','Da Giao Hang','2024-04-22',860000,10),('WB5-320047609','Da Giao Hang','2024-04-05',1730000,2),('WB5-321521490','Da Huy','2024-04-05',3440000,2),('WB5-410640474','Da Giao Hang','2024-05-05',6249000,10),('WB5-410986903','Da Giao Hang','2024-05-05',2561000,10),('WB5-411096577','Da Giao Hang','2024-05-05',1711000,10),('WB5-411151895','Da Giao Hang','2024-05-05',1711000,10),('WB5-414001763','Da Giao Hang','2024-05-05',27719000,10),('WB6-314252115','Da Giao Hang','2024-04-06',120000,10),('WB6-488994956','Da Giao Hang','2024-05-06',1250000,30);
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhacungcap`
--

DROP TABLE IF EXISTS `nhacungcap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhacungcap` (
  `ten` varchar(250) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `diachi` varchar(250) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(250) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `sodienthoai` varchar(250) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `manhacungcap` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`manhacungcap`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhacungcap`
--

LOCK TABLES `nhacungcap` WRITE;
/*!40000 ALTER TABLE `nhacungcap` DISABLE KEYS */;
INSERT INTO `nhacungcap` VALUES ('la huu minh','ha noi','lahuuman678@gmail.com','0997330699',9),('Tôn hoa sen','ha noi','lahuuman678@gmail.com','0993022112',11),('test','tphcm','akinbaber@gmail.com','0898891856',13);
/*!40000 ALTER TABLE `nhacungcap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieunhap`
--

DROP TABLE IF EXISTS `phieunhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieunhap` (
  `maphieunhap` varchar(250) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `ngaynhap` date DEFAULT NULL,
  `loai` int DEFAULT NULL,
  `tongtien` double DEFAULT NULL,
  `soluong` int DEFAULT NULL,
  `masanpham` int DEFAULT NULL,
  `congty` varchar(250) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`maphieunhap`),
  KEY `FK_PersonOrder` (`masanpham`),
  CONSTRAINT `FK_PersonOrder` FOREIGN KEY (`masanpham`) REFERENCES `sanpham` (`masanpham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieunhap`
--

LOCK TABLES `phieunhap` WRITE;
/*!40000 ALTER TABLE `phieunhap` DISABLE KEYS */;
INSERT INTO `phieunhap` VALUES ('1235','2024-04-18',1,120,10,1,'test'),('45897','2024-04-18',4,100,10,1,'huu man'),('502688','2024-04-21',1,100000,1,7,'huu man'),('722787','2024-05-05',1,100000,2,10,'la huu minh'),('726345','2024-05-06',4,10000000,100,12,'la huu minh'),('791094','2024-04-17',1,1000000,10,1,'la huu minh'),('9883','2024-04-21',3,100000,2,7,'huu man');
/*!40000 ALTER TABLE `phieunhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
  `masanpham` int NOT NULL AUTO_INCREMENT,
  `gia` double DEFAULT NULL,
  `soluong` int DEFAULT NULL,
  `theloai` int DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`masanpham`),
  KEY `theloai` (`theloai`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (1,40000,100,1,'Mô hình: Super Saiya God Goku'),(2,160000,100,1,'Mô hình: Titan Thiết Giáp'),(3,160000,98,2,'Mô hình: Gray Fullbuster'),(4,180000,97,2,'Mô hình: Satoru Gojo'),(5,210000,100,3,'Mô hình: Huggy Wuggy'),(6,160000,100,1,'Mô hình: Komi không thể nói'),(7,420000,103,1,'Mô hình: SAO Kirito'),(8,520000,10,1,'Mô hình: Cloud Strife cầm kiếm'),(9,200000,10,1,'Mô hình: Thầy Aizawa chiến đấu'),(10,200000,10,3,'songoku'),(11,210000,10,3,'Bộ figure: DRAGONBALL SS SON GOKU DX'),(12,250000,100,4,'Chibi figure: TV Anime MASHLE Mash Burnedead'),(13,372000,97,4,'Cosplay: Unisex Demon Slayer Kimetsu no Yaiba'),(14,850000,49,4,'Cosplay: Unisex One Piece Monkey D Luffy'),(15,1711000,39,4,'Unisex Demon Slayer Tomioka Giyuu Cosplay'),(16,1055000,55,4,'Cosplay: Unisex Naruto Akatsuki Tobi Uchiha Obito'),(17,560855,30,3,'Bộ figure: DRAGONBALL SS SON GOKU DX'),(18,129728,44,3,'Bộ figure: Belfine Demon Slayer Kyojuro Rengoku'),(19,196490,43,3,'Bộ figure: Dragon Ball Shenron and Childhood Goku'),(20,1300000,18,2,'Chibi figure: LookUp ONE PIECE Yamato 12');
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` enum('active','inactive','delete') COLLATE utf8mb4_general_ci DEFAULT 'active',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `role` enum('admin','nguoiban','nguoimua','nguoiquanly','nguoiquanlykho') COLLATE utf8mb4_general_ci DEFAULT 'nguoimua',
  `accountname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'minhman1@gmail.com','lahuuminh','active','12345678','0708393931','admin','lahuuminh','hanoi'),(2,'minhman1@gmail.com','lahuuman','active','12345678','0912345678','nguoiquanlykho','lahuuman','vung tau'),(10,'lahuuminh678@vnu.edu.vn','lachikim','active','12345678','0966749653','nguoiquanly','lachikim','tpchm'),(18,'akinbaber@gmail.com','tranthanh','active','12345678','0708270639','nguoimua','tranthanhlong','long an'),(21,'akinbaber@gmail.com','hotam','active','12345678','0708270639','nguoimua','hotam','vung tau'),(22,'akinbaber1@gmail.com','phamthanh','active','123456789','0708270639','nguoiquanlykho','phamthanh','thanhhoa'),(30,'lahuuminh678@gmail.com','thuy','active','12345678','0708270639','nguoimua','thuy','tayninh');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-25 22:52:29
