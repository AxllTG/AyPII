	package colectivos.modelo;

import java.util.Objects;

import net.datastructures.LinkedQueue;

public class Parada {

	// attributes
	private int id;
	private String direccion;
	private LinkedQueue<Pasajero> pasajerosEsperando;
	
	// constructor
	public Parada(int id, String direccion) {
		this.id = id;
		this.direccion = direccion;
		this.pasajerosEsperando = new LinkedQueue<>();
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public String getDireccion() {
		return direccion;
	}

	public LinkedQueue<Pasajero> getPasajerosEsperando(){
		return pasajerosEsperando;
	}
	
	public void setPasajerosEsperando(LinkedQueue<Pasajero> pasajerosEsperando) {
		this.pasajerosEsperando = pasajerosEsperando;
	}
	
	@Override
	public String toString() {
		return "Parada [id=" + id + ", dirección=" + direccion + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parada other = (Parada) obj;
		return this.id == other.id;
	}
	
}
