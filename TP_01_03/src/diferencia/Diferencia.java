package diferencia;

import java.util.Scanner;

public class Diferencia {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
				
		int num1;
		int num2;
		System.out.println("Escriba el primer numero: ");
		num1 = input.nextInt();

		System.out.println("Escriba el segundo numero numero: ");
		num2 = input.nextInt();

		if (num1 > num2) {
			System.out.printf("%d ES MAS GRANDE",num1);
		}
	
		if(num1 < num2) {
			System.out.printf("%d ES MAS GRANDE",num2);
		}
		
		if(num1 == num2){
			System.out.println("SON IGUALES");
		}
	
	}
}
