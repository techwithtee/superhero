package com.wileyedge.superhero.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.dao.DataAccessException;

import com.wileyedge.superhero.model.Sighting;

public class SightDaoImplTest {

    private SightDaoImpl sightDao;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        sightDao = new SightDaoImpl(jdbcTemplate);
    }

    @Test
    public void testCreateSighting_ValidInput() {
        Sighting sighting = new Sighting();
        sighting.setSightTitle("Superman Spotted");
        sighting.setSightingDate(/* Set a valid date */ "2023-09-13");
        // Set a Location or LocationDTO as needed
        // Set a Hero or HeroDTO as needed

        // Mock the behavior of JdbcTemplate
        when(jdbcTemplate.update(anyString(), any(), any())).thenReturn(1);

        Sighting createdSighting = sightDao.createSighting(sighting);

        assertNotNull(createdSighting);
        assertNotNull(createdSighting.getSightId());
        assertEquals("Superman Spotted", createdSighting.getSightTitle());
        // Additional assertions for date, location, and hero as needed
    }

    @Test
    public void testCreateSighting_InvalidInput() {
        Sighting invalidSighting = new Sighting();
        // Invalid input, e.g., missing required fields

        // Mock the behavior of JdbcTemplate
        when(jdbcTemplate.update(anyString(), any(), any())).thenReturn(0);

        // Use assertThrows to verify that the method throws an exception
        assertThrows(DataAccessException.class, () -> sightDao.createSighting(invalidSighting));
    }

    @Test
    public void testGetAllSightings_ValidInput() {
        // Create a list of mock sightings for the test
        List<Sighting> sightings = new ArrayList<>();
        sightings.add(new Sighting(1, "Superman Spotted", "2023-09-13"));
        sightings.add(new Sighting(2, "Batman Sighted", "2023-09-14"));

        // Mock the behavior of JdbcTemplate to return the list of sightings
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(sightings);

        List<Sighting> allSightings = sightDao.getAllSightings();

        assertNotNull(allSightings);
        assertEquals(2, allSightings.size());
    }

    // Additional tests for other CRUD operations and invalid input scenarios

}
