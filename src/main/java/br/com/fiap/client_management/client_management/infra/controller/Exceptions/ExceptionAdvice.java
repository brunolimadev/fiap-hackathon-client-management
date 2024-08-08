package br.com.fiap.client_management.client_management.infra.controller.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import br.com.fiap.client_management.client_management.infra.dto.error.ErrorDto;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler({ NoResourceFoundException.class })
    public ResponseEntity<ErrorDto> handleNotFoundException(NoResourceFoundException ex) {
        ErrorDto errorDto = new ErrorDto(
                "Erro interno",
                "Recurso não encontrado.",
                "404", null);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }

    @ExceptionHandler({ ClientAlreadyRegisteredException.class })
    public ResponseEntity<ErrorDto> handleEmailAlreadyInUseException(ClientAlreadyRegisteredException e) {
        ErrorDto errorDto = new ErrorDto(
                "Dados inválidos",
                e.getMessage(),
                "500",
                null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }

    @ExceptionHandler({ ClientNotFoundException.class })
    public ResponseEntity<ErrorDto> handleEmailAlreadyInUseException(ClientNotFoundException e) {
        ErrorDto errorDto = new ErrorDto(
                "Dados Inválidos",
                e.getMessage(),
                "500",
                null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }

}
