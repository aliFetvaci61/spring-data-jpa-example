package com.alifetvaci.springdatajpaexample.device.repository;

import com.alifetvaci.springdatajpaexample.device.model.entity.Device;
import com.alifetvaci.springdatajpaexample.device.model.enums.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {

    Optional<Device> findByClientIdAndPlatform(String clientId, Platform platform);

}
