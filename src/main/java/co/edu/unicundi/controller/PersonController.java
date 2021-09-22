/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.controller;

import co.edu.unicundi.dto.PersonDto;
import co.edu.unicundi.message.HandlerWrapper;
import co.edu.unicundi.message.MessageWrapper;
import co.edu.unicundi.service.PersonService;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Clase
 *
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 1.1.0
 * @since 1.0.0
 */
@Stateless
@Path("/personas")
public class PersonController {

    PersonService objPersonList = new PersonService();
    MessageWrapper msg = new MessageWrapper();
    HandlerWrapper handler = new HandlerWrapper();

    @GET
    @Path("/obtener")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersons() {

        List<PersonDto> personList = objPersonList.getPersons();

        if (personList.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).entity(personList).build();
        } else {
            return Response.status(Response.Status.OK).entity(personList).build();
        }
    }

    @GET
    @Path("/obtenerPorId/{identification}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsById(@PathParam("identification") String id) {

        PersonDto person = objPersonList.getPersonByIdentification(id);

        if (person == null) {
            msg = handler.toResponse(Response.Status.NOT_FOUND.getStatusCode(), 
                Response.Status.NOT_FOUND, "personas/obtenerPorId/{identification}");
            return Response.status(Response.Status.NOT_FOUND).entity(msg).build();
        } else {
            return Response.status(Response.Status.OK).entity(person).build();
        }
    }

    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(PersonDto person) {

        HashMap<String, String> errores = objPersonList.error(person);;
        if (errores.size() > 0) {
            return Response.status(Response.Status.BAD_REQUEST).entity(errores).build();
        }

        if (objPersonList.savePerson(person)) {
            return Response.status(Response.Status.CREATED).entity(person).build();
        } else {
            msg = handler.toResponse(Response.Status.CONFLICT.getStatusCode(), 
                Response.Status.CONFLICT, "personas/insertar");
            return Response.status(Response.Status.CONFLICT).entity(msg).build();
        }

    }

    @PUT
    @Path("/editarPorId/{identification}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("identification") String id,
            PersonDto editPerson) {

        HashMap<String, String> errores = objPersonList.error(editPerson);;
        if (errores.size() > 0) {
            return Response.status(Response.Status.BAD_REQUEST).entity(errores).build();
        }
        
        PersonDto person = (PersonDto) objPersonList.updatePerson(id, editPerson);
        if (person == null) {
            msg = handler.toResponse(Response.Status.NOT_FOUND.getStatusCode(), 
                Response.Status.NOT_FOUND, "personas/editarPorId/{identification}");
            return Response.status(Response.Status.NOT_FOUND).entity(msg).build();
        } else if (person != editPerson) {
             msg = handler.toResponse(Response.Status.CONFLICT.getStatusCode(), 
                Response.Status.CONFLICT, "personas/editarPorId/{identification}");
            return Response.status(Response.Status.CONFLICT).entity(msg).build();
        } else {
            return Response.status(Response.Status.OK).entity(editPerson).build();
        }

    }

    @DELETE
    @Path("/eliminarPorId/{identification}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("identification") @NotNull String id) {

        if (objPersonList.deletePerson(id)) {
             msg = handler.toResponse(Response.Status.OK.getStatusCode(), 
                Response.Status.OK, "/eliminarPorId/{identification}");
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            msg = handler.toResponse(Response.Status.NOT_FOUND.getStatusCode(), 
                Response.Status.NOT_FOUND, "personas/eliminarPorId/{identification}");
            return Response.status(Response.Status.NOT_FOUND).entity(msg).build();
        }

    }
}
