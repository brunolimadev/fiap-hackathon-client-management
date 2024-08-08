package br.com.fiap.client_management.client_management.infra.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, String> {

    @Query("SELECT c FROM ClientEntity c WHERE c.cpf = :cpf")
    ClientEntity findClientByCpf(@Param("cpf") String cpf);
}
