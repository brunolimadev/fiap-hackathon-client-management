package br.com.fiap.client_management.client_management.infra.controller.Exceptions;

public class ClientAlreadyRegisteredException extends RuntimeException {

    public ClientAlreadyRegisteredException(String message) {
        super(message);
    }
}
