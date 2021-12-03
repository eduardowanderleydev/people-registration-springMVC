package br.com.eduardowanderley.personregistration.repository;

import br.com.eduardowanderley.personregistration.model.Person;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    default Page<Person> findPersonByNamePage(String name, Pageable pageable) {

        Person person = new Person();
        person.setName(name);

        /*
         * Configurando a pesquisa para consultar por por nome no banco de dados (
         * funciona como o like do sql)
         */
        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny().withMatcher("name",
                ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        /* Une o objeto com o valor e a configuração pra consultar */
        Example<Person> example = Example.of(person, exampleMatcher);

        Page<Person> people = findAll(example, pageable);

        return people;
    }

    default Page<Person> findPersonByGenderPage(String gender, Pageable pageable) {

        Person person = new Person();
        person.setGender(gender);

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll().withMatcher("gender",
                ExampleMatcher.GenericPropertyMatchers.exact().ignoreCase());

        Example<Person> example = Example.of(person, exampleMatcher);

        Page<Person> people = findAll(example, pageable);

        return people;
    }

    default Page<Person> findPersonByNameAndGenderPage(String gender, String name, Pageable pageable) {

        Person person = new Person();
        person.setName(name);
        person.setGender(gender);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("gender", ExampleMatcher.GenericPropertyMatchers.exact().ignoreCase());

        Example<Person> example = Example.of(person, exampleMatcher);

        Page<Person> people = findAll(example, pageable);

        return people;
    }

}
