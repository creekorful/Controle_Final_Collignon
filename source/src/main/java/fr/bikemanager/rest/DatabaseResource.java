package fr.bikemanager.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/databases")
public interface DatabaseResource {


    @GET
    @Path("/create")
    Response generateDatabase();

    @DELETE
    Response deleteDatabase();
}
