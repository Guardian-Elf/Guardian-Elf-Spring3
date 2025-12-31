package fun.guardianelf.embedded.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;

public interface EmbeddedDeviceMapper {
    @Select("select id from device_info where device_serial = #{serial}")
    Long getDeviceIdBySerial(String serial);

    @Select("select exists(select 1 from device_info where id = #{id})")
    Boolean isDeviceExist(Long id);

    @Update("update device_info set last_seen_at = now(), is_active = 1 where id = #{id}")
    void updateDeviceActiveTime(Long id);
}
