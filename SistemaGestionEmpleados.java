/**
 * Clase principal de la aplicación de gestión de empleados.
 *
 * <p>Contiene el método {@code main} y orquesta la creación de empleados,
 * la lectura del porcentaje de aumento, y la impresión del resultado.</p>
 */
import java.util.Scanner;

public class SistemaGestionEmpleados {

    /**
     * Punto de entrada de la aplicación.
     *
     * @param args parámetros de línea de comandos (no usados)
     */
    public static void main(String[] args) {
        Empleados empleados = new Empleados(Constantes.CAPACIDAD_EMPLEADOS_PREDETERMINADA);

        empleados.darAltaEmpleado(new Empleado("Juan Pérez", Cargos.DESARROLLADOR, 50000));
        empleados.darAltaEmpleado(new Empleado("María López", Cargos.DISENADORA, 45000));
        empleados.darAltaEmpleado(new Empleado("Pedro Gómez", Cargos.GERENTE, 60000));

        Scanner scanner = new Scanner(System.in);
        System.out.print(Constantes.SOLICITUD_PORCENTAJE_AUMENTO);
        double porcentaje = scanner.nextDouble();

        empleados.aumentarSalario(porcentaje);
        empleados.mostrarListado();

        scanner.close();
    }
}
