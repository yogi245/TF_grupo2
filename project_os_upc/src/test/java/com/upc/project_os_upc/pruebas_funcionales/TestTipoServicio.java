package com.upc.project_os_upc.pruebas_funcionales;

import com.upc.project_os_upc.entity.TipoServicio;
import com.upc.project_os_upc.service.TipoServicioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootTest
class TestTipoServicio {

    @Autowired
    private TipoServicioService service;

    @Test
    void contextLoads(ApplicationContext context) {
        Assertions.assertNotNull(context);
    }

    @Test
    void listarTipoServicios(){
        List<TipoServicio> tipoServicios = service.findAll();
        for(TipoServicio tipoServicio:tipoServicios){
            System.out.println(tipoServicio.getIdTipoServicio() + " " + tipoServicio.getDescripcion());
        }
        Assertions.assertNotNull(tipoServicios);
    }
}
