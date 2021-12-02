package br.com.eduardowanderley.personregistration.repository;

import br.com.eduardowanderley.personregistration.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
