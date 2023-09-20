package com.wileyedge.superhero.service;

import com.wileyedge.superhero.model.Hero;
import com.wileyedge.superhero.model.HeroOrg;
import com.wileyedge.superhero.model.HeroSighting;

import java.util.List;

public interface HeroService {
    Hero createHero(Hero hero);
    Hero getHeroById(int id);
    List<Hero> getAllHeroes();
    void updateHero(Hero hero);
    void deleteHero(int id);
    List<HeroOrg> getOrganisationsOfHero(int heroId);

    void recordHeroSighting(HeroSighting heroSighting);


}
