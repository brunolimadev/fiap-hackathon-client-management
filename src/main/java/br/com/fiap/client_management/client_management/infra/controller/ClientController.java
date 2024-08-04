package br.com.fiap.client_management.client_management.infra.controller;

import br.com.fiap.client_management.client_management.infra.dto.ClientRequestDTO;
import br.com.fiap.client_management.client_management.infra.dto.ClientResponseDTO;
import br.com.fiap.client_management.client_management.infra.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {


    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> save(@RequestBody ClientRequestDTO clientRequestDTO) {
        return ResponseEntity.status(200).body(clientService.save(clientRequestDTO));
    }


}
