package com.wileyedge.superhero.service;

import com.wileyedge.superhero.dao.OrgDao;
import com.wileyedge.superhero.model.Organisation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrgServiceImplTest {

    @InjectMocks
    private OrgServiceImpl orgService;

    @Mock
    private OrgDao orgDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateOrganisation_ValidInput() {
        // Create an Organisation object with valid data
        Organisation organisation = new Organisation();
        organisation.setOrgName("Justice League");
        organisation.setOrgDesc("A team of superheroes");
        // Set other properties as needed

        // Mock the behavior of the orgDao.createOrganisation method
        when(orgDao.createOrganisation(organisation)).thenReturn(organisation);

        // Call the createOrganisation method in your service
        Organisation createdOrganisation = orgService.createOrganisation(organisation);

        // Assert that the returned Organisation matches the input Organisation
        assertNotNull(createdOrganisation);
        assertEquals("Justice League", createdOrganisation.getOrgName());
        assertEquals("A team of superheroes", createdOrganisation.getOrgDesc());
        // Add more assertions for other properties as needed

        // Verify that the orgDao.createOrganisation method was called with the correct Organisation object
        verify(orgDao, times(1)).createOrganisation(organisation);
    }

    @Test
    public void testCreateOrganisation_InvalidInput() {
        // Create an Organisation object with invalid data (e.g., missing required fields)
        Organisation invalidOrganisation = new Organisation();

        // Mock the behavior of the orgDao.createOrganisation method to throw an exception
        when(orgDao.createOrganisation(invalidOrganisation)).thenThrow(IllegalArgumentException.class);

        // Use assertThrows to verify that the service method throws an exception for invalid input
        assertThrows(IllegalArgumentException.class, () -> orgService.createOrganisation(invalidOrganisation));

        // Verify that the orgDao.createOrganisation method was called with the invalid Organisation object
        verify(orgDao, times(1)).createOrganisation(invalidOrganisation);
    }

    @Test
    public void testGetAllOrganisations() {
        // Create a list of Organisation objects for testing
        List<Organisation> organisations = new ArrayList<>();
        // Add Organisation objects to the list as needed

        // Mock the behavior of the orgDao.getAllOrganisations method
        when(orgDao.getAllOrganisations()).thenReturn(organisations);

        // Call the getAllOrganisations method in your service
        List<Organisation> retrievedOrganisations = orgService.getAllOrganisations();

        // Assert that the returned list of organisations matches the mocked list
        assertEquals(organisations.size(), retrievedOrganisations.size());

        // Verify that the orgDao.getAllOrganisations method was called
        verify(orgDao, times(1)).getAllOrganisations();
    }

    // Add more test methods for other Organisation Service functionality (update, delete, etc.)
}
