package fun.guardianelf.embedded.service.impl;

import fun.guardianelf.embedded.mapper.EmbeddedDeviceMapper;
import fun.guardianelf.embedded.service.IEmbeddedDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmbeddedDeviceService implements IEmbeddedDeviceService {
    @Autowired
    private EmbeddedDeviceMapper embeddedDeviceMapper;


    @Override
    public Long getDeviceIdBySerial(String serial) {
        Long id =  embeddedDeviceMapper.getDeviceIdBySerial(serial);
        if (id == null) {
            return -1L;
        }
        return id;
    }
}
