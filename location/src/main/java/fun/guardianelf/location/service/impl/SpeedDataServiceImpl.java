package fun.guardianelf.location.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fun.guardianelf.location.mapper.SpeedDataMapper;
import fun.guardianelf.location.domain.SpeedData;
import fun.guardianelf.location.service.ISpeedDataService;

/**
 * 运动数据Service业务层处理
 * 
 * @author pc
 * @date 2025-12-24
 */
@Service
public class SpeedDataServiceImpl implements ISpeedDataService 
{
    @Autowired
    private SpeedDataMapper speedDataMapper;

    /**
     * 查询运动数据
     * 
     * @param id 运动数据主键
     * @return 运动数据
     */
    @Override
    public SpeedData selectSpeedDataById(Long id)
    {
        return speedDataMapper.selectSpeedDataById(id);
    }

    /**
     * 查询运动数据列表
     * 
     * @param speedData 运动数据
     * @return 运动数据
     */
    @Override
    public List<SpeedData> selectSpeedDataList(SpeedData speedData)
    {
        return speedDataMapper.selectSpeedDataList(speedData);
    }

    /**
     * 新增运动数据
     * 
     * @param speedData 运动数据
     * @return 结果
     */
    @Override
    public int insertSpeedData(SpeedData speedData)
    {
        return speedDataMapper.insertSpeedData(speedData);
    }

    /**
     * 修改运动数据
     * 
     * @param speedData 运动数据
     * @return 结果
     */
    @Override
    public int updateSpeedData(SpeedData speedData)
    {
        return speedDataMapper.updateSpeedData(speedData);
    }

    /**
     * 批量删除运动数据
     * 
     * @param ids 需要删除的运动数据主键
     * @return 结果
     */
    @Override
    public int deleteSpeedDataByIds(Long[] ids)
    {
        return speedDataMapper.deleteSpeedDataByIds(ids);
    }

    /**
     * 删除运动数据信息
     * 
     * @param id 运动数据主键
     * @return 结果
     */
    @Override
    public int deleteSpeedDataById(Long id)
    {
        return speedDataMapper.deleteSpeedDataById(id);
    }
}
