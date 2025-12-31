package fun.guardianelf.embedded.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 坐标信息对象 coordinate_info
 * 
 * @author pc
 * @date 2025-12-09
 */
public class CoordinateInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** GPS数据ID */
    private Long id;

    /** 海拔(米) */
    @Excel(name = "海拔(米)")
    private BigDecimal altitudeM;

    /** 相对高度(米) */
    @Excel(name = "相对高度(米)")
    private BigDecimal altitudeAgl;

    /** 经度 */
    @Excel(name = "经度")
    private BigDecimal longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private BigDecimal latitude;

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

    public void setAltitudeM(BigDecimal altitudeM) 
    {
        this.altitudeM = altitudeM;
    }

    public BigDecimal getAltitudeM() 
    {
        return altitudeM;
    }

    public void setAltitudeAgl(BigDecimal altitudeAgl) 
    {
        this.altitudeAgl = altitudeAgl;
    }

    public BigDecimal getAltitudeAgl() 
    {
        return altitudeAgl;
    }

    public void setLongitude(BigDecimal longitude) 
    {
        this.longitude = longitude;
    }

    public BigDecimal getLongitude() 
    {
        return longitude;
    }

    public void setLatitude(BigDecimal latitude) 
    {
        this.latitude = latitude;
    }

    public BigDecimal getLatitude() 
    {
        return latitude;
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
            .append("altitudeM", getAltitudeM())
            .append("altitudeAgl", getAltitudeAgl())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .append("createdAt", getCreatedAt())
            .toString();
    }
}
