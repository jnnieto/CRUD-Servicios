package co.edu.unicundi.controller;

import co.edu.unicundi.dto.PersonDto;
import co.edu.unicundi.exception.ConflictException;
import co.edu.unicundi.exception.ConstraintException;
import co.edu.unicundi.exception.PersonNotFoundException;
import co.edu.unicundi.service.PersonService;
import java.util.List;
import javax.ejb.Stateless;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 2.0.1
 * @since 1.0.0
 */
@Stateless
@Path("/personas")
public class PersonController {

    PersonService objPersonList = new PersonService();

    @GET
    @Path("/obtener")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersons() throws Exception {

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
    public Response getPersonsById(@PathParam("identification") @Size(min = 6, max = 12)
            @Pattern(regexp = "^([0-9])*$") String id)
            throws PersonNotFoundException, Exception {

        PersonDto person = objPersonList.getPersonByIdentification(id);
        return Response.status(Response.Status.OK).entity(person).build();

    }

    
    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(PersonDto person)
            throws ConstraintException, ConflictException, Exception {

        objPersonList.savePerson(person);
        return Response.status(Response.Status.CREATED).entity(person).build();

    }

    
    @PUT
    @Path("/editarPorId/{identification}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("identification") @Size(min = 6, max = 12)
            @Pattern(regexp = "^([0-9])*$") String id, PersonDto editPerson)
            throws ConstraintException, ConflictException, PersonNotFoundException, Exception {

        PersonDto person = objPersonList.updatePerson(id, editPerson);
        return Response.status(Response.Status.OK).entity(editPerson).build();

    }

    
    @DELETE
    @Path("/eliminarPorId/{identification}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("identification") @Size(min = 6, max = 12)
            @Pattern(regexp = "^([0-9])*$") String id) throws PersonNotFoundException, Exception {

        objPersonList.deletePerson(id);
        return Response.status(Response.Status.NO_CONTENT).build();

    }
}
