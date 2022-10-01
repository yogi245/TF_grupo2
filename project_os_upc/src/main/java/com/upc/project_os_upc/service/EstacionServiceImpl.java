package com.upc.project_os_upc.service;

import com.upc.project_os_upc.entity.Estacion;
import com.upc.project_os_upc.repository.EstacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstacionServiceImpl implements EstacionService{
    @Autowired
    EstacionRepository repository;

    @Override
    public List<Estacion> findAll() {
        return repository.findAll();
    }
}
