package com.alifetvaci.springdatajpaexample.device.service;

import com.alifetvaci.springdatajpaexample.device.model.entity.Device;
import com.alifetvaci.springdatajpaexample.device.model.enums.Platform;
import com.alifetvaci.springdatajpaexample.device.model.request.CreateDeviceRequest;

public interface DeviceService {

    Device findByClientIdAndPlatform(String clientId, Platform platform);

    void saveOrUpdate(CreateDeviceRequest device);
}
