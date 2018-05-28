package fr.bikemanager.rest;

import fr.bikemanager.dto.DetailedMotorcycleDto;
import fr.bikemanager.dto.MotorcycleDto;
import fr.bikemanager.manager.MotorcycleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import fr.bikemanager.rest.MotorcycleResource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/motorcycles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MotorcycleResource {

    private MotorcycleManager motorcycleManager;

    @Autowired
    public MotorcycleResource(MotorcycleManager motorcycleManager) {
        this.motorcycleManager = motorcycleManager;
    }

    @GET
    public List<MotorcycleDto> getMotorcycles() {
        return motorcycleManager.getAll();
    }

    @POST
    public void addMotorcycle(DetailedMotorcycleDto motorcycleDto) {
        motorcycleManager.create(motorcycleDto);
    }

    @GET
    @Path("/{id}")
    public DetailedMotorcycleDto getMotorcycle(@PathParam("id") int id) {
        return motorcycleManager.getById(id);
    }

    @DELETE
    @Path("/{id}")
    public void deleteMotorcycle(@PathParam("id") int id) {
        motorcycleManager.deleteById(id);
    }
}
