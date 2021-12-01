package br.com.eduardowanderley.personregistration.repository;

import br.com.eduardowanderley.personregistration.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
