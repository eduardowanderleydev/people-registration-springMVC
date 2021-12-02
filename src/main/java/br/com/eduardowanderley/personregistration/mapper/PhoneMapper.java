package br.com.eduardowanderley.personregistration.mapper;

import br.com.eduardowanderley.personregistration.controller.dto.phone.PhoneDTO;
import br.com.eduardowanderley.personregistration.model.Phone;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapper {

    public Phone changePhoneDtoToPhone(PhoneDTO dto) {
        Phone phone = new Phone();
        phone.setId(dto.getId());
        phone.setType(dto.getType());
        phone.setNumber(dto.getNumber());
        return phone;
    }
}
