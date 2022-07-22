package com.delapaz.test.service;

import com.delapaz.test.exception.EntityNotFoundException;
import com.delapaz.test.service.dto.ClienteRequestDto;
import com.delapaz.test.service.dto.ClienteResponseDto;

import java.util.List;

public interface ClienteService {
    ClienteResponseDto addCliente(ClienteRequestDto request) throws EntityNotFoundException;

    String deleteCliente(Integer id) throws EntityNotFoundException;

    ClienteResponseDto updateCliente(Integer id, ClienteRequestDto request) throws EntityNotFoundException;

    ClienteResponseDto getCliente(Integer id) throws EntityNotFoundException;

    List<ClienteResponseDto> getListCliente() throws EntityNotFoundException;
}
