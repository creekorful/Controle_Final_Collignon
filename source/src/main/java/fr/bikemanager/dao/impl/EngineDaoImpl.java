package fr.bikemanager.dao.impl;

import java.util.List;

import fr.bikemanager.dao.AbstractDao;
import fr.bikemanager.dao.EngineDao;
import fr.bikemanager.entity.Engine;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class EngineDaoImpl extends AbstractDao implements EngineDao {
    @Transactional
    @Override
    public void save(Engine engine) {
        getSession().save(engine);
    }

    @Transactional
    @Override
    public Engine findById(int id) {
        return (Engine) getSession().createCriteria(Engine.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Engine> findAll() {
        return getSession().createCriteria(Engine.class).list();
    }
}
