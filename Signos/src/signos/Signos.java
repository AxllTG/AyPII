package signos;

import java.util.Random;

public class Signos {

	public static void main(String[] args) {
		Random random = new Random(); // crea un objeto de la clase Random y lo guarda en random.
		double[] numeros = new double[10]; // crea un arry de double con 10 elementos.

		System.out.println("Los 10 numeros generado: ");
		for (int i = 0; i < numeros.length; i++) { // llama a un "for" que recorre el tamanio del arreglo.
			numeros[i] = random.nextDouble() * 200 - 100; // asigna un numero random en cada casilla del arreglo entrenumero desde el -100 y 100
		}
		System.out.println("\n");

		// inicializa los contadores de positivos, negativos y ceros.
		int positivos = 0;
		int negativos = 0;
		int ceros = 0;
		// clasifica la cantidad de numeros negativos y positivos.
		for (double num : numeros) {
			if (num > 0)
				positivos++;
			else if (num < 0)
				negativos++;
			else
				ceros++;
		}

		System.out.println("Positivos: " + positivos);

		System.out.println("Negativos: " + negativos);

		System.out.println("Ceros: " + ceros);
	}
}