package fun.guardianelf.location.mapper;

import java.util.List;
import fun.guardianelf.location.domain.EnvironmentData;

/**
 * 环境数据Mapper接口
 * 
 * @author pc
 * @date 2025-12-24
 */
public interface EnvironmentDataMapper 
{
    /**
     * 查询环境数据
     * 
     * @param id 环境数据主键
     * @return 环境数据
     */
    public EnvironmentData selectEnvironmentDataById(Long id);

    /**
     * 查询环境数据列表
     * 
     * @param environmentData 环境数据
     * @return 环境数据集合
     */
    public List<EnvironmentData> selectEnvironmentDataList(EnvironmentData environmentData);

    /**
     * 新增环境数据
     * 
     * @param environmentData 环境数据
     * @return 结果
     */
    public int insertEnvironmentData(EnvironmentData environmentData);

    /**
     * 修改环境数据
     * 
     * @param environmentData 环境数据
     * @return 结果
     */
    public int updateEnvironmentData(EnvironmentData environmentData);

    /**
     * 删除环境数据
     * 
     * @param id 环境数据主键
     * @return 结果
     */
    public int deleteEnvironmentDataById(Long id);

    /**
     * 批量删除环境数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEnvironmentDataByIds(Long[] ids);
}
