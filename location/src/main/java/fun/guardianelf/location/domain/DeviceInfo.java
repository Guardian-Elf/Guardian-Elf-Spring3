package fun.guardianelf.location.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备信息对象 device_info
 * 
 * @author pc
 * @date 2025-12-09
 */
public class DeviceInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 设备序列号 */
    @Excel(name = "设备序列号")
    private String deviceSerial;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String name;

    /** 设备描述 */
    @Excel(name = "设备描述")
    private String description;

    /** 上报间隔(秒) */
    @Excel(name = "上报间隔(秒)")
    private Long reportInterval;

    /** 状态(0禁用 1正常) */
    @Excel(name = "状态(0禁用 1正常)")
    private Integer isActive;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 最后通信时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后通信时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastSeenAt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setDeviceSerial(String deviceSerial) 
    {
        this.deviceSerial = deviceSerial;
    }

    public String getDeviceSerial() 
    {
        return deviceSerial;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setReportInterval(Long reportInterval) 
    {
        this.reportInterval = reportInterval;
    }

    public Long getReportInterval() 
    {
        return reportInterval;
    }

    public void setIsActive(Integer isActive) 
    {
        this.isActive = isActive;
    }

    public Integer getIsActive() 
    {
        return isActive;
    }

    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }

    public void setLastSeenAt(Date lastSeenAt) 
    {
        this.lastSeenAt = lastSeenAt;
    }

    public Date getLastSeenAt() 
    {
        return lastSeenAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceSerial", getDeviceSerial())
            .append("name", getName())
            .append("description", getDescription())
            .append("reportInterval", getReportInterval())
            .append("isActive", getIsActive())
            .append("createdAt", getCreatedAt())
            .append("lastSeenAt", getLastSeenAt())
            .toString();
    }
}
