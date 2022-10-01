package com.upc.project_os_upc.pruebas_funcionales;

import com.upc.project_os_upc.entity.Programacion;
import com.upc.project_os_upc.service.ProgramacionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootTest
class TestProgramacion {

    @Autowired
    private ProgramacionService service;

    @Test
    void contextLoads(ApplicationContext context) {
        Assertions.assertNotNull(context);
    }

    @Test
    void listarProgramaciones(){
        List<Programacion> programaciones = service.findAll();
        for(Programacion programacion:programaciones){
            System.out.println(programacion.getIdProgramacion() + " " + programacion.getEstacion().getDescripcion() + " " + programacion.getServicio().getDescripcion());
        }
        Assertions.assertNotNull(programaciones);
    }

    @Test
    void obtenerProgramacion(){
        Programacion programacion = service.findById(1L);
        System.out.println(programacion.toString());
        Assertions.assertNotNull(programacion);
    }
}
