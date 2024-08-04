package br.com.fiap.client_management.client_management.infra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AddressResponseDTO(

        @JsonProperty("rua")
        String street,

        @JsonProperty("cidade")
        String city,

        @JsonProperty("estado")
        String country,

        @JsonProperty("cep")
        String zipCode
)
{}
