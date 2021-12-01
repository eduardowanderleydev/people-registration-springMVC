package br.com.eduardowanderley.personregistration.repository;

import br.com.eduardowanderley.personregistration.model.Occupation;
import org.springframework.data.repository.CrudRepository;

public interface OccupationRepository extends CrudRepository<Occupation, Long> {
}
