package com.upc.project_os_upc.adapter;

import com.upc.project_os_upc.dto.EstacionDTO;
import com.upc.project_os_upc.entity.Estacion;
import org.springframework.stereotype.Component;

@Component
public class EstacionAdapter {
    public EstacionDTO toEstacionDTO(Estacion estacion){
        EstacionDTO dto = new EstacionDTO();
        dto.setIdEstacion(estacion.getIdEstacion());
        dto.setDescripcion(estacion.getDescripcion());
        return dto;
    }
}
