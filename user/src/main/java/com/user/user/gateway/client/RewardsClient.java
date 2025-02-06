package com.user.user.gateway.client;

import org.springframework.web.client.RestTemplate;

public class RewardsClient {

    private final RestTemplate restTemplate;
    private final String baseUrl;


    public RewardsClient(RestTemplate restTemplate, String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }
}
