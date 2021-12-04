package br.com.eduardowanderley.personregistration.service.exceptions;

public class OccupationNotFoundException extends RuntimeException {
    public OccupationNotFoundException(String msg) {
        super(msg);
    }
}
