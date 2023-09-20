package com.wileyedge.superhero.model;

import java.time.LocalDate;

public class HeroSighting {
    private int heroId;
    private String heroName;
    private int sightId;
    private LocalDate sightingDate;
    private int locationId;
    private String locationName;

    public HeroSighting() {
    }

    public HeroSighting(int heroId, String heroName, int sightId, LocalDate sightingDate, int locationId, String locationName) {
        this.heroId = heroId;
        this.heroName = heroName;
        this.sightId = sightId;
        this.sightingDate = sightingDate;
        this.locationId = locationId;
        this.locationName = locationName;
    }

    // Getters and setters

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getSightId() {
        return sightId;
    }

    public void setSightId(int sightId) {
        this.sightId = sightId;
    }

    public LocalDate getSightingDate() {
        return sightingDate;
    }

    public void setSightingDate(LocalDate sightingDate) {
        this.sightingDate = sightingDate;
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
}
