package com.upc.project_os_upc.pruebas_unitarias;

import com.upc.project_os_upc.entity.Usuario;
import com.upc.project_os_upc.repository.UsuarioRepository;
import com.upc.project_os_upc.service.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class TestUsuario {

    @Autowired
    private UsuarioService service;

    @MockBean
    private UsuarioRepository repository;

    @Test
    void obtenerUsuario(){
        when(repository.findById(1L)).thenReturn(
                Optional.of(new Usuario(1L, "User", "Prueba", new Date(), "u.prueba@gmail.com", "123456", new Date(), null))
        );
        Assertions.assertEquals("User",service.findById(1L).getNombre());
    }

    @Test
    void obtenerUsuarioCorreo(){
        when(repository.findByCorreo("p.guerrero@gmail.com")).thenReturn(
                new Usuario(1L, "User", "Prueba", new Date(), "p.guerrero@gmail.com", "123456", new Date(), null)
        );
        Assertions.assertEquals("User",service.findByCorreo("p.guerrero@gmail.com").getNombre());
    }

    @Test
    void crearUsuario(){
        Usuario usuario = new Usuario(1L, "User", "Prueba", new Date(), "u.prueba@gmail.com", "123456", new Date(), null);
        when(repository.save(usuario)).thenReturn(usuario);
        Assertions.assertEquals("User",service.save(usuario).getNombre());
    }
}
