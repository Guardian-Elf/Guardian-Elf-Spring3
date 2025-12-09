package fun.guardianelf.location.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fun.guardianelf.location.mapper.GpsDataMapper;
import fun.guardianelf.location.domain.GpsData;
import fun.guardianelf.location.service.IGpsDataService;

/**
 * GPS数据Service业务层处理
 * 
 * @author pc
 * @date 2025-12-09
 */
@Service
public class GpsDataServiceImpl implements IGpsDataService 
{
    @Autowired
    private GpsDataMapper gpsDataMapper;

    /**
     * 查询GPS数据
     * 
     * @param id GPS数据主键
     * @return GPS数据
     */
    @Override
    public GpsData selectGpsDataById(Long id)
    {
        return gpsDataMapper.selectGpsDataById(id);
    }

    /**
     * 查询GPS数据列表
     * 
     * @param gpsData GPS数据
     * @return GPS数据
     */
    @Override
    public List<GpsData> selectGpsDataList(GpsData gpsData)
    {
        return gpsDataMapper.selectGpsDataList(gpsData);
    }

    /**
     * 新增GPS数据
     * 
     * @param gpsData GPS数据
     * @return 结果
     */
    @Override
    public int insertGpsData(GpsData gpsData)
    {
        return gpsDataMapper.insertGpsData(gpsData);
    }

    /**
     * 修改GPS数据
     * 
     * @param gpsData GPS数据
     * @return 结果
     */
    @Override
    public int updateGpsData(GpsData gpsData)
    {
        return gpsDataMapper.updateGpsData(gpsData);
    }

    /**
     * 批量删除GPS数据
     * 
     * @param ids 需要删除的GPS数据主键
     * @return 结果
     */
    @Override
    public int deleteGpsDataByIds(Long[] ids)
    {
        return gpsDataMapper.deleteGpsDataByIds(ids);
    }

    /**
     * 删除GPS数据信息
     * 
     * @param id GPS数据主键
     * @return 结果
     */
    @Override
    public int deleteGpsDataById(Long id)
    {
        return gpsDataMapper.deleteGpsDataById(id);
    }
}
