package com.pagatodo.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.pagatodo.test.entity.Proyecto;
import com.pagatodo.test.repository.ProyectoRepository;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    public List<Proyecto> getAllProyectos() {
        return proyectoRepository.findAll();
    }

    public Proyecto getProyectoById(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    public Proyecto createProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public Proyecto updateProyecto(Long id, Proyecto proyecto) {
        Proyecto existingProyecto = getProyectoById(id);
        if (existingProyecto != null) {
            existingProyecto.setNombre(proyecto.getNombre());
            existingProyecto.setDescripcion(proyecto.getDescripcion());
            existingProyecto.setFechaInicio(proyecto.getFechaInicio());
            existingProyecto.setFechaFin(proyecto.getFechaFin());
            return proyectoRepository.save(existingProyecto);
        }
        return null;
    }

    public void deleteProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }
}