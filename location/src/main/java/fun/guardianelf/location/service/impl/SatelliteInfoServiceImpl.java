package fun.guardianelf.location.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fun.guardianelf.location.mapper.SatelliteInfoMapper;
import fun.guardianelf.location.domain.SatelliteInfo;
import fun.guardianelf.location.service.ISatelliteInfoService;

/**
 * 卫星信息Service业务层处理
 * 
 * @author pc
 * @date 2025-12-09
 */
@Service
public class SatelliteInfoServiceImpl implements ISatelliteInfoService 
{
    @Autowired
    private SatelliteInfoMapper satelliteInfoMapper;

    /**
     * 查询卫星信息
     * 
     * @param id 卫星信息主键
     * @return 卫星信息
     */
    @Override
    public SatelliteInfo selectSatelliteInfoById(Long id)
    {
        return satelliteInfoMapper.selectSatelliteInfoById(id);
    }

    /**
     * 查询卫星信息列表
     * 
     * @param satelliteInfo 卫星信息
     * @return 卫星信息
     */
    @Override
    public List<SatelliteInfo> selectSatelliteInfoList(SatelliteInfo satelliteInfo)
    {
        return satelliteInfoMapper.selectSatelliteInfoList(satelliteInfo);
    }

    /**
     * 新增卫星信息
     * 
     * @param satelliteInfo 卫星信息
     * @return 结果
     */
    @Override
    public int insertSatelliteInfo(SatelliteInfo satelliteInfo)
    {
        return satelliteInfoMapper.insertSatelliteInfo(satelliteInfo);
    }

    /**
     * 修改卫星信息
     * 
     * @param satelliteInfo 卫星信息
     * @return 结果
     */
    @Override
    public int updateSatelliteInfo(SatelliteInfo satelliteInfo)
    {
        return satelliteInfoMapper.updateSatelliteInfo(satelliteInfo);
    }

    /**
     * 批量删除卫星信息
     * 
     * @param ids 需要删除的卫星信息主键
     * @return 结果
     */
    @Override
    public int deleteSatelliteInfoByIds(Long[] ids)
    {
        return satelliteInfoMapper.deleteSatelliteInfoByIds(ids);
    }

    /**
     * 删除卫星信息信息
     * 
     * @param id 卫星信息主键
     * @return 结果
     */
    @Override
    public int deleteSatelliteInfoById(Long id)
    {
        return satelliteInfoMapper.deleteSatelliteInfoById(id);
    }
}
