package fr.bikemanager.manager;

import java.util.List;

import fr.bikemanager.dto.CreateMotorcycleDto;
import fr.bikemanager.dto.DetailedMotorcycleDto;
import fr.bikemanager.dto.MotorcycleDto;

public interface MotorcycleManager {

    /**
     * Get all existing motorcycle
     *
     * @return a list of fr.bikemanager.dto that map the existing motorcycles or empty list if none
     */
    List<MotorcycleDto> getAll();

    /**
     * Get details about specific motorcycle
     *
     * @param motorcycleId the wanted motorcycle id
     * @return the detail associated with the motorcycle id or null if invalid id
     */
    DetailedMotorcycleDto getById(int motorcycleId);

    /**
     * Create a motorcycle using the provided dto
     *
     * @param motorcycleDto the information about the motorcycle to create
     */
    void create(CreateMotorcycleDto motorcycleDto);

    /**
     * Create a motorcycle using his id
     *
     * @param motorcycleId the motorcycle to delete id
     */
    void deleteById(int motorcycleId);

    /**
     * Update motorcycle details
     *
     * @param id the motorcycle id
     * @param details the new motorcycle details
     */
    void updateMotorcycle(int id, DetailedMotorcycleDto details);
}
