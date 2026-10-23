package colectivos.datos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

public class CargarParametros {

	private static String archivoLinea;
	private static String archivoParada;
	private static int cantidadPasajeros;
	private static int capacidadSentados;
	private static int capacidadParados;
	
	public static void parametros() throws IOException{
		
		Properties properties = new Properties();
		InputStream input = CargarParametros.class.getClassLoader().getResourceAsStream("colectivos/config.properties");
		
		if(input == null) 
			throw new FileNotFoundException("No se encontró el archivo config.properties");
		
		properties.load(input); // loads properties file
		
		archivoLinea = "colectivos/" + properties.getProperty("linea");
		archivoParada = "colectivos/" + properties.getProperty("parada");
		
		String pasajerosString = properties.getProperty("cantidadPasajeros");
		String sentadosString = properties.getProperty("capacidadSentados");
		String paradosString = properties.getProperty("capacidadParados");
		
		if(pasajerosString != null) {
			try {
				cantidadPasajeros = Integer.parseInt(pasajerosString);
			}catch(NumberFormatException e) {
				cantidadPasajeros = 0; // default value
				System.err.println("Se produjo un error leyendo cantidadPasajeros, valor default: 0.");
			}
		}else {
			throw new IllegalArgumentException("Propiedad para 'cantidadPasajeros' no encontrada.");
		}
		
		try {
			capacidadSentados = Integer.parseInt(sentadosString);
		}catch(NumberFormatException e) {
			capacidadSentados = 40;
			System.err.println("Se produjo un error leyendo cantidadPasajeros, valor default: 40");
		}
		
		try {
			capacidadParados = Integer.parseInt(paradosString);
		}catch(NumberFormatException e) {
			capacidadParados = 10;
			System.err.println("Se produjo un error leyendo cantidadPasajeros, valor default: 10");
		}
		
	}
	
	public static String getArchivoLinea() {
		return archivoLinea;
	}
	
	public static String getArchivoParada() {
		return archivoParada;
	}
	
	public static int getCantidadPasajeros() {
		return cantidadPasajeros;
	}
	
	public static int getCapacidadSentados() {
		return capacidadSentados;
	}
	
	public static int getCapacidadParados() {
		return capacidadParados;
	}
	
}
