package com.upc.project_os_upc.service;

import com.upc.project_os_upc.entity.Programacion;
import com.upc.project_os_upc.repository.ProgramacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramacionServiceImpl implements ProgramacionService{

    @Autowired
    private ProgramacionRepository repository;

    @Override
    public List<Programacion> findAll() {
        return repository.findAll();
    }

    @Override
    public Programacion findById(Long id) {
        return repository.findById(id).orElse(null);
    }

}
