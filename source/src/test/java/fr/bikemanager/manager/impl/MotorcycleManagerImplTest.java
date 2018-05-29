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

import fr.bikemanager.dao.MotorcycleDao;
import fr.bikemanager.dto.DetailedMotorcycleDto;
import fr.bikemanager.dto.MotorcycleDto;
import fr.bikemanager.entity.Engine;
import fr.bikemanager.entity.Motorcycle;
import fr.bikemanager.exception.NotFoundException;

public class MotorcycleManagerImplTest {

    @Mock
    private MotorcycleDao motorcycleDao;

    @InjectMocks
    private MotorcycleManagerImpl motorcycleManager;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllWithoutMotorcycles() {
        Mockito.when(motorcycleDao.findAll()).thenReturn(new ArrayList<>());

        Assert.assertTrue(motorcycleManager.getAll().isEmpty()); // Should return an empty list not null object
    }

    @Test
    public void testGetAllWithMotorcycles() {
        Engine engine = new Engine(10, "Citroen", 100, 300);
        List<Motorcycle> motorcycles = Arrays.asList(new Motorcycle("Renaud", "TG V", engine, 100, "Course"),
                                                     new Motorcycle("Citroen", "XD", engine, 100, "Ville"),
                                                     new Motorcycle("Ducati", "LOL", engine, 10, "Course"));

        Mockito.when(motorcycleDao.findAll()).thenReturn(motorcycles);

        List<MotorcycleDto> motorcycleDtos = motorcycleManager.getAll();

        Assert.assertFalse(motorcycleDtos.isEmpty()); // Shouldn't be empty
        Assert.assertEquals(motorcycleDtos.size(), motorcycles.size()); // Size should be = to motorcycles count
        Assert.assertEquals(motorcycleDtos.get(0).getBrand(), motorcycles.get(0).getBrand()); // Should be ordered
    }

    @Test
    public void testGetByIdWithInvalidId() {
        int id = 10;

        Mockito.when(motorcycleDao.findById(id)).thenReturn(null);

        Assert.assertNull(motorcycleManager.getById(id));
    }

    @Test
    public void testGetByIdWithValidId() {
        int id = 10;
        Engine engine = new Engine(10, "Citroen", 100, 300);
        Motorcycle motorcycle = new Motorcycle("Renaud", "TG V", engine, 10, "Course");

        Mockito.when(motorcycleDao.findById(id)).thenReturn(motorcycle);

        DetailedMotorcycleDto dto = motorcycleManager.getById(id);
        Assert.assertNotNull(dto);
        Assert.assertEquals(dto.getBrand(), motorcycle.getBrand());
        Assert.assertEquals(dto.getEngine().getBrand(), engine.getBrand());
    }

    @Test
    public void testCreateWithInvalidData() {
        // todo
    }

    @Test
    public void testCreateWithValidData() {
        // todo
    }

    @Test
    public void testDeleteByIdWithInvalidId() {
        // todo
    }

    @Test
    public void testDeleteByIdWithValidId() {
        // todo
    }

    @Test(expected = NotFoundException.class)
    public void testUpdateMotorcycleWithInvalidId() {
        int id = 50;
        DetailedMotorcycleDto dto = buildMotorcycleDto();

        Mockito.when(motorcycleDao.findById(id)).thenReturn(null);

        motorcycleManager.updateMotorcycle(id, dto);
    }

    @Test
    public void testUpdateMotorcycleWithValidId() {
        int id = 50;
        DetailedMotorcycleDto dto = buildMotorcycleDto();
        Motorcycle motorcycle = new Motorcycle("Renaud", "TG V", new Engine(), 10, "Course");

        Mockito.when(motorcycleDao.findById(id)).thenReturn(motorcycle);

        motorcycleManager.updateMotorcycle(id, dto);

        Assert.assertEquals(motorcycle.getBrand(), dto.getBrand());
        Assert.assertEquals(motorcycle.getFiscalPower(), dto.getFiscalPower());
        Assert.assertEquals(motorcycle.getModel(), dto.getModel());
        Assert.assertEquals(motorcycle.getTireType(), dto.getTireType());
    }

    private DetailedMotorcycleDto buildMotorcycleDto() {
        return new DetailedMotorcycleDto(new Motorcycle("Renaud", "TG V",
                                                        new Engine(10, "Citroen", 100, 300),
                                                        10, "Course"));
    }
}
