package calificaciones;

public class TestLibroDeCalificaciones {
//el metodo main empieza la ejecucion del programa
	public static void main(String[] args) {
		// crea objeto libroDeCalificaciones
		LibroDeCalificaciones libroDeCalificaciones = new LibroDeCalificaciones(
				"CS101 Introduccion a la programacion en Java");
		LibroDeCalificaciones libroDeCalificaciones2 = new LibroDeCalificaciones(
				"CS102 Introduccion a la programacion en Java");

		// muestra el valor inicial de nombreDelCurso para cada libroDeCalificaciones.
		System.out.printf("El nombre del curso de libroDeCalificaciones es: %s\n\n",
				libroDeCalificaciones.getNombreDelCurso());
		System.out.printf("El nombre del curso de libroDeCalificaciones2 es: %s\n",
				libroDeCalificaciones2.getNombreDelCurso());
	}// fin del main

} // fin de la clase TestLibroDeCalificaciones
