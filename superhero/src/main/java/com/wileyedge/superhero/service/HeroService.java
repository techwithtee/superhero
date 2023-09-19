package com.wileyedge.superhero.service;

import com.wileyedge.superhero.model.Hero;
import java.util.List;

public interface HeroService {
    Hero createHero(Hero hero);
    Hero getHeroById(int id);
    List<Hero> getAllHeroes();
    void updateHero(Hero hero);
    void deleteHero(int id);
}
