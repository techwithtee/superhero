package com.wileyedge.superhero.dao;

import java.time.LocalDate;
import java.util.List;

import com.wileyedge.superhero.model.HeroSighting;
import com.wileyedge.superhero.model.Sighting;
public interface SightDao {
    Sighting createSighting(Sighting sighting);
    Sighting getSightingById(int id);
    List<Sighting> getAllSightings();
    Sighting updateSighting(Sighting sighting);
    void deleteSighting(int id);
    List<HeroSighting> getSuperheroesAtLocation(int locationId);
    List<HeroSighting> getSightingsByDate(LocalDate date);

}

