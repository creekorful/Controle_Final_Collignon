package fr.bikemanager.manager;

import java.util.List;

import fr.bikemanager.dto.MotorDto;

public interface MotorManager {

    /**
     * Get all existing motors
     *
     * @return the list of all existing motors associated dto
     */
    List<MotorDto> getAll();
}
