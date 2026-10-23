package colectivos.modelo;

import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

public class Linea {
	
	// attributes
	private String codigo;
	private List<Parada> paradasIda;
	private List<Parada> paradasVuelta;
	private static int MAX_RECORRIDOS = 3;
	
	// constructor
	public Linea(String codigo) {
		this.codigo = codigo;
		this.paradasIda = new ArrayList<>();
		this.paradasVuelta = new ArrayList<>();
	}
	
	// getters and setters
	public String getCodigo() {
		return codigo;
	}
	
	public List<Parada> getParadasIda() {
		return paradasIda;
	}
	
	public List<Parada> getParadasVuelta(){
		return paradasVuelta;
	}
	
	public void agregarParadaIda(Parada paradaIda) {
		paradasIda.add(paradaIda);
	}
	
	public void agregarParadaVuelta(Parada paradaVuelta) {
		paradasVuelta.add(paradaVuelta);
	}
	
	public int getMaxRecorridos() {
		return MAX_RECORRIDOS;
	}
	
	@Override
	public String toString() {
		return "Línea " + codigo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Linea other = (Linea) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
}
