import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmpleadoTest {

    @Test
    void casoValidoV1_debeCrearEmpleadoCorrectamente() {
        assertDoesNotThrow(() -> {
            Empleado e = new Empleado("Juan Pérez", Cargos.DESARROLLADOR, 3000);
            assertEquals("Juan Pérez", e.getNombre());
            assertEquals(Cargos.DESARROLLADOR, e.getCargo());
            assertEquals(3000, e.getSalario());
        });
    }

    @Test
    void casoValidoV2_salarioConvenioValido() {
        assertDoesNotThrow(() -> new Empleado("María López", Cargos.DISENADORA, Constantes.SALARIO_CONVENIO));
    }

    @Test
    void casoValidoV3_nombreMasDeUnaPalabra() {
        assertDoesNotThrow(() -> new Empleado("Ana María", Cargos.GERENTE, 1500));
    }

    @Test
    void casoNoValidoN1_nombreVacio() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new Empleado("", Cargos.DESARROLLADOR, 3000));
        assertTrue(ex.getMessage().contains(Constantes.NOMBRE_NO_VALIDO));
    }

    @Test
    void casoNoValidoN2_nombreUnaPalabra() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new Empleado("Unapalabra", Cargos.DESARROLLADOR, 3000));
        assertTrue(ex.getMessage().contains(Constantes.NOMBRE_NO_VALIDO));
    }

    @Test
    void casoNoValidoN3_nombreSoloEspacios() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new Empleado("   ", Cargos.GERENTE, 3000));
        assertTrue(ex.getMessage().contains(Constantes.NOMBRE_NO_VALIDO));
    }

    @Test
    void casoNoValidoN4_cargoNoValido() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new Empleado("Juan Pérez", "Administrador", 3000));
        assertTrue(ex.getMessage().contains(Constantes.CARGO_NO_VALIDO));
    }

    @Test
    void casoNoValidoN5_cargoVacio() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new Empleado("Juan Pérez", "", 3000));
        assertTrue(ex.getMessage().contains(Constantes.CARGO_NO_VALIDO));
    }

    @Test
    void casoNoValidoN6_salarioNegativo() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new Empleado("Juan Pérez", Cargos.DESARROLLADOR, -500));
        assertTrue(ex.getMessage().contains(Constantes.SALARIO_NO_VALIDO));
    }

    @Test
    void casoNoValidoN7_salarioCero() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new Empleado("Juan Pérez", Cargos.DESARROLLADOR, 0));
        assertTrue(ex.getMessage().contains(Constantes.SALARIO_NO_VALIDO));
    }

    @Test
    void casoNoValidoN8_salarioPorDebajoConvenio() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new Empleado("Juan Pérez", Cargos.DESARROLLADOR, 1000));
        assertTrue(ex.getMessage().contains(Constantes.SALARIO_NO_VALIDO));
    }

    @Test
    void casoNoValidoN9_salarioNaN() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new Empleado("Juan Pérez", Cargos.DESARROLLADOR, Double.NaN));
        assertTrue(ex.getMessage().contains(Constantes.SALARIO_NO_VALIDO));
    }
}
