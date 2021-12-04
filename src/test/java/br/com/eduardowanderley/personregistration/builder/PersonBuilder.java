package br.com.eduardowanderley.personregistration.builder;

import br.com.eduardowanderley.personregistration.model.Person;

import java.time.LocalDate;

public class PersonBuilder {

    private static final Long ID_DEFAULT = 999L;
    private static final String NAME_DEFAULT = "Eduardo";
    private static final String LAST_NAME_DEFAULT = "Wanderley";
    private static final Integer AGE_DEFAULT = 20;
    private static final String GENDER_DEFAULT = "MALE";
    private static final LocalDate BIRTHDATE_DEFAULT = LocalDate.of(2002, 03, 03);

    private Long id = ID_DEFAULT;
    private String name = NAME_DEFAULT;
    private String lastName = LAST_NAME_DEFAULT;
    private Integer age = AGE_DEFAULT;
    private String gender = GENDER_DEFAULT;
    private LocalDate birthDate = BIRTHDATE_DEFAULT;


    public static PersonBuilder onePerson() {
        return new PersonBuilder();
    }

    public PersonBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public PersonBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public PersonBuilder withBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }


    public Person build() {
        Person person = new Person();
        person.setId(this.id);
        person.setName(this.name);
        person.setLastName(this.lastName);
        person.setAge(this.age);
        person.setGender(this.gender);
        person.setBirthDate(this.birthDate);
        return person;
    }

}
