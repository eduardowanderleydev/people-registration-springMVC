package br.com.eduardowanderley.personregistration.repository;

import br.com.eduardowanderley.personregistration.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
