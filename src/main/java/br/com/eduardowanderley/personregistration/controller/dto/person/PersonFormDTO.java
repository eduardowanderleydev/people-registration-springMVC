package br.com.eduardowanderley.personregistration.controller.dto.person;

import br.com.eduardowanderley.personregistration.model.Person;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

public class PersonFormDTO implements Serializable {

    private String name;
    private String lastName;
    private Integer age;
    private String gender;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate birthDate;

    private String occupation;

    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String uf;
    private String ibge;

    public PersonFormDTO() {
    }

    public PersonFormDTO(Person person) {
        this.name = person.getName();
        this.lastName = person.getLastName();
        this.age = person.getAge();
        this.gender = person.getGender();
        this.birthDate = person.getBirthDate();
        this.occupation = person.getPersonOccupation().getName();
        this.cep = person.getAddress().getCep();
        this.rua = person.getAddress().getRua();
        this.bairro = person.getAddress().getBairro();
        this.cidade = person.getAddress().getCidade();
        this.uf = person.getAddress().getUf();
        this.ibge = person.getAddress().getIbge();
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }
}
