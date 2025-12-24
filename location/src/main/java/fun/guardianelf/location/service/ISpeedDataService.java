package fun.guardianelf.location.service;

import java.util.List;
import fun.guardianelf.location.domain.SpeedData;

/**
 * 运动数据Service接口
 * 
 * @author pc
 * @date 2025-12-24
 */
public interface ISpeedDataService 
{
    /**
     * 查询运动数据
     * 
     * @param id 运动数据主键
     * @return 运动数据
     */
    public SpeedData selectSpeedDataById(Long id);

    /**
     * 查询运动数据列表
     * 
     * @param speedData 运动数据
     * @return 运动数据集合
     */
    public List<SpeedData> selectSpeedDataList(SpeedData speedData);

    /**
     * 新增运动数据
     * 
     * @param speedData 运动数据
     * @return 结果
     */
    public int insertSpeedData(SpeedData speedData);

    /**
     * 修改运动数据
     * 
     * @param speedData 运动数据
     * @return 结果
     */
    public int updateSpeedData(SpeedData speedData);

    /**
     * 批量删除运动数据
     * 
     * @param ids 需要删除的运动数据主键集合
     * @return 结果
     */
    public int deleteSpeedDataByIds(Long[] ids);

    /**
     * 删除运动数据信息
     * 
     * @param id 运动数据主键
     * @return 结果
     */
    public int deleteSpeedDataById(Long id);
}
