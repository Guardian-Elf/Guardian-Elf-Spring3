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
import fun.guardianelf.location.domain.GpsData;
import fun.guardianelf.location.service.IGpsDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * GPS数据Controller
 * 
 * @author pc
 * @date 2025-12-09
 */
@RestController
@RequestMapping("/location/data")
@DataSource(value = DataSourceType.LOCATION)
public class GpsDataController extends BaseController
{
    @Autowired
    private IGpsDataService gpsDataService;

    /**
     * 查询GPS数据列表
     */
    @PreAuthorize("@ss.hasPermi('location:data:list')")
    @GetMapping("/list")
    public TableDataInfo list(GpsData gpsData)
    {
        startPage();
        List<GpsData> list = gpsDataService.selectGpsDataList(gpsData);
        return getDataTable(list);
    }

    /**
     * 导出GPS数据列表
     */
    @PreAuthorize("@ss.hasPermi('location:data:export')")
    @Log(title = "GPS数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GpsData gpsData)
    {
        List<GpsData> list = gpsDataService.selectGpsDataList(gpsData);
        ExcelUtil<GpsData> util = new ExcelUtil<GpsData>(GpsData.class);
        util.exportExcel(response, list, "GPS数据数据");
    }

    /**
     * 获取GPS数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('location:data:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(gpsDataService.selectGpsDataById(id));
    }

    /**
     * 新增GPS数据
     */
    @PreAuthorize("@ss.hasPermi('location:data:add')")
    @Log(title = "GPS数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GpsData gpsData)
    {
        return toAjax(gpsDataService.insertGpsData(gpsData));
    }

    /**
     * 修改GPS数据
     */
    @PreAuthorize("@ss.hasPermi('location:data:edit')")
    @Log(title = "GPS数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GpsData gpsData)
    {
        return toAjax(gpsDataService.updateGpsData(gpsData));
    }

    /**
     * 删除GPS数据
     */
    @PreAuthorize("@ss.hasPermi('location:data:remove')")
    @Log(title = "GPS数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(gpsDataService.deleteGpsDataByIds(ids));
    }
}
