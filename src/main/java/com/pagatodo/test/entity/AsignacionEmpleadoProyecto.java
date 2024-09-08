package com.pagatodo.test.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Asignacion_Empleado_Proyecto")
@Data
public class AsignacionEmpleadoProyecto {
  
  @EmbeddedId
  private AsignacionEmpleadoProyectoPK id;
  
  @ManyToOne
  @MapsId("idEmpleado")
  @JoinColumn(name = "id_empleado", nullable = false)
  private Empleado empleado;
  
  @ManyToOne
  @MapsId("idProyecto")
  @JoinColumn(name = "id_proyecto", nullable = false)
  private Proyecto proyecto;
  
  private String rol;
}