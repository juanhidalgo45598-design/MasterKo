
package implementaciones;

import interfaces.IMetodoPago;
import java.math.BigDecimal;


public class PagoEfectivo implements IMetodoPago {
    
    private BigDecimal montoRecibido;

    public PagoEfectivo() {}

    public PagoEfectivo(BigDecimal montoRecibido) {
        this.montoRecibido = montoRecibido;
    }
    
    @Override
    public boolean procesarPago(BigDecimal monto) {
        // Valida que el dinero entregado cubra el total del consumo
        return this.montoRecibido != null && this.montoRecibido.compareTo(monto) >= 0;
    }

    @Override
    public String obtenerDetallePago() {
        return "Pago en Efectivo";
    }

    public BigDecimal calcularVuelto(BigDecimal montoTotal) {
        if (montoRecibido != null && montoTotal != null) {
            return this.montoRecibido.subtract(montoTotal);
        }
        return BigDecimal.ZERO;
    }

    public BigDecimal getMontoRecibido() { return montoRecibido; }
    public void setMontoRecibido(BigDecimal montoRecibido) { this.montoRecibido = montoRecibido; }

    
}
