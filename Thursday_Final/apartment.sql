/*
 Navicat Premium Data Transfer

 Source Server         : Thursday
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 149.28.58.107:3306
 Source Schema         : apartment

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 09/12/2019 14:33:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `companyname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `adminuser` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`,`companyname`),
  UNIQUE KEY `companyname_2` (`companyname`),
  KEY `id` (`id`),
  KEY `companyname` (`companyname`),
  KEY `admin` (`adminuser`),
  CONSTRAINT `admin` FOREIGN KEY (`adminuser`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of company
-- ----------------------------
BEGIN;
INSERT INTO `company` VALUES (1, 'Emerald Property', 'APT', 'aptadmin1', 0);
INSERT INTO `company` VALUES (2, 'CY Leung 689', 'CLC', 'clcadmin', 1);
INSERT INTO `company` VALUES (3, 'Carrie Lam 777', 'CLC', NULL, 0);
INSERT INTO `company` VALUES (4, 'SUPERUSER', 'SU', 'root', 1);
INSERT INTO `company` VALUES (5, 'SAM\'s Room', 'APT', 'samadmin', 1);
INSERT INTO `company` VALUES (6, 'AMY\'s Lockerroom', 'APT', 'amyadmin1', 0);
INSERT INTO `company` VALUES (7, 'Elizabeth\'s Cleaning', 'CLC', 'ecladmin', 0);
INSERT INTO `company` VALUES (8, 'Landmark', 'APT', 'LandmarkAdmin', 1);
INSERT INTO `company` VALUES (9, 'BG cleaning company', 'CLC', 'BGAdmin', 1);
INSERT INTO `company` VALUES (10, 'Boston scenic  Apt', 'APT', 'BSAdmin', 1);
INSERT INTO `company` VALUES (11, 'DingDong', 'APT', 'dingadmin', 1);
INSERT INTO `company` VALUES (12, 'CityView apt', 'APT', 'dfs', 1);
INSERT INTO `company` VALUES (14, 'lihai comp', 'APT', 'lihaiAdmin', 1);
INSERT INTO `company` VALUES (15, '123', 'APT', '123admin', 1);
INSERT INTO `company` VALUES (16, 'sad', 'APT', '123admin1', 1);
INSERT INTO `company` VALUES (17, '1234', 'CLC', '1234admin', 1);
INSERT INTO `company` VALUES (18, 'PG clc', 'CLC', 'PGadmin', 1);
INSERT INTO `company` VALUES (19, 'PG apt', 'APT', 'PGAdmin1', 0);
INSERT INTO `company` VALUES (20, 'LP clc', 'CLC', 'LPadmin', 0);
INSERT INTO `company` VALUES (21, 'LP apt', 'APT', 'LPadmin1', 1);
INSERT INTO `company` VALUES (22, 'Aparte', 'APT', 'aptadmin2', 1);
INSERT INTO `company` VALUES (23, 'CleanWinnie', 'CLC', 'winnieadmin', 1);
INSERT INTO `company` VALUES (24, 'Apartment', 'APT', 'aptadmin', 1);
INSERT INTO `company` VALUES (25, 'CleaningCompany', 'CLC', 'ccmpadmin', 1);
COMMIT;

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `message` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creator` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createtime` datetime(6) DEFAULT NULL,
  `resolvetime` datetime(6) DEFAULT NULL,
  `status` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `state` int(2) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `creator` (`creator`),
  CONSTRAINT `creator` FOREIGN KEY (`creator`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of task
-- ----------------------------
BEGIN;
INSERT INTO `task` VALUES (1, 'Hello', 'Nothing here', NULL, '2019-11-30 13:24:51.414000', '2019-11-30 13:36:59.852000', 'FINISHED', 0);
INSERT INTO `task` VALUES (2, 'Hello Again', 'Nothing here', 'aptadmin1', '2019-11-30 13:27:54.381000', '2019-11-30 13:37:07.376000', 'FINISHED', 0);
INSERT INTO `task` VALUES (4, 'Hello Again!', 'Nothing here', 'root', '2019-11-30 13:28:44.282000', '2019-11-30 13:35:12.690000', 'FINISHED', 0);
INSERT INTO `task` VALUES (13, 'Test2', 'Nothing here', 'aptadmin1', '2019-11-30 14:55:00.685000', NULL, 'PENDING', 0);
INSERT INTO `task` VALUES (15, '123 Repair', '12334', 'lihang', '2019-12-03 22:15:59.710000', NULL, 'PENDING', 0);
INSERT INTO `task` VALUES (16, 'Apt214 Repair', '12', 'lihang', '2019-12-04 09:46:04.782000', NULL, 'PENDING', 0);
INSERT INTO `task` VALUES (17, 'Apt123 Repair', '1', 'lihang', '2019-12-04 18:03:43.630000', NULL, 'WORKING', 0);
INSERT INTO `task` VALUES (18, 'Apt123 Repair', '123', 'lihang', '2019-12-05 10:48:09.608000', NULL, 'PENDING', 0);
INSERT INTO `task` VALUES (19, 'Apt123 Cleaning', '1234', 'lihang', '2019-12-05 10:48:15.712000', NULL, 'WAIT_FOR_RESPONSE', 0);
INSERT INTO `task` VALUES (20, 'Apt123 Repair', '123r', 'lihang', '2019-12-05 11:34:50.045000', NULL, 'FINISHED', 0);
INSERT INTO `task` VALUES (21, 'Apt123 Cleaning', '123c', 'lihang', '2019-12-05 11:34:55.509000', NULL, 'PENDING', 0);
INSERT INTO `task` VALUES (22, 'Apt123 Cleaning', '1234', 'lihang', '2019-12-05 13:40:25.044000', NULL, 'WORKING', 0);
INSERT INTO `task` VALUES (23, 'Apt123 Repair', '1234r', 'lihang', '2019-12-05 13:40:29.513000', NULL, 'WAIT_FOR_RESPONSE', 0);
INSERT INTO `task` VALUES (24, 'Apt123 Repair', '123r', 'lihang', '2019-12-05 13:54:49.604000', NULL, 'FINISHED', 0);
INSERT INTO `task` VALUES (25, 'Apt123 Cleaning', '123c', 'lihang', '2019-12-05 13:54:54.534000', NULL, 'WAIT_FOR_RESPONSE', 0);
INSERT INTO `task` VALUES (26, 'Apt234 Repair', '1234r', 'cjy', '2019-12-05 15:09:57.535000', NULL, 'PENDING', 0);
INSERT INTO `task` VALUES (27, 'Apt1231 Cleaning', '234', 'cjy', '2019-12-05 15:10:52.204000', NULL, 'WAIT_FOR_RESPONSE', 0);
INSERT INTO `task` VALUES (28, 'Apt123 Repair', '12', 'lihang', '2019-12-05 16:48:58.446000', NULL, 'PENDING', 0);
INSERT INTO `task` VALUES (29, 'Apt12313 Repair', '123123', 'amyjoseph', '2019-12-05 17:05:12.896000', NULL, 'WAIT_FOR_RESPONSE', 0);
INSERT INTO `task` VALUES (30, 'Apt123 Repair', 're12', 'qwe', '2019-12-06 15:18:09.021000', NULL, 'FINISHED', 1);
INSERT INTO `task` VALUES (31, 'Apt123 Cleaning', 'cle12', 'qwe', '2019-12-06 15:18:30.912000', NULL, 'PENDING', 0);
INSERT INTO `task` VALUES (32, 'Apt123 Cleaning', 'asd3cl', 'qwe', '2019-12-06 15:19:05.961000', NULL, 'WAIT_FOR_RESPONSE', 1);
INSERT INTO `task` VALUES (33, 'Apt Repair', '', 'lihang', '2019-12-06 16:24:48.221000', NULL, 'PENDING', 0);
INSERT INTO `task` VALUES (34, 'Apt123 Repair', '123', 'lihang', '2019-12-06 16:41:01.718000', NULL, 'PENDING', 0);
INSERT INTO `task` VALUES (35, 'Apt123 Repair', '123', 'lihang', '2019-12-06 16:41:53.805000', NULL, 'PENDING', 0);
INSERT INTO `task` VALUES (36, 'Apt123a Repair', '123', 'lihang', '2019-12-06 16:41:59.252000', NULL, 'PENDING', 0);
INSERT INTO `task` VALUES (37, 'Apta Repair', '123', 'lihang', '2019-12-06 16:42:08.052000', NULL, 'PENDING', 0);
INSERT INTO `task` VALUES (38, 'Aptds Cleaning', 'sdfg', 'qwe', '2019-12-06 16:55:41.249000', NULL, 'FINISHED', 1);
INSERT INTO `task` VALUES (39, 'Aptasdasdad Repair', 'asdasd', 'lihang', '2019-12-06 18:42:46.034000', NULL, 'WAIT_FOR_RESPONSE', 0);
INSERT INTO `task` VALUES (40, 'Apt123 Repair', '123', 'qwe', '2019-12-06 18:49:52.780000', NULL, 'WAIT_FOR_RESPONSE', 1);
INSERT INTO `task` VALUES (41, 'Apt123 Repair', '123', 'qwe', '2019-12-06 18:57:26.556000', NULL, 'WAIT_FOR_RESPONSE', 1);
INSERT INTO `task` VALUES (42, 'Apt123 Repair', '123', 'lihang', '2019-12-06 19:19:29.376000', NULL, 'WAIT_FOR_RESPONSE', 0);
INSERT INTO `task` VALUES (43, 'Apt123 Repair', '123', 'lihang', '2019-12-06 19:29:05.516000', NULL, 'WAIT_FOR_RESPONSE', 0);
INSERT INTO `task` VALUES (44, 'Apt123 Repair', '123', 'lihang', '2019-12-06 19:34:17.479000', NULL, 'WAIT_FOR_RESPONSE', 0);
INSERT INTO `task` VALUES (45, 'Aptapt312 Repair', 'no', 'PeterR', '2019-12-07 13:12:03.167000', NULL, 'WAIT_FOR_RESPONSE', 1);
INSERT INTO `task` VALUES (46, 'Aptabc1 Cleaning', '1111', 'PeterR', '2019-12-07 13:12:21.366000', NULL, 'PENDING', 0);
INSERT INTO `task` VALUES (47, 'Apt312 Cleaning', '123', 'PeterR', '2019-12-07 13:12:51.286000', NULL, 'FINISHED', 1);
INSERT INTO `task` VALUES (48, 'Apt510a Repair', '123dafs asd', 'AliceR', '2019-12-07 13:15:46.110000', NULL, 'WAIT_FOR_RESPONSE', 1);
INSERT INTO `task` VALUES (49, 'Apt510a Cleaning', '!@#$%$^!@!#%$', 'AliceR', '2019-12-07 13:15:56.710000', NULL, 'FINISHED', 1);
INSERT INTO `task` VALUES (50, 'Apt123 Repair', '23', 'lihang', '2019-12-07 14:03:11.667000', NULL, 'FINISHED', 0);
INSERT INTO `task` VALUES (51, 'Apt89 Cleaning', 'None', 'lihang', '2019-12-07 16:20:04.595000', NULL, 'WAIT_FOR_RESPONSE', 0);
INSERT INTO `task` VALUES (52, 'Apt35 Cleaning', 'dfs', 'lihang', '2019-12-07 16:25:06.245000', NULL, 'WAIT_FOR_RESPONSE', 0);
INSERT INTO `task` VALUES (53, 'Apt102 Repair', 'no', 'winniethepooh', '2019-12-07 17:52:06.453000', NULL, 'FINISHED', 1);
INSERT INTO `task` VALUES (54, 'Apt123 Repair', '123', 'winniethepooh', '2019-12-07 17:53:44.042000', NULL, 'FINISHED', 1);
INSERT INTO `task` VALUES (55, 'Apt123 Repair', '123', 'winniethepooh', '2019-12-07 17:56:19.638000', NULL, 'FINISHED', 1);
INSERT INTO `task` VALUES (56, 'Apt123 Repair', '234', 'winniethepooh', '2019-12-07 17:56:24.384000', NULL, 'WORKING', 1);
INSERT INTO `task` VALUES (57, 'Apt213 Repair', '1234', 'winniethepooh', '2019-12-07 18:04:20.568000', NULL, 'WAIT_FOR_RESPONSE', 1);
INSERT INTO `task` VALUES (58, 'Apt99 Repair', 'Air Conditioner Issues', 'andy', '2019-12-07 18:52:40.013000', NULL, 'FINISHED', 1);
INSERT INTO `task` VALUES (59, 'Apt99 Cleaning', 'House need to clean', 'andy', '2019-12-07 19:07:01.373000', NULL, 'FINISHED', 1);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `passwd` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `firstname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `companyname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `state` int(2) DEFAULT '1',
  PRIMARY KEY (`id`,`username`),
  UNIQUE KEY `username_2` (`username`),
  KEY `username` (`username`),
  KEY `companyname` (`companyname`),
  CONSTRAINT `companyname` FOREIGN KEY (`companyname`) REFERENCES `company` (`companyname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'aptadmin1', '$31$16$-a86BIy6IOYS7a1ypTs2dUIHfulYpbysBUzIgLSyi-A', 'Zero', 'Administrator', 'Emerald Property', 'ADMIN', 0);
INSERT INTO `user` VALUES (2, 'root', '$31$16$H_zJbqDYygqs1mNXSUMPoNB_Z4D3RrTNdLMD_wBs0CM', 'Super', 'User', 'SUPERUSER', 'SUPERUSER', 1);
INSERT INTO `user` VALUES (3, 'clcadmin', '$31$16$hWtcTrULqx-t0dmhhxrJfndyG6SiCU6xthAhAypwZ4I', 'One', 'Administator', 'CY Leung 689', 'HUMAN RESOURCES', 1);
INSERT INTO `user` VALUES (4, 'cjy', '$31$16$35rWue_Tdxt85k1yD1gSnRtMZlfvivNTtePQXYoOA9E', 'Jieying', 'Chen', 'Emerald Property', 'RESIDENT', 0);
INSERT INTO `user` VALUES (5, 'lihang', '$31$16$acujpDQCff3vBDDOIsjhj492hjFuYl4RHhD0lBOsIYo', 'Lihang', 'Zhou', 'Emerald Property', 'RESIDENT', 0);
INSERT INTO `user` VALUES (6, 'carrielam', '$31$16$4Jro5G0uF52pIKZAGTMt1okb95EVVyXTtXmBv3CdMK4', 'Carrie', 'Lam', 'Emerald Property', 'REPAIR PERSON', 0);
INSERT INTO `user` VALUES (7, 'cyleung', '$31$16$SqdBcHT97V90V8iTjI83BSucG0Me9CUAq2dqe6LvW_s', 'CY', 'Leung', 'CY Leung 689', 'CLEANER', 1);
INSERT INTO `user` VALUES (8, 'Username', '$31$16$ZZW58GcE1yuWhKLBvxlnaypNRoihEEByY7Ur4f6RZ7w', 'Yuk-man', 'Wong', 'CY Leung 689', 'SCHEDULE MAKER', 1);
INSERT INTO `user` VALUES (9, 'samadmin', '$31$16$FDOpDFkvPryB6LNFnru-eQ1kBFdCzd9z_18HfjEyhu0', 'One', 'Administrator', 'SAM\'s Room', 'ADMIN', 1);
INSERT INTO `user` VALUES (10, 'amyadmin1', '$31$16$kr_LR2bpkdZWXL5pSmBrhRRiV-IeHUi0aX7pflz08Cs', 'One', 'Administrator', 'AMY\'s Lockerroom', 'ADMIN', 0);
INSERT INTO `user` VALUES (11, 'ecladmin', '$31$16$BHJGWtCTyGCSrjkNNeM6pF8jTkSnNg1gWofgDn5Otts', 'One', 'Administrator', 'Elizabeth\'s Cleaning', 'HUMAN RESOURCES', 0);
INSERT INTO `user` VALUES (12, 'john1', '$31$16$UPJ6KtpMpPVChvGiRSkWIKPumktBpfIZ8vB6tRmQtjQ', 'John', 'Johnson', 'Emerald Property', 'REPAIR PERSON', 0);
INSERT INTO `user` VALUES (13, 'amylynn', '$31$16$NcCzLL72A36m9rSMXLacRmfXM5IAEPRFym7B-wPP6b4', 'Amy', 'Lynn', 'AMY\'s Lockerroom', 'REPAIR PERSON', 0);
INSERT INTO `user` VALUES (14, 'amyjoseph', '$31$16$1GfaeHcj_xwu1A8em7QGirkwsjRKmtpyS7OQiXpElXk', 'Amy', 'Joseph', 'AMY\'s Lockerroom', 'RESIDENT', 0);
INSERT INTO `user` VALUES (15, 'LandmarkAdmin', '$31$16$8RY8V6esi8IWkVGPwTpO67J965z9KFn_syV8cYV2x3Q', 'One', 'Administrator', 'Landmark', 'ADMIN', 1);
INSERT INTO `user` VALUES (16, 'raymondhi', '$31$16$Py_16zC6n1gDpl2cx1VU4AfYkZ2wT7pDnafe-m3-xdk', 'Raymond', 'Hi', 'CY Leung 689', 'CLEANER', 0);
INSERT INTO `user` VALUES (17, 'gongje', '$31$16$xLoCOQ8aaMfa4lxuw66xDNPDrQLhdFqjg9xPk2zLKcY', 'Gong', 'Je', 'CY Leung 689', 'CLEANER', 0);
INSERT INTO `user` VALUES (18, 'BGAdmin', '$31$16$7SRzoXJIaK-l6Djw2PUP03aAQJEOEGLJJepv_uBhI60', 'One', 'Administrator', 'BG cleaning company', 'HUMAN RESOURCES', 1);
INSERT INTO `user` VALUES (19, 'BSAdmin', '$31$16$7l9iiL6PCh5DECas8LetVA-bEThQJj1MEpJEFMwtAlc', 'One', 'Administrator', 'Boston scenic  Apt', 'ADMIN', 1);
INSERT INTO `user` VALUES (20, 'dingadmin', '$31$16$75_DsqUTMEsk0SQPEShEfQZg0fgFSORJg8Z6mX-qWaM', 'One', 'Administrator', 'DingDong', 'ADMIN', 1);
INSERT INTO `user` VALUES (21, 'dfs', '$31$16$nqnzg2xQRAojQSzdVHbWZ9P_xSC2xzfyGQzETwldZLQ', 'One', 'Administrator', 'CityView apt', 'ADMIN', 1);
INSERT INTO `user` VALUES (22, 'qwe', '$31$16$ZaarOZ1E4u1DKhxXZogREZ-TWcGd2gNUZRPBH_v_wyA', 'qwer', 'qwer', 'CityView apt', 'RESIDENT', 1);
INSERT INTO `user` VALUES (23, 'qwer', '$31$16$PDVJYdQxAtReRKhQoOoui9PJPYgYiFMTH8Z-QoPrFxA', 'sadad', 'sadad', 'CityView apt', 'RESIDENT', 0);
INSERT INTO `user` VALUES (24, 're3', '$31$16$sNReIvJi2LmnP5WyfIsWsXQ438UK-KJbKS6zALbpqiA', 'qe   wet', 'ertr   fhyrtfd', 'CityView apt', 'REPAIR PERSON', 1);
INSERT INTO `user` VALUES (26, 'lihaiAdmin', '$31$16$JrVRXyQQjoxcHvbXOrV0HE2l-J9qnlhtpXbd6nDJpGs', 'One', 'Administrator', 'lihai comp', 'ADMIN', 1);
INSERT INTO `user` VALUES (27, 'cl1', '$31$16$jhJO1b_3u0QrG0beqrwaZpRzp4OjQgW5xiD5e4vPbiI', 'fsghj', 'fdxgh', 'Elizabeth\'s Cleaning', 'CLEANER', 0);
INSERT INTO `user` VALUES (28, '123admin', '$31$16$jGVW_tiy1dPbSCYQdaLdDSivq9pul7QJbTMLaBYFE38', 'One', 'Administrator', '123', 'ADMIN', 1);
INSERT INTO `user` VALUES (29, '123admin1', '$31$16$az8ct9DMha7eLOXjnCfdWiUrqQGLWOUWOrLH6B-T-7Y', 'One', 'Administrator', 'sad', 'ADMIN', 1);
INSERT INTO `user` VALUES (30, '1234admin', '$31$16$-a86BIy6IOYS7a1ypTs2dUIHfulYpbysBUzIgLSyi-A', 'One', 'Administrator', '1234', 'HUMAN RESOURCES', 1);
INSERT INTO `user` VALUES (31, 'PGadmin', '$31$16$DMK9gQ9aLWbLvkiHRkQjvQQvKpj-_6JRBO0xD8gWD-A', 'One', 'Administrator', 'PG clc', 'HUMAN RESOURCES', 1);
INSERT INTO `user` VALUES (32, 'PGAdmin1', '$31$16$mzuksLllFcG_tyEmmovWwb6wbsvN3Eo33wPnDqu7UOY', 'One', 'Administrator', 'PG apt', 'ADMIN', 0);
INSERT INTO `user` VALUES (33, 'LPadmin', '$31$16$S4xI5wjiUIWuWGcZk8abCUnWTako8bkA96_Ul5_eZJ0', 'One', 'Administrator', 'LP clc', 'HUMAN RESOURCES', 0);
INSERT INTO `user` VALUES (34, 'LPadmin1', '$31$16$Qi4BNAfZNDEim0qNBm-1PcGlZB9EZ5Pj3F42qnWAeIU', 'One', 'Administrator', 'LP apt', 'ADMIN', 1);
INSERT INTO `user` VALUES (35, 'PeterR', '$31$16$4nwFuAS7aXYmfJ64Zycul8hJVR1JUHePEOqmttnzR-8', 'p', 'j', 'LP apt', 'RESIDENT', 1);
INSERT INTO `user` VALUES (36, 'AliceR', '$31$16$LjjOlQ-flsqu0LmyAa7xcgcsuY8vJOQZuHLTjKLb8RM', 'a', 's', 'LP apt', 'RESIDENT', 1);
INSERT INTO `user` VALUES (37, 'PeterL', '$31$16$d-EE_zPE14dTzsOOuckPouO2q6THESPVp_6JCH2N_uE', 'p', 'j', 'LP apt', 'REPAIR PERSON', 1);
INSERT INTO `user` VALUES (38, 'Johnson', '$31$16$skX2k75VwiXwHtDuOihmAgMzn-BS2a6IQmGPewUNMeg', 'j', 's', 'LP apt', 'REPAIR PERSON', 1);
INSERT INTO `user` VALUES (39, 'Joe', '$31$16$IEDdp9PekWJ0WfvGIFnCmWOPO_La94xErkKtJql5asI', '1', '2', 'LP clc', 'CLEANER', 0);
INSERT INTO `user` VALUES (40, 'dood', '$31$16$ct0K7z6veirxsfpvnBlbAHHwEbrF_BjrdPTZBGOFxLw', 'Do', 'Od', '1234', 'CLEANER', 1);
INSERT INTO `user` VALUES (41, 'aptadmin2', '$31$16$pYMegY9d3z2380nnxQWFGFeNjGNWRPJ2MOKjtp5m_gU', 'One', 'Administrator', 'Aparte', 'ADMIN', 1);
INSERT INTO `user` VALUES (42, 'winnieadmin', '$31$16$7hhsa5cG0s0_9dvCantT4ykRyABktw0AJEA6eoi_DV4', 'One', 'Administrator', 'CleanWinnie', 'HUMAN RESOURCES', 1);
INSERT INTO `user` VALUES (43, 'winniethepooh', '$31$16$0E-IV1YGljLyX0ssCf1nEdpcwi3oXp5psoGwYOPJ5YI', 'Winnie', 'The Pooh', 'Aparte', 'RESIDENT', 1);
INSERT INTO `user` VALUES (44, 'repainman1', '$31$16$k43ROUoEPDROlNpQwtEwbEbNP5EfnST8jGOb3VpJKw0', 'my', 'name', 'Aparte', 'REPAIR PERSON', 1);
INSERT INTO `user` VALUES (45, 'aptadmin', '$31$16$yJ7KXy5IRu_YhNBY85QqUPfhYN7nRa_eIpocQ5be9WU', 'One', 'Administrator', 'Apartment', 'ADMIN', 1);
INSERT INTO `user` VALUES (46, 'andy', '$31$16$e7QgJ1ifL3Pfnu85KRzggKzfDPjIOTg95LGnJy7AVvE', 'Andy', 'Zhang', 'Apartment', 'RESIDENT', 1);
INSERT INTO `user` VALUES (47, 'liwang', '$31$16$WKmUJVt-C4qlcsfsVl9oSdfaAHwXo8xsEEn1JIpkHCE', 'Liwang', 'Chau', 'Apartment', 'REPAIR PERSON', 1);
INSERT INTO `user` VALUES (48, 'ccmpadmin', '$31$16$n4U79j5_p-EgNwFdrlB_COlR7e1iwSK2E8pUwPhfZRM', 'One', 'Administrator', 'CleaningCompany', 'HUMAN RESOURCES', 1);
INSERT INTO `user` VALUES (49, 'cleanerx', '$31$16$hnM1Jv7y5m_OApe7GchuQBpyqq_m9S2EvCsK0x3rJBo', 'X', 'Cleaner', 'CleaningCompany', 'CLEANER', 1);
COMMIT;

-- ----------------------------
-- Table structure for workrequest
-- ----------------------------
DROP TABLE IF EXISTS `workrequest`;
CREATE TABLE `workrequest` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `taskid` int(255) DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `message` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sender` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `receiver` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `isread` tinyint(1) DEFAULT '0',
  `requesttime` datetime(6) DEFAULT NULL,
  `readtime` datetime(6) DEFAULT NULL,
  `state` int(2) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `task` (`taskid`),
  KEY `senders` (`sender`),
  KEY `receivers` (`receiver`),
  CONSTRAINT `receivers` FOREIGN KEY (`receiver`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `senders` FOREIGN KEY (`sender`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `task` FOREIGN KEY (`taskid`) REFERENCES `task` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of workrequest
-- ----------------------------
BEGIN;
INSERT INTO `workrequest` VALUES (1, 43, 'Apt123 Repair', '123', 'aptadmin1', 'john1', 0, '2019-12-06 19:29:55.369000', NULL, 0);
INSERT INTO `workrequest` VALUES (2, 44, 'Apt123 Repair', '123', 'aptadmin1', 'john1', 0, '2019-12-06 19:34:35.296000', NULL, 0);
INSERT INTO `workrequest` VALUES (3, 48, 'Apt510a Repair', '123dafs asd', 'LPadmin1', 'PeterL', 0, '2019-12-07 13:18:29.080000', NULL, 1);
INSERT INTO `workrequest` VALUES (4, 45, 'Aptapt312 Repair', 'no', 'LPadmin1', 'Johnson', 0, '2019-12-07 13:20:09.547000', NULL, 1);
INSERT INTO `workrequest` VALUES (5, 49, 'Apt510a Cleaning', '!@#$%$^!@!#%$', 'LPadmin1', 'LPadmin', 1, '2019-12-07 13:20:27.362000', '2019-12-07 13:27:01.531000', 0);
INSERT INTO `workrequest` VALUES (6, 47, 'Apt312 Cleaning', '123', 'LPadmin1', 'PGadmin', 0, '2019-12-07 13:20:40.342000', NULL, 1);
INSERT INTO `workrequest` VALUES (7, 49, 'Apt510a Cleaning', '!@#$%$^!@!#%$', 'LPadmin', 'Joe', 0, '2019-12-07 13:27:01.424000', NULL, 0);
INSERT INTO `workrequest` VALUES (8, 50, 'Apt123 Repair', '23', 'aptadmin1', 'carrielam', 1, '2019-12-07 14:03:34.054000', '2019-12-07 14:04:14.767000', 0);
INSERT INTO `workrequest` VALUES (9, 50, 'Apt123 Repair', '23', 'carrielam', 'aptadmin1', 1, '2019-12-07 14:04:20.624000', '2019-12-07 14:04:44.874000', 0);
INSERT INTO `workrequest` VALUES (10, 29, 'Apt12313 Repair', '123123', 'amyadmin1', 'amylynn', 0, '2019-12-07 16:12:12.063000', NULL, 0);
INSERT INTO `workrequest` VALUES (11, 51, 'Apt89 Cleaning', 'None', 'aptadmin1', 'ecladmin', 0, '2019-12-07 16:20:42.530000', NULL, 0);
INSERT INTO `workrequest` VALUES (12, 52, 'Apt35 Cleaning', 'dfs', 'aptadmin1', '1234admin', 1, '2019-12-07 16:25:34.043000', '2019-12-07 16:27:51.751000', 0);
INSERT INTO `workrequest` VALUES (13, 52, 'Apt35 Cleaning', 'dfs', '1234admin', 'dood', 1, '2019-12-07 16:27:51.155000', '2019-12-07 16:28:14.786000', 0);
INSERT INTO `workrequest` VALUES (14, 52, 'Apt35 Cleaning', 'dfs', 'dood', '1234admin', 1, '2019-12-07 16:28:19.823000', '2019-12-07 16:29:09.396000', 1);
INSERT INTO `workrequest` VALUES (20, 53, 'Apt102 Repair', 'no', 'aptadmin2', 'repainman1', 1, '2019-12-07 17:53:07.531000', '2019-12-07 17:55:01.577000', 0);
INSERT INTO `workrequest` VALUES (21, 54, 'Apt123 Repair', '123', 'aptadmin2', 'repainman1', 1, '2019-12-07 17:54:28.739000', '2019-12-07 17:54:52.906000', 0);
INSERT INTO `workrequest` VALUES (22, 56, 'Apt123 Repair', '234', 'aptadmin2', 'repainman1', 1, '2019-12-07 17:56:51.380000', '2019-12-07 18:03:30.617000', 1);
INSERT INTO `workrequest` VALUES (23, 55, 'Apt123 Repair', '123', 'aptadmin2', 'repainman1', 1, '2019-12-07 17:57:01.711000', '2019-12-07 18:03:16.350000', 0);
INSERT INTO `workrequest` VALUES (24, 54, 'Apt123 Repair', '123', 'repainman1', 'aptadmin2', 0, '2019-12-07 18:03:06.298000', NULL, 1);
INSERT INTO `workrequest` VALUES (25, 53, 'Apt102 Repair', 'no', 'repainman1', 'aptadmin2', 0, '2019-12-07 18:03:11.939000', NULL, 1);
INSERT INTO `workrequest` VALUES (26, 55, 'Apt123 Repair', '123', 'repainman1', 'aptadmin2', 0, '2019-12-07 18:03:26.838000', NULL, 1);
INSERT INTO `workrequest` VALUES (27, 57, 'Apt213 Repair', '1234', 'aptadmin2', 'repainman1', 0, '2019-12-07 18:04:45.136000', NULL, 1);
INSERT INTO `workrequest` VALUES (28, 58, 'Apt99 Repair', 'Air Conditioner Issues', 'aptadmin', 'liwang', 1, '2019-12-07 18:58:25.615000', '2019-12-07 18:59:37.499000', 0);
INSERT INTO `workrequest` VALUES (29, 58, 'Apt99 Repair', 'Air Conditioner Issues', 'liwang', 'aptadmin', 1, '2019-12-07 19:01:56.647000', '2019-12-07 19:03:15.098000', 1);
INSERT INTO `workrequest` VALUES (30, 59, 'Apt99 Cleaning', 'House need to clean', 'aptadmin', 'ccmpadmin', 1, '2019-12-07 19:11:32.524000', '2019-12-07 19:15:08.666000', 1);
INSERT INTO `workrequest` VALUES (31, 59, 'Apt99 Cleaning', 'House need to clean', 'ccmpadmin', 'cleanerx', 1, '2019-12-07 19:15:08.346000', '2019-12-07 19:15:37.045000', 0);
INSERT INTO `workrequest` VALUES (32, 59, 'Apt99 Cleaning', 'House need to clean', 'cleanerx', 'ccmpadmin', 1, '2019-12-07 19:18:12.582000', '2019-12-07 19:22:34.924000', 1);
INSERT INTO `workrequest` VALUES (33, 59, 'Apt99 Cleaning', 'House need to clean', 'ccmpadmin', 'aptadmin', 1, '2019-12-07 19:22:35.011000', '2019-12-07 19:24:57.424000', 1);
COMMIT;

-- ----------------------------
-- View structure for view_taskcompany
-- ----------------------------
DROP VIEW IF EXISTS `view_taskcompany`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_taskcompany` AS select `task`.`id` AS `taskid`,`task`.`title` AS `title`,`task`.`message` AS `message`,`task`.`creator` AS `creator`,`user`.`companyname` AS `company`,`task`.`status` AS `status` from (`task` join `user` on((`task`.`creator` = `user`.`username`))) where (`task`.`state` = 1);

SET FOREIGN_KEY_CHECKS = 1;
