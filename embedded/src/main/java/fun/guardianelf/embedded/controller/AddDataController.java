package fun.guardianelf.embedded.controller;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.DataSourceType;
import fun.guardianelf.embedded.pojo.CoordinateInfo;
import fun.guardianelf.embedded.pojo.EnvironmentData;
import fun.guardianelf.embedded.pojo.Gp10Data;
import fun.guardianelf.embedded.pojo.SpeedData;
import fun.guardianelf.embedded.service.IAddDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

// 嵌入式设备添加数据的控制层
@RestController
@RequestMapping("/embedded/data")
@DataSource(value = DataSourceType.LOCATION)
public class AddDataController {

    @Autowired
    private IAddDataService addDataService;

    // 添加GPS数据
    @GetMapping("/GPS")
    public AjaxResult GPS(@RequestBody Gp10Data gp10Data, @RequestParam Long deviceId, @RequestParam LocalDateTime localTime)
    {
        addDataService.addGpsData(gp10Data, deviceId, localTime);
        return AjaxResult.success();
    }

    // 添加环境数据
    @GetMapping("/environment")
    public AjaxResult environment(@RequestBody EnvironmentData environmentData, @RequestParam Long deviceId, @RequestParam LocalDateTime localTime) {
        addDataService.addEnvironmentData(environmentData, deviceId, localTime);
        return AjaxResult.success();
    }

    // 添加运动数据
    @GetMapping("/speed")
    public AjaxResult speed(@RequestBody SpeedData speedData, @RequestParam Long deviceId, @RequestParam LocalDateTime localTime) {
        addDataService.addSpeedData(speedData, deviceId, localTime);
        return AjaxResult.success();
    }
}
