package resta;

import java.util.Scanner;

public class Resta {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int number1;
		int number2;
		int resta;
		
		System.out.println("Escriba el primer numero: ");
		number1 = input.nextInt();
		
		System.out.println("Escriba el segundo numero: ");
		number2 = input.nextInt();
		
		resta = number1 - number2;
		
		System.out.printf("La resta es: %d\n",resta);
	}

}
