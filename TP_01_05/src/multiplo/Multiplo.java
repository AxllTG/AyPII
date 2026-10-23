package multiplo;

import java.text.BreakIterator;
import java.util.Scanner;

public class Multiplo {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int num1;
		int num2;
		
		System.out.println("Ingresar numero: ");
		num1 = input.nextInt();
		
		System.out.println("Ingresar Segundo numero: ");
		num2 = input.nextInt();
		
		if(num1 % num2 == 0) {
				System.out.printf("%d es multiplo de %d",num1,num2);
		}else {
			System.out.println("");  
		}
		
		
		
	}

}
