/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 * Clase
 *
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 1.1.0
 * @since 1.0.0
 */
public class PersonDto implements Serializable {

    @NotNull(message = "La identificación no puede ser nula")
    @Size(min = 6, max = 12, message = "La identificación debe tener mínimo seis caracteres y máximo doce caracteres")
    private String identification;

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 2, message = "El nombre debe tener mínimo dos caracteres")
    private String name;

    @NotNull(message = "El apellido no puede ser nulo")
    @Size(min = 3, message = "El apellido debe tener mínimo tres caracteres")
    private String lastName;

    @NotNull(message = "La edad no puede ser nula")
    @Size(min = 1, max = 2, message = "La edad debe tener mínimo 1 dígito y máximo 2 dígitos")
    private String age;

    @NotNull(message = "El correo no puede ser nulo")
    @Size(min = 5, max = 30, message = "El correo debe tener mínimo 5 caracteres")
    private String email;

    @NotNull(message = "El número de teléfono no puede ser nulo")
    @Size(min = 7, max = 10, message = "El número de teléfono debe tener mínimo 7 dígitos y máximo 10 dígitos")
    private String phoneNumber;

    @NotNull(message = "La ocupación no puede ser nula")
    @Size(min = 5, max = 20, message = "La ocupación debe tener mínimo 5 caracteres")
    private String ocupation;

    private List<String> certificationsList;

    /**
     *
     */
    public PersonDto() {
    }

    /**
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
     *
     * @return
     */
    public String getIdentification() {
        return identification;
    }

    /**
     *
     * @param identification
     */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getAge() {
        return age;
    }

    /**
     *
     * @param age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return
     */
    public String getOcupation() {
        return ocupation;
    }

    /**
     *
     * @param ocupation
     */
    public void setOcupation(String ocupation) {
        this.ocupation = ocupation;
    }

    /**
     *
     * @return
     */
    public List<String> getCertificationsList() {
        return certificationsList;
    }

    /**
     *
     * @param certificationsList
     */
    public void setCertificationsList(List<String> certificationsList) {
        this.certificationsList = certificationsList;
    }

    /**
     *
     * @return
     */
    public Set<ConstraintViolation<PersonDto>> validate() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(this);
    }
}
