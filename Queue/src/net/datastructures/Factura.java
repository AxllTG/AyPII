package net.datastructures;

public class Factura implements PorPagar {

    private class Item {
        private String descripcion;
        private int cantidad;
        private double precioUnitario;

        public Item(String descripcion, int cantidad, double precioUnitario) {
            this.descripcion = descripcion;
            this.cantidad = cantidad;
            this.precioUnitario = precioUnitario;
        }

        public double subtotal() {
            return (double) cantidad * precioUnitario;
        }

        @Override
        public String toString() {
            return String.format("  %-25s  cant: %3d  precio: $%6.2f  subtotal: $%8.2f",
                    descripcion, cantidad, precioUnitario, subtotal());
        }
    }

    private String proveedor;
    private int numero;
    private String fecha;
    private Item[] articulos;
    private int cantidadItems;
    private static final int MAX_ITEMS = 10;

    public Factura(String proveedor, int numero, String fecha) {
        this.proveedor = proveedor;
        this.numero = numero;
        this.fecha = fecha;
        this.articulos = new Item[MAX_ITEMS];
        this.cantidadItems = 0;
    }

    public void agregarItems(String descripcion, int cantidad, double precioUnitario) {
        if (cantidadItems >= MAX_ITEMS) {
            System.out.println("No se pueden agregar mas items (MAXIMO " + MAX_ITEMS + ").");
            return;
        }
        articulos[cantidadItems] = new Item(descripcion, cantidad, precioUnitario);
        cantidadItems++;
    }

    @Override
    public double obtenerPago() {
        double total = 0;
        for (int i = 0; i < cantidadItems; i++) {
            total += articulos[i].subtotal();
        }
        return total;
    }

    public String getProveedor() { return proveedor; }
    public void setProveedor(String proveedor) { this.proveedor = proveedor; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public int getCantidadItems() { return cantidadItems; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("  FACTURA N° %d\n", numero));
        sb.append("========================================\n");
        sb.append(String.format("  Proveedor : %s\n", proveedor));
        sb.append(String.format("  Fecha     : %s\n", fecha));
        sb.append("  ----------------------------------------\n");
        sb.append("  Ítems:\n");
        for (int i = 0; i < cantidadItems; i++) {
            sb.append(articulos[i].toString()).append("\n");
        }
        sb.append("  ----------------------------------------\n");
        sb.append(String.format("  TOTAL: $%.2f\n", obtenerPago()));
        sb.append("========================================\n");
        return sb.toString();
    }
}