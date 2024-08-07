package br.com.fiap.client_management.client_management.domain;

import br.com.fiap.client_management.client_management.infra.persistence.AddressEntity;
import br.com.fiap.client_management.client_management.infra.persistence.ClientEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        Client client = new Client();
        client.setAddress(new Address());
        client.setName("Jose da Silva");
        client.setTelephone("2125222145");
        client.setEmail("email@emai.com");
        client.setCpf("12345678900");
        client.setUuid("2514-fs21441-22220");
    }

    @Test
    public void testClientCreation() {
        // Criando um endereço para o cliente
        Address address = Address.of("Rua Exemplo", "Cidade Exemplo", "Estado Exemplo", "12345-678", "Brasil");

        // Criando um cliente usando o método of
        Client client = Client.of("uuid-1234", "Nome Exemplo", "12345678900", "email@example.com", "123456789", address);

        // Verifica se o objeto não é nulo
        assertNotNull(client);

        // Verifica se os valores dos campos estão corretos
        assertEquals("uuid-1234", client.getUuid());
        assertEquals("Nome Exemplo", client.getName());
        assertEquals("12345678900", client.getCpf());
        assertEquals("email@example.com", client.getEmail());
        assertEquals("123456789", client.getTelephone());
        assertEquals(address, client.getAddress());
    }

    @Test
    public void testClientValidation() {
        Address address = Address.of("Rua Exemplo", "Cidade Exemplo", "Estado Exemplo", "12345-678", "Brasil");

        // Testando criação com nome nulo
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Client.of("uuid-1234", null, "12345678900", "email@example.com", "123456789", address);
        });
        assertEquals("O nome informado é inválido.", exception.getMessage());

        // Testando criação com CPF nulo
        exception = assertThrows(IllegalArgumentException.class, () -> {
            Client.of("uuid-1234", "Nome Exemplo", null, "email@example.com", "123456789", address);
        });
        assertEquals("Informe um CPF com 11 números sem pontuação.", exception.getMessage());

        // Testando criação com email nulo
        exception = assertThrows(IllegalArgumentException.class, () -> {
            Client.of("uuid-1234", "Nome Exemplo", "12345678900", null, "123456789", address);
        });
        assertEquals("O Email informado não é válido.", exception.getMessage());

        // Testando criação com telefone nulo
        exception = assertThrows(IllegalArgumentException.class, () -> {
            Client.of("uuid-1234", "Nome Exemplo", "12345678900", "email@example.com", null, address);
        });
        assertEquals("O telefone informado não é válido.", exception.getMessage());

        // Testando criação com endereço nulo
        exception = assertThrows(IllegalArgumentException.class, () -> {
            Client.of("uuid-1234", "Nome Exemplo", "12345678900", "email@example.com", "123456789", null);
        });
        assertEquals("Preencha os campos do endereço com valores válidos.", exception.getMessage());
    }

    @Test
    public void testClientEntityConversion() {
        // Criando um endereço e um cliente
        Address address = Address.of("Rua Exemplo", "Cidade Exemplo", "Estado Exemplo", "12345-678", "Brasil");
        Client client = Client.of("uuid-1234", "Nome Exemplo", "12345678900", "email@example.com", "123456789", address);

        // Convertendo Client para ClientEntity
        ClientEntity clientEntity = Client.toClientEntity(client);

        // Verificando se os valores estão corretos
        assertNotNull(clientEntity);
        assertEquals(client.getName(), clientEntity.getName());
        assertEquals(client.getEmail(), clientEntity.getEmail());
        assertEquals(client.getCpf(), clientEntity.getCpf());
        assertEquals(client.getTelephone(), clientEntity.getTelephone());

        AddressEntity addressEntity = clientEntity.getAddress();
        assertNotNull(addressEntity);
        assertEquals(address.getStreet(), addressEntity.getStreet());
        assertEquals(address.getCity(), addressEntity.getCity());
        assertEquals(address.getProvince(), addressEntity.getProvince());
        assertEquals(address.getZipCode(), addressEntity.getZipCode());
        assertEquals(address.getCountry(), addressEntity.getCountry());

        // Convertendo ClientEntity de volta para Client
        Client convertedClient = Client.toClient(clientEntity);

        // Verificando se os valores estão corretos
        assertNotNull(convertedClient);
        assertEquals(client.getName(), convertedClient.getName());
        assertEquals(client.getCpf(), convertedClient.getCpf());
        assertEquals(client.getEmail(), convertedClient.getEmail());
        assertEquals(client.getTelephone(), convertedClient.getTelephone());
        assertEquals(client.getAddress().getClass(), convertedClient.getAddress().getClass());
    }
}



