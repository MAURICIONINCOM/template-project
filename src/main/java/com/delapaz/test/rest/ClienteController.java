package com.delapaz.test.rest;


import com.delapaz.test.domain.Cliente;
import com.delapaz.test.exception.EntityNotFoundException;
import com.delapaz.test.service.ClienteService;
import com.delapaz.test.service.dto.ClienteRequestDto;
import com.delapaz.test.service.dto.ClienteResponseDto;
import com.delapaz.test.shared.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/add")
    public JsonResult addCliente(@RequestBody ClienteRequestDto request) throws EntityNotFoundException {
        ClienteResponseDto response = clienteService.addCliente(request);
        return new JsonResult(true, response, "Proveedor registrado correctamente");
    }

    @DeleteMapping("/delete/{id}")
    public JsonResult deleteCliente(@PathVariable("id") Integer id) throws EntityNotFoundException {
        String response = clienteService.deleteCliente(id);
        return new JsonResult(true, response, "Proveedor eliminado correctamente");
    }

    @PutMapping("/update/{id}")
    public JsonResult updateCliente(@PathVariable("id") Integer id,
                                    @RequestBody ClienteRequestDto request) throws EntityNotFoundException {
        ClienteResponseDto response = clienteService.updateCliente(id, request);
        return new JsonResult(true, response, "Proveedor actualizado correctamente");
    }

    @GetMapping("/get/{id}")
    public JsonResult getCliente(@PathVariable("id") Integer id) throws EntityNotFoundException {
        ClienteResponseDto response = clienteService.getCliente(id);
        return new JsonResult(true, response, "Proveedor obtenido correctamente");
    }

    @GetMapping("/list")
    public JsonResult getListCliente() throws EntityNotFoundException {
        List<ClienteResponseDto> response = clienteService.getListCliente();
        return new JsonResult(true, response, "Listado de proveedores");
    }

}
