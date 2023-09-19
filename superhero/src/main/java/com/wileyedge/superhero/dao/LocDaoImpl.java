package com.wileyedge.superhero.dao;

import com.wileyedge.superhero.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocDaoImpl implements LocDao {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Location> rowMapper;

    @Autowired
    public LocDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = (rs, rowNum) -> {
            Location location = new Location();
            location.setLocationId(rs.getInt("location_id"));
            location.setLocationName(rs.getString("location_name"));
            location.setLocationDesc(rs.getString("location_desc"));
            location.setLocationAddress(rs.getString("location_add"));
            location.setLocationLat(rs.getBigDecimal("location_lat"));
            location.setLocationLong(rs.getBigDecimal("location_long"));
            // You can map other fields here if needed
            return location;
        };
    }

    @Override
    public Location createLocation(Location location) {
        String query = "INSERT INTO location (location_name, location_desc, location_add, location_lat, location_long) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                query,
                location.getLocationName(),
                location.getLocationDesc(),
                location.getLocationAddress(),
                location.getLocationLat(),
                location.getLocationLong()
        );
        return location;
    }

    @Override
    public Location getLocationById(int id) {
        String query = "SELECT * FROM location WHERE location_id=?";
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }

    @Override
    public List<Location> getAllLocations() {
        String query = "SELECT * FROM location";
        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public void updateLocation(Location location) {
        String query = "UPDATE location SET location_name=?, location_desc=?, location_add=?, location_lat=?, location_long=? WHERE location_id=?";
        jdbcTemplate.update(
                query,
                location.getLocationName(),
                location.getLocationDesc(),
                location.getLocationAddress(),
                location.getLocationLat(),
                location.getLocationLong(),
                location.getLocationId()
        );
    }

    @Override
    public void deleteLocation(int id) {
        String query = "DELETE FROM location WHERE location_id=?";
        jdbcTemplate.update(query, id);
    }
}
