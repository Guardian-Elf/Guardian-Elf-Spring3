package fun.guardianelf.location.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fun.guardianelf.location.mapper.MotionInfoMapper;
import fun.guardianelf.location.domain.MotionInfo;
import fun.guardianelf.location.service.IMotionInfoService;

/**
 * 运动信息Service业务层处理
 * 
 * @author pc
 * @date 2025-12-09
 */
@Service
public class MotionInfoServiceImpl implements IMotionInfoService 
{
    @Autowired
    private MotionInfoMapper motionInfoMapper;

    /**
     * 查询运动信息
     * 
     * @param id 运动信息主键
     * @return 运动信息
     */
    @Override
    public MotionInfo selectMotionInfoById(Long id)
    {
        return motionInfoMapper.selectMotionInfoById(id);
    }

    /**
     * 查询运动信息列表
     * 
     * @param motionInfo 运动信息
     * @return 运动信息
     */
    @Override
    public List<MotionInfo> selectMotionInfoList(MotionInfo motionInfo)
    {
        return motionInfoMapper.selectMotionInfoList(motionInfo);
    }

    /**
     * 新增运动信息
     * 
     * @param motionInfo 运动信息
     * @return 结果
     */
    @Override
    public int insertMotionInfo(MotionInfo motionInfo)
    {
        return motionInfoMapper.insertMotionInfo(motionInfo);
    }

    /**
     * 修改运动信息
     * 
     * @param motionInfo 运动信息
     * @return 结果
     */
    @Override
    public int updateMotionInfo(MotionInfo motionInfo)
    {
        return motionInfoMapper.updateMotionInfo(motionInfo);
    }

    /**
     * 批量删除运动信息
     * 
     * @param ids 需要删除的运动信息主键
     * @return 结果
     */
    @Override
    public int deleteMotionInfoByIds(Long[] ids)
    {
        return motionInfoMapper.deleteMotionInfoByIds(ids);
    }

    /**
     * 删除运动信息信息
     * 
     * @param id 运动信息主键
     * @return 结果
     */
    @Override
    public int deleteMotionInfoById(Long id)
    {
        return motionInfoMapper.deleteMotionInfoById(id);
    }
}
