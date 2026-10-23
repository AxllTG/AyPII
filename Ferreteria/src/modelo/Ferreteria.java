package modelo;

import java.util.Arrays;

public class Ferreteria {
	private String nombre;
	private Cliente clientes;
	private Factura facturas[];
	private Stock articulos[];
	
	
	public Ferreteria(String nombre, Factura[] facturas, Stock[] articulos, Cliente clientes) {
		super();
		this.nombre = nombre;
		this.facturas = facturas;
		this.articulos = articulos;
		this.clientes = clientes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Factura[] getFacturas() {
		return facturas;
	}
	public void setFacturas(Factura[] facturas) {
		this.facturas = facturas;
	}
	public Stock[] getArticulos() {
		return articulos;
	}
	public void setArticulos(Stock[] articulos) {
		this.articulos = articulos;
	}
	
	public Cliente getClientes() {
		return clientes;
	}
	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(facturas);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ferreteria other = (Ferreteria) obj;
		return Arrays.equals(facturas, other.facturas);
	}
	@Override
	public String toString() {
		return "Ferreteria [nombre=" + nombre + ", clientes=" + clientes + ", facturas=" + Arrays.toString(facturas)
				+ ", articulos=" + Arrays.toString(articulos) + "]";
	}

	
	
}
