package com.pagatodo.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pagatodo.test.dao.AsignacionEmpleadoProyecto;
import com.pagatodo.test.dao.AsignacionEmpleadoProyectoPK;

@Repository
public interface AsignacionEmpleadoProyectoRepository extends JpaRepository<AsignacionEmpleadoProyecto, AsignacionEmpleadoProyectoPK> {
}