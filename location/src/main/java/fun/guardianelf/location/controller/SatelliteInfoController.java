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
import fun.guardianelf.location.domain.SatelliteInfo;
import fun.guardianelf.location.service.ISatelliteInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 卫星信息Controller
 * 
 * @author pc
 * @date 2025-12-09
 */
@RestController
@RequestMapping("/location/satellite")
@DataSource(value = DataSourceType.LOCATION)
public class SatelliteInfoController extends BaseController
{
    @Autowired
    private ISatelliteInfoService satelliteInfoService;

    /**
     * 查询卫星信息列表
     */
    @PreAuthorize("@ss.hasPermi('location:satellite:list')")
    @GetMapping("/list")
    public TableDataInfo list(SatelliteInfo satelliteInfo)
    {
        startPage();
        List<SatelliteInfo> list = satelliteInfoService.selectSatelliteInfoList(satelliteInfo);
        return getDataTable(list);
    }

    /**
     * 导出卫星信息列表
     */
    @PreAuthorize("@ss.hasPermi('location:satellite:export')")
    @Log(title = "卫星信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SatelliteInfo satelliteInfo)
    {
        List<SatelliteInfo> list = satelliteInfoService.selectSatelliteInfoList(satelliteInfo);
        ExcelUtil<SatelliteInfo> util = new ExcelUtil<SatelliteInfo>(SatelliteInfo.class);
        util.exportExcel(response, list, "卫星信息数据");
    }

    /**
     * 获取卫星信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('location:satellite:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(satelliteInfoService.selectSatelliteInfoById(id));
    }

    /**
     * 新增卫星信息
     */
    @PreAuthorize("@ss.hasPermi('location:satellite:add')")
    @Log(title = "卫星信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SatelliteInfo satelliteInfo)
    {
        return toAjax(satelliteInfoService.insertSatelliteInfo(satelliteInfo));
    }

    /**
     * 修改卫星信息
     */
    @PreAuthorize("@ss.hasPermi('location:satellite:edit')")
    @Log(title = "卫星信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SatelliteInfo satelliteInfo)
    {
        return toAjax(satelliteInfoService.updateSatelliteInfo(satelliteInfo));
    }

    /**
     * 删除卫星信息
     */
    @PreAuthorize("@ss.hasPermi('location:satellite:remove')")
    @Log(title = "卫星信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(satelliteInfoService.deleteSatelliteInfoByIds(ids));
    }
}
