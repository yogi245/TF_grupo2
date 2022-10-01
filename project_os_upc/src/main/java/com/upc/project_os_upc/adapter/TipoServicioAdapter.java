package com.upc.project_os_upc.adapter;

import com.upc.project_os_upc.dto.TipoServicioDTO;
import com.upc.project_os_upc.entity.TipoServicio;
import org.springframework.stereotype.Component;

@Component
public class TipoServicioAdapter {
    public TipoServicioDTO toTipoServicioDTO(TipoServicio tipoServicio){
        TipoServicioDTO dto = new TipoServicioDTO();
        dto.setIdTipoServicio(tipoServicio.getIdTipoServicio());
        dto.setDescripcion(tipoServicio.getDescripcion());
        dto.setTarifa(tipoServicio.getTarifa());
        return dto;
    }
}
