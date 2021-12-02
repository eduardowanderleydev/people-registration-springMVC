package br.com.eduardowanderley.personregistration.service;

import br.com.eduardowanderley.personregistration.model.Phone;
import br.com.eduardowanderley.personregistration.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    public List<Phone> findAll() {
        return (List<Phone>) phoneRepository.findAll();
    }

    public List<Phone> findByPerson(Long personid) {
        // TODO change IllegalException for some personalized exception
        return phoneRepository.findPhonesByPerson(personid);
    }

    public void save(Phone phone) {
        phoneRepository.save(phone);
    }
}
