-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS mi_base_de_datos;

-- Conectarse a la base de datos
CONNECT TO mi_base_de_datos;

-- Crear la tabla Departamento si no existe
CREATE TABLE IF NOT EXISTS Departamento (
  id_departamento INTEGER PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  descripcion VARCHAR(200)
);

-- Crear la tabla Empleado si no existe
CREATE TABLE IF NOT EXISTS Empleado (
  id_empleado INTEGER PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  apellidos VARCHAR(50) NOT NULL,
  id_departamento INTEGER NOT NULL,
  puesto VARCHAR(50),
  FOREIGN KEY (id_departamento) REFERENCES Departamento(id_departamento)
);

-- Crear la tabla Proyecto si no existe
CREATE TABLE IF NOT EXISTS Proyecto (
  id_proyecto INTEGER PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  descripcion VARCHAR(200),
  fecha_inicio DATE,
  fecha_fin DATE
);

-- Crear la tabla Asignacion_Empleado_Proyecto si no existe
CREATE TABLE IF NOT EXISTS Asignacion_Empleado_Proyecto (
  id_empleado INTEGER NOT NULL,
  id_proyecto INTEGER NOT NULL,
  rol VARCHAR(50),
  PRIMARY KEY (id_empleado, id_proyecto),
  FOREIGN KEY (id_empleado) REFERENCES Empleado(id_empleado),
  FOREIGN KEY (id_proyecto) REFERENCES Proyecto(id_proyecto)
);