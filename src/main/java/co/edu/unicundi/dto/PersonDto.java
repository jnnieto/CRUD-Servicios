package co.edu.unicundi.dto;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.Pattern;

/**
 * Clase que almacena los datos de un objeto persona
 *
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 2.0.1
 * @since 1.0.0
 */
public class PersonDto implements Serializable {

    /**
     * Variable de tipo String que almacena el número de identificación de la
     * persona
     */
    @NotNull(message = "La identificación no puede ser nula")
    @Size(min = 6, max = 12, message = "La identificación debe tener mínimo seis caracteres y máximo doce caracteres")
    @Pattern(regexp = "^([0-9])*$", message = "La identificación solo puede contener números")
    private String identification;

    /**
     * Variable de tipo String que almacena el nombre de la persona
     */
    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 2, message = "El nombre debe tener mínimo dos caracteres")
    private String name;

    /**
     * Variable de tipo String que almacena el apellido de la persona
     */
    @NotNull(message = "El apellido no puede ser nulo")
    @Size(min = 3, message = "El apellido debe tener mínimo tres caracteres")
    private String lastName;

    /**
     * Variable de tipo String que almacena la edad de la persona
     */
    @NotNull(message = "La edad no puede ser nula")
    @Size(min = 1, max = 2, message = "La edad debe tener mínimo 1 dígito y máximo 2 dígitos")
    private String age;

    /**
     * Variable de tipo String que almacena el correo de la persona
     */
    @NotNull(message = "El correo no puede ser nulo")
    @Size(min = 5, max = 30, message = "El correo debe tener mínimo 5 caracteres")
    private String email;

    /**
     * Variable de tipo String que almacena el número de teléfono de la persona
     */
    @NotNull(message = "El número de teléfono no puede ser nulo")
    @Size(min = 7, max = 10, message = "El número de teléfono debe tener mínimo 7 dígitos y máximo 10 dígitos")
    private String phoneNumber;

    /**
     * Variable de tipo String que almacena la ocupación de la persona
     */
    @NotNull(message = "La ocupación no puede ser nula")
    @Size(min = 5, max = 20, message = "La ocupación debe tener mínimo 5 caracteres")
    private String ocupation;

    /**
     * Lista que almacena String de las certificaciones de la persona
     */
    private List<String> certificationsList;

    /**
     * Constructor vacío de la clase PersonDto
     */
    public PersonDto() {
    }

    /**
     * Constructor sobrecargado de la clase PersonDto
     *
     * @param identification
     * @param name
     * @param lastName
     * @param age
     * @param email
     * @param phoneNumber
     * @param ocupation
     * @param certificationsList
     */
    public PersonDto(String identification, String name, String lastName, String age, String email, String phoneNumber, String ocupation, List<String> certificationsList) {
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.ocupation = ocupation;
        this.certificationsList = certificationsList;
    }

    /**
     * Método que obtiene la identificación de la persona
     *
     * @return
     */
    public String getIdentification() {
        return identification;
    }

    /**
     * Método que asigna la identificación de la persona
     *
     * @param identification
     */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     * Método que obtiene el nombre de la persona
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Método que asigna el nombre de la persona
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método que obtiene el apellido de la persona
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Método que asigna el apellido de la persona
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Método que obtiene la edad de la persona
     *
     * @return
     */
    public String getAge() {
        return age;
    }

    /**
     * Método que asigna la edad de la persona
     *
     * @param age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * Método que obtiene el correo electrónico de la persona
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método que asigna el correo electrónico de la persona
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método que obtiene el número de teléfono de la persona
     *
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Método que asigna el número de teléfono de la persona
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Método que obtiene la ocupación de la persona
     *
     * @return
     */
    public String getOcupation() {
        return ocupation;
    }

    /**
     * Método que asigna la ocupación de la persona
     *
     * @param ocupation
     */
    public void setOcupation(String ocupation) {
        this.ocupation = ocupation;
    }

    /**
     * Método que obtiene la lista de certificaciones de la persona
     *
     * @return
     */
    public List<String> getCertificationsList() {
        return certificationsList;
    }

    /**
     * Método que asigna una lista de certificaciones de la persona
     *
     * @param certificationsList
     */
    public void setCertificationsList(List<String> certificationsList) {
        this.certificationsList = certificationsList;
    }

    /**
     * Método que valida los datos de la persona
     *
     * @return la validación del objeto
     */
    public Set<ConstraintViolation<PersonDto>> validate() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(this);
    }
}
