package colectivos.interfaz;

import java.util.List;
import java.util.Scanner;
import colectivos.modelo.Colectivo;
import colectivos.modelo.Linea;
import colectivos.modelo.Parada;
import net.datastructures.TreeMap;

public class Interfaz {
	
	// attributes
	private TreeMap<String, Linea> lineas;
	private static Scanner scanner = new Scanner(System.in);
	
	// constructor
	public Interfaz(TreeMap<String, Linea> lineas) {
		super();
		this.lineas = lineas;
	}
	
	/**
	 * Displays the main menu with all the initial options
	 * the simulation offers.
	 * @return the user's selected option as an integer.
	 * */
	public static int iniciar() {
		System.out.println("INGRESE UNA OPCIÓN:");
		System.out.println("1 - Simular recorrido");
		System.out.println("2 - Ingresar parada de origen y destino");
		System.out.println("0 - Salir");
		return scanner.nextInt();
	}
	
	/**
	 * Validates whether a given pair of stop ids represents a valid route.
	 * It checks that both the origin and destination stops exist,
	 * that they belong to an existing line, and that the destination stop
	 * is always after the origin stop.
	 * @param codigoOrigen  the code of the origin stop entered by the user
	 * @param codigoDestino the code of the destination stop entered by the user
	 * @param lineas        a map containing all available bus lines
	 * @param paradas       a map containing all available stops
	 * @return true if it defines a valid route, false otherwise.
	 * */
	public boolean ingresarParada(int codigoOrigen, int codigoDestino, TreeMap<String, Linea> lineas, TreeMap<Integer, Parada> paradas) {
		Parada origen = paradas.get(codigoOrigen);
		Parada destino = paradas.get(codigoDestino);
		if(origen == null || destino == null) {
			System.out.println("Una de las paradas no existe.");
			return false;
		}
		if(!estanEnMismaLinea(origen, destino)) {
			System.out.println("Las paradas no están en la misma línea.");
			return false;
		}
		if(!ordenCorrecto(origen, destino)) {
			System.out.println("El orden de las paradas no es correcto.");
			return false;
		}
		
		System.out.println("Paradas válidas:\nOrigen = " + codigoOrigen + ", Destino = " + codigoDestino);
		System.out.println("La línea en la que debería viajar es la " + lineaCorrecta(origen, destino));
		return true;
	}
	
	/**
	 * Verifies if two stops (Paradas) are in the same line.
	 * @param a Origin stop
	 * @param b Destination stop
	 * @return true if both stops are in the same line, false if they're not
	 * */
	public boolean estanEnMismaLinea(Parada a, Parada b) {
		for(Linea l : lineas.values()) {
			List<Parada> ida = l.getParadasIda();
			List<Parada> vuelta = l.getParadasVuelta();
			
			boolean enIda = ida.contains(a) && ida.contains(b);
			boolean enVuelta = vuelta.contains(a) && vuelta.contains(b);
			
			if(enIda || enVuelta)
				return true;
		}
		return false;
	}
	
	/**
	 * Verifies if the two stops the user gave are in the correct order within the line.
	 * @param origen   Origin stop
	 * @param destino  Destination stop
	 * @return true if they're in the correct order, false if they're not.
	 * */
	public boolean ordenCorrecto(Parada origen, Parada destino) {
		for(Linea l : lineas.values()) {
			if(estanEnOrden(l.getParadasIda(), origen, destino) || estanEnOrden(l.getParadasVuelta(), origen, destino))
				return true;
		}
		return false;
	}
	
	/**
	 * Calculates the desired line that connects both stops.
	 * @param origen   origin stop.
	 * @param destino  destination stop.
	 * @return l       desired line, or null if it cannot find one.
	 * */
	public Linea lineaCorrecta(Parada origen, Parada destino) {
		for(Linea l : lineas.values()) {
			if(estanEnOrden(l.getParadasIda(), origen, destino) || estanEnOrden(l.getParadasVuelta(), origen, destino))
				return l;
		}
		return null;
	}
	
