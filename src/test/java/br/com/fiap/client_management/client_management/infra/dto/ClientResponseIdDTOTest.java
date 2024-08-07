package br.com.fiap.client_management.client_management.infra.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClientResponseIdDTOTest {

    @Test
    public void testClientResponseIdDTO() {
        // Cria uma instância do DTO
        ClientResponseIdDTO dto = new ClientResponseIdDTO("123456");

        // Verifica se o idClient foi corretamente atribuído
        assertThat(dto.idClient()).isEqualTo("123456");
    }

}