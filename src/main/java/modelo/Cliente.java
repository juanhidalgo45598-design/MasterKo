
package modelo;


public class Cliente extends Persona {
    
    private String tipoCliente;  //Normal/Corporativo

    public Cliente() {
    }

    public Cliente(String TipoCliente) {
        this.tipoCliente = tipoCliente;
    }   

    public Cliente(String TipoCliente, Long idPersona, String nombre, String tipoDocumento, String numeroDocumento, String telefono) {
        super(idPersona, nombre, tipoDocumento, numeroDocumento, telefono);
        this.tipoCliente = tipoCliente;
    }
    
    public boolean esClienteCorporativo() {
        return "CORPORATIVO".equalsIgnoreCase(this.tipoCliente);
    }
    
    public String obtenerComprobantePreferido() {
        if (esClienteCorporativo()) {
            return "FACTURA";
        } else {
            return "BOLETA";
        }
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String TipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    
    
}
