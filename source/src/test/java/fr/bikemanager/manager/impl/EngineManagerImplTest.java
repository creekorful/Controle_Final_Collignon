package fr.bikemanager.manager.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.bikemanager.dao.EngineDao;
import fr.bikemanager.dto.EngineDto;
import fr.bikemanager.entity.Engine;

public class EngineManagerImplTest {

    @Mock
    private EngineDao engineDao;

    @InjectMocks
    private EngineManagerImpl engineManager;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllWithNoMotors() {
        Mockito.when(engineDao.findAll()).thenReturn(new ArrayList<>());

        Assert.assertTrue(engineManager.getAll().isEmpty()); // Should return an empty list not null object
    }

    @Test
    public void testGetAllWithMotors() {
        List<Engine> engines = Arrays.asList(new Engine(10, "Renaud", 100, 250),
                                             new Engine(11, "Citroen", 200, 150),
                                             new Engine(6, "Ducati", 205, 300));

        Mockito.when(engineDao.findAll()).thenReturn(engines);

        List<EngineDto> engineDtos = engineManager.getAll();

        Assert.assertFalse(engineDtos.isEmpty()); // Shouldn't be empty
        Assert.assertEquals(engineDtos.size(), engines.size()); // Size should be equals to engine list size
        Assert.assertEquals(engineDtos.get(0).getBrand(), engines.get(0).getBrand()); // Should be ordered
    }
}