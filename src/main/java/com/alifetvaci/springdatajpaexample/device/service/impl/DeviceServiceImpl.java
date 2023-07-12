package com.alifetvaci.springdatajpaexample.device.service.impl;

import com.alifetvaci.springdatajpaexample.device.model.entity.Device;
import com.alifetvaci.springdatajpaexample.device.model.enums.Platform;
import com.alifetvaci.springdatajpaexample.device.model.request.CreateDeviceRequest;
import com.alifetvaci.springdatajpaexample.device.repository.DeviceRepository;
import com.alifetvaci.springdatajpaexample.device.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;

    @Override
    public Device findByClientIdAndPlatform(String clientId, Platform platform) {
        return deviceRepository.findByClientIdAndPlatform(clientId,platform).orElseThrow();
    }

    @Override
    public void saveOrUpdate(CreateDeviceRequest createDeviceRequest) {
        final Device device = Device.builder().clientId(createDeviceRequest.getClientId()).platform(createDeviceRequest.getPlatform()).model(createDeviceRequest.getModel()).build();
        deviceRepository.save(device);
    }
}
