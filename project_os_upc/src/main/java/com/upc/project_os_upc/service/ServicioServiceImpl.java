package com.upc.project_os_upc.service;

import com.upc.project_os_upc.entity.Servicio;
import com.upc.project_os_upc.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService{
    @Autowired
    ServicioRepository repository;

    @Override
    public List<Servicio> findAll() {
        return repository.findAll();
    }
}
