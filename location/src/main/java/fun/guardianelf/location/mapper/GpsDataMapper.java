package fun.guardianelf.location.mapper;

import java.util.List;
import fun.guardianelf.location.domain.GpsData;

/**
 * GPS数据Mapper接口
 * 
 * @author pc
 * @date 2025-12-09
 */
public interface GpsDataMapper 
{
    /**
     * 查询GPS数据
     * 
     * @param id GPS数据主键
     * @return GPS数据
     */
    public GpsData selectGpsDataById(Long id);

    /**
     * 查询GPS数据列表
     * 
     * @param gpsData GPS数据
     * @return GPS数据集合
     */
    public List<GpsData> selectGpsDataList(GpsData gpsData);

    /**
     * 新增GPS数据
     * 
     * @param gpsData GPS数据
     * @return 结果
     */
    public int insertGpsData(GpsData gpsData);

    /**
     * 修改GPS数据
     * 
     * @param gpsData GPS数据
     * @return 结果
     */
    public int updateGpsData(GpsData gpsData);

    /**
     * 删除GPS数据
     * 
     * @param id GPS数据主键
     * @return 结果
     */
    public int deleteGpsDataById(Long id);

    /**
     * 批量删除GPS数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGpsDataByIds(Long[] ids);
}
