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
import fun.guardianelf.location.domain.MotionInfo;
import fun.guardianelf.location.service.IMotionInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 运动信息Controller
 * 
 * @author pc
 * @date 2025-12-09
 */
@RestController
@RequestMapping("/location/motion")
@DataSource(value = DataSourceType.LOCATION)
public class MotionInfoController extends BaseController
{
    @Autowired
    private IMotionInfoService motionInfoService;

    /**
     * 查询运动信息列表
     */
    @PreAuthorize("@ss.hasPermi('location:motion:list')")
    @GetMapping("/list")
    public TableDataInfo list(MotionInfo motionInfo)
    {
        startPage();
        List<MotionInfo> list = motionInfoService.selectMotionInfoList(motionInfo);
        return getDataTable(list);
    }

    /**
     * 导出运动信息列表
     */
    @PreAuthorize("@ss.hasPermi('location:motion:export')")
    @Log(title = "运动信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MotionInfo motionInfo)
    {
        List<MotionInfo> list = motionInfoService.selectMotionInfoList(motionInfo);
        ExcelUtil<MotionInfo> util = new ExcelUtil<MotionInfo>(MotionInfo.class);
        util.exportExcel(response, list, "运动信息数据");
    }

    /**
     * 获取运动信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('location:motion:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(motionInfoService.selectMotionInfoById(id));
    }

    /**
     * 新增运动信息
     */
    @PreAuthorize("@ss.hasPermi('location:motion:add')")
    @Log(title = "运动信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MotionInfo motionInfo)
    {
        return toAjax(motionInfoService.insertMotionInfo(motionInfo));
    }

    /**
     * 修改运动信息
     */
    @PreAuthorize("@ss.hasPermi('location:motion:edit')")
    @Log(title = "运动信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MotionInfo motionInfo)
    {
        return toAjax(motionInfoService.updateMotionInfo(motionInfo));
    }

    /**
     * 删除运动信息
     */
    @PreAuthorize("@ss.hasPermi('location:motion:remove')")
    @Log(title = "运动信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(motionInfoService.deleteMotionInfoByIds(ids));
    }
}
