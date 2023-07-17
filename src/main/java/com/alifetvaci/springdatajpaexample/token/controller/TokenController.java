package com.alifetvaci.springdatajpaexample.token.controller;


import com.alifetvaci.springdatajpaexample.token.model.request.CreateTokenRequest;
import com.alifetvaci.springdatajpaexample.token.model.response.TokenResponse;
import com.alifetvaci.springdatajpaexample.token.service.TokenService;
import com.alifetvaci.springdatajpaexample.user.model.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/token")
@Slf4j
@RequiredArgsConstructor
public class TokenController {

    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenResponse> createToken(@RequestBody CreateTokenRequest  createTokenRequest) {

        String token = tokenService.createToken(createTokenRequest.getUserId(), createTokenRequest.getDeviceId());

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);
        return new ResponseEntity<>(tokenResponse,HttpStatus.OK);
    }
}
