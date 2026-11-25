Ejercicio 6: Configuración General de un Hospital (Patrón Singleton)
Temática
Gestión Hospitalaria — Administración centralizada de parámetros institucionales compartidos entre recepción y consultorios.

Consigna
Contexto del problema: Un hospital utiliza una aplicación administrativa con módulos de recepción y consultorios. Ambos necesitan consultar el nombre de la institución, el horario de atención y la duración predeterminada de los turnos. Las configuraciones independientes provocan diferencias entre las pantallas.
Objetivo de aprendizaje: Aplicar Singleton con inicialización diferida para compartir parámetros generales de una aplicación.
Requisitos funcionales:

Consultar y modificar el nombre del hospital, el horario de apertura y cierre y la duración de los turnos.

Acceder a los parámetros desde recepción y consultorios.

Reflejar los cambios inmediatamente en ambos módulos.
Restricciones técnicas:

La instancia debe crearse únicamente cuando se solicite por primera vez.

La clase debe impedir su instanciación directa desde los módulos.

La duración de los turnos debe ser positiva y el horario de cierre posterior al de apertura.

Se debe demostrar que las consultas posteriores no construyen nuevas instancias.

Explicación lógica
Atributos: En la clase ConfiguracionHospital se declaran nombreHospital (private String), horaApertura (private LocalTime), horaCierre (private LocalTime) y duracionTurnosMinutos (private int), junto con instancia (private static ConfiguracionHospital) para conservar la referencia única.

Instancia única: El constructor es private para bloquear new desde los módulos, y getInstancia() aplica inicialización diferida (lazy initialization), creando el objeto únicamente la primera vez que se solicita y reutilizándolo en llamadas posteriores.

Asignación y Acceso: En Main, se verifica que antes de la primera llamada no existe instancia, luego se obtiene desde recepción y consultorios comprobando ==, se actualizan nombre, horario (con cierre posterior a apertura) y duración positiva, reflejándose el cambio al instante en ambos módulos.

Estructura del ejercicio
ConfiguracionHospital.java: Implementa el Singleton perezoso con validaciones de horario y duración de turnos.

Main.java: Verifica la creación diferida, la identidad de instancia, la sincronización entre módulos y las reglas de validación.