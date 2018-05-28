package fr.bikemanager.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import fr.bikemanager.dto.MotorDto;
import fr.bikemanager.manager.MotorManager;

@Path("/motors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MotorResource {

    private MotorManager motorManager;

    @Autowired
    public MotorResource(MotorManager motorManager) {
        this.motorManager = motorManager;
    }

    @GET
    public List<MotorDto> getAll() {
        return motorManager.getAll();
    }
}
