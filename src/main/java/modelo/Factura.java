
package modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Factura extends Comprobante {
    private String ruc;
    private String razonSocial;
    private String direccionFiscal;

    public Factura() {
        super();
    }

    public Factura(Long idComprobante, String serie, String numero, LocalDateTime fechaEmision, BigDecimal subtotal, BigDecimal igv, BigDecimal total, String ruc, String razonSocial, String direccionFiscal) {
        super(idComprobante, serie, numero, fechaEmision, subtotal, igv, total);
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccionFiscal = direccionFiscal;
    }

    @Override
    public boolean validarDocumentoFiscal() {
        return this.ruc != null && this.ruc.length() == 11 && this.razonSocial != null && !this.razonSocial.isEmpty();
    }

    public boolean validarRucYRazonSocial() {
        return validarDocumentoFiscal();
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccionFiscal() {
        return direccionFiscal;
    }

    public void setDireccionFiscal(String direccionFiscal) {
        this.direccionFiscal = direccionFiscal;
    }


}
