package fr.bikemanager.filter;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import fr.bikemanager.dto.ErrorDto;
import fr.bikemanager.exception.ServiceException;

public class ExceptionFilter implements ExceptionMapper<ServiceException> {
    @Override
    public Response toResponse(ServiceException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorDto(e.getError())).build();
    }
}
