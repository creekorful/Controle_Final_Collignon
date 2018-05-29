package fr.bikemanager.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import fr.bikemanager.annotation.Secured;
import fr.bikemanager.dto.CreateMotorcycleDto;
import fr.bikemanager.dto.DetailedMotorcycleDto;
import fr.bikemanager.dto.MotorcycleDto;
import fr.bikemanager.entity.User;
import fr.bikemanager.manager.MotorcycleManager;
import fr.bikemanager.manager.UserManager;

@Path("/motorcycles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MotorcycleResource {

    @Context
    private SecurityContext context;

    private MotorcycleManager motorcycleManager;

    private UserManager userManager;

    @Autowired
    public MotorcycleResource(MotorcycleManager motorcycleManager, UserManager userManager) {
        this.motorcycleManager = motorcycleManager;
        this.userManager = userManager;
    }

    @GET
    public List<MotorcycleDto> getMotorcycles() {
        return motorcycleManager.getAll();
    }

    @Secured
    @POST
    public void addMotorcycle(CreateMotorcycleDto motorcycleDto) {
        // Only admin user are allowed to add motorcycle
        if (isUserAdmin(context.getUserPrincipal().getName())) {
            motorcycleManager.create(motorcycleDto);
        }
    }

    @Secured
    @PATCH
    @Path("/{id}")
    public void editMotorcycle(@PathParam("id") int id, DetailedMotorcycleDto details) {
        // Only admin are allowed to edit motorcycle
        if (isUserAdmin(context.getUserPrincipal().getName())) {
            motorcycleManager.updateMotorcycle(id, details);
        }
    }

    @GET
    @Path("/{id}")
    public DetailedMotorcycleDto getMotorcycle(@PathParam("id") int id) {
        return motorcycleManager.getById(id);
    }

    @Secured
    @DELETE
    @Path("/{id}")
    public void deleteMotorcycle(@PathParam("id") int id) {
        // Only admin are allowed to delete motorcycle
        if (isUserAdmin(context.getUserPrincipal().getName())) {
            motorcycleManager.deleteById(id);
        }
    }

    /**
     * Check if the user with the provided auth token is admin
     *
     * @param authToken the user auth token
     * @return true if the user is admin one otherwise false
     */
    private boolean isUserAdmin(String authToken) {
        User user = userManager.getByAuthToken(authToken);
        return user != null && user.isAdmin();
    }
}
