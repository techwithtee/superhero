package com.wileyedge.superhero.service;

import com.wileyedge.superhero.dao.SightDao;
import com.wileyedge.superhero.model.HeroSighting;
import com.wileyedge.superhero.model.Sighting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SightServiceImpl implements SightService {

    private final SightDao sightDao;

    @Autowired
    public SightServiceImpl(SightDao sightDao) {
        this.sightDao = sightDao;
    }

    @Override
    public Sighting createSighting(Sighting sighting) {
        return sightDao.createSighting(sighting);
    }

    @Override
    public Sighting getSightingById(int id) {
        return sightDao.getSightingById(id);
    }

    @Override
    public List<Sighting> getAllSightings() {
        return sightDao.getAllSightings();
    }

    @Override
    public void updateSighting(Sighting sighting) {
        sightDao.updateSighting(sighting);
    }

    @Override
    public void deleteSighting(int id) {
        sightDao.deleteSighting(id);
    }

    @Override
    public List<HeroSighting> getSuperheroesAtLocation(int locationId) {
        return sightDao.getSuperheroesAtLocation(locationId);
    }

    @Override
    public List<HeroSighting> getSightingsByDate(LocalDate date) {
        return sightDao.getSightingsByDate(date);
    }


}
