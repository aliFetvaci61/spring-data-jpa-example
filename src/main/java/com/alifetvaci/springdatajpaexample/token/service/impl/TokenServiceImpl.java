package com.alifetvaci.springdatajpaexample.token.service.impl;

import com.alifetvaci.springdatajpaexample.device.model.entity.Device;
import com.alifetvaci.springdatajpaexample.device.repository.DeviceRepository;
import com.alifetvaci.springdatajpaexample.token.model.entity.Token;
import com.alifetvaci.springdatajpaexample.token.repository.TokenRepository;
import com.alifetvaci.springdatajpaexample.token.service.TokenService;
import com.alifetvaci.springdatajpaexample.user.model.entity.User;
import com.alifetvaci.springdatajpaexample.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {


    private final TokenRepository tokenRepository;

    private final UserRepository userRepository;

    private final DeviceRepository deviceRepository;

    private long expireInMinutes=129600;


    @Override
    public String createToken(Long userId, Long deviceId) {

        Device device = deviceRepository.findById(deviceId).orElseThrow();

        User user = userRepository.findById(userId).orElseThrow();

        UUID uuid = UUID.randomUUID();
        Token token = Token.builder().token(uuid.toString()).device(device).user(user).expireTime(OffsetDateTime.now().plusMinutes(expireInMinutes)).build();
        tokenRepository.save(token);
        return token.getToken();

    }

}
