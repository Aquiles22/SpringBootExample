package com.pagatodo.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.pagatodo.test.entity.Empleado;
import com.pagatodo.test.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado getEmpleadoById(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    public Empleado createEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado updateEmpleado(Long id, Empleado empleado) {
        Empleado existingEmpleado = getEmpleadoById(id);
        if (existingEmpleado != null) {
            existingEmpleado.setNombre(empleado.getNombre());
            existingEmpleado.setApellidos(empleado.getApellidos());
            existingEmpleado.setDepartamento(empleado.getDepartamento());
            existingEmpleado.setPuesto(empleado.getPuesto());
            return empleadoRepository.save(existingEmpleado);
        }
        return null;
    }

    public void deleteEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}