package br.com.eduardowanderley.personregistration.repository;

import br.com.eduardowanderley.personregistration.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
    @Query("select p from Phone p where p.person.id= ?1")
    List<Phone> findPhonesByPerson(Long personid);
}
