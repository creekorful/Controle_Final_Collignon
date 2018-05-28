package fr.bikemanager.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import fr.bikemanager.dto.EngineDto;
import fr.bikemanager.manager.EngineManager;

@Path("/engines")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EngineResource {

    private EngineManager engineManager;

    @Autowired
    public EngineResource(EngineManager engineManager) {
        this.engineManager = engineManager;
    }

    @GET
    public List<EngineDto> getAll() {
        return engineManager.getAll();
    }
}
