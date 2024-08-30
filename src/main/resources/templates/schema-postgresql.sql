-- Crear la tabla Departamento si no existe
CREATE TABLE IF NOT EXISTS Departamento (
  id_departamento SERIAL PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  descripcion TEXT
);

-- Crear la tabla Empleado si no existe
CREATE TABLE IF NOT EXISTS Empleado (
  id_empleado SERIAL PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  apellidos VARCHAR(50) NOT NULL,
  id_departamento INTEGER NOT NULL,
  puesto VARCHAR(50),
  CONSTRAINT fk_departamento FOREIGN KEY (id_departamento) REFERENCES Departamento(id_departamento)
);

-- Crear la tabla Proyecto si no existe
CREATE TABLE IF NOT EXISTS Proyecto (
  id_proyecto SERIAL PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  descripcion TEXT,
  fecha_inicio Timestamp,
  fecha_fin Timestamp
);

-- Crear la tabla Asignación de Empleados a Proyectos si no existe
CREATE TABLE IF NOT EXISTS Asignacion_Empleado_Proyecto (
  id_empleado INTEGER NOT NULL,
  id_proyecto INTEGER NOT NULL,
  rol VARCHAR(50),
  PRIMARY KEY (id_empleado, id_proyecto),
  CONSTRAINT fk_empleado FOREIGN KEY (id_empleado) REFERENCES Empleado(id_empleado),
  CONSTRAINT fk_proyecto FOREIGN KEY (id_proyecto) REFERENCES Proyecto(id_proyecto)
);