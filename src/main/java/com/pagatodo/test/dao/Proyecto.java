package com.pagatodo.test.dao;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import lombok.Data;

@Entity
@Table(name = "Proyecto")
@Data
public class Proyecto {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idProyecto;
  
  @Column(nullable = false)
  private String nombre;
  
  private String descripcion;
  
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  private Date fechaInicio;
  
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  private Date fechaFin;
}