package com.reward.reward.service;

import com.reward.reward.client.GpsClientService;
import org.springframework.stereotype.Service;

@Service
public class RewardService {
    private final GpsClientService gpsClientService;

    public RewardService(GpsClientService gpsClientService) {
        this.gpsClientService = gpsClientService;
    }



}
