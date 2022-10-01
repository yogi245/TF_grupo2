package com.upc.project_os_upc.service;

import com.upc.project_os_upc.entity.Reserva;

import java.util.List;

public interface ReservaService {
    public List<Reserva> findAll();
    public Reserva findById(Long id);
    public Reserva save(Reserva reserva);
    public void deleteById(Long id);
}
