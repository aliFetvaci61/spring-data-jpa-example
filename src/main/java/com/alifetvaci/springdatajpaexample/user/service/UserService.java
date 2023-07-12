package com.alifetvaci.springdatajpaexample.user.service;

import com.alifetvaci.springdatajpaexample.device.model.entity.Device;
import com.alifetvaci.springdatajpaexample.device.model.enums.Platform;
import com.alifetvaci.springdatajpaexample.user.model.entity.User;
import com.alifetvaci.springdatajpaexample.user.model.request.CreateUserRequest;

public interface UserService {

    User findByName(String name);

    void saveOrUpdate(CreateUserRequest createUserRequest);
}
