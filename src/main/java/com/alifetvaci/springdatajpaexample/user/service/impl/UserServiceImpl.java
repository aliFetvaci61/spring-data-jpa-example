package com.alifetvaci.springdatajpaexample.user.service.impl;

import com.alifetvaci.springdatajpaexample.device.model.entity.Device;
import com.alifetvaci.springdatajpaexample.device.repository.DeviceRepository;
import com.alifetvaci.springdatajpaexample.user.model.entity.User;
import com.alifetvaci.springdatajpaexample.user.model.request.CreateUserRequest;
import com.alifetvaci.springdatajpaexample.user.repository.UserRepository;
import com.alifetvaci.springdatajpaexample.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final DeviceRepository deviceRepository;

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name).orElseThrow();
    }

    @Override
    @Transactional
    public void saveOrUpdate(CreateUserRequest createUserRequest) {
        Device device = deviceRepository.findById(createUserRequest.getDeviceId()).orElseThrow();
        User user = User.builder().name(createUserRequest.getName()).surname(createUserRequest.getSurname()).device(device).build();
        userRepository.save(user);
    }
}
