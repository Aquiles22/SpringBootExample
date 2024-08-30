package com.pagatodo.test.dao;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class AsignacionEmpleadoProyectoPK implements Serializable {
  
  @Column(name = "id_empleado")
  private Long idEmpleado;
  
  @Column(name = "id_proyecto")
  private Long idProyecto;
}