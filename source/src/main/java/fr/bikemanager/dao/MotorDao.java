package fr.bikemanager.dao;

import java.util.List;

import fr.bikemanager.entity.Motor;

public interface MotorDao {

    /**
     * Save a motor to the database
     *
     * @param motor the motor to save
     */
    void save(Motor motor);

    /**
     * Find all existing motor from the database
     *
     * @return the list of all existing motors
     */
    List<Motor> findAll();
}
