package br.com.eduardowanderley.personregistration.service;

import br.com.eduardowanderley.personregistration.controller.dto.occupation.OccupationDTO;
import br.com.eduardowanderley.personregistration.model.Occupation;
import br.com.eduardowanderley.personregistration.repository.OccupationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OccupationService {

    @Autowired
    private OccupationRepository occupationRepository;

    public List<OccupationDTO> findAll() {
        return occupationRepository.findAll().stream().map(occupation -> new OccupationDTO(occupation)).collect(Collectors.toList());
    }

    public OccupationDTO findById(Long id) {
        return occupationRepository.findById(id).map(OccupationDTO::new).orElseThrow(() -> new IllegalArgumentException());
    }
}
