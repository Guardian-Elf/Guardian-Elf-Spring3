package fun.guardianelf.embedded.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 运动信息对象 motion_info
 * 
 * @author pc
 * @date 2025-12-09
 */
public class MotionInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** GPS数据ID */
    private Long id;

    /** 速度(节) */
    @Excel(name = "速度(节)")
    private BigDecimal speedKnots;

    /** 速度(km/h) */
    @Excel(name = "速度(km/h)")
    private BigDecimal speedKmh;

    /** 真北航向 */
    @Excel(name = "真北航向")
    private BigDecimal courseTrue;

    /** 磁偏角 */
    @Excel(name = "磁偏角")
    private BigDecimal magneticVariation;

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

    public void setSpeedKnots(BigDecimal speedKnots) 
    {
        this.speedKnots = speedKnots;
    }

    public BigDecimal getSpeedKnots() 
    {
        return speedKnots;
    }

    public void setSpeedKmh(BigDecimal speedKmh) 
    {
        this.speedKmh = speedKmh;
    }

    public BigDecimal getSpeedKmh() 
    {
        return speedKmh;
    }

    public void setCourseTrue(BigDecimal courseTrue) 
    {
        this.courseTrue = courseTrue;
    }

    public BigDecimal getCourseTrue() 
    {
        return courseTrue;
    }

    public void setMagneticVariation(BigDecimal magneticVariation) 
    {
        this.magneticVariation = magneticVariation;
    }

    public BigDecimal getMagneticVariation() 
    {
        return magneticVariation;
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
            .append("speedKnots", getSpeedKnots())
            .append("speedKmh", getSpeedKmh())
            .append("courseTrue", getCourseTrue())
            .append("magneticVariation", getMagneticVariation())
            .append("createdAt", getCreatedAt())
            .toString();
    }
}
