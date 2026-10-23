package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {

    private static final int MAX_ITEMS = 20;

    private int numero;
    private LocalDate fecha;
    private Cliente cliente; // 0..1: la venta puede no tener cliente asociado (ej. venta al contado)
    private boolean tipoVenta;
    private List<ItemFactura> items;

    /**
     * Visibilidad de paquete: solo Negocio puede crear facturas, para
     * garantizar que toda factura nazca con al menos un item (regla de
     * negocio: 1..20 items por factura, ver agregarItem).
     *
     * @param tipoVenta true = venta en cuenta corriente (requiere cliente),
     * false = venta al contado (cliente opcional)
     * @throws ClienteRequeridoException si tipoVenta es cuenta corriente y no
     * se especifico un cliente
     */
    Factura(int numero, LocalDate fecha, Cliente cliente, boolean tipoVenta) {
        if (tipoVenta && cliente == null) {
            throw new ClienteRequeridoException(
                    "La factura " + numero + " es en cuenta corriente y requiere un cliente asociado");
        }
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.tipoVenta = tipoVenta;
        this.items = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isTipoVenta() {
        return tipoVenta;
    }

    /**
     * @return true si la venta fue en cuenta corriente
     */
    public boolean esCuentaCorriente() {
        return tipoVenta;
    }

    /**
     * Agrega un articulo vendido a la factura.
     *
     * @throws ArticuloRepetidoException si el articulo ya fue cargado en un
     * item de esta misma factura
     * @throws StockInsuficienteException si la cantidad a vender supera el
     * stock disponible del articulo
     * @throws IllegalStateException si la factura ya alcanzo el maximo de 20
     * items permitidos
     */
    public void agregarItem(Articulo articulo, double cantidad) {
        if (items.size() >= MAX_ITEMS) {
            throw new IllegalStateException(
                    "La factura " + numero + " ya alcanzo el maximo de " + MAX_ITEMS + " items");
        }

        for (ItemFactura it : items) {
            if (it.getArticulo().equals(articulo)) {
                throw new ArticuloRepetidoException(
                        "El articulo " + articulo.getDescripcion()
                        + " ya fue ingresado en la factura " + numero);
            }
        }

        if (cantidad > articulo.getCantidad()) {
            throw new StockInsuficienteException(
                    "No hay stock suficiente, quedan " + formatCantidad(articulo.getCantidad())
                    + " " + articulo.getDescripcion());
        }

        items.add(new ItemFactura(articulo, cantidad, articulo.getPrecio()));
        articulo.setCantidad(articulo.getCantidad() - cantidad);
    }

    public double importeTotal() {
        double total = 0;
        for (ItemFactura item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    private String formatCantidad(double cantidad) {
        if (cantidad == Math.floor(cantidad)) {
            return String.valueOf((long) cantidad);
        }
        return String.valueOf(cantidad);
    }

    @Override
    public String toString() {
        return "Factura{numero=" + numero + ", fecha=" + fecha + ", items=" + items.size() + '}';
    }

    /**
     * Detalle interno de la factura: articulo vendido, cantidad y precio
     * congelado al momento de la venta. Solo tiene sentido dentro del
     * contexto de una Factura, por eso es una clase interna privada.
     */
    private static class ItemFactura {

        private Articulo articulo;
        private double cantidad;
        private double precioUnitario;

        private ItemFactura(Articulo articulo, double cantidad, double precioUnitario) {
            this.articulo = articulo;
            this.cantidad = cantidad;
            this.precioUnitario = precioUnitario;
        }

        private Articulo getArticulo() {
            return articulo;
        }

        private double getSubtotal() {
            return cantidad * precioUnitario;
        }
    }
}