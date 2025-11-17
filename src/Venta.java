// Clase que representa una venta realizada en la tienda.
// Cada venta tiene un mes, una cantidad vendida, un producto asociado
// y un total calculado en base al precio del producto.
public class Venta {

    // Mes en el que se realiza la venta (1 = enero, 2 = febrero, etc.)
    private int mes;

    // Cantidad de unidades vendidas del producto
    private int cantidad;

    // Producto que se está vendiendo
    private Producto producto;

    // Valor total de la venta (cantidad * precio del producto)
    private float total;

    // Constructor de la clase Venta
    // Calcula automáticamente el total basándose en el precio actual del producto
    public Venta(int mes, int cantidad, Producto producto) {
        this.mes = mes;
        this.cantidad = cantidad;
        this.producto = producto;

        // Calcula el total de forma automática
        this.total = this.cantidad * producto.getPrecio();
    }

    // Métodos getter y setter para acceder y modificar los atributos

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    // Si se cambia el producto también sería correcto recalcular el total,
    // pero eso depende del diseño del programa.
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public float getTotal() {
        return total;
    }

    // Permite actualizar el total manualmente si se desea
    public void setTotal(float total) {
        this.total = total;
    }

    // Método para imprimir la información completa de la venta
    @Override
    public String toString() {
        return "Venta: " +
                " mes = " + mes +
                ", cantidad = " + cantidad +
                ", producto = " + producto.toString() +
                ", total = " + total;
    }
}

