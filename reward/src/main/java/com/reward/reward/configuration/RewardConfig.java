package com.reward.reward.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import rewardCentral.RewardCentral;

@Configuration
public class RewardConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RewardCentral rewardCentral() {
        return new RewardCentral();
    }
}
