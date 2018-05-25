package fr.bikemanager.dao.impl;

import fr.bikemanager.dao.AbstractDao;
import fr.bikemanager.dao.UserDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import fr.bikemanager.entity.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class UserDaoImpl extends AbstractDao implements UserDao {
    @Transactional
    @Override
    public User findUserByCredentials(String username, String password) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        criteria.add(Restrictions.eq("password", password)); // todo hash/salt and stuff
        return (User) criteria.uniqueResult();
    }

    @Transactional
    @Override
    public void save(User user) {
        getSession().save(user);
    }
}
