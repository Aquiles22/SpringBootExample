package com.pagatodo.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagatodo.test.dao.AsignacionEmpleadoProyecto;
import com.pagatodo.test.dao.AsignacionEmpleadoProyectoPK;
import com.pagatodo.test.repository.AsignacionEmpleadoProyectoRepository;

import java.util.List;

@Service
public class AsignacionEmpleadoProyectoService {

    @Autowired
    private AsignacionEmpleadoProyectoRepository asignacionEmpleadoProyectoRepository;

    public AsignacionEmpleadoProyecto crearAsignacion(AsignacionEmpleadoProyecto asignacion) {
        return asignacionEmpleadoProyectoRepository.save(asignacion);
    }

    public List<AsignacionEmpleadoProyecto> obtenerAsignaciones() {
        return asignacionEmpleadoProyectoRepository.findAll();
    }

    public AsignacionEmpleadoProyecto obtenerAsignacionPorId(AsignacionEmpleadoProyectoPK id) {
        return asignacionEmpleadoProyectoRepository.findById(id).orElse(null);
    }

    public AsignacionEmpleadoProyecto actualizarAsignacion(AsignacionEmpleadoProyecto asignacion) {
        return asignacionEmpleadoProyectoRepository.save(asignacion);
    }

    public void eliminarAsignacion(AsignacionEmpleadoProyectoPK id) {
        asignacionEmpleadoProyectoRepository.deleteById(id);
    }

    /*public List<AsignacionEmpleadoProyecto> obtenerAsignacionesPorEmpleado(Long empleadoId) {
        return asignacionEmpleadoProyectoRepository.findByEmpleadoId(empleadoId);
    }

    public List<AsignacionEmpleadoProyecto> obtenerAsignacionesPorProyecto(Long proyectoId) {
        return asignacionEmpleadoProyectoRepository.findByProyectoId(proyectoId);
    }*/
}