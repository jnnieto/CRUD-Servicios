/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.message;

import co.edu.unicundi.exception.ConflictException;
import co.edu.unicundi.exception.ConstraintException;
import co.edu.unicundi.exception.PersonNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author 
 */
@Provider
public class HandlerException implements ExceptionMapper<Exception>{

    @Context
    private HttpServletRequest request;
    
    @Override
    public Response toResponse(Exception exception) {
        // exception.printStackTrace();
        MessageWrapper msg;
        
        if (exception instanceof PersonNotFoundException) {
            msg = new MessageWrapper(Response.Status.NOT_FOUND.getStatusCode(), Response.Status.NOT_FOUND, exception.getMessage(), request.getRequestURI());
            return Response.status(Response.Status.NOT_FOUND).entity(msg).build();
        } else if (exception instanceof ConstraintException) {
            msg = new MessageWrapper(Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST, exception.getMessage(), request.getRequestURI());
            return Response.status(Response.Status.BAD_REQUEST).entity(msg).build();
        } else if (exception instanceof ConflictException) {
            msg = new MessageWrapper(Response.Status.CONFLICT.getStatusCode(), Response.Status.CONFLICT, exception.getMessage(), request.getRequestURI());
            return Response.status(Response.Status.CONFLICT).entity(msg).build();
        } else {
            msg = new MessageWrapper(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR, "", request.getRequestURI());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(msg).build();
        }
        
    }

}
