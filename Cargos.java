public class Cargos {

    public static final String DESARROLLADOR = "Desarrollador";
    public static final String DISENADORA = "Diseñadora";
    public static final String GERENTE = "Gerente";

    public static final String[] LISTA = {
            DESARROLLADOR,
            DISENADORA,
            GERENTE
    };

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