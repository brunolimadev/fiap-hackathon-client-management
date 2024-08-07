package br.com.fiap.client_management.client_management.infra.persistence;

import br.com.fiap.client_management.client_management.domain.Client;
import br.com.fiap.client_management.client_management.gateway.ClientRepositoryGateway;
import br.com.fiap.client_management.client_management.infra.controller.Exceptions.ClientAlreadyRegisteredException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryGatewayImpl implements ClientRepositoryGateway {

    private final ClientRepository clientRepository;

    public ClientRepositoryGatewayImpl(ClientRepository usuarioRepository) {
        this.clientRepository = usuarioRepository;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public Client save(Client client) {

        ClientEntity clientEntity = null;
        try {
            clientEntity = Client.toClientEntity(client);
            return Client.toClient(clientRepository.save(clientEntity));
        } catch (DataIntegrityViolationException e) {
            throw new ClientAlreadyRegisteredException("Esse cliente já se encontra cadastrado no sistema!");
        }
    }

    @Override
    public Client findClientByCpf(String cpf) {
        return Client.toClient(clientRepository.findClientByCpf(cpf));
    }
}
