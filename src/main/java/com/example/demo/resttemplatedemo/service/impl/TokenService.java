package com.example.demo.resttemplatedemo.service.impl;

import com.example.demo.resttemplatedemo.service.ITokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TokenService implements ITokenService {

    private final RestTemplate restTemplate;

    public TokenService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getToken() {
        ResponseEntity<Object> response = restTemplate.getForEntity("http://localhost:8200", Object.class);

        return response.getBody().toString();
    }
}
