package com.wileyedge.superhero.service;

import com.wileyedge.superhero.model.Sighting;
import java.util.List;

public interface SightService {
    Sighting createSighting(Sighting sighting);
    Sighting getSightingById(int id);
    List<Sighting> getAllSightings();
    void updateSighting(Sighting sighting);
    void deleteSighting(int id);
}
