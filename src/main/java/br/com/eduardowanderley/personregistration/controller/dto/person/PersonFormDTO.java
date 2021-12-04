package br.com.eduardowanderley.personregistration.controller.dto.person;

import br.com.eduardowanderley.personregistration.controller.dto.phone.PhoneDTO;
import br.com.eduardowanderley.personregistration.model.Person;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class PersonFormDTO implements Serializable {

    private Long id;

    @NotEmpty(message = "name cannot be empty")
    @NotNull(message = "name cannot be null")
    private String name;

    @NotEmpty(message = "Last name cannot be empty")
    @NotNull(message = "Last name cannot be null")
    private String lastName;

    @Min(value = 18, message = "Age must be older than 18 years")
    private Integer age;

    private String gender;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate birthDate;

    @NotNull(message = "Occupation cannot be null")
    private String personOccupation;

    @NotEmpty(message = "CEP cannot be empty")
    private String cep;

    private String rua;
    private String bairro;
    private String cidade;
    private String uf;
    private String ibge;

    private String fileCurriculumName;
    private String fileCurriculumType;
    private byte[] curriculum;

    private List<PhoneDTO> phones;

    public PersonFormDTO() {
    }

    public PersonFormDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.lastName = person.getLastName();
        this.age = person.getAge();
        this.gender = person.getGender();
        this.birthDate = person.getBirthDate();
        this.personOccupation = person.getPersonOccupation().getName();
        this.cep = person.getAddress().getCep();
        this.rua = person.getAddress().getRua();
        this.bairro = person.getAddress().getBairro();
        this.cidade = person.getAddress().getCidade();
        this.uf = person.getAddress().getUf();
        this.ibge = person.getAddress().getIbge();
        this.fileCurriculumName = person.getFileCurriculumName();
        this.fileCurriculumType = person.getFileCurriculumType();
        this.curriculum = person.getCurriculum();
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

    public String getPersonOccupation() {
        return personOccupation;
    }

    public void setPersonOccupation(String personOccupation) {
        this.personOccupation = personOccupation;
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

    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
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
