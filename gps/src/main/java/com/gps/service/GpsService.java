package com.gps.service;

import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.Location;
import gpsUtil.location.VisitedLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class GpsService {


    private static final double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
    private final GpsUtil gpsUtil;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${reward.url}")
    private String rewardUrl;

    public GpsService(GpsUtil gpsUtil) {
        this.gpsUtil = gpsUtil;
    }

    public GpsUtil getGpsUtil() {
    return gpsUtil; }

    public VisitedLocation getUserLocation(java.util.UUID userId) {
    return gpsUtil.getUserLocation(userId);
    }


    public List<Attraction> getAttractions() {
    return gpsUtil.getAttractions();
    }

    public VisitedLocation trackUserLocation(UUID userId) {
        //option la localisation
        VisitedLocation visitedLocation = gpsUtil.getUserLocation(userId);
        //envoie la maj au user service
        restTemplate.postForEntity("http://localhost:8081/user/" + userId + "/location", visitedLocation, Void.class);
        //déclenche le calcul des rewards de manière asynchrone
        restTemplate.postForEntity(rewardUrl + "/reward/calculate/" + userId, visitedLocation, Void.class);

        return visitedLocation;
    }

    public static double calculateDistance(Location loc1, Location loc2) {
        //Conversion des coordonnées en radian
        double lat1 = Math.toRadians(loc1.latitude);
        double lon1 = Math.toRadians(loc1.longitude);
        double lat2 = Math.toRadians(loc2.latitude);
        double lon2 = Math.toRadians(loc2.longitude);

        //Calcul de la distance
        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

        // Conversion en miles nautiques puis statutaires
        double nauticalMiles = 60 * Math.toDegrees(angle);
        return STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
    }



}
