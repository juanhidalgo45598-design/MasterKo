
package modelo;

import java.math.BigDecimal;

public class Platillo {
    
    private Long idPlatillo;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String categoria; // Ej: "Entrada", "Plato Principal", "Bebida", "Postre"
    private boolean disponible;
    
    public Platillo() {
        this.disponible = true;
    }

    public Platillo(Long idPlatillo, String nombre, String descripcion, BigDecimal precio, String categoria, boolean disponible) {
        this.idPlatillo = idPlatillo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.disponible = disponible;
    }
    
    public boolean verificarDisponibilidad() {
        return this.disponible;
    }

    public Long getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(Long idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    
    
}
