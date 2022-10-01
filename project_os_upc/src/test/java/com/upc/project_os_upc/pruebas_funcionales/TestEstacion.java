package com.upc.project_os_upc.pruebas_funcionales;

import com.upc.project_os_upc.entity.Estacion;
import com.upc.project_os_upc.service.EstacionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootTest
class TestEstacion {

    @Autowired
    private EstacionService service;

    @Test
    void contextLoads(ApplicationContext context) {
        Assertions.assertNotNull(context);
    }

    @Test
    void listarEstaciones(){
        List<Estacion> estaciones = service.findAll();
        for(Estacion estacion:estaciones){
            System.out.println(estacion.getIdEstacion() + " " + estacion.getDescripcion());
        }
        Assertions.assertNotNull(estaciones);
    }
}
