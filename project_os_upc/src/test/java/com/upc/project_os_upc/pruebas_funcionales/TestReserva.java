package com.upc.project_os_upc.pruebas_funcionales;

import com.upc.project_os_upc.entity.Destino;
import com.upc.project_os_upc.entity.Programacion;
import com.upc.project_os_upc.entity.Reserva;
import com.upc.project_os_upc.entity.Usuario;
import com.upc.project_os_upc.service.DestinoService;
import com.upc.project_os_upc.service.ReservaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.List;

@SpringBootTest
class TestReserva {

    @Autowired
    private ReservaService service;

    @Test
    void contextLoads(ApplicationContext context) {
        Assertions.assertNotNull(context);
    }

    @Test
    void listarReservas(){
        List<Reserva> reservas = service.findAll();
        for(Reserva reserva:reservas){
            System.out.println(reserva.getIdReserva() + " " + reserva.getFechaHora());
        }
        Assertions.assertNotNull(reservas);
    }

    @Test
    void obtenerReserva(){
        Reserva reserva = service.findById(1L);
        System.out.println(reserva.getIdReserva() + " " + reserva.getFechaHora());
        Assertions.assertNotNull(reserva);
    }
    @Test
    void crearReserva(){
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1L);
        Programacion programacion = new Programacion();
        programacion.setIdProgramacion(3L);
        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
        reserva.setProgramacion(programacion);
        reserva.setFechaHora(new Date());
        reserva.setCuentaBancaria("98127435");
        Reserva nuevaReserva = service.save(reserva);
        Assertions.assertNotNull(nuevaReserva);
    }

    @Test
    void eliminarReserva(){
        service.deleteById(10L);
        Assertions.assertNull(service.findById(10L));
    }

}
