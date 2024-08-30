package com.pagatodo.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagatodo.test.dao.Departamento;
import com.pagatodo.test.repository.DepartamentoRepository;


@Service
public class DepartamentoService {
  
  @Autowired
  private DepartamentoRepository departamentoRepository;
  
  public List<Departamento> getAllDepartamentos() {
    return departamentoRepository.findAll();
  }
  
  public Departamento getDepartamentoById(Long id) {
    return departamentoRepository.findById(id).orElse(null);
  }
  
  public Departamento createDepartamento(Departamento departamento) {
    return departamentoRepository.save(departamento);
  }
  
  public Departamento updateDepartamento(Long id, Departamento departamento) {
    Departamento existingDepartamento = getDepartamentoById(id);
    if (existingDepartamento != null) {
      existingDepartamento.setNombre(departamento.getNombre());
      existingDepartamento.setDescripcion(departamento.getDescripcion());
      return departamentoRepository.save(existingDepartamento);
    }
    return null;
  }
  
  public void deleteDepartamento(Long id) {
    departamentoRepository.deleteById(id);
  }
}
