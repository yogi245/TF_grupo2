package com.upc.project_os_upc.pruebas_funcionales;

import com.upc.project_os_upc.entity.Usuario;
import com.upc.project_os_upc.service.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootTest
class TestUsuario {

    @Autowired
    private UsuarioService service;

    @Test
    void contextLoads(ApplicationContext context) {
        Assertions.assertNotNull(context);
    }

    @Test
    void obtenerUsuario(){
        Usuario usuario = service.findById(1L);
        System.out.println(usuario.getIdUsuario() + " " + usuario.getNombre() + " " + usuario.getCorreo());
        Assertions.assertNotNull(usuario);
    }

    @Test
    void obtenerUsuarioCorreo(){
        Usuario usuario = service.findByCorreo("p.guerrero@gmail.com");
        System.out.println(usuario.getIdUsuario() + " " + usuario.getNombre() + " " + usuario.getCorreo());
        Assertions.assertNotNull(usuario);
    }

    @Test
    void crearUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNombre("User");
        usuario.setApellido("Prueba");
        usuario.setCorreo("u.prueba@gmail.com");
        usuario.setContrasena("123456");
        usuario.setFechaNacimiento(new Date(100,9,8));
        usuario.setFechaRegistro(new Date());
        Usuario nuevoUsuario = service.save(usuario);
        Assertions.assertNotNull(nuevoUsuario);
    }


}
