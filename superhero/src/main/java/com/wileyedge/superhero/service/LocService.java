package com.wileyedge.superhero.service;

import com.wileyedge.superhero.model.Location;
import java.util.List;

public interface LocService {
    Location createLocation(Location location);
    Location getLocationById(int id);
    List<Location> getAllLocations();
    void updateLocation(Location location);
    void deleteLocation(int id);
}
