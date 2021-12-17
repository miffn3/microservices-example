package com.example.service.client.api.controller;

import com.example.service.client.api.dto.ClientDto;
import com.example.service.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/v3/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClientInfo(@PathVariable Long id) {
        return Optional.ofNullable(clientService.getClient(id))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build());
    }

    @PostMapping
    public ResponseEntity<ClientDto> createClientAccount(@RequestBody ClientDto clientDto) {
        return Optional.ofNullable(clientService.createClient(clientDto))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> updateClientInfo(@PathVariable Long id, @RequestBody @Valid ClientDto clientDto) {
        return Optional.ofNullable(clientService.updateClientInfo(id, clientDto))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build());
    }
}
