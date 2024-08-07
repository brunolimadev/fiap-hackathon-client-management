package br.com.fiap.client_management.client_management.infra.dto;

import br.com.fiap.client_management.client_management.domain.Address;
import br.com.fiap.client_management.client_management.domain.Client;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ClientResponseDTOTest {

    @Test
    public void testToClient() {
        // Cria uma instância do DTO
        ClientResponseDTO dto = new ClientResponseDTO(
                "Maria Oliveira",
                "maria.oliveira@example.com",
                "+55 11 91234-5678",
                "98765432100",
                "Avenida Paulista, 1000",
                "São Paulo",
                "SP",
                "01000-000",
                "Brasil"
        );

        // Converte o DTO para Client
        Client client = ClientResponseDTO.toClient(dto);

        // Verifica se o Client foi corretamente criado a partir do DTO
        assertThat(client).isNotNull();
        assertThat(client.getName()).isEqualTo("Maria Oliveira");
        assertThat(client.getEmail()).isEqualTo("maria.oliveira@example.com");
        assertThat(client.getTelephone()).isEqualTo("+55 11 91234-5678");
        assertThat(client.getCpf()).isEqualTo("98765432100");

        // Verifica se o endereço está correto
        Address address = client.getAddress();
        assertThat(address).isNotNull();
        assertThat(address.getStreet()).isEqualTo("Avenida Paulista, 1000");
        assertThat(address.getCity()).isEqualTo("São Paulo");
        assertThat(address.getProvince()).isEqualTo("SP");
        assertThat(address.getZipCode()).isEqualTo("01000-000");
        assertThat(address.getCountry()).isEqualTo("Brasil");
    }

    @Test
    public void testToDto() {
        // Cria um Address e um Client
        Address address = Address.of("Avenida Paulista, 1000", "São Paulo", "SP", "01000-000", "Brasil");
        Client client = Client.of(null, "Carlos Silva", "12345678900", "carlos.silva@example.com", "+55 11 93456-7890", address);

        // Converte o Client para ClientResponseDTO
        ClientResponseDTO dto = ClientResponseDTO.toDto(client);

        // Verifica se o DTO foi corretamente criado a partir do Client
        assertThat(dto).isNotNull();
        assertThat(dto.name()).isEqualTo("Carlos Silva");
        assertThat(dto.email()).isEqualTo("carlos.silva@example.com");
        assertThat(dto.telephone()).isEqualTo("+55 11 93456-7890");
        assertThat(dto.cpf()).isEqualTo("12345678900");
        assertThat(dto.street()).isEqualTo("Avenida Paulista, 1000");
        assertThat(dto.city()).isEqualTo("São Paulo");
        assertThat(dto.province()).isEqualTo("SP");
        assertThat(dto.zipCode()).isEqualTo("01000-000");
        assertThat(dto.country()).isEqualTo("Brasil");
    }

}