package br.com.eduardowanderley.personregistration.repository;

import br.com.eduardowanderley.personregistration.model.Occupation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupationRepository extends CrudRepository<Occupation, Long> {
}
