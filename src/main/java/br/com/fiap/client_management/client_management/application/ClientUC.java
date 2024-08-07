package br.com.fiap.client_management.client_management.application;

import br.com.fiap.client_management.client_management.domain.Client;
import br.com.fiap.client_management.client_management.gateway.ClientRepositoryGateway;
import br.com.fiap.client_management.client_management.infra.controller.Exceptions.ClientAlreadyRegisteredException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ClientUC {

    private final ClientRepositoryGateway clientRepositoryGateway;

    public ClientUC(ClientRepositoryGateway clientRepositoryGateway) {
        this.clientRepositoryGateway = clientRepositoryGateway;
    }

    public Client save(Client client){
       try {
           return clientRepositoryGateway.save(client);
       } catch (DataIntegrityViolationException e) {
           throw new ClientAlreadyRegisteredException("Esse cliente já se encontra cadastrado no sistema!");
       }
    }

    public Client findClientByCpf(String cpf){
        return clientRepositoryGateway.findClientByCpf(cpf);
    }
}
