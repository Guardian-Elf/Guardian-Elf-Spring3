package fun.guardianelf.embedded.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 卫星信息对象 satellite_info
 * 
 * @author pc
 * @date 2025-12-09
 */
public class SatelliteInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** GPS数据ID */
    private Long id;

    /** GPS卫星数 */
    @Excel(name = "GPS卫星数")
    private Long gpsSatellites;

    /** 北斗卫星数 */
    @Excel(name = "北斗卫星数")
    private Long bdsSatellites;

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

    public void setGpsSatellites(Long gpsSatellites) 
    {
        this.gpsSatellites = gpsSatellites;
    }

    public Long getGpsSatellites() 
    {
        return gpsSatellites;
    }

    public void setBdsSatellites(Long bdsSatellites) 
    {
        this.bdsSatellites = bdsSatellites;
    }

    public Long getBdsSatellites() 
    {
        return bdsSatellites;
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
            .append("gpsSatellites", getGpsSatellites())
            .append("bdsSatellites", getBdsSatellites())
            .append("createdAt", getCreatedAt())
            .toString();
    }
}
