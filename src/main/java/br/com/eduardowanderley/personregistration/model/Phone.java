package br.com.eduardowanderley.personregistration.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String type;

    @ManyToOne
    private Person person;

    public Phone(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return Objects.equals(getId(), phone.getId()) && Objects.equals(getNumber(), phone.getNumber()) && Objects.equals(getPerson(), phone.getPerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumber(), getPerson());
    }
}
