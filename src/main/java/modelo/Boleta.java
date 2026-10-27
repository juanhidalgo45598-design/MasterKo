
package modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Boleta extends Comprobante {
    
    private String dniCliente;

    public Boleta() {
        super();
    }

    public Boleta(Long idComprobante, String serie, String numero, LocalDateTime fechaEmision, BigDecimal subtotal, BigDecimal igv, BigDecimal total, String dniCliente) {
        super(idComprobante, serie, numero, fechaEmision, subtotal, igv, total);
        this.dniCliente = dniCliente;
    }

    @Override
    public boolean validarDocumentoFiscal() {
        return this.dniCliente != null && this.dniCliente.length() == 8;
    }

    public BigDecimal calcularCostoConsumo() {
        return this.total != null ? this.total : BigDecimal.ZERO;
    }

    public String getDniCliente() { 
        return dniCliente; 
    }
    
    public void setDniCliente(String dniCliente) { 
        this.dniCliente = dniCliente; 
    }
    
}
