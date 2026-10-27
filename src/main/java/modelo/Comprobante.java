
package modelo;


import util.FechaUtil;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public abstract class Comprobante {
    
    protected Long idComprobante;
    protected String serie;
    protected String numero;
    protected LocalDateTime fechaEmision;
    protected BigDecimal subtotal;
    protected BigDecimal igv;
    protected BigDecimal total;
    
    public Comprobante() {
        this.fechaEmision = FechaUtil.obtenerFechaActual();
    }
    
    public Comprobante(Long idComprobante, String serie, String numero, LocalDateTime fechaEmision, BigDecimal subtotal, BigDecimal igv, BigDecimal total) {
        this.idComprobante = idComprobante;
        this.serie = serie;
        this.numero = numero;
        this.fechaEmision = (fechaEmision != null) ? fechaEmision : FechaUtil.obtenerFechaActual();
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
    }
    
    public abstract boolean validarDocumentoFiscal();
    
public String getFechaEmisionFormateada() {
    return FechaUtil.convertirAString(this.fechaEmision);
}

    public Long getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(Long idComprobante) {
        this.idComprobante = idComprobante;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getIgv() {
        return igv;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }


    
    
    

}
