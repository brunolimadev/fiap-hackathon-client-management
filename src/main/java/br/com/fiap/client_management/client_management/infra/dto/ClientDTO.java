package br.com.fiap.client_management.client_management.infra.dto;

import br.com.fiap.client_management.client_management.domain.Address;
import br.com.fiap.client_management.client_management.domain.Client;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ClientDTO(
        @JsonProperty("nome") String name,

        @JsonProperty("email") String email,

        @JsonProperty("telefone") String telephone,

        @JsonProperty("cpf") String cpf,

        @JsonProperty("rua") String street,

        @JsonProperty("cidade") String city,

        @JsonProperty("estado") String province,

        @JsonProperty("pais") String country,

        @JsonProperty("cep") String zipCode) {

    public static Client toClient(ClientDTO dto) {
        return Client.of(null, dto.name, dto.cpf, dto.email, dto.telephone,
                Address.of(dto.street, dto.city, dto.province, dto.zipCode, dto.country));
    }

}
