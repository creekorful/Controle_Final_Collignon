package fr.bikemanager.manager.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bikemanager.dao.EngineDao;
import fr.bikemanager.dto.EngineDto;
import fr.bikemanager.manager.EngineManager;

@Service
public class EngineManagerImpl implements EngineManager {

    private EngineDao engineDao;

    @Autowired
    public EngineManagerImpl(EngineDao engineDao) {
        this.engineDao = engineDao;
    }

    @Override
    public List<EngineDto> getAll() {
        return engineDao.findAll().stream().map(EngineDto::new).collect(Collectors.toList());
    }
}
