package com.gps.controller;


import com.gps.dto.DistanceDTO;
import com.gps.service.GpsService;
import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.Location;
import gpsUtil.location.VisitedLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/gps/location")
public class GpsController {

    @Autowired
    private GpsUtil gpsUtil;

    @GetMapping("/attractions")
    public List<Attraction> getAttractions() {
        return gpsUtil.getAttractions();
    }

    @GetMapping("/attraction/{userId}")
    public VisitedLocation getUserLocation(@PathVariable UUID userId) {
        return gpsUtil.getUserLocation(userId);
    }


    @GetMapping("/distance")
    public DistanceDTO calculateDistance(
            @RequestParam double lat1,
            @RequestParam double lon1,
            @RequestParam double lat2,
            @RequestParam double lon2) {

        Location location1 = new Location(lat1, lon1);
        Location location2 = new Location(lat2, lon2);

        double distance = GpsService.calculateDistance(location1, location2);
        return new DistanceDTO(distance);
    }
}



