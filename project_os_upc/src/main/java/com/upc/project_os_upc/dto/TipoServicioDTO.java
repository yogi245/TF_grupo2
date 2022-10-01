package com.upc.project_os_upc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoServicioDTO {
    private Long idTipoServicio;
    private String descripcion;
    private double tarifa;
}
