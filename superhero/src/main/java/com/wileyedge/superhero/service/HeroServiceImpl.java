package com.wileyedge.superhero.service;

import com.wileyedge.superhero.dao.HeroDao;
import com.wileyedge.superhero.model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    private final HeroDao heroDao;

    @Autowired
    public HeroServiceImpl(HeroDao heroDao) {
        this.heroDao = heroDao;
    }

    @Override
    public Hero createHero(Hero hero) {
        return heroDao.createHero(hero);
    }

    @Override
    public Hero getHeroById(int id) {
        return heroDao.getHeroById(id);
    }

    @Override
    public List<Hero> getAllHeroes() {
        return heroDao.getAllHeroes();
    }

    @Override
    public void updateHero(Hero hero) {
        heroDao.updateHero(hero);
    }

    @Override
    public void deleteHero(int id) {
        heroDao.deleteHero(id);
    }
}
