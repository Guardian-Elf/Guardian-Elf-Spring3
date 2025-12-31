package fun.guardianelf.embedded.mapper;

import fun.guardianelf.embedded.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface AddDataMapper {
    @Insert("insert into environment_data(device_id, local_time, illuminance, temperature, humidity, pressure) " +
            "values(#{deviceId}, #{localTime}, #{illuminance}, #{temperature}, #{humidity}, #{pressure})")
    void addEnvironmentData(EnvironmentData environmentData);

    @Insert("insert into speed_data(device_id, local_time, accel_x, accel_y, accel_z, gyro_x, gyro_y, gyro_z) " +
            "values(#{deviceId}, #{localTime}, #{accelX}, #{accelY}, #{accelZ}, #{gyroX}, #{gyroY}, #{gyroZ})")
    void addSpeedData(SpeedData speedData);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into gps_data(device_id, local_time)" +
            "values(#{deviceId}, #{localTime})")
    void addGpsData(GpsData gpsData);

    @Insert("insert into satellite_info(id, bds_satellites, gps_satellites)" +
            "values(#{id}, #{bdsSatellites}, #{gpsSatellites})")
    void addSatellitesInfo(SatelliteInfo satelliteInfo);

    @Insert("insert into motion_info(id, speed_knots, speed_kmh, course_true, magnetic_variation) " +
            "values(#{id}, #{speedKnots}, #{speedKmh}, #{courseTrue}, #{magneticVariation})")
    void addMotionInfo(MotionInfo motionInfo);
}
