package com.upc.project_os_upc.adapter;

import com.upc.project_os_upc.dto.NuevoUsuarioDTO;
import com.upc.project_os_upc.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class NuevoUsuarioAdapter {
    public Usuario toUsuarioEntity(NuevoUsuarioDTO dto){
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setFechaNacimiento(dto.getFechaNacimiento());
        usuario.setCorreo(dto.getCorreo());
        usuario.setContrasena(dto.getContrasena());
        usuario.setFechaRegistro(dto.getFechaRegistro());
        return usuario;
    }
}
