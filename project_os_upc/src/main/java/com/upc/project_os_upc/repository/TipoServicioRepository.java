package com.upc.project_os_upc.repository;

import com.upc.project_os_upc.entity.TipoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoServicioRepository extends JpaRepository<TipoServicio,Long> {
}
