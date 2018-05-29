package fr.bikemanager.dao.impl;

import fr.bikemanager.dao.AbstractDao;
import fr.bikemanager.dao.MotorcycleDao;
import fr.bikemanager.entity.Motorcycle;
import fr.bikemanager.exception.NotFoundException;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class MotorcycleDaoImpl extends AbstractDao implements MotorcycleDao {

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Motorcycle> findAll() {
        return getSession().createCriteria(Motorcycle.class).list();
    }

    @Transactional
    @Override
    public Motorcycle findById(int id) {
        return (Motorcycle) getSession().createCriteria(Motorcycle.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Motorcycle motorcycle = findById(id);

        if (motorcycle != null) {
            getSession().delete(motorcycle);
        } else {
            throw new NotFoundException("Invalid motorcycle id.");
        }
    }

    @Transactional
    @Override
    public void save(Motorcycle motorcycle) {
        getSession().save(motorcycle);
    }
}
