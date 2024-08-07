package br.com.fiap.client_management.client_management.infra.controller.Exceptions;

import br.com.fiap.client_management.client_management.infra.dto.error.ErrorDto;
import br.com.fiap.client_management.client_management.infra.dto.error.ErrorFieldDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<ErrorDto> handleRuntimeException(RuntimeException runtimeException) {
        ErrorDto errorDto = new ErrorDto(
                "Ocorreu um erro interno",
                runtimeException.getMessage(),
                "500", null);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public ResponseEntity<ErrorDto> handleValidationException(MethodArgumentNotValidException ex) {
        List<ErrorFieldDto> errorFields = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorFields.add(new ErrorFieldDto(error.getField(), error.getDefaultMessage()));
        });

        ErrorDto errorDto = new ErrorDto(
                "Dados inválidos",
                "Por favor, verifique os dados enviados e tente novamente.",
                "400",
                errorFields);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    @ExceptionHandler({ NoResourceFoundException.class })
    public ResponseEntity<ErrorDto> handleNotFoundException(NoResourceFoundException ex) {
        ErrorDto errorDto = new ErrorDto(
                "Erro interno",
                "Recurso não encontrado.",
                "404", null);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }

    @ExceptionHandler({ ClientAlreadyRegisteredException.class} )
    public ResponseEntity<ErrorDto> handleEmailAlreadyInUseException(ClientAlreadyRegisteredException e) {
        ErrorDto errorDto = new ErrorDto(
                "Dados Inválidos",
                e.getMessage(),
                "500",
                null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }

}
