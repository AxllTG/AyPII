package producto;

import java.util.Scanner;

public class Producto {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int number1;
		int number2;
		int product;
		
		System.out.println("Ingrese el primer numero: ");
		number1 = input.nextInt();
		
		System.out.println("Ingrese el segundo numero: ");
		number2 = input.nextInt();
		
		product = number1 * number2;
		
		System.out.printf("el producto es: %d",product);
	}

}
