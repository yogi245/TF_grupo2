package com.upc.project_os_upc.pruebas_unitarias;

import com.upc.project_os_upc.entity.Horario;
import com.upc.project_os_upc.repository.HorarioRepository;
import com.upc.project_os_upc.service.HorarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
class TestHorario {
    @Autowired
    private HorarioService service;

    @MockBean
    private HorarioRepository repository;

    @Test
    void listarHorarios(){

        when(repository.findAll()).thenReturn(
                Stream.of(
                        new Horario(),
                        new Horario()).collect(Collectors.toList())
        );
        Assertions.assertEquals(2,service.findAll().size());

    }
}
