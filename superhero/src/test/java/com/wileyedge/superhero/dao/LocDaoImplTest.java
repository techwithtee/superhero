package com.wileyedge.superhero.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.dao.DataAccessException;



import com.wileyedge.superhero.model.Location;

public class LocDaoImplTest {

    private LocDaoImpl locDao;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        locDao = new LocDaoImpl(jdbcTemplate);
    }

    @Test
    public void testCreateLocationValidInput() {
        Location location = new Location();
        location.setLocationName("Metropolis");
        location.setLocationDesc("City of Heroes");
        location.setLocationAddress("123 Hero Street");
        location.setLocationLat(BigDecimal.valueOf(40.7128)); // Example latitude value
        location.setLocationLong(BigDecimal.valueOf(-74.0060)); // Example longitude value

        // Mock the behavior of JdbcTemplate
        when(jdbcTemplate.update(anyString(), any(), any(), any(), any(), any())).thenReturn(1);

        Location createdLocation = locDao.createLocation(location);

        assertNotNull(createdLocation);
        assertNotNull(createdLocation.getLocationId());
        assertEquals("Metropolis", createdLocation.getLocationName());
        assertEquals("City of Heroes", createdLocation.getLocationDesc());
        assertEquals("123 Hero Street", createdLocation.getLocationAddress());
        assertEquals(BigDecimal.valueOf(40.7128), createdLocation.getLocationLat());
        assertEquals(BigDecimal.valueOf(-74.0060), createdLocation.getLocationLong());
    }


    @Test
    public void testGetAllLocationsValidInput() {
        // Create a list of mock locations for the test
        List<Location> locations = new ArrayList<>();
        locations.add(new Location(1, "Metropolis", "City of Heroes", "123 Hero Street", BigDecimal.valueOf(40.7128), BigDecimal.valueOf(-74.0060)));
        locations.add(new Location(2, "Gotham", "City of Darkness", "456 Dark Lane", BigDecimal.valueOf(41.8781), BigDecimal.valueOf(-87.6298)));

        // Mock the behavior of JdbcTemplate to return the list of locations
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(locations);

        List<Location> allLocations = locDao.getAllLocations();

        assertNotNull(allLocations);
        assertEquals(2, allLocations.size());
    }



}
