package fun.guardianelf.location.service;

import java.util.List;
import fun.guardianelf.location.domain.SatelliteInfo;

/**
 * 卫星信息Service接口
 * 
 * @author pc
 * @date 2025-12-09
 */
public interface ISatelliteInfoService 
{
    /**
     * 查询卫星信息
     * 
     * @param id 卫星信息主键
     * @return 卫星信息
     */
    public SatelliteInfo selectSatelliteInfoById(Long id);

    /**
     * 查询卫星信息列表
     * 
     * @param satelliteInfo 卫星信息
     * @return 卫星信息集合
     */
    public List<SatelliteInfo> selectSatelliteInfoList(SatelliteInfo satelliteInfo);

    /**
     * 新增卫星信息
     * 
     * @param satelliteInfo 卫星信息
     * @return 结果
     */
    public int insertSatelliteInfo(SatelliteInfo satelliteInfo);

    /**
     * 修改卫星信息
     * 
     * @param satelliteInfo 卫星信息
     * @return 结果
     */
    public int updateSatelliteInfo(SatelliteInfo satelliteInfo);

    /**
     * 批量删除卫星信息
     * 
     * @param ids 需要删除的卫星信息主键集合
     * @return 结果
     */
    public int deleteSatelliteInfoByIds(Long[] ids);

    /**
     * 删除卫星信息信息
     * 
     * @param id 卫星信息主键
     * @return 结果
     */
    public int deleteSatelliteInfoById(Long id);
}
