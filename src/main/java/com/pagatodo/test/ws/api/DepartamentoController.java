package com.pagatodo.test.ws.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagatodo.test.entity.Departamento;
import com.pagatodo.test.service.DepartamentoService;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

  @Autowired
  private DepartamentoService departamentoService;

  @GetMapping
  public List<Departamento> getAllDepartamentos() {
    return departamentoService.getAllDepartamentos();
  }

  @GetMapping("/{id}")
  public Departamento getDepartamentoById(@PathVariable Long id) {
    return departamentoService.getDepartamentoById(id);
  }

  @PostMapping
  public Departamento createDepartamento(@RequestBody Departamento departamento) {
    return departamentoService.createDepartamento(departamento);
  }

  @PutMapping("/{id}")
  public Departamento updateDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
    return departamentoService.updateDepartamento(id, departamento);
  }

  @DeleteMapping("/{id}")
  public void deleteDepartamento(@PathVariable Long id) {
    departamentoService.deleteDepartamento(id);
  }
}