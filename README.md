# Sistema de Gestión de Empleados

## Descripción general

Este repositorio contiene una pequeña aplicación Java para gestionar empleados en un array fijo.

- `Empleado`: clase del modelo con nombre, cargo y salario.
- `Cargos`: lista estática de cargos válidos para evitar cadenas abiertas.
- `Constantes`: constantes de texto y valores reutilizables (UI, errores, convenio, capacidad).
- `Empleados`: clase de gestión que maneja el array central, altas, aumentos y listado.
- `SistemaGestionEmpleados`: clase principal que ejecuta la app con entrada por consola.

## Autores y versión

- Autor: [Nombre del Autor] (ajusta con tu nombre real)
- Fecha: 16 de marzo de 2026
- Versión: 1.0.0

## Funcionamiento

1. Se crea un objeto `Empleados` con capacidad fija.
2. Se dan de alta empleados con `darAltaEmpleado(...)`.
3. El usuario ingresa un porcentaje de aumento por teclado.
4. Se aplican los aumentos con `aumentarSalario(...)`.
5. Se muestra el listado de empleados con salarios actualizados.

## Requisitos de compilación

- JDK 17+ (probado con JDK 24)
- (opcional) JUnit 5 para pruebas con `EmpleadoTest`

### Compilar y ejecutar

```bash
javac *.java
java SistemaGestionEmpleados
```

## Pruebas (testing)

- Archivo de pruebas: `EmpleadoTest.java` (JUnit 5)
- Criterios incluidos:
  - `nombre`: no vacío, mínimo 2 palabras
  - `cargo`: válido según `Cargos`
  - `salario`: no NaN, no < `Constantes.SALARIO_CONVENIO`

Para ejecutar con JUnit en local (sin Maven/Gradle):

```bash
javac -cp .;path\a\junit-jupiter-api-5.10.0.jar;path\a\junit-jupiter-engine-5.10.0.jar;path\a\opentest4j-1.3.0.jar;path\a\apiguardian-api-1.1.3.jar *.java
java -jar path\a\junit-platform-console-standalone-1.10.0.jar --class-path . --scan-classpath
```

## Notas

- La clase `Empleado` valida y lanza `IllegalArgumentException` en construcción o en cambios invalidos.
- `Constantes` soporta internacionalización/ajustes de texto fácilmente.
- Cambios de lógica futuros pueden implementarse en `Empleados` sin tocar `SistemaGestionEmpleados`.
