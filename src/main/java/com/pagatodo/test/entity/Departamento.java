package com.pagatodo.test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Departamento")
@Data
public class Departamento {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idDepartamento;
  
  @Column(nullable = false)
  private String nombre;
  
  private String descripcion;
}