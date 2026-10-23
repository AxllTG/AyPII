package colectivos.aplicacion;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import colectivos.datos.CargarParametros;
import colectivos.datos.Datos;
import colectivos.interfaz.Interfaz;
import colectivos.logica.Calculo;
import colectivos.modelo.Linea;
import colectivos.modelo.Parada;
import excepciones.SimulationErrorException;
import net.datastructures.TreeMap;

public class Aplicacion {

	public static void main(String[] args) throws SimulationErrorException{
		
		try {
			// loads parameters and files
			CargarParametros.parametros();
			String archivoLinea = CargarParametros.getArchivoLinea();
			String archivoParada = CargarParametros.getArchivoParada();
			int cantidadPasajeros = CargarParametros.getCantidadPasajeros();
			int capacidadSentados = CargarParametros.getCapacidadSentados();
			int capacidadParados = CargarParametros.getCapacidadParados();
			
			InputStream inputLinea = CargarParametros.class.getClassLoader().getResourceAsStream(archivoLinea);
			InputStream inputParada = CargarParametros.class.getClassLoader().getResourceAsStream(archivoParada);
			
			if (inputLinea == null) 
			    throw new FileNotFoundException("No se encontró el archivo linea.txt");
			
			if (inputParada == null)
				throw new FileNotFoundException("No se encontró el archivo parada.txt");
			
			// loads structures
			TreeMap<Integer, Parada> paradas = Datos.cargarParadas(inputParada);
			TreeMap<String, Linea> lineas = Datos.cargarLineas(inputLinea, paradas);
			Datos.cargarRuta(inputLinea, lineas, paradas);
			
			// simulation begins
			Calculo calculo = new Calculo(lineas, paradas, capacidadSentados, capacidadParados);
			Scanner scanner = new Scanner(System.in);
			boolean seguir = true;
			
			Interfaz interfaz = null;
			while(seguir) {
				int opcion = Interfaz.iniciar();
				switch(opcion) {
					case 1: 
						calculo.iniciarSimulacion(cantidadPasajeros);
						interfaz = new Interfaz(lineas);
						break;
					case 2:
						System.out.println("Ingrese código de parada de origen:");
						int origen = scanner.nextInt();
						System.out.println("Ingrese código de parada de destino:");
						int destino = scanner.nextInt();
						if (interfaz == null) 
							interfaz = new Interfaz(lineas);
						interfaz.ingresarParada(origen, destino, lineas, paradas);
						break;
					case 0:
						System.out.println("Programa ha finalizado.");
						seguir = false;
						break;
					default:
						System.out.println("Opción no válida, intente nuevamente.");
						break;
				}
			}
			scanner.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new SimulationErrorException("Error al iniciar la simulación.");
		}
		
	}
	
}
