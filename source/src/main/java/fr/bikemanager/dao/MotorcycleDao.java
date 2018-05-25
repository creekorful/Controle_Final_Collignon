package fr.bikemanager.dao;

import fr.bikemanager.entity.Motorcycle;

import java.util.List;

public interface MotorcycleDao {

    List<Motorcycle> findAll();

    Motorcycle findById(int id);

    void deleteById(int id);

    void save(Motorcycle motorcycle);
}
