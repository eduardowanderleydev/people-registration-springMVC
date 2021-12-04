package br.com.eduardowanderley.personregistration.service;

import br.com.eduardowanderley.personregistration.controller.dto.phone.PhoneDTO;
import br.com.eduardowanderley.personregistration.mapper.PhoneMapper;
import br.com.eduardowanderley.personregistration.model.Person;
import br.com.eduardowanderley.personregistration.model.Phone;
import br.com.eduardowanderley.personregistration.repository.PersonRepository;
import br.com.eduardowanderley.personregistration.repository.PhoneRepository;
import br.com.eduardowanderley.personregistration.service.exceptions.DatabaseException;
import br.com.eduardowanderley.personregistration.service.exceptions.PersonNotFoundException;
import br.com.eduardowanderley.personregistration.service.exceptions.PhoneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PhoneMapper mapper;

    public List<PhoneDTO> findAll() {
        return phoneRepository.findAll().stream().map(PhoneDTO::new).collect(Collectors.toList());
    }

    public List<PhoneDTO> findByPerson(Long personid) {
        return phoneRepository.findPhonesByPerson(personid).stream().map(PhoneDTO::new).collect(Collectors.toList());
    }

    public void save(PhoneDTO phoneDTO, Long personId) {
        Phone phone = mapper.changePhoneDtoToPhone(phoneDTO);
        Person person = personRepository.findById(personId).orElseThrow(() -> new PersonNotFoundException("Person with id " + personId + "cannot be found"));
        phone.setPerson(person);

        phoneRepository.save(phone);
    }

    public PhoneDTO findById(Long id) {
        return phoneRepository.findById(id).map(PhoneDTO::new).orElseThrow(() -> new PhoneNotFoundException("Phone with id " + id + "cannot be found"));
    }

    public long findPersonIdByPhone(Long id) {
        Phone phone = phoneRepository.findById(id).orElseThrow(() -> new PhoneNotFoundException("Phone with id " + id + "cannot be found"));
        return phone.getPerson().getId();
    }

    public void deleteById(Long id) {
        try {
            phoneRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new PhoneNotFoundException("Phone with id " + id + "cannot be found");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Database violation");
        }

    }
}
