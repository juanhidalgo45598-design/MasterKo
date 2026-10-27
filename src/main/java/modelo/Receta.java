
package modelo;

import java.math.BigDecimal;

public class Receta {
    
    private Long idReceta;
    private Platillo platillo;
    private Insumo insumo;
    private BigDecimal cantidadRequerida;

    public Receta() {
    }

    public Receta(Long idReceta, Platillo platillo, Insumo insumo, BigDecimal cantidadRequerida) {
        this.idReceta = idReceta;
        this.platillo = platillo;
        this.insumo = insumo;
        this.cantidadRequerida = cantidadRequerida;
    }

    public Long getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Long idReceta) {
        this.idReceta = idReceta;
    }

    public Platillo getPlatillo() {
        return platillo;
    }

    public void setPlatillo(Platillo platillo) {
        this.platillo = platillo;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public BigDecimal getCantidadRequerida() {
        return cantidadRequerida;
    }

    public void setCantidadRequerida(BigDecimal cantidadRequerida) {
        this.cantidadRequerida = cantidadRequerida;
    }
    
    
    
}
