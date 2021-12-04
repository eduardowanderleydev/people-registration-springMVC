package br.com.eduardowanderley.personregistration.service;

import br.com.eduardowanderley.personregistration.controller.dto.occupation.OccupationDTO;
import br.com.eduardowanderley.personregistration.service.exceptions.OccupationNotFoundException;
import br.com.eduardowanderley.personregistration.repository.OccupationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OccupationService {

    @Autowired
    private OccupationRepository occupationRepository;

    public List<OccupationDTO> findAll() {
        return occupationRepository.findAll().stream().map(OccupationDTO::new).collect(Collectors.toList());
    }

    public OccupationDTO findById(Long id) {
        return occupationRepository.findById(id).map(OccupationDTO::new).orElseThrow(() -> new OccupationNotFoundException("Occupation with id " + id + "cannot be found"));
    }
}
