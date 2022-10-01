package com.upc.project_os_upc.service;

import com.upc.project_os_upc.entity.Usuario;

public interface UsuarioService {
    public Usuario findById(Long id);
    public Usuario findByCorreo(String correo);
    public Usuario save(Usuario usuario);
}
