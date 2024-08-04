package br.com.fiap.client_management.client_management.infra.controller;

import br.com.fiap.client_management.client_management.infra.dto.ClientDTO;
import br.com.fiap.client_management.client_management.infra.dto.ClientResponseDTO;
import br.com.fiap.client_management.client_management.infra.dto.ClientResponseIdDTO;
import br.com.fiap.client_management.client_management.infra.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientResponseIdDTO> save(@RequestBody ClientDTO clientRequestDTO) {
        return ResponseEntity.status(200).body(clientService.save(clientRequestDTO));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClientResponseDTO> getClientByCpf(@PathVariable String cpf) {
        return ResponseEntity.status(200).body(clientService.findClientByCpf(cpf));
    }

}
