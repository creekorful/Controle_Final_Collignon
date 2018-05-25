package fr.bikemanager.rest.impl;

import fr.bikemanager.dto.DetailedMotorcycleDto;
import fr.bikemanager.dto.MotorcycleDto;
import fr.bikemanager.manager.MotorcycleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import fr.bikemanager.rest.MotorcycleResource;

import java.util.List;

@Component
public class MotorcycleResourceImpl implements MotorcycleResource {

    private MotorcycleManager motorcycleManager;

    @Autowired
    public MotorcycleResourceImpl(MotorcycleManager motorcycleManager) {
        this.motorcycleManager = motorcycleManager;
    }

    @Override
    public List<MotorcycleDto> getMotorcycles() {
        return motorcycleManager.getAll();
    }

    @Override
    public void addMotorcycle(DetailedMotorcycleDto motorcycleDto) {
        motorcycleManager.create(motorcycleDto);
    }

    @Override
    public DetailedMotorcycleDto getMotorcycle(int id) {
        return motorcycleManager.getById(id);
    }

    @Override
    public void deleteMotorcycle(int id) {
        motorcycleManager.deleteById(id);
    }
}
