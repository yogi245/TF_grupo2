package com.upc.project_os_upc.pruebas_funcionales;

import com.upc.project_os_upc.entity.Horario;
import com.upc.project_os_upc.service.HorarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootTest
class TestHorario {

    @Autowired
    private HorarioService service;

    @Test
    void contextLoads(ApplicationContext context) {
        Assertions.assertNotNull(context);
    }

    @Test
    void listarHorarios(){
        List<Horario> horarios = service.findAll();
        for(Horario horario:horarios){
            System.out.println(horario.getIdHorario() + " " + horario.getHora());
        }
        Assertions.assertNotNull(horarios);
    }
}
