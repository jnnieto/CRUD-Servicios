/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.model;

import co.edu.unicundi.dto.PersonDto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author tatia
 */
public class PersonList {
    
    public static final String DATA_FILE = "data.txt";
    
    private List<PersonDto> personList;
    
    public PersonList() {
        this.personList = new ArrayList<>();
        loadList();
    }
    
    public List<PersonDto> getPersons() {
       return this.personList;
    }
    
    public PersonDto getPersonByIdentification(String identification) {
        PersonDto p = new PersonDto();
        return p;
    }
    
    public boolean savePerson(PersonDto personDto) {
       
        ObjectOutputStream objStream = null;

        //write the object to the file
        try {
            objStream = new ObjectOutputStream(
                            new FileOutputStream(new File(DATA_FILE)));

            this.personList.add(personDto);
   
            objStream.writeObject(this.personList);
            
            objStream.close();
            return true;

        } catch (Exception e) {
            System.out.println("Error Writing Pattern");
            return false;
        }
    }
    
    public PersonDto updatePerson(String identification) {
        PersonDto p = new PersonDto();
        return p;
    }
    
    public boolean detelePerson(String identification) {
        return true;
    }
      
    public final void loadList () {
        ObjectInputStream objStream = null;

        if (isFileExists(DATA_FILE)) {
            //read the object from the file
             try {
                objStream = new ObjectInputStream(
                            new FileInputStream(new File(DATA_FILE)));

                this.personList = (List<PersonDto>)
                     objStream.readObject();
                     objStream.close();

            } catch (Exception e) {
            System.out.println("Error Reading Pattern");
            }
        }
    }
    
    public boolean isFileExists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

}
