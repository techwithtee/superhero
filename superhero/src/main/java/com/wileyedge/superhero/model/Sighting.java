package com.wileyedge.superhero.model;

import java.util.Date;

public class Sighting {
    private int sightId;
    private String sightTitle;
    @lombok.Setter
    private String sightingDate;
    private int locationId;

    public Sighting() {
        // Default constructor
    }

    public Sighting(int sightId, String sightTitle, Date sightingDate, int locationId) {
        this.sightId = sightId;
        this.sightTitle = sightTitle;
        this.sightingDate = String.valueOf(sightingDate);
        this.locationId = locationId;
    }

    public Sighting(int i, String supermanSpotted, String date) {
    }

    public int getSightId() {
        return sightId;
    }

    public void setSightId(int sightId) {
        this.sightId = sightId;
    }

    public String getSightTitle() {
        return sightTitle;
    }

    public void setSightTitle(String sightTitle) {
        this.sightTitle = sightTitle;
    }

    public String getSightingDate() {
        return sightingDate;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "Sighting [sightId=" + sightId + ", sightTitle=" + sightTitle + ", sightingDate=" + sightingDate + ", locationId=" + locationId + "]";
    }
}
