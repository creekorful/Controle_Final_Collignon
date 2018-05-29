package fr.bikemanager.manager.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.bikemanager.dao.EngineDao;
import fr.bikemanager.dao.MotorcycleDao;
import fr.bikemanager.dto.CreateMotorcycleDto;
import fr.bikemanager.dto.DetailedMotorcycleDto;
import fr.bikemanager.dto.MotorcycleDto;
import fr.bikemanager.entity.Engine;
import fr.bikemanager.entity.Motorcycle;
import fr.bikemanager.exception.NotFoundException;
import fr.bikemanager.manager.MotorcycleManager;

@Service
public class MotorcycleManagerImpl implements MotorcycleManager {

    private MotorcycleDao motorcycleDao;

    private EngineDao engineDao;

    @Autowired
    public MotorcycleManagerImpl(MotorcycleDao motorcycleDao, EngineDao engineDao) {
        this.motorcycleDao = motorcycleDao;
        this.engineDao = engineDao;
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
    public void create(CreateMotorcycleDto motorcycleDto) {
        Engine engine = engineDao.findById(motorcycleDto.getEngineId());

        if (engine != null) {
            Motorcycle motorcycle = new Motorcycle(motorcycleDto.getBrand(), motorcycleDto.getModel(),
                                                   engine, motorcycleDto.getFiscalPower(), motorcycleDto.getTireType());
            motorcycleDao.save(motorcycle);
        } else {
            throw new NotFoundException("Invalid engine id.");
        }
    }

    @Override
    public void deleteById(int motorcycleId) {
        motorcycleDao.deleteById(motorcycleId);
    }

    @Transactional
    @Override
    public void updateMotorcycle(int id, DetailedMotorcycleDto details) {
        Motorcycle motorcycle = motorcycleDao.findById(id);

        if (motorcycle != null) {
            if (details.getBrand() != null) motorcycle.setBrand(details.getBrand());
            if (details.getModel() != null) motorcycle.setModel(details.getModel());
            if (details.getFiscalPower() != 0) motorcycle.setFiscalPower(details.getFiscalPower());
            if (details.getTireType() != null) motorcycle.setTireType(details.getTireType());
        } else {
            throw new NotFoundException("Invalid motorcycle id.");
        }
    }
}
