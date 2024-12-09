package com.example.demo.resttemplatedemo.controller;

import com.example.demo.resttemplatedemo.service.IDomainService;
import com.example.demo.resttemplatedemo.service.ITokenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class demoController {
    private final ITokenService tokenService;
    private final IDomainService domainService;

    public demoController(ITokenService tokenService, IDomainService domainService) {
        this.tokenService = tokenService;
        this.domainService = domainService;
    }

    @GetMapping(value = "directCall")
    public String directCall() {
        return tokenService.getToken();
    }

    @GetMapping(value="serviceCall")
    public String serviceCall() {
        return domainService.getResult();
    }
}
