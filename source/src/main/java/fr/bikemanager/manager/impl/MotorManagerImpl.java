package fr.bikemanager.manager.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bikemanager.dao.MotorDao;
import fr.bikemanager.dto.MotorDto;
import fr.bikemanager.manager.MotorManager;

@Service
public class MotorManagerImpl implements MotorManager {

    private MotorDao motorDao;

    @Autowired
    public MotorManagerImpl(MotorDao motorDao) {
        this.motorDao = motorDao;
    }

    @Override
    public List<MotorDto> getAll() {
        return motorDao.findAll().stream().map(MotorDto::new).collect(Collectors.toList());
    }
}
