package com.upc.project_os_upc.repository;

import com.upc.project_os_upc.entity.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinoRepository extends JpaRepository<Destino,Long> {
}
