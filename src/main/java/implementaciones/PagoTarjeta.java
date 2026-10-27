
package implementaciones;

import interfaces.IMetodoPago;
import java.math.BigDecimal;


public class PagoTarjeta implements IMetodoPago {
    private String numeroTarjeta;
    private String tipoTarjeta; // "CREDITO" o "DEBITO"
    private String banco;

    public PagoTarjeta() {}

    public PagoTarjeta(String numeroTarjeta, String tipoTarjeta, String banco) {
        this.numeroTarjeta = numeroTarjeta;
        this.tipoTarjeta = tipoTarjeta;
        this.banco = banco;
    }
    
    @Override
    public boolean procesarPago(BigDecimal monto) {
        // Simulación básica de validación de tarjeta
        return this.numeroTarjeta != null && this.numeroTarjeta.length() >= 16;
    }

    @Override
    public String obtenerDetallePago() {
        return "Pago con Tarjeta " + (tipoTarjeta != null ? tipoTarjeta : "") + " (" + (banco != null ? banco : "General") + ")";
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
    
    
}
