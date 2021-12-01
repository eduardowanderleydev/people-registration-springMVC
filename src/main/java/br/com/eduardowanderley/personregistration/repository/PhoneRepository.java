package br.com.eduardowanderley.personregistration.repository;

import br.com.eduardowanderley.personregistration.model.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<Phone, Long> {
}
