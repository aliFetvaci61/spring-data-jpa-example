package com.alifetvaci.springdatajpaexample.token.model.entity;

import com.alifetvaci.springdatajpaexample.common.entity.BaseEntity;
import com.alifetvaci.springdatajpaexample.device.model.entity.Device;
import com.alifetvaci.springdatajpaexample.user.model.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "token")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@SequenceGenerator(name = "default_seq_gen", sequenceName = "token_id_seq", allocationSize = 1)
public class Token extends BaseEntity {

    @Column(name = "token", unique = true, updatable = false)
    private String token;

    @Column(name = "expire_time", updatable = false, nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime expireTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "device_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Device device;

}
