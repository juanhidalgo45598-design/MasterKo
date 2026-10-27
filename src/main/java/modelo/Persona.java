
package modelo;


public abstract class Persona {
    
    protected Long idPersona;
    protected String nombre;
    protected String tipoDocumento;
    protected String numeroDocumento;
    protected String telefono;

    public Persona() {
    }

    public Persona(Long idPersona, String nombre, String tipoDocumento, String numeroDocumento, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.telefono = telefono;
    }

    public boolean validarDocumento() {
        return this.numeroDocumento != null && !this.numeroDocumento.isEmpty();
    }

    public void actualizarDatos(String nuevoTelefono) {
        this.telefono = nuevoTelefono;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    

    
    
    
}
