package br.com.fiap.client_management.client_management.infra.controller;

import br.com.fiap.client_management.client_management.infra.dto.ClientDTO;
import br.com.fiap.client_management.client_management.infra.dto.ClientResponseDTO;
import br.com.fiap.client_management.client_management.infra.dto.ClientResponseIdDTO;
import br.com.fiap.client_management.client_management.infra.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ClientControllerTest {

    @Mock
    private ClientService clientService;

    @InjectMocks
    private ClientController clientController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }

    @Test
    public void testSaveClient() throws Exception {
        ClientDTO clientDTO = new ClientDTO(
                "Nome Exemplo","email@email.com","123456789",
                "320322","Rua a ","Rio de Janeiro","Rio de Janeiro","Brasil","22525425");
        // Configure o clientDTO conforme necessário

        ClientResponseIdDTO clientResponseIdDTO = new ClientResponseIdDTO("a9ffedcd-f97d-4ba4-afd4-c3ef6e7591fb");
        // Configure o clientResponseIdDTO conforme necessário

        when(clientService.save(any(ClientDTO.class))).thenReturn(clientResponseIdDTO);

        mockMvc.perform(post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"Nome Exemplo\", \"cpf\": \"12345678900\", \"email\": \"email@example.com\", \"telephone\": \"123456789\", \"address\": { \"street\": \"Rua Exemplo\", \"city\": \"Cidade Exemplo\", \"province\": \"Estado Exemplo\", \"zipCode\": \"12345-678\", \"country\": \"Brasil\" } }"))
                .andExpect(status().isOk());

        verify(clientService, times(1)).save(any(ClientDTO.class));
    }

    @Test
    public void testGetClientByCpf() throws Exception {
        String cpf = "12345678900";
        ClientResponseDTO clientResponseDTO = new ClientResponseDTO(
                "Nome Exemplo","email@email.com","123456789",
                "320322","Rua a ","Rio de Janeiro","Rio de Janeiro","Brasil","22525425");
        // Configure o clientResponseDTO conforme necessário

        when(clientService.findClientByCpf(cpf)).thenReturn(clientResponseDTO);

        mockMvc.perform(get("/cliente/{cpf}", cpf)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(clientService, times(1)).findClientByCpf(cpf);
    }

}