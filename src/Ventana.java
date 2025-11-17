import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// Clase que maneja la interfaz gráfica del programa utilizando Swing.
// Aquí se registran ventas, se muestran ventas de los últimos 3 meses,
// se editan precios de productos y se buscan productos.
public class Ventana {

    // Componentes de la interfaz (generados con GUI Builder de IntelliJ)
    private JPanel Principal;
    private JTabbedPane tabbedPane1;
    private JComboBox cmbProducto;
    private JComboBox cmbMes;
    private JSpinner spnCantidad;
    private JButton btnAgregar;
    private JList lstVentasM;
    private JButton mostrarRegistroUltimos3Button;
    private JButton btnEditar;
    private JTextField txtID;
    private JTextField txtNombreA;
    private JTextField txtnB;
    private JTextField txtidB;
    private JLabel lblTotal;
    private JButton btnBuscar;
    private JTextArea txtBuscar;
    private JTextField txtNuevoP;

    // Objeto Tienda que contiene los productos y las ventas
    Tienda cordero = new Tienda();

    // Constructor: aquí se programan los eventos de los botones
    public Ventana() {

        // Inicializa los 3 productos base
        cordero.iniciar();

        // ------------------ BOTÓN AGREGAR VENTA ------------------
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Obtiene datos ingresados por el usuario
                int mes = cmbMes.getSelectedIndex() + 1; // índice +1 para que coincida con el mes real
                int cantidad = Integer.parseInt(spnCantidad.getValue().toString());

                String nombre = cmbProducto.getSelectedItem().toString();
                List<Producto> productos = cordero.obtenerProductos();

                // Busca el producto seleccionado
                for (Producto producto : productos) {
                    if (producto.getNombre().equals(nombre)) {

                        // Registra la venta
                        Venta venta = new Venta(mes, cantidad, producto);
                        cordero.agregarVenta(venta);

                        // Muestra el total de la venta en pantalla
                        lblTotal.setText("Total:  " + venta.getTotal());

                        JOptionPane.showMessageDialog(null, "Se registró la venta");
                    }
                }
            }
        });

        // --------------- BOTÓN MOSTRAR REGISTRO ÚLTIMOS 3 MESES ----------------
        mostrarRegistroUltimos3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Venta> ventas = cordero.obtenerVentas();
                DefaultListModel dml = new DefaultListModel<>();

                // Filtra ventas solo de septiembre (9), octubre (10) y noviembre (11)
                for (Venta j : ventas) {
                    if (j.getMes() <= 11 && j.getMes() >= 9) {
                        dml.addElement(j.toString());
                    }
                }

                // Imprime en el JList
                lstVentasM.setModel(dml);
            }
        });

        // ------------------ BOTÓN EDITAR PRECIO DE PRODUCTO ------------------
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Producto> productos = cordero.obtenerProductos();

                int id = Integer.parseInt(txtID.getText());
                String nombre = txtNombreA.getText();
                float nuevoPrecio = Float.parseFloat(txtNuevoP.getText());

                // Busca producto por ID y nombre para actualizar su precio
                for (Producto p : productos) {
                    if (id == p.getId() && p.getNombre().equals(nombre)) {
                        p.setPrecio(nuevoPrecio);
                        JOptionPane.showMessageDialog(null, "Se actualizó el precio");
                    }
                }
            }
        });

        // ------------------ BOTÓN BUSCAR PRODUCTO ------------------
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Producto> productos = cordero.obtenerProductos();

                int id = Integer.parseInt(txtidB.getText());
                String nombre = txtnB.getText();

                // Búsqueda por ID y nombre
                for (Producto p : productos) {
                    if (id == p.getId() && nombre.equals(p.getNombre())) {

                        // Muestra el producto en el textArea
                        txtBuscar.setText(p.toString());
                        JOptionPane.showMessageDialog(null, "Se encontró el producto");
                    }
                }
            }
        });
    }

    // ------------------ MÉTODO MAIN PARA MOSTRAR LA VENTANA ------------------
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");

        // Asocia la ventana principal creada por el GUI Builder
        frame.setContentPane(new Ventana().Principal);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();          // Ajusta tamaño automático
        frame.setVisible(true); // Muestra la ventana
    }
}
