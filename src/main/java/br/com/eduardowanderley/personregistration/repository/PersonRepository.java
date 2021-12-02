package br.com.eduardowanderley.personregistration.repository;

import br.com.eduardowanderley.personregistration.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
