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


import com.wileyedge.superhero.model.Organisation;

public class OrgDaoImplTest {

    private OrgDaoImpl orgDao;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        orgDao = new OrgDaoImpl(jdbcTemplate);
    }

    @Test
    public void testCreateOrganisationValidInput() {
        Organisation org = new Organisation();
        org.setOrgName("Justice League");
        org.setOrgDesc("Superhero Team");
        // Set other properties as needed

        // Mock the behavior of JdbcTemplate
        when(jdbcTemplate.update(anyString(), any(), any())).thenReturn(1);

        Organisation createdOrg = orgDao.createOrganisation(org);

        assertNotNull(createdOrg);
        assertNotNull(createdOrg.getOrgId());
        assertEquals("Justice League", createdOrg.getOrgName());
        assertEquals("Superhero Team", createdOrg.getOrgDesc());
        // Additional assertions for other properties
    }

    @Test
    public void testCreateOrganisationInvalidInput() {
        Organisation invalidOrg = new Organisation();
        // Invalid input, e.g., missing required fields

        // Mock the behavior of JdbcTemplate
        when(jdbcTemplate.update(anyString(), any(), any())).thenReturn(0);

        // Use assertThrows to verify that the method throws an exception
        assertThrows(DataAccessException.class, () -> orgDao.createOrganisation(invalidOrg));
    }

    @Test
    public void testGetAllOrganisationsValidInput() {
        // Create a list of mock organizations for the test
        List<Organisation> orgs = new ArrayList<>();
        orgs.add(new Organisation(1, "Justice League", "Superhero Team"));
        orgs.add(new Organisation(2, "Avengers", "Superhero Team"));

        // Mock the behavior of JdbcTemplate to return the list of organizations
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(orgs);

        List<Organisation> allOrgs = orgDao.getAllOrganisations();

        assertNotNull(allOrgs);
        assertEquals(2, allOrgs.size());
    }

    // Additional tests for other CRUD operations and invalid input scenarios

}
