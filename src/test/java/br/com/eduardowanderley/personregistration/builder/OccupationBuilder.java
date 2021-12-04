package br.com.eduardowanderley.personregistration.builder;

import br.com.eduardowanderley.personregistration.model.Occupation;

public class OccupationBuilder {

    private static final Long ID_DEFAULT = 999l;
    private static final String NAME_DEFAULT = "Dev";

    private Long id = ID_DEFAULT;
    private String name = NAME_DEFAULT;

    public static OccupationBuilder OneOccupation() {
        return new OccupationBuilder();
    }

    public OccupationBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public OccupationBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public Occupation build() {
        Occupation occupation = new Occupation();
        occupation.setId(this.id);
        occupation.setName(this.name);
        return occupation;
    }

}
