package com.wileyedge.superhero.service;

import com.wileyedge.superhero.dao.SightDao;
import com.wileyedge.superhero.model.Sighting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SightServiceImplTest {

    @InjectMocks
    private SightServiceImpl sightService;

    @Mock
    private SightDao sightDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateSighting_ValidInput() {
        // Create a Sighting object with valid data
        Sighting sighting = new Sighting();
        sighting.setSightTitle("Superman Spotted");
        // Set other properties as needed

        // Mock the behavior of the sightDao.createSighting method
        when(sightDao.createSighting(sighting)).thenReturn(sighting);

        // Call the createSighting method in your service
        Sighting createdSighting = sightService.createSighting(sighting);

        // Assert that the returned Sighting matches the input Sighting
        assertNotNull(createdSighting);
        assertEquals("Superman Spotted", createdSighting.getSightTitle());
        // Add more assertions for other properties as needed

        // Verify that the sightDao.createSighting method was called with the correct Sighting object
        verify(sightDao, times(1)).createSighting(sighting);
    }

    @Test
    public void testCreateSighting_InvalidInput() {
        // Create a Sighting object with invalid data (e.g., missing required fields)
        Sighting invalidSighting = new Sighting();

        // Mock the behavior of the sightDao.createSighting method to throw an exception
        when(sightDao.createSighting(invalidSighting)).thenThrow(IllegalArgumentException.class);

        // Use assertThrows to verify that the service method throws an exception for invalid input
        assertThrows(IllegalArgumentException.class, () -> sightService.createSighting(invalidSighting));

        // Verify that the sightDao.createSighting method was called with the invalid Sighting object
        verify(sightDao, times(1)).createSighting(invalidSighting);
    }

    @Test
    public void testGetAllSightings() {
        // Create a list of Sighting objects for testing
        List<Sighting> sightings = new ArrayList<>();
        // Add Sighting objects to the list as needed

        // Mock the behavior of the sightDao.getAllSightings method
        when(sightDao.getAllSightings()).thenReturn(sightings);

        // Call the getAllSightings method in your service
        List<Sighting> retrievedSightings = sightService.getAllSightings();

        // Assert that the returned list of sightings matches the mocked list
        assertEquals(sightings.size(), retrievedSightings.size());

        // Verify that the sightDao.getAllSightings method was called
        verify(sightDao, times(1)).getAllSightings();
    }

    // Add more test methods for other Sighting Service functionality (update, delete, etc.)
}
