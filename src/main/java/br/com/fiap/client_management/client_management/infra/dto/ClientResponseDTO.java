package br.com.fiap.client_management.client_management.infra.dto;

import br.com.fiap.client_management.client_management.domain.Address;
import br.com.fiap.client_management.client_management.domain.Client;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record ClientResponseDTO(
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

        @Schema(description = "ZipCode", example = "22587526")
        @JsonProperty("cep")
        String zipCode,

        @Schema(description = "Pais", example = "Brasil")
        @JsonProperty("pais")
        String country) {

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
