package com.upc.project_os_upc.adapter;

import com.upc.project_os_upc.dto.HorarioDTO;
import com.upc.project_os_upc.entity.Horario;
import org.springframework.stereotype.Component;

@Component
public class HorarioAdapter {
    public HorarioDTO toHorarioDTO(Horario horario){
        HorarioDTO dto = new HorarioDTO();
        dto.setIdHorario(horario.getIdHorario());
        dto.setHora(horario.getHora());
        return dto;
    }
}
