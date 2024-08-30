package com.pagatodo.test.ws.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagatodo.test.dao.AsignacionEmpleadoProyecto;
import com.pagatodo.test.dao.AsignacionEmpleadoProyectoPK;
import com.pagatodo.test.service.AsignacionEmpleadoProyectoService;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionEmpleadoProyectoController {

    @Autowired
    private AsignacionEmpleadoProyectoService asignacionEmpleadoProyectoService;

    @PostMapping
    public AsignacionEmpleadoProyecto crearAsignacion(@RequestBody AsignacionEmpleadoProyecto asignacion) {
        return asignacionEmpleadoProyectoService.crearAsignacion(asignacion);
    }

    @GetMapping
    public List<AsignacionEmpleadoProyecto> obtenerAsignaciones() {
        return asignacionEmpleadoProyectoService.obtenerAsignaciones();
    }

    @GetMapping("/{empleadoId}/{proyectoId}")
    public AsignacionEmpleadoProyecto obtenerAsignacionPorId(@PathVariable Long empleadoId, @PathVariable Long proyectoId) {
        AsignacionEmpleadoProyectoPK id = new AsignacionEmpleadoProyectoPK();
        id.setIdEmpleado(empleadoId);
        id.setIdProyecto(proyectoId);
        return asignacionEmpleadoProyectoService.obtenerAsignacionPorId(id);
    }

    @PutMapping
    public AsignacionEmpleadoProyecto actualizarAsignacion(@RequestBody AsignacionEmpleadoProyecto asignacion) {
        return asignacionEmpleadoProyectoService.actualizarAsignacion(asignacion);
    }

    @DeleteMapping("/{empleadoId}/{proyectoId}")
    public void eliminarAsignacion(@PathVariable Long empleadoId, @PathVariable Long proyectoId) {
        AsignacionEmpleadoProyectoPK id = new AsignacionEmpleadoProyectoPK();
        id.setIdEmpleado(empleadoId);
        id.setIdProyecto(proyectoId);
        asignacionEmpleadoProyectoService.eliminarAsignacion(id);
    }

    /*@GetMapping("/empleado/{empleadoId}")
    public List<AsignacionEmpleadoProyecto> obtenerAsignacionesPorEmpleado(@PathVariable Long empleadoId) {
        return asignacionEmpleadoProyectoService.obtenerAsignacionesPorEmpleado(empleadoId);
    }

    @GetMapping("/proyecto/{proyectoId}")
    public List<AsignacionEmpleadoProyecto> obtenerAsignacionesPorProyecto(@PathVariable Long proyectoId) {
        return asignacionEmpleadoProyectoService.obtenerAsignacionesPorProyecto(proyectoId);
    }*/
}