package com.wileyedge.superhero.dao;

import java.util.List;
import com.wileyedge.superhero.model.Hero;

public interface HeroDao {
    Hero createHero(Hero hero);
    Hero getHeroById(int id);
    List<Hero> getAllHeroes();
    void updateHero(Hero hero);
    void deleteHero(int id);
    // Additional query methods
}
