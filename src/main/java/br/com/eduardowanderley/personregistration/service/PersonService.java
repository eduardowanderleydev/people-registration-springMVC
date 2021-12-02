package br.com.eduardowanderley.personregistration.service;

import br.com.eduardowanderley.personregistration.controller.dto.person.PersonDTO;
import br.com.eduardowanderley.personregistration.controller.dto.person.PersonFormDTO;
import br.com.eduardowanderley.personregistration.mapper.PersonMapper;
import br.com.eduardowanderley.personregistration.model.Person;
import br.com.eduardowanderley.personregistration.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper mapper;

    public void save(PersonFormDTO personDTO) {
        Person person = mapper.changePersonFormDtoToPerson(personDTO);
        personRepository.save(person);
    }

    public List<PersonDTO> findAll() {
        return personRepository.findAll().stream().map(person -> new PersonDTO(person)).collect(Collectors.toList());
    }

    public PersonDTO findById(Long personid) {
        // TODO change IllegalException for some personalized exception
        return personRepository.findById(personid).map(PersonDTO::new).orElseThrow(() -> new IllegalArgumentException());
    }

}
