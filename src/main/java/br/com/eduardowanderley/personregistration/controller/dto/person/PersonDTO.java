package br.com.eduardowanderley.personregistration.controller.dto.person;

import br.com.eduardowanderley.personregistration.model.Person;

public class PersonDTO {

    private Long id;

    private String name;

    private String lastName;

    public PersonDTO(){

    }

    public PersonDTO(Person psn) {
        this.id = psn.getId();
        this.name = psn.getName();
        this.lastName = psn.getLastName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
