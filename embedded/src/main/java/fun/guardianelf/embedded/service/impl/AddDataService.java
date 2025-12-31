package fun.guardianelf.embedded.service.impl;


import com.ruoyi.common.exception.ServiceException;
import fun.guardianelf.embedded.mapper.AddDataMapper;
import fun.guardianelf.embedded.mapper.EmbeddedDeviceMapper;
import fun.guardianelf.embedded.pojo.*;
import fun.guardianelf.embedded.service.IAddDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class AddDataService implements IAddDataService {
    private static final Logger log = LoggerFactory.getLogger(AddDataService.class);
    @Autowired
    private AddDataMapper addDataMapper;

    @Autowired
    private EmbeddedDeviceMapper embeddedDeviceMapper;

    @Override
    @Transactional
    public void addEnvironmentData(EnvironmentData environmentData, Long deviceId, LocalDateTime localTime) {
        if (!isIdExist(deviceId)) {
            throw new ServiceException("id" +  deviceId + "不存在");
        }

        environmentData.setDeviceId(deviceId);
        Date date = Date.from(localTime.atZone(ZoneId.systemDefault()).toInstant());
        environmentData.setLocalTime(date);
        addDataMapper.addEnvironmentData(environmentData);
        embeddedDeviceMapper.updateDeviceActiveTime(deviceId);
    }

    @Override
    @Transactional
    public void addSpeedData(SpeedData speedData, Long deviceId, LocalDateTime localTime) {
        if (!isIdExist(deviceId)) {
            throw new ServiceException("id" +  deviceId + "不存在");
        }

        speedData.setDeviceId(deviceId);
        Date date = Date.from(localTime.atZone(ZoneId.systemDefault()).toInstant());
        speedData.setLocalTime(date);
        addDataMapper.addSpeedData(speedData);
        embeddedDeviceMapper.updateDeviceActiveTime(deviceId);

    }

    @Override
    @Transactional
    public void addGpsData(Gp10Data gp10Data, Long deviceId, LocalDateTime localTime) {
        if (!isIdExist(deviceId)) {
            throw new ServiceException("id" +  deviceId + "不存在");
        }

        GpsData gpsData =  new GpsData();
        gpsData.setDeviceId(deviceId);
        gpsData.setLocalTime(localTime);
        addDataMapper.addGpsData(gpsData);

        log.info("添加GPS数据成功#{}", gpsData);

        SatelliteInfo satelliteInfo = new SatelliteInfo();
        satelliteInfo.setBdsSatellites(gp10Data.getSatellite().getBdsSatellites());
        satelliteInfo.setGpsSatellites(gp10Data.getSatellite().getGpsSatellites());
        satelliteInfo.setId(gpsData.getId());
        addDataMapper.addSatellitesInfo(satelliteInfo);

        MotionInfo motionInfo = new MotionInfo();
        motionInfo.setSpeedKnots(gp10Data.getMotion().getSpeedKnots());
        motionInfo.setSpeedKmh(gp10Data.getMotion().getSpeedKmh());
        motionInfo.setCourseTrue(gp10Data.getMotion().getCourseTrue());
        motionInfo.setMagneticVariation(gp10Data.getMotion().getMagneticVariation());
        motionInfo.setId(gpsData.getId());
        addDataMapper.addMotionInfo(motionInfo);

        embeddedDeviceMapper.updateDeviceActiveTime(deviceId);
    }

    // 判断id是否存在
    public boolean isIdExist(Long id) {
        return embeddedDeviceMapper.isDeviceExist(id);
    }
}
