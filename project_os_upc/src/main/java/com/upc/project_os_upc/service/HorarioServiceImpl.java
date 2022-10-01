package com.upc.project_os_upc.service;

import com.upc.project_os_upc.entity.Horario;
import com.upc.project_os_upc.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioServiceImpl implements HorarioService{
    @Autowired
    HorarioRepository repository;

    @Override
    public List<Horario> findAll() {
        return repository.findAll();
    }
}
