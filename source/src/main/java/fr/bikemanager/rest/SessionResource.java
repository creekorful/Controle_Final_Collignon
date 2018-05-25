package fr.bikemanager.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/session")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface SessionResource {

    @POST
    String login(@FormParam("username") String username,
                 @FormParam("password") String password);
}
