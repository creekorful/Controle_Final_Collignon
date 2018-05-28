package fr.bikemanager.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import fr.bikemanager.annotation.Secured;
import fr.bikemanager.dto.CredentialsDto;
import fr.bikemanager.dto.TokenDto;
import fr.bikemanager.manager.UserManager;

@Path("/session")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SessionResource {

    @Context
    private SecurityContext context;

    private UserManager userManager;

    @Autowired
    public SessionResource(UserManager userManager) {
        this.userManager = userManager;
    }

    @POST
    public TokenDto login(CredentialsDto credentialsDto) {
        String token = userManager.login(credentialsDto.getUsername(), credentialsDto.getPassword());
        return new TokenDto(token);
    }

    @Secured
    @GET
    @Path("/isAdmin")
    public Response isAdmin() {
        return Response.ok(userManager.isAdmin(context.getUserPrincipal().getName())).build();
    }
}
