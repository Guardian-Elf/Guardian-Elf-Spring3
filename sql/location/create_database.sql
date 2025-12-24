-- create_database.sql
-- 精简版 - 适配若依框架风格

-- 创建数据库
Drop DATABASE IF EXISTS location;

CREATE DATABASE IF NOT EXISTS location DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE location;

-- 设备信息表
CREATE TABLE device_info
(
    id              INT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    device_serial   VARCHAR(50) UNIQUE NOT NULL COMMENT '设备序列号',
    name            VARCHAR(50)        NOT NULL COMMENT '设备名称',
    description     TEXT               NOT NULL COMMENT '设备描述',
    report_interval INT CHECK (report_interval > 0) COMMENT '上报间隔(秒)',
    is_active       BOOLEAN   DEFAULT TRUE COMMENT '状态(0禁用 1正常)',
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    last_seen_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '最后通信时间'
) COMMENT = '设备信息表';

-- GPS数据主表
CREATE TABLE gps_data
(
    id         INT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    local_time TIMESTAMP NOT NULL COMMENT '设备时间',
    device_id  INT       NOT NULL COMMENT '设备ID',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',

    FOREIGN KEY (device_id) REFERENCES device_info (id) ON DELETE CASCADE
) COMMENT = 'GPS数据表';

-- 卫星信息表
CREATE TABLE satellite_info
(
    id             INT PRIMARY KEY COMMENT 'GPS数据ID',
    gps_satellites TINYINT CHECK (gps_satellites BETWEEN 0 AND 99) COMMENT 'GPS卫星数',
    bds_satellites TINYINT CHECK (bds_satellites BETWEEN 0 AND 99) COMMENT '北斗卫星数',
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',

    FOREIGN KEY (id) REFERENCES gps_data (id) ON DELETE CASCADE
) COMMENT = '卫星信息表';

-- 坐标信息表（修改：将POINT类型拆分为经纬度字段）
CREATE TABLE coordinate_info
(
    id           INT PRIMARY KEY COMMENT 'GPS数据ID',
    altitude_m   DECIMAL(7, 3) COMMENT '海拔(米)',
    altitude_agl DECIMAL(7, 3) COMMENT '相对高度(米)',
    longitude    DECIMAL(10, 6) NOT NULL COMMENT '经度',
    latitude     DECIMAL(10, 6) NOT NULL COMMENT '纬度',
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',

    FOREIGN KEY (id) REFERENCES gps_data (id) ON DELETE CASCADE
) COMMENT = '坐标信息表';

-- 运动信息表
CREATE TABLE motion_info
(
    id                 INT PRIMARY KEY COMMENT 'GPS数据ID',
    speed_knots        DECIMAL(6, 3) CHECK (speed_knots >= 0) COMMENT '速度(节)',
    speed_kmh          DECIMAL(6, 3) CHECK (speed_kmh >= 0) COMMENT '速度(km/h)',
    course_true        DECIMAL(5, 2) CHECK (course_true BETWEEN 0 AND 360) COMMENT '真北航向',
    magnetic_variation DECIMAL(5, 2) CHECK (magnetic_variation BETWEEN -180 AND 180) COMMENT '磁偏角',
    created_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',

    FOREIGN KEY (id) REFERENCES gps_data (id) ON DELETE CASCADE
) COMMENT = '运动信息表';

-- 设备表索引
CREATE INDEX idx_device_serial ON device_info (device_serial);
CREATE INDEX idx_device_active ON device_info (is_active);

-- GPS数据表索引
CREATE INDEX idx_gps_time ON gps_data (local_time);
CREATE INDEX idx_gps_device ON gps_data (device_id);
CREATE INDEX idx_gps_created ON gps_data (created_at);
CREATE INDEX idx_device_time ON gps_data (device_id, local_time);

-- 坐标表索引（添加经纬度索引）
CREATE INDEX idx_coordinate_lon_lat ON coordinate_info (longitude, latitude);


-- 环境数据表 (environment_data) - 适配现有结构
CREATE TABLE environment_data
(
    id            INT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    device_id     INT      NOT NULL COMMENT '设备ID',
    illuminance   FLOAT DEFAULT NULL COMMENT '光照强度(lux)',
    temperature   FLOAT DEFAULT NULL COMMENT '温度(°C)',
    humidity      FLOAT DEFAULT NULL COMMENT '湿度(%)',
    pressure      FLOAT DEFAULT NULL COMMENT '气压(hPa)',
    local_time    TIMESTAMP NOT NULL COMMENT '设备时间',
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',

    FOREIGN KEY (device_id) REFERENCES device_info (id) ON DELETE CASCADE,
    INDEX idx_env_device_time (device_id, local_time),
    INDEX idx_env_created_at (created_at)
) COMMENT = '环境数据表';

-- 运动数据表 (speed_data)
CREATE TABLE speed_data
(
    id            INT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    device_id     INT      NOT NULL COMMENT '设备ID',
    accel_x       FLOAT DEFAULT NULL COMMENT '加速度X轴(g)',
    accel_y       FLOAT DEFAULT NULL COMMENT '加速度Y轴(g)',
    accel_z       FLOAT DEFAULT NULL COMMENT '加速度Z轴(g)',
    gyro_x        FLOAT DEFAULT NULL COMMENT '陀螺仪X轴(°/s)',
    gyro_y        FLOAT DEFAULT NULL COMMENT '陀螺仪Y轴(°/s)',
    gyro_z        FLOAT DEFAULT NULL COMMENT '陀螺仪Z轴(°/s)',
    local_time    TIMESTAMP NOT NULL COMMENT '设备时间',
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',

    FOREIGN KEY (device_id) REFERENCES device_info (id) ON DELETE CASCADE,
    INDEX idx_motion_device_time (device_id, local_time),
    INDEX idx_motion_created_at (created_at)
) COMMENT = '运动数据表';