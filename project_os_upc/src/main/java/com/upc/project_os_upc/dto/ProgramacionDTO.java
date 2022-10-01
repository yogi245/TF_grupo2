package com.upc.project_os_upc.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class ProgramacionDTO {
    private Long idProgramacion;
    private String estacion;
    private String servicio;
    private Time horario;
    private String destino;
    private double tarifa;
}
