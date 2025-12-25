-- test_shopping_data.sql（完整修复版）
-- 购物管理系统测试数据

USE shopping;

-- ============================================
-- 第1步：清空所有数据
-- ============================================
DROP PROCEDURE IF EXISTS GenerateOrderData;

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE `order`;
TRUNCATE TABLE address;
TRUNCATE TABLE product;
TRUNCATE TABLE user;
SET FOREIGN_KEY_CHECKS = 1;

ALTER TABLE user AUTO_INCREMENT = 1;
ALTER TABLE address AUTO_INCREMENT = 1;
ALTER TABLE product AUTO_INCREMENT = 1;

-- ============================================
-- 第2步：插入用户信息
-- ============================================
INSERT INTO user (username, nickname, password, email, phone, gender, birthday, is_active, created_at)
VALUES
    ('zhangsan', '张三', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iXgI8hC7GpFcH1Zk5U1V8bH1Vz2a', 'zhangsan@example.com', '13800138001', 1, '1990-05-15', true, NOW() - INTERVAL 365 DAY),
    ('lisi', '李四', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iXgI8hC7GpFcH1Zk5U1V8bH1Vz2a', 'lisi@example.com', '13800138002', 1, '1992-08-20', true, NOW() - INTERVAL 300 DAY),
    ('wangwu', '王五', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iXgI8hC7GpFcH1Zk5U1V8bH1Vz2a', 'wangwu@example.com', '13800138003', 1, '1988-03-10', true, NOW() - INTERVAL 250 DAY),
    ('zhaoliu', '赵六', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iXgI8hC7GpFcH1Zk5U1V8bH1Vz2a', 'zhaoliu@example.com', '13800138004', 1, '1995-11-25', true, NOW() - INTERVAL 200 DAY),
    ('xiaoming', '小明', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iXgI8hC7GpFcH1Zk5U1V8bH1Vz2a', 'xiaoming@example.com', '13800138005', 1, '2000-01-01', true, NOW() - INTERVAL 150 DAY),
    ('xiaohong', '小红', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iXgI8hC7GpFcH1Zk5U1V8bH1Vz2a', 'xiaohong@example.com', '13800138006', 2, '1998-07-12', true, NOW() - INTERVAL 100 DAY),
    ('admin', '管理员', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iXgI8hC7GpFcH1Zk5U1V8bH1Vz2a', 'admin@example.com', '13800138000', 0, '1985-12-01', true, NOW() - INTERVAL 400 DAY);

-- ============================================
-- 第3步：插入地址信息
-- ============================================
INSERT INTO address (user_id, name, phone, province, city, district, street, postal_code, is_default, tag, created_at)
VALUES
    (1, '张三', '13800138001', '北京市', '北京市', '朝阳区', '建国门外大街1号国贸大厦A座', '100004', 1, '公司', NOW() - INTERVAL 200 DAY),
    (1, '张三家人', '13800138011', '北京市', '北京市', '海淀区', '中关村大街1号', '100080', 0, '家', NOW() - INTERVAL 180 DAY),
    (2, '李四', '13800138002', '上海市', '上海市', '浦东新区', '陆家嘴环路100号', '200120', 1, '公司', NOW() - INTERVAL 150 DAY),
    (3, '王五', '13800138003', '广东省', '广州市', '天河区', '体育西路1号', '510620', 1, '家', NOW() - INTERVAL 120 DAY),
    (4, '赵六', '13800138004', '浙江省', '杭州市', '西湖区', '文三路1号', '310012', 1, '公司', NOW() - INTERVAL 90 DAY),
    (5, '小明', '13800138005', '江苏省', '南京市', '鼓楼区', '中山路1号', '210008', 1, '家', NOW() - INTERVAL 60 DAY),
    (6, '小红', '13800138006', '四川省', '成都市', '锦江区', '春熙路1号', '610016', 1, '家', NOW() - INTERVAL 30 DAY),
    (6, '小红公司', '13800138006', '四川省', '成都市', '高新区', '天府大道1号', '610041', 0, '公司', NOW() - INTERVAL 15 DAY);

-- ============================================
-- 第4步：插入商品信息
-- ============================================
INSERT INTO product (product_name, description, price, stock, status, sales_count, created_at)
VALUES
    ('iPhone 15 Pro', '苹果最新款智能手机，A17 Pro芯片，钛金属边框', 8999.00, 100, 1, 0, NOW() - INTERVAL 180 DAY),
    ('MacBook Air M2', '13.6英寸 Liquid 视网膜显示屏，M2芯片', 8999.00, 50, 1, 0, NOW() - INTERVAL 160 DAY),
    ('华为 Mate 60 Pro', '华为旗舰手机，卫星通话功能', 6999.00, 200, 1, 0, NOW() - INTERVAL 140 DAY),
    ('小米 14 Pro', '徕卡光学镜头，骁龙8 Gen 3处理器', 4999.00, 150, 1, 0, NOW() - INTERVAL 120 DAY),
    ('戴尔 XPS 13', '13.4英寸 InfinityEdge 触控屏', 8999.00, 30, 1, 0, NOW() - INTERVAL 100 DAY),
    ('索尼 PlayStation 5', '次世代游戏主机，支持4K游戏', 3899.00, 80, 1, 0, NOW() - INTERVAL 80 DAY),
    ('任天堂 Switch OLED', '7英寸OLED屏幕，增强版支架', 2399.00, 60, 1, 0, NOW() - INTERVAL 60 DAY),
    ('佳能 EOS R6 Mark II', '全画幅专业微单相机', 15999.00, 20, 1, 0, NOW() - INTERVAL 40 DAY),
    ('Bose QuietComfort 45', '无线降噪耳机，超长续航', 2299.00, 100, 1, 0, NOW() - INTERVAL 30 DAY),
    ('罗技 MX Master 3S', '无线蓝牙鼠标，精准追踪', 699.00, 200, 1, 0, NOW() - INTERVAL 20 DAY),
    ('三星 980 PRO SSD 1TB', 'PCIe 4.0 NVMe M.2 固态硬盘', 799.00, 150, 1, 0, NOW() - INTERVAL 15 DAY),
    ('小米手环 8 Pro', '1.74英寸AMOLED大屏，多功能运动监测', 399.00, 300, 1, 0, NOW() - INTERVAL 10 DAY),
    ('华为 Watch GT 4', '1.43英寸AMOLED屏，两周续航', 1488.00, 120, 1, 0, NOW() - INTERVAL 5 DAY),
    ('Kindle Paperwhite', '6.8英寸电子墨水屏，防水设计', 998.00, 80, 0, 0, NOW() - INTERVAL 200 DAY); -- 下架商品

-- ============================================
-- 第5步：批量生成订单数据（存储过程 - 修复版）
-- ============================================
DELIMITER $$

CREATE PROCEDURE GenerateOrderData()
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE user_id_val INT UNSIGNED;
    DECLARE address_id_val INT UNSIGNED;
    DECLARE product_id_val INT UNSIGNED;
    DECLARE order_time TIMESTAMP;
    DECLARE order_id_str VARCHAR(32);
    DECLARE product_price DECIMAL(10,2);
    DECLARE product_quantity INT UNSIGNED;
    DECLARE shipping_fee_val DECIMAL(10,2);
    DECLARE order_status_val TINYINT(1);
    DECLARE payment_method_val VARCHAR(20);
    DECLARE payment_time_val TIMESTAMP;

    -- 使用事务确保数据一致性
    START TRANSACTION;

    -- 先清空订单表
    SET FOREIGN_KEY_CHECKS = 0;
    TRUNCATE TABLE `order`;
    SET FOREIGN_KEY_CHECKS = 1;

    -- 重置商品销量为0
    UPDATE product SET sales_count = 0;

    WHILE i <= 50 DO
            -- 随机选择用户
            SELECT id INTO user_id_val FROM user ORDER BY RAND() LIMIT 1;

            -- 随机选择该用户的地址
            SELECT id INTO address_id_val FROM address WHERE user_id = user_id_val ORDER BY RAND() LIMIT 1;

            -- 随机选择商品
            SELECT id, price INTO product_id_val, product_price FROM product WHERE status = 1 ORDER BY RAND() LIMIT 1;

            -- 随机生成订单时间（过去30天内）
            SET order_time = NOW() - INTERVAL FLOOR(RAND() * 30 * 24 * 60 * 60) SECOND;

            -- 修复：使用更可靠的订单号生成方法
            -- 格式：年月日时分秒 + 微秒部分 + 序号
            SET order_id_str = CONCAT(
                    DATE_FORMAT(order_time, '%Y%m%d%H%i%s'),
                    LPAD(FLOOR(RAND() * 1000), 3, '0'),
                    LPAD(i, 3, '0')
                               );

            -- 随机生成购买数量（1-3个）
            SET product_quantity = FLOOR(RAND() * 3) + 1;

            -- 随机生成运费（0-20元）
            SET shipping_fee_val = ROUND(RAND() * 20, 2);

            -- 随机生成订单状态（加权概率：已完成最多，待付款最少）
            SET order_status_val = CASE
                                       WHEN RAND() < 0.5 THEN 3  -- 已完成 50%
                                       WHEN RAND() < 0.7 THEN 2  -- 已发货 20%
                                       WHEN RAND() < 0.85 THEN 1 -- 待发货 15%
                                       WHEN RAND() < 0.95 THEN 4 -- 已取消 10%
                                       ELSE 0                    -- 待付款 5%
                END;

            -- 根据订单状态确定支付方式和支付时间
            IF order_status_val IN (1, 2, 3) THEN
                -- 已支付的订单
                SET payment_method_val = CASE FLOOR(RAND() * 4)
                                             WHEN 0 THEN '支付宝'
                                             WHEN 1 THEN '微信支付'
                                             WHEN 2 THEN '银行卡'
                                             ELSE '余额支付'
                    END;
                -- 支付时间在订单创建后1小时内
                SET payment_time_val = order_time + INTERVAL FLOOR(RAND() * 3600) SECOND;
            ELSE
                SET payment_method_val = NULL;
                SET payment_time_val = NULL;
            END IF;

            -- 插入订单数据
            INSERT INTO `order` (
                id, user_id, address_id, product_id, price, quantity,
                total_amount, shipping_fee, pay_amount,
                order_status, payment_method, payment_time,
                created_at, updated_at
            ) VALUES (
                         order_id_str,
                         user_id_val,
                         address_id_val,
                         product_id_val,
                         product_price,
                         product_quantity,
                         -- total_amount = 价格×数量 + 运费
                         ROUND(product_price * product_quantity + shipping_fee_val, 2),
                         shipping_fee_val,
                         -- pay_amount = total_amount（简化，不考虑优惠）
                         ROUND(product_price * product_quantity + shipping_fee_val, 2),
                         order_status_val,
                         payment_method_val,
                         payment_time_val,
                         order_time,
                         order_time
                     );

            -- 更新商品销量（仅统计已发货和已完成的订单）
            IF order_status_val IN (1, 2, 3) THEN
                UPDATE product
                SET sales_count = sales_count + product_quantity
                WHERE id = product_id_val;
            END IF;

            -- 每10条输出一次进度
            IF i % 10 = 0 THEN
                SELECT CONCAT('已插入 ', i, ' 条订单数据') AS '进度';
            END IF;

            SET i = i + 1;
        END WHILE;

    COMMIT;

    SELECT '订单数据生成完成！共插入50条订单数据。' AS '完成状态';
END$$

DELIMITER ;

-- 执行存储过程生成订单数据
CALL GenerateOrderData();

-- 删除存储过程
DROP PROCEDURE IF EXISTS GenerateOrderData;

-- ============================================
-- 第6步：查看和验证数据
-- ============================================

-- 查看用户数据
SELECT '用户数据统计' AS '检查项', COUNT(*) AS '数量' FROM user
UNION ALL
SELECT '地址数据统计', COUNT(*) FROM address
UNION ALL
SELECT '商品数据统计', COUNT(*) FROM product
UNION ALL
SELECT '订单数据统计', COUNT(*) FROM `order`;

-- 查看用户详情
SELECT
    id, username, nickname, email, phone,
    CASE gender
        WHEN 0 THEN '未知'
        WHEN 1 THEN '男'
        WHEN 2 THEN '女'
        END AS gender,
    birthday, is_active,
    DATE_FORMAT(created_at, '%Y-%m-%d') as 注册时间
FROM user
ORDER BY id;

-- 查看商品详情（包含更新后的销量）
SELECT
    id, product_name,
    CONCAT('¥', FORMAT(price, 2)) as 价格,
    stock as 库存,
    sales_count as 销量,
    CASE status
        WHEN 0 THEN '下架'
        WHEN 1 THEN '上架'
        END AS 状态,
    DATE_FORMAT(created_at, '%Y-%m-%d') as 上架时间
FROM product
ORDER BY sales_count DESC
LIMIT 10;

-- 查看订单详情
SELECT
    o.id as 订单号,
    u.username as 用户名,
    p.product_name as 商品名称,
    o.quantity as 数量,
    CONCAT('¥', FORMAT(o.price, 2)) as 单价,
    CONCAT('¥', FORMAT(o.total_amount, 2)) as 总金额,
    CONCAT('¥', FORMAT(o.shipping_fee, 2)) as 运费,
    CONCAT('¥', FORMAT(o.pay_amount, 2)) as 实付金额,
    CASE o.order_status
        WHEN 0 THEN '待付款'
        WHEN 1 THEN '待发货'
        WHEN 2 THEN '已发货'
        WHEN 3 THEN '已完成'
        WHEN 4 THEN '已取消'
        END AS 订单状态,
    o.payment_method as 支付方式,
    DATE_FORMAT(o.created_at, '%Y-%m-%d %H:%i') as 下单时间,
    DATE_FORMAT(o.payment_time, '%Y-%m-%d %H:%i') as 支付时间
FROM `order` o
         JOIN user u ON o.user_id = u.id
         JOIN product p ON o.product_id = p.id
ORDER BY o.created_at DESC
LIMIT 10;

-- 查看订单状态分布
SELECT
    CASE order_status
        WHEN 0 THEN '待付款'
        WHEN 1 THEN '待发货'
        WHEN 2 THEN '已发货'
        WHEN 3 THEN '已完成'
        WHEN 4 THEN '已取消'
        END AS 订单状态,
    COUNT(*) as 订单数量,
    CONCAT(ROUND(COUNT(*) * 100.0 / (SELECT COUNT(*) FROM `order`), 1), '%') as 占比
FROM `order`
GROUP BY order_status
ORDER BY order_status;

-- 查看用户订单统计
SELECT
    u.username as 用户名,
    u.nickname as 昵称,
    COUNT(o.id) as 订单总数,
    SUM(CASE WHEN o.order_status = 3 THEN 1 ELSE 0 END) as 已完成订单,
    SUM(CASE WHEN o.order_status = 0 THEN 1 ELSE 0 END) as 待付款订单,
    CONCAT('¥', FORMAT(SUM(o.pay_amount), 2)) as 总消费金额
FROM user u
         LEFT JOIN `order` o ON u.id = o.user_id
GROUP BY u.id, u.username, u.nickname
HAVING 订单总数 > 0
ORDER BY SUM(o.pay_amount) DESC;

-- 查看商品销售排行
SELECT
    p.product_name as 商品名称,
    COUNT(o.id) as 销售订单数,
    SUM(o.quantity) as 销售总数量,
    CONCAT('¥', FORMAT(SUM(o.pay_amount), 2)) as 销售总额,
    p.stock as 当前库存,
    CONCAT(ROUND(SUM(o.quantity) * 100.0 / p.stock, 1), '%') as 库存销售比
FROM product p
         LEFT JOIN `order` o ON p.id = o.product_id AND o.order_status IN (1, 2, 3)
GROUP BY p.id, p.product_name, p.stock
HAVING 销售订单数 > 0
ORDER BY 销售总额 DESC
LIMIT 10;

-- 数据完整性检查
SELECT '用户数据完整性' as '检查项',
       CASE
           WHEN COUNT(*) = (SELECT COUNT(*) FROM user WHERE username IS NOT NULL AND password IS NOT NULL)
               THEN '✅ 用户数据完整'
           ELSE '❌ 用户数据有缺失'
           END as '状态'
FROM user
UNION ALL
SELECT '商品数据完整性',
       CASE
           WHEN COUNT(*) = (SELECT COUNT(*) FROM product WHERE product_name IS NOT NULL AND price >= 0)
               THEN '✅ 商品数据完整'
           ELSE '❌ 商品数据有缺失'
           END
FROM product
UNION ALL
SELECT '订单数据完整性',
       CASE
           WHEN COUNT(*) = (SELECT COUNT(*) FROM `order` WHERE user_id IS NOT NULL AND product_id IS NOT NULL)
               THEN '✅ 订单数据完整'
           ELSE '❌ 订单数据有缺失'
           END
FROM `order`
UNION ALL
SELECT '外键约束检查-订单用户',
       CASE
           WHEN EXISTS (
               SELECT 1 FROM `order` o
               WHERE NOT EXISTS (SELECT 1 FROM user u WHERE u.id = o.user_id)
           ) THEN '❌ 存在无效用户ID'
           ELSE '✅ 订单用户外键正常'
           END
UNION ALL
SELECT '外键约束检查-订单商品',
       CASE
           WHEN EXISTS (
               SELECT 1 FROM `order` o
               WHERE NOT EXISTS (SELECT 1 FROM product p WHERE p.id = o.product_id)
           ) THEN '❌ 存在无效商品ID'
           ELSE '✅ 订单商品外键正常'
           END
UNION ALL
SELECT '外键约束检查-订单地址',
       CASE
           WHEN EXISTS (
               SELECT 1 FROM `order` o
               WHERE NOT EXISTS (SELECT 1 FROM address a WHERE a.id = o.address_id)
           ) THEN '❌ 存在无效地址ID'
           ELSE '✅ 订单地址外键正常'
           END;

-- 生成测试完成提示
SELECT '====================================' AS '';
SELECT '购物管理系统测试数据生成完成！' AS '状态';
SELECT '====================================' AS '';
SELECT CONCAT('共生成 ', (SELECT COUNT(*) FROM user), ' 条用户数据') AS '数据统计';
SELECT CONCAT('共生成 ', (SELECT COUNT(*) FROM address), ' 条地址数据') AS '';
SELECT CONCAT('共生成 ', (SELECT COUNT(*) FROM product), ' 条商品数据') AS '';
SELECT CONCAT('共生成 ', (SELECT COUNT(*) FROM `order`), ' 条订单数据') AS '';
SELECT '====================================' AS '';