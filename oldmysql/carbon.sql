/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : carbon

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 21/10/2022 23:56:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goodsId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goodsName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsScore` float(10, 2) NULL DEFAULT NULL,
  `goodsPic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`goodsId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('g001', '环保书签', 145.00, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/good/bookmark.jpg');
INSERT INTO `goods` VALUES ('g002', '文创书签', 200.00, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/good/bookmark_1.jpg');
INSERT INTO `goods` VALUES ('g003', '竹筷', 130.00, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/good/chopsticks.jpg');
INSERT INTO `goods` VALUES ('g004', '冰箱贴', 160.00, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/good/fridge_magnet.jpg');
INSERT INTO `goods` VALUES ('g005', '钥匙扣', 130.00, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/good/key.jpg');
INSERT INTO `goods` VALUES ('g006', '环保灯', 220.00, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/good/lamp.jpg');
INSERT INTO `goods` VALUES ('g007', '手帕', 180.00, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/good/mocket.jpg');
INSERT INTO `goods` VALUES ('g008', '环保袋', 130.00, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/good/recycle_bog.jpg');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `transportation` float(10, 5) NULL DEFAULT 0.00000,
  `traffic` float(10, 5) NULL DEFAULT 0.00000,
  `eating` float(10, 2) NULL DEFAULT 0.00,
  `shopping` float(10, 5) NULL DEFAULT 0.00000,
  `sleeping` float(10, 2) NULL DEFAULT 0.00,
  `playing` float(10, 2) NULL DEFAULT 0.00,
  `answering` float(10, 2) NULL DEFAULT 0.00,
  `compensating` float(10, 2) NULL DEFAULT 0.00,
  `point` float(20, 2) NULL DEFAULT 0.00,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `user_id_score` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('0001', 0.00000, 2.04750, 8.10, 2.00000, 8.51, 1.22, 0.00, 0.00, -536.47);
INSERT INTO `score` VALUES ('1b7efa1a09fc49bca2eeb216f1eabfa4', 0.00000, 0.97500, 4.05, 1.00000, 7.51, 0.42, 0.00, 0.00, 648.21);
INSERT INTO `score` VALUES ('a5176ac0d560418ca20e910522aa8669', 130.00000, 0.00150, 4.05, 0.30170, 2.68, 0.80, 0.00, 0.00, 131.08);
INSERT INTO `score` VALUES ('e029d23bde384696a04b5187408e1e38', 0.00000, 0.97500, 4.05, 0.00000, 7.51, 0.42, 0.00, 0.00, 193.51);

-- ----------------------------
-- Table structure for tree
-- ----------------------------
DROP TABLE IF EXISTS `tree`;
CREATE TABLE `tree`  (
  `tree_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tree_name` varchar(202) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_time` datetime(6) NULL DEFAULT NULL,
  `efficient` float(20, 5) NULL DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tree_id`) USING BTREE,
  INDEX `user_id_tree`(`user_id`) USING BTREE,
  CONSTRAINT `user_id_tree` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tree
-- ----------------------------
INSERT INTO `tree` VALUES ('04db3bac759d4b3399e6cc21c856fca6', '7db0380fce1e4a3b9d4cce1831ade3fe', '栓皮栎', '2022-02-14 17:52:02.712000', 1.12300, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/栓皮栎.jpg');
INSERT INTO `tree` VALUES ('1d0be3fd223443beb9572808bf625ce5', '0001', '油松', '2022-02-14 16:37:56.214000', 0.87600, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/油松.jpg');
INSERT INTO `tree` VALUES ('25b7ebbe7cfa47c78d115b52bbf8b2ad', NULL, '白皮松', '2022-02-18 10:27:51.390000', 0.82200, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/白皮松.jpg');
INSERT INTO `tree` VALUES ('430ebdf0a09444f98f22ded565405af2', '0001', '栓皮栎', '2022-02-14 16:37:53.326000', 1.12300, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/栓皮栎.jpg');
INSERT INTO `tree` VALUES ('6729ff37705746179c73f6c4b1b755c6', NULL, '栓皮栎', '2022-02-18 10:28:07.638000', 1.12300, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/栓皮栎.jpg');
INSERT INTO `tree` VALUES ('6e4a12e31eaf455e8ce734652deb0a62', '0001', '白皮松', '2022-02-14 16:37:46.278000', 0.82200, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/白皮松.jpg');
INSERT INTO `tree` VALUES ('74fa6eb5048f40eabc56229e16636ed5', NULL, '油松', '2022-02-15 04:52:39.318000', 0.87600, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/油松.jpg');
INSERT INTO `tree` VALUES ('8510ee051f494753ad2f0641701d8b65', NULL, '油松', '2022-02-22 12:21:27.564000', 0.87600, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/油松.jpg');
INSERT INTO `tree` VALUES ('85509ab6a416486aad11cc7341f0f968', '7db0380fce1e4a3b9d4cce1831ade3fe', '油松', '2022-02-14 17:51:54.830000', 0.87600, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/油松.jpg');
INSERT INTO `tree` VALUES ('8c7f1c5857af455981f99966ae713685', NULL, '雄株毛白杨', '2022-02-14 17:59:36.427000', 1.37000, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/雄株毛白杨.jpg');
INSERT INTO `tree` VALUES ('b29422621758449d9c6a4862e1b62c77', NULL, '白皮松', '2022-02-15 04:52:36.701000', 0.82200, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/白皮松.jpg');
INSERT INTO `tree` VALUES ('b9955343915d4ed4b6d3994300efe500', NULL, '白皮松', '2022-02-14 17:59:28.220000', 0.82200, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/白皮松.jpg');
INSERT INTO `tree` VALUES ('bbae708eef314ff3b44a111b757336d1', '7db0380fce1e4a3b9d4cce1831ade3fe', '雄株毛白杨', '2022-02-14 17:51:52.544000', 1.37000, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/雄株毛白杨.jpg');
INSERT INTO `tree` VALUES ('beceed9b54ff44ea8ce5a430ac3bd699', '7db0380fce1e4a3b9d4cce1831ade3fe', '栓皮栎', '2022-02-14 17:51:57.834000', 1.12300, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/栓皮栎.jpg');
INSERT INTO `tree` VALUES ('c6933a7c6b7c4b95bb135aec30a247fb', NULL, '白皮松', '2022-02-22 12:21:24.075000', 0.82200, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/白皮松.jpg');
INSERT INTO `tree` VALUES ('ca1a1ab6d9694e62a16b89a0a1088775', NULL, '油松', '2022-02-14 17:59:34.071000', 0.87600, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/油松.jpg');
INSERT INTO `tree` VALUES ('cf69ae83af344531876c5de322d4ddff', '7db0380fce1e4a3b9d4cce1831ade3fe', '白皮松', '2022-02-14 17:51:48.398000', 0.82200, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/白皮松.jpg');
INSERT INTO `tree` VALUES ('da06e4d4c42c4a1282417f1d4c52bf80', NULL, '栓皮栎', '2022-02-14 17:59:30.735000', 1.12300, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/栓皮栎.jpg');
INSERT INTO `tree` VALUES ('e507c89ab7aa437693ae4fb60d7eeb01', NULL, '油松', '2022-02-18 10:28:12.200000', 0.87600, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/油松.jpg');
INSERT INTO `tree` VALUES ('f86ec42698194153a641ac32d8425561', '1b7efa1a09fc49bca2eeb216f1eabfa4', '白皮松', '2022-03-15 15:08:52.637000', 0.82200, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/白皮松.jpg');
INSERT INTO `tree` VALUES ('fe662754954547d293ccb9db55e9c145', '1b7efa1a09fc49bca2eeb216f1eabfa4', '栓皮栎', '2022-03-15 15:08:56.018000', 1.12300, 'cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/栓皮栎.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', '232417', '0001');
INSERT INTO `user` VALUES ('change', '123456', '1b7efa1a09fc49bca2eeb216f1eabfa4');
INSERT INTO `user` VALUES ('das', 'das', '2032fae9c33f4b2ebee815ebcdb4bdae');
INSERT INTO `user` VALUES ('hh', '123456', '717048f1ba50457687bfdce1a24284fc');
INSERT INTO `user` VALUES ('qq', '123456', '7db0380fce1e4a3b9d4cce1831ade3fe');
INSERT INTO `user` VALUES ('11', '111111', 'a5176ac0d560418ca20e910522aa8669');
INSERT INTO `user` VALUES ('ewqe', 'ewqe12', 'cbca426007524cc69ac85e0ac91a6635');
INSERT INTO `user` VALUES ('ww', '123456', 'cf346bfb164c42be9e6dc46e53ee1d16');
INSERT INTO `user` VALUES ('hello', '666', 'd29e7ef607914c62b6ea7bf378fbe83b');
INSERT INTO `user` VALUES ('hulianwang', '123456', 'e029d23bde384696a04b5187408e1e38');

SET FOREIGN_KEY_CHECKS = 1;
