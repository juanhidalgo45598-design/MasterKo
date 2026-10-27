
package interfaces;

import java.math.BigDecimal;

public interface IMetodoPago {
    
    boolean procesarPago(BigDecimal monto);
    String obtenerDetallePago();
    
}
