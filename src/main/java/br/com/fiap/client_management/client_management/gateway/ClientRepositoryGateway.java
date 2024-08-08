package br.com.fiap.client_management.client_management.gateway;

import br.com.fiap.client_management.client_management.domain.Client;

public interface ClientRepositoryGateway {

    Client save(Client client);

    Client findClientByCpf(String cpf);
}
