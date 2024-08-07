package br.com.fiap.client_management.client_management.infra.dto;

import br.com.fiap.client_management.client_management.domain.Address;
import br.com.fiap.client_management.client_management.domain.Client;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ClientDTOTest {

    @Test
    public void testToClient() {
        // Cria uma instância do DTO
        ClientDTO dto = new ClientDTO(
                "João Silva",
                "joao.silva@example.com",
                "+55 11 98765-4321",
                "12345678900",
                "Rua das Flores, 123",
                "São Paulo",
                "SP",
                "Brasil",
                "01234-567"
        );

        // Converte o DTO para Client
        Client client = ClientDTO.toClient(dto);

        // Verifica se o Client foi corretamente criado a partir do DTO
        assertThat(client).isNotNull();
        assertThat(client.getName()).isEqualTo("João Silva");
        assertThat(client.getEmail()).isEqualTo("joao.silva@example.com");
        assertThat(client.getTelephone()).isEqualTo("+55 11 98765-4321");
        assertThat(client.getCpf()).isEqualTo("12345678900");

        // Verifica se o endereço está correto
        Address address = client.getAddress();
        assertThat(address).isNotNull();
        assertThat(address.getStreet()).isEqualTo("Rua das Flores, 123");
        assertThat(address.getCity()).isEqualTo("São Paulo");
        assertThat(address.getProvince()).isEqualTo("SP");
        assertThat(address.getCountry()).isEqualTo("Brasil");
        assertThat(address.getZipCode()).isEqualTo("01234-567");
    }

}