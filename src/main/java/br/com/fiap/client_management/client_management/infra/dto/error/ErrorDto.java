package br.com.fiap.client_management.client_management.infra.dto.error;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public record ErrorDto(
        String title,
        String message,
        String code,
        @JsonInclude(JsonInclude.Include.NON_NULL) List<ErrorFieldDto> fields) {
}
