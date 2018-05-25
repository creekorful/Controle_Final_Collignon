package fr.bikemanager.dao;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao {

    @PersistenceContext(unitName = "default")
    private EntityManager em;

    /**
     * @return the default JPA delegate implementation which is hibernate
     */
    protected Session getSession() {
        return em.unwrap(Session.class);
        //return (Session) em.getDelegate();
    }
}