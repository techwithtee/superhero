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


import com.wileyedge.superhero.model.Hero;

public class HeroDaoImplTest {

    private HeroDaoImpl heroDao;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        heroDao = new HeroDaoImpl(jdbcTemplate);
    }

    @Test
    public void testCreateHero_ValidInput() {
        Hero hero = new Hero();
        hero.setHeroName("Superman");
        hero.setHeroDesc("Man of Steel");
        hero.setSuperpower("Flight, Super Strength");

        // Mock the behavior of JdbcTemplate
        when(jdbcTemplate.update(anyString(), any(), any(), any())).thenReturn(1);

        Hero createdHero = heroDao.createHero(hero);

        assertNotNull(createdHero);
        assertNotNull(createdHero.getHeroId());
        assertEquals("Superman", createdHero.getHeroName());
        assertEquals("Man of Steel", createdHero.getHeroDesc());
        assertEquals("Flight, Super Strength", createdHero.getSuperpower());
    }

    @Test
    public void testCreateHero_InvalidInput() {
        Hero invalidHero = new Hero();
        // Set invalid input, e.g., missing required fields

        // Mock the behavior of JdbcTemplate to throw a DataAccessException
        when(jdbcTemplate.update(anyString(), any(), any(), any())).thenThrow(DataAccessException.class);

        // Use assertThrows to verify that the method throws a DataAccessException
        assertThrows(DataAccessException.class, () -> heroDao.createHero(invalidHero));
    }



    @Test
    public void testGetAllHeroes_ValidInput() {
        // Create a list of mock heroes for the test
        List<Hero> heroes = new ArrayList<>();
        heroes.add(new Hero(1, "Superman", "Man of Steel", "Flight, Super Strength"));
        heroes.add(new Hero(2, "Batman", "Dark Knight", "Intelligence, Martial Arts"));

        // Mock the behavior of JdbcTemplate to return the list of heroes
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(heroes);

        List<Hero> allHeroes = heroDao.getAllHeroes();

        assertNotNull(allHeroes);
        assertEquals(2, allHeroes.size());
    }

    // Additional tests for other CRUD operations and invalid input scenarios

}
