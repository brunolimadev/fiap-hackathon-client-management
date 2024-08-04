package br.com.fiap.client_management.client_management.infra.dto;

import br.com.fiap.client_management.client_management.domain.Address;
import br.com.fiap.client_management.client_management.domain.Client;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ClientResponseDTO(
        @JsonProperty("nome") String name,

        @JsonProperty("email") String email,

        @JsonProperty("telefone") String telephone,

        @JsonProperty("cpf") String cpf,

        @JsonProperty("rua") String street,

        @JsonProperty("cidade") String city,

        @JsonProperty("estado") String province,

        @JsonProperty("cep") String zipCode,

        @JsonProperty("pais") String country) {

    public static Client toClient(ClientResponseDTO dto) {
        return Client.of(null, dto.name, dto.cpf, dto.email, dto.telephone,
                Address.of(dto.street, dto.city, dto.province, dto.zipCode, dto.country));
    }

    public static ClientResponseDTO toDto(Client client) {
        Address address = client.getAddress();
        return new ClientResponseDTO(client.getName(), client.getEmail(), client.getTelephone(), client.getCpf(),
                address.getStreet(), address.getCity(), address.getProvince(), address.getZipCode(),
                address.getCountry());
    }

}
