import java.util.ArrayList;
import java.util.List;

// Clase que representa la tienda. Administra el listado de productos
// y el registro de ventas realizadas.
public class Tienda {

    // Lista de productos disponibles en la tienda
    private List<Producto> listado;

    // Lista donde se guardan todas las ventas registradas
    private List<Venta> ventas;

    // Constructor: inicializa las listas vacías
    public Tienda() {
        listado = new ArrayList<>();
        ventas = new ArrayList<>();
    }

    // Método para iniciar la tienda con 3 productos predefinidos
    public void iniciar() {
        listado.add(new Producto(1, "Levadura", 1.3f));
        listado.add(new Producto(2, "Harina", 0.50f));
        listado.add(new Producto(3, "Mantequilla", 1.29f));
    }

    // Agrega una venta al registro de ventas
    public void agregarVenta(Venta venta) {
        ventas.add(venta);
    }

    /**
     * Método para buscar un producto por ID y actualizar su precio.
     * Implementa una búsqueda binaria .
     *
     * @param id     ID del producto a buscar
     * @param precio Nuevo precio a asignar si se encuentra el producto
     * @return true si el producto fue encontrado y actualizado, false si no existe
     */
    public boolean buscarEditar(int id, float precio) {

        int i = 0;                      // inicio del rango de búsqueda
        int s = listado.size() - 1;     // fin del rango de búsqueda
        int c;                          // punto medio

        // Búsqueda binaria
        while (i <= s) {

            c = (i + s) / 2;  // calcula la posición media

            // Compara el ID buscado con el ID del producto en el medio
            if (id == listado.get(c).getId()) {
                // Si coincide, actualiza su precio
                listado.get(c).setPrecio(precio);
                return true;

            } else if (id < listado.get(c).getId()) {
                // Si el ID buscado es menor, continúa en la mitad izquierda
                s = c - 1;

            } else {
                // Si el ID buscado es mayor, continúa en la mitad derecha
                i = c + 1;
            }
        }

        // Si sale del ciclo, significa que el ID no existe
        return false;
    }

    // Retorna la lista completa de productos
    public List<Producto> obtenerProductos() {
        return listado;
    }

    // Retorna la lista completa de ventas registradas
    public List<Venta> obtenerVentas() {
        return ventas;
    }
}

