/**
 * Representa un empleado de la empresa.
 *
 * <p>Incluye validaciones de nombre, cargo y salario conforme a reglas de negocio:
 * - nombre no vacío, trim y mínimo dos palabras
 * - cargo dentro de valores válidos de {@link Cargos}
 * - salario no menor al convenio ({@link Constantes#SALARIO_CONVENIO})</p>
 */
public class Empleado {

    /** Nombre completo del empleado (2+ palabras). */
    private String nombre;

    /** Cargo profesional del empleado (uno de {@link Cargos}). */
    private String cargo;

    /** Salario bruto del empleado. */
    private double salario;

    /**
     * Construye un empleado con valores iniciales.
     *
     * @param nombre nombre completo (no vacío, 2+ palabras)
     * @param cargo cargo válido según {@link Cargos}
     * @param salario salario >= {@link Constantes#SALARIO_CONVENIO}
     * @throws IllegalArgumentException si cualquier validación falla
     */
    public Empleado(String nombre, String cargo, double salario) {
        setNombre(nombre);
        setCargo(cargo);
        setSalario(salario);
    }

    /**
     * Devuelve el nombre completo del empleado.
     *
     * @return nombre completo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el cargo profesional del empleado.
     *
     * @return cargo válido
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Devuelve el salario del empleado.
     *
     * @return salario bruto
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre nombre completo no vacío y con al menos dos palabras
     * @throws IllegalArgumentException si el nombre no es válido
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty() || nombre.trim().split("\\s+").length < 2) {
            throw new IllegalArgumentException(Constantes.NOMBRE_NO_VALIDO + nombre);
        }
        this.nombre = nombre.trim();
    }

    /**
     * Establece el cargo profesional del empleado.
     *
     * @param cargo cargo válido según {@link Cargos}
     * @throws IllegalArgumentException si el cargo no es válido
     */
    public void setCargo(String cargo) {
        if (!Cargos.esCargoValido(cargo)) {
            throw new IllegalArgumentException(Constantes.CARGO_NO_VALIDO + cargo);
        }
        this.cargo = cargo;
    }

    /**
     * Establece el salario bruto del empleado.
     *
     * @param salario salario >= {@link Constantes#SALARIO_CONVENIO}
     * @throws IllegalArgumentException si el salario es NaN o por debajo de convenio
     */
    public void setSalario(double salario) {
        if (Double.isNaN(salario) || salario < Constantes.SALARIO_CONVENIO) {
            throw new IllegalArgumentException(Constantes.SALARIO_NO_VALIDO + salario);
        }
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                '}';
    }
}
