/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.controller;

import co.edu.unicundi.dto.PersonDto;
import co.edu.unicundi.model.PersonList;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nicon
 */
@Stateless
@Path("/personas")
public class PersonController {

    @GET
    @Path("/obtenerPersonas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonDto> getPersons() {

        PersonList objPersonList = new PersonList();
        
        List<PersonDto> personList = objPersonList.getPersons();

        return personList;
    }

    @POST
    @Path("/insertarPersona")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addPerson(PersonDto person) {

        PersonList newPerson = new PersonList();
        
        if (newPerson.savePerson(person)) {
            return "Persona almacenada correctamente";
        } else {
            return "No se pudo almacenar la persona";
        }

    }
    
    
    
}
