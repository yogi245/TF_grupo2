package com.upc.project_os_upc.service;


import com.upc.project_os_upc.entity.Destino;
import com.upc.project_os_upc.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinoServiceImpl implements DestinoService{
    @Autowired
    DestinoRepository repository;

    @Override
    public List<Destino> findAll() {
        return repository.findAll();
    }
}
