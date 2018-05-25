package fr.bikemanager.rest.impl;

import fr.bikemanager.dao.MotorDao;
import fr.bikemanager.dao.MotorcycleDao;
import fr.bikemanager.dao.UserDao;
import fr.bikemanager.entity.Motor;
import fr.bikemanager.entity.Motorcycle;
import fr.bikemanager.entity.User;
import fr.bikemanager.rest.DatabaseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component
public class DatabaseResourceImpl implements DatabaseResource {

    private UserDao userDao;

    private MotorcycleDao motorcycleDao;

    private MotorDao motorDao;

    @Autowired
    public DatabaseResourceImpl(UserDao userDao, MotorcycleDao motorcycleDao, MotorDao motorDao) {
        this.userDao = userDao;
        this.motorcycleDao = motorcycleDao;
        this.motorDao = motorDao;
    }

    @Override
    public Response generateDatabase() {

        // First of all generate some users
        userDao.save(new User("admin", "admin", true));
        userDao.save(new User("guest", "guest", false));

        // Then some motors
        Motor renaudEngine = new Motor(120, "Renaud", 150, 500);
        Motor citroenEngine = new Motor(100, "Citroen", 100, 350);
        motorDao.save(renaudEngine);
        motorDao.save(citroenEngine);

        // And finally, the motorcycle
        motorcycleDao.save(new Motorcycle("Renaud", "Lol I", renaudEngine, 5, "Course"));
        motorcycleDao.save(new Motorcycle("Citroen", "CIT II", citroenEngine, 7, "Ville"));
        motorcycleDao.save(new Motorcycle("Ford", "F III", renaudEngine, 10, "Road"));

        return Response.ok().build();
    }

    @Override
    public Response deleteDatabase() {
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
}
