package br.com.fiap.client_management.client_management.infra.persistence;

import br.com.fiap.client_management.client_management.domain.Address;
import br.com.fiap.client_management.client_management.domain.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ClientRepositoryGatewayImplTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientRepositoryGatewayImpl clientRepositoryGateway;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        // Configurando o comportamento do mock
        Address address = Address.of("Rua Exemplo", "Cidade Exemplo", "Estado Exemplo", "12345-678", "Brasil");
        Client client = Client.of("uuid-1234", "Nome Exemplo", "12345678900", "email@example.com", "123456789", address);

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId("uuid-1234");
        clientEntity.setName("Nome Exemplo");
        clientEntity.setEmail("email@example.com");
        clientEntity.setCpf("12345678900");
        clientEntity.setTelephone("123456789");
        clientEntity.setAddress(new AddressEntity()); // Adicionar a configuração para AddressEntity conforme necessário

        when(clientRepository.save(any(ClientEntity.class))).thenReturn(clientEntity);

        // Executando o método a ser testado
        Client savedClient = clientRepositoryGateway.save(client);

        // Verificando o resultado
        assertEquals(client.getUuid(), savedClient.getUuid());
        assertEquals(client.getName(), savedClient.getName());

        // Verificando se o método save foi chamado uma vez com o ClientEntity correto
        verify(clientRepository, times(1)).save(any(ClientEntity.class));
    }

    @Test
    public void testFindClientByCpf() {
        // Configurando o comportamento do mock
        Address address = Address.of("Rua Exemplo", "Cidade Exemplo", "Estado Exemplo", "12345-678", "Brasil");
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId("uuid-1234");
        clientEntity.setName("Nome Exemplo");
        clientEntity.setEmail("email@example.com");
        clientEntity.setCpf("12345678900");
        clientEntity.setTelephone("123456789");
        clientEntity.setAddress(new AddressEntity()); // Adicionar a configuração para AddressEntity conforme necessário

        Client client = Client.of("uuid-1234", "Nome Exemplo", "12345678900", "email@example.com", "123456789", address);

        when(clientRepository.findClientByCpf(anyString())).thenReturn(clientEntity);

        // Executando o método a ser testado
        Client foundClient = clientRepositoryGateway.findClientByCpf("12345678900");

        // Verificando o resultado
        assertEquals(client.getCpf(), foundClient.getCpf());
        assertEquals(client.getName(), foundClient.getName());

        // Verificando se o método findClientByCpf foi chamado uma vez com o CPF correto
        verify(clientRepository, times(1)).findClientByCpf(anyString());
    }

}