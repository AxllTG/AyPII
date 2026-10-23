package colectivos.modelo;

import java.util.Objects;

public class Pasajero {

	// attributes
	private int id;
	private Parada paradaActual;
	private Parada destino;
	private Colectivo colectivo;
	private Linea lineaDeseada;
	private boolean subio;
	private boolean consiguioAsiento;
	private int intentosFallidos;
	
	// constructor
	public Pasajero(int id, Parada paradaActual, Parada destino) {

		this.id = id;
		this.paradaActual = paradaActual;
		this.destino = destino;
		this.colectivo = null; // not in a bus yet
		this.subio = false;	
		this.consiguioAsiento = false;
		this.intentosFallidos = 0;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public Parada getParadaActual() {
		return paradaActual;
	}

	public Parada getDestino() {
		return destino;
	}

	public Colectivo getColectivo() {
		return colectivo;
	}

	public void setColectivo(Colectivo colectivo) {
		this.colectivo = colectivo;
	}
	
	public Linea getLineaDeseada() {
		return lineaDeseada;
	}
	
	public void setLineaDeseada(Linea lineaDeseada) {
		this.lineaDeseada = lineaDeseada;
	}
	
	public boolean pudoSubir() {
		return subio;
	}
	
	public void setSubio(boolean subio) {
		this.subio = subio;
	}
	
	public boolean consiguioAsiento() {
		return consiguioAsiento;
	}
	
	public void setConsiguioAsiento(boolean consiguioAsiento) {
		this.consiguioAsiento = consiguioAsiento;
	}
	
	public int getIntentosFallidos() {
		return intentosFallidos;
	}

	/**
	 * Registers a passenger's failed attempt to get 
	 * on the bus to easily calculate the satisfaction 
	 * index later on.
	 * */
	public void registrarIntentoFallido() {
        this.intentosFallidos++;
    }
	
	@Override
	public String toString() {
		return "Pasajero [id=" + id + ", paradaActual=" + paradaActual + ", destino=" + destino + ", colectivo="
				+ colectivo + ", lineaDeseada=" + lineaDeseada + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(colectivo, destino, id, paradaActual);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasajero other = (Pasajero) obj;
		return Objects.equals(destino, other.destino) && id == other.id;
	}
	
}
