package fun.guardianelf.location.service;

import java.util.List;
import fun.guardianelf.location.domain.MotionInfo;

/**
 * 运动信息Service接口
 * 
 * @author pc
 * @date 2025-12-09
 */
public interface IMotionInfoService 
{
    /**
     * 查询运动信息
     * 
     * @param id 运动信息主键
     * @return 运动信息
     */
    public MotionInfo selectMotionInfoById(Long id);

    /**
     * 查询运动信息列表
     * 
     * @param motionInfo 运动信息
     * @return 运动信息集合
     */
    public List<MotionInfo> selectMotionInfoList(MotionInfo motionInfo);

    /**
     * 新增运动信息
     * 
     * @param motionInfo 运动信息
     * @return 结果
     */
    public int insertMotionInfo(MotionInfo motionInfo);

    /**
     * 修改运动信息
     * 
     * @param motionInfo 运动信息
     * @return 结果
     */
    public int updateMotionInfo(MotionInfo motionInfo);

    /**
     * 批量删除运动信息
     * 
     * @param ids 需要删除的运动信息主键集合
     * @return 结果
     */
    public int deleteMotionInfoByIds(Long[] ids);

    /**
     * 删除运动信息信息
     * 
     * @param id 运动信息主键
     * @return 结果
     */
    public int deleteMotionInfoById(Long id);
}
