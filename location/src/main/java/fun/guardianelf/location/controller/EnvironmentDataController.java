package fun.guardianelf.location.controller;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import java.util.List;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import fun.guardianelf.location.domain.EnvironmentData;
import fun.guardianelf.location.service.IEnvironmentDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 环境数据Controller
 * 
 * @author pc
 * @date 2025-12-24
 */
@RestController
@RequestMapping("/location/environment")
@DataSource(value = DataSourceType.LOCATION)
public class EnvironmentDataController extends BaseController
{
    @Autowired
    private IEnvironmentDataService environmentDataService;

    /**
     * 查询环境数据列表
     */
    @PreAuthorize("@ss.hasPermi('location:environment:list')")
    @GetMapping("/list")
    public TableDataInfo list(EnvironmentData environmentData)
    {
        startPage();
        List<EnvironmentData> list = environmentDataService.selectEnvironmentDataList(environmentData);
        return getDataTable(list);
    }

    /**
     * 导出环境数据列表
     */
    @PreAuthorize("@ss.hasPermi('location:environment:export')")
    @Log(title = "环境数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EnvironmentData environmentData)
    {
        List<EnvironmentData> list = environmentDataService.selectEnvironmentDataList(environmentData);
        ExcelUtil<EnvironmentData> util = new ExcelUtil<EnvironmentData>(EnvironmentData.class);
        util.exportExcel(response, list, "环境数据数据");
    }

    /**
     * 获取环境数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('location:environment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(environmentDataService.selectEnvironmentDataById(id));
    }

    /**
     * 新增环境数据
     */
    @PreAuthorize("@ss.hasPermi('location:environment:add')")
    @Log(title = "环境数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EnvironmentData environmentData)
    {
        return toAjax(environmentDataService.insertEnvironmentData(environmentData));
    }

    /**
     * 修改环境数据
     */
    @PreAuthorize("@ss.hasPermi('location:environment:edit')")
    @Log(title = "环境数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EnvironmentData environmentData)
    {
        return toAjax(environmentDataService.updateEnvironmentData(environmentData));
    }

    /**
     * 删除环境数据
     */
    @PreAuthorize("@ss.hasPermi('location:environment:remove')")
    @Log(title = "环境数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(environmentDataService.deleteEnvironmentDataByIds(ids));
    }
}
