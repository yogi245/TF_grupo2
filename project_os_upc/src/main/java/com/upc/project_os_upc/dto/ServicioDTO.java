package com.upc.project_os_upc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicioDTO {
    private Long idServicio;
    private String descripcion;
    private double tarifa;
}
