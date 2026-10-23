package calificaciones;

public class LibroDeCalificaciones {
	private String nombreDelCurso;// nombre del curso para este LibroDeCalificaciones

	public LibroDeCalificaciones (String nombre) {
		nombreDelCurso = nombre;
	}
	
	// metodo para establecer el nombre del curso
	public void setNombreDelCurso(String nombre) {
		nombreDelCurso = nombre;
	}// fin del metodo setNombreDelCurso
	
	
	// metodo para obtener el nombre del curso
	public String getNombreDelCurso() {
		return nombreDelCurso;
	}// fin del metodo getNombreDelCurso



	// muestra el mensaje de bienvenida al usuario de LibroDeCalificaciones
	public void mostrarMensaje() {
		/*
		 * esta instruccion llama a getNombreDelCurso para obtener el nombre del curso
		 * que representa es libroDeCalificaciones
		 */
		System.out.printf("Bienvenido al Libro de calificaciones para \n%s!\n",
				getNombreDelCurso());
	}// fin del método mostrarMensaje

}// fin de la clase LibroDeCalificaciones
