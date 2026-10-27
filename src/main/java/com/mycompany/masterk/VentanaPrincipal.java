
package com.mycompany.masterk;



import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import modelo.*;
import implementaciones.*;
import interfaces.*;
import util.FechaUtil;

public class VentanaPrincipal extends JFrame {
    private JTextField txtNombreCliente;
    private JTextField txtDniCliente;
    private JTextArea txtAreaResultado;

    public VentanaPrincipal() {
        // Configuración de la Ventana
        setTitle("Master Kong - Sistema de Gestión de Restaurante");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en la pantalla
        setLayout(new BorderLayout(10, 10));

        // --- PANEL SUPERIOR (Formulario de Entrada) ---
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 8, 8));
        panelFormulario.setBorder(BorderFactory.createTitledBorder(" Datos del Cliente y Pedido "));

        panelFormulario.add(new JLabel(" Nombre del Cliente:"));
        txtNombreCliente = new JTextField("Maria Gomez");
        panelFormulario.add(txtNombreCliente);

        panelFormulario.add(new JLabel(" DNI del Cliente:"));
        txtDniCliente = new JTextField("78945612");
        panelFormulario.add(txtDniCliente);

        JButton btnProcesar = new JButton("Procesar Pedido y Pagar");
        panelFormulario.add(new JLabel("")); // Espacio vacío
        panelFormulario.add(btnProcesar);

        add(panelFormulario, BorderLayout.NORTH);

        // --- PANEL CENTRAL (Consola Visual / Ticket) ---
        txtAreaResultado = new JTextArea();
        txtAreaResultado.setEditable(false);
        txtAreaResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(txtAreaResultado);
        scrollPane.setBorder(BorderFactory.createTitledBorder(" Ticket Electrónico y Estado "));
        add(scrollPane, BorderLayout.CENTER);

        // --- ACCIÓN DEL BOTÓN ---
        btnProcesar.addActionListener(e -> ejecutarSistemaRestaurante());
    }

    private void ejecutarSistemaRestaurante() {
        try {
            // Recoger datos de la interfaz
            String nombre = txtNombreCliente.getText();
            String dni = txtDniCliente.getText();

            // 1. Registrar Personal y Cliente
            Empleado cajero = new Empleado(1L, "Carlos Perez", "DNI", "45879612", "987654321", "Cajero", "Mañana", "EMP001");
            Cliente cliente = new Cliente("REGULAR", 2L, nombre, "DNI", dni, "912345678");

            // 2. Asignar Mesa y Platillos
            Mesa mesa = new Mesa(5, 4, "OCUPADA");
            Platillo plato1 = new Platillo(1L, "Arroz Chaufa Especial", "Chaufa con chancho y pollo", new BigDecimal("28.00"), "Plato Principal", true);
            Platillo plato2 = new Platillo(2L, "Wantan Frito (10 un.)", "Acompañamiento", new BigDecimal("16.00"), "Entrada", true);

            // 3. Crear Pedido y sus Detalles
            Pedido pedido = new Pedido(100L, mesa, cajero, FechaUtil.obtenerFechaActual(), "PENDIENTE", BigDecimal.ZERO);
            
            DetallePedido detalle1 = new DetallePedido(1L, pedido, plato1, 2, new BigDecimal("56.00")); // 2 x 28.00
            DetallePedido detalle2 = new DetallePedido(2L, pedido, plato2, 1, new BigDecimal("16.00")); // 1 x 16.00

            BigDecimal totalPedido = detalle1.getSubtotal().add(detalle2.getSubtotal());
            pedido.setTotal(totalPedido);
            pedido.cambiarEstadoPedido("ATENDIDO");

            // 4. Comprobante (Boleta)
            BigDecimal subtotal = pedido.getTotal().divide(new BigDecimal("1.18"), 2, java.math.RoundingMode.HALF_UP);
            BigDecimal igv = pedido.getTotal().subtract(subtotal);
            Boleta boleta = new Boleta(10L, "B001", "000452", FechaUtil.obtenerFechaActual(), subtotal, igv, pedido.getTotal(), cliente.getNumeroDocumento());

            // 5. Procesar Pago (Polimorfismo)
            IMetodoPago metodoPago = new PagoTarjeta("4557380012345678", "CREDITO", "BCP");
            Pago pago = new Pago(1L, boleta, pedido.getTotal(), FechaUtil.obtenerFechaActual(), metodoPago);

            boolean pagoExitoso = pago.ejecutarPago();
            if (pagoExitoso) {
                pedido.cambiarEstadoPedido("PAGADO");
                mesa.cambiarEstado("LIBRE");
            }

            // --- MOSTRAR RESULTADOS EN LA VENTANA ---
            StringBuilder sb = new StringBuilder();
            sb.append("==================================================\n");
            sb.append("         RESTAURANTE MASTER KONG - TICKET         \n");
            sb.append("==================================================\n");
            sb.append(" Cajero: ").append(cajero.getNombre()).append(" (").append(cajero.getRol()).append(")\n");
            sb.append(" Cliente: ").append(cliente.getNombre()).append(" [DNI: ").append(cliente.getNumeroDocumento()).append("]\n");
            sb.append(" Mesa N°: ").append(mesa.getNumeroMesa()).append("\n");
            sb.append("--------------------------------------------------\n");
            sb.append(detalle1.getCantidad()).append("x ").append(plato1.getNombre()).append(" ---> S/. ").append(detalle1.getSubtotal()).append("\n");
            sb.append(detalle2.getCantidad()).append("x ").append(plato2.getNombre()).append(" ---> S/. ").append(detalle2.getSubtotal()).append("\n");
            sb.append("--------------------------------------------------\n");
            sb.append(" TOTAL A PAGAR: S/. ").append(pedido.getTotal()).append("\n");
            sb.append(" Comprobante: Boleta ").append(boleta.getSerie()).append("-").append(boleta.getNumero()).append("\n");
            sb.append(" Validación Fiscal SUNAT: ").append(boleta.validarDocumentoFiscal() ? "APROBADO (DNI Válido)" : "RECHAZADO").append("\n");
            sb.append(" Método de Pago: ").append(pago.obtenerDetalleDelPago()).append("\n");
            sb.append(" Estado Transacción: ").append(pagoExitoso ? "¡APROBADO EXITOSAMENTE!" : "RECHAZADO").append("\n");
            sb.append(" Estado Mesa: ").append(mesa.getEstado()).append(" (Liberada)\n");
            sb.append("==================================================");

            txtAreaResultado.setText(sb.toString());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Ejecutar la interfaz gráfica en el hilo seguro de Swing
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}