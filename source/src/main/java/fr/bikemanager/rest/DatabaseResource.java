package fr.bikemanager.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import fr.bikemanager.dao.MotorDao;
import fr.bikemanager.dao.MotorcycleDao;
import fr.bikemanager.dao.UserDao;
import fr.bikemanager.entity.Motor;
import fr.bikemanager.entity.Motorcycle;
import fr.bikemanager.entity.User;

@Path("/databases")
public class DatabaseResource {

    private UserDao userDao;

    private MotorcycleDao motorcycleDao;

    private MotorDao motorDao;

    @Autowired
    public DatabaseResource(UserDao userDao, MotorcycleDao motorcycleDao, MotorDao motorDao) {
        this.userDao = userDao;
        this.motorcycleDao = motorcycleDao;
        this.motorDao = motorDao;
    }

    @GET
    @Path("/create")
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

    @DELETE
    public Response deleteDatabase() {
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
}
