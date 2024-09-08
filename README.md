# Ejemplo Spring Boot

## Generación de ambiente

### Windows/Linux

Spring boot provee una serie de wrappers para la configuración automática del ambiente y su ejecución.

Para apoyarse ejecutando comandos de maven y compilar, instalar dependencias, etc puede usar mvnw.cmd para Windows OS y mvnw como archivo batch en Linux

Por ejemplo

```
$ mvnw clean
$ mvnw install
```

Para iniciar la ejecución use:
```
$ mvnw spring-boot:run
```

### MAC (la configuración manual para Linux es parecida)

* [Brew install](https://mac.install.guide/homebrew/3)
* [Java install](https://docs.oracle.com/en/java/javase/17/install/installation-jdk-macos.html) : Version 17
* [Maven install](https://stackoverflow.com/questions/30461201/how-do-i-edit-path-bash-profile-on-os-x) : Version 3.x.x


Validamos que java este bien configurado:

```
$ java -version
openjdk version "17.0.12" 2024-07-16
OpenJDK Runtime Environment Homebrew (build 17.0.12+0)
OpenJDK 64-Bit Server VM Homebrew (build 17.0.12+0, mixed mode, sharing)
```

Validamos quue Maven este instalado

```
$ mvn -version
Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
Maven home: /Users/antonionunez/Documents/apache-maven-3.9.9
Java version: 17.0.12, vendor: Homebrew, runtime: /opt/homebrew/Cellar/openjdk@17/17.0.12/libexec/openjdk.jdk/Contents/Home
Default locale: es_MX, platform encoding: UTF-8
OS name: "mac os x", version: "14.6.1", arch: "aarch64", family: "mac"
```

Ejecutamos el proyecto con
```
$ mvn spring-boot:run 
```

![](/img/1.jpeg)

## Evidencias

### Postman

Para validar pruebas agrgue una colección de postman [Aqui](/postman/PagaTodo.postman_collection.json)

### Las imagenes de ejecuciones:

1. Asignaciones

- [POST](/postman/img/asignaciones/asi2.jpeg)
- [GET](/postman/img/asignaciones/asi1.jpeg)

2. Departamentos

- [POST](/postman/img/departamentos/dep1.jpeg)
- [PUT](/postman/img/departamentos/dep2.jpeg)
- [GET](/postman/img/departamentos/dep3.jpeg)

3. Empleados

- [POST](/postman/img/empleados/emp2.jpeg)
- [GET](/postman/img/empleados/emp1.jpeg)

4. Proyectos

- [POST](/postman/img/proyectos/pro1.jpeg)
- [GET](/postman/img/proyectos/pro2.jpeg)

5. Usuarios

- [Login](/postman/img/usuarios/login.jpeg)
- [Registro](/postman/img/usuarios/registro.jpeg)

