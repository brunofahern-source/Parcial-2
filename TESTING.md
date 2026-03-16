# TESTING - Análisis de caja negra para `Empleado`

## 1. Tabla de atributos y criterios de aceptación

| Atributo | Tipo | Criterio de aceptación | Observaciones |
|---|---|---|---|
| `nombre` | String | No vacío, al menos 2 palabras (separado por espacio) | No acepta solo espacios. |
| `cargo` | String | Debe ser uno de los valores de `Cargos` (`Desarrollador`, `Diseñadora`, `Gerente`) | Se valida con `Cargos.esCargoValido`. |
| `salario` | double | No nulo/definido, >= salario convenio (ej. 1200), y >= 0 | Salario convenio asumido 1200 para el análisis. |

## 2. Tabla de casos válidos

| Caso | nombre | cargo | salario | Resultado esperado | Comentarios |
|---|---|---|---|---|---|
| V1 | "Juan Pérez" | `Cargos.DESARROLLADOR` | 3000 | Creación OK | nombre 2 palabras, cargo válido, salario > convenio |
| V2 | "María López" | `Cargos.DISENADORA` | 1200 | Creación OK | salario exacto convenio |
| V3 | "Ana María" | `Cargos.GERENTE` | 1500 | Creación OK | nombre con más de una palabra y cargo válido |

## 3. Tabla de casos no válidos

| Caso | nombre | cargo | salario | Resultado esperado | Motivo de fallo |
|---|---|---|---|---|---|
| N1 | "" | `Cargos.DESARROLLADOR` | 3000 | Rechazo | nombre vacío |
| N2 | "Unapalabra" | `Cargos.DESARROLLADOR` | 3000 | Rechazo | nombre no tiene 2 palabras |
| N3 | "  " | `Cargos.GERENTE` | 3000 | Rechazo | nombre solo espacios |
| N4 | "Juan Pérez" | "Administrador" | 3000 | Rechazo | cargo no pertenece a `Cargos` (no válido) |
| N5 | "Juan Pérez" | "" | 3000 | Rechazo | cargo vacío (no válido) |
| N6 | "Juan Pérez" | `Cargos.DESARROLLADOR` | -500 | Rechazo | salario negativo |
| N7 | "Juan Pérez" | `Cargos.DESARROLLADOR` | 0 | Rechazo | salario por debajo de convenio (asumido 1200) |
| N8 | "Juan Pérez" | `Cargos.DESARROLLADOR` | 1000 | Rechazo | salario por debajo de convenio |
| N9 | "Juan Pérez" | `Cargos.DESARROLLADOR` | NaN | Rechazo | salario indefinido |

---

### Notas de implementación

- Se recomienda ajustar el constructor de `Empleado` y `setCargo` / `setSalario` para implementar estos criterios de aceptación de forma explícita.
- El convenio salarial puede parametrizarse mediante constante (e.g., `Constantes.SALARIO_CONVENIO`).
