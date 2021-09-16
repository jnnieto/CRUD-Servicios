/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.controller;

import co.edu.unicundi.dto.PersonDto;
import co.edu.unicundi.model.PersonList;
import java.util.List;
import javax.ejb.Stateless;
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
 *
 * @author nicon
 */
@Stateless
@Path("/personas")
public class PersonController {

    PersonList objPersonList = new PersonList();

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
            return Response.status(Response.Status.NOT_FOUND).entity("" + "{\n"
                    + "\"Mensaje\": \"Persona no encontrada\"\n" + "}").build();
        } else {
            return Response.status(Response.Status.OK).entity(person).build();
        }
    }

    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(PersonDto person) {

        if (objPersonList.savePerson(person)) {
            return Response.status(Response.Status.CREATED).entity(person).build();
        } else {
            return Response.status(Response.Status.CONFLICT).entity("" + "{\n"
                    + "\"Mensaje\": \"Ya existe una persona con la misma identificación\"\n" + "}").build();
        }
    }

    @PUT
    @Path("/editarPorId/{identification}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("identification") String id,
            PersonDto editPerson) {

        PersonDto person = objPersonList.updatePerson(id, editPerson);

        if (person == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("" + "{\n"
                    + "\"Mensaje\": \"Persona no encontrada\"\n" + "}").build();
        } else if (person != editPerson) {
            return Response.status(Response.Status.CONFLICT).entity("" + "{\n"
                    + "\"Mensaje\": \"Ya existe una persona con la misma identificación\"\n" + "}").build();
        } else {
            return Response.status(Response.Status.OK).entity(editPerson).build();
        }
    }

    @DELETE
    @Path("/eliminarPorId/{identification}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("identification") String id) {

        if (objPersonList.deletePerson(id)) {
            return Response.status(Response.Status.OK).entity("" + "{\n"
                    + "\"Mensaje\": \"La persona se eliminó correctamente\"\n" + "}").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("" + "{\n"
                    + "\"Mensaje\": \"Persona no encontrada\"\n" + "}").build();
        }

    }
}
