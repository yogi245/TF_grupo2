package com.upc.project_os_upc.pruebas_unitarias;

import com.upc.project_os_upc.entity.Destino;
import com.upc.project_os_upc.repository.DestinoRepository;
import com.upc.project_os_upc.service.DestinoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
class TestDestino {

    @Autowired
    private DestinoService service;

    @MockBean
    private DestinoRepository repository;

    @Test
    void listarDestinos(){

       when(repository.findAll()).thenReturn(
               Stream.of(
                       new Destino(),
                       new Destino()).collect(Collectors.toList())
               );
        Assertions.assertEquals(2,service.findAll().size());

    }
}
