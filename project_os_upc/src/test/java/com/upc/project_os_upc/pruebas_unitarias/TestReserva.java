package com.upc.project_os_upc.pruebas_unitarias;

import com.upc.project_os_upc.entity.Reserva;
import com.upc.project_os_upc.repository.ReservaRepository;
import com.upc.project_os_upc.service.ReservaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
class TestReserva {
    @Autowired
    private ReservaService service;

    @MockBean
    private ReservaRepository repository;

    @Test
    void listarReservas(){
        when(repository.findAll()).thenReturn(
                Stream.of(
                        new Reserva(),
                        new Reserva()).collect(Collectors.toList())
        );
        Assertions.assertEquals(2,service.findAll().size());
    }

    @Test
    void obtenerReserva(){
        when(repository.findById(1L)).thenReturn(
                Optional.of(new Reserva(1L,null,null,new Date(),"76767878" ))
        );
        Assertions.assertEquals("76767878",service.findById(1L).getCuentaBancaria());
    }

    @Test
    void crearReserva(){
        Reserva reserva = new Reserva(1L,null,null,new Date(),"76767878" );
        when(repository.save(reserva)).thenReturn(reserva);
        Assertions.assertEquals("76767878",service.save(reserva).getCuentaBancaria());
    }

}
