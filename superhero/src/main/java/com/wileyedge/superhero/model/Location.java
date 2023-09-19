package com.wileyedge.superhero.model;

import java.math.BigDecimal;

public class Location {
    private int locationId;
    private String locationName;
    private String locationDesc;
    private String locationAddress;
    private BigDecimal locationLat;
    private BigDecimal locationLong;

    public Location() {
        // Default constructor
    }

    public Location(int locationId, String locationName, String locationDesc, String locationAddress, BigDecimal locationLat, BigDecimal locationLong) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.locationDesc = locationDesc;
        this.locationAddress = locationAddress;
        this.locationLat = locationLat;
        this.locationLong = locationLong;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public BigDecimal getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(BigDecimal locationLat) {
        this.locationLat = locationLat;
    }

    public BigDecimal getLocationLong() {
        return locationLong;
    }

    public void setLocationLong(BigDecimal locationLong) {
        this.locationLong = locationLong;
    }

    @Override
    public String toString() {
        return "Location [locationId=" + locationId + ", locationName=" + locationName + ", locationDesc=" + locationDesc + ", locationAddress=" + locationAddress + ", locationLat=" + locationLat + ", locationLong=" + locationLong + "]";
    }

}
