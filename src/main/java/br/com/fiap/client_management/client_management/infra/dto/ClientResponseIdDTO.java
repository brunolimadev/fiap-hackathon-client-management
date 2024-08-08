package br.com.fiap.client_management.client_management.infra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record ClientResponseIdDTO(
        @Schema(description = "id_cliente", example = "868b4128-6875-4597-b779-ee34958ff587")
        @JsonProperty("id_cliente")
        String idClient
) {}

