package br.com.fiap.client_management.client_management.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        Address address = new Address();
        address.setCity("cidade");
        address.setCountry("Pais");
        address.setProvince("bairro");
        address.setZipCode("cep");
    }

    @Test
    public void testAddressCreation() {
        // Criação do objeto Address usando o método of
        Address address = Address.of("Rua Exemplo", "Cidade Exemplo", "Estado Exemplo", "12345-678", "Brasil");

        // Verifica se o objeto não é nulo
        assertNotNull(address);

        // Verifica se os valores dos campos estão corretos
        assertEquals("Rua Exemplo", address.getStreet());
        assertEquals("Cidade Exemplo", address.getCity());
        assertEquals("Estado Exemplo", address.getProvince());
        assertEquals("12345-678", address.getZipCode());
        assertEquals("Brasil", address.getCountry());
    }

    @Test
    public void testSetters() {
        // Criação do objeto Address usando o construtor padrão
        Address address = new Address();

        // Definindo valores usando os setters
        address.setStreet("Rua Exemplo");
        address.setCity("Cidade Exemplo");
        address.setProvince("Estado Exemplo");
        address.setZipCode("12345-678");
        address.setCountry("Brasil");

        // Verifica se os valores dos campos estão corretos
        assertEquals("Rua Exemplo", address.getStreet());
        assertEquals("Cidade Exemplo", address.getCity());
        assertEquals("Estado Exemplo", address.getProvince());
        assertEquals("12345-678", address.getZipCode());
        assertEquals("Brasil", address.getCountry());
    }



}