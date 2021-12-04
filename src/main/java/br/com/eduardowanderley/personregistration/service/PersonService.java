package br.com.eduardowanderley.personregistration.service;

import br.com.eduardowanderley.personregistration.controller.dto.person.PersonDTO;
import br.com.eduardowanderley.personregistration.controller.dto.person.PersonFormDTO;
import br.com.eduardowanderley.personregistration.mapper.PersonMapper;
import br.com.eduardowanderley.personregistration.model.Person;
import br.com.eduardowanderley.personregistration.repository.PersonRepository;
import br.com.eduardowanderley.personregistration.service.exceptions.DatabaseException;
import br.com.eduardowanderley.personregistration.service.exceptions.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper mapper;

    public Page<Person> findByPage(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    public List<PersonDTO> findAll() {
        return personRepository.findAll().stream().map(PersonDTO::new).collect(Collectors.toList());
    }

    public List<PersonFormDTO> findAllFormDto() {
        return personRepository.findAll().stream().map(PersonFormDTO::new).collect(Collectors.toList());
    }

    public PersonDTO findById(Long personid) {
        return personRepository.findById(personid).map(PersonDTO::new).orElseThrow(() -> new PersonNotFoundException("Person with id " + personid + "cannot be found"));
    }

    public PersonFormDTO findPersonToEditById(Long personid) {
        return personRepository.findById(personid).map(PersonFormDTO::new).orElseThrow(() -> new PersonNotFoundException("Person with id " + personid + "cannot be found"));
    }

    public Page<Person> findPersonByNameAndGenderPage(String genderSearch, String research, Pageable pageable) {
        return personRepository.findPersonByNameAndGenderPage(genderSearch, research, pageable);
    }

    public Page<Person> findPersonByNamePage(String research, Pageable pageable) {
        return personRepository.findPersonByNamePage(research, pageable);
    }

    public Page<Person> findPersonByGenderPage(String genderSearch, Pageable pageable) {
        return personRepository.findPersonByGenderPage(genderSearch, pageable);
    }

    public List<PersonFormDTO> findByNameAndGender(String research, String genderSearch) {
        return personRepository.findByNameAndGender(research, genderSearch).stream().map(PersonFormDTO::new).collect(Collectors.toList());
    }

    public List<PersonFormDTO> findByName(String research) {
        return personRepository.findByNameContaining(research).stream().map(PersonFormDTO::new).collect(Collectors.toList());
    }

    public List<PersonFormDTO> findByGender(String genderSearch) {
        return personRepository.findByGender(genderSearch).stream().map(PersonFormDTO::new).collect(Collectors.toList());
    }

    public void save(PersonFormDTO personDTO) {
        Person person = mapper.changePersonFormDtoToPerson(personDTO);
        personRepository.save(person);
    }

    public void deleteById(Long personId) {
        try {
            personRepository.deleteById(personId);
        } catch (EmptyResultDataAccessException e) {
            throw new PersonNotFoundException("Person with id " + personId + "cannot be found");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Database violation");
        }
    }
}
