package br.com.eduardowanderley.personregistration.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String lastName;

    private Integer age;

    private String gender;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = CascadeType.ALL)
    List<Phone> phones;

    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

    @ManyToOne
    private Occupation personOccupation;

    public Person() {
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

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Occupation getPersonOccupation() {
        return personOccupation;
    }

    public void setPersonOccupation(Occupation occupation) {
        this.personOccupation = occupation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getId(), person.getId()) && Objects.equals(getName(), person.getName()) && Objects.equals(getLastName(), person.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLastName());
    }
}
