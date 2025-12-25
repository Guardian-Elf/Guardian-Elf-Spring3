-- create_shopping_db.sql
-- 购物管理系统数据库

-- 创建数据库
Drop DATABASE IF EXISTS shopping;

CREATE DATABASE IF NOT EXISTS shopping DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE shopping;

-- 1. 用户信息表
CREATE TABLE user
(
    id         INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID',
    username   VARCHAR(50) UNIQUE NOT NULL COMMENT '用户名（唯一）',
    nickname   VARCHAR(50) COMMENT '用户昵称',
    password   VARCHAR(255) NOT NULL COMMENT '加密后的密码',
    email      VARCHAR(100) UNIQUE COMMENT '邮箱（唯一）',
    phone      VARCHAR(20) COMMENT '手机号',
    gender     TINYINT(1) DEFAULT 0 COMMENT '性别(0:未知 1:男 2:女)',
    birthday   DATE COMMENT '生日',
    is_active  BOOLEAN DEFAULT TRUE COMMENT '账户状态',
    last_login TIMESTAMP COMMENT '最后登录时间',
    login_ip   VARCHAR(45) COMMENT '最后登录IP',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '用户信息表';

-- 2. 地址表
CREATE TABLE address
(
    id          INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '地址ID',
    user_id     INT UNSIGNED NOT NULL COMMENT '用户ID',
    name        VARCHAR(50) NOT NULL COMMENT '收货人姓名',
    phone       VARCHAR(20) NOT NULL COMMENT '联系电话',
    province    VARCHAR(50) NOT NULL COMMENT '省份',
    city        VARCHAR(50) NOT NULL COMMENT '城市',
    district    VARCHAR(50) NOT NULL COMMENT '区县',
    street      VARCHAR(255) NOT NULL COMMENT '详细地址',
    postal_code VARCHAR(10) COMMENT '邮政编码',
    is_default  TINYINT(1) DEFAULT 0 COMMENT '是否默认(0:否 1:是)',
    tag         VARCHAR(20) COMMENT '标签(家/公司/学校)',
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE
) COMMENT = '地址表';

-- 3. 商品表
CREATE TABLE product
(
    id           INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '商品ID',
    product_name VARCHAR(200) NOT NULL COMMENT '商品名称',
    description  TEXT COMMENT '商品描述',
    price        DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '价格',
    stock        INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '库存',
    status       TINYINT(1) NOT NULL DEFAULT 1 COMMENT '状态(0:下架 1:上架)',
    sales_count  INT UNSIGNED DEFAULT 0 COMMENT '销量',
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT = '商品表';

-- 4. 订单表（注意：order是MySQL关键字，需要特殊处理）
CREATE TABLE `order`
(
    id              VARCHAR(32) PRIMARY KEY COMMENT '订单号（唯一）',
    user_id         INT UNSIGNED NOT NULL COMMENT '用户ID',
    address_id      INT UNSIGNED NOT NULL COMMENT '地址ID',
    product_id      INT UNSIGNED NOT NULL COMMENT '商品ID',
    price           DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '价格',
    quantity        INT UNSIGNED NOT NULL DEFAULT 1 COMMENT '购买数量',
    total_amount    DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '订单总金额',
    shipping_fee    DECIMAL(10,2) DEFAULT 0.00 COMMENT '运费',
    pay_amount      DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '实付金额',
    order_status    TINYINT(1) NOT NULL DEFAULT 0 COMMENT '订单状态(0:待付款 1:待发货 2:已发货 3:已完成 4:已取消)',
    payment_method  VARCHAR(20) COMMENT '支付方式',
    payment_time    TIMESTAMP COMMENT '支付时间',
    shipping_time   TIMESTAMP COMMENT '发货时间',
    receive_time    TIMESTAMP COMMENT '收货时间',
    cancel_time     TIMESTAMP COMMENT '取消时间',
    user_note       VARCHAR(500) COMMENT '用户备注',
    invoice_needed  TINYINT(1) DEFAULT 0 COMMENT '是否需要发票(0:否 1:是)',
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE,
    FOREIGN KEY (address_id) REFERENCES address (id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE
) COMMENT = '订单表';

-- ============================================
-- 创建索引
-- ============================================

-- 用户表索引
CREATE INDEX idx_user_username ON user (username);
CREATE INDEX idx_user_email ON user (email);
CREATE INDEX idx_user_phone ON user (phone);
CREATE INDEX idx_user_active ON user (is_active);
CREATE INDEX idx_user_created ON user (created_at);

-- 地址表索引
CREATE INDEX idx_address_user ON address (user_id);
CREATE INDEX idx_address_default ON address (user_id, is_default);
CREATE INDEX idx_address_created ON address (created_at);

-- 商品表索引
CREATE INDEX idx_product_name ON product (product_name);
CREATE INDEX idx_product_status ON product (status);
CREATE INDEX idx_product_price ON product (price);
CREATE INDEX idx_product_sales ON product (sales_count);
CREATE INDEX idx_product_created ON product (created_at);

-- 订单表索引
CREATE INDEX idx_order_user ON `order` (user_id);
CREATE INDEX idx_order_product ON `order` (product_id);
CREATE INDEX idx_order_status ON `order` (order_status);
CREATE INDEX idx_order_created ON `order` (created_at);
CREATE INDEX idx_order_user_status ON `order` (user_id, order_status);
CREATE INDEX idx_order_payment_time ON `order` (payment_time);
