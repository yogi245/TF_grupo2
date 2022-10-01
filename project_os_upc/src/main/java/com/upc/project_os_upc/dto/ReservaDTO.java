package com.upc.project_os_upc.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReservaDTO {
    private Long idReserva;
    private Long usuario;
    private Long idProgramacion;
    private String estacion;
    private Date fechaHora;
    private String cuentaBancaria;
}
