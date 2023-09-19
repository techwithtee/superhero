package com.wileyedge.superhero.dao;

import com.wileyedge.superhero.model.Sighting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
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
            // You can map other fields here if needed
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
                sighting.getSightingDate()
        );
        return sighting;
    }

    @Override
    public void deleteSighting(int id) {
        String query = "DELETE FROM sighting WHERE sight_id=?";
        jdbcTemplate.update(query, id);
    }
}
