package fr.bikemanager.rest;

import fr.bikemanager.dto.DetailedMotorcycleDto;
import fr.bikemanager.dto.MotorcycleDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/motorcycles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface MotorcycleResource {

    @GET
    List<MotorcycleDto> getMotorcycles();

    @POST
    void addMotorcycle(DetailedMotorcycleDto motorcycleDto);

    @GET
    @Path("/{id}")
    DetailedMotorcycleDto getMotorcycle(@PathParam("id") int id);

    @DELETE
    @Path("/{id}")
    void deleteMotorcycle(@PathParam("id") int id);
}
