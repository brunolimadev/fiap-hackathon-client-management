package br.com.fiap.client_management.client_management.application;

import br.com.fiap.client_management.client_management.domain.Address;
import br.com.fiap.client_management.client_management.domain.Client;
import br.com.fiap.client_management.client_management.gateway.ClientRepositoryGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ClientUCTest {

    @Mock
    private ClientRepositoryGateway clientRepositoryGateway;

    @InjectMocks
    private ClientUC clientUC;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        // Configurando o comportamento do mock
        Address address = Address.of("Rua Exemplo", "Cidade Exemplo", "Estado Exemplo", "12345-678", "Brasil");
        Client client = Client.of("uuid-1234", "Nome Exemplo", "12345678900", "email@example.com", "123456789", address);

        when(clientRepositoryGateway.save(client)).thenReturn(client);

        // Executando o método a ser testado
        Client savedClient = clientUC.save(client);

        // Verificando o resultado
        assertNotNull(savedClient);
        assertEquals(client, savedClient);

        // Verificando se o método save foi chamado uma vez com o cliente correto
        verify(clientRepositoryGateway, times(1)).save(client);
    }

    @Test
    public void testFindClientByCpf() {
        // Configurando o comportamento do mock
        Address address = Address.of("Rua Exemplo", "Cidade Exemplo", "Estado Exemplo", "12345-678", "Brasil");
        Client client = Client.of("uuid-1234", "Nome Exemplo", "12345678900", "email@example.com", "123456789", address);

        when(clientRepositoryGateway.findClientByCpf("12345678900")).thenReturn(client);

        // Executando o método a ser testado
        Client foundClient = clientUC.findClientByCpf("12345678900");

        // Verificando o resultado
        assertNotNull(foundClient);
        assertEquals(client, foundClient);

        // Verificando se o método findClientByCpf foi chamado uma vez com o CPF correto
        verify(clientRepositoryGateway, times(1)).findClientByCpf("12345678900");
    }

}
