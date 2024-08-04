package br.com.fiap.client_management.client_management.infra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClientResponseIdDTO(
        @JsonProperty("id_cliente")
        String idClient
) {}

