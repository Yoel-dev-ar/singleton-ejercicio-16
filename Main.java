import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("¿Instancia creada antes del primer pedido? " + ConfiguracionHospital.estaInicializada());

        // Primera solicitud: inicialización diferida (lazy)
        ConfiguracionHospital recepcion = ConfiguracionHospital.getInstancia();
        System.out.println("¿Instancia creada tras primer pedido? " + ConfiguracionHospital.estaInicializada());

        ConfiguracionHospital consultorios = ConfiguracionHospital.getInstancia();
        System.out.println("¿Misma referencia en recepción y consultorios? " + (recepcion == consultorios));

        recepcion.mostrarConfiguracion("Recepción");
        consultorios.mostrarConfiguracion("Consultorios");

        // Actualización desde recepción reflejada en consultorios
        recepcion.setNombreHospital("Hospital Regional del Este");
        recepcion.setHorarioAtencion(LocalTime.of(7, 30), LocalTime.of(21, 30));
        recepcion.setDuracionTurnosMinutos(20);

        consultorios.mostrarConfiguracion("Consultorios tras cambio");

        // Validación de horario inválido (cierre anterior o igual a apertura)
        try {
            recepcion.setHorarioAtencion(LocalTime.of(18, 0), LocalTime.of(16, 0));
        } catch (IllegalArgumentException e) {
            System.out.println("Validación de horario correcta: " + e.getMessage());
        }

        // Validación de duración no positiva
        try {
            consultorios.setDuracionTurnosMinutos(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Validación de duración correcta: " + e.getMessage());
        }
    }
}