	/**
	 * Checks if both the origin and destination stops are part
	 * of the route, and if the origin stop appears before the
	 * destination stop in the list.
	 * @param recorrido  the list of stops
	 * @param origen     origin stop
	 * @param destino    destination stop
	 * @return true if both stops are in the route and in the correct order, false otherwise.
	 * */
	public boolean estanEnOrden(List<Parada> recorrido, Parada origen, Parada destino) {
		return recorrido.contains(origen) && recorrido.contains(destino) && recorrido.indexOf(origen) < recorrido.indexOf(destino);
	}
	
	/**
	 * Displays summary info for the current bus route.
	 * Shows which bus it is, the route number, direction, how
	 * many stops it has and how many passengers it can carry.
	 * @param colectivo    bus id
	 * @param numParadas   number of stops for each line
	 * @param numRecorrido route number
	 * */
	public static void imprimirInfoRecorrido(Colectivo colectivo, int numParadas, int numRecorrido) {
		String tipo = colectivo.isEsIda() ? "IDA" : "VUELTA";
		System.out.println("\n═══════════════════════════════════════════════════════════════");
		System.out.printf("COLECTIVO %d - RECORRIDO %d - LÍNEA %s (%s)\n", colectivo.getId(), numRecorrido, colectivo.getLinea().getCodigo(), tipo);
		System.out.printf("Paradas: %d | Capacidad: %d asientos + %d parados\n", numParadas, colectivo.getCapacidadSentados(), colectivo.getCapacidadParados());
		System.out.println("═══════════════════════════════════════════════════════════════");
	}
	
	/**
	 * Prints the information about each stop of the route,
	 * indicating the stop's id, the amount of passengers that
	 * got on or off the bus at said stop and the amount of
	 * passengers that are currently on the bus.
	 * @param idParada        stop id
	 * @param cantSuben       number of passengers that got on
	 * @param cantBajan       number of passengers that got off
	 * @param pasajerosABordo number of passengers on the bus
	 * */
	public static void imprimirInfoParadas(int idParada, int cantSuben, int cantBajan, int pasajerosABordo) {
		String paradaString = String.format("Parada %d:", idParada);		
		System.out.printf("%-11s ↑ Suben %-3d | ↓ Bajan %-3d | Ocupación actual %d/50\n", paradaString, cantSuben, cantBajan, pasajerosABordo);
	}
	
	/**
	 * Prints the summary of the route, showing the number of
	 * passengers that got on and off the bus in total, the max
	 * number of passengers that were on the bus at the same
	 * time, the average occupancy rate and the number of passengers
	 * that were on the bus in total.
	 * @param totalSuben             number of passengers that got on the bus
	 * @param totalBajan             number of passengers that got off the bus
	 * @param maxPasajerosABordo     number of max passengers transported in every stop
	 * @param ocupacion              average occupancy rate
	 * @param pasajerosTransportados number of passengers transported
	 * */
	public static void imprimirResumenRecorrido(int totalSuben, int totalBajan, int maxPasajerosABordo, double ocupacion, int pasajerosTransportados) {
		System.out.println("\n════════════════════ RESUMEN DEL RECORRIDO ════════════════════");
		System.out.printf("• Total que subieron: %-5d | • Total que bajaron: %-5d\n", totalSuben, totalBajan);
		System.out.printf("• Máximo de pasajeros a bordo en una parada: %d/50\n", maxPasajerosABordo);
		System.out.printf("• Ocupación promedio: %.2f%%\n", ocupacion * 100);
       System.out.println("• Pasajeros transportados: " + pasajerosTransportados);
		System.out.println("═══════════════════════════════════════════════════════════════\n");
	}
	
	/**
	 * Prints the statistics of the whole line, showing the 
	 * satisfaction index previously calculated.
	 * @param estadisticas        percentage calculated based on the satisfaction index
	 * @param estadisticasTotales String with all of the qualifications given by the passengers
	 * */
	public static void imprimirEstadisticas(double estadisticas, String estadisticasTotales) {
		System.out.println("\n═══════════════════ ÍNDICE DE SATISFACCIÓN ════════════════════");
		System.out.println(estadisticasTotales);
		System.out.printf("El índice de satisfacción es de %.2f%%", (estadisticas * 100));
		System.out.println("\n═══════════════════════════════════════════════════════════════\n");
	}
	
}
