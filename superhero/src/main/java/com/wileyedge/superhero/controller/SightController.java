package com.wileyedge.superhero.controller;

import com.wileyedge.superhero.model.Sighting;
import com.wileyedge.superhero.service.SightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sightings")
public class SightController {

    private final SightService sightService;

    @Autowired
    public SightController(SightService sightService) {
        this.sightService = sightService;
    }

    @PostMapping
    public Sighting createSighting(@RequestBody Sighting sighting) {
        return sightService.createSighting(sighting);
    }

    @GetMapping("/{id}")
    public Sighting getSightingById(@PathVariable int id) {
        return sightService.getSightingById(id);
    }

    @GetMapping
    public List<Sighting> getAllSightings() {
        return sightService.getAllSightings();
    }

    @PutMapping("/{id}")
    public void updateSighting(@PathVariable int id, @RequestBody Sighting sighting) {
        sightService.updateSighting(sighting);
    }

    @DeleteMapping("/{id}")
    public void deleteSighting(@PathVariable int id) {
        sightService.deleteSighting(id);
    }
}
