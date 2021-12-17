package com.example.service.client.mapper;

import com.example.service.client.api.dto.ClientDto;
import com.example.service.client.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ClientMapper {

    ClientDto mapClientDto(Client client);

    @Mapping(target = "firstName", source = "clientDto.firstName")
    @Mapping(target = "lastName", source = "clientDto.lastName")
    Client mapClient(Long id, ClientDto clientDto);

    Client mapClient(ClientDto clientDto);
}
