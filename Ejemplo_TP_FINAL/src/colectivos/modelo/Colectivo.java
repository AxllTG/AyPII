package colectivos.modelo;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class Colectivo {
	
	// attributes
	private int id;
	private Linea linea;
	private ArrayList<Pasajero> pasajerosSentados;
	private ArrayList<Pasajero> pasajerosParados;
	private List<Pasajero> pasajerosHistoricos = new ArrayList<>();
	private boolean esIda;
	private final int capacidadSentados;
	private final int capacidadParados;
	
	// constructor
	public Colectivo(int id, Linea linea, int capacidadSentados, int capacidadParados, boolean empiezaEnVuelta) {
		if(linea == null)
			throw new IllegalArgumentException("La línea no puede ser nula.");
		this.id = id;
		this.linea = linea;
		this.capacidadSentados = capacidadSentados;
		this.capacidadParados = capacidadParados;
		this.pasajerosSentados = new ArrayList<>();
		this.pasajerosParados = new ArrayList<>();
		this.esIda = !empiezaEnVuelta;
	}
	
	// getters and setters
	public int getId() {
		return id;
	}
	
	public Linea getLinea() {
		return linea;
	}
	
	public int getCapacidadSentados() {
		return capacidadSentados;
	}
	
	public int getCapacidadParados() {
		return capacidadParados;
	}
	
	public ArrayList<Pasajero> getPasajerosSentados() {
		return pasajerosSentados;
	}
	
	public ArrayList<Pasajero> getPasajerosParados(){
		return pasajerosParados;
	}
	
	public List<Pasajero> getPasajerosHistoricos() {
	    return pasajerosHistoricos;
	}
	
	/**
	 * Returns every passenger currently on the bus,
	 * both standing and seating.
	 * @return todos  a list with every passenger currently 
	 * on the bus.
	 * */
	public List<Pasajero> getTodosLosPasajeros(){
		List<Pasajero> todos = new ArrayList<>(pasajerosSentados.size() + pasajerosParados.size());
		
		for(int i = 0; i < pasajerosSentados.size(); i++)
			todos.add(i, pasajerosSentados.get(i));
		
		for(int i = 0; i < pasajerosParados.size(); i++)
			todos.add(i, pasajerosParados.get(i));
		
		return todos;
	}
	
	/**
	 * Removes a passenger from the bus.
	 * @param pasajero the passenger to be removed
	 * */
	public void removePasajeroABordo(Pasajero pasajero) {
		
		for(int i = 0; i < pasajerosSentados.size(); i++) {
			if(pasajerosSentados.get(i).equals(pasajero)) {
				pasajerosSentados.remove(i);
				pasajero.setColectivo(null);
				return;
			}
		}
		for(int i = 0; i < pasajerosParados.size(); i++) {
			if(pasajerosParados.get(i).equals(pasajero)) {
				pasajerosParados.remove(i);
				pasajero.setColectivo(null);
				return;
			}
		}
	}
	
	public List<Parada> getRecorridoActual(){
		if (esIda) 
	        return linea.getParadasIda();
	    else
	        return linea.getParadasVuelta();
	}
	
	public boolean isEsIda() {
		return esIda;
	}
	
	@Override
	public String toString() {
		return "Colectivo [id=" + id + ", línea=" + linea + ", es ida=" + esIda + ", pasajeros a bordo=" + pasajerosSentados + ", " + pasajerosParados + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, linea);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colectivo other = (Colectivo) obj;
		return id == other.id && Objects.equals(linea, other.linea);
	}
	
}
