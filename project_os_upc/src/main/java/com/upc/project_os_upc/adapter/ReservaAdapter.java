package com.upc.project_os_upc.adapter;

import com.upc.project_os_upc.dto.ReservaDTO;
import com.upc.project_os_upc.entity.Programacion;
import com.upc.project_os_upc.entity.Reserva;
import com.upc.project_os_upc.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class ReservaAdapter {
    public ReservaDTO toReservaDTO(Reserva reserva){
        ReservaDTO dto = new ReservaDTO();
        dto.setIdReserva(reserva.getIdReserva());
        dto.setUsuario(reserva.getUsuario().getIdUsuario());
        dto.setIdProgramacion(reserva.getProgramacion().getIdProgramacion());
        dto.setEstacion(reserva.getProgramacion().getEstacion().getDescripcion());
        dto.setFechaHora(reserva.getFechaHora());
        dto.setCuentaBancaria(reserva.getCuentaBancaria());
        return dto;
    }

    public Reserva toReservaEntity(ReservaDTO dto){
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(dto.getUsuario());

        Programacion programacion = new Programacion();
        programacion.setIdProgramacion(dto.getIdProgramacion());

        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
        reserva.setProgramacion(programacion);
        reserva.setFechaHora(dto.getFechaHora());
        reserva.setCuentaBancaria(dto.getCuentaBancaria());
        return reserva;
    }
}
