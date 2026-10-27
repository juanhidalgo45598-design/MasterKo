
package modelo;

import interfaces.IMetodoPago;
import util.FechaUtil;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pago {
    private Long idPago;
    private Comprobante comprobante;
    private BigDecimal montoPagado;
    private LocalDateTime fechaPago;
    private IMetodoPago metodoPago; // Aquí se aplica el polimorfismo

    public Pago() {
        this.fechaPago = FechaUtil.obtenerFechaActual();
    }

    public Pago(Long idPago, Comprobante comprobante, BigDecimal montoPagado, LocalDateTime fechaPago, IMetodoPago metodoPago) {
        this.idPago = idPago;
        this.comprobante = comprobante;
        this.montoPagado = montoPagado;
        this.fechaPago = (fechaPago != null) ? fechaPago : FechaUtil.obtenerFechaActual();
        this.metodoPago = metodoPago;
    }

    public boolean ejecutarPago() {
        if (metodoPago != null && montoPagado != null) {
            return metodoPago.procesarPago(montoPagado);
        }
        return false;
    }

    public String obtenerDetalleDelPago() {
        return metodoPago != null ? metodoPago.obtenerDetallePago() : "Sin método de pago";
    }

    public String getFechaPagoFormateada() {
        return FechaUtil.convertirAString(this.fechaPago);
    }

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public BigDecimal getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(BigDecimal montoPagado) {
        this.montoPagado = montoPagado;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public IMetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(IMetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
    
    
    
}
