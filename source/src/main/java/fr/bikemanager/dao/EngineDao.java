package fr.bikemanager.dao;

import java.util.List;

import fr.bikemanager.entity.Engine;

public interface EngineDao {

    /**
     * Save a engine to the database
     *
     * @param engine the engine to save
     */
    void save(Engine engine);

    /**
     * Find an engine using his id
     *
     * @param id the engine id
     * @return the associated engine or null if not found
     */
    Engine findById(int id);

    /**
     * Find all existing engines from the database
     *
     * @return the list of all existing engines
     */
    List<Engine> findAll();
}
