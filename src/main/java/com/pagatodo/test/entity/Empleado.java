package com.pagatodo.test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import lombok.Data;

@Entity
@Table(name = "Empleado")
@Data
public class Empleado {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idEmpleado;
  
  @Column(nullable = false)
  private String nombre;
  
  @Column(nullable = false)
  private String apellidos;
  
  @ManyToOne
  @JoinColumn(name = "id_departamento", nullable = false)
  private Departamento departamento;
  
  private String puesto;
}