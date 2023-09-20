package com.wileyedge.superhero.dao;

import com.wileyedge.superhero.model.Hero;
import com.wileyedge.superhero.model.HeroOrg;
import com.wileyedge.superhero.model.HeroSighting;
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

    @Override
    public List<HeroOrg> getOrganisationsOfHero(int heroId) {
        String query = "SELECT hero.hero_id, hero.hero_name, org.org_id, org.org_name " +
                "FROM hero " +
                "JOIN hero_organisation ho ON hero.hero_id = ho.hero_id " +
                "JOIN organisation org ON ho.org_id = org.org_id " +
                "WHERE hero.hero_id = ?";

        return jdbcTemplate.query(query, new Object[]{heroId}, (resultSet, i) -> {
            HeroOrg heroOrg = new HeroOrg();
            heroOrg.setHeroId(resultSet.getInt("hero_id"));
            heroOrg.setHeroName(resultSet.getString("hero_name"));
            heroOrg.setOrgId(resultSet.getInt("org_id"));
            heroOrg.setOrgName(resultSet.getString("org_name"));
            return heroOrg;
        });
    }

    @Override
    public void recordHeroSighting(HeroSighting heroSighting) {
        // Implement the logic to insert the sighting data into the database
        String sql = "INSERT INTO hero_sighting (hero_id, location_id, sighting_date) VALUES (?, ?, ?)";

        jdbcTemplate.update(
                sql,
                heroSighting.getHeroId(),
                heroSighting.getLocationId(),
                heroSighting.getSightingDate()
        );
    }

}
