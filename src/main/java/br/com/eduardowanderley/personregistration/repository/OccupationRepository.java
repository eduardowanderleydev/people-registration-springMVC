package br.com.eduardowanderley.personregistration.repository;

import br.com.eduardowanderley.personregistration.model.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupationRepository extends JpaRepository<Occupation, Long> {
}
