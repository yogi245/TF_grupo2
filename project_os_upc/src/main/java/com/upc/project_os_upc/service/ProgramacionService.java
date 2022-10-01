package com.upc.project_os_upc.service;

import com.upc.project_os_upc.entity.Programacion;

import java.util.List;

public interface ProgramacionService {
    public List<Programacion> findAll();
    public Programacion findById(Long id);

}
