package com.upc.project_os_upc.adapter;

import com.upc.project_os_upc.dto.DestinoDTO;
import com.upc.project_os_upc.entity.Destino;
import org.springframework.stereotype.Component;

@Component
public class DestinoAdapter {

    public DestinoDTO toDestinoDTO(Destino destino){
        DestinoDTO dto = new DestinoDTO();
        dto.setIdDestino(destino.getIdDestino());
        dto.setDescripcion(destino.getDescripcion());
        return dto;
    }
}
