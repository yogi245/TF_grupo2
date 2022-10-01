package com.upc.project_os_upc.pruebas_funcionales;

import com.upc.project_os_upc.entity.Destino;
import com.upc.project_os_upc.service.DestinoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootTest
class TestDestino {

    @Autowired
    private DestinoService service;

    @Test
    void contextLoads(ApplicationContext context) {
        Assertions.assertNotNull(context);
    }

    @Test
    void listarDestinos(){
        List<Destino> destinos = service.findAll();
        for(Destino destino:destinos){
            System.out.println(destino.getIdDestino() + " " + destino.getDescripcion());
        }
        Assertions.assertNotNull(destinos);
    }
}
