package com.alifetvaci.springdatajpaexample.token.service;

public interface TokenService {

    String createToken(Long userId, Long deviceId);

}
