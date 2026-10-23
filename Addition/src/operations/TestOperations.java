package operations;

import java.util.Scanner;

public class TestOperations {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a;
		int b;
		
		System.out.println("Ingrese el primer numero: ");
		a = input.nextInt();
		
		System.out.println("Ingrese el segundo numero: ");
		b = input.nextInt();
		
		System.out.println("suma:  "+ Operations.suma(a, b));
		System.out.println("resta:  "+ Operations.resta(a, b));
		System.out.println("producto:  "+ Operations.producto(a, b));
		System.out.println("resto:  "+ Operations.resto(a, b));
		System.out.println("division:  "+ Operations.division(a, b));
		
		
		
		
		
	}

}
