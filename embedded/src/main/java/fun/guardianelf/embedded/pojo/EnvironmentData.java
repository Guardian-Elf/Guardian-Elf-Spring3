package fun.guardianelf.embedded.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 环境数据对象 environment_data
 * 
 * @author pc
 * @date 2025-12-24
 */
public class EnvironmentData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 设备ID */
    @Excel(name = "设备ID")
    private Long deviceId;

    /** 光照强度(lux) */
    @Excel(name = "光照强度(lux)")
    private Long illuminance;

    /** 温度(°C) */
    @Excel(name = "温度(°C)")
    private Double temperature;

    /** 湿度(%) */
    @Excel(name = "湿度(%)")
    private Double humidity;

    /** 气压(hPa) */
    @Excel(name = "气压(hPa)")
    private Double pressure;

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

    public void setIlluminance(Long illuminance) 
    {
        this.illuminance = illuminance;
    }

    public Long getIlluminance() 
    {
        return illuminance;
    }

    public void setTemperature(Double temperature) 
    {
        this.temperature = temperature;
    }

    public Double getTemperature() 
    {
        return temperature;
    }

    public void setHumidity(Double humidity) 
    {
        this.humidity = humidity;
    }

    public Double getHumidity() 
    {
        return humidity;
    }

    public void setPressure(Double pressure) 
    {
        this.pressure = pressure;
    }

    public Double getPressure() 
    {
        return pressure;
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
            .append("illuminance", getIlluminance())
            .append("temperature", getTemperature())
            .append("humidity", getHumidity())
            .append("pressure", getPressure())
            .append("localTime", getLocalTime())
            .append("createdAt", getCreatedAt())
            .toString();
    }
}
