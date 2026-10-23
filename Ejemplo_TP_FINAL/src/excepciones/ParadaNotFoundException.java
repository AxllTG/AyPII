package excepciones;

public class ParadaNotFoundException extends Exception{

	public ParadaNotFoundException(int idParada) {
		super("Parada no encontrada: " + idParada);
	}
	
}
