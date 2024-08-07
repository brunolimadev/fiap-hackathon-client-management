package br.com.fiap.client_management.client_management.infra.persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressEntityTest {

    @Test
    public void testAddressEntity() {
        // Criar uma instância da entidade
        AddressEntity address = new AddressEntity();

        // Definir valores para os atributos
        address.setStreet("Rua Exemplo");
        address.setCity("Cidade Exemplo");
        address.setProvince("Estado Exemplo");
        address.setCountry("Brasil");
        address.setZipCode("12345-678");

        // Verificar se os getters retornam os valores esperados
        assertEquals("Rua Exemplo", address.getStreet());
        assertEquals("Cidade Exemplo", address.getCity());
        assertEquals("Estado Exemplo", address.getProvince());
        assertEquals("Brasil", address.getCountry());
        assertEquals("12345-678", address.getZipCode());

        // Verificar se o ID é nulo após a criação
        assertEquals(null, address.getId());
    }

}