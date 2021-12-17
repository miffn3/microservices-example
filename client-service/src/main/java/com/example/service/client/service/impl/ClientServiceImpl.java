package com.example.service.client.service.impl;

import com.example.service.client.api.dto.ClientDto;
import com.example.service.client.entity.Client;
import com.example.service.client.mapper.ClientMapper;
import com.example.service.client.repository.ClientRepository;
import com.example.service.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDto getClient(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::mapClientDto)
                .orElse(null);
    }

    @Override
    public ClientDto updateClientInfo(Long id, ClientDto clientDto) {
        Client client = clientMapper.mapClient(id, clientDto);
        return clientMapper.mapClientDto(clientRepository.save(client));
    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        Client client = clientMapper.mapClient(clientDto);
        return clientMapper.mapClientDto(clientRepository.save(client));
    }
}
