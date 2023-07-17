package com.alifetvaci.springdatajpaexample.user.model.entity;


import com.alifetvaci.springdatajpaexample.common.entity.BaseEntity;
import com.alifetvaci.springdatajpaexample.device.model.entity.Device;
import com.alifetvaci.springdatajpaexample.token.model.entity.Token;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@SequenceGenerator(name = "default_seq_gen", sequenceName = "users_id_seq", allocationSize = 1)
public class User extends BaseEntity {

    private String name;

    private String surname;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Token> Tokens = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    private Device device;
}
