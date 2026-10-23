package colectivos.logica;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import colectivos.interfaz.Interfaz;
import colectivos.modelo.Colectivo;
import colectivos.modelo.Linea;
import colectivos.modelo.Parada;
import colectivos.modelo.Pasajero;
import net.datastructures.ArrayList;
import net.datastructures.LinkedQueue;
import net.datastructures.TreeMap;

public class Calculo {
	
	// attributes
	private TreeMap<String, Linea> lineas;
	private TreeMap<Integer, Parada> paradas;
	private int capacidadSentados;
	private int capacidadParados;
	private Estadisticas estadisticas;
	
	// constructor
	public Calculo(TreeMap<String, Linea> lineas, TreeMap<Integer, Parada> paradas, int capacidadSentados, int capacidadParados) {
		this.lineas = lineas;
		this.paradas = paradas;
		this.capacidadSentados = capacidadSentados;
		this.capacidadParados = capacidadParados;
		this.estadisticas = new Estadisticas();
	}
	
	/**
	 * Simulates the route of the bus along its line of stops.
	 * At each stop:
	 * 	- Passengers whose destination is the current stop get off the bus.
	 * 	- Waiting passengers at the stop get on the bus (is there is space).
	 * @param colectivo  The bus that performs the route.
	 * */
	public int[] recorrido(Colectivo colectivo, int numRecorrido) {
		
		Linea linea = colectivo.getLinea(); // obtains bus' line
		List<Parada> recorrido = colectivo.getRecorridoActual();
		List<Pasajero> pasajerosColectivo = colectivo.getTodosLosPasajeros();
		int cantSuben = 0, cantBajan = 0; // amount of passengers that get on/off the bus
		
		int totalSuben = 0, totalBajan = 0, maxPasajerosABordo = 0, pasajerosABordo = 0, pasajerosABordoTotal = 0; // statistics
		int numParadas = recorrido.size();
		
		Interfaz.imprimirInfoRecorrido(colectivo, numParadas, numRecorrido);
		
		for(Parada parada : recorrido) {
			int idParada = parada.getId();
			
			cantBajan = bajada(parada, colectivo, cantBajan, pasajerosColectivo);
			
			cantSuben = subida(parada, colectivo, linea, pasajerosColectivo, cantSuben);
			
			totalSuben += cantSuben;
			totalBajan += cantBajan;
			
			pasajerosABordo = colectivo.getPasajerosSentados().size() + colectivo.getPasajerosParados().size();
			
			pasajerosABordoTotal += pasajerosABordo;
			
			if(pasajerosABordo > maxPasajerosABordo)
				maxPasajerosABordo = pasajerosABordo;
			
			Interfaz.imprimirInfoParadas(idParada, cantSuben, cantBajan, pasajerosABordo);
			
			cantSuben = 0; // resets values for next stop
			cantBajan = 0;
		}
		return new int[] {totalSuben, totalBajan, maxPasajerosABordo, pasajerosABordoTotal};
	}
	
	/**
	 * Calculates the passengers that get on the bus at any given stop.
	 * @param parada             the specific stop in which they might get on the bus.
	 * @param colectivo          the bus they get on.
	 * @param linea              the specific line the passengers need to take.
	 * @param pasajerosColectivo list with all the passengers.
	 * @param cantSuben          amount of passengers that get on the bus.
	 * @return an integer with the amount of passengers that got on the bus.
	 * */
	public int subida(Parada parada, Colectivo colectivo, Linea linea, List<Pasajero> pasajerosColectivo, int cantSuben) {
		LinkedQueue<Pasajero> filaPasajeros = parada.getPasajerosEsperando();
		LinkedQueue<Pasajero> nuevaFila = new LinkedQueue<>(); // list with all the passengers that are still waiting because the current stop is not theirs
		LinkedQueue<Pasajero> noPudieronSubir = new LinkedQueue<>();
	
		while(!filaPasajeros.isEmpty()) {
			Pasajero p = filaPasajeros.dequeue();
			
			if(p.getParadaActual().equals(parada) && p.getLineaDeseada().equals(linea)) { // if the current stop is the passenger's current stop, adds it
				
				p.setSubio(true);
				if(colectivo.getPasajerosSentados().size() < capacidadSentados) {
					
					colectivo.getPasajerosSentados().add(p);
					p.setColectivo(colectivo);
					pasajerosColectivo.add(p);
					colectivo.getPasajerosHistoricos().add(p);
					p.setConsiguioAsiento(true);
					cantSuben++;
				}else if(colectivo.getPasajerosParados().size() < capacidadParados) {
					
					colectivo.getPasajerosParados().add(p);
					p.setColectivo(colectivo);
					pasajerosColectivo.add(p);
					colectivo.getPasajerosHistoricos().add(p);
					p.setConsiguioAsiento(false);
					cantSuben++;
				}else {
					noPudieronSubir.enqueue(p);
					p.registrarIntentoFallido();
					p.setSubio(false);
				}
				
			}else {
				nuevaFila.enqueue(p); // the current stop does not correspond with this passenger
			}
		}
		while(!noPudieronSubir.isEmpty())
			nuevaFila.enqueue(noPudieronSubir.dequeue());
		
		parada.setPasajerosEsperando(nuevaFila); // updates the queue with the passengers that didn't get on the bus
		
		return cantSuben;
	}
	
