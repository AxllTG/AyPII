package paridad;

import java.util.Scanner;

public class Paridad {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1;
		
		System.out.println("Ingrese un numero:" );
		num1 = input.nextInt();
		
		if(num1 % 2 == 0 ) {
		System.out.println("EL NUMERO INGRESADO ES PAR");
	} 
		if( num1 % 2 == 1) {
		System.out.println("EL NUMERO INGRESADO ES IMPAR");	
		}
	}
}
