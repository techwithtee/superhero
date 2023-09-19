package com.wileyedge.superhero.service;

import com.wileyedge.superhero.dao.LocDao;
import com.wileyedge.superhero.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocServiceImpl implements LocService {

    private final LocDao locDao;

    @Autowired
    public LocServiceImpl(LocDao locDao) {
        this.locDao = locDao;
    }

    @Override
    public Location createLocation(Location location) {
        return locDao.createLocation(location);
    }

    @Override
    public Location getLocationById(int id) {
        return locDao.getLocationById(id);
    }

    @Override
    public List<Location> getAllLocations() {
        return locDao.getAllLocations();
    }

    @Override
    public void updateLocation(Location location) {
        locDao.updateLocation(location);
    }

    @Override
    public void deleteLocation(int id) {
        locDao.deleteLocation(id);
    }
}
