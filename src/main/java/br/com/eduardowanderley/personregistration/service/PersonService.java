package br.com.eduardowanderley.personregistration.service;

import br.com.eduardowanderley.personregistration.model.Person;
import br.com.eduardowanderley.personregistration.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public void save(Person person) {
        personRepository.save(person);
    }
}
