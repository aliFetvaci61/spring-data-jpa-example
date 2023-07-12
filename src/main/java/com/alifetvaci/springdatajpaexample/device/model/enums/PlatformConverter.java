package com.alifetvaci.springdatajpaexample.device.model.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Converter(autoApply = true)
public class PlatformConverter implements AttributeConverter<Platform, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Platform platform) {
        return Objects.isNull(platform) ? null : platform.getValue();
    }

    @Override
    public Platform convertToEntityAttribute(Integer value) {
        return Objects.isNull(value) ? null : Platform.of(value);
    }
}
