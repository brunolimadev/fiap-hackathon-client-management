package br.com.fiap.client_management.client_management.infra.controller.Exceptions;

import br.com.fiap.client_management.client_management.infra.dto.error.ErrorDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ExceptionAdviceTest {

    private final ExceptionAdvice exceptionAdvice = new ExceptionAdvice();

    @Test
    public void testHandleClientAlreadyRegisteredException() {
        // Given
        ClientAlreadyRegisteredException exception = new ClientAlreadyRegisteredException("Cliente já cadastrado");

        // When
        ResponseEntity<ErrorDto> response = exceptionAdvice.handleEmailAlreadyInUseException(exception);

        // Then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

}