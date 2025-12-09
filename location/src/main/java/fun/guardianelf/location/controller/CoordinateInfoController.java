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
import fun.guardianelf.location.domain.CoordinateInfo;
import fun.guardianelf.location.service.ICoordinateInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 坐标信息Controller
 * 
 * @author pc
 * @date 2025-12-09
 */
@RestController
@RequestMapping("/location/coordinate")
@DataSource(value = DataSourceType.LOCATION)
public class CoordinateInfoController extends BaseController
{
    @Autowired
    private ICoordinateInfoService coordinateInfoService;

    /**
     * 查询坐标信息列表
     */
    @PreAuthorize("@ss.hasPermi('location:coordinate:list')")
    @GetMapping("/list")
    public TableDataInfo list(CoordinateInfo coordinateInfo)
    {
        startPage();
        List<CoordinateInfo> list = coordinateInfoService.selectCoordinateInfoList(coordinateInfo);
        return getDataTable(list);
    }

    /**
     * 导出坐标信息列表
     */
    @PreAuthorize("@ss.hasPermi('location:coordinate:export')")
    @Log(title = "坐标信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CoordinateInfo coordinateInfo)
    {
        List<CoordinateInfo> list = coordinateInfoService.selectCoordinateInfoList(coordinateInfo);
        ExcelUtil<CoordinateInfo> util = new ExcelUtil<CoordinateInfo>(CoordinateInfo.class);
        util.exportExcel(response, list, "坐标信息数据");
    }

    /**
     * 获取坐标信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('location:coordinate:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(coordinateInfoService.selectCoordinateInfoById(id));
    }

    /**
     * 新增坐标信息
     */
    @PreAuthorize("@ss.hasPermi('location:coordinate:add')")
    @Log(title = "坐标信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CoordinateInfo coordinateInfo)
    {
        return toAjax(coordinateInfoService.insertCoordinateInfo(coordinateInfo));
    }

    /**
     * 修改坐标信息
     */
    @PreAuthorize("@ss.hasPermi('location:coordinate:edit')")
    @Log(title = "坐标信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CoordinateInfo coordinateInfo)
    {
        return toAjax(coordinateInfoService.updateCoordinateInfo(coordinateInfo));
    }

    /**
     * 删除坐标信息
     */
    @PreAuthorize("@ss.hasPermi('location:coordinate:remove')")
    @Log(title = "坐标信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(coordinateInfoService.deleteCoordinateInfoByIds(ids));
    }
}
