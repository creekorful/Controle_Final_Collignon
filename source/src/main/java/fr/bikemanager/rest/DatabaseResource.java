package fr.bikemanager.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import fr.bikemanager.dao.EngineDao;
import fr.bikemanager.dao.MotorcycleDao;
import fr.bikemanager.dao.UserDao;
import fr.bikemanager.entity.Engine;
import fr.bikemanager.entity.Motorcycle;
import fr.bikemanager.entity.User;

@Path("/databases")
public class DatabaseResource {

    private UserDao userDao;

    private MotorcycleDao motorcycleDao;

    private EngineDao engineDao;

    @Autowired
    public DatabaseResource(UserDao userDao, MotorcycleDao motorcycleDao, EngineDao engineDao) {
        this.userDao = userDao;
        this.motorcycleDao = motorcycleDao;
        this.engineDao = engineDao;
    }

    @GET
    @Path("/create")
    public Response generateDatabase() {

        // First of all generate some users
        userDao.save(new User("admin", "admin", true));
        userDao.save(new User("guest", "guest", false));

        // Then some engines
        Engine renaudEngine = new Engine(120, "Renaud", 150, 500);
        Engine citroenEngine = new Engine(100, "Citroen", 100, 350);
        engineDao.save(renaudEngine);
        engineDao.save(citroenEngine);

        // And finally, the motorcycle
        motorcycleDao.save(new Motorcycle("BMW", "F 750 GS", renaudEngine, 5, "Course"));
        motorcycleDao.save(new Motorcycle("BMW", "C 400 X", renaudEngine, 5, "Ville"));
        motorcycleDao.save(new Motorcycle("Ducati", "Monster 620", citroenEngine, 7, "Course"));
        motorcycleDao.save(new Motorcycle("Ducati", "SuperSport 900", citroenEngine, 7, "Course"));
        motorcycleDao.save(new Motorcycle("Ducati", "Multistrada 1200 Enduro", citroenEngine, 7, "Course"));
        motorcycleDao.save(new Motorcycle("Ford", "F III", renaudEngine, 10, "Road"));

        return Response.ok().build();
    }

    @DELETE
    public Response deleteDatabase() {
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
}
