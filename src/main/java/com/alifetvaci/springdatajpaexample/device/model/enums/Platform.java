package com.alifetvaci.springdatajpaexample.device.model.enums;

import java.util.stream.Stream;

public enum Platform {
    IOS(0), ANDROID(1), HUAWEI(2);

    private final int value;

    Platform(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Platform of(int value) {
        return Stream.of(Platform.values())
                .filter(name -> name.getValue() == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
