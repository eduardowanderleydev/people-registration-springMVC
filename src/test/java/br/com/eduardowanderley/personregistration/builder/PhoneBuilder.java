package br.com.eduardowanderley.personregistration.builder;

import br.com.eduardowanderley.personregistration.model.Phone;

public class PhoneBuilder {

    private static final Long ID_DEFAULT = 999l;
    private static final String NUMBER_DEFAULT = "123456789";
    private static final String TYPE_DEFAULT = "home";

    private Long id = ID_DEFAULT;
    private String number = NUMBER_DEFAULT;
    private String type = TYPE_DEFAULT;

    public static PhoneBuilder onePhone() {
        return new PhoneBuilder();
    }

    public PhoneBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public PhoneBuilder withNumber(String number) {
        this.number = number;
        return this;
    }

    public PhoneBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public Phone build() {
        Phone phone = new Phone();
        phone.setId(this.id);
        phone.setNumber(this.number);
        phone.setType(this.type);
        return phone;
    }

}
