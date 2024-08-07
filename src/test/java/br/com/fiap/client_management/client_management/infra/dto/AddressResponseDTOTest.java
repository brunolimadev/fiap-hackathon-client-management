package br.com.fiap.client_management.client_management.infra.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AddressResponseDTOTest {

    @Test
    public void testAddressResponseDTO() {
        // Cria uma instância do DTO
        AddressResponseDTO dto = new AddressResponseDTO(
                "Rua A",
                "Cidade B",
                "Estado C",
                "12345-678"
        );

        // Verifica se os valores estão corretos
        assertThat(dto.street()).isEqualTo("Rua A");
        assertThat(dto.city()).isEqualTo("Cidade B");
        assertThat(dto.country()).isEqualTo("Estado C");
        assertThat(dto.zipCode()).isEqualTo("12345-678");
    }

}