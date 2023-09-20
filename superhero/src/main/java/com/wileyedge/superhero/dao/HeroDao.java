package com.wileyedge.superhero.dao;

import java.util.List;
import com.wileyedge.superhero.model.Hero;
import com.wileyedge.superhero.model.HeroOrg;
import com.wileyedge.superhero.model.HeroSighting;

public interface HeroDao {
    Hero createHero(Hero hero);
    Hero getHeroById(int id);
    List<Hero> getAllHeroes();
    void updateHero(Hero hero);
    void deleteHero(int id);
    // Additional query methods
    List<HeroOrg> getOrganisationsOfHero(int heroId);
    void recordHeroSighting(HeroSighting heroSighting);

}
