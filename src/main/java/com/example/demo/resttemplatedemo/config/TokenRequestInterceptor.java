package com.example.demo.resttemplatedemo.config;

import com.example.demo.resttemplatedemo.service.ITokenService;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.io.IOException;

public class TokenRequestInterceptor implements ClientHttpRequestInterceptor {

    private final ITokenService tokenService;

    public TokenRequestInterceptor(ITokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpRequestWrapper wrapper = new HttpRequestWrapper(request);
        wrapper.getHeaders().set("token", tokenService.getToken());
        return execution.execute(wrapper, body);
    }
}
