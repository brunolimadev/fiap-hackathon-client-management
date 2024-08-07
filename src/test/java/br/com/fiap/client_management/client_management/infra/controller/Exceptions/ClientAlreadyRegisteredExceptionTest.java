package br.com.fiap.client_management.client_management.infra.controller.Exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientAlreadyRegisteredExceptionTest {

    @Test
    public void testExceptionMessage() {
        // Given
        String message = "Esse cliente já se encontra cadastrado no sistema!";

        // When
        ClientAlreadyRegisteredException exception = new ClientAlreadyRegisteredException(message);

        // Then
        assertEquals(message, exception.getMessage());
    }



}