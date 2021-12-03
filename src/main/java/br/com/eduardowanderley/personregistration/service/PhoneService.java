package br.com.eduardowanderley.personregistration.service;

import br.com.eduardowanderley.personregistration.controller.dto.phone.PhoneDTO;
import br.com.eduardowanderley.personregistration.mapper.PhoneMapper;
import br.com.eduardowanderley.personregistration.model.Person;
import br.com.eduardowanderley.personregistration.model.Phone;
import br.com.eduardowanderley.personregistration.repository.PersonRepository;
import br.com.eduardowanderley.personregistration.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        return phoneRepository.findAll().stream().map(phone -> new PhoneDTO(phone)).collect(Collectors.toList());
    }

    public List<PhoneDTO> findByPerson(Long personid) {
        // TODO change IllegalException for some personalized exception
        return phoneRepository.findPhonesByPerson(personid).stream().map(phone -> new PhoneDTO(phone)).collect(Collectors.toList());
    }

    public void save(PhoneDTO phoneDTO, Long personId) {
        Phone phone = mapper.changePhoneDtoToPhone(phoneDTO);
        Person person = personRepository.findById(personId).orElseThrow(() -> new RuntimeException());
        phone.setPerson(person);

        phoneRepository.save(phone);
    }

    public PhoneDTO findById(Long id) {
        return phoneRepository.findById(id).map(phone -> new PhoneDTO(phone)).orElseThrow(() -> new RuntimeException());
    }

    public long findPersonIdByPhone(Long id) {
        Phone phone = phoneRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return phone.getId();
    }

    public void deleteById(Long id) {
        phoneRepository.deleteById(id);
    }
}
