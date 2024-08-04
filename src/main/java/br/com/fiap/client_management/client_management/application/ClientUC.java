package br.com.fiap.client_management.client_management.application;

import br.com.fiap.client_management.client_management.domain.Client;
import br.com.fiap.client_management.client_management.gateway.ClientRepositoryGateway;
import org.springframework.stereotype.Service;

@Service
public class ClientUC {

    private final ClientRepositoryGateway clientRepositoryGateway;

    public ClientUC(ClientRepositoryGateway clientRepositoryGateway) {
        this.clientRepositoryGateway = clientRepositoryGateway;
    }

    public Client save(Client client){
        return clientRepositoryGateway.save(client);
    }

}
