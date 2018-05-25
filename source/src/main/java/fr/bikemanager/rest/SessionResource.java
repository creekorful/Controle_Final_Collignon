package fr.bikemanager.rest;

import fr.bikemanager.dto.CredentialsDto;
import fr.bikemanager.dto.TokenDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/session")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface SessionResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    TokenDto login(CredentialsDto credentialsDto);
}
