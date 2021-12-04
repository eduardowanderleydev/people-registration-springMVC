package br.com.eduardowanderley.personregistration.service.exceptions;

public class PhoneNotFoundException extends RuntimeException {
    public PhoneNotFoundException(String msg) {
        super(msg);
    }
}
