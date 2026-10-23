package division;

import java.util.Scanner;

public class Division {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double number1;
		double number2;
		double div;
		
		System.out.println("Ingrese el primer numero: ");
		number1 = input.nextDouble();
		
		System.out.println("Ingrese el segundo numero: ");
		number2 = input.nextDouble();
		
		div = number1 / number2;
		
		System.out.printf("el cociente es: %2.5f",div);
	}

}
