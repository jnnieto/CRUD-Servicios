package co.edu.unicundi.service;

import co.edu.unicundi.dto.PersonDto;
import jakarta.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.validation.ConstraintViolation;

/**
 * Clase que maneja la lógica de los datos solicitados por los servicios
 * 
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 1.1.0
 * @since 1.0.0
 */
public class PersonService {

    /**
     * Variable estática que guarda el nombre del archivo que contiene las personas
     */
    public static final String DATA_FILE = "data.txt";

    /**
     * Lista de tipo PersonDto que almacena la lista de personas leidas y escritas en el archivo
     */
    private List<PersonDto> personList;

    /**
     * Constructor de la clase PersonService que inicializa la lista de personas
     * y cargar la lista del archivo de texto
     */
    public PersonService() {
        this.personList = new ArrayList<>();
        loadList();
    }

    /**
     * Método que retorna la lista de personas que están en el archivo de texto
     * @return la lista de personas
     */
    public List<PersonDto> getPersons() {
        return this.personList;
    }

    /**
     * Método de tipo PersonDto que obtiene la información de una persona por medio
     * de su identificación
     * @param identification la identificación de la persona
     * @return el objeto PersonDto con los datos de la persona con esa identificación
     */
    public PersonDto getPersonByIdentification(String identification) {

        for (PersonDto person : this.personList) {
            if (person.getIdentification().equals(identification)) {
                return person;
            }
        }
        return null;
    }

    /**
     * Método de tipo booleano que añade a una nueva persona a la lista
     * y la guarda en el archivo de texto
     * @param personDto el objeto de la nueva persona a agregar
     * @return true si la persona se guardó, false si la identificación ya existe
     */
    public boolean savePerson(PersonDto personDto) {

        for (PersonDto p: this.personList) {

            if (p.getIdentification().equals(personDto.getIdentification())) {
                return false;
            }
        }
        this.personList.add(personDto);
        saveList();
        return true;
    }

    /**
     * Método de tipo PersonDto que actualiza la información de una persona que
     * se encuentra en la lista
     * @param identification la identificación de la persona
     * @param person la persona a editar
     * @return person la persona sise editó correctamente
     * p si existe una identificación con otra persona
     * null si la persona no existe
     */
    public PersonDto updatePerson(String identification, PersonDto person) {

        for (int index = 0; index < this.personList.size(); index++) {

            if (this.personList.get(index).getIdentification().equals(identification)) {

                for (PersonDto p: this.personList) {
                    if (p.getIdentification().equals(person.getIdentification()) && !person.getIdentification().equals(identification)) {
                        return p;
                    }
                }
    
                this.personList.set(index, person);
                saveList();
                return person;
            }
        }
        return null;
    }

    /**
     * Método de tipo booleano que permite eliminar a una persona
     * @param identification la identificación de la persona a eliminar
     * @return true si se eliminó la persona
     * false si la persona no existe
     */
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

    /**
     * Método que carga la lista de las personas con los datos escritos en el archivo
     */
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

    /**
     * Método que valida si el archivo a leer o a escribir existe
     * @param fileName nombre del archivo a validar
     * @return true o false si el archivo existe
     */
    public boolean isFileExists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    /**
     * Método que permite guardar los datos de la lista de la clase en el archivo de texto
     * @return true si el objeto se guardo en el archivo
     * false si ocurrió un error en la escritura
     */
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

    /**
     * Método que permite manejar los errores de los datos de una persona
     * @param person la persona a validar
     * @return la lista de errores
     */
    public HashMap<String, String> error(PersonDto person) {
        HashMap<String, String> errores = new HashMap<>();
        for (ConstraintViolation error : person.validate()) {
            errores.put(error.getPropertyPath().toString(), error.getMessage());
        }
        return errores;
    }
    
}