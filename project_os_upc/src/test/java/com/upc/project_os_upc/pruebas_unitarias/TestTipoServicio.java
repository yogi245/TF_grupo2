package com.upc.project_os_upc.pruebas_unitarias;

import com.upc.project_os_upc.entity.TipoServicio;
import com.upc.project_os_upc.repository.TipoServicioRepository;
import com.upc.project_os_upc.service.TipoServicioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
class TestTipoServicio {
    @Autowired
    private TipoServicioService service;

    @MockBean
    private TipoServicioRepository repository;

    @Test
    void listarServicios(){

        when(repository.findAll()).thenReturn(
                Stream.of(
                        new TipoServicio(),
                        new TipoServicio()).collect(Collectors.toList())
        );
        Assertions.assertEquals(2,service.findAll().size());

    }

}
