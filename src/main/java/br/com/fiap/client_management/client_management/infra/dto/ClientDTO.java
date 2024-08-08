package br.com.fiap.client_management.client_management.infra.dto;

import br.com.fiap.client_management.client_management.domain.Address;
import br.com.fiap.client_management.client_management.domain.Client;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record ClientDTO(
        @Schema(description = "Nome", example = "João da Silva")
        @JsonProperty("nome")
        String name,

        @Schema(description = "Email", example = "joao@example.com")
        @JsonProperty("email")
        String email,

        @Schema(description = "Telefone", example = "55 11 91234-5678")
        @JsonProperty("telefone")
        String telephone,

        @Schema(description = "Cpf", example = "João da Silva")
        @JsonProperty("cpf")
        String cpf,

        @Schema(description = "Rua", example = "Rua A")
        @JsonProperty("rua")
        String street,

        @Schema(description = "Cidade", example = "Guarulhos")
        @JsonProperty("cidade")
        String city,

        @Schema(description = "Estado", example = "São Paulo")
        @JsonProperty("estado")
        String province,

        @Schema(description = "Pais", example = "Brasil")
        @JsonProperty("pais")
        String country,

        @Schema(description = "Cep", example = "22587526")
        @JsonProperty("cep")
        String zipCode) {

    public static Client toClient(ClientDTO dto) {
        return Client.of(null, dto.name, dto.cpf, dto.email, dto.telephone,
                Address.of(dto.street, dto.city, dto.province, dto.zipCode, dto.country));
    }

}
