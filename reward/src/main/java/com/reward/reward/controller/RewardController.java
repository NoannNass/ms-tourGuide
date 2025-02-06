package com.reward.reward.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import rewardCentral.RewardCentral;

import java.util.UUID;

@RestController
@RequestMapping("/reward")
public class RewardController {

   @Autowired
   private RestTemplate restTemplate;

   @Autowired
    private RewardCentral rewardCentral;

   @GetMapping("/{attractionId}, {userId}")
    public int getRewardPoints(@PathVariable UUID attractionId, @PathVariable UUID userId){
       return rewardCentral.getAttractionRewardPoints(attractionId, userId);
    }


}
