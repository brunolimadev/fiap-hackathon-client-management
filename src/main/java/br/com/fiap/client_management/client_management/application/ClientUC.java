package br.com.fiap.client_management.client_management.application;

import br.com.fiap.client_management.client_management.domain.Client;
import br.com.fiap.client_management.client_management.gateway.ClientRepositoryGateway;
import br.com.fiap.client_management.client_management.infra.controller.Exceptions.ClientAlreadyRegisteredException;

import org.hibernate.NonUniqueResultException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ClientUC {

    private final ClientRepositoryGateway clientRepositoryGateway;

    public ClientUC(ClientRepositoryGateway clientRepositoryGateway) {
        this.clientRepositoryGateway = clientRepositoryGateway;
    }

    public Client save(Client client) {

        try {
            var userFounded = clientRepositoryGateway.findClientByCpf(client.getCpf());

            if (userFounded != null) {
                throw new ClientAlreadyRegisteredException("Esse cliente já se encontra cadastrado no sistema!");
            }

            return clientRepositoryGateway.save(client);
        } catch (Exception e) {
            throw new ClientAlreadyRegisteredException("Erro ao cadastrar cliente!");
        }
    }

    public Client findClientByCpf(String cpf) {
        return clientRepositoryGateway.findClientByCpf(cpf);
    }
}
