package com.wileyedge.superhero.controller;

import com.wileyedge.superhero.model.Sighting;
import com.wileyedge.superhero.model.HeroSighting;
import com.wileyedge.superhero.service.SightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/superheroes-at-location/{locationId}")
    public List<HeroSighting> getSuperheroesAtLocation(@PathVariable int locationId) {
        return sightService.getSuperheroesAtLocation(locationId);
    }

    @GetMapping("/sightings-by-date")
    public ResponseEntity<List<HeroSighting>> getSightingsByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<HeroSighting> sightings = sightService.getSightingsByDate(date);
        return new ResponseEntity<>(sightings, HttpStatus.OK);
    }

}
