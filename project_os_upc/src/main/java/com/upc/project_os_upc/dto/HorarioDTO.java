package com.upc.project_os_upc.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class HorarioDTO {
    private Long idHorario;
    private Time hora;
}
