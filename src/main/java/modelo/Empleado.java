
package modelo;


public class Empleado extends Persona{
    private String rol; // Ej: "Mozo", "Cajero", "Chef", "Anfitrión"
    private String turno; // Ej: "Mañana", "Tarde", "Noche"
    private String codigoEmpleado;

    public Empleado() {
        super();
    }


public Empleado(Long idPersona, String nombre, String tipoDocumento, String numeroDocumento, String telefono, String rol, String turno, String codigoEmpleado) {
    super(idPersona, nombre, tipoDocumento, numeroDocumento, telefono);
    this.rol = rol;
    this.turno = turno;
    this.codigoEmpleado = codigoEmpleado;
}
    
    public boolean verificarAccesoSistema() {
        return this.codigoEmpleado != null && !this.codigoEmpleado.isEmpty();
    }

    public void cambiarTurno(String nuevoTurno) {
        this.turno = nuevoTurno;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }
    
    
    
    
    
    
}
