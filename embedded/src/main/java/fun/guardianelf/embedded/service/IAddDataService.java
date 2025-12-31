package fun.guardianelf.embedded.service;

import fun.guardianelf.embedded.pojo.CoordinateInfo;
import fun.guardianelf.embedded.pojo.EnvironmentData;
import fun.guardianelf.embedded.pojo.Gp10Data;
import fun.guardianelf.embedded.pojo.SpeedData;

import java.time.LocalDateTime;

public interface IAddDataService {
    void addEnvironmentData(EnvironmentData environmentData, Long deviceId, LocalDateTime localTime);

    void addSpeedData(SpeedData speedData, Long deviceId, LocalDateTime localTime);

    void addGpsData(Gp10Data gp10Data, Long deviceId, LocalDateTime localTime);
}
