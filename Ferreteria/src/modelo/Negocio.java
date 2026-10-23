package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Negocio {

    private String cuit;
    private String nombre;
    private List<Cliente> clientes;
    private List<Articulo> articulos;
    private List<Factura> facturas;

    public Negocio(String cuit, String nombre) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.clientes = new ArrayList<>();
        this.articulos = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }

    public String getCuit() {
        return cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public Cliente agregarCliente(int codigo, String nombre, String cuit, String telefono, String direccion) {
        Cliente cliente = new Cliente(codigo, nombre, cuit, telefono, direccion);
        clientes.add(cliente);
        return cliente;
    }

    public Articulo agregarArticulo(int codigo, String descripcion, double precio, double cantidad) {
        Articulo articulo = new Articulo(codigo, descripcion, precio, cantidad);
        articulos.add(articulo);
        return articulo;
    }

    /**
     * Crea una factura con un primer articulo vendido y la registra en el
     * negocio. La factura queda sin cliente asociado (0..1, ej. venta al
     * contado) y con tipoVenta en false.
     *
     * @throws StockInsuficienteException si la cantidad a vender supera el
     * stock disponible del articulo
     */
    public Factura agregarFactura(int numero, LocalDate fecha, Articulo articulo, double cantidad) {
        return agregarFactura(numero, fecha, null, false, articulo, cantidad);
    }

    /**
     * Crea una factura asociada a un cliente, con un primer articulo
     * vendido, y la registra en el negocio.
     *
     * @throws StockInsuficienteException si la cantidad a vender supera el
     * stock disponible del articulo
     */
    public Factura agregarFactura(int numero, LocalDate fecha, Cliente cliente, boolean tipoVenta,
            Articulo articulo, double cantidad) {
        Factura factura = new Factura(numero, fecha, cliente, tipoVenta);
        factura.agregarItem(articulo, cantidad);
        facturas.add(factura);
        return factura;
    }

    public Articulo buscarArticulo(int codigo) {
        for (Articulo a : articulos) {
            if (a.getCodigo() == codigo) {
                return a;
            }
        }
        return null;
    }

    /**
     * Cambia en un porcentaje el precio de todos los articulos del stock
     *
     * @param porcCambio porcentaje de cambio de precio
     */
    public void cambiarPrecio(double porcCambio) {
        for (Articulo articulo : articulos) {
            double nuevoPrecio = articulo.getPrecio() + articulo.getPrecio() * porcCambio / 100.0;
            articulo.setPrecio(nuevoPrecio);
        }
    }

    /**
     * Retorna el valor total del stock multiplicando la cantidad existente
     * por el precio
     *
     * @return stock valorizado
     */
    public double stockValorizado() {
        double total = 0;
        for (Articulo articulo : articulos) {
            total += articulo.getCantidad() * articulo.getPrecio();
        }
        return total;
    }

    /**
     * Total facturado entre dos fechas (inclusive), sin importar cliente ni
     * tipo de venta.
     */
    public double totalFacturado(LocalDate desde, LocalDate hasta) {
        double total = 0;
        for (Factura factura : facturas) {
            if (enRango(factura.getFecha(), desde, hasta)) {
                total += factura.importeTotal();
            }
        }
        return total;
    }

    /**
     * Total facturado entre dos fechas (inclusive) para un cliente
     * determinado, sin importar el tipo de venta.
     */
    public double totalFacturado(LocalDate desde, LocalDate hasta, Cliente cliente) {
        double total = 0;
        for (Factura factura : facturas) {
            if (enRango(factura.getFecha(), desde, hasta) && cliente.equals(factura.getCliente())) {
                total += factura.importeTotal();
            }
        }
        return total;
    }

    /**
     * Total facturado entre dos fechas (inclusive) en ventas de cuenta
     * corriente, sin importar el cliente.
     */
    public double totalFacturadoCuentaCorriente(LocalDate desde, LocalDate hasta) {
        double total = 0;
        for (Factura factura : facturas) {
            if (enRango(factura.getFecha(), desde, hasta) && factura.esCuentaCorriente()) {
                total += factura.importeTotal();
            }
        }
        return total;
    }

    /**
     * Total facturado entre dos fechas (inclusive) en ventas de cuenta
     * corriente para un cliente determinado.
     */
    public double totalFacturadoCuentaCorriente(LocalDate desde, LocalDate hasta, Cliente cliente) {
        double total = 0;
        for (Factura factura : facturas) {
            if (enRango(factura.getFecha(), desde, hasta) && factura.esCuentaCorriente()
                    && cliente.equals(factura.getCliente())) {
                total += factura.importeTotal();
            }
        }
        return total;
    }

    private boolean enRango(LocalDate fecha, LocalDate desde, LocalDate hasta) {
        return !fecha.isBefore(desde) && !fecha.isAfter(hasta);
    }
}