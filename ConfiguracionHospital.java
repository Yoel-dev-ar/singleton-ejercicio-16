// ConfiguracionHospital.java
import java.time.LocalTime;

public class ConfiguracionHospital {
    private static ConfiguracionHospital instancia;

    private String nombreHospital;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    private int duracionTurnosMinutos;

    private ConfiguracionHospital() {
        this.nombreHospital = "Hospital Central";
        this.horaApertura = LocalTime.of(8, 0);
        this.horaCierre = LocalTime.of(20, 0);
        this.duracionTurnosMinutos = 30;
    }

    public static ConfiguracionHospital getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionHospital();
        }
        return instancia;
    }

    public static boolean estaInicializada() {
        return instancia != null;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        if (nombreHospital == null || nombreHospital.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del hospital no puede estar vacío.");
        }
        this.nombreHospital = nombreHospital.trim();
    }

    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    public void setHorarioAtencion(LocalTime horaApertura, LocalTime horaCierre) {
        if (horaApertura == null || horaCierre == null) {
            throw new IllegalArgumentException("Las horas de apertura y cierre son obligatorias.");
        }
        if (!horaCierre.isAfter(horaApertura)) {
            throw new IllegalArgumentException("El horario de cierre debe ser posterior al de apertura.");
        }
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    public int getDuracionTurnosMinutos() {
        return duracionTurnosMinutos;
    }

    public void setDuracionTurnosMinutos(int duracionTurnosMinutos) {
        if (duracionTurnosMinutos <= 0) {
            throw new IllegalArgumentException("La duración de los turnos debe ser positiva.");
        }
        this.duracionTurnosMinutos = duracionTurnosMinutos;
    }

    public void mostrarConfiguracion(String modulo) {
        System.out.println("[" + modulo + "] " + nombreHospital
                + " | Horario: " + horaApertura + " a " + horaCierre
                + " | Turnos: " + duracionTurnosMinutos + " min");
    }
}