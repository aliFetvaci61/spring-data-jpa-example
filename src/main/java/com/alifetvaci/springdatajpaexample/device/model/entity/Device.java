package com.alifetvaci.springdatajpaexample.device.model.entity;

import com.alifetvaci.springdatajpaexample.common.entity.BaseEntity;
import com.alifetvaci.springdatajpaexample.device.model.enums.Platform;
import com.alifetvaci.springdatajpaexample.device.model.enums.PlatformConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;


@Entity
@Table(name = "device")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@SequenceGenerator(name = "default_seq_gen", sequenceName = "device_id_seq", allocationSize = 1)
public class Device extends BaseEntity {

    @Column(unique = true)
    private String clientId;

    @Convert(converter = PlatformConverter.class)
    @Column(name = "platform", columnDefinition = "INTEGER CHECK (platform IN (0, 1, 2))")
    private Platform platform;

    @Column(nullable = false, updatable = false)
    private String model;
}
