package com.wileyedge.superhero.service;

import com.wileyedge.superhero.dao.HeroDao;
import com.wileyedge.superhero.model.Hero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HeroServiceImplTest {

    @InjectMocks
    private HeroServiceImpl heroService;

    @Mock
    private HeroDao heroDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateHero_ValidInput() {
        // Create a Hero object with valid data
        Hero hero = new Hero();
        hero.setHeroName("Superman");
        // Set other properties as needed

        // Mock the behavior of the heroDao.createHero method
        when(heroDao.createHero(hero)).thenReturn(hero);

        // Call the createHero method in your service
        Hero createdHero = heroService.createHero(hero);

        // Assert that the returned Hero matches the input Hero
        assertNotNull(createdHero);
        assertEquals("Superman", createdHero.getHeroName());
        // Add more assertions for other properties as needed

        // Verify that the heroDao.createHero method was called with the correct Hero object
        verify(heroDao, times(1)).createHero(hero);
    }

    @Test
    public void testCreateHero_InvalidInput() {
        // Create a Hero object with invalid data (e.g., missing required fields)
        Hero invalidHero = new Hero();

        // Mock the behavior of the heroDao.createHero method to throw an exception
        when(heroDao.createHero(invalidHero)).thenThrow(IllegalArgumentException.class);

        // Use assertThrows to verify that the service method throws an exception for invalid input
        assertThrows(IllegalArgumentException.class, () -> heroService.createHero(invalidHero));

        // Verify that the heroDao.createHero method was called with the invalid Hero object
        verify(heroDao, times(1)).createHero(invalidHero);
    }

    @Test
    public void testGetAllHeroes() {
        // Create a list of Hero objects for testing
        List<Hero> heroes = new ArrayList<>();
        // Add Hero objects to the list as needed

        // Mock the behavior of the heroDao.getAllHeroes method
        when(heroDao.getAllHeroes()).thenReturn(heroes);

        // Call the getAllHeroes method in your service
        List<Hero> retrievedHeroes = heroService.getAllHeroes();

        // Assert that the returned list of heroes matches the mocked list
        assertEquals(heroes.size(), retrievedHeroes.size());

        // Verify that the heroDao.getAllHeroes method was called
        verify(heroDao, times(1)).getAllHeroes();
    }

    // Add more test methods for other Hero Service functionality (update, delete, etc.)
}
