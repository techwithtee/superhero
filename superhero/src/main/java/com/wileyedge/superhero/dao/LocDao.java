package com.wileyedge.superhero.dao;

import com.wileyedge.superhero.model.Location;

import java.util.List;

public interface LocDao {

    Location createLocation(Location location);

    Location getLocationById(int id);

    List<Location> getAllLocations();

    void updateLocation(Location location);

    void deleteLocation(int id);

    List<Location> getLocationsByHero(int heroId);
}
