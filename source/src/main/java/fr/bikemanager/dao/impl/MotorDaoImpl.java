package fr.bikemanager.dao.impl;

import java.util.List;

import fr.bikemanager.dao.AbstractDao;
import fr.bikemanager.dao.MotorDao;
import fr.bikemanager.entity.Motor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class MotorDaoImpl extends AbstractDao implements MotorDao {
    @Transactional
    @Override
    public void save(Motor motor) {
        getSession().save(motor);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Motor> findAll() {
        return getSession().createCriteria(Motor.class).list();
    }
}
