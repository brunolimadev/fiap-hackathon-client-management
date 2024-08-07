package br.com.fiap.client_management.client_management.infra.persistence;

import br.com.fiap.client_management.client_management.domain.Client;
import br.com.fiap.client_management.client_management.gateway.ClientRepositoryGateway;
import br.com.fiap.client_management.client_management.infra.controller.Exceptions.ClientNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class ClientRepositoryGatewayImpl implements ClientRepositoryGateway {

    private final ClientRepository clientRepository;

    public ClientRepositoryGatewayImpl(ClientRepository usuarioRepository) {
        this.clientRepository = usuarioRepository;
    }

    @Override
    public Client save(Client client) {

        ClientEntity clientEntity = Client.toClientEntity(client);
        return Client.toClient(clientRepository.save(clientEntity));
    }

    @Override
    public Client findClientByCpf(String cpf) {
        ClientEntity client = clientRepository.findClientByCpf(cpf);
        if(Objects.isNull(client)){
            throw new ClientNotFoundException("Cliente com o CPF informado não foi localizado!");
        }
        return Client.toClient(client);
    }
}
