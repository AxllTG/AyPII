package histograma;

import java.util.Iterator;
import java.util.Scanner;

public class Histrograma {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] numeros = new int[5];

		System.out.println("=== HISTOGRAMA HORIZONTAL ===\n");

		// Leer los 5 números
		for (int i = 0; i < numeros.length; i++) {
			do {
				System.out.println(" Ingrese el numero " + (i + 1) + " (entre 1 y 30: ");
				numeros[i] = input.nextInt();

				if (numeros[i] < 1 || numeros[i] > 30) {
					System.out.println("Error:  El número debe estar entre 1 y 30");
				}

			} while (numeros[i] < 1 || numeros[i] > 30);
		}
		System.out.println("\n=== HISTOGRAMA ===\n");
		// dibujar histograma
		for (int i = 0; i < numeros.length; i++) {
			System.out.printf("%2d | ", numeros[i]);// Muestra el valor del número

			// Imprimir los asteriscos
			for (int j = 0; j < numeros.length; j++) {
				System.out.println("*");
			}
			System.out.println();// Nueva línea para el siguiente número
		}

		input.close();
	}

}
