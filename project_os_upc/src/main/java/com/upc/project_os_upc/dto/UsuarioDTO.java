package com.upc.project_os_upc.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsuarioDTO {
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String correo;
}
