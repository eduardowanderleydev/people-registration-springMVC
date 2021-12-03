package br.com.eduardowanderley.personregistration.controller.dto.phone;

import br.com.eduardowanderley.personregistration.model.Phone;

import java.io.Serializable;

public class PhoneDTO implements Serializable {

    private Long id;
    private String number;
    private String type;

    public PhoneDTO() {
    }

    public PhoneDTO(Phone phone) {
        this.id = phone.getId();
        this.number = phone.getNumber();
        this.type = phone.getType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
