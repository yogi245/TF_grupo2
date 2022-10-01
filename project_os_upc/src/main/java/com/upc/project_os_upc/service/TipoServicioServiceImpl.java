package com.upc.project_os_upc.service;

import com.upc.project_os_upc.entity.TipoServicio;
import com.upc.project_os_upc.repository.TipoServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoServicioServiceImpl implements TipoServicioService{
    @Autowired
    TipoServicioRepository repository;

    @Override
    public List<TipoServicio> findAll() {
        return repository.findAll();
    }
}
