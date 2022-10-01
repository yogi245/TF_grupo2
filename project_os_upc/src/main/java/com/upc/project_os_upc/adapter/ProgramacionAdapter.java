package com.upc.project_os_upc.adapter;

import com.upc.project_os_upc.dto.ProgramacionDTO;
import com.upc.project_os_upc.entity.Programacion;
import org.springframework.stereotype.Component;

@Component
public class ProgramacionAdapter {
    public ProgramacionDTO toProgramacionDTO(Programacion programacion){
        ProgramacionDTO dto = new ProgramacionDTO();
        dto.setIdProgramacion(programacion.getIdProgramacion());
        dto.setEstacion(programacion.getEstacion().getDescripcion());
        dto.setServicio(programacion.getServicio().getDescripcion());
        dto.setHorario(programacion.getHorario().getHora());
        dto.setDestino(programacion.getDestino().getDescripcion());
        dto.setTarifa(programacion.getServicio().getTipoServicio().getTarifa());
        return dto;
    }
}
