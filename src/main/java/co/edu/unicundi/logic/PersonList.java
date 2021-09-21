/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.logic;

import co.edu.unicundi.dto.PersonDto;
import jakarta.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase 
 *
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 1.1.0
 * @since 1.0.0
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

        for (@Valid PersonDto person : this.personList) {
            if (person.getIdentification().equals(identification)) {
                return person;
            }
        }
        return null;
    }

    public boolean savePerson(@Valid PersonDto personDto) {

        for (PersonDto p : this.personList) {

            if (p.getIdentification().equals(personDto.getIdentification())) {
                return false;
            }
        }
        this.personList.add(personDto);
        saveList();
        return true;
    }

    public PersonDto updatePerson(String identification, PersonDto person) {

        for (int index = 0; index < this.personList.size(); index++) {

            if (this.personList.get(index).getIdentification().equals(identification)) {

                this.personList.set(index, person);
                saveList();
                return person;
            }
        }
        return null;
    }

    public boolean deletePerson(String identification) {

        for (PersonDto p : this.personList) {
            if (p.getIdentification().equals(identification)) {
                this.personList.remove(p);
                saveList();
                return true;
            }
        }
        return false;
    }

    public final void loadList() {
        ObjectInputStream objStream = null;

        if (isFileExists(DATA_FILE)) {
            //read the object from the file
            try {
                objStream = new ObjectInputStream(
                        new FileInputStream(new File(DATA_FILE)));

                this.personList = (List<PersonDto>) objStream.readObject();
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

    public final boolean saveList() {

        ObjectOutputStream objStream = null;

        //write the object to the file
        try {
            objStream = new ObjectOutputStream(
                    new FileOutputStream(new File(DATA_FILE)));

            objStream.writeObject(this.personList);

            objStream.close();

            return true;

        } catch (Exception e) {
            System.out.println("Error Writing Pattern");

            return false;
        }
    }

}
