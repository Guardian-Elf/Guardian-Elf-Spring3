package fun.guardianelf.embedded.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * GPS数据对象 gps_data
 * 
 * @author pc
 * @date 2025-12-09
 */
public class GpsData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 设备时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "设备时间", width = 30, dateFormat = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime localTime;

    /** 设备ID */
    @Excel(name = "设备ID")
    private Long deviceId;

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

    public void setLocalTime(LocalDateTime localTime)
    {
        this.localTime = localTime;
    }

    public LocalDateTime getLocalTime()
    {
        return localTime;
    }

    public void setDeviceId(Long deviceId) 
    {
        this.deviceId = deviceId;
    }

    public Long getDeviceId() 
    {
        return deviceId;
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
            .append("localTime", getLocalTime())
            .append("deviceId", getDeviceId())
            .append("createdAt", getCreatedAt())
            .toString();
    }
}
