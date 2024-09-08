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
import java.util.List;

import com.pagatodo.test.entity.Empleado;
import com.pagatodo.test.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> getAllEmpleados() {
        return empleadoService.getAllEmpleados();
    }

    @GetMapping("/{id}")
    public Empleado getEmpleadoById(@PathVariable Long id) {
        return empleadoService.getEmpleadoById(id);
    }

    @PostMapping
    public Empleado createEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.createEmpleado(empleado);
    }

    @PutMapping("/{id}")
    public Empleado updateEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        return empleadoService.updateEmpleado(id, empleado);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable Long id) {
        empleadoService.deleteEmpleado(id);
    }
}
