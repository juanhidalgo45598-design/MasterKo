
package modelo;

import util.FechaUtil;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pedido {
    
    private Long idPedido;
    private Mesa mesa;
    private Empleado empleado;
    private LocalDateTime fechaHora;
    private String estado; // "PENDIENTE", "EN_PREPARACION", "ATENDIDO", "PAGADO"
    private BigDecimal total;
    
    public Pedido() {
        this.fechaHora = FechaUtil.obtenerFechaActual();
        this.estado = "PENDIENTE";
        this.total = BigDecimal.ZERO;
    }

    public Pedido(Long idPedido, Mesa mesa, Empleado empleado, LocalDateTime fechaHora, String estado, BigDecimal total) {
        this.idPedido = idPedido;
        this.mesa = mesa;
        this.empleado = empleado;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.total = total;
    }
    
    public void cambiarEstadoPedido(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public String getFechaHoraFormateada() {
        return FechaUtil.convertirAString(this.fechaHora);
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    
    
    
    
}
