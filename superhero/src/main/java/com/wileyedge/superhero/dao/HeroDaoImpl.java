package com.wileyedge.superhero.dao;

import com.wileyedge.superhero.model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HeroDaoImpl implements HeroDao {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Hero> rowMapper;

    @Autowired
    public HeroDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = (rs, rowNum) -> {
            Hero hero = new Hero();
            hero.setHeroId(rs.getInt("hero_id"));
            hero.setHeroName(rs.getString("hero_name"));
            hero.setHeroDesc(rs.getString("hero_desc"));
            hero.setSuperpower(rs.getString("superpower"));
            return hero;
        };
    }

    @Override
    public Hero getHeroById(int id) {
        String query = "SELECT * FROM hero WHERE hero_id=?";
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }

    @Override
    public List<Hero> getAllHeroes() {
        String query = "SELECT * FROM hero";
        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public void updateHero(Hero hero) {
        String query = "UPDATE hero SET hero_name=?, hero_desc=?, superpower=? WHERE hero_id=?";
        jdbcTemplate.update(query, hero.getHeroName(), hero.getHeroDesc(), hero.getSuperpower(), hero.getHeroId());
    }

    @Override
    public void deleteHero(int id) {
        String query = "DELETE FROM hero WHERE hero_id=?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public Hero createHero(Hero hero) {
        String query = "INSERT INTO hero (hero_name, hero_desc, superpower) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, hero.getHeroName(), hero.getHeroDesc(), hero.getSuperpower());
        return hero;
    }
}
