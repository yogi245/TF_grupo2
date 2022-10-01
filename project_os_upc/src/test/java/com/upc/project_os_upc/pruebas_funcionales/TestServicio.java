package com.upc.project_os_upc.pruebas_funcionales;

import com.upc.project_os_upc.entity.Servicio;
import com.upc.project_os_upc.service.ServicioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootTest
class TestServicio {

    @Autowired
    private ServicioService service;

    @Test
    void contextLoads(ApplicationContext context) {
        Assertions.assertNotNull(context);
    }

    @Test
    void listarDestinos(){
        List<Servicio> servicios = service.findAll();
        for(Servicio servicio:servicios){
            System.out.println(servicio.getIdServicio() + " " + servicio.getDescripcion());
        }
        Assertions.assertNotNull(servicios);
    }
}
