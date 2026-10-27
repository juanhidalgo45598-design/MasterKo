
package modelo;

import java.math.BigDecimal;

public class DetallePedido {
    
    private Long idDetalle;
    private Pedido pedido;
    private Platillo platillo;
    private int cantidad;
    private BigDecimal subtotal;

    public DetallePedido() {
        this.cantidad = 1;
        this.subtotal = BigDecimal.ZERO;
    }

    public DetallePedido(Long idDetalle, Pedido pedido, Platillo platillo, int cantidad, BigDecimal subtotal) {
        this.idDetalle = idDetalle;
        this.pedido = pedido;
        this.platillo = platillo;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }
    
    public void calcularSubtotal() {
        if (this.platillo != null && this.platillo.getPrecio() != null) {
            this.subtotal = this.platillo.getPrecio().multiply(BigDecimal.valueOf(this.cantidad));
        } else {
            this.subtotal = BigDecimal.ZERO;
        }
    }
    
public Long getIdDetalle() { return idDetalle; }
    public void setIdDetalle(Long idDetalle) { this.idDetalle = idDetalle; }

    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }

    public Platillo getPlatillo() { return platillo; }
    public void setPlatillo(Platillo platillo) { 
        this.platillo = platillo; 
        calcularSubtotal(); // Actualiza el subtotal si cambia el platillo
    }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { 
        this.cantidad = cantidad; 
        calcularSubtotal(); // Actualiza el subtotal si cambia la cantidad
    }

    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}