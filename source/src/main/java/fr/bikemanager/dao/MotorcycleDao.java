package fr.bikemanager.dao;

import java.util.List;

import fr.bikemanager.entity.Motorcycle;

public interface MotorcycleDao {

    List<Motorcycle> findAll();

    Motorcycle findById(int id);

    void deleteById(int id);

    void save(Motorcycle motorcycle);
}
