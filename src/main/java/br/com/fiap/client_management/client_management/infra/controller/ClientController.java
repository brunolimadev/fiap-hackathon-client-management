package br.com.fiap.client_management.client_management.infra.controller;

import br.com.fiap.client_management.client_management.infra.dto.ClientDTO;
import br.com.fiap.client_management.client_management.infra.dto.ClientResponseDTO;
import br.com.fiap.client_management.client_management.infra.dto.ClientResponseIdDTO;
import br.com.fiap.client_management.client_management.infra.dto.error.ErrorDto;
import br.com.fiap.client_management.client_management.infra.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@Tag(name = "Client Controller",
        description = "This service will be responsible for customer-related operations" +
                ", including creating, reading, customer records")

public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Operation(summary = "Register Client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida"),
            @ApiResponse(responseCode = "401", description = "Não autorizado",content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro de negócio", content = @Content)
    })
    @PostMapping
    public ResponseEntity<ClientResponseIdDTO> save(@RequestBody ClientDTO clientRequestDTO) {
        return ResponseEntity.status(200).body(clientService.save(clientRequestDTO));
    }

    @Operation(summary = "Search Client by CPF")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida"),
            @ApiResponse(responseCode = "401", description = "Não autorizado",content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro de negócio", content = @Content)
    })
    @GetMapping("/{cpf}")
    public ResponseEntity<ClientResponseDTO> getClientByCpf(@PathVariable String cpf) {
        return ResponseEntity.status(200).body(clientService.findClientByCpf(cpf));
    }

}
