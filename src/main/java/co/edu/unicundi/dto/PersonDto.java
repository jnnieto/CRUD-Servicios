/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author tatia
 */
public class PersonDto implements Serializable {

    private String identification;

    private String name;

    private String lastName;

    private String age;

    private String email;

    private String phoneNumber;

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

    public void savePerson(PersonDto person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
