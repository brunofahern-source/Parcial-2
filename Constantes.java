/**
 * Constantes globales de la aplicación.
 *
 * <p>Incluye cadenas de texto de UI/mensajes y valores numéricos de negocio.
 * Clase final y no instanciable.</p>
 */
public final class Constantes {

    private Constantes() {
        // clase utilitaria, no instanciable
    }

    // Textos UI
    /** Texto para solicitar el porcentaje de aumento. */
    public static final String SOLICITUD_PORCENTAJE_AUMENTO = "Introduzca el porcentaje de aumento de salario: ";

    /** Texto del encabezado de listado de empleados. */
    public static final String LISTADO_EMPLEADOS = "Lista de Empleados:";

    // Mensajes de error
    /** Prefijo para error de cargo inválido. */
    public static final String CARGO_NO_VALIDO = "Cargo no válido: ";

    /** Mensaje de error cuando no queda capacidad. */
    public static final String CAPACIDAD_COMPLETA = "No se pueden dar de alta más empleados: capacidad completa";

    /** Prefijo para error de nombre inválido. */
    public static final String NOMBRE_NO_VALIDO = "Nombre no válido: ";

    /** Prefijo para error de salario inválido. */
    public static final String SALARIO_NO_VALIDO = "Salario no válido: ";

    // Números mágicos
    /** Capacidad fija por defecto para el array de empleados. */
    public static final int CAPACIDAD_EMPLEADOS_PREDETERMINADA = 3;

    /** Salario mínimo de convenio aceptado. */
    public static final double SALARIO_CONVENIO = 1200.0;

}