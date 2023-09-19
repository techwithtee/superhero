package com.wileyedge.superhero.controller;

import com.wileyedge.superhero.model.Location;
import com.wileyedge.superhero.service.LocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocController {

    private final LocService locService;

    @Autowired
    public LocController(LocService locService) {
        this.locService = locService;
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locService.createLocation(location);
    }

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable int id) {
        return locService.getLocationById(id);
    }

    @GetMapping
    public List<Location> getAllLocations() {
        return locService.getAllLocations();
    }

    @PutMapping("/{id}")
    public void updateLocation(@PathVariable int id, @RequestBody Location location) {
        locService.updateLocation(location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable int id) {
        locService.deleteLocation(id);
    }
}
