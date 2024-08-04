package br.com.fiap.client_management.client_management.gateway;

import br.com.fiap.client_management.client_management.domain.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepositoryGateway {

    List<Client> findAll();

    Client save(Client client);
}
