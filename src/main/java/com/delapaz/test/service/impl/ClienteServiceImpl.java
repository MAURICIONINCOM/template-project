package com.delapaz.test.service.impl;

import com.delapaz.test.domain.Cliente;
import com.delapaz.test.exception.EntityNotFoundException;
import com.delapaz.test.repository.ClienteRepository;
import com.delapaz.test.service.ClienteService;
import com.delapaz.test.service.dto.ClienteRequestDto;
import com.delapaz.test.service.dto.ClienteResponseDto;
import com.delapaz.test.service.mapper.ClienteMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    private final ClienteMapper clienteMapper = new ClienteMapper();

    @Override
    public ClienteResponseDto addCliente(ClienteRequestDto request) throws EntityNotFoundException {
        Cliente cliente = new Cliente();
        cliente.setNombre(request.getNombre());
        cliente.setDireccion(request.getDireccion());
        cliente.setTelefono(request.getTelefono());
        clienteRepository.saveAndFlush(cliente);
        return clienteMapper.toDto(cliente);
    }

    @Override
    public String deleteCliente(Integer id) throws EntityNotFoundException {
        Cliente cliente = clienteRepository.getClienteById(id);
        if (cliente == null) {
            throw new EntityNotFoundException(String.format(
                    "No se encontro el proveedor con Id: %d", id
            ));
        }
        String response = cliente.getNombre() + " eliminado.";
        clienteRepository.delete(cliente);
        return response;
    }

    @Override
    public ClienteResponseDto updateCliente(Integer id, ClienteRequestDto request) throws EntityNotFoundException {
        Cliente cliente = clienteRepository.getClienteById(id);
        if (cliente == null) {
            throw new EntityNotFoundException(String.format(
                    "No se encontro el proveedor con Id: %d", id
            ));
        }
        
        cliente.setNombre(request.getNombre());
        cliente.setDireccion(request.getDireccion());
        cliente.setTelefono(request.getTelefono());
        clienteRepository.saveAndFlush(cliente);
        return clienteMapper.toDto(cliente);
    }

    @Override
    public ClienteResponseDto getCliente(Integer id) throws EntityNotFoundException {
        Cliente cliente = clienteRepository.getClienteById(id);
        if (cliente == null) {
            throw new EntityNotFoundException(String.format(
                    "No se encontro el proveedor con Id: %d", id
            ));
        }
        return clienteMapper.toDto(cliente);
    }

    @Override
    public List<ClienteResponseDto> getListCliente() throws EntityNotFoundException {
        List<Cliente> clientes = clienteRepository.findAll();
        if (clientes == null) {
            throw new EntityNotFoundException(String.format(
                    "No se encontro proveedores registrados."
            ));
        }
        return clienteMapper.toDto(clientes);
    }
}
