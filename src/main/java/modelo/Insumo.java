
package modelo;

import java.math.BigDecimal;
public class Insumo {
    
    private Long idInsumo;
    private String nombre;
    private String unidadMedida; // Ej: "kg", "litros", "unidades"
    private BigDecimal stockActual;
    private BigDecimal stockMinimo;

    public Insumo() {
    }

    public Insumo(Long idInsumo, String nombre, String unidadMedida, BigDecimal stockActual, BigDecimal stockMinimo) {
        this.idInsumo = idInsumo;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
    }
    
    public boolean verificarStockBajo() {
        return this.stockActual != null && this.stockMinimo != null && this.stockActual.compareTo(this.stockMinimo) <= 0;
    }

    public Long getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Long idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public BigDecimal getStockActual() {
        return stockActual;
    }

    public void setStockActual(BigDecimal stockActual) {
        this.stockActual = stockActual;
    }

    public BigDecimal getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(BigDecimal stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
    
    
}
