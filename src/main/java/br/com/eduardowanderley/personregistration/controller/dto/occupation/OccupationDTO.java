package br.com.eduardowanderley.personregistration.controller.dto.occupation;

import br.com.eduardowanderley.personregistration.model.Occupation;

public class OccupationDTO {

    private Long id;
    private String name;

    public OccupationDTO(Occupation ocp) {
        this.id = ocp.getId();
        this.name = ocp.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
