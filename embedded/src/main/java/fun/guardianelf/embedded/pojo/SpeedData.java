package fun.guardianelf.embedded.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 运动数据对象 speed_data
 * 
 * @author pc
 * @date 2025-12-24
 */
public class SpeedData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 设备ID */
    @Excel(name = "设备ID")
    private Long deviceId;

    /** 加速度X轴(g) */
    @Excel(name = "加速度X轴(g)")
    private Double accelX;

    /** 加速度Y轴(g) */
    @Excel(name = "加速度Y轴(g)")
    private Double accelY;

    /** 加速度Z轴(g) */
    @Excel(name = "加速度Z轴(g)")
    private Double accelZ;

    /** 陀螺仪X轴(°/s) */
    @Excel(name = "陀螺仪X轴(°/s)")
    private Double gyroX;

    /** 陀螺仪Y轴(°/s) */
    @Excel(name = "陀螺仪Y轴(°/s)")
    private Double gyroY;

    /** 陀螺仪Z轴(°/s) */
    @Excel(name = "陀螺仪Z轴(°/s)")
    private Double gyroZ;

    /** 设备时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "设备时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date localTime;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setDeviceId(Long deviceId) 
    {
        this.deviceId = deviceId;
    }

    public Long getDeviceId() 
    {
        return deviceId;
    }

    public void setAccelX(Double accelX) 
    {
        this.accelX = accelX;
    }

    public Double getAccelX() 
    {
        return accelX;
    }

    public void setAccelY(Double accelY) 
    {
        this.accelY = accelY;
    }

    public Double getAccelY() 
    {
        return accelY;
    }

    public void setAccelZ(Double accelZ) 
    {
        this.accelZ = accelZ;
    }

    public Double getAccelZ() 
    {
        return accelZ;
    }

    public void setGyroX(Double gyroX) 
    {
        this.gyroX = gyroX;
    }

    public Double getGyroX() 
    {
        return gyroX;
    }

    public void setGyroY(Double gyroY) 
    {
        this.gyroY = gyroY;
    }

    public Double getGyroY() 
    {
        return gyroY;
    }

    public void setGyroZ(Double gyroZ) 
    {
        this.gyroZ = gyroZ;
    }

    public Double getGyroZ() 
    {
        return gyroZ;
    }

    public void setLocalTime(Date localTime) 
    {
        this.localTime = localTime;
    }

    public Date getLocalTime() 
    {
        return localTime;
    }

    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceId", getDeviceId())
            .append("accelX", getAccelX())
            .append("accelY", getAccelY())
            .append("accelZ", getAccelZ())
            .append("gyroX", getGyroX())
            .append("gyroY", getGyroY())
            .append("gyroZ", getGyroZ())
            .append("localTime", getLocalTime())
            .append("createdAt", getCreatedAt())
            .toString();
    }
}
