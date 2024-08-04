package br.com.fiap.client_management.client_management.infra.service;

import br.com.fiap.client_management.client_management.application.ClientUC;
import br.com.fiap.client_management.client_management.domain.Client;
import br.com.fiap.client_management.client_management.infra.dto.ClientDTO;
import br.com.fiap.client_management.client_management.infra.dto.ClientResponseDTO;
import br.com.fiap.client_management.client_management.infra.dto.ClientResponseIdDTO;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientUC clientUC;

    public ClientService(ClientUC clientUC) {
        this.clientUC = clientUC;
    }

    public ClientResponseIdDTO save(ClientDTO requestDTO) {
        Client client = clientUC.save(ClientDTO.toClient(requestDTO));
        return new ClientResponseIdDTO(client.getUuid());
    }

    public ClientResponseDTO findClientByCpf(String cpf) {
        Client client = clientUC.findClientByCpf(cpf);
        return ClientResponseDTO.toDto(client);
    }
}
