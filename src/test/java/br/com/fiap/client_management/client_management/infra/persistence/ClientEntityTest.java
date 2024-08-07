package br.com.fiap.client_management.client_management.infra.persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientEntityTest {
    @Test
    public void testClientEntity() {
        // Criar uma instância de AddressEntity
        AddressEntity address = new AddressEntity();
        address.setStreet("Rua Exemplo");
        address.setCity("Cidade Exemplo");
        address.setProvince("Estado Exemplo");
        address.setCountry("Brasil");
        address.setZipCode("12345-678");

        // Criar uma instância de ClientEntity
        ClientEntity client = new ClientEntity();
        client.setName("Nome Exemplo");
        client.setEmail("email@example.com");
        client.setCpf("12345678900");
        client.setTelephone("123456789");
        client.setAddress(address);

        // Verificar se os getters retornam os valores esperados
        assertEquals("Nome Exemplo", client.getName());
        assertEquals("email@example.com", client.getEmail());
        assertEquals("12345678900", client.getCpf());
        assertEquals("123456789", client.getTelephone());
        assertEquals(address, client.getAddress());

        // Verificar se o ID é nulo após a criação
        assertNull(client.getId());
    }


}