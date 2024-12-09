package com.example.demo.resttemplatedemo.service.impl;

import com.example.demo.resttemplatedemo.service.IDomainService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DomainService implements IDomainService {

    private final RestTemplate restTemplate;

    public DomainService(@Qualifier("restTemplateA") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getResult() {
        ResponseEntity<Object> response = restTemplate.getForEntity("http://localhost:8200/config/v1/agents?service.name=demo-service", Object.class);

        return response.getBody().toString();
    }
}
