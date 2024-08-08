package br.com.fiap.client_management.client_management.infra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record AddressResponseDTO(

        @Schema(description = "Rua", example = "Rua a")
        @JsonProperty("rua")
        String street,

        @Schema(description = "Cidade", example = "Guarulhos")
        @JsonProperty("cidade")
        String city,

        @Schema(description = "Estado", example = "São Paulo")
        @JsonProperty("estado")
        String country,

        @Schema(description = "Cep", example = "22587526")
        @JsonProperty("cep")
        String zipCode
)
{}
