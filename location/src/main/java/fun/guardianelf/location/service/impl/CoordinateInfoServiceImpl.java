package fun.guardianelf.location.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fun.guardianelf.location.mapper.CoordinateInfoMapper;
import fun.guardianelf.location.domain.CoordinateInfo;
import fun.guardianelf.location.service.ICoordinateInfoService;

/**
 * 坐标信息Service业务层处理
 * 
 * @author pc
 * @date 2025-12-09
 */
@Service
public class CoordinateInfoServiceImpl implements ICoordinateInfoService 
{
    @Autowired
    private CoordinateInfoMapper coordinateInfoMapper;

    /**
     * 查询坐标信息
     * 
     * @param id 坐标信息主键
     * @return 坐标信息
     */
    @Override
    public CoordinateInfo selectCoordinateInfoById(Long id)
    {
        return coordinateInfoMapper.selectCoordinateInfoById(id);
    }

    /**
     * 查询坐标信息列表
     * 
     * @param coordinateInfo 坐标信息
     * @return 坐标信息
     */
    @Override
    public List<CoordinateInfo> selectCoordinateInfoList(CoordinateInfo coordinateInfo)
    {
        return coordinateInfoMapper.selectCoordinateInfoList(coordinateInfo);
    }

    /**
     * 新增坐标信息
     * 
     * @param coordinateInfo 坐标信息
     * @return 结果
     */
    @Override
    public int insertCoordinateInfo(CoordinateInfo coordinateInfo)
    {
        return coordinateInfoMapper.insertCoordinateInfo(coordinateInfo);
    }

    /**
     * 修改坐标信息
     * 
     * @param coordinateInfo 坐标信息
     * @return 结果
     */
    @Override
    public int updateCoordinateInfo(CoordinateInfo coordinateInfo)
    {
        return coordinateInfoMapper.updateCoordinateInfo(coordinateInfo);
    }

    /**
     * 批量删除坐标信息
     * 
     * @param ids 需要删除的坐标信息主键
     * @return 结果
     */
    @Override
    public int deleteCoordinateInfoByIds(Long[] ids)
    {
        return coordinateInfoMapper.deleteCoordinateInfoByIds(ids);
    }

    /**
     * 删除坐标信息信息
     * 
     * @param id 坐标信息主键
     * @return 结果
     */
    @Override
    public int deleteCoordinateInfoById(Long id)
    {
        return coordinateInfoMapper.deleteCoordinateInfoById(id);
    }
}
