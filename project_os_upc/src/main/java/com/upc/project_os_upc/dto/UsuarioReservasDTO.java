package com.upc.project_os_upc.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class UsuarioReservasDTO {
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String correo;
    private List<ReservaDTO> reservasUsuario;
}
