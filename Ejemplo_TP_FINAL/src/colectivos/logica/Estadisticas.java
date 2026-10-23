package colectivos.logica;

import java.util.List;
import colectivos.modelo.Colectivo;
import colectivos.modelo.Parada;
import colectivos.modelo.Pasajero;
import net.datastructures.ArrayList;

public class Estadisticas {
	
	/**
	 * Calculates the individual satisfaction of each passenger
	 * with the service.
	 * @param pasajero   a passenger.
	 * @return an integer rating from 1 to 5.
	 * @throws IllegalArgumentException if the passenger is null.
	 * */
	public int calificacionPasajeros(Pasajero pasajero) {
		
		//if (pasajero == null)
		  //  throw new IllegalArgumentException("El pasajero no puede ser nulo.");
		
		if(pasajero.pudoSubir()) {
			switch(pasajero.getIntentosFallidos()) {
				case 0:
					if(pasajero.consiguioAsiento()) 
						return 5;
					else
						return 4;
				case 1:
					return 3;
				default:
					return 2;
			}
		}else {
			return 1;
		}
	}
	
	/**
	 * Calculates the satisfaction index based on the passengers ratings.
	 * @param pasajeros          an ArrayList with all the passengers.
	 * @param cantidadPasajeros  amount of passengers in total.
	 * @return the index of satisfaction
	 * @throws IllegalArgumentException if the passenger is null.
	 * */
	public double indiceSatisfaccion(ArrayList<Pasajero> pasajeros, int cantidadPasajeros) {
		if (pasajeros == null || pasajeros.isEmpty())
           throw new IllegalArgumentException("La lista de pasajeros no puede ser nula.");
      
		int sumaCalificaciones = 0;
		int calificacionMax = 5;
		
		for(Pasajero p : pasajeros)
			sumaCalificaciones += calificacionPasajeros(p);
		
		return (double) sumaCalificaciones / (cantidadPasajeros * calificacionMax);
	}
	
	/**
	 * Generates a summary of service ratings given by passengers.
	 * @param pasajeros an ArrayList with all the passengers.
	 * @return a string with the amount of passengers that gave 1-5 stars
	 * to the service.
	 * */
	public String calificacionesTotales(ArrayList<Pasajero> pasajeros) {
		
		int count[] = new int[6];
		
		for(Pasajero p : pasajeros) {
			int calificaciones = calificacionPasajeros(p);
			count[calificaciones]++;
		}
		
		StringBuilder total = new StringBuilder();
		for(int i = 5; i >= 1; i--)
			total.append(String.format("• %d pasajeros calificaron con %d el servicio.\n", count[i], i));
		
		return total.toString();
	}
	
	/**
	 * Calculates the average occupancy of a bus in its current route.
	 * @param colectivo  the bus
	 * @return a double with the percentage of the average occupancy.
	 * */
	public double ocupacionPromedio(Colectivo colectivo, int pasajerosABordoTotal) {
		
		List<Parada> paradas = colectivo.getRecorridoActual();
		int capacidadTotal = colectivo.getCapacidadParados() + colectivo.getCapacidadSentados();
		
		if(paradas == null || paradas.size() < 2 || capacidadTotal == 0)  // needs at least two stops
			return 0.0;
		
		colectivo.getTodosLosPasajeros();
		int totalParadas = paradas.size();
		
		return ((double) pasajerosABordoTotal / capacidadTotal) / totalParadas;
	}
	
}
