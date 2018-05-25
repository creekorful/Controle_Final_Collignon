package fr.bikemanager.manager.impl;

import fr.bikemanager.dao.MotorcycleDao;
import fr.bikemanager.dto.DetailedMotorcycleDto;
import fr.bikemanager.dto.MotorcycleDto;
import fr.bikemanager.entity.Motorcycle;
import fr.bikemanager.manager.MotorcycleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotorcycleManagerImpl implements MotorcycleManager {

    private MotorcycleDao motorcycleDao;

    @Autowired
    public MotorcycleManagerImpl(MotorcycleDao motorcycleDao) {
        this.motorcycleDao = motorcycleDao;
    }

    @Override
    public List<MotorcycleDto> getAll() {
        return motorcycleDao.findAll().stream().map(MotorcycleDto::new).collect(Collectors.toList());
    }

    @Override
    public DetailedMotorcycleDto getById(int motorcycleId) {
        Motorcycle motorcycle = motorcycleDao.findById(motorcycleId);
        return motorcycle != null ? new DetailedMotorcycleDto(motorcycle) : null;
    }

    @Override
    public void create(DetailedMotorcycleDto motorcycleDto) {
        // todo
    }

    @Override
    public void deleteById(int motorcycleId) {
        motorcycleDao.deleteById(motorcycleId);
    }
}
