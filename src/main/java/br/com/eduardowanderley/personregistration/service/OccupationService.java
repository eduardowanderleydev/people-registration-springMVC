package br.com.eduardowanderley.personregistration.service;

import br.com.eduardowanderley.personregistration.model.Occupation;
import br.com.eduardowanderley.personregistration.repository.OccupationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccupationService {

    @Autowired
    OccupationRepository occupationRepository;

    public List<Occupation> findAll() {
        return (List<Occupation>) occupationRepository.findAll();
    }
}
