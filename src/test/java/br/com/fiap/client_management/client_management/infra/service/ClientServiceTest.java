package br.com.fiap.client_management.client_management.infra.service;

import br.com.fiap.client_management.client_management.application.ClientUC;
import br.com.fiap.client_management.client_management.domain.Address;
import br.com.fiap.client_management.client_management.domain.Client;
import br.com.fiap.client_management.client_management.infra.dto.ClientDTO;
import br.com.fiap.client_management.client_management.infra.dto.ClientResponseDTO;
import br.com.fiap.client_management.client_management.infra.dto.ClientResponseIdDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ClientServiceTest {

    @Mock
    private ClientUC clientUC;

    @InjectMocks
    private ClientService clientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        // Configurando o comportamento do mock
        Address address = Address.of("Rua Exemplo", "Cidade Exemplo", "Estado Exemplo", "12345-678", "Brasil");
        Client client = Client.of("uuid-1234", "Nome Exemplo", "12345678900", "email@example.com", "123456789", address);
        ClientDTO clientDTO = new ClientDTO(
                "João Silva",
                "joao.silva@example.com",
                "+55 11 98765-4321",
                "12345678900",
                "Rua das Flores, 123",
                "São Paulo",
                "SP",
                "Brasil",
                "01234-567");

        // Configure o clientDTO conforme necessário
        when(clientUC.save(any(Client.class))).thenReturn(client);

        // Executando o método a ser testado
        ClientResponseIdDTO responseIdDTO = clientService.save(clientDTO);

        // Verificando o resultado
        assertNotNull(responseIdDTO);
        assertEquals(client.getUuid(), responseIdDTO.idClient());

        // Verificando se o método save foi chamado uma vez com o cliente correto
        verify(clientUC, times(1)).save(any(Client.class));
    }

    @Test
    public void testFindClientByCpf() {
        // Configurando o comportamento do mock
        Address address = Address.of("Rua Exemplo", "Cidade Exemplo", "Estado Exemplo", "12345-678", "Brasil");
        Client client = Client.of("uuid-1234", "Nome Exemplo", "12345678900", "email@example.com", "123456789", address);
        ClientResponseDTO responseDTO = ClientResponseDTO.toDto(client);
        // Configure o responseDTO conforme necessário

        when(clientUC.findClientByCpf(anyString())).thenReturn(client);

        // Executando o método a ser testado
        ClientResponseDTO foundClient = clientService.findClientByCpf("12345678900");

        // Verificando o resultado
        assertNotNull(foundClient);
        assertEquals(responseDTO, foundClient);

        // Verificando se o método findClientByCpf foi chamado uma vez com o CPF correto
        verify(clientUC, times(1)).findClientByCpf("12345678900");
    }

}