package br.com.eduardowanderley.personregistration.controller.dto.person;

import br.com.eduardowanderley.personregistration.model.Occupation;
import br.com.eduardowanderley.personregistration.model.Person;

public class PersonDTO {

    private Long id;
    private String name;
    private String lastName;

    private Occupation personOccupation;

    private String fileCurriculumName;
    private String fileCurriculumType;
    private byte [] curriculum;

    public PersonDTO(){
    }

    public PersonDTO(Person psn) {
        this.id = psn.getId();
        this.name = psn.getName();
        this.lastName = psn.getLastName();
        this.fileCurriculumName = psn.getFileCurriculumName();
        this.fileCurriculumType = psn.getFileCurriculumType();
        this.curriculum = psn.getCurriculum();
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

    public Occupation getPersonOccupation() {
        return personOccupation;
    }

    public void setPersonOccupation(Occupation personOccupation) {
        this.personOccupation = personOccupation;
    }

    public String getFileCurriculumName() {
        return fileCurriculumName;
    }

    public void setFileCurriculumName(String fileCurriculumName) {
        this.fileCurriculumName = fileCurriculumName;
    }

    public String getFileCurriculumType() {
        return fileCurriculumType;
    }

    public void setFileCurriculumType(String fileCurriculumType) {
        this.fileCurriculumType = fileCurriculumType;
    }

    public byte[] getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(byte[] curriculum) {
        this.curriculum = curriculum;
    }
}
