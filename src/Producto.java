// Clase que representa un producto dentro del sistema de ventas.
// Cada producto tiene un id, nombre y precio.
public class Producto {
    // Atributos privados para aplicar encapsulamiento.
    private int id;
    private String nombre;
    private float precio;

    // Constructor: permite crear un producto con sus datos iniciales.
    public Producto(int id, String nombre, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Métodos getter y setter: permiten acceder y modificar los atributos.

    public int getId() {
        return id;
    }

    // Permite modificar el id del producto.
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    // Permite modificar el nombre del producto.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    // Permite actualizar el precio del producto.
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    // Representación en texto del objeto, útil para imprimir información del producto.
    @Override
    public String toString() {
        return "Producto " + '\n' +
                "id: " + id + '\n' +
                "nombre: " + nombre + '\n' +
                "precio: " + precio;
    }
}

