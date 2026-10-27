
package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FechaUtil {
    
    private static final DateTimeFormatter FORMATO_PERU = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
public static LocalDateTime obtenerFechaActual() {
        return LocalDateTime.now();
    }

    // Método para convertir un LocalDateTime a un texto bonito (para mostrar en boletas/facturas)
    public static String convertirAString(LocalDateTime fecha) {
        if (fecha == null) {
            return "";
        }
        return fecha.format(FORMATO_PERU);
    }

    
}
