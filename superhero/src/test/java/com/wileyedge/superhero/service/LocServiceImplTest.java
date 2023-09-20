package com.wileyedge.superhero.service;

import com.wileyedge.superhero.dao.LocDao;
import com.wileyedge.superhero.model.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LocServiceImplTest {

    @InjectMocks
    private LocServiceImpl locService;

    @Mock
    private LocDao locDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateLocationValidInput() {
        // Create a Location object with valid data
        Location location = new Location();
        location.setLocationName("Metropolis");
        location.setLocationDesc("City of Heroes");
        // Set other properties as needed

        // Mock the behavior of the locDao.createLocation method
        when(locDao.createLocation(location)).thenReturn(location);

        // Call the createLocation method in your service
        Location createdLocation = locService.createLocation(location);

        // Assert that the returned Location matches the input Location
        assertNotNull(createdLocation);
        assertEquals("Metropolis", createdLocation.getLocationName());
        assertEquals("City of Heroes", createdLocation.getLocationDesc());
        // Add more assertions for other properties as needed

        // Verify that the locDao.createLocation method was called with the correct Location object
        verify(locDao, times(1)).createLocation(location);
    }

    @Test
    public void testCreateLocationInvalidInput() {
        // Create a Location object with invalid data (e.g., missing required fields)
        Location invalidLocation = new Location();

        // Mock the behavior of the locDao.createLocation method to throw an exception
        when(locDao.createLocation(invalidLocation)).thenThrow(IllegalArgumentException.class);

        // Use assertThrows to verify that the service method throws an exception for invalid input
        assertThrows(IllegalArgumentException.class, () -> locService.createLocation(invalidLocation));

        // Verify that the locDao.createLocation method was called with the invalid Location object
        verify(locDao, times(1)).createLocation(invalidLocation);
    }

    @Test
    public void testGetAllLocations() {
        // Create a list of Location objects for testing
        List<Location> locations = new ArrayList<>();
        // Add Location objects to the list as needed

        // Mock the behavior of the locDao.getAllLocations method
        when(locDao.getAllLocations()).thenReturn(locations);

        // Call the getAllLocations method in your service
        List<Location> retrievedLocations = locService.getAllLocations();

        // Assert that the returned list of locations matches the mocked list
        assertEquals(locations.size(), retrievedLocations.size());

        // Verify that the locDao.getAllLocations method was called
        verify(locDao, times(1)).getAllLocations();
    }

}
