package com.upc.project_os_upc.adapter;

import com.upc.project_os_upc.dto.ServicioDTO;
import com.upc.project_os_upc.entity.Servicio;
import org.springframework.stereotype.Component;

@Component
public class ServicioAdapter {
    public ServicioDTO toServicioDTO(Servicio servicio){
        ServicioDTO dto = new ServicioDTO();
        dto.setIdServicio(servicio.getIdServicio());
        dto.setDescripcion(servicio.getDescripcion());
        dto.setTarifa(servicio.getTipoServicio().getTarifa());
        return dto;
    }
}
