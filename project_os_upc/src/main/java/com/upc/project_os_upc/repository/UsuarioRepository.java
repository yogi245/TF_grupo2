package com.upc.project_os_upc.repository;

import com.upc.project_os_upc.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    public Usuario findByCorreo(String correo);
}
