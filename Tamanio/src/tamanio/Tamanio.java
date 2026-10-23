package tamanio;

import java.util.Random;

public class Tamanio {

	public static void main(String[] args) {
		Random random = new Random(); // crea un objeto de clase Random de referencia llamada random

		//inicializamos variables
		int numero;
		int mayor = 0;
		int menor = 0;

		//imprimimos y clasifacamos los 10 numeros randoms
		for (int i = 1; i < 10; i++) {
			numero = random.nextInt(100);

			System.out.println(" Numero " + i + ": " + numero);

			if (i == 1) {
				mayor = numero;
				menor = numero;
			} else {
				if (numero > mayor) {
					mayor = numero;
				}
				if (numero < menor) {
					menor = numero;
				}
			}

		}

		System.out.println("\n El numero mayor es: " + mayor);
		System.out.println("\n El numero menor es: " + menor);

	}

}
