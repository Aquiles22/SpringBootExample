package com.pagatodo.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pagatodo.test.entity.AsignacionEmpleadoProyecto;
import com.pagatodo.test.entity.AsignacionEmpleadoProyectoPK;

@Repository
public interface AsignacionEmpleadoProyectoRepository
        extends JpaRepository<AsignacionEmpleadoProyecto, AsignacionEmpleadoProyectoPK> {
}