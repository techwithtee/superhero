package com.wileyedge.superhero.dao;

import com.wileyedge.superhero.model.HeroSighting;
import com.wileyedge.superhero.model.Sighting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class SightDaoImpl implements SightDao {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Sighting> rowMapper;

    @Autowired
    public SightDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = (rs, rowNum) -> {
            Sighting sighting = new Sighting();
            sighting.setSightId(rs.getInt("sight_id"));
            sighting.setSightTitle(rs.getString("sight_title"));
            sighting.setSightingDate(String.valueOf(rs.getDate("sighting_date")));
            return sighting;
        };
    }

    @Override
    public Sighting createSighting(Sighting sighting) {
        String query = "INSERT INTO sighting (sight_title, sighting_date) VALUES (?, ?)";
        jdbcTemplate.update(
                query,
                sighting.getSightTitle(),
                sighting.getSightingDate()
        );
        return sighting;
    }

    @Override
    public Sighting getSightingById(int id) {
        String query = "SELECT * FROM sighting WHERE sight_id=?";
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }

    @Override
    public List<Sighting> getAllSightings() {
        String query = "SELECT * FROM sighting";
        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public Sighting updateSighting(Sighting sighting) {
        String query = "UPDATE sighting SET sight_title=?, sighting_date=? WHERE sight_id=?";
        jdbcTemplate.update(
                query,
                sighting.getSightTitle(),
                sighting.getSightingDate(),
                sighting.getSightId()
        );
        return sighting;
    }

    @Override
    public void deleteSighting(int id) {
        String query = "DELETE FROM sighting WHERE sight_id=?";
        jdbcTemplate.update(query, id);
    }


    @Override
    public List<HeroSighting> getSuperheroesAtLocation(int locationId) {
        String query = "SELECT hero.hero_name " +
                "FROM hero " +
                "INNER JOIN hero_sighting ON hero.hero_id = hero_sighting.hero_id " +
                "INNER JOIN sighting ON hero_sighting.sight_id = sighting.sight_id " +
                "WHERE sighting.location_id = ?";

        return jdbcTemplate.query(query, new Object[]{locationId}, (rs, rowNum) -> {
            HeroSighting heroSighting = new HeroSighting();
            heroSighting.setHeroName(rs.getString("hero_name"));
            return heroSighting;
        });
    }

    @Override
    public List<HeroSighting> getSightingsByDate(LocalDate date) {
        String sql = "SELECT h.hero_id, h.hero_name, s.sight_id, s.sighting_date, l.location_id, l.location_name " +
                "FROM sighting s " +
                "JOIN hero_sighting hs ON s.sight_id = hs.sight_id " +
                "JOIN hero h ON hs.hero_id = h.hero_id " +
                "JOIN location l ON s.location_id = l.location_id " +
                "WHERE s.sighting_date = ?";

        return jdbcTemplate.query(
                sql,
                new Object[] { date },
                (rs, rowNum) -> {
                    HeroSighting heroSighting = new HeroSighting();
                    heroSighting.setHeroId(rs.getInt("hero_id"));
                    heroSighting.setHeroName(rs.getString("hero_name"));
                    heroSighting.setSightId(rs.getInt("sight_id"));
                    heroSighting.setSightingDate(rs.getDate("sighting_date").toLocalDate());
                    heroSighting.setLocationId(rs.getInt("location_id"));
                    heroSighting.setLocationName(rs.getString("location_name"));
                    return heroSighting;
                }
        );
    }


}
