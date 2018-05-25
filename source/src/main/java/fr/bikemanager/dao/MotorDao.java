package fr.bikemanager.dao;

import fr.bikemanager.entity.Motor;

public interface MotorDao {

    /**
     * Save a motor to the database
     *
     * @param motor the motor to save
     */
    void save(Motor motor);
}
