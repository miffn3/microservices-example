package com.example.service.client.service;

import com.example.service.client.api.dto.ClientDto;

public interface ClientService {

    ClientDto getClient(Long id);

    ClientDto updateClientInfo(Long id, ClientDto clientDto);

    ClientDto createClient(ClientDto clientDto);
}
