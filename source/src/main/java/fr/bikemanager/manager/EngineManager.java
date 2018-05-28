package fr.bikemanager.manager;

import java.util.List;

import fr.bikemanager.dto.EngineDto;

public interface EngineManager {

    /**
     * Get all existing engines
     *
     * @return the list of all existing engine associated dto
     */
    List<EngineDto> getAll();
}
