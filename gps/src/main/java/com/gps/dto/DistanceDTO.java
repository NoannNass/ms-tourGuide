package com.gps.dto;

public class DistanceDTO {
    public double distanceMiles;

    public DistanceDTO(double distanceMiles) {
        this.distanceMiles = distanceMiles;
    }

    public DistanceDTO() {
    }

    public double getDistanceMiles() {
        return distanceMiles;
    }

    public void setDistanceMiles(double distanceMiles) {
        this.distanceMiles = distanceMiles;
    }
}
