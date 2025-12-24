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
import fun.guardianelf.location.domain.SpeedData;
import fun.guardianelf.location.service.ISpeedDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 运动数据Controller
 * 
 * @author pc
 * @date 2025-12-24
 */
@RestController
@RequestMapping("/location/speed")
@DataSource(value = DataSourceType.LOCATION)
public class SpeedDataController extends BaseController
{
    @Autowired
    private ISpeedDataService speedDataService;

    /**
     * 查询运动数据列表
     */
    @PreAuthorize("@ss.hasPermi('location:speed:list')")
    @GetMapping("/list")
    public TableDataInfo list(SpeedData speedData)
    {
        startPage();
        List<SpeedData> list = speedDataService.selectSpeedDataList(speedData);
        return getDataTable(list);
    }

    /**
     * 导出运动数据列表
     */
    @PreAuthorize("@ss.hasPermi('location:speed:export')")
    @Log(title = "运动数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SpeedData speedData)
    {
        List<SpeedData> list = speedDataService.selectSpeedDataList(speedData);
        ExcelUtil<SpeedData> util = new ExcelUtil<SpeedData>(SpeedData.class);
        util.exportExcel(response, list, "运动数据数据");
    }

    /**
     * 获取运动数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('location:speed:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(speedDataService.selectSpeedDataById(id));
    }

    /**
     * 新增运动数据
     */
    @PreAuthorize("@ss.hasPermi('location:speed:add')")
    @Log(title = "运动数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SpeedData speedData)
    {
        return toAjax(speedDataService.insertSpeedData(speedData));
    }

    /**
     * 修改运动数据
     */
    @PreAuthorize("@ss.hasPermi('location:speed:edit')")
    @Log(title = "运动数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SpeedData speedData)
    {
        return toAjax(speedDataService.updateSpeedData(speedData));
    }

    /**
     * 删除运动数据
     */
    @PreAuthorize("@ss.hasPermi('location:speed:remove')")
    @Log(title = "运动数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(speedDataService.deleteSpeedDataByIds(ids));
    }
}
