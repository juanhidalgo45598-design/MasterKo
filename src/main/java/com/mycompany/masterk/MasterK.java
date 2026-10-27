
package com.mycompany.masterk;

import modelo.*;
import implementaciones.*;
import interfaces.*;
import util.*;

import java.math.BigDecimal;

public class MasterK {

public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   SISTEMA DE GESTION RESTAURANTE - MASTER KONG   ");
        System.out.println("==================================================\n");

        // 1. Registrar Personal y Cliente
        Empleado cajero = new Empleado(1L, "Carlos Perez", "DNI", "45879612", "987654321", "Cajero", "Mañana", "EMP001");
        Cliente cliente = new Cliente("REGULAR", 2L, "Maria Gomez", "DNI", "78945612", "912345678");

        System.out.println("[Personal] Empleado en caja: " + cajero.getNombre() + " (" + cajero.getRol() + ")");
        System.out.println("[Cliente] Atendiendo a: " + cliente.getNombre() + " (DNI: " + cliente.getNumeroDocumento() + ")\n");

        // 2. Asignar Mesa y Platillos
        Mesa mesa = new Mesa(5, 4, "OCUPADA");
        System.out.println("[Mesa] Mesa N° " + mesa.getNumeroMesa() + " ocupada. Capacidad: " + mesa.getCapacidad() + " personas.");

        Platillo plato1 = new Platillo(1L, "Arroz Chaufa Especial", "Chaufa con chancho asado y pollo", new BigDecimal("28.00"), "Plato Principal", true);
        Platillo plato2 = new Platillo(2L, "Wantan Frito (10 un.)", "Acompañamiento con tamarindo", new BigDecimal("16.00"), "Entrada", true);

        System.out.println("[Menu] Platillos seleccionados:");
        System.out.println("  - " + plato1.getNombre() + " : S/. " + plato1.getPrecio());
        System.out.println("  - " + plato2.getNombre() + " : S/. " + plato2.getPrecio() + "\n");

        // 3. Crear Pedido y sus Detalles
        Pedido pedido = new Pedido(100L, mesa, cajero, FechaUtil.obtenerFechaActual(), "PENDIENTE", BigDecimal.ZERO);
        
DetallePedido detalle1 = new DetallePedido(1L, pedido, plato1, 2, new BigDecimal("56.00")); // 2 x 28.00
DetallePedido detalle2 = new DetallePedido(2L, pedido, plato2, 1, new BigDecimal("16.00")); // 1 x 16.00

        // Calcular total combinando los subtotales
        BigDecimal totalPedido = detalle1.getSubtotal().add(detalle2.getSubtotal());
        pedido.setTotal(totalPedido);
        pedido.cambiarEstadoPedido("ATENDIDO");

        System.out.println("[Pedido] Pedido N° " + pedido.getIdPedido() + " procesado.");
        System.out.println("  -> Cantidad de " + plato1.getNombre() + ": " + detalle1.getCantidad() + " (Subtotal: S/. " + detalle1.getSubtotal() + ")");
        System.out.println("  -> Cantidad de " + plato2.getNombre() + ": " + detalle2.getCantidad() + " (Subtotal: S/. " + detalle2.getSubtotal() + ")");
        System.out.println("  ================================================");
        System.out.println("  TOTAL A PAGAR: S/. " + pedido.getTotal() + "\n");

        // 4. Generar Comanda para Cocina
        Comanda comanda = new Comanda(1L, pedido, FechaUtil.obtenerFechaActual(), "LISTO");
        System.out.println("[Comanda Cocina] Emitida a las " + comanda.getFechaHoraEmisionFormateada() + " | Estado: " + comanda.getEstadoCocina() + "\n");

        // 5. Emitir Comprobante (Boleta con validación fiscal)
        BigDecimal subtotal = pedido.getTotal().divide(new BigDecimal("1.18"), 2, java.math.RoundingMode.HALF_UP);
        BigDecimal igv = pedido.getTotal().subtract(subtotal);

        Boleta boleta = new Boleta(10L, "B001", "000452", FechaUtil.obtenerFechaActual(), subtotal, igv, pedido.getTotal(), cliente.getNumeroDocumento());
        
        System.out.println("[Comprobante Fiscal] Generando Boleta Electrónica...");
        System.out.println("  - Serie y Número: " + boleta.getSerie() + "-" + boleta.getNumero());
        System.out.println("  - Fecha de Emisión: " + boleta.getFechaEmisionFormateada());
        System.out.println("  - Validación DNI Cliente (8 dígitos): " + (boleta.validarDocumentoFiscal() ? "CORRECTO (Válido para SUNAT)" : "INCORRECTO"));

        // 6. Procesar Pago (Demostración de POLIMORFISMO con IMetodoPago)
        IMetodoPago metodoPago = new PagoTarjeta("4557380012345678", "CREDITO", "BCP");
        Pago pago = new Pago(1L, boleta, pedido.getTotal(), FechaUtil.obtenerFechaActual(), metodoPago);

        System.out.println("\n[Caja] Procesando pago...");
        System.out.println("  - Método seleccionado: " + pago.obtenerDetalleDelPago());

        boolean pagoExitoso = pago.ejecutarPago();
        if (pagoExitoso) {
            System.out.println("  - Resultado: ¡PAGO EXITOSO! Aprobado por la pasarela de pagos.");
            pedido.cambiarEstadoPedido("PAGADO");
            mesa.cambiarEstado("LIBRE");
        } else {
            System.out.println("  - Resultado: PAGO RECHAZADO.");
        }

        System.out.println("\n==================================================");
        System.out.println(" ESTADO FINAL: Mesa " + mesa.getNumeroMesa() + " ahora se encuentra " + mesa.getEstado());
        System.out.println("==================================================");
    }
}
