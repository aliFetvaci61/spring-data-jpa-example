package com.alifetvaci.springdatajpaexample.device.controller;


import com.alifetvaci.springdatajpaexample.device.model.entity.Device;
import com.alifetvaci.springdatajpaexample.device.model.enums.Platform;
import com.alifetvaci.springdatajpaexample.device.model.request.CreateDeviceRequest;
import com.alifetvaci.springdatajpaexample.device.repository.DeviceRepository;
import com.alifetvaci.springdatajpaexample.device.service.DeviceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/device")
@Slf4j
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping
    public ResponseEntity<Device> getDevice(@RequestHeader String clientId,
                                            @RequestHeader int platform) {

        Device device = deviceService.findByClientIdAndPlatform(clientId, Platform.of(platform));
        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createDevice(@RequestBody CreateDeviceRequest createDeviceRequest) {

        deviceService.saveOrUpdate(createDeviceRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
