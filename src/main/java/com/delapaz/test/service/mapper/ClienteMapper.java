package com.delapaz.test.service.mapper;


import com.delapaz.test.domain.Cliente;
import com.delapaz.test.service.dto.ClienteRequestDto;
import com.delapaz.test.service.dto.ClienteResponseDto;

public class ClienteMapper extends AbstractMapper<ClienteRequestDto, ClienteResponseDto, Cliente>  {

    @Override
    public Cliente toEntity(ClienteRequestDto request) {
        return null;
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public ClienteResponseDto toDto(Cliente proveedor) {
        return new ClienteResponseDto (
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getDireccion(),
                proveedor.getTelefono()
        );
    }
}
