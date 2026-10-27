
package modelo;

import util.FechaUtil;
import java.time.LocalDateTime;


public class Comanda {
    
    private Long idComanda;
    private Pedido pedido;
    private LocalDateTime fechaHoraEmision;
    private String estadoCocina; // "PENDIENTE", "EN_PREPARACION", "LISTO"

    public Comanda() {
        this.fechaHoraEmision = FechaUtil.obtenerFechaActual();
        this.estadoCocina = "PENDIENTE";
    }
    
    public Comanda(Long idComanda, Pedido pedido, LocalDateTime fechaHoraEmision, String estadoCocina) {
        this.idComanda = idComanda;
        this.pedido = pedido;
        this.fechaHoraEmision = (fechaHoraEmision != null) ? fechaHoraEmision : FechaUtil.obtenerFechaActual();
        this.estadoCocina = (estadoCocina != null) ? estadoCocina : "PENDIENTE";
    }
    
    public void actualizarEstadoCocina(String nuevoEstado) {
        this.estadoCocina = nuevoEstado;
    }

    public String getFechaHoraEmisionFormateada() {
        return FechaUtil.convertirAString(this.fechaHoraEmision);
    }

    public Long getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(Long idComanda) {
        this.idComanda = idComanda;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public LocalDateTime getFechaHoraEmision() {
        return fechaHoraEmision;
    }

    public void setFechaHoraEmision(LocalDateTime fechaHoraEmision) {
        this.fechaHoraEmision = fechaHoraEmision;
    }

    public String getEstadoCocina() {
        return estadoCocina;
    }

    public void setEstadoCocina(String estadoCocina) {
        this.estadoCocina = estadoCocina;
    }
    
    
    
    
    
}
