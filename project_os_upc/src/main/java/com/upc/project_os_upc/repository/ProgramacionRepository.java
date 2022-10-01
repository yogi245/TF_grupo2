package com.upc.project_os_upc.repository;

import com.upc.project_os_upc.entity.Programacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramacionRepository extends JpaRepository<Programacion,Long> {
}
