package fun.guardianelf.location.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fun.guardianelf.location.mapper.EnvironmentDataMapper;
import fun.guardianelf.location.domain.EnvironmentData;
import fun.guardianelf.location.service.IEnvironmentDataService;

/**
 * 环境数据Service业务层处理
 * 
 * @author pc
 * @date 2025-12-24
 */
@Service
public class EnvironmentDataServiceImpl implements IEnvironmentDataService 
{
    @Autowired
    private EnvironmentDataMapper environmentDataMapper;

    /**
     * 查询环境数据
     * 
     * @param id 环境数据主键
     * @return 环境数据
     */
    @Override
    public EnvironmentData selectEnvironmentDataById(Long id)
    {
        return environmentDataMapper.selectEnvironmentDataById(id);
    }

    /**
     * 查询环境数据列表
     * 
     * @param environmentData 环境数据
     * @return 环境数据
     */
    @Override
    public List<EnvironmentData> selectEnvironmentDataList(EnvironmentData environmentData)
    {
        return environmentDataMapper.selectEnvironmentDataList(environmentData);
    }

    /**
     * 新增环境数据
     * 
     * @param environmentData 环境数据
     * @return 结果
     */
    @Override
    public int insertEnvironmentData(EnvironmentData environmentData)
    {
        return environmentDataMapper.insertEnvironmentData(environmentData);
    }

    /**
     * 修改环境数据
     * 
     * @param environmentData 环境数据
     * @return 结果
     */
    @Override
    public int updateEnvironmentData(EnvironmentData environmentData)
    {
        return environmentDataMapper.updateEnvironmentData(environmentData);
    }

    /**
     * 批量删除环境数据
     * 
     * @param ids 需要删除的环境数据主键
     * @return 结果
     */
    @Override
    public int deleteEnvironmentDataByIds(Long[] ids)
    {
        return environmentDataMapper.deleteEnvironmentDataByIds(ids);
    }

    /**
     * 删除环境数据信息
     * 
     * @param id 环境数据主键
     * @return 结果
     */
    @Override
    public int deleteEnvironmentDataById(Long id)
    {
        return environmentDataMapper.deleteEnvironmentDataById(id);
    }
}
