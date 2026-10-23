package convertidor;

import java.util.Scanner;

public class Celsius {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		float celsius;
		double conversion;
		int conversionEntera;

		System.out.println("ingrese el valor que desea convertir de Celsius a Fahrenheit");
		celsius = enter.nextFloat();

		conversion = (celsius * 1.8) + 32;
		conversionEntera = (int) conversion;

		System.out.println(String.format("El valor de %f Celsius a Fahrenheit es %f", celsius, conversion));

		System.out.println("El valor de Fahrenheit sin decimales es : " + conversionEntera);

		enter.close();
	}

}
