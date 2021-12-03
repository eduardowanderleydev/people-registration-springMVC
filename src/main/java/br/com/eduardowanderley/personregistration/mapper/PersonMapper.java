package br.com.eduardowanderley.personregistration.mapper;

import br.com.eduardowanderley.personregistration.controller.dto.occupation.OccupationDTO;
import br.com.eduardowanderley.personregistration.controller.dto.person.PersonFormDTO;
import br.com.eduardowanderley.personregistration.model.Address;
import br.com.eduardowanderley.personregistration.model.Occupation;
import br.com.eduardowanderley.personregistration.model.Person;
import br.com.eduardowanderley.personregistration.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    @Autowired
    OccupationService occupationService;

    public Person changePersonFormDtoToPerson(PersonFormDTO dto) {
        Person person = new Person();

        person.setAddress(returnAddressByDto(dto));
        person.setAge(dto.getAge());
        person.setBirthDate(dto.getBirthDate());
        person.setGender(dto.getGender());
        person.setName(dto.getName());
        person.setLastName(dto.getLastName());
        person.setPersonOccupation(returnOccupationByDto(dto));
        person.setCurriculum(dto.getCurriculum());
        person.setFileCurriculumName(dto.getFileCurriculumName());
        person.setFileCurriculumType(dto.getFileCurriculumType());
        return person;
    }

    private Occupation returnOccupationByDto(PersonFormDTO dto) {
        Long occupationId = Long.parseLong(dto.getOccupation());
        OccupationDTO occupationDTO = occupationService.findById(occupationId);
        Occupation occupation = new Occupation();
        occupation.setId(occupationDTO.getId());
        occupation.setName(occupationDTO.getName());
        return occupation;
    }

    private Address returnAddressByDto(PersonFormDTO dto) {
        Address address = new Address();
        address.setCep(dto.getCep());
        address.setBairro(dto.getBairro());
        address.setIbge(dto.getIbge());
        address.setCidade(dto.getCidade());
        address.setRua(dto.getRua());
        address.setUf(dto.getUf());
        return address;
    }

}
