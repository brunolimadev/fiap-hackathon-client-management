package br.com.fiap.client_management.client_management.infra.dto.error;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorFieldDtoTest {

    @Test
    public void testErrorFieldDto() {
        // Given
        String expectedField = "username";
        String expectedMessage = "Username is required";

        // When
        ErrorFieldDto errorFieldDto = new ErrorFieldDto(expectedField, expectedMessage);

        // Then
        assertEquals(expectedField, errorFieldDto.field());
        assertEquals(expectedMessage, errorFieldDto.message());
    }

}