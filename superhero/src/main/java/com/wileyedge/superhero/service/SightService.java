package com.wileyedge.superhero.service;

import com.wileyedge.superhero.model.HeroSighting;
import com.wileyedge.superhero.model.Sighting;

import java.time.LocalDate;
import java.util.List;

public interface SightService {
    Sighting createSighting(Sighting sighting);
    Sighting getSightingById(int id);
    List<Sighting> getAllSightings();
    void updateSighting(Sighting sighting);
    void deleteSighting(int id);
    List<HeroSighting> getSuperheroesAtLocation(int locationId);
    List<HeroSighting> getSightingsByDate(LocalDate date);


}
