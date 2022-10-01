package com.upc.project_os_upc.pruebas_unitarias;

import com.upc.project_os_upc.entity.Estacion;
import com.upc.project_os_upc.repository.EstacionRepository;
import com.upc.project_os_upc.service.EstacionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
class TestEstacion {
    @Autowired
    private EstacionService service;

    @MockBean
    private EstacionRepository repository;

    @Test
    void listarEstaciones(){

        when(repository.findAll()).thenReturn(
                Stream.of(
                        new Estacion(),
                        new Estacion()).collect(Collectors.toList())
        );
        Assertions.assertEquals(2,service.findAll().size());

    }
}
