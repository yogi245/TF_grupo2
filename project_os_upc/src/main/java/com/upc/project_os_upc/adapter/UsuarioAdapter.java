package com.upc.project_os_upc.adapter;

import com.upc.project_os_upc.dto.UsuarioDTO;
import com.upc.project_os_upc.dto.UsuarioReservasDTO;
import com.upc.project_os_upc.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UsuarioAdapter {
    @Autowired
    public ReservaAdapter adapterReserva;

    public UsuarioDTO toUsuarioDTO(Usuario usuario){
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setNombre(usuario.getNombre());
        dto.setApellido(usuario.getApellido());
        dto.setCorreo(usuario.getCorreo());
        dto.setFechaNacimiento(usuario.getFechaNacimiento());
        return dto;
    }

    public UsuarioReservasDTO toUsuarioReservasDTO(Usuario usuario){
        UsuarioReservasDTO dto = new UsuarioReservasDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setNombre(usuario.getNombre());
        dto.setApellido(usuario.getApellido());
        dto.setCorreo(usuario.getCorreo());
        dto.setFechaNacimiento(usuario.getFechaNacimiento());
        dto.setReservasUsuario(usuario.getReservasUsuario()
                .stream()
                .map(x->adapterReserva.toReservaDTO(x))
                .collect(Collectors.toList()));
        return dto;
    }
}
