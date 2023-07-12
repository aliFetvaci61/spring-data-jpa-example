package com.alifetvaci.springdatajpaexample.device.model.request;

import com.alifetvaci.springdatajpaexample.device.model.enums.Platform;
import com.alifetvaci.springdatajpaexample.device.model.enums.PlatformConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Convert;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDeviceRequest {

    private String clientId;

    @Convert(converter = PlatformConverter.class)
    @Column(name = "platform", columnDefinition = "INTEGER CHECK (platform IN (0, 1, 2))")
    private Platform platform;

    private String model;
}
