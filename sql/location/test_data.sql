-- test_data.sql 最终版本
USE location;

-- ============================================
-- 第1步：清空所有数据
-- ============================================
DROP PROCEDURE IF EXISTS GenerateGPSDataFinal;
DROP TEMPORARY TABLE IF EXISTS temp_device_ids;

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE coordinate_info;
TRUNCATE TABLE motion_info;
TRUNCATE TABLE satellite_info;
TRUNCATE TABLE gps_data;
TRUNCATE TABLE device_info;
SET FOREIGN_KEY_CHECKS = 1;

ALTER TABLE device_info AUTO_INCREMENT = 1;
ALTER TABLE gps_data AUTO_INCREMENT = 1;

-- ============================================
-- 第2步：插入设备信息
-- ============================================
INSERT INTO device_info (device_serial, name, description, report_interval, is_active, created_at)
VALUES
    ('GPS001', '车辆跟踪器-1', '安装在货车上的GPS跟踪器', 60, true, NOW() - INTERVAL 30 DAY),
    ('GPS002', '车辆跟踪器-2', '安装在客车上的GPS跟踪器', 30, true, NOW() - INTERVAL 25 DAY),
    ('GPS003', '无人机定位器', '农业无人机定位设备', 10, true, NOW() - INTERVAL 20 DAY),
    ('GPS004', '个人追踪器', '老年人安全追踪设备', 120, true, NOW() - INTERVAL 15 DAY),
    ('GPS005', '资产追踪器', '贵重物品追踪设备', 300, true, NOW() - INTERVAL 10 DAY),
    ('GPS006', '宠物追踪器', '宠物位置追踪项圈', 180, true, NOW() - INTERVAL 8 DAY),
    ('GPS007', '船舶定位器', '渔船位置追踪设备', 60, false, NOW() - INTERVAL 5 DAY),
    ('GPS008', '测试设备-1', '开发测试用设备', 5, true, NOW() - INTERVAL 3 DAY),
    ('GPS009', '测试设备-2', 'QA测试用设备', 5, true, NOW() - INTERVAL 2 DAY),
    ('GPS010', '备用设备', '备用追踪设备', 3600, false, NOW() - INTERVAL 1 DAY);

-- ============================================
-- 第3步：批量生成GPS数据
-- ============================================
DELIMITER $$

CREATE PROCEDURE GenerateGPSDataFinal()
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE dev_id INT;
    DECLARE gps_id INT;
    DECLARE base_lat DECIMAL(10, 6) DEFAULT 39.916527;  -- 纬度
    DECLARE base_lng DECIMAL(10, 6) DEFAULT 116.397128; -- 经度
    DECLARE rand_lat DECIMAL(10, 6);
    DECLARE rand_lng DECIMAL(10, 6);
    DECLARE data_time TIMESTAMP;

    WHILE i <= 100 DO
            -- 随机选择一个设备ID
            SELECT id INTO dev_id FROM device_info ORDER BY RAND() LIMIT 1;

            -- 随机生成时间（过去7天内）
            SET data_time = NOW() - INTERVAL FLOOR(RAND() * 7 * 24 * 60 * 60) SECOND;

            -- 插入 gps_data
            INSERT INTO gps_data (local_time, device_id, created_at)
            VALUES (data_time, dev_id, data_time);

            -- 获取最后插入的ID
            SET gps_id = LAST_INSERT_ID();

            -- 插入卫星信息
            INSERT INTO satellite_info (id, gps_satellites, bds_satellites, created_at)
            VALUES (
                       gps_id,
                       FLOOR(RAND() * 15) + 5,
                       FLOOR(RAND() * 10) + 3,
                       data_time
                   );

            -- 随机生成坐标（缩小范围避免越界）
            SET rand_lat = base_lat + (RAND() - 0.5) * 0.1;
            SET rand_lng = base_lng + (RAND() - 0.5) * 0.1;

            -- 插入坐标信息（修改：直接存储经纬度）
            INSERT INTO coordinate_info (id, altitude_m, altitude_agl, longitude, latitude, created_at)
            VALUES (
                       gps_id,
                       ROUND((RAND() * 2000) + 50, 3),
                       ROUND((RAND() * 2000) + 50, 3),
                       rand_lng,  -- 经度
                       rand_lat,  -- 纬度
                       data_time
                   );

            -- 插入运动信息
            INSERT INTO motion_info (id, speed_knots, speed_kmh, course_true, magnetic_variation, created_at)
            VALUES (
                       gps_id,
                       ROUND(RAND() * 80, 3),
                       ROUND(RAND() * 150, 3),
                       ROUND(RAND() * 360, 2),
                       ROUND((RAND() * 10) - 5, 2),
                       data_time
                   );

            -- 每25条输出一次进度
            IF i % 25 = 0 THEN
                SELECT CONCAT('已插入 ', i, ' 条数据') AS '进度';
            END IF;

            SET i = i + 1;
        END WHILE;

    SELECT '数据生成完成！共插入100条GPS数据。' AS '完成状态';
