package com.example.demo.resttemplatedemo.config;

import com.example.demo.resttemplatedemo.service.ITokenService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean("restTemplateA")
    public RestTemplate restTemplateA(RestTemplateBuilder builder, ITokenService tokenService) {
        TokenRequestInterceptor tokenRequestInterceptor = new TokenRequestInterceptor(tokenService);

        return builder.additionalInterceptors(tokenRequestInterceptor)
                .build();
    }
}
