-- docs/dev-ops/mysql/sql/xfg-frame-archetype.sql

CREATE DATABASE IF NOT EXISTS `online-shopping-system` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

USE `online-shopping-system`;

-- ----------------------------
-- `employee` table for example
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `employee_number` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '雇员编号',
    `employee_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '雇员姓名',
    `employee_level` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '雇员级别',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uq_employee_number` (`employee_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='雇员表示例';

-- ----------------------------
-- `user` table
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
    `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uq_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户表';


-- ----------------------------
-- `product` table for our new feature
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `product_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '商品名称',
    `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商品描述',
    `price` decimal(10,2) unsigned NOT NULL COMMENT '商品价格',
    `stock` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '库存数量',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='商品表';