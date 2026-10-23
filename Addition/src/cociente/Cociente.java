package cociente;

import java.util.Scanner;

class Cociente {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double number1;
		double number2;
		double cociente;
		
		System.out.println("Ingrese el primer numero: ");
		number1 = input.nextDouble();
		
		System.out.println("Ingrese el segundo numero: ");
		number2 = input.nextDouble();
		
		cociente = number1 % number2;
		
		System.out.printf("el cociente es: %2f",cociente);
		
	}

}
