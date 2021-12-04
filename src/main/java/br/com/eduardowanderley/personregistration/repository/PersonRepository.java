package br.com.eduardowanderley.personregistration.repository;

import br.com.eduardowanderley.personregistration.model.Person;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select p from Person p where lower( p.name ) LIKE LOWER( CONCAT('%',:name,'%') ) and lower( p.gender ) LIKE LOWER( CONCAT('%',:gender,'%') )")
    List<Person> findByNameAndGender(@Param("name") String name, @Param("gender") String gender);

    @Query("select p from Person p where lower( p.name ) LIKE LOWER( CONCAT('%',:name,'%') )")
    List<Person> findByNameContaining(@Param("name") String name);

    @Query("select p from Person p where lower( p.gender ) = lower( ?1 )")
    List<Person> findByGender(String gender);

    default Page<Person> findPersonByNamePage(String name, Pageable pageable) {

        Person person = new Person();
        person.setName(name);
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matchingAny()
                .withMatcher("name", ExampleMatcher
                        .GenericPropertyMatchers
                        .contains()
                        .ignoreCase());
        Example<Person> example = Example.of(person, exampleMatcher);

        return findAll(example, pageable);
    }

    default Page<Person> findPersonByGenderPage(String gender, Pageable pageable) {

        Person person = new Person();
        person.setGender(gender);
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matchingAll()
                .withMatcher("gender", ExampleMatcher
                        .GenericPropertyMatchers
                        .exact()
                        .ignoreCase());
        Example<Person> example = Example.of(person, exampleMatcher);

        return findAll(example, pageable);
    }

    default Page<Person> findPersonByNameAndGenderPage(String gender, String name, Pageable pageable) {

        Person person = new Person();
        person.setName(name);
        person.setGender(gender);

        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withMatcher("name", ExampleMatcher
                        .GenericPropertyMatchers
                        .contains()
                        .ignoreCase())
                .withMatcher("gender", ExampleMatcher
                        .GenericPropertyMatchers
                        .exact()
                        .ignoreCase());

        Example<Person> example = Example.of(person, exampleMatcher);

        return findAll(example, pageable);
    }
}
