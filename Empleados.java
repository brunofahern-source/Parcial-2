/**
 * Gestiona un conjunto de empleados en una lista de tamaño fijo.
 *
 * <p>Proporciona métodos para dar de alta empleados, modificar su salario y
 * mostrar el listado completo.</p>
 */
public class Empleados {

    /**
     * Lista interna de empleados. Se recomienda acceso via {@link #getLista()}.
     */
    public Empleado[] lista;

    /** Número actual de empleados dados de alta. */
    private int cantidad;

    /**
     * Crea un gestor de empleados con capacidad máxima.
     *
     * @param capacidadMaxima número máximo de empleados alojables
     */
    public Empleados(int capacidadMaxima) {
        this.lista = new Empleado[capacidadMaxima];
        this.cantidad = 0;
    }

    /**
     * Da de alta un nuevo empleado en la lista.
     *
     * @param empleado empleado válido a dar de alta
     * @throws IllegalStateException si la capacidad ya está completa
     */
    public void darAltaEmpleado(Empleado empleado) {
        if (cantidad >= lista.length) {
            throw new IllegalStateException(Constantes.CAPACIDAD_COMPLETA);
        }
        lista[cantidad++] = empleado;
    }

    /**
     * Aumenta el salario de todos los empleados en la lista.
     *
     * @param porcentaje porcentaje de aumento (ej. 10 = +10%)
     */
    public void aumentarSalario(double porcentaje) {
        for (int i = 0; i < cantidad; i++) {
            Empleado empleado = lista[i];
            double nuevoSalario = empleado.getSalario() * (1 + porcentaje / 100);
            empleado.setSalario(nuevoSalario);
        }
    }

    /**
     * Muestra por consola el listado de empleados dados de alta.
     */
    public void mostrarListado() {
        System.out.println(Constantes.LISTADO_EMPLEADOS);
        for (int i = 0; i < cantidad; i++) {
            System.out.println(lista[i]);
        }
    }

    /**
     * Devuelve una copia del array de empleados actuales.
     *
     * @return copia del array con los empleados activos
     */
    public Empleado[] getLista() {
        Empleado[] copia = new Empleado[cantidad];
        System.arraycopy(lista, 0, copia, 0, cantidad);
        return copia;
    }
}