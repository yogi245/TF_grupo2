package com.upc.project_os_upc.service;

import com.upc.project_os_upc.entity.Usuario;
import com.upc.project_os_upc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository repository;
    @Override
    public Usuario findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Usuario findByCorreo(String correo) {
        return repository.findByCorreo(correo);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }
}
