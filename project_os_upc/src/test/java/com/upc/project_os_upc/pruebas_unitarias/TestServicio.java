package com.upc.project_os_upc.pruebas_unitarias;

import com.upc.project_os_upc.entity.Servicio;
import com.upc.project_os_upc.repository.ServicioRepository;
import com.upc.project_os_upc.service.ServicioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
class TestServicio {

    @Autowired
    private ServicioService service;

    @MockBean
    private ServicioRepository repository;

    @Test
    void listarServicios(){

        when(repository.findAll()).thenReturn(
                Stream.of(
                        new Servicio(),
                        new Servicio()).collect(Collectors.toList())
        );
        Assertions.assertEquals(2,service.findAll().size());

    }
}
