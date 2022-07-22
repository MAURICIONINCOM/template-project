package com.delapaz.test.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDto {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
}
