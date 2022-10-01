package com.upc.project_os_upc.service;

import com.upc.project_os_upc.entity.Reserva;
import com.upc.project_os_upc.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService{
    @Autowired
    ReservaRepository repository;

    @Override
    public List<Reserva> findAll() {
        return repository.findAll();
    }

    @Override
    public Reserva findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Reserva save(Reserva reserva) {
        return repository.save(reserva);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
