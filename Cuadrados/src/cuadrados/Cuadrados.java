package cuadrados;

import java.util.Random;

public class Cuadrados {
	public static void main(String[] args) {
		Random numerosAleatorios = new Random();
		for (int i = 0; i < 11; i++) {
			int cuadrado = i * i;

			System.out.println("El cuadrado de " + i + " es: " + cuadrado);
		}

	}

}
