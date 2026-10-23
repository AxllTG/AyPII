package suma;

import java.util.Scanner;

public class Addition {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		int number1;
		int number2;
		int sum;
		
		System.out.println("Ingrese el primer numero: ");
		number1 = input.nextInt();
		
		System.out.println("Ingrese el primer numero: ");
		number2 = input.nextInt();
		
		sum = number1 + number2;
		
		System.out.printf("suma es %d", sum);
	}

}
