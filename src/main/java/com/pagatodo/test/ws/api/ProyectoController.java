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

import com.pagatodo.test.entity.Proyecto;
import com.pagatodo.test.service.ProyectoService;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    public List<Proyecto> getAllProyectos() {
        return proyectoService.getAllProyectos();
    }

    @GetMapping("/{id}")
    public Proyecto getProyectoById(@PathVariable Long id) {
        return proyectoService.getProyectoById(id);
    }

    @PostMapping
    public Proyecto createProyecto(@RequestBody Proyecto proyecto) {
        return proyectoService.createProyecto(proyecto);
    }

    @PutMapping("/{id}")
    public Proyecto updateProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        return proyectoService.updateProyecto(id, proyecto);
    }

    @DeleteMapping("/{id}")
    public void deleteProyecto(@PathVariable Long id) {
        proyectoService.deleteProyecto(id);
    }
}