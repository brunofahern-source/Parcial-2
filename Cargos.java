/**
 * Constantes y validación de cargos profesionales válidos.
 *
 * <p>Evita el uso de cadenas libres (magic strings) cuando se asigna el cargo
 * del empleado.</p>
 */
public class Cargos {

    /** Cargo de desarrollador. */
    public static final String DESARROLLADOR = "Desarrollador";

    /** Cargo de diseñadora. */
    public static final String DISENADORA = "Diseñadora";

    /** Cargo de gerente. */
    public static final String GERENTE = "Gerente";

    /** Arreglo con todos los cargos válidos. */
    public static final String[] LISTA = {
            DESARROLLADOR,
            DISENADORA,
            GERENTE
    };

    /**
     * Comprueba si un cargo es válido.
     *
     * @param cargo cargo a validar
     * @return {@code true} si está en {@link #LISTA}, {@code false} en caso contrario
     */
    public static boolean esCargoValido(String cargo) {
        if (cargo == null) {
            return false;
        }
        for (String c : LISTA) {
            if (c.equals(cargo)) {
                return true;
            }
        }
        return false;
    }

}