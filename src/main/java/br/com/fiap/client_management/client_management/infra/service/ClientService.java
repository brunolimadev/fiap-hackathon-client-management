package br.com.fiap.client_management.client_management.infra.service;

import br.com.fiap.client_management.client_management.application.ClientUC;
import br.com.fiap.client_management.client_management.domain.Client;
import br.com.fiap.client_management.client_management.infra.dto.ClientRequestDTO;
import br.com.fiap.client_management.client_management.infra.dto.ClientResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientUC clientUC;

    public ClientService(ClientUC clientUC) {
        this.clientUC = clientUC;
    }

    public ClientResponseDTO save(ClientRequestDTO requestDTO) {
        Client client = clientUC.save(ClientRequestDTO.toClient(requestDTO));
        return new ClientResponseDTO(client.getUuid());
    }
}
