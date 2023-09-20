package com.wileyedge.superhero.controller;

import com.wileyedge.superhero.model.Hero;
import com.wileyedge.superhero.model.HeroOrg;
import com.wileyedge.superhero.model.HeroSighting;
import com.wileyedge.superhero.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    private final HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @PostMapping
    public Hero createHero(@RequestBody Hero hero) {
        return heroService.createHero(hero);
    }

    @GetMapping("/{id}")
    public Hero getHeroById(@PathVariable int id) {
        return heroService.getHeroById(id);
    }

    @GetMapping
    public List<Hero> getAllHeroes() {
        return heroService.getAllHeroes();
    }

    @PutMapping("/{id}")
    public void updateHero(@PathVariable int id, @RequestBody Hero hero) {
        heroService.updateHero(hero);
    }

    @DeleteMapping("/{id}")
    public void deleteHero(@PathVariable int id) {
        heroService.deleteHero(id);
    }

    @GetMapping("/heroes/{heroId}/organisations")
    public ResponseEntity<List<HeroOrg>> getOrganisationsOfHero(@PathVariable int heroId) {
        List<HeroOrg> organisations = heroService.getOrganisationsOfHero(heroId);
        return new ResponseEntity<>(organisations, HttpStatus.OK);
    }

    @PostMapping("/heroes/sightings")
    public ResponseEntity<String> recordHeroSighting(@RequestBody HeroSighting heroSighting) {
        // Validate input and process the request in the service layer
        heroService.recordHeroSighting(heroSighting);
        return new ResponseEntity<>("Hero sighting recorded successfully", HttpStatus.CREATED);
    }


}
