package com.upc.project_os_upc.pruebas_unitarias;

import com.upc.project_os_upc.entity.Programacion;
import com.upc.project_os_upc.repository.ProgramacionRepository;
import com.upc.project_os_upc.service.ProgramacionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
class TestProgramacion {
    @Autowired
    private ProgramacionService service;

    @MockBean
    private ProgramacionRepository repository;

    @Test
    void listarProgramaciones(){
        when(repository.findAll()).thenReturn(
                Stream.of(
                        new Programacion(),
                        new Programacion()).collect(Collectors.toList())
        );
        Assertions.assertEquals(2,service.findAll().size());
    }

    @Test
    void obtenerProgramacion(){
        when(repository.findById(1L)).thenReturn(
                Optional.of(new Programacion(1L,null,null,null,null,true))
        );
        Assertions.assertEquals(true,service.findById(1L).getActiva());
    }

}
