/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.dto;

import jakarta.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase
 *
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 1.1.0
 * @since 1.0.0
 */
public class PersonDto implements Serializable {

    @NotNull
    @Size(min = 6, max = 12)
    private String identification;

    @NotNull(message = "Nombre vacío")
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    @Size(min = 1, max = 3)
    private String age;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 7, max = 10)
    private String phoneNumber;

    @NotNull
    private String ocupation;

    private List<String> certificationsList;

    public PersonDto() {
    }

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

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOcupation() {
        return ocupation;
    }

    public void setOcupation(String ocupation) {
        this.ocupation = ocupation;
    }

    public List<String> getCertificationsList() {
        return certificationsList;
    }

    public void setCertificationsList(List<String> certificationsList) {
        this.certificationsList = certificationsList;
    }

}
