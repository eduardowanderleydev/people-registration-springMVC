package br.com.eduardowanderley.personregistration.service;

import br.com.eduardowanderley.personregistration.builder.PersonBuilder;
import br.com.eduardowanderley.personregistration.controller.dto.person.PersonFormDTO;
import br.com.eduardowanderley.personregistration.model.Person;
import br.com.eduardowanderley.personregistration.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

    private static final String SHOULD_THROW_AN_EXCEPTION_MESSAGE = "Should throw an exception";

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Before
    public void setup() {
        personRepository.deleteAll();
        Person p1 = PersonBuilder.onePerson().withName("Eduardo").withGender("MALE").build();
        Person p2 = PersonBuilder.onePerson().withName("Braz").withGender("MALE").build();
        Person p3 = PersonBuilder.onePerson().withName("Wanderley").withGender("MALE").build();

        Person p4 = PersonBuilder.onePerson().withName("Giovana").withGender("FEMALE").build();
        Person p5 = PersonBuilder.onePerson().withName("Oliveira").withGender("FEMALE").build();
        Person p6 = PersonBuilder.onePerson().withName("Fabiana").withGender("FEMALE").build();
        personRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
    }

    @Test
    public void findByGender_WhenAValidGender_ShouldGetAllPersonByGender() {
        final String GENDER = "MALE";
        List<PersonFormDTO> list = personService.findByGender(GENDER);

        list.forEach(p -> {
            Assert.assertEquals(GENDER, p.getGender());
        });
    }

    @Test
    public void findByName_WhenAnExistentName_ShouldGetAllPersonByName() {
        final String RESEARCH = "b";
        List<PersonFormDTO> list = personService.findByName(RESEARCH);

        list.forEach(p -> {
            Assert.assertTrue(p.getName().toUpperCase().contains(RESEARCH.toUpperCase()));
        });
    }

    @Test
    public void findByNameAndGender_WhenAValidGenderAndAnExistentName_ShouldGetAllPersonByNameAndGender() {
        final String RESEARCH = "b";
        final String GENDER = "MALE";
        List<PersonFormDTO> list = personService.findByNameAndGender(RESEARCH, GENDER);

        list.forEach(p -> {
            Assert.assertTrue(p.getName().toUpperCase().contains(RESEARCH.toUpperCase()) && p.getGender().equals(GENDER));
        });
    }

    @Test
    public void findPersonByGenderPage_WhenAValidGender_ShouldGetPageOfPersonByGender() {
        final String GENDER = "FEMALE";
        Page<Person> list = personService.findPersonByGenderPage(GENDER, PageRequest.of(0, 5, Sort.by("name")));

        list.forEach(p -> {
            Assert.assertEquals("FEMALE", p.getGender());
        });
    }

    @Test
    public void findPersonByNamePage_WhenAnExistentName_ShouldGetAllPersonByName() {
        final String RESEARCH = "a";
        Page<Person> list = personService.findPersonByNamePage(RESEARCH, PageRequest.of(0, 5, Sort.by("name")));

        list.forEach(p -> {
            Assert.assertTrue(p.getName().contains(RESEARCH));
        });
    }

    @Test
    public void findPersonByNameAndGenderPage_WhenAValidGenderAndAnExistentName_ShouldGetPagePersonByNameAndGender() {
        final String RESEARCH = "b";
        final String GENDER = "MALE";
        Page<Person> list = personService.findPersonByNameAndGenderPage(GENDER, RESEARCH, PageRequest.of(0, 5, Sort.by("name")));

        list.forEach(p -> {
            Assert.assertTrue(p.getName().toUpperCase().contains(RESEARCH.toUpperCase()) && p.getGender().equals(GENDER));
        });
    }

    @Test
    public void deleteById_whenIdDoesNotExists_shouldThrowPersonNotFoundException() {
        final long ID = 999;

        try {
            personService.deleteById(ID);
            Assert.fail(SHOULD_THROW_AN_EXCEPTION_MESSAGE);
        } catch (Exception e) {
            Assert.assertEquals("Person with id " + ID + "cannot be found", e.getMessage());
        }
    }
}