	/**
	 * Calculates the passengers that get off the bus at any given stop.
	 * @param parada             the specific stop in which they might get off the bus.
	 * @param colectivo          the bus the passengers are currently in.
	 * @param cantBajan          variable that stores the amount of passengers that get off the bus.
	 * @param pasajerosColectivo list with all the passengers.
	 * @return an integer with the amount of passengers that got off the bus.
	 * */
	public int bajada(Parada parada, Colectivo colectivo, int cantBajan, List<Pasajero> pasajerosColectivo) {
		
		Iterator<Pasajero> pasajerosSentados = colectivo.getPasajerosSentados().iterator();
		while(pasajerosSentados.hasNext()) {
			Pasajero p = pasajerosSentados.next();	
			if(p.getDestino().equals(parada)) { // if the current stop is the passenger's destination, removes it
				pasajerosSentados.remove();
				colectivo.removePasajeroABordo(p);
				cantBajan++;
			}
		}
		
		Iterator<Pasajero> pasajerosParados = colectivo.getPasajerosParados().iterator();
		while(pasajerosParados.hasNext()) {
			Pasajero p = pasajerosParados.next();	
			if(p.getDestino().equals(parada)) { // if the current stop is the passenger's destination, removes it
				pasajerosParados.remove();
				colectivo.removePasajeroABordo(p);
				cantBajan++;
			}
		}
		return cantBajan;
	}
	
	/**
	 * Generates a given number of passengers with random origin and destination stops.
	 * The destination stop is always located after the origin stop in the route,
	 * ensuring that the passenger travels forward along the line.
	 * Each passenger is assigned a unique ID starting from 1.
	 * @param cantidadTotal  The total number of passengers to generate.
	 * @param pasajeros      The queue where the generated passengers will be added.
	 * */
	public void generarPasajeros(int cantidadTotal, ArrayList<Pasajero> pasajeros) {
		
		Random rand = new Random();
		
		ArrayList<Parada> listaParadas = new ArrayList<>();
		int index = 0;
		for(Parada p : paradas.values()) {
			listaParadas.add(index, p);
			index++;
		}
		
		for(int i = 0; i < cantidadTotal; i++) {
			Parada origen, destino;
			Linea lineaElegida = null;
			
			do {
				origen = listaParadas.get(rand.nextInt(listaParadas.size()));
				destino = listaParadas.get(rand.nextInt(listaParadas.size()));
				
				while(destino.equals(origen))
					destino = listaParadas.get(rand.nextInt(listaParadas.size()));
				
				for(Linea linea : lineas.values()) {
					if(conecta(linea.getParadasIda(), origen, destino) || conecta(linea.getParadasVuelta(), origen, destino)) {
						lineaElegida = linea;
						break;
					}
				}
				
			}while(lineaElegida == null);
			
			Pasajero pasajero = new Pasajero(i + 1, origen, destino);
			pasajeros.add(i, pasajero);
			pasajero.setLineaDeseada(lineaElegida);
		}
	}
	
	/**
	 * Checks if a given route connects the specified origin and destination stops
	 * in the correct order.
	 * @param recorrido  list with all stops
	 * @param origen     origin stop
	 * @param destino    destination stop
	 * @return true if there is a line that connects them, false if there's not
	 * */
	private boolean conecta(List<Parada> recorrido, Parada origen, Parada destino) {
		
		int indexOrigen = recorrido.indexOf(origen);
		int indexDestino = recorrido.indexOf(destino);
		
		return indexOrigen >= 0 && indexDestino > indexOrigen;
	}
	
	/**
	 * Starts the simulation by generating passengers, assigning them to their
	 * corresponding stops and running a bus (Colectivo) through each line.
	 * @param cantidadPasajeros Max of passengers generated in the entire simulation.
	 * */
	public void iniciarSimulacion(int cantidadPasajeros){
		
		ArrayList<Pasajero> pasajerosEsperando = new ArrayList<>();
		ArrayList<Parada> paradasLista = new ArrayList<>();
		int index = 0;
		
		for(Parada p : paradas.values()) { // adds every stop to the list
			paradasLista.add(index, p);
			index++;
		}
			
		generarPasajeros(cantidadPasajeros, pasajerosEsperando);
			
		for(Pasajero p : pasajerosEsperando) {
			Parada paradaOrigen = p.getParadaActual();
			paradaOrigen.getPasajerosEsperando().enqueue(p); // adds each passenger to their corresponding stop
		}
			
		int idColectivo;
		int numRecorrido;
		for(Linea linea : lineas.values()) {
			for(int i = 0; i < linea.getMaxRecorridos(); i++) {
				
				numRecorrido = i + 1;
				idColectivo = numRecorrido;
				
				if(linea.getCodigo().endsWith("I")){
					
					Colectivo colectivoIda = new Colectivo(idColectivo, linea, capacidadSentados, capacidadParados, false);
					int datos[] = recorrido(colectivoIda, numRecorrido);
					double ocupacion = estadisticas.ocupacionPromedio(colectivoIda, datos[3]);
					int pasajerosTransportados = colectivoIda.getPasajerosHistoricos().size();
					
					Interfaz.imprimirResumenRecorrido(datos[0], datos[1], datos[2], ocupacion, pasajerosTransportados);	
				}
				
				if(linea.getCodigo().endsWith("R")) {
					
					Colectivo colectivoVuelta = new Colectivo(idColectivo, linea, capacidadSentados, capacidadParados, true);
					int datos[] = recorrido(colectivoVuelta, numRecorrido);
					double ocupacion = estadisticas.ocupacionPromedio(colectivoVuelta, datos[3]);
					
					int pasajerosTransportados = colectivoVuelta.getPasajerosHistoricos().size();
					
					Interfaz.imprimirResumenRecorrido(datos[0], datos[1], datos[2], ocupacion, pasajerosTransportados);	
				}
			}
		}
		double stats = estadisticas.indiceSatisfaccion(pasajerosEsperando, cantidadPasajeros);
		String statsTotales = estadisticas.calificacionesTotales(pasajerosEsperando);
		
		Interfaz.imprimirEstadisticas(stats, statsTotales);
		
	}
	
}
