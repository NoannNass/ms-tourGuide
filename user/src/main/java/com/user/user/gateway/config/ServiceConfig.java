package com.user.user.gateway.config;

import com.user.user.gateway.client.GpsClient;
import com.user.user.gateway.client.RewardsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServiceConfig {

    @Value("${services.gps.url}")
    private String gpsServiceUrl;

    @Value("${services.rewards.url")
    private String rewardsServiceUrl;

    @Bean
    public GpsClient gpsClient(RestTemplate restTemplate) {
        // création d'un client GPS qui utilisera le RestTemplate pour communiquer avec le service GPS
        return new GpsClient(restTemplate, gpsServiceUrl);
    }

    @Bean
    public RewardsClient rewardsClient(RestTemplate restTemplate) {
        // création d'un client Rewards qui utilisera le RestTemplate pour communiquer avec le service Rewards
        return new RewardsClient(restTemplate, rewardsServiceUrl);
    }

}
