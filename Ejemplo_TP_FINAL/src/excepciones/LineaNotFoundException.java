package excepciones;

public class LineaNotFoundException extends Exception{

	public LineaNotFoundException(String linea) {
		super("Línea no encontrada: " + linea);
	}
	
}
