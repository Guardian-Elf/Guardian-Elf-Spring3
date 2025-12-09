package fun.guardianelf.location.service;

import java.util.List;
import fun.guardianelf.location.domain.CoordinateInfo;

/**
 * 坐标信息Service接口
 * 
 * @author pc
 * @date 2025-12-09
 */
public interface ICoordinateInfoService 
{
    /**
     * 查询坐标信息
     * 
     * @param id 坐标信息主键
     * @return 坐标信息
     */
    public CoordinateInfo selectCoordinateInfoById(Long id);

    /**
     * 查询坐标信息列表
     * 
     * @param coordinateInfo 坐标信息
     * @return 坐标信息集合
     */
    public List<CoordinateInfo> selectCoordinateInfoList(CoordinateInfo coordinateInfo);

    /**
     * 新增坐标信息
     * 
     * @param coordinateInfo 坐标信息
     * @return 结果
     */
    public int insertCoordinateInfo(CoordinateInfo coordinateInfo);

    /**
     * 修改坐标信息
     * 
     * @param coordinateInfo 坐标信息
     * @return 结果
     */
    public int updateCoordinateInfo(CoordinateInfo coordinateInfo);

    /**
     * 批量删除坐标信息
     * 
     * @param ids 需要删除的坐标信息主键集合
     * @return 结果
     */
    public int deleteCoordinateInfoByIds(Long[] ids);

    /**
     * 删除坐标信息信息
     * 
     * @param id 坐标信息主键
     * @return 结果
     */
    public int deleteCoordinateInfoById(Long id);
}
