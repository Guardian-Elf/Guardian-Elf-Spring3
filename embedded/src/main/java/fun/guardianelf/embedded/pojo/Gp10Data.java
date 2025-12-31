package fun.guardianelf.embedded.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * GP10数据对象
 */
public class Gp10Data extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long deviceId;
    private Coordinate coordinate;
    private TimeInfo time;
    private Motion motion;
    private Satellite satellite;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    // 无参构造
    public Gp10Data() {
    }

    // getter和setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public TimeInfo getTime() {
        return time;
    }

    public void setTime(TimeInfo time) {
        this.time = time;
    }

    public Motion getMotion() {
        return motion;
    }

    public void setMotion(Motion motion) {
        this.motion = motion;
    }

    public Satellite getSatellite() {
        return satellite;
    }

    public void setSatellite(Satellite satellite) {
        this.satellite = satellite;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    // toString方法
    @Override
    public String toString() {
        return "Gp10Data{" +
                "id=" + id +
                ", deviceId=" + deviceId +
                ", coordinate=" + coordinate +
                ", time=" + time +
                ", motion=" + motion +
                ", satellite=" + satellite +
                ", createdAt=" + createdAt +
                '}';
    }

    /**
     * 坐标信息内部类
     */
    public static class Coordinate {
        private Long latitudeDeg;
        private Long longitudeDeg;
        private BigDecimal latitudeDm;
        private BigDecimal longitudeDm;
        private BigDecimal altitudeM;
        private BigDecimal altitudeAgl;
        private Character latDir;
        private Character lonDir;

        public Coordinate() {
        }

        // getter和setter
        public Long getLatitudeDeg() {
            return latitudeDeg;
        }

        public void setLatitudeDeg(Long latitudeDeg) {
            this.latitudeDeg = latitudeDeg;
        }

        public Long getLongitudeDeg() {
            return longitudeDeg;
        }

        public void setLongitudeDeg(Long longitudeDeg) {
            this.longitudeDeg = longitudeDeg;
        }

        public BigDecimal getLatitudeDm() {
            return latitudeDm;
        }

        public void setLatitudeDm(BigDecimal latitudeDm) {
            this.latitudeDm = latitudeDm;
        }

        public BigDecimal getLongitudeDm() {
            return longitudeDm;
        }

        public void setLongitudeDm(BigDecimal longitudeDm) {
            this.longitudeDm = longitudeDm;
        }

        public BigDecimal getAltitudeM() {
            return altitudeM;
        }

        public void setAltitudeM(BigDecimal altitudeM) {
            this.altitudeM = altitudeM;
        }

        public BigDecimal getAltitudeAgl() {
            return altitudeAgl;
        }

        public void setAltitudeAgl(BigDecimal altitudeAgl) {
            this.altitudeAgl = altitudeAgl;
        }

        public Character getLatDir() {
            return latDir;
        }

        public void setLatDir(Character latDir) {
            this.latDir = latDir;
        }

        public Character getLonDir() {
            return lonDir;
        }

        public void setLonDir(Character lonDir) {
            this.lonDir = lonDir;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "latitudeDeg=" + latitudeDeg +
                    ", longitudeDeg=" + longitudeDeg +
                    ", latitudeDm=" + latitudeDm +
                    ", longitudeDm=" + longitudeDm +
                    ", altitudeM=" + altitudeM +
                    ", altitudeAgl=" + altitudeAgl +
                    ", latDir=" + latDir +
                    ", lonDir=" + lonDir +
                    '}';
        }
    }

    /**
     * 时间信息内部类
     */
    public static class TimeInfo {
        private String utcTime;
        private String date;
        private String timezoneOffset;

        public TimeInfo() {
        }

        public String getUtcTime() {
            return utcTime;
        }

        public void setUtcTime(String utcTime) {
            this.utcTime = utcTime;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTimezoneOffset() {
            return timezoneOffset;
        }

        public void setTimezoneOffset(String timezoneOffset) {
            this.timezoneOffset = timezoneOffset;
        }

        @Override
        public String toString() {
            return "TimeInfo{" +
                    "utcTime='" + utcTime + '\'' +
                    ", date='" + date + '\'' +
                    ", timezoneOffset='" + timezoneOffset + '\'' +
                    '}';
        }
    }

    /**
     * 运动信息内部类
     */
    public static class Motion {
        private BigDecimal speedKnots;
        private BigDecimal speedKmh;
        private BigDecimal courseTrue;
        private BigDecimal magneticVariation;
        private Character variationDir;

        public Motion() {
        }

        public BigDecimal getSpeedKnots() {
            return speedKnots;
        }

        public void setSpeedKnots(BigDecimal speedKnots) {
            this.speedKnots = speedKnots;
        }

        public BigDecimal getSpeedKmh() {
            return speedKmh;
        }

        public void setSpeedKmh(BigDecimal speedKmh) {
            this.speedKmh = speedKmh;
        }

        public BigDecimal getCourseTrue() {
            return courseTrue;
        }

        public void setCourseTrue(BigDecimal courseTrue) {
            this.courseTrue = courseTrue;
        }

        public BigDecimal getMagneticVariation() {
            return magneticVariation;
        }

        public void setMagneticVariation(BigDecimal magneticVariation) {
            this.magneticVariation = magneticVariation;
        }

        public Character getVariationDir() {
            return variationDir;
        }

        public void setVariationDir(Character variationDir) {
            this.variationDir = variationDir;
        }

        @Override
        public String toString() {
            return "Motion{" +
                    "speedKnots=" + speedKnots +
                    ", speedKmh=" + speedKmh +
                    ", courseTrue=" + courseTrue +
                    ", magneticVariation=" + magneticVariation +
                    ", variationDir=" + variationDir +
                    '}';
        }
    }

    /**
     * 卫星信息内部类
     */
    public static class Satellite {
        private Long gpsSatellites;
        private Long bdsSatellites;

        public Satellite() {
        }

        public Long getGpsSatellites() {
            return gpsSatellites;
        }

        public void setGpsSatellites(Long gpsSatellites) {
            this.gpsSatellites = gpsSatellites;
        }

        public Long getBdsSatellites() {
            return bdsSatellites;
        }

        public void setBdsSatellites(Long bdsSatellites) {
            this.bdsSatellites = bdsSatellites;
        }

        @Override
        public String toString() {
            return "Satellite{" +
                    "gpsSatellites=" + gpsSatellites +
                    ", bdsSatellites=" + bdsSatellites +
                    '}';
        }
    }
}