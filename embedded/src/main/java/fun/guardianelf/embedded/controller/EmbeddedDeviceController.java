package fun.guardianelf.embedded.controller;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.DataSourceType;
import fun.guardianelf.embedded.service.IEmbeddedDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/embedded/device")
@DataSource(value = DataSourceType.LOCATION)
public class EmbeddedDeviceController {
    @Autowired
    private IEmbeddedDeviceService embeddedDeviceService;
    // 根据设备编号获取设备id

    @RequestMapping("/id/{serial}")
    public AjaxResult getDeviceIdBySerial(@PathVariable String serial) {
        Long id = embeddedDeviceService.getDeviceIdBySerial(serial);
        return AjaxResult.success(id);

    }

}
