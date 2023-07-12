package com.alifetvaci.springdatajpaexample.user.controller;


import com.alifetvaci.springdatajpaexample.device.model.entity.Device;
import com.alifetvaci.springdatajpaexample.device.model.enums.Platform;
import com.alifetvaci.springdatajpaexample.device.model.request.CreateDeviceRequest;
import com.alifetvaci.springdatajpaexample.device.service.DeviceService;
import com.alifetvaci.springdatajpaexample.user.model.entity.User;
import com.alifetvaci.springdatajpaexample.user.model.request.CreateUserRequest;
import com.alifetvaci.springdatajpaexample.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<User> getByName(@RequestHeader String name) {

        User user = userService.findByName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createDevice(@RequestBody CreateUserRequest createUserRequest) {

        userService.saveOrUpdate(createUserRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