END$$

DELIMITER ;

-- 执行存储过程
CALL GenerateGPSDataFinal();

-- 删除存储过程
DROP PROCEDURE IF EXISTS GenerateGPSDataFinal;

-- ============================================
-- 第4步：查看和验证数据
-- ============================================

-- 查看坐标数据（修改后的查询）
SELECT
    g.id,
    d.device_serial,
    d.name as device_name,
    DATE_FORMAT(g.local_time, '%Y-%m-%d %H:%i:%s') as '时间',
    ROUND(c.altitude_m, 2) as '海拔_米',
    ROUND(m.speed_kmh, 2) as '速度_kmh',
    s.gps_satellites as 'GPS卫星数',
    s.bds_satellites as '北斗卫星数',
    CONCAT('经度:', ROUND(c.longitude, 6), ', 纬度:', ROUND(c.latitude, 6)) as '坐标'
FROM gps_data g
         JOIN device_info d ON g.device_id = d.id
         JOIN coordinate_info c ON g.id = c.id
         JOIN motion_info m ON g.id = m.id
         JOIN satellite_info s ON g.id = s.id
ORDER BY g.local_time DESC
LIMIT 10;

-- 验证外键约束（保持不变）
SELECT '设备数据完整性检查' as '检查项',
       CASE
           WHEN EXISTS (
               SELECT 1 FROM gps_data g
               WHERE NOT EXISTS (
                   SELECT 1 FROM device_info d WHERE d.id = g.device_id
               )
           ) THEN '❌ 存在无效设备ID'
           ELSE '✅ 设备外键正常'
           END as '状态'
UNION ALL
SELECT '坐标数据一对一检查',
       CASE
           WHEN EXISTS (
               SELECT 1 FROM gps_data g
               WHERE NOT EXISTS (
                   SELECT 1 FROM coordinate_info c WHERE c.id = g.id
               )
           ) THEN '❌ 缺少坐标数据'
           ELSE '✅ 坐标一对一正常'
           END
UNION ALL
SELECT '运动数据一对一检查',
       CASE
           WHEN EXISTS (
               SELECT 1 FROM gps_data g
               WHERE NOT EXISTS (
                   SELECT 1 FROM motion_info m WHERE m.id = g.id
               )
           ) THEN '❌ 缺少运动数据'
           ELSE '✅ 运动一对一正常'
           END
UNION ALL
SELECT '卫星数据一对一检查',
       CASE
           WHEN EXISTS (
               SELECT 1 FROM gps_data g
               WHERE NOT EXISTS (
                   SELECT 1 FROM satellite_info s WHERE s.id = g.id
               )
           ) THEN '❌ 缺少卫星数据'
           ELSE '✅ 卫星一对一正常'
           END;

-- 数据质量检查（修改）
SELECT
    '总记录数' as '检查项',
    COUNT(*) as '结果'
FROM gps_data
UNION ALL
SELECT '有坐标数据的记录数', COUNT(*) FROM coordinate_info
UNION ALL
SELECT '有运动数据的记录数', COUNT(*) FROM motion_info
UNION ALL
SELECT '有卫星数据的记录数', COUNT(*) FROM satellite_info
UNION ALL
SELECT '坐标数据质量',
       CASE
           WHEN COUNT(*) = (SELECT COUNT(*) FROM coordinate_info WHERE longitude IS NOT NULL AND latitude IS NOT NULL)
               THEN '✅ 经纬度数据完整'
           ELSE '❌ 经纬度数据缺失'
           END
FROM coordinate_info;