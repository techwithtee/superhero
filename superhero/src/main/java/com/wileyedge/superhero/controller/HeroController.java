package com.wileyedge.superhero.controller;

import com.wileyedge.superhero.model.Hero;
import com.wileyedge.superhero.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
