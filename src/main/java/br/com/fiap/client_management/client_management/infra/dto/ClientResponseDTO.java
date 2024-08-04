package br.com.fiap.client_management.client_management.infra.dto;

import br.com.fiap.client_management.client_management.domain.Address;
import br.com.fiap.client_management.client_management.domain.Client;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record ClientResponseDTO(
        @JsonProperty("id_cliente")
        String idClient
) {}

