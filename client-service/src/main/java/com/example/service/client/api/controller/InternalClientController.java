package com.example.service.client.api.controller;

import com.example.service.client.api.dto.ClientDto;
import com.example.service.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/client")
@RequiredArgsConstructor
public class InternalClientController {

    private final ClientService clientService;

    @GetMapping("/{id}")
    public ClientDto getClientInfo(@PathVariable Long id) {
        return clientService.getClient(id);
    }
}